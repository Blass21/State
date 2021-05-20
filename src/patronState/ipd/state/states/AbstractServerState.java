/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronState.ipd.state.states;

import patronState.ipd.state.Server;

/**
 *
 * @author Javier Blas
 */
public abstract class AbstractServerState {
    public AbstractServerState(){
    }
    /**
     *
     * @param server
     * @param message
     */
    public abstract void handleMessage(Server server, String message);
}
