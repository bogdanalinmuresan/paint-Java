/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;
import sm.image.BufferedImageSampleIterator;

/**
 *
 * @author bogdan
 */
public class OperPropia extends BufferedImageOpAdapter{

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
 /*       if (dest == null) {
        dest = createCompatibleDestImage(src, null); }
        WritableRaster destRaster = dest.getRaster();
        float mixColorComp[] = mixColor.getColorComponents(null);
        for (BufferedImageSampleIterator it = new BufferedImageSampleIterator(src); it.hasNext();) { BufferedImageSampleIterator.SampleData sample = it.next();
        int colorBand= 255 * mixColorComp[sample.band];
        sample.value = (int) (sample.value * (1.0f - mixValue) + colorBand * mixValue); destRaster.setSample(sample.col, sample.row, sample.band, sample.value);
         
        }
         */
        return dest; 


    }
    
}
