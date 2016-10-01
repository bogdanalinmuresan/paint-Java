/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.imagen;

import java.awt.image.BufferedImage;

/**
 * clase que realiza un operacion binaria de resta
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see sm.image.BinaryOp
 */
public class RestaOp extends sm.image.BinaryOp {

    public RestaOp(BufferedImage img) {
        super(img);
    }

    @Override
    public int binaryOp(int i, int i1) {
        int rdo=i-i1;
        if((rdo)<0)
            return 0;
        else if(rdo>255)
             return 255;
        
        return rdo;
    
    }
    
}
