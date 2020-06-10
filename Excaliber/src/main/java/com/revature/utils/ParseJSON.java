package com.revature.utils;

import com.revature.beans.Batch;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

public class ParseJSON {
    private static String json;


    protected static Batch setBatchData(){
        assert json != null;
        return null;
    }


    protected static boolean readDataFromFile(String fileName) {

        ClassLoader classLoader = new ParseJSON().getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        //File is found
        System.out.println("File Found : " + file.exists());

        try {
            json = new String(Files.readAllBytes(file.toPath()));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

