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
public class RemoveContainer {
    private String cId;
    private String name;
    private String cType;
    
    public RemoveContainer(String name, String cId, String cType){
        this.cId = cId;
        this.name = name;
        this.cType = cType;
    }
    
    public String removeIt (){
        Map<String, String> removeMap = new HashMap<>();
        
        removeMap.put("name", name);
        removeMap.put("cId", cId);
        removeMap.put("cType", cType);
        
        JsonCreator creator = new JsonCreator(removeMap);
        
        JSONObject createdJson = creator.createJson();
        
        System.out.println(createdJson);
        
        return "The container with id " + cId + " has been removed successfully";
    }
}
