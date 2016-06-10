/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.interfaces;

import java.util.Map;

/**
 *
 * @author absentium
 */
public interface Command {
    String execute(Map data);
}
