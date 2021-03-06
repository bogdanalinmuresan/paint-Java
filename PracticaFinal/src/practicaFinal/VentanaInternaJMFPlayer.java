/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaFinal;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.media.Manager;
import javax.media.*;

/**
 *clase para reproducir video
 * @author Bogdan Alin Muresan
 * @version 1.0
 */
public class VentanaInternaJMFPlayer extends javax.swing.JInternalFrame {
    private Player player=null;
    /**
     * constructor por defecto
     * @param f 
     */
    private VentanaInternaJMFPlayer(File f) {
        initComponents();
        String sfichero = "file:" + f.getAbsolutePath();
        MediaLocator ml = new MediaLocator(sfichero);
        try {
          player = Manager.createRealizedPlayer(ml);
          Component vc = player.getVisualComponent();
          if(vc!=null)
              conenedorVideo.add(vc, java.awt.BorderLayout.CENTER);
          Component cpc = player.getControlPanelComponent();
          if(cpc!=null)
              conenedorVideo.add(cpc, java.awt.BorderLayout.SOUTH);
          this.pack();
        }catch(IOException | NoPlayerException | CannotRealizeException e) {
          System.err.println("VentanaInternaJMFPlayer: "+e);
          player = null;
        }
    }
    
    public static VentanaInternaJMFPlayer getInstance(File f){
        VentanaInternaJMFPlayer v = new VentanaInternaJMFPlayer(f);
        if(v.player!=null) return v;
        else return null;
    }
    /**
     * metodo para reproducir al archivo 
     * 
     */
     public void play() {
        if (player != null) {
            try {
              player.start();
            } catch (Exception e) {
              System.err.println("VentanaInternaJMFPlayer: "+e);
            }
        }   
     }
     
     /**
      * metodo para hacer para la reproduccion del archivo audio
      */
     public void close (){
         if(player!=null){
             try{
                 player.stop();
             }catch(Exception e){
                 System.err.println("VentanaInternaJMFPlayer : "+e);
             }
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

        conenedorVideo = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        conenedorVideo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conenedorVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conenedorVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conenedorVideo;
    // End of variables declaration//GEN-END:variables
}
