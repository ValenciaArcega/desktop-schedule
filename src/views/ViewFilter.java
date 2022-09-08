// by:: { valencia_arcega }
package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import views.resource.Fonts;

public class ViewFilter extends JFrame {

    public ViewFilter() {
        StackBody();
        WinProperties();
    }

    void StackBody() {

        btnRegister = new JButton() {

            @Override
            public void paint(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(colorBtnRegister);
                obj.fillRoundRect(0, 0, 205, 38, 20, 20);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 18));
                obj.drawString("Registrarme", 50, 26);

            }
        };
        btnRegister.setBounds(97, 135, 205, 38);
        btnRegister.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent var) {

                colorBtnRegister = new Color(0xbfbfbf);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent var) {

                colorBtnRegister = new Color(0xD9D9D9);
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent var) {

                new ViewRegister()
                        .setVisible(true);
                dispose();
            }
        });
        add(btnRegister);

        btnLogin = new JButton() {

            @Override
            public void paint(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(colorBtnLogin);
                obj.fillRoundRect(0, 0, 205, 38, 20, 20);

                obj.setColor(Color.white);
                obj.setFont(font.QuicksandM(0, 18));
                obj.drawString("Iniciar sesión", 50, 26);
            }
        };
        btnLogin.setBounds(97, 221, 205, 38);
        btnLogin.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent var) {

                colorBtnLogin = new Color(0x054da3);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent var) {

                colorBtnLogin = new Color(0x0074FF);
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent var) {

                new ViewLogin()
                        .setVisible(true);
                dispose();
            }
        });
        add(btnLogin);
    }

    void WinProperties() {

        this.setSize(winWidth, winHeight);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setTitle("Bienvenido");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()
                .getResource("/assets/img/64-icon-app.png")));

        btnClose = new JPanel() {

            @Override
            public void paintComponent(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(colorBtnClose);
                obj.fillOval(0, 0, 20, 19);

                obj.setColor(Color.white);
                obj.setFont(font.QuicksandB(1, 17));
                obj.drawString("x", 6, 14);
            }
        };        
        btnClose.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent var) {

                System.exit(DO_NOTHING_ON_CLOSE);
            }

            @Override
            public void mouseEntered(MouseEvent var) {

                colorBtnClose = new Color(0xFE3B30);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent var) {

                colorBtnClose = new Color(0xf56252);
                repaint();
            }
        });
        btnClose.setBounds(368, 10, 20, 19);
        add(btnClose);

        panelTop = new JPanel();
        panelTop.addMouseListener(new MouseAdapter(){

            @Override public void mousePressed(MouseEvent var) {

                xMouse = var.getX();
                yMouse = var.getY();                
            }
        });
        panelTop.addMouseMotionListener(new MouseAdapter(){

            @Override public void mouseDragged(MouseEvent var) {

                int x = var.getXOnScreen();
                int y = var.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });
        panelTop.setOpaque(false);
        panelTop.setBounds(0,0,winWidth, 20);
        add(panelTop);

        background = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(Color.white);
                obj.fillRoundRect(0, 0, winWidth - 1, winHeight - 1, 20, 20);

                obj.setPaint(colorTxtTitle);
                obj.setFont(font.QuicksandB(1, 30));
                obj.drawString("¡ Hola Scheduler !", 72, 75);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 13));
                obj.drawString("¿No tienes una cuenta?", 127, 125);
                obj.drawString("o", 196, 203);
            }
        };
        background.setBounds(0, 0, winWidth, winHeight);
        add(background);
    }

    
    // Objects & Variables

    private final int winWidth = 400;
    private final int winHeight = 300;

    int xMouse, yMouse;

    Fonts font = new Fonts();

    protected Color colorBtnRegister = new Color(0xD9D9D9);
    protected Color colorBtnLogin = new Color(0x0074FF);

    private Color colorBtnClose = new Color(0xf56252);

    protected GradientPaint colorTxtTitle = new GradientPaint(0, 0, Color.blue, 300, 0, Color.red);

    public JPanel background, btnClose, panelTop;

    protected JButton btnRegister, btnLogin;

} // class
