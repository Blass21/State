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
public class SaturatedServerState extends AbstractServerState{
    
    private Thread monitoringThread;
    
    public SaturatedServerState(final Server server){
        server.getMessageProcess().start(); 
        monitoringThread = new Thread(new Runnable() {
            
            @Override
            public void run(){
                try{
                    while(true){
                            if(server.getMessageProcess().countMessage()<server.getMaxRequest()){
                                server.setState(new StartServerState(server));
                                break;
                            }
                    }
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        monitoringThread.start();
    }
    
    @Override
    public void handleMessage(Server server, String message) {
        System.out.println("Cann't process request, Server Saturated");
    }
}

