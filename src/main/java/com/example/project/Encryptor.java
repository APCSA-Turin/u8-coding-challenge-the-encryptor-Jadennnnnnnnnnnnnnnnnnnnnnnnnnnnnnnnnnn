package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen == 0) {
            return 1; 
        }
        return (int) Math.ceil((double) messageLen / rows);
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int col = determineColumns(message.length(), rows);
        String[][] arr = new String[rows][col];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0;  j < col; j++) {
                if (count < message.length()) {
                    arr[i][j] = String.valueOf(message.charAt(count));
                } else arr[i][j] = "=";
                count++;
            }
        }
        return arr;
    }

    public static String encryptMessage(String message, int rows){
        String[][] arr = generateEncryptArray(message, rows);
        String string = "";
        for (int i = arr[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                string += arr[j][i];
            }
        }
        return string;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int col = determineColumns(encryptedMessage.length(), rows);
        String[][] arr = new String[rows][col];
        int count = 0;
        for (int i = col - 1; i >= 0; i--) { 
            for (int j = 0; j < rows; j++) {
                if (count < encryptedMessage.length()) {
                    arr[j][i] = String.valueOf(encryptedMessage.charAt(count));
                    count++;
                }
            }
        }

        String string = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != null && !arr[i][j].equals("=")) { 
                    string += arr[i][j];
                }
            }
        }
        return string;
    }
}