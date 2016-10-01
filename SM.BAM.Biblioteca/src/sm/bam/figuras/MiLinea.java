/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.figuras;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import static java.lang.Math.abs;

/**
 *
 * Una clase que representa una Linea que extiende de clase abstracta FiguraGeometrica
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see FiguraGeometrica
 */
public class MiLinea extends FiguraGeometrica{
    /**
     * constructor por defecto
     */
    public MiLinea(){
        super();
    }
    /**
     * constructor con parametros
     * @param p1 punto inicial 
     * @param p2 punto final
     */
    public MiLinea(Point p1,Point p2){
        super(new Line2D.Double(p1.x,p1.y,p2.x,p2.y));
        setPuntoInicial(p1);
        setPuntoFinal(p2);
    }
    
    /**
     * metodo selector
     * @return MiLinea
     */
    public MiLinea  getMiLinea(){
        return (MiLinea)getFigura();
    }
    
    /**
     * metodo modificador
     * @param p1  nuevo punto inicial
     * @param p2  nuevo punto final
     */ 
    public void setMiLinea(Point p1,Point p2){
        setFigura(new Line2D.Double(p1.x,p1.y,p2.x,p2.y));
        setPuntoInicial(p1);
        setPuntoFinal(p2);
    }
    
    /**
     * metodo que comprueba que un punto dado esta cerca de la linea (distancia<=5.0)
     * @param p punto con el que se compara
     * @return true si esta cerca de la linea ,false en caso contrario
     */
    public boolean isNear(Point2D p){ 
        return ((Line2D.Double)getFigura()).ptLineDist(p)<=5.0;
    }
    
    /**
     * metodo que comprueba que la linea contiene un punto
     * @param p punto 
     * @return true si lo contine,false en caso contrario
     * @ see #isNear(Point2D p)
     */
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }
    
    /**
     * medodo que translada una linea
     * @param p punto al que se translada
     */
    @Override
    public void setLocation(Point2D p) {
        int deltax=(int) ((p.getX()-getPuntoInicial().x));
        int deltay=(int) ((p.getY()-getPuntoInicial().y));
        Point2D tmp=new Point(getPuntoEsquinaFigura().x+deltax,getPuntoEsquinaFigura().y+deltay);
      
        double dx=(tmp.getX()-((Line2D.Double)getFigura()).getX1());
        double dy=(tmp.getY()-((Line2D.Double)getFigura()).getY1());
        
        Point2D newp2=new Point2D.Double(abs(((Line2D.Double)getFigura()).getX2()+dx),abs(((Line2D.Double)getFigura()).getY2()+dy));
        ((Line2D.Double)getFigura()).setLine(tmp,newp2);
        
    }

    /**
     * metodo que pinta una linea
     * @param g2d  contexto en el que se pinta
     */
    @Override
    public void pintar(Graphics2D g2d) {
        g2d.setStroke(getTrazo());
        if(getColor()!=null)
            g2d.setColor(getColor());
        if(getRenderizacion()!=null)
            g2d.addRenderingHints(getRenderizacion());
        
        
        g2d.draw(getFigura());
        
    }

    /**
     * redimensiona la lina
     * @param pfinal punto al que se va a redimensionar
     */
    @Override
    public void setDimensionFigura( Point pfinal) {
        try{
            Line2D.Double l=(Line2D.Double)getFigura();
            if(l!=null){
                l.setLine(getPuntoInicial(), pfinal);
                setPuntoFinal(pfinal);
                setFigura(l);
            }else{
                System.out.println("linea null en setDimensionFigura");
            }
        }catch(Exception e){
                System.out.println("error en redimensionar linea");
        }
    }
    
    
}
