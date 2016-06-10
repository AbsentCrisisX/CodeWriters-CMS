/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi;

import java.util.HashMap;
import java.util.Map;
import nl.acxdev.codewriters.cmsapi.commands.*;
import static spark.Spark.*;
import nl.acxdev.codewriters.cmsapi.cors.CorsFilter;
import nl.acxdev.codewriters.cmsapi.factory.CommandFactory;
import nl.acxdev.codewriters.cmsapi.interfaces.Command;

/**
 *
 * @author absentium
 */
public class Main {
    public static void main(String[] args){
        CorsFilter.apply();
        
        CommandFactory commandFactory = new CommandFactory();
        
        get("/serverList", (req,res) -> {
            GetServers getS = new GetServers();
            String data = getS.getData();
            return data; 
        });
        
        // Start or stop a specific container
        post("/start", (req, res) -> {
            Command start = commandFactory.getCommand("start");
            
            Map<String, String> data = new HashMap<>();
            
            data.put("name", req.queryParams("name"));
            data.put("cId", req.queryParams("cId"));
            data.put("cType", req.queryParams("cType"));
            
            String result = start.execute(data);
            
            return result;
        });
        post("/stop", (req, res) -> {
            Command stop = commandFactory.getCommand("stop");
            
            Map<String, String> data = new HashMap<>();
            
            data.put("name", req.queryParams("name"));
            data.put("cId", req.queryParams("cId"));
            data.put("cType", req.queryParams("cType"));
            
            String result = stop.execute(data);
            
            return result;
        });
        
        // Update a specific container
        post("/rename", (req, res) -> {
            Command rename = commandFactory.getCommand("rename");
            
            Map<String, String> data = new HashMap<>();
        
            data.put("name", req.queryParams("name"));
            data.put("cType", req.queryParams("cType"));
            data.put("cId", req.queryParams("cId"));
            data.put("newName", req.queryParams("newName"));
            
            String result = rename.execute(data);
            
            return result;
        });
        get("/move", (req, res) -> {
            Command move = commandFactory.getCommand("move");
            
            Map<String,String> data = new HashMap<>();
        
            data.put("name", req.queryParams("name"));
            data.put("cId", req.queryParams("cId"));
            data.put("cType", req.queryParams("cType"));
            data.put("destination", req.queryParams("destination"));
            
            String result = move.execute(data);
            
            return result;
        });
        
        // Remove a specific container
        post("/remove", (req, res) -> {
            Command remove = commandFactory.getCommand("remove");
            
            Map<String, String> data = new HashMap<>();
        
            data.put("name", req.queryParams("name"));
            data.put("cId", req.queryParams("cId"));
            data.put("cType", req.queryParams("cType"));
            
            String result = remove.execute(data);
            
            return result;
        });
        
        // Create a new container on a specific server
        post("/create", (req, res) -> {
            Command create = commandFactory.getCommand("create");
            
            Map<String,String> data = new HashMap<>();
        
            data.put("name", req.queryParams("name"));
            data.put("image", req.queryParams("image"));
            data.put("cType", req.queryParams("cType"));
            data.put("destination", req.queryParams("destination"));
            
            String result = create.execute(data);
            
            return result;
        });
    }
}
