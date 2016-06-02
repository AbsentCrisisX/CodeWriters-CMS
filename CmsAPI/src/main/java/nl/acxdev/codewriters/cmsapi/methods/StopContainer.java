/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.methods;

import java.util.HashMap;
import java.util.Map;
import nl.acxdev.codewriters.cmsapi.json.JsonCreator;
import org.json.simple.JSONObject;

/**
 *
 * @author absentium
 */
public class StopContainer {
    private String cId;
    private String name;
    
    public StopContainer(String cId, String name){
        this.cId = cId;
        this.name = name;
    }
    
    public String stopIt (){
        Map<String, String> stopMap = new HashMap<>();
        
        stopMap.put("name", name);
        stopMap.put("cId", cId);
        
        JsonCreator creator = new JsonCreator(stopMap);
        
        JSONObject createdJson = creator.createJson();
        
        System.out.println(createdJson);
        
        return "The container with id " + cId + " has been stopped successfully";
    }
}
