/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.methods;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Absentium
 */
public class GetServers {
    
    JSONArray data;
    
    public void GetServers() {
        
    }
    
    public String getData(){
        JSONParser parser = new JSONParser();
        
        
        try{
            Object object = parser.parse(new FileReader("/Users/absentium/GitHub Projects/CodeWriters-CMS/CmsAPI/assets/Containers.json"));
            
            JSONObject obj = (JSONObject) object;
            
            data = (JSONArray) obj.get("servers");
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String dataString = data.toJSONString();
        return dataString;
    }
}
