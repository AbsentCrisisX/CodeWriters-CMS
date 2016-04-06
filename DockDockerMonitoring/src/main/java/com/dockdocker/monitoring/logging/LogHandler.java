/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dockdocker.monitoring.logging;

/**
 * Handles log requests
 * @author Patrick
 */
public class LogHandler {
    
    /**
     * Submits new log entry
     * @param message, message to log
     * @see PostLogEntryRequest
     */
    public static void submitLogEntry(String message) {
        new PostLogEntryRequest(message).execute();
    }
    
}
