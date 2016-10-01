/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.bam.iu;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import sm.bam.figuras.MiPunto;
import sm.bam.figuras.MiRectangulo;
import sm.bam.figuras.*;

/**
 * clase que extiende de jpanel y que representa el lienzo sobre el que se va a dibujar
 * @author Bogdan Alin Muresan
 * @version 1.0
 *  
 */
public class Lienzo2D extends javax.swing.JPanel {
    
    //array que guarda las formas
    List<FiguraGeometrica> vShape=new ArrayList<>(); 
    FiguraGeometrica figuraSeleccionada=null;
    //variable para setLocation
    Point puntoEsquinaFigura;
   // practicaFinal.VentanaPaint p;
    boolean lineaCurvaPintada=false;
    
    /***************************************************************************/
    //estados del lienzo y las figuras
    //necesarias para guardar para cuando hay cambios de ventana interna
    //y poder recuperar su estado anterior
    private boolean relleno =false;
    boolean alisar=false;
    boolean transparencia=false;
    private boolean editar=false;
    int formaActiva=-1;
    private Color c1=Color.BLACK;
    float spinner=1;
    boolean hayComposicion=false;
    boolean hayRenderizacion=false;
    float grosorPunto=0;
    /***************************************************************************/
    int anchuraClipArea=0;
    int alturaClipArea=0;
    static int aw=0;
    static int ah=0;
    
    /*
     public void setPadreLienzo(VentanaPaint v){
        ve=v;
    }
     
    public VentanaPaint getVentanaPaint(){
        return ve;
    }
     
    public void setAtributosLienzo(){
        
    }
    */
    public void setDimAARR(int i,int j){
        aw=i;
        ah=j;
    }
    
    float dash1[] = {10.0f};
       Stroke dashed =new BasicStroke(5.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash1, 5.0f);
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo2D() {
        initComponents();
    }
    


    /**
     * Método que dibuja puntos,lineas,cuadrados y elipses
     * @param g recibe como párametro el contexto
     */
    @Override
    public void paint (Graphics g){
       super.paint(g);
       Graphics2D g2d=(Graphics2D)g;
       Shape clipArea;
       //establecer el area de recorte
       clipArea = new Rectangle(0,0,getAnchuraClipArea(),getAlturaClipArea());
       g2d.clip(clipArea);
       
       //dibujar las figuras
       for(FiguraGeometrica s:vShape){
           if(figuraSeleccionada!=null){
               g2d.setColor(Color.MAGENTA);
               g2d.setStroke(dashed);
               g2d.draw(figuraSeleccionada.getBounds2D());
           }
           s.pintar(g2d);
       }
       
/* 
     // create new QuadCurve2D.Float
     QuadCurve2D q = new QuadCurve2D.Float();
     // draw QuadCurve2D.Float with set coordinates
     q.setCurve(0.0f, 70.0f, 150.0f, 80.0f, 190.0f, 220.0f);
     g2d.draw(q);
     
     // create new QuadCurve2D.Float
     QuadCurve2D q2 = new QuadCurve2D.Float();
     // draw QuadCurve2D.Float with set coordinates
     q2.setCurve(0.0f, 70.0f, 150.0f, 90.0f, 190.0f, 220.0f);
     g2d.draw(q2);
*/
       
    }

    /**
     * Método updateShape que crea las formas en funcion de la casuistíca
     * @param puntoEvt punto para crear las figuras
     */
    void createShape(Point puntoEvt)
    {
        //Shape s = null;
        FiguraGeometrica s = null;
        switch(formaActiva){
            //dibujar punto
            case 0:
                s= new MiPunto(puntoEvt);
                break;
            //dibujar linea
            case 1: 
                s=new MiLinea(puntoEvt,puntoEvt);
                break;
            //dibujar rectangulo
            case 2:
                s=new MiRectangulo(puntoEvt,1,1);
                break;
            //dibujar elipse
            case 3:
               s=new MiElipse(puntoEvt,0,0);
                break;
            //dibujar rectangulo redondeado
            case 4:
                s=new MiRectanguloRedondeado(puntoEvt, 0, 0,aw,ah);
                break;
            case 5:
                s=new MiLineaCurva(puntoEvt,puntoEvt,puntoEvt);
                break;
        }
        if(s!=null) vShape.add(s); 
       
    }//fin createShape()

