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
public class StartServerState extends AbstractServerState{

    public StartServerState(Server server){
        server.getMessageProcess().start();
    } 

    @Override
    public void handleMessage(Server server, String message) {
        boolean isSaturated = server.getMessageProcess().queueMessage(message);
        if(!isSaturated){
            server.setState(new SaturatedServerState(server));
        }
    }
    
}
