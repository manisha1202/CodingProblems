package com.home.codingproblems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class CommonUtils {
    private CommonUtils(){

    }
    public static String readInputAsString(String filePath){
        String content = "";
        try {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e) {
        }
        return content;
    }
    public static int[] getIntegerArrayFromString(String listAsString){
        String[] stringArray = listAsString.split(" ");
        int arr[] = new int[stringArray.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(stringArray[i]);
        }
        return arr;
    }
    public static String[] splitStringOnNewLine(String stringToBeSplitted){
        return stringToBeSplitted.split("\n");
    }
    public static String[] splitStringOnSpace(String stringToBeSplitted){
        return stringToBeSplitted.split(" ");
    }
    public static int parseInt(String s){
        return Integer.parseInt(s.trim());
    }
}


