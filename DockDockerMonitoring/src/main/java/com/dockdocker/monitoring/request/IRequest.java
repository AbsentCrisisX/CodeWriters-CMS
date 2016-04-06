/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dockdocker.monitoring.request;

/**
 * Request interface
 * 
 * @author Patrick
 */
public interface IRequest {
    
     /**
     * 1. Sends the request
     * 2. Reads results
     * 3. Closes connection
     */
    public abstract void execute();
    
}
