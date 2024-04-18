package com.example.remitlytask;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonSolution {

    public static void main(String[] args){
        String filePath = args[0];
        boolean result = verifyInputJson(filePath);
        System.out.println("Verification result: " + result);
    }
    public static boolean verifyInputJson(String absolutePath){
        try{
            String parsedData = new String(Files.readAllBytes(Paths.get(absolutePath)));

            JSONObject policyData = new JSONObject(parsedData);

            JSONArray statements = policyData.getJSONObject("PolicyDocument").getJSONArray("Statement");
            for(int i = 0; i < statements.length(); i++){
                JSONObject statement = statements.getJSONObject(i);
                if(statement.has("Resource") && statement.getString("Resource").equals("*")){
                    return false;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
