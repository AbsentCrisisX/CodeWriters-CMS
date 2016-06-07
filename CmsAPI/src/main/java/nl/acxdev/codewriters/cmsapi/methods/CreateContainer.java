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
public class CreateContainer {
    private String port;
    private String image;
    private String name;
    private String cType;
    private String destination;
    
    public CreateContainer(String name, String port, String cType, String destination, String image){
        this.name = name;
        this.port = port;
        this.cType = cType;
        this.destination = destination;
        this.image = image;
    }
    
    public String createIt(){
        Map<String,String> createMap = new HashMap<>();
        
        createMap.put("name", name);
        createMap.put("port", port);
        createMap.put("image", image);
        createMap.put("cType", cType);
        createMap.put("destination", destination);
        
        JsonCreator creator = new JsonCreator(createMap);
        
        JSONObject receivedJson = creator.createJson();
        
        System.out.println(receivedJson);
        
        return "The new container has been created succesfully";
    }
}
