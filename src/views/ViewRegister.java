// by:: { valencia_arcega }
package views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import views.resource.Fonts;

public class ViewRegister extends JFrame {

    public ViewRegister() {

        StackTopBar();
        StackBody();
        this.setSize(winWidth, winHeight);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Formulario");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()
                .getResource("/assets/img/64-icon-app.png")));
    }

    void StackTopBar() {

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
        btnBack.setBounds(30, 30, 77, 35);
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
        add(btnBack);

        panelTop = new JPanel();
        panelTop.setBounds(0, 0, winWidth, 25);
        panelTop.setBackground(new Color(0, 0, 0, 0));
        panelTop.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent var) {

                xMouse = var.getX();
                yMouse = var.getY();
            }
        });
        panelTop.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent var) {

                int x = var.getXOnScreen();
                int y = var.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });
        add(panelTop);
    }

    void StackBody() {

        
        field1 = new JTextField();
        field1.setBounds(56, 128, 240, 36);
        field1.setFont(font.QuicksandM(0, 17));
        field1.setForeground(Color.black);
        field1.setOpaque(false);
        field1.setBorder(null);
        field1.setHorizontalAlignment(JTextField.CENTER);
        field1.addKeyListener(new KeyAdapter() {

            @Override public void keyTyped(KeyEvent var) {
    
            char input = var.getKeyChar();

                if(!(Character.isAlphabetic(input) ||  (input == KeyEvent.VK_SPACE)||  input == KeyEvent.VK_DELETE )){
                    
                        var.consume();
                    }

                if (field1.getText().length() >= 42 ) {

                    var.consume();
                }
            }
        });
        add(field1);

        field2 = new JTextField();
        field2.setBounds(56, 228, 240, 36);
        field2.setFont(font.QuicksandM(0, 17));
        field2.setForeground(Color.black);
        field2.setBorder(null);
        field2.setOpaque(false);
        field2.setHorizontalAlignment(JTextField.CENTER);
        field2.addKeyListener(new KeyAdapter() {

            @Override public void keyTyped(KeyEvent var) {
    
            char input = var.getKeyChar();
            
                if(!(Character.isAlphabetic(input) ||  (input == KeyEvent.VK_SPACE)||  input == KeyEvent.VK_DELETE )){
                
                    var.consume();
                }

                if (field2.getText().length() >= 40 ) {

                    var.consume();
                }
            }
        });
        add(field2);

        field3 = new JTextField();
        field3.setBounds(56, 328, 240, 36);
        field3.setFont(font.QuicksandM(0, 17));
        field3.setForeground(new Color(0x082452));
        field3.setBorder(null);
        field3.setOpaque(false);
        field3.setHorizontalAlignment(JTextField.CENTER);
        field3.addKeyListener(new KeyAdapter() {

            @Override public void keyTyped(KeyEvent var) {

                char input = var.getKeyChar();
                if ( ((input < '0') || (input > '9')) && (input != KeyEvent.VK_SPACE)) {

                    var.consume();
                }

                if (field3.getText().length() >= 15 ) {

                    var.consume();
                }
             }
        });
        add(field3);

        field4 = new JPasswordField();
        field4.setBounds(56, 428, 198, 36);
        field4.setFont(font.QuicksandM(0, 17));
        field4.setForeground(Color.black);
        field4.setBorder(null);
        field4.setOpaque(false);
        field4.addFocusListener(new FocusAdapter(){

            @Override 
            public void focusGained(FocusEvent var) {

                btnEye.setEnabled(true);
            }
        }); 
        field4.setHorizontalAlignment(JPasswordField.CENTER);
        add(field4);

        btnEye = new JRadioButton();
        btnEye.setBounds(263, 437, 24, 20);
        btnEye.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_show.png")));
        btnEye.setSelected(false);
        btnEye.setEnabled(false);
        btnEye.setOpaque(false);
        btnEye.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent var) {

                if (btnEye.isSelected()) {

                    btnEye.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_hide.png")));
                    echo = field4.getEchoChar();
                    field4.setEchoChar((char) 0);
                } else {

                    btnEye.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_show.png")));
                    field4.setEchoChar(echo);
                }
            }
        });
        add(btnEye);

        btnAdd = new JPanel() {

            @Override
            public void paint(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(colorBtnAdd);
                obj.fillRoundRect(0, 0, 220, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/20_btnAdd.png"))
                        .getImage(), 44, 10, this);

                obj.setColor(Color.white);
                obj.setFont(font.QuicksandM(0, 18));
                obj.drawString("Registrarme", 69, 27);
            }
        };
        btnAdd.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent var) {

                try {

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                    Connection con = DriverManager.getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=Schedule; user = sa; password = 1234;");

                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("INSERT INTO Users VALUES('" + field1.getText() + "','" + field2.getText()
                            + "','" + field3.getText() + "','" + field4.getPassword() + "')");
                    stmt.close();
                    con.close();

                    dispose();

                    new Done().setVisible(true);

                } 
                catch (SQLException e) {            new Wrong().setVisible(true); } 

                catch (ClassNotFoundException cE) { new Wrong().setVisible(true); }
            }

            @Override
            public void mouseEntered(MouseEvent var) {

                colorBtnAdd = new Color(0x054da3);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent var) {

                colorBtnAdd = new Color(0x0074ff);
                repaint();
            }
        });
        btnAdd.setBounds(65, 490, 220, 40);
        add(btnAdd);

        background = new JPanel() {

            @Override
            public void paintComponent(Graphics var) {

                Graphics2D obj = (Graphics2D) var;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(Color.white);
                obj.fillRoundRect(0, 0, winWidth - 1, winHeight - 1, 25, 25);
                obj.setPaint(Color.lightGray);
                obj.drawRoundRect(0, 0, winWidth - 1, winHeight - 1, 25, 25);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandB(0, 23));
                obj.drawString("Ingresa tus datos", 120, 55);

                // ---------------------------------------------------------------------------------
                obj.setColor(new Color(0xE3E3E3));
                obj.fillRoundRect(30, 90, 290, 90, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(30, 90, 290, 90, 15, 15);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 18));
                obj.drawString("Nombre", 60, 120);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/21_Aa.png"))
                        .getImage(), 293, 96, this);

                obj.setColor(Color.white);
                obj.fillRoundRect(55, 128, 240, 36, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(55, 128, 240, 36, 15, 15);

                // ---------------------------------------------------------------------------------

                obj.setColor(new Color(0xE3E3E3));
                obj.fillRoundRect(30, 190, 290, 90, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(30, 190, 290, 90, 15, 15);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 18));
                obj.drawString("Apellido", 60, 220);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/21_Aa.png"))
                        .getImage(), 293, 196, this);

                obj.setColor(Color.white);
                obj.fillRoundRect(55, 228, 240, 36, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(55, 228, 240, 36, 15, 15);

                // ---------------------------------------------------------------------------------

                obj.setColor(new Color(0xE3E3E3));
                obj.fillRoundRect(30, 290, 290, 90, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(30, 290, 290, 90, 15, 15);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 18));
                obj.drawString("Numero telefónico", 60, 320);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/21_numbers.png"))
                        .getImage(), 293, 296, this);

                obj.setColor(Color.white);
                obj.fillRoundRect(55, 328, 240, 36, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(55, 328, 240, 36, 15, 15);

                // ---------------------------------------------------------------------------------

                obj.setColor(new Color(0xE3E3E3));
                obj.fillRoundRect(30, 390, 290, 90, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(30, 390, 290, 90, 15, 15);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 18));
                obj.drawString("Crea una contraseña", 60, 420);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/19_hashtag.png"))
                        .getImage(), 294, 396, this);

                obj.setColor(Color.white);
                obj.fillRoundRect(55, 428, 198, 36, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(55, 428, 198, 36, 15, 15);

                obj.setColor(Color.white);
                obj.fillRoundRect(258, 428, 36, 36, 15, 15);
                obj.setColor(Color.lightGray);
                obj.drawRoundRect(258, 428, 36, 36, 15, 15);
            }
        };
        background.setBounds(0, 0, winWidth, winHeight);
        add(background);
    }

    // Objects & Variables

    private final int winWidth = 350;
    private final int winHeight = 550;

    public int xMouse, yMouse;

    private char echo = ' ';

    private Color colorBtnAdd = new Color(0x0074ff);
    private Color colorBtnBack = new Color(0xE9E8EE);

    Fonts font = new Fonts();

    // Swing components

    JPanel background, btnAdd, panelTop, btnBack;

    JTextField field1, field2, field3;

    JPasswordField field4;

    JRadioButton btnEye;

} // class

