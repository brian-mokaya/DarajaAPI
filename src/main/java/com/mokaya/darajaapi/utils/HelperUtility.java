package com.mokaya.darajaapi.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
//import org.bson.internal.Base64;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.crypto.BadPaddingException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/*
    * This utility class that contains a set of helper methods.
 */
@Slf4j
public class HelperUtility {
    /**
     * Converts a string to Base64 encoding.
     *
     * @param value the string to encode
     * @return the Base64 encoded string
     */
    public static String toBase64(String value) {
        return java.util.Base64.getEncoder().encodeToString(value.getBytes());
    }


    /**
     * Converts an object to its JSON representation.
     *
     * @param object the object to convert
     * @return the JSON string representation of the object
     */
    public static String toJson(Object object) {

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }

    }

    @SneakyThrows
    public static String getSecurityCredentials(String initiatorPassword) {
        String encryptedPassword;

        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            byte[] input = initiatorPassword.getBytes();

            Resource resource = new ClassPathResource("cert.cer");
            InputStream inputStream = resource.getInputStream();

            FileInputStream fin = new FileInputStream(resource.getFile());
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) cf.generateCertificate(fin);
            PublicKey pk = certificate.getPublicKey();
            cipher.init(Cipher.ENCRYPT_MODE, pk);

            byte[] cipherText = cipher.doFinal(input);

            // Convert the resulting encrypted byte array into a string using base64 encoding
            encryptedPassword = Base64.getEncoder().encodeToString(cipherText).trim();
            return encryptedPassword;
        } catch (NoSuchAlgorithmException | CertificateException | InvalidKeyException | NoSuchPaddingException |
                 IllegalBlockSizeException | BadPaddingException | NoSuchProviderException | FileNotFoundException e) {
            log.error("Error generating security credentials ->{}", e.getLocalizedMessage());
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }
}
