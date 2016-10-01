/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package sm.bam.imagen;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.*;

/**
 * clase que realiza una operacion de umbralizacion
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see BufferedImageOpAdapter
 */
public class UmbralizacionOp extends BufferedImageOpAdapter{ private int umbral;
       
    public UmbralizacionOp(int umbral) {
         this.umbral = umbral;
       }

       @Override
       public BufferedImage filter(BufferedImage src, BufferedImage dest)
       {
           if(src!=null){
            //Código de umbralización
               if (dest == null) 
               {
                   dest = createCompatibleDestImage(src, null);
               }
               WritableRaster srcRaster = src.getRaster(); 
               WritableRaster destRaster = dest.getRaster();
               //BufferedImagePixelIterator.PixelData pixel_dest =null;
              for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();)
              {
                   BufferedImagePixelIterator.PixelData pixel = it.next();
                   
                   if((pixel.sample[0]+pixel.sample[1]+pixel.sample[2])/3 <umbral){
                       pixel.sample[0]=0;
                       pixel.sample[1]=0;
                       pixel.sample[2]=0;
                   }else{
                       pixel.sample[0]=255;
                       pixel.sample[1]=255;
                       pixel.sample[2]=255;
                       
                   }
                   destRaster.setPixel(pixel.col, pixel.row,pixel.sample);
                    
               }
           }
        return dest;
       }
}//UmbralizacionOp
 
 
