/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformaciones;

/**
 *
 * @author ale
 */
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Boolean.FALSE;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Ventana extends JPanel implements ActionListener,KeyListener{

     
    // ventana
    
    int op;
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];
    public JMenuBar arc;
    public JButton b;
    public JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    public JButton btn4;
    public JMenu uno, dos;
    public JMenuItem u1,u2,u3,u4,u5,u6,u7,u8,u9;
    public JLabel t;
    MouseMotionListener motion;
    MouseListener  listener;
    KeyListener KeyCommand;
    Stroke stroke = new BasicStroke(2f);  



    /**
     * Crear una ventana para representar la figura
     * @param titulo Titulo de la ventana
     * @param figura Figura representada por puntos
     */
    public Ventana(String titulo,Punto figura[]) {
      Punto FIGURA[]=figura;
        // inicializar la ventana
        ventana = new JFrame(titulo);
        ventana.setBackground(Color.BLACK);
        
       
        // definir tamaño a ventana
        ventana.setSize(1000, 700);
         
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
 
        b1= new JButton("+"); 
        b2 = new JButton("-");
        b3 = new JButton("R <-");
        b4 = new JButton("R ->");
        b5 = new JButton("DEFORMAR");
        b6 = new JButton("R EN X");
        b7 = new JButton("R EN Y");
        b8 = new JButton("R EN XY");
        b9 = new JButton("Rotacion <-");
        b10 = new JButton("Restaurar");
         u1 = new JMenuItem("Trasladar");
         
         //evitar perdida de foco con los botones
         b1.setFocusable(FALSE);
         b2.setFocusable(FALSE);
         b3.setFocusable(FALSE);
         b4.setFocusable(FALSE);
         b5.setFocusable(FALSE);
         b6.setFocusable(FALSE);
         b7.setFocusable(FALSE);
         b8.setFocusable(FALSE);
         b9.setFocusable(FALSE);
         b10.setFocusable(FALSE);
         //JMENU
        u2 = new JMenuItem("Rotacion");
        u3 = new JMenuItem("Escalar");
        u4 = new JMenuItem("Reflexion en Y");
        u5 = new JMenuItem("Reflexion en XY");
        u6 = new JMenuItem("Reflexion en X");
        u7 = new JMenuItem("Rotar en contra");
        u8 = new JMenuItem("Rotar en sentido");
        u9 = new JMenuItem("Salir");
        uno = new JMenu("Transformaciones");
        dos = new JMenu("Opciones");
  
        add(arc);
          arc.add(uno);
        arc.add(dos);
        uno.add(u1);
        uno.add(u2);
        uno.add(u3);
        uno.add(u4);
        uno.add(u5);
        uno.add(u7);
        uno.add(u8);
         dos.add(u9);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        
                
  
        
        arc.add(b1);
        arc.add(b2);
        arc.add(b3);
        arc.add(b4);
        arc.add(b5);
        arc.add(b6);
        arc.add(b7);
        arc.add(b8);
      
        arc.add(b10);
        
         //escuchas
        u2.addActionListener(this);
        u1.addActionListener(this);
        u3.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        u6.addActionListener(this);
        u7.addActionListener(this);
        u8.addActionListener(this);
        u9.addActionListener(this);
        
        //escuchas mouse
         EventosMouseMotion();
         this.addMouseMotionListener(motion);
         
         EventosMouseListener();
         this.addMouseListener(listener);
         
         ventana.addKeyListener(this);
      
//        ventana.addMouseListener(this);
//        ventana.addMouseMotionListener(motion);
                
        b = new JButton("salir");
        b.setBounds(100, 150, 100, 30);
        b.addActionListener(this);
        add(b);
   
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setBackground(Color.BLACK);
        
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(1000, 800);
        contenedor.setBackground(Color.BLACK);
        
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3f));
       
        g2d.setStroke(stroke);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
        //Dibujar la figura original
        g.setColor(Color.DARK_GRAY);
        this.dibujar(g);
    }
    
    
    //escuchas
    public void actionPerformed(ActionEvent e){
   
        if(e.getSource()==b){
          
        }
        if(e.getSource()==u1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u2){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.Rotacion(angulo);
            repaint();
        }
         if(e.getSource()==u3){
            Double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("el factor a escalar en x"));
            y=Double.parseDouble(JOptionPane.showInputDialog("el factor a escalar en y"));
            this.escalar(x,y);
            repaint();
        }
         if(e.getSource()==u4 || e.getSource()==b7){
            this.reflexionY();
            repaint();
    }
             if(e.getSource()==null || e.getSource()==b6){
            this.reflexiónX();
            repaint();
    }
         if(e.getSource()==u5 || e.getSource()==b8){
            this.reflexionXY();
            repaint();
         }
            if(e.getSource()==u7 ||  e.getSource()==b3 ){
            this.rotacionFija(-2, 1, 1);
            repaint();
         }
            if(e.getSource()==u8 ||  e.getSource()==b4){
            this.rotacionFija(2, 10, 10);
            repaint();
         }
              if(e.getSource()==b1){
            this.escalar(1.2f);
            repaint();
         }
              if(e.getSource()==b2){
            this.escalar(0.8f);
            repaint();
         }
              if(e.getSource()==b5){
            this.deformación(0.2f, 0.0f);
            repaint();
         }
              if(e.getSource()==b10){
         
                  reset();
           repaint();
         }
              if(e.getSource()==b||  e.getSource()==u9){
         System.exit(0);
         }
    }

    
    //metodos 
        
    public void traslacion(int xf, int yf){
        for (Punto punto : figura) {
        //punto x:((x - xf) 
        //punto y: ((y - yf)
            punto.setX((int)( xf+punto.getX()));
            punto.setY((int)(yf+punto.getY()));
        }
        
    }
    
    public void setFig(Punto figura[]){
        this.figura=figura;
    }
    public void reset(){
        Punto fig[] = {
          new Punto(20, 550),
           new Punto(770, 550),
           new Punto(770, 350),//altura de primer pilar
           new Punto(517, 300),
           new Punto(517, 290),
           new Punto(780, 340),
           new Punto(770, 350),
           new Punto(780, 340),
           new Punto(780, 325),
           new Punto(517, 270),
           new Punto(517, 550),
           new Punto(517, 240),
           new Punto(380, 80),
           new Punto(253, 240),
           new Punto(228, 240),
           new Punto(380, 45),
           new Punto(380, 45),
           new Punto(545, 240),
           new Punto(517, 240),
           new Punto(380, 80),
           new Punto(253, 240),
           new Punto(253, 300),
           new Punto(20, 350),
           new Punto(10, 340),
           new Punto(253, 285),
           new Punto(253, 270),
           new Punto(10, 325),
           new Punto(10, 340),
           new Punto(20, 350),
           new Punto(20, 550),
           new Punto(97, 550),
           new Punto(97, 400),
           new Punto(194, 400),
           new Punto(194, 550),
           new Punto(253, 550),
           new Punto(253, 300),
           new Punto(253, 550),
           new Punto(341,550),
           new Punto(341,400),
           new Punto(431,400),
           new Punto(431,550),
           new Punto(386,550),
           new Punto(386,400),//PUERTA DE ENMEDIO ARRIBA XD
           new Punto(386,550),
           new Punto(600,550),
           new Punto(600,400),
           new Punto(700,400),
           new Punto(700,550),
           
           
        };
        setFig(fig);
        repaint();
    }
        
         public void traslacionMouse(int xf, int yf){
        for (Punto punto : figura) {
        //punto x:((x - xf) 
        //punto y: ((y - yf)
            int X=punto.getX(),Y=punto.getY();
         punto.setX((int)( xf+punto.getX()));
            punto.setY((int)(yf+punto.getY()));
        }
    
    }
    public void Rotacion (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {

            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
        public void escalar (double factor_x, double factor_y){
        for (Punto punto : figura) {
            punto.setX((int)(punto.getX()*factor_x));
            punto.setY((int)(punto.getY()*factor_y));
        }
    }
        public void escalar (float escalar){
        for (Punto punto : figura){
            punto.setX((int) (punto.getX()*escalar));
            punto.setY((int) (punto.getY()*escalar));
        }
    }
           public void escalarFijo (float escalar, int fx, int fy){
        for (Punto punto : figura){
            punto.setX((int) (fx + ((punto.getX() - fx) * escalar)));
            punto.setY((int) (fy + ((punto.getY() - fy) * escalar)));
        }
    }
        public void escalarFijo (float factorX, float factorY, int fx, int fy){
        for (Punto punto : figura){
            punto.setX((int) (fx + ((punto.getX() - fx) * factorX)));
            punto.setY((int) (fy + ((punto.getY() - fy) * factorY)));
        }
    }
        
    public void rotacionFija(double ang, int fx, int fy){
        this.traslacion(-fx, -fy);
        this.Rotacion(ang);
        this.traslacion(fx, fy);
    }
    
    public void reflexionY (){
        int tx = figura [0].getX();
        int ty = figura [0].getY();
        
        for (Punto punto : figura){
            punto.setX((punto.getX()-tx) + tx);
            punto.setY(-(punto.getY()-ty) + ty);
        }
    }
    
    public void reflexionXY(){
        int tx = figura [0].getX();
        int ty = figura [0].getY();
        
        for (Punto punto : figura){
            punto.setX(-(punto.getX()-tx) + tx);
            punto.setY(-(punto.getY()-ty) + ty);
        }
    }
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                    this.figura[i].getX(),//punto A
                    this.figura[i].getY(),
                    this.figura[i+1].getX(),//punto B
                    this.figura[i+1].getY()
            );
        }
    }
     private void deformación(double dx, double dy) {
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            punto.setX(((int) ((punto.getX() - tx) + ((punto.getY() - ty) * dx) + tx)));
            punto.setY(((int) (((punto.getX() - tx) * dy) + ((punto.getY() - ty) + ty))));
        }}
     private void reflexiónX() {
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            punto.setX(-(punto.getX() - tx) + tx);
            punto.setY((punto.getY() - ty) + ty);
        }
        
        
    }
         public void EventosMouseMotion(){
            motion =new  MouseMotionListener(){
                @Override
                public void mouseDragged(MouseEvent me) {
                    int x,y;
                    System.out.println("X: "+me.getX()+" Y: "+me.getY());
                    x=me.getX();
                    y=me.getY();
                    
                    if (y>0 && y<360) {
                    traslacion(0, -4);
                        
                        
                    }else if (y>360 && y<800) {
                       traslacion(0, 4); 
                    }
                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent me) {
                    //To change body of generated methods, choose Tools | Templates.
                }
            
                    }  ;                 
    
                    }
         
          private void EventosMouseListener(){
    listener=new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent me) {
            System.out.println("press");
            if (SwingUtilities.isLeftMouseButton(me)) {
               System.out.println("click left"); 
             Rotacion(-3f);
             repaint();
              
            }
               if (SwingUtilities.isRightMouseButton(me)) {
               System.out.println("click left"); 
             Rotacion(3f);
             repaint();
              
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
          
        }

        @Override
        public void mouseReleased(MouseEvent me) {
          
        }

        @Override
        public void mouseEntered(MouseEvent me) {
           
        }

        @Override
        public void mouseExited(MouseEvent me) {
            //To change body of generated methods, choose Tools | Templates.
        }
   
    }  ;

            }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("key"); 
 
    }

    @Override
    public void keyPressed(KeyEvent ke) {
                 if (ke.getKeyCode() == KeyEvent.VK_UP){
            traslacion(0, -50);
            repaint();
          }
          
         else if (ke.getKeyCode() == KeyEvent.VK_DOWN){
             traslacion(0, 50);
            repaint();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT){
            traslacion(-50, 0);
            repaint();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
           traslacion(50, 0);
           repaint();
        }
        else if (ke.isControlDown() && ke.getKeyChar()!= 'w' && ke.getKeyCode() == KeyEvent.VK_W){
           escalar(1.2f);
            repaint();
          
        }
        else if (ke.isControlDown() && ke.getKeyChar() != 's' &&  ke.getKeyCode() == KeyEvent.VK_S){
           escalar(.8f);
            repaint();
        } 
        else if (ke.isControlDown() && ke.getKeyChar() != 'R' &&  ke.getKeyCode() == KeyEvent.VK_R){
           traslacion(50, -50);
           repaint();
        }         
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       //To change body of generated methods, choose Tools | Templates.
    }
}   