/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dockdocker.monitoring;

import java.util.logging.LogManager;
import java.util.logging.Logger;
import static spark.Spark.*;

/**
 * Main instance for REST API
 * @author Patrick
 */
public class MonitoringApi {

    public static void main(String[] args) {
        RequestHandler handler = new RequestHandler();
        
        // /getcontainerlist returns list of containers with information
        get("/containerslist", (request, response) -> {
            return handler.getContainerList();
        });
        
        get("/searchimage/:name", "application/json", (request, response) -> {
            return handler.searchImage(request.params(":name"));
        });

    }

}