    /**
     * Metodo updateShape que modifica/actualiza las formas
     * @param puntoU punto al que se redimensiona las formas
     */
    void updateShape(Point puntoU){
        //Shape s=null; 
        FiguraGeometrica figura;
       // getFiguraSeleccionada().setPtoEsqIzqAr(puntoU);
        switch(formaActiva){
            //actualizar punto
            case 0:
                //el punto no se redimensiona
            break;
            //actualizar linea
            case 1 :
                figura=vShape.get(vShape.size()-1);
                figura.setDimensionFigura(puntoU);
                break;
            //actualizar el rectangulo
            case 2:
                //FiguraGeometrica  rec;
                figura=vShape.get(vShape.size()-1);
                figura.setDimensionFigura(puntoU);
                break;
            //actualizar elipse
            case 3:
                figura=vShape.get(vShape.size()-1);
                figura.setDimensionFigura(puntoU);
                break;
            case 4:
                //rectangulo redondeado
                figura=vShape.get(vShape.size()-1);
                figura.setDimensionFigura(puntoU);
                break;
            case 5:
                //linea curva
                figura=vShape.get(vShape.size()-1);
                
                figura.setDimensionFigura(puntoU);
                //linea curva esta creada
                // lineaCurvaPintada=true;
                break;
               
        }//fin switch
         
    }//fin metodo updateShape

    /**
     * devuelve la forma seleccionada
     * @param p punto que se pasa como parametro
     * @return devuelve una forma
     */
    private FiguraGeometrica getSlectedShape(Point2D p){
       
        for(FiguraGeometrica s:vShape){
            
            if(s.contains(p))
            {
                return s;
            }
        }
        return null;
    }

    /**************************************************************************/ 
    
    
    /**
     * devuelve la anchura del area de recorte
     * @return anchuraClipArea
     */
    public int getAnchuraClipArea(){
        return anchuraClipArea;
    }
    
    /**
     * modifica la altura del area de recorte
     * @param an nueva anchura
     */
    public void setAnchuraArea(int an){
        anchuraClipArea=an;
    }
    /**
     * devuelve la altura del area de recorte
     * @return alturaClipArea
     */
    public int getAlturaClipArea(){
        return alturaClipArea;
    }
    
    /**
     * modifica la altura del area de recorte
     * @param al 
     */
    public void setAlturaClipArea(int al){
        alturaClipArea=al;
    }
   
    /**
     * devuelve el valor del spinner
     * @return spinner
     */
    public float getSpinner()
    {
        return spinner;
    }
    /**
     * establece un nuevo valor del spinner 
     * @param nuevoSpinneractivo 
     */
    public void setSpinner(float nuevoSpinneractivo)
    {
        spinner=nuevoSpinneractivo;
    }
    
    /**
     * modifica el color activo del lienzo
     * @param nuevoColor 
     */
    public void setColor(Color nuevoColor)
    {
        c1=nuevoColor;
    }
    
    /**
     * método selector del atributo color
     * @return el color 
     */
    public Color getColor(){
        return c1;
    }

    /**
     * método modificador que modifica que forma de pintar hay activa
     * @param i 
     */
    public void setForma(int i){
        formaActiva=i;
    }
    /**
     * método que devuelve la forma de pintar que hay activa
     * @return devuelve un entero entre 0 y 3
     */
    public int getForma(){
        return formaActiva;
    }
 
    
    /**
     * metodo selector que devuelve true si esta en modo edicion
     * @return devuelve true si esta en modo edicion
     */
    public boolean getEditar()
    {
        return editar;
    }
    
    /**
     * metodo modificador que indica si esta en modo edicion o no
     * @param nuevoEditar 
     */
    public void setEditar(boolean nuevoEditar)
    {
        editar=nuevoEditar;
    }
    
       /**
     * metodo selector que devuelve true si hay composicion
     * @return true
     */
    
    public boolean getHayComposicion()
    {
        return hayComposicion;
    }
    
    /**
     * metodo modificador que modifica a false si no hay composiocion
     * @param nuevohaycomposicion
     */
    
    public void setHayComposicion(boolean nuevohaycomposicion)
    {
        hayComposicion=nuevohaycomposicion;
    }
    
        /**
     * metodo selector que devuelve true si hay activado la renderizacion
     * @return hayRenderizacion
     */
    
    public boolean getHayRenderizacion()
    {
        return hayRenderizacion;
    }
    
