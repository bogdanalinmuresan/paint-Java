/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.imagen;
import java.awt.image.BufferedImage;

/**
 *clase que realiza una operacion resta entre imagenes
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see sm.imagen.BinaryOp
 */
public class SumaOp extends sm.image.BinaryOp{
    private float alpha=0.5f;
    public SumaOp(BufferedImage img) {
        super(img);
        this.setAlpha(alpha);
    }

  
    @Override
    public int binaryOp(int i, int i1) {
        
        int rdo = (int)((alpha*i)+((1-alpha)*i1));
        if(rdo<=0) 
            return 0;
        else if(rdo>=255) 
            return 255;
    return rdo;
      
      
    }
    
    public final void setAlpha(float alpha) {
        if (alpha < 0.0f) alpha = 0.0f;
        else if (alpha > 1.0f) alpha = 1.0f; this.alpha = alpha;
    }
    
    public float getAlpha() {
        return alpha; }
}
