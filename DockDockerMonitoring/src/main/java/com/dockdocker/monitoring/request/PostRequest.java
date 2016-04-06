/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dockdocker.monitoring.request;

import com.dockdocker.monitoring.logging.LogHandler;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick
 */
public abstract class PostRequest extends Request {
    
    protected byte[] body;
    protected int bodyLength;
    
    /**
     * Constructor
     * 
     * @param domain: domain to send request to
     * @param url: url / action 
     */
    public PostRequest(String domain, String url) {
        super(domain, url);
    }
    
    protected void setRequestBody(String message) {
        this.body = message.getBytes();
        bodyLength = body.length;
    }

    @Override
    public void execute() {
        HttpURLConnection con = null;
        try {            
            // Set up url request
            URL urlObj = new URL(domain+url);
            con = (HttpURLConnection) urlObj.openConnection();

            // Prepare request
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            //con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
            //con.setRequestProperty("charset", "utf-8");
            //con.setRequestProperty("Content-Length", Integer.toString(bodyLength));
            // Write body
            try( DataOutputStream wr = new DataOutputStream( con.getOutputStream())) {
                wr.write(body);
            }
            
            // Get response code
            int responseCode = con.getResponseCode();
            
            // If status OK
            if(responseCode == 200) {
                 // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer responseReader = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseReader.append(inputLine);
                }
                in.close();
                
                // Set response
                response = responseReader.toString();
            } else if(responseCode == 404) {
                response = "Error 404: docker remote api not found";
                LogHandler.submitLogEntry(this.getClass().getName() + "Error 404: docker remote api not found");
            } else {
                response = "Unable to send request to docker remote Api";
                LogHandler.submitLogEntry("Unable to send request to docker remote Api");
            }
        } catch (MalformedURLException ex) {
            LogHandler.submitLogEntry(this.getClass().getName() + ex.getMessage() + ex.getStackTrace().toString());
        } catch (IOException ex) {
            LogHandler.submitLogEntry(this.getClass().getName() + ex.getMessage() + ex.getStackTrace().toString());
        } finally {
            body = null;
            con.disconnect();
        }
    }
}
