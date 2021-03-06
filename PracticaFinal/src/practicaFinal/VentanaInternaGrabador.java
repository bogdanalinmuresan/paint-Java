/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaFinal;

import java.io.File;
import sm.sound.*;

/**
 * clase para grabar sonido
 * @author Bogdan Alin Muresan
 * @version 1.0
 * 
 */
public class VentanaInternaGrabador extends javax.swing.JInternalFrame {
    SMRecorder grabador=null;
    
    
    public VentanaInternaGrabador(File f) {
        initComponents();
        grabador=new SMSoundRecorder(f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesGrabador = new javax.swing.ButtonGroup();
        contenedorBotonesGrabador = new javax.swing.JPanel();
        botonGrabar = new javax.swing.JToggleButton();
        botonStopGrabacion = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        grupoBotonesGrabador.add(botonGrabar);
        botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/RecordPressed_48x48.png"))); // NOI18N
        botonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGrabarActionPerformed(evt);
            }
        });
        contenedorBotonesGrabador.add(botonGrabar);

        grupoBotonesGrabador.add(botonStopGrabacion);
        botonStopGrabacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/StopDisabled_48x48.png"))); // NOI18N
        botonStopGrabacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonStopGrabacionActionPerformed(evt);
            }
        });
        contenedorBotonesGrabador.add(botonStopGrabacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contenedorBotonesGrabador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contenedorBotonesGrabador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGrabarActionPerformed
        // TODO add your handling code here:
        if(grabador!=null){
            grabador.record();
        }
    }//GEN-LAST:event_botonGrabarActionPerformed

    private void botonStopGrabacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonStopGrabacionActionPerformed
        // TODO add your handling code here:
        if(grabador!=null){
            grabador.stop();
        }
    }//GEN-LAST:event_botonStopGrabacionActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        if(grabador!=null){
            grabador.stop();
        }
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonGrabar;
    private javax.swing.JToggleButton botonStopGrabacion;
    private javax.swing.JPanel contenedorBotonesGrabador;
    private javax.swing.ButtonGroup grupoBotonesGrabador;
    // End of variables declaration//GEN-END:variables
}
