/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.bam.figuras;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Clase abstracta que representa una figura geometrica
 * @author Bogdan Alin Muresan
 * @version 1.0
 */
public abstract class FiguraGeometrica{
    //atributos
    /***************************************************************************/
    //representacion interna de la figura
    private Shape figura;
    
    private Color color;
    private BasicStroke trazo;
    //tipo de relleno
    private boolean estaRelleno;
    private GradientPaint degradado;
    //renderizacion
    private RenderingHints renderizacion;
    //transparencia
    private Composite transparencia;
    private boolean editar;
    
    private Point pInicial,pFinal;
    //variable para setLocation
    Point puntoEsquinaFigura;
    private boolean hayTransparencia=false;
    private Point2D ptoEsqIzqAr,ptoEsqDchaAbajo;
    private int tipoGradiente;
    private int tipoTrazo;
    private int grosorTrazo;
    //tipo de gradiente
    public enum tipoDegradado{
        HORIZONTAL,VERTICAL
    }
    
   
    
    private int altura=0;
    private int anchura=0;
    
    //constructores
    
   /**
    * constructor por defecto
    */
    public FiguraGeometrica(){
       // this.transparencia = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        figura=null;
        color=Color.BLACK;
        trazo=new BasicStroke(1);
        estaRelleno=false;
        degradado=null;
       /* renderizacion=new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);*/
        renderizacion=null;
        pInicial=null;
        pFinal=null;
        puntoEsquinaFigura=null;
        editar=false;
        hayTransparencia=false;
        ptoEsqIzqAr=new Point(0,0);
        ptoEsqDchaAbajo=null;
        tipoGradiente=-1;
    }
    /**
     * constructor con parametro
     * @param s figura
     * @see Shape
     */
     public FiguraGeometrica(Shape s){
        this.transparencia = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        figura=s;
        color=Color.BLACK;
        trazo=new BasicStroke(1);
        estaRelleno=false;
        degradado=null;
        /*renderizacion=new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);*/
        renderizacion=null;
       
        pInicial=null;
        pFinal=null;
        puntoEsquinaFigura=null;
        editar=false;
        ptoEsqIzqAr=new Point(0,0);
        ptoEsqDchaAbajo=null;
        
    }
    /***************************************************************************/
    //metodos selectores
     
    /**
     * @return 
     */
    public Point2D getPtoEsqIzqAr (){
        return ptoEsqIzqAr;
    }
    
    /**
     * @return 
     */
    public Point2D getPtoEsqDchaAbajo (){
        return ptoEsqDchaAbajo;
    }
     /**
     * devuelve los limites de la figura 
     * @return rectangulo que representa los limites
     */
    public Rectangle2D getBounds2D(){
        return figura.getBounds2D();
    }
    
    /**
     * devuelve al anchura de la figura
     * @return anchura
     */
    public double getAnchura(){
         return anchura;
     }
    /**
     * devuelve la altura
     * @return altura 
     */
    public double getAltura(){
        return altura ;
    }
   
    /**
     * metodo que especifica si la figura esta en modo edicion
     * @return true si se esta editando ,false en caso contrario
     */
    public boolean getEditar(){
        return editar;
    }
    
    /**
     * devuelve la figura
     * @return  figura
     */
    public Shape getFigura(){
        return figura;
    }
    
    /**
     * devuelve el color de la figura
     * @return color
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * devuelve el grosor del trazo de la figura
     * @return trazo 
     * @see BasicStroke
     */
    public int getGrosorTrazo(){
        return grosorTrazo;
    }
    
    /**
     * devuelve si la figura esta rellena
     * @return  true si lo esta ,false en caso contrario
     */
    public boolean getEstaRelleno(){
        return estaRelleno;
    }
    
    /**
     * devuelve el degradado de la figura 
     * @return degradado
     * @see GradientPaint
     */
    public GradientPaint getDegradado(){
        return degradado;
    }
    
    /**
     * devuelve la renderizacion de la figura
     * @return renderizacion
     * @see RenderingHints
     */
    public RenderingHints getRenderizacion(){
        return renderizacion;
    }
    