class Done extends JFrame {

    public Done() {

        StackBodyMessage();
        this.setSize(winWidth, winHeight);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setTitle("OK");
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
                obj.setFont(font.QuicksandB(0,16));
                obj.drawString("OK", 86,23);
            }
        };
        btnOkey.setBounds(33,110,194,35);
        btnOkey.addMouseListener(new MouseAdapter(){

            @Override public void mouseClicked(MouseEvent var) {

                dispose();
                new ViewFilter()
                            .setVisible(true);
                
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
                obj.drawString("Registro exitoso", 55, 35);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/32_done.png"))
                        .getImage(), 44, 56, this);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 14));
                obj.drawString("Usuario agregado", 85, 69);
                obj.drawString("a la base de datos", 85, 85);
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

class Wrong extends JFrame {

    public Wrong() {

        StackBodyMessage();
        this.setSize(winWidth, winHeight);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setTitle("Error de registro");
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
                obj.setFont(font.QuicksandB(0,16));
                obj.drawString("OK", 86,23);
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
                obj.drawString("Error al registrar", 57, 35);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewRegister/32_wrong.png"))
                                .getImage(), 44, 56, this);

                obj.setColor(Color.black);
                obj.setFont(font.QuicksandM(0, 14));
                obj.drawString("Revisa que todos", 85, 62);
                obj.drawString("los campos sean", 85, 78);
                obj.drawString("correctos", 85, 92);
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
