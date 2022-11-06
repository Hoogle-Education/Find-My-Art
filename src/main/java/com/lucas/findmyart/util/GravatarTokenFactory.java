package com.lucas.findmyart.util;

import java.io.*;
import java.security.*;

public class GravatarTokenFactory {
    public static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();

        for (byte b : array) {
            sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
        }

        return sb.toString();
    }
    public static String gravatarHex (String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex (md.digest(message.getBytes("CP1252")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ignored) { }

        return null;
    }

    // testing gravatar API
    public static void main(String[] args) {

        String email = "test@gmail.com";
        System.out.println( "MD5HEX = " + gravatarHex(email) );

    }
}
