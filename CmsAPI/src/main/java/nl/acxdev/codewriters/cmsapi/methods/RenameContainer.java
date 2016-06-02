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
public class RenameContainer {
    private String name;
    private String cId;
    private String cType;
    private String newName;
    
    public RenameContainer(String name, String cId, String cType, String newName){
        this.name = name;
        this.cId = cId;
        this.cType = cType;
        this.newName = newName;
    }
    
    public String sendName(){
        Map<String, String> renameMap = new HashMap<>();
        
        renameMap.put("name", name);
        renameMap.put("cType", cType);
        renameMap.put("cId", cId);
        renameMap.put("newName", newName);
        
        JsonCreator creator = new JsonCreator(renameMap);
        
        JSONObject createdJson = creator.createJson();
        
        System.out.println(createdJson);
        
        return "The name has been changed successfully";
    }
}
