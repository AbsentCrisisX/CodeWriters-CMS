
package com.dockdocker.monitoring.logging;

import com.dockdocker.monitoring.request.PostRequest;
import com.dockdocker.monitoring.resources.Configuration;

/**
 * Handler logging entry requests
 * 
 * @author Patrick
 */
public class PostLogEntryRequest extends PostRequest {
    
    /**
     * Constructor
     *  Inits the state
     *  Sets the message
     *  Executes the request
     * @param message, log entry
     */
    public PostLogEntryRequest(String message) {
        super(Configuration.logApiDomain, "/log/MonitoringApi");
        
        setRequestBody(message);
    }
    
    
}
