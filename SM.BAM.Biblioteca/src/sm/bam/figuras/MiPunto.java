/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.figuras;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 *
 * Una clase que representa un punto que extiende de clase abstracta FiguraGeometrica
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see FiguraGeometrica
 */
public class MiPunto extends FiguraGeometrica {
     /**
      * constructor por defecto
      */
     public MiPunto(){
         super(new Rectangle(0,0,0,0));     
     }
     /**
      * constuctor con parametros
      * @param s punto con el que se inicializa la figura punto
      */
     public MiPunto(Point s){
        super(new Rectangle(s.x,s.y,10,10));
        setPuntoInicial(s);
        setAltura(1);
        setAnchura(1);
        setEstaRelleno(true);
     }
     
     /**
      * metodo selector que devuelve MiPunto
      * @return  MiPunto
      */
     public MiPunto getMiPunto(){
         return  (MiPunto)getFigura();
     }
     
     /**
      * metodo modificador
      * @param p nuevo punto 
      * @param altura nueva altura 
      * @param anchura nueva anchura
      */
     public void setMiPunto(Point p,int altura ,int anchura){
         setFigura(new Rectangle(p.x,p.y,altura,anchura));
     }
     
     /**
      * establece el grosor del punto
      * @param t nuevo grosor
      * @see BasicStroke
      */
     
     @Override
     public void setGrosorTrazo(int t){
        Rectangle p=(Rectangle)getFigura();
        try{
           p.setSize(((int)t), (int)t);
           
           //System.out.println("altura punto en setDimention\n"+p.getHeight());
        }catch(Exception e){
            System.out.print("error en redimensionar el punto");
        }
    }
     
    /**
     * translada el punto a otra localizacion
     * @param p punto al que se se translada
     */
    @Override
    public void setLocation(Point2D p) {
        if(getPuntoEsquinaFigura()!=null){
            //calculamos el desplazamiento
            int deltax=(int) (p.getX()-getPuntoInicial().x);
            int deltay=(int) (p.getY()-getPuntoInicial().y);
            ((Rectangle)getFigura()).setLocation(deltax+getPuntoEsquinaFigura().x, deltay+getPuntoEsquinaFigura().y);
        }  
    }

    
    /**
     * metodo para pintar el punto 
     * @param g2d contexto sobre el que se pinta
     * @see Graphics2D
     */
    @Override
    public void pintar(Graphics2D g2d) {
        
        g2d.setStroke(getTrazo());
        if(getHayTransparencia()!=false)
            g2d.setComposite(getComposicion()); 
        //si tiene color
        if(getColor()!=null)
            g2d.setColor(getColor());
        if(getEstaRelleno()==true)
            g2d.fill((Shape) getFigura());
        if(getRenderizacion()!=null)
            g2d.addRenderingHints(getRenderizacion());
    }

    /**
     * redimensionar el tamaño del punto
     * @param p2  posicion a la que se va a redimensionar
     */
    @Override
    public void setDimensionFigura(Point p2) {
    Rectangle p=(Rectangle)getFigura();
         try{
            p.setFrameFromDiagonal(getPuntoInicial(),p2);
             setPuntoFinal(p2);
            //System.out.println("altura punto en setDimention\n"+p.getHeight());
         }catch(Exception e){
             System.out.print("error en redimensionar el punto");
         }
    }
    
    /**
     * redimensionar el punto
     * @param altura altura del punto
     * @param anchura anchura del punto
     */
    public void setDimensionFigura(int altura,int anchura){
    Rectangle p=(Rectangle)getFigura();
        try{
           p.setSize(altura,anchura);
           
           //System.out.println("altura punto en setDimention\n"+p.getHeight());
        }catch(Exception e){
            System.out.print("error en redimensionar el punto");
        }
    }
}
