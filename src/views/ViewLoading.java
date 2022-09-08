// by:: { valencia_arcega }
package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import views.resource.Fonts;

public class ViewLoading extends JFrame {

    public ViewLoading() {

        StackBody();
        WinProperties();
    }

    void StackBody() {

        progressBar = new JProgressBar();
        progressBar.setBounds(40,245,440,5);  
        progressBar.setBackground(new Color(232,232,237));
        progressBar.setBorder(null);
        progressBar.setBorderPainted(false);  
        progressBar.setForeground(new Color(0,113,227));
        progressBar.setMaximum(100);
        add(progressBar); 

        timerBar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Progress = Progress + 1;
                progressBar.setValue(Progress);
                        
                if (progressBar.getValue()==1) { tsb = "Cargando pantalla de registro"; repaint();  }
                if (progressBar.getValue()==10) { tsb = "Cargando imagenes"; repaint(); }
                if (progressBar.getValue()==20) { tsb = "Inicializando complementos"; repaint(); }
                if (progressBar.getValue()==40) { tsb = "Importando fuentes"; repaint(); }
                if (progressBar.getValue()==50) { tsb = "Inicializando vistas"; repaint(); }
                if (progressBar.getValue()==70) { tsb = "Cargando componentes"; repaint();  }
                if (progressBar.getValue()==75) { tsb = "Preparando todo"; repaint();  }
                if (progressBar.getValue()==85) { tsb = "Ya casi esta"; repaint(); }
                if (progressBar.getValue()==90) { tsb = "Listo"; repaint();  }
                if (progressBar.getValue()==95) { progressBar.setForeground(new Color(0x00FF80));}
                if (progressBar.getValue()==100) { 
                
                    tsb = "Terminado"; repaint();
                    time.stop(); 
                    
                    dispose();
                    new ViewFilter()
                                .setVisible(true);
                    
                }
            }
        };

        time = new Timer(100,timerBar);
        time.start();  
       
    }

    void WinProperties() {

        this.setSize(winWidth, winHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setBackground(new Color(0,0,0,0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Cargando...");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()
                                 .getResource("/assets/img/64-icon-app.png")));

        background = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;
                int w = getWidth(); 
                int h = getHeight();
                
                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(Color.white); 
                obj.fillRoundRect(0,0,w-1, h-1, 35, 35);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 16));
                obj.drawString(tsb,40,238);
            }
        };
        background.setBounds(0,0,winWidth, winHeight); 
        background.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });
        background.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {

                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                setLocation(x-xMouse, y-yMouse);
            }
        });
        add(background);
    }


    // Objects & Variables

    int winWidth = 520;
    int winHeight = 270;
    int Progress = 0;
    int xMouse, yMouse;
    
    String tsb = "";

    // Colors
    Color clrtxtStatus = Color.black;
    
    // Fonts
    Fonts font = new Fonts();    

    // Swing components
    JPanel IconArea, BarArea, background;
    
    JLabel iconApp, txtProgress;

    JProgressBar progressBar;
    
    Timer time;

    ActionListener timerBar;

} // class
