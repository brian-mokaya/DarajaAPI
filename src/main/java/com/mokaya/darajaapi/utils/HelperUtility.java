package com.mokaya.darajaapi.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

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
}
