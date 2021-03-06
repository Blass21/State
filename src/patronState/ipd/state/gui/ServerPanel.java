/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronState.ipd.state.gui;

import java.io.OutputStream;
import java.io.PrintStream;
import patronState.ipd.state.Server;
import patronState.ipd.state.states.*;
/**
 *
 * @author Javier Blas
 */
public class ServerPanel extends javax.swing.JPanel {
    
    private Server server;
    private int messageCouter;
    
    public ServerPanel() {
        initComponents();
        
        PrintStream defaultPrinter = System.out;
        PrintStream interceptor = new TextAreaPrinter(defaultPrinter);
        System.setOut(interceptor);
        
        server = new Server();
    }
    
    private class TextAreaPrinter extends PrintStream {
        
        public TextAreaPrinter(OutputStream out) {
            super(out,true);
        }
        
        @Override
        public void print(String line){
            println(line);
        }
        
        @Override
        public void println(String line){
            line = line + "\n";
            super.print(line);
            jTextArea1.append(line);
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("sendMessage");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AbstractServerState state = server.getState();
        if(state instanceof StopServerState){
            jButton1.setText("Stop");
            server.setState(new StartingServerState(server));
        } else {
            if(state instanceof StartingServerState){
                server.setState(new StopServerState(server));
            } else {
                jButton1.setText("Start");
                server.setState(new StopServerState(server));
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        server.handleMessage("Send Message + " + ++messageCouter); 
    }//GEN-LAST:event_jButton2ActionPerformed

    /*private void sendMessageEvent(java.awt.event.ActionEvent evt){
        server.handleMessage("Send Message + " + ++messageCouter); 
    } 
    
    private void startAction(java.awt.event.ActionEvent evt){
        AbstractServerState state = server.getState();
        if(state instanceof StopServerState){
            jButton1.setText("Stop");
            server.setState(new StartingServerState(server));
        } else {
            if(state instanceof StartingServerState){
                server.setState(new StopServerState(server));
            } else {
                jButton1.setText("Start");
                server.setState(new StopServerState(server));
            }
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
