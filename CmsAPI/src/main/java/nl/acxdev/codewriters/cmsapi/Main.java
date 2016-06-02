/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi;

import nl.acxdev.codewriters.cmsapi.methods.*;
import static spark.Spark.*;
import nl.acxdev.codewriters.cmsapi.cors.CorsFilter;

/**
 *
 * @author absentium
 */
public class Main {
    public static void main(String[] args){
        CorsFilter.apply();
        
        
        get("/serverList", (req,res) -> {
            GetServers getS = new GetServers();
            String data = getS.getData();
            return data; 
        });
        
        // Start or stop a specific container
        post("/start", (req, res) -> {
            StartContainer start = new StartContainer(req.queryParams("name"), req.queryParams("cId"), req.queryParams("cType"));
            
            String result = start.startIt();
            
            return result;
        });
        post("/stop", (req, res) -> {
            StopContainer stop = new StopContainer(req.queryParams("name"), req.queryParams("cId"), req.queryParams("cType"));
            
            String result = stop.stopIt();
            
            return result;
        });
        
        // Update a specific container
        post("/rename", (req, res) -> {
            RenameContainer rename = new RenameContainer(req.queryParams("name"), req.queryParams("cId"), req.queryParams("cType"), req.queryParams("extra"));
            
            String result = rename.sendName();
            
            return result;
        });
        get("/move/:cId/:cType/:cDestination", (req, res) -> "Move container with id " + req.params("cId") + " of type " + req.params("cType") + " to " + req.params("cDestination"));
        
        // Remove a specific container
        post("/remove", (req, res) -> {
            RemoveContainer remove = new RemoveContainer(req.queryParams("name"), req.queryParams("cId"), req.queryParams("cType"));
            
            String result = remove.removeIt();
            
            return result;
        });
        
        // Create a new container on a specific server
        get("/create/:cDestination/:image/:cName/:port", (req, res) -> "Create a new container on " + req.params("cDestination") + " with the " + req.params("image") + " image, name it " + req.params("cName") + " and use these " + req.params("port") + " port");
    }
}
