package com.mokaya.darajaapi.utils;


/*
    * This utility class that contains a set of helper methods.
 */
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
}
