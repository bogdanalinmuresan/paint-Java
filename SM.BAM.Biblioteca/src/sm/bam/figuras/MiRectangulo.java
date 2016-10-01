/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.figuras;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 *
 * Una clase que representa un rectangulo que extiende de clase abstracta FiguraGeometrica
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see FiguraGeometrica
 */
public class MiRectangulo extends FiguraGeometrica {
    
    /**
     * constructor por defecto
     */
    public MiRectangulo(){
        super(new Rectangle(0,0,0,0));
    }
    
    /**
     * constructor con parámetros
     * @param p punto inicial necesario para construir un rectangulo
     * @param altura la altura del rectangulo
     * @param anchura  la anchura del rectángulo
     */
    public MiRectangulo(Point p,int altura ,int anchura){
        super(new Rectangle(p.x,p.y,altura ,anchura));
        setPuntoInicial(p);
        setAltura(altura);
        setAnchura(anchura);
        //setPtoEsqIzqAr(p);
         System.out.println("p en mi rectangulo=(" +p.getX() +","+p.getY()+")");
    }
    
    
    /**
     * metodo selector
     * @return MiRectangulo
     */
    public MiRectangulo getMiRectangulo(){
        return (MiRectangulo) getFigura();
    }
    
    /**
     * metodo modificador
     * @param p nuevo punto del rectangulo
     * @param altura nueva altura 
     * @param anchura nueva anchura
     */
    public void setMiRectangulo(Point p,int altura ,int anchura){
        setFigura(new Rectangle(p.x,p.y,altura,anchura));
        setPuntoInicial(p);
        setAltura(altura);
        setAnchura(anchura);
    }
    
    /**
     * método que translada el rectangulo a un punto dado
     * @param p punto al cual se translada el rectangulo
     */
    @Override
    public void setLocation(Point2D p) {
         if(getPuntoEsquinaFigura()!=null){
            //calculamos el desplazamiento
            int deltax=(int) (p.getX()-getPuntoInicial().x);
            int deltay=(int) (p.getY()-getPuntoInicial().y); 
            //Point p2=new Point((int) (p.getX()-deltax), (int) (p.getY()-deltay));
            //setPtoEsqIzqAr(getPuntoEsquinaFigura());
             //System.out.println("getPtoEsqAr  en set location=(" +getPtoEsqIzqAr().getX() +","+getPtoEsqIzqAr().getY());
             //System.out.println("p en set location=(" +p.getX() +","+p.getY()+")");

            // System.out.println("get punto final en set location=(" +getPuntoFinal().getX() +","+getPuntoFinal().getY()+")");
            //Point2D pu=new Point(deltax,deltay);
             //System.out.println("get punto quina figura en set location=(" +getPuntoEsquinaFigura().getX() +","+getPuntoEsquinaFigura().getY()+")");
            
            
            ((Rectangle)getFigura()).setLocation(deltax+getPuntoEsquinaFigura().x, deltay+getPuntoEsquinaFigura().y);
         }
    }
    
    
   
    /**
     * metodo que devuelve la altura del rectangulo
     * @return la altura
     */
    @Override
    public double getAltura(){
        return ((Rectangle)getFigura()).getBounds2D().getHeight();
    }
    
    @Override
    public double getAnchura(){
        return ((Rectangle)getFigura()).getBounds2D().getWidth();
    }
    /**
     * metodo que pinta el rectangulo
     * @param g2d el contexto sobre el que se dibuja el rectangulo
     */
    @Override
    public void pintar(Graphics2D g2d) {
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

    /**
     * metodo que redimensiona la figura
     * @param pfinal punto al que se dimensiona
     */
    @Override
    public void setDimensionFigura(Point pfinal) {
    Rectangle p=(Rectangle)getFigura();
        try{
            p.setFrameFromDiagonal(getPuntoInicial(), pfinal);
            //setPuntoFinal(pfinal);
            setFigura(p);
            setPuntoFinal(pfinal);
        }catch(Exception e){
            System.out.print("error en dimensionar fugura");
        }
    }


    
}
