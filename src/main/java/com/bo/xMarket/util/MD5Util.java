package com.bo.xMarket.util;

import java.security.MessageDigest;

public class MD5Util {
    /***
     32 * MD5 md5 code generating overweight
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    public static String convertMD5(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        return new String(a);

    }

    // main function test
    public static void main(String[] args) {
        String s = "Kodak";
        System.out.println("Original:" + s);
        System.out.println("after MD5:" + string2MD5(s));
        System.out.println("encryption:" + convertMD5(s));
        System.out.println("decrypted:" + convertMD5(convertMD5(s)));
    }


}