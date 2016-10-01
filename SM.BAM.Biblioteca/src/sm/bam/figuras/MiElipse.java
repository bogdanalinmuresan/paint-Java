/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.figuras;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * Una clase que representa una Elipse que extiende de clase abstracta FiguraGeometrica
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see FiguraGeometrica
 */
public class MiElipse extends FiguraGeometrica{
   /**
    * constructor por defecto
    */
    public MiElipse(){
        super();
    }
    /**
     * constructor con parametros
     * @param p punto 
     * @param anchura anchura 
     * @param altura altura 
     */
    public MiElipse(Point p,int anchura ,int altura){
        super(new Ellipse2D.Double(p.x,p.y,anchura,altura));
        setPuntoInicial(p);
        setAnchura(anchura);
        setAltura(altura);
        
    }
    
    /**
     * metodo selector
     * @return MiElipse
     */
    public MiElipse getMiElipse(){
        return (MiElipse) getFigura();
    }
    
    /**
     * metodo modificador que modifica la elipse
     * @param p nuevo punto
     * @param anchura nueva anchura
     * @param altura nueva altura
     */
    public void setMiElipse(Point p,int anchura,int altura){
        setFigura(new Ellipse2D.Double(p.x,p.y,anchura,altura));
    }
    /**
     * ,etodo que devuelve la altura de la elipse
     * @return la altura
     */
    @Override
    public double getAltura(){
        return ((Ellipse2D)getFigura()).getBounds2D().getHeight();
    }
    
    @Override
    public double getAnchura(){
        return ((Ellipse2D)getFigura()).getBounds2D().getWidth();
    }
    
    /**
     * metodo que translada la elipse 
     * @param p punto al que se translada
     */
    @Override
    public void setLocation(Point2D p) {
        double altura=((Ellipse2D.Double)getFigura()).getHeight();
        double anchura=((Ellipse2D.Double)getFigura()).getWidth();
        int deltax=(int) (p.getX()-getPuntoInicial().x);
        int deltay=(int) (p.getY()-getPuntoInicial().y);
        ((Ellipse2D.Double)getFigura()).setFrame(deltax+puntoEsquinaFigura.x, deltay+puntoEsquinaFigura.y, anchura,altura);

    }

    /**
     * metodo que pinta la elipse
     * @param g2d  contexto en el que se dibuja
     */
    @Override
    public void pintar(Graphics2D g2d) {
        if(getRenderizacion()!=null)
            g2d.addRenderingHints(getRenderizacion());
        g2d.setStroke(getTrazo());
        if(getHayTransparencia()!=false)
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

    /**
     * metodo que redimensiona una elipse
     * @param pfinal punto al que se redimensiona
     */
    @Override
    public void setDimensionFigura( Point pfinal) {
        Ellipse2D.Double e=(Ellipse2D.Double)getFigura();
        e.setFrameFromDiagonal(getPuntoInicial(), pfinal);
        setFigura(e);
        setPuntoFinal(pfinal);
    }

    
}
