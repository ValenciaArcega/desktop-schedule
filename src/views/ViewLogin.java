// by:: { valencia_arcega }
package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import views.resource.Fonts;

public class ViewLogin extends JFrame {

    public ViewLogin() {
        StackBody();        
        WinProperties();
    }

    void StackBody() {

        fieldUser = new JTextField();
        fieldUser.setBounds(51, 135, 219, 35);
        fieldUser.setOpaque(false);
        fieldUser.setBorder(null);
        fieldUser.setForeground(Color.black);
        fieldUser.setFont(font.QuicksandM(0,22));
        fieldUser.setHorizontalAlignment(JTextField.CENTER);
        fieldUser.addKeyListener(new KeyAdapter() {

            @Override public void keyTyped(KeyEvent var) {

                char input = var.getKeyChar();
                if ( ((input < '0') || (input > '9')) && (input != KeyEvent.VK_SPACE)) {

                    var.consume();
                }

                if (fieldUser.getText().length() >= 15 ) {

                    var.consume();
                }
             }
        });
        add(fieldUser);

        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(51, 245, 179, 35);
        fieldPassword.setOpaque(false);
        fieldPassword.setBorder(null);
        fieldPassword.setForeground(Color.black);
        fieldPassword.setFont(font.QuicksandM(0,18));
        fieldPassword.setHorizontalAlignment(JTextField.CENTER);
        fieldPassword.addFocusListener(new FocusAdapter(){

            @Override 
            public void focusGained(FocusEvent var) {

                btnEye.setEnabled(true);
            }
        }); 
        add(fieldPassword);

        btnEye = new JRadioButton();
        btnEye.setIcon(iconPassword);
        btnEye.setOpaque(false);
        btnEye.setEnabled(false);
        btnEye.setBounds(239, 251, 25, 25);  
        btnEye.addMouseListener(new MouseAdapter(){
          
            @Override public void mouseClicked(MouseEvent var) {

                if (btnEye.isSelected()) {

                    btnEye.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_hide.png")));
                    echo = fieldPassword.getEchoChar();
                    fieldPassword.setEchoChar((char) 0);
                } else {

                    btnEye.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_show.png")));
                    fieldPassword.setEchoChar(echo);
                }          
            }
        });
        add(btnEye);   

        btnLogin = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(colorBtnLogin);
                obj.fillRoundRect(0, 0, 200, 40 , 20, 20);

                obj.setColor(Color.white);
                obj.setFont(font.QuicksandM(0,21));
                obj.drawString("Ingresar",60,28);
            }
        };
        btnLogin.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                String U1 = "123";
                String U1R = "123";
                String res = fieldUser.getText();
                String res2 = fieldPassword.getText();

                if (res.equals(U1) && res2.equals(U1R)) {
                    fieldUser.setForeground(new Color(0x02b55c));
                    fieldPassword.setForeground(new Color(0x02b55c));
                    dispose();
                    new ViewHome()
                                .setVisible(true);
                }
                else {
                    new LoginWrong()
                                .setVisible(true);
                    btnEye.setEnabled(false);
                    fieldPassword.setText("");
                }

            }

            @Override
            public void mouseEntered(MouseEvent evt) { 

                colorBtnLogin = new Color(0x054da3);
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent evt) { 

                colorBtnLogin = new Color(0x0074ff);
                repaint();
            }
        });
        btnLogin.setBounds(60, 330, 200, 40);
        add(btnLogin);   
        
    }
    
    void WinProperties() {

        this.setSize(window_width, window_height);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setTitle("Inicia sesion");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()
                                                    .getResource("/assets/img/64-icon-app.png")));

        btnBack = new JPanel() {

            @Override
            public void paintComponent(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(colorBtnBack);
                obj.fillRoundRect(0, 0, 76, 34, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(0, 0, 76, 34, 15, 15);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_back.png"))
                        .getImage(), 2, 6, this);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 15));
                obj.drawString("Atras", 26, 23);
            }
        };
        btnBack.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent var) {

                new ViewFilter()
                        .setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent var) {

                colorBtnBack = new Color(0xD9D9D9);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent var) {

                colorBtnBack = new Color(0xE9E8EE);
                repaint();
            }
        });
        btnBack.setBounds(30, 30, 77, 35);
        add(btnBack);

        panelTop = new JPanel();
        panelTop.setBounds(0,0,window_width, 20);
        panelTop.setOpaque(false);
        panelTop.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent var) {
                xMouse = var.getX();
                yMouse = var.getY();
            }
        });
        panelTop.addMouseMotionListener(new MouseAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent var) {
                int x = var.getXOnScreen();
                int y = var.getYOnScreen();

                setLocation(x-xMouse, y-yMouse);
            }
        });
        add(panelTop);

        background = new JPanel() {
            
            @Override public void paintComponent(Graphics g) {

                Graphics2D let = (Graphics2D) g;

                let.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                let.setPaint(Color.white); //26,26,27
                let.fillRoundRect(0, 0, window_width-1, window_height-1, 25, 25);
                let.setPaint(Color.lightGray);
                let.drawRoundRect(0, 0, window_width-1, window_height-1, 25, 25);

                let.setColor(Color.black);
                let.setFont(font.QuicksandB(0,23));
                let.drawString("Inicia sesión", 120,55);

                let.setPaint(new Color(0xE3E3E3)); // 27,27,29
                let.fillRoundRect(30, 90, window_width-60, 99,20, 20);
                let.setPaint(Color.lightGray);
                let.drawRoundRect(30, 90, window_width-60, 99,20, 20);  

                let.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/21_numbers.png")).getImage(),263,97,this);             
                
                let.setPaint(new Color(0xE3E3E3));
                let.fillRoundRect(30, 200, window_width-60, 120,20, 20);
                let.setPaint(Color.lightGray);
                let.drawRoundRect(30, 200, window_width-60, 120,20, 20);

                let.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/19_hashtag.png")).getImage(),264,206,this);
                
                let.setColor(Color.black);
                let.setFont(font.QuicksandM(0,20));
                let.drawString("Numero de telefono",50,120);
                let.drawString("Contraseña",50,230);
                            
                // user field
                let.setPaint(Color.white);
                let.fillRoundRect(50, 134, 220, 35, 15, 15);
                let.setPaint(Color.lightGray);
                let.drawRoundRect(50, 134, 220, 35, 15, 15);
                // password field
                let.setPaint(Color.white);
                let.fillRoundRect(50, 245, 180, 35, 15, 15);
                let.setPaint(Color.lightGray);
                let.drawRoundRect(50, 245, 180, 35, 15, 15);
                // Eye area
                let.setPaint(Color.white);
                let.fillRoundRect(235, 245, 35, 35, 15, 15);
                let.setPaint(Color.lightGray);
                let.drawRoundRect(235, 245, 35, 35, 15, 15);
            }
        };
        background.setBounds(0, 0, window_width, window_height);
        add(background);  

    }
        
    // Objects & Variables

    int xMouse, yMouse;

    char echo = ' ';

    private final int window_width = 320;
    private final int window_height = 380;

    private Color colorBtnBack = new Color(0xE9E8EE);
    private Color colorBtnLogin = new Color(0x0074ff);

    private ImageIcon iconPassword = new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_show.png"));

    JRadioButton btnEye;

    JPanel pInformation, background, panelTop
            ,btnLogin, btnBack;
        
    JTextField fieldUser;
    JPasswordField fieldPassword;

    Fonts font = new Fonts();   

} // class


