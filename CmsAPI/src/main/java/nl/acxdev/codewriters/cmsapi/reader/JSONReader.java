/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.reader;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Absentium
 */
public class JSONReader {
    
    private JSONArray data;
    
    public JSONReader (){
        data = new JSONArray();
    }
    
    public void getData(){
        JSONParser parser = new JSONParser();
        
        try{
            JSONArray object = (JSONArray) parser.parse(new FileReader("/Users/absentium/GitHub Projects/CodeWriters-CMS/CmsAPI/assets/Containers.json"));
            
            for(Object server : object){
                JSONObject s = (JSONObject) server;
                
                System.out.println(server);
                
                String ip = (String) s.get("IPAddress");
                System.out.println(ip);
            }
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
