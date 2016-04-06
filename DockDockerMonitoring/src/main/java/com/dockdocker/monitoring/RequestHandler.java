/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dockdocker.monitoring;

import com.dockdocker.monitoring.logging.LogHandler;
import com.dockdocker.monitoring.request.GetRequest;
import com.dockdocker.monitoring.logging.PostLogEntryRequest;
import com.dockdocker.monitoring.resources.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Patrick
 */
public class RequestHandler {
    
    /**
     * Sends a request to the remote API to retrieve images
     * @param name, search name
     * @return response
     */
    public String searchImage(String name) {
        LogHandler.submitLogEntry("Request to: "+Configuration.remoteApiDomain+"/images/search?term="+name);
        GetRequest req = new GetRequest(Configuration.remoteApiDomain, "/images/search?term="+name);
        req.execute();
        return req.getRespone();
    }
    
    /**
     * Retrieve list of containers with full container information
     * @return list with container information
     */
    public String getContainerList() {        
        // Get base container list
        LogHandler.submitLogEntry("GetContainerList called, retrieving base container list");
        JSONArray containerListBase = getBaseContainerList();
        
        // Prepare stringbuilder
        StringBuilder containerListFull = new StringBuilder();
        
        // Append array start
        containerListFull.append("[");
        
        // For every container in the base list
        LogHandler.submitLogEntry("Retrieving specific container information for every container in base list");
        for (int i = 0; i < containerListBase.length(); i++) {
            // Get container
            JSONObject container = containerListBase.getJSONObject(i);
            
            // Retrieve id
            String id = container.getString("Id");
            
            // Retrieve status
            String status = container.getString("Status");
            
            // Retrieve full data of the specific container
            String containerInfo = retrieveContainerInfo(id);
            
            // Append container info
            containerListFull.append(containerInfo);
            
            // Append status from JSONobject container
            containerListFull.replace(containerListFull.length()-1, containerListFull.length(), ",\"Status\":\""+ status + "\"}");
            
            // If not last
            if(containerListBase.length()-1 != i) {
                // Append comma
                containerListFull.append(",");
            }
        }
        // Close JSON array
        containerListFull.append("]");

        // Return result
        LogHandler.submitLogEntry("Request getContainerList finished, returning result");
        return containerListFull.toString();
    }
    
    /**
     * Retrieve base container list
     * @return JSONArray base container list
     */
    private JSONArray getBaseContainerList() {
        LogHandler.submitLogEntry("Request to: "+Configuration.remoteApiDomain+"/containers/json?all=1&size=1");
        GetRequest req = new GetRequest(Configuration.remoteApiDomain, "/containers/json?all=1&size=1");
        req.execute();
        return new JSONArray(req.getRespone());
    }
    
    /**
     * Retrieves specific container information
     * @param id container id
     * @return String specific container information
     */
    private String retrieveContainerInfo(String id) {
        LogHandler.submitLogEntry("Request to: "+Configuration.remoteApiDomain+"/containers/"+id+"/json");
        GetRequest req = new GetRequest(Configuration.remoteApiDomain, "/containers/"+id+"/json");
        req.execute();
        return req.getRespone();
    }
}
