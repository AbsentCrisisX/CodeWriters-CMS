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
    private String cType;
    
    public StopContainer(String name, String cId, String cType){
        this.cId = cId;
        this.name = name;
        this.cType = cType;
    }
    
    public String stopIt (){
        Map<String, String> stopMap = new HashMap<>();
        
        stopMap.put("name", name);
        stopMap.put("cId", cId);
        stopMap.put("cType", cType);
        
        JsonCreator creator = new JsonCreator(stopMap);
        
        JSONObject createdJson = creator.createJson();
        
        System.out.println(createdJson);
        
        return "The container with id " + cId + " has been stopped successfully";
    }
}
