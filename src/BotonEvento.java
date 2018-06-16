import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;

public class BotonEvento extends JApplet {
    private int tipoCara = 1;
    
    public BotonEvento(){
        setSize(300,300);
        setBackground(Color.cyan);
        setLayout(new FlowLayout());
        addComponentes();
        setVisible(true);
    }
    
    private void addComponentes(){
       //boton1 y 2 son objetos de origen de eventos
        Button boton1= new Button("Carita Feliz");
        Button boton2= new Button("Carita Triste");
        //aBoton1 y 2 son objetos oyentes de eventos
        AccionBoton aBoton1 = new AccionBoton(1);
        AccionBoton aBoton2 = new AccionBoton(2);
        //Registro de Oyentes
        boton1.addActionListener(aBoton1);
        boton2.addActionListener(aBoton2);

        add(boton1);
        add(boton2);
        
    }
    @Override
    public void paint(Graphics g){
        if(tipoCara!=0){
           g.setColor(Color.YELLOW);
           g.fillOval(40, 60, 200, 200);
           g.setColor(Color.BLACK);
           g.fillOval(90, 120, 20, 20);
           g.fillOval(180-10, 130-10, 20, 20);
           g.setColor(Color.RED);
           
          if(tipoCara==1)
               g.drawArc(80, 100, 120, 120, 180, 180);
                //x ,y ,largo,ancho,angulo inicial, angulo final           
           else
               g.drawArc(80, 160, 120, 120, 0, 180);
               
           }        
    }
    
    class AccionBoton implements ActionListener{
       private int valor;
        
         public AccionBoton(int valor){
              this.valor = valor;
         }        
         public void actionPerformed(ActionEvent e){
             tipoCara = valor;
             repaint();         
         }    
    }
    //Una clase adaptadora nos ahorra poner todos los metodos de WindowListener
}