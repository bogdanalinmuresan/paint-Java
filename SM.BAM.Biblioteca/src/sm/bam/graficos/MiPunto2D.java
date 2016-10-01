/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.graficos;

/**
 *clase para diferenciar a un punto
 * @author bogdan
 */
public class MiPunto2D extends java.awt.Rectangle {
   // float anchoLinea;
    float altura;
    float anchura;
    
    public MiPunto2D(int x ,int y ,int w ,int h){
        super(x,y,w,h);
    }
    
    public float getAlturaPunto(){
        return altura;
    }
    
    public float getAnchuraPunto(){
        return anchura;
    }
    
    public void setAlturaPunto(float a){
        altura=a;
    }
    
    public void setAnchuraPunto(float a){
        anchura=a;
    }
    
}