class LoginWrong extends JFrame {

    public LoginWrong() {

        StackBodyMessage();
        this.setSize(winWidth, winHeight);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setTitle("Algo salio mal");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()
                                 .getResource("/assets/img/64-icon-app.png")));
    }

    void StackBodyMessage() {

        JPanel btnOkey = new JPanel() {

            @Override public void paint(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(colorBtnOkey);
                obj.fillRoundRect(0,0,194,35,15,15);

                obj.setColor(Color.white);
                obj.setFont(font.QuicksandB(0,17));
                obj.drawString("OK", 85,24);
            }
        };
        btnOkey.setBounds(33,110,194,35);
        btnOkey.addMouseListener(new MouseAdapter(){

            @Override public void mouseClicked(MouseEvent var) {

                dispose();            
            }

            @Override public void mouseEntered(MouseEvent var) {

                colorBtnOkey = new Color(0x054da3);
                repaint();
            }

            @Override public void mouseExited(MouseEvent var) {

                colorBtnOkey = new Color(0x0074ff);
                repaint();
            }
        });
        add(btnOkey);

        JPanel bg = new JPanel() {

            @Override
            public void paint(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(Color.white);
                obj.fillRoundRect(0, 0, winWidth - 1, winHeight - 1, 25, 25);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(0, 0, winWidth - 1, winHeight - 1, 25, 25);

                obj.setColor(new Color(0xCFCFCF));
                obj.fillRoundRect(33, 46, 194, 50, 10, 10);
                obj.setColor(new Color(0xAEACAC));
                obj.drawRoundRect(33, 46, 194, 50, 10, 10);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandB(0, 18));
                obj.drawString("Error en las credenciales", 22, 33);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/32_wrong.png"))
                                .getImage(), 54, 56, this);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 14));
                obj.drawString("Revisa que los", 95, 61);
                obj.drawString("campos", 95, 77);
                obj.drawString("sean correctos", 95, 91);
            }
        };
        bg.setBounds(0, 0, winWidth, winHeight);
        bg.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent var) {

                xMouse = var.getX();
                yMouse = var.getY();
            }
        });
        bg.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent var) {

                int x = var.getXOnScreen();
                int y = var.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });
        add(bg);
    }

    // Objects n Variables

    public int xMouse, yMouse;

    private final int winWidth = 260;
    private final int winHeight = 160;

    public Color colorBtnOkey = new Color(0x0074ff);

    Fonts font = new Fonts();

} // class