    /**
     * devuelve la transparencia
     * @return  transparencia
     * @see Composite
     */
    public Composite getComposicion(){
        return transparencia;
    }
    /**
     * devuelve la transparencia 
     * @param c el grado de transparencia
     * @return Composite
     */
    public Composite setComposicion(float c){
        
        return transparencia= AlphaComposite.getInstance(AlphaComposite.SRC_OVER, c);
        
    }
    
    /**
     * devuelve el punto inicial de la figura
     * @return pInicial
     * @see Point
     */
    public Point getPuntoInicial(){
        return pInicial;
    }
    
    /**
     * devuelve el punto final de la figura
     * @return pFinal
     * @see Point
     */
     public Point getPuntoFinal(){
        return pFinal;
    }
    
     /**
      * devuelve el punt ode la esquina de la figura
      * @return puntoEsquinaFigura
      * @see Point
      */
    public Point getPuntoEsquinaFigura(){
      return puntoEsquinaFigura;
    }
    
    /**
     * devuelve so tiene transparencia la figura
     * @return  true si la tiene ,false en caso contrario
     */
    public boolean getHayTransparencia(){
        return hayTransparencia;
    }
    

    //*************************************************************************/
    //metodos moddificadores
    //*************************************************************************/
  
      /**
     * @param p 
     */
    public void setPtoEsqIzqAr (Point2D p){
         ptoEsqIzqAr=p;
    }
    
     public GradientPaint getDegradadoFigura(){
        Point2D f1 = null ;
        Point2D f2=null;
        GradientPaint gradiente=null;
        //setPtoEsqIzqAr(getPuntoEsquinaFigura());
        if(getTipoGradiente()==1){//vertical
            try{
                f1 = new Point((int) getPtoEsqIzqAr().getX(),(int)getPtoEsqIzqAr().getY());
                int dex=(int) getPtoEsqIzqAr().getX()+(int)getAnchura();
                int dey=(int)getPtoEsqIzqAr().getY()+(int)getAltura();
                f2 = new Point(dex, dey);

                gradiente=new GradientPaint(f1, getColor() ,f2, Color.WHITE);
                 //gradiente=new GradientPaint(vi.getLienzo().getFiguraSeleccionada().getPuntoEsquinaFigura(),vi.getLienzo().getFiguraSeleccionada().getColor() ,vi.getLienzo().getFiguraSeleccionada().getPuntoFinal(), Color.WHITE);
            }catch (Exception e){
                System.err.print("Error en getDegradadoFigura"+e);
            }  
        }
        if(getTipoGradiente()==2){//horizontal
            f1 = new Point((int) getPtoEsqIzqAr().getX(),(int)getPtoEsqIzqAr().getY()+(int)getAltura()/2);
            int dex=(int) getPtoEsqIzqAr().getX()+(int)getAnchura();
            int dey=(int)getPtoEsqIzqAr().getY()+(int)getAltura()/2;
            f2 = new Point(dex, dey);
            
            gradiente=new GradientPaint(f1, getColor() ,f2, Color.WHITE);
        }
        
        if(getTipoGradiente()==3){//vertical
            f1 = new Point((int) getPtoEsqIzqAr().getX()+(int)getAnchura()/2,(int)getPtoEsqIzqAr().getY());
            int dex=(int) getPtoEsqIzqAr().getX()+(int)getAnchura()/2;
            int dey=(int)getPtoEsqIzqAr().getY()+(int)getAltura();
            f2 = new Point(dex, dey);
            
            gradiente=new GradientPaint(f1, getColor() ,f2, Color.WHITE);
        }
        if(getTipoGradiente()==0){//ninguno
            gradiente=null;
        }
        return gradiente;
        //setDegradado(gradiente); 
    }
    
    
     /**
     * @param p 
     */
    public void setPtoEsqDchaAbajo (Point2D p){
         ptoEsqDchaAbajo=p;
    }
    /**
     * modifica la anchura de al figura
     * @param a nueva anchura
     */
    public void setAnchura(int a ){
        anchura=a;
    }
    /**
     * modifica la altura 
     * @param a nueva altura
     */
    public void setAltura(int a){
        altura=a;
    }
    
