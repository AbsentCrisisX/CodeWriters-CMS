/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.sender;

import org.json.simple.JSONObject;

/**
 *
 * @author absentium
 */
public class CommandSender {
    JSONObject commandData;
    
    public CommandSender(JSONObject json){
        this.commandData = json;
    }
    
    public int sendData(){
        int result = 0;
        if(commandData != null){
            result = 1;
        } else {
            result = 0;
        }
        
        return result;
    }
}
