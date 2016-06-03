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
public class MoveContainer {
    private String cId;
    private String name;
    private String cType;
    private String destination;
    
    public MoveContainer(String name, String cId, String cType, String destination){
        this.name = name;
        this.cId = cId;
        this.cType = cType;
        this.destination = destination;
    }
    
    public String moveIt(){
        Map<String,String> moveMap = new HashMap<>();
        
        moveMap.put("name", name);
        moveMap.put("cId", cId);
        moveMap.put("cType", cType);
        moveMap.put("destination", destination);
        
        JsonCreator creator = new JsonCreator(moveMap);
        
        JSONObject receivedJson = creator.createJson();
        
        System.out.println(receivedJson);
        
        return "The container with id " + cId + " has been moved to " + destination + " successfully";
    }
}
