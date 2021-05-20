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
public class StopServerState extends AbstractServerState {

    public StopServerState(Server server){
        server.getMessageProcess().stop();
    }
    
    @Override
    public void handleMessage(Server server, String message) {
           System.out.println("The server is stopped");
    }
    
}