    /**
     * modifica el estado de edicion de la figura
     * @param e true si esta editando ,false en caso contrario
     */
    public void setEditar(boolean e){
        editar=e;
    }
    
    /**
     * modifica la figura
     * @param s nueva figura
     */
    public void setFigura(Shape s){
         figura=s;
         
    }
    /**
     * modifica el color de la figura 
     * @param c nuevo color
     */
    public void setColor(Color c){
        color=c;
    }
    
    /**
     * modifica el grosor
     * @param t nuevo grosor
     */
    public void setGrosorTrazo(int t){
        grosorTrazo=t;
    }
    /**
     * modifica el grosor al por defecto
     */
    public void setGrosorTrazo(){
        trazo=new BasicStroke(1);
    }
    
    public void setTipoTrazo(int i){
        tipoTrazo=i;
        
        //return trazo;
    }
    public BasicStroke getTrazo(){
        if(tipoTrazo==1){//continuo
            trazo=new BasicStroke(getGrosorTrazo());
        }
        if(tipoTrazo==2){//punteado
            trazo=new BasicStroke(getGrosorTrazo(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1f,new float[] {10, 10, 10, 10},2);
        }
        if(tipoTrazo==3){//discontinuo
            trazo=new BasicStroke(getGrosorTrazo(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1f,new float[] {25, 20, 25, 20},2);
        }
        
        return trazo;
    }
    
    /**
     * modifica el estado de relleno
     * @param b nuevo estado
     */
    public void setEstaRelleno(boolean b){
        estaRelleno=b;
    }
    
    /**
     * modifica el degradado de la figura
     * @param g nuevo degradado
     */
    public void setDegradado(GradientPaint g){
        degradado=g;
    }
    public void setTipoGradiente(int i){
        tipoGradiente=i;
    }
    public int getTipoGradiente(){
        return tipoGradiente;
    }
    
    /**
     * modifica la renderizacion
     * @param r nueva renderizacion
     */
    public void setRenderizacion(RenderingHints r){
        renderizacion=r;
    }
    
    /**
     * establece la renderizacion por defecto
     */
    public void setRenderizacion(){
        renderizacion=new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                     RenderingHints.VALUE_ANTIALIAS_ON);
    }
  
    /**
     * modifica el estado de transparencia
     * @param hay nuevo estado
     */
    public void setHayTransparencia(boolean hay){
        
            hayTransparencia=hay;
    }
   
    /**
     * establece un nuevo punto inicial de la figura
     * @param p nuevo punto
     */
    public void setPuntoInicial(Point p){
        pInicial=p;
    }
    
    /**
     * establece nuevo punto final de la figura
     * @param p nuevo punto final
     */
     public void setPuntoFinal(Point p){
        pFinal=p;
    }
     
     /**
      * establece nuevo punto de la esquina de la figura
      * @param p nuevo punto
      */
    public void setPuntoEsquinaFigura(Point p){
        if(p!=null)
            puntoEsquinaFigura=p;
    }
    /*************************************************************************/
  

    /**
     * metodo que especifica si un punto pertenece a la figura
     * @param p punto 
     * @return  true si el punto dado pertenece,false en caso contrario
     */
    public boolean contains(Point2D p)
    {
        return figura.contains(p);
        
    }
    
    
    
    //metodos abstractos que implementaran la clases que hereden de 
    //esta clase abstracta
    /**
     * metodo abstracto que redimensiona la figura
     * @param p2 punto al que redimensionar
     */
    public abstract void setDimensionFigura(Point p2);
    
    /**
     * metodo abstracto para cambiar la posicion de la figura
     * @param p punto al que transladar
     */
    public abstract void setLocation(Point2D p);
    
    /**
     * metodo abstracto para dibujar la figura
     * @param g2d 
     */
    public abstract void pintar(Graphics2D g2d);
}
