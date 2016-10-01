/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.figuras;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author bogdan
 */


public class MiRectanguloRedondeado extends FiguraGeometrica {
    // RADIO  DE LAS ESQUINAS DEL RECTANGULO 
    //static int ARCW=30;
    //static int ARCH=30;
    
    /**
     * constructor por defecto
     */
    public MiRectanguloRedondeado(){
        super(new RoundRectangle2D.Double());
    }
    
    /**
     * constructor con parámetros
     * @param p punto inicial necesario para construir un rectangulo
     * @param altura la altura del rectangulo
     * @param anchura  la anchura del rectángulo
     * @param ah al altura del arco de las esquinas del rectangulo
     * @param aw la anchura del arco de las esquinas del rectangulo
 
     */
    public MiRectanguloRedondeado(Point p,int altura ,int anchura,int ah,int aw){
        super(new RoundRectangle2D.Double(p.x,p.y,altura ,anchura,aw,ah));
        setPuntoInicial(p);
        setAltura(altura);
        setAnchura(anchura);
    }
    
    /**
     * metodo que devuelve la altura del rectangulo redondeado
     * @return la altura
     */
    @Override
    public double getAltura(){
        return ((RoundRectangle2D)getFigura()).getBounds2D().getHeight();
    }
    
    /**
     * metodo que devuelve la anchura del rectangulo redondeado
     * @return la anchura
     */
    @Override
    public double getAnchura(){
        return ((RoundRectangle2D)getFigura()).getBounds2D().getWidth();
    }
    
    /**
     * metodo selector
     * @return MiRectanguloRedondeado
     */
    public MiRectanguloRedondeado getMiRectanguloRedondeado(){
        return (MiRectanguloRedondeado) getFigura();
    }
   /* 
    public void setMiRectanguloRegondeado(int ah,int aw){
        //MiRectanguloRedondeado.setArch(ah);
        //MiRectanguloRedondeado.setArcw(aw);
        //getMiRectanguloRedondeado().setRoundRect(new RoundRectangle2D.Double(aw, aw, aw, ah, aw, ah));
        setFigura(new RoundRectangle2D.Double(getPuntoFinal().x,getPuntoInicial().y, getAltura(), getAnchura(), ah, aw));
        //setFiguraS(null);
    }
*/
    

    @Override
    public void setDimensionFigura(Point pfinal) {
        RoundRectangle2D.Double p=(RoundRectangle2D.Double)getFigura();
            try{
            p.setFrameFromDiagonal(getPuntoInicial(), pfinal);
            //setPuntoFinal(pfinal);
            setFigura(p);
            setPuntoFinal(pfinal);
        }catch(Exception e){
            System.out.print("error en dimensionar round rectangle");
        }
    }
        

    @Override
    public void setLocation(Point2D p) 
    {
        if(getPuntoEsquinaFigura()!=null)
        {
            double altura=((RoundRectangle2D.Double)getFigura()).getHeight();
            double anchura=((RoundRectangle2D.Double)getFigura()).getWidth();
            //calculamos el desplazamiento
            int deltax=(int) (p.getX()-getPuntoInicial().x);
            int deltay=(int) (p.getY()-getPuntoInicial().y); 
            //Point delta=new Point(deltax,deltay);
            //Point puntoEsqCal=new Point(deltax+getPuntoEsquinaFigura().x,deltay+getPuntoEsquinaFigura().y);
            //((RoundRectangle2D.Double)getFigura()).setFrameFromDiagonal(deltax+getPuntoEsquinaFigura().x, deltay+getPuntoEsquinaFigura().y);
            //((RoundRectangle2D.Double)getFigura()).setFrame( ((RoundRectangle2D.Double)getFigura()).getPuntoFinal(),delta+getPuntoEsquinaFigura());
            ((RoundRectangle2D.Double)getFigura()).setFrame(deltax+puntoEsquinaFigura.x, deltay+puntoEsquinaFigura.y, anchura,altura);

        }
    }

    @Override
    public void pintar(Graphics2D g2d) 
    {
        //getFigura().
        ///System.out.println("rectangulo transparencia es "+getHayTransparencia());
        //si tiene color
        if(getRenderizacion()!=null) 
            g2d.addRenderingHints(getRenderizacion());
        
        g2d.setStroke(getTrazo());
        
        if(getHayTransparencia()==true)
            g2d.setComposite(getComposicion()); 
        
        if(getColor()!=null)
            g2d.setColor(getColor());
        if(getEstaRelleno()==true){
            g2d.setColor(getColor());
            if(getDegradadoFigura()!=null){
                g2d.setPaint(getDegradadoFigura());
            }
            g2d.fill((Shape) getFigura());
        }
        else{
            g2d.draw((Shape)getFigura());
        }
    }
}
