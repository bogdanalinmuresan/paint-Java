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
import java.awt.geom.QuadCurve2D;
import static java.lang.Math.abs;

/**
 *
 * Una clase que representa una una linea curva que extiende de clase abstracta FiguraGeometrica
 * @author Bogdan Alin Muresan
 * @version 1.0
 * @see FiguraGeometrica
 */
public class MiLineaCurva extends FiguraGeometrica {
    public static double ctrlx=-1;
    public static double ctrly=-1;
    
     /**
     * constructor por defecto
     */
    public MiLineaCurva(){
        super();
    }
    
        /**
     * constructor con parametros
     * @param p1 punto inicial 
     * @param control 
     * @param p2 punto final
     */
    public MiLineaCurva(Point p1,Point control,Point p2){
        //QuadCurve2D.Double(double x1, double y1, double ctrlx, double ctrly, double x2, double y2)
        super(new QuadCurve2D.Double(p1.x,p1.y,control.x,control.y,p2.x,p2.y));
        setPuntoInicial(p1);
        setPuntoFinal(p2);
        //setCtrlx(control.x);
        //setCtrly(control.y);
    }
    
  
    public double getCtrlx(){
        return ctrlx;
    }
    
    public  void setCtrlx(double n){
        ctrlx=n;
    }
    
    public double getCtrly(){
        return ctrly;
    }
    
    public void setCtrly(double n){
        ctrly=n;
    }
    
    /**
     * metodo que ajusta el punto de control
     * @param ctrlx la coordenada x del punto de control
     * @param ctrly la coordenada y del punto de control
     * 
     */
    public void setFiguraMiLineaCurva(double ctrlx,double ctrly){
        QuadCurve2D.Double l=(QuadCurve2D.Double)getFigura();
        if(l!=null){
               setCtrlx(ctrlx);
               setCtrly(ctrly);
                l.setCurve(getPuntoInicial().x,getPuntoInicial().y,ctrlx,ctrly, getPuntoFinal().x,getPuntoFinal().y);
                //setPuntoFinal(pfinal);
                setFigura(l);
        }
        else{
            System.err.println("error en setFiguraMiLineaCurva");
        }
    }
   
    @Override
    public void setDimensionFigura(Point pfinal) {
        //setCurve()
        try{
            QuadCurve2D.Double l=(QuadCurve2D.Double)getFigura();
            if(l!=null){
                l.setCurve(getPuntoInicial().x,getPuntoInicial().y,getCtrlx(),getCtrly(), getPuntoFinal().x,getPuntoFinal().y);
                setPuntoFinal(pfinal);
                setFigura(l);
            }else{
                System.out.println("linea curva  null en setDimensionFigura");
            }
        }catch(Exception e){
                System.out.println("error en redimensionar linea");
        }
    }

    @Override
    public void setLocation(Point2D p) {
        int deltax=(int) ((p.getX()-getPuntoInicial().x));
        int deltay=(int) ((p.getY()-getPuntoInicial().y));
        Point2D tmp=new Point(getPuntoEsquinaFigura().x+deltax,getPuntoEsquinaFigura().y+deltay);
      
        double dx=(tmp.getX()-((QuadCurve2D.Double)getFigura()).getX1());
        double dy=(tmp.getY()-((QuadCurve2D.Double)getFigura()).getY1());
        
        Point2D newp2=new Point2D.Double(abs(((QuadCurve2D.Double)getFigura()).getX2()+dx),abs(((QuadCurve2D.Double)getFigura()).getY2()+dy));
        ((QuadCurve2D.Double)getFigura()).setCurve(tmp,new Point2D.Double(getCtrlx(),getCtrly()),newp2);
    }

    @Override
    public void pintar(Graphics2D g2d) {
        if(getRenderizacion()!=null)
            g2d.addRenderingHints(getRenderizacion());
        g2d.setStroke(getTrazo());
        if(getHayTransparencia()!=false)
            g2d.setComposite(getComposicion()); 
        if(getColor()!=null)
            g2d.setColor(getColor());
        if(getEstaRelleno()==true)
            g2d.fill((Shape)getFigura());
        else{
            g2d.draw((Shape)getFigura());
        }
    
        /*
        g2d.setStroke(getGrosorTrazo());
        if(getColor()!=null)
            g2d.setColor(getColor());
        if(getRenderizacion()!=null)
            g2d.addRenderingHints(getRenderizacion());
        
        
        g2d.draw(getFigura());
                */
    }
}