    /**
     * metodo modificador que activa o desactiva la renderizadion
     * @param nuevoHayRenderizacion 
     */
    
    public void setHayRenderizacion(boolean nuevoHayRenderizacion)
    {
        hayRenderizacion=nuevoHayRenderizacion;
    }
    
    /**
     * método selector que devuelve si el atributo rellenable es activo 
     * @return devuelve true o false 
     */
    public boolean getRelleno(){
        return relleno;
    }
    /**
     * método modificador del atributo relleno
     * @param b 
     */
    public void setRelleno(boolean b){
        relleno=b;
        
    }
    /**************************************************************************/

    /**
     * modifica la figura seleccionada
     * @param nuevaShape
     */
    public void setFiguraSeleccionada(FiguraGeometrica nuevaShape)
    {
        figuraSeleccionada=nuevaShape;
    }
    
    /**
     * devuelva la figura seleccionada del lienzo
     * @return figuraSleccionada
     * @see FiguraGeometrica 
     */
    public FiguraGeometrica getFiguraSeleccionada(){
        return figuraSeleccionada;
    }
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this Ycode. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents

 /**
 * Evento que gestiona la eleccion de la forma para dibujar,crea las formas o las selecciona
 * @param evt 
 */   
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
        if(!getEditar()){
            if(getForma()==0){ 
                createShape(evt.getPoint());
            }
           
            //modo edicion
        }
        else{
            try{
                if(getSlectedShape(evt.getPoint())!=null){
                    setFiguraSeleccionada(getSlectedShape(evt.getPoint()));
                }
                else{//click fuera del cuadro que engloba la figura
                   ((MiLineaCurva)getFiguraSeleccionada()).setFiguraMiLineaCurva(evt.getPoint().x,evt.getPoint().y);

                    System.err.println("click fuera del bounding box");
                }
            }
            catch (Exception e){
                System.out.println("error en clicked");
            }   
        }
        this.repaint();
        
    }//GEN-LAST:event_formMouseClicked
/**
 * Evento que gestiona arrastrar ratón para redimensionar las formas
 * @param evt 
 */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
     FiguraGeometrica s= getSlectedShape(evt.getPoint());
        //FiguraGeometrica s= getFiguraSeleccionada();
         if(getEditar()){//estamos en modo edicion
            if(getFiguraSeleccionada()!=null){
                getFiguraSeleccionada().setPuntoFinal(evt.getPoint());
                getFiguraSeleccionada().setLocation(evt.getPoint());
                if(s!=null)
                    s.setPtoEsqIzqAr(new Point(s.getFigura().getBounds().x,s.getFigura().getBounds().y));
                    //s.setPtoEsqIzqAr(new Point(getFigura.getBounds().x,s.getFigura().getBounds().y));

                this.repaint();
            }
         }else{
             
            //s.setPuntoFinal(evt.getPoint());
            updateShape(evt.getPoint());
            //getFiguraSeleccionada().setPtoEsqDchaAbajo(evt.getPoint());
            this.repaint();
         }
    }//GEN-LAST:event_formMouseDragged
/**
 * Evento que gestiona la liberación del ratón
 * @param evt 
 */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(getEditar()){
            lineaCurvaPintada=true;
        }else{
            if(!vShape.isEmpty()){
             //setFiguraSeleccionada(null);
            }
        }
        
        
    }//GEN-LAST:event_formMouseReleased
/**
 * Evento que gestion presionar el ratón para arrastrar una figura o crearlas
 * @param evt 
 */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       if(getEditar()){
            FiguraGeometrica s= getSlectedShape(evt.getPoint());
           // if(s instanceof MiRectanguloRedondeado)
               // System.err.println("en un rectangulo redondeado la figura seleccionada");
            //pInicial=evt.getPoint();
            if(s!=null){
                s.setPuntoInicial(evt.getPoint());
                s.setPuntoEsquinaFigura(new Point(s.getFigura().getBounds().x,s.getFigura().getBounds().y));
                setFiguraSeleccionada(s);
                
                //getFiguraSeleccionada().setPtoEsqIzqAr(evt.getPoint());
               
            }
            
       }else{
            if(getForma()!=0) {
                createShape(evt.getPoint());
                //getFiguraSeleccionada().setPtoEsqIzqAr(evt.getPoint());
            }
       }
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
