// by:: { valencia_arcega }
package views;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

import java.awt.*;
import java.awt.event.*;

import views.resource.Fonts;


public class ViewHome extends JFrame {

    public ViewHome() {
        ColorsCustom();
        Days();
        Subjects();
        Appearance();
        Structure();

        this.setSize(winWidht, winHeight);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(false);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setTitle("Mi Schedule");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()
                                 .getResource("/assets/img/64-icon-app.png")));
    }

    void Days() {

        pTitle = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setColor(black);
                obj.setFont(font.QuicksandM(0,36));
                obj.drawString(title, 0, 30);
            }
        };
        pTitle.setBounds(280, 70, 350, 38);
        pTitle.setVisible(false);
        add(pTitle);

        // Day 1:
        pActiveMon = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(active);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-monday-active.png"))
                                                    .getImage(), 20, 10, this);

                obj.setColor(Color.black);
                obj.setFont(Quicksand17);
                obj.drawString("Lunes", 55, 25);
            }
        };
        pActiveMon.setBounds(40, 270, 150, 40);
        pActiveMon.setVisible(false);
        add(pActiveMon);

        pMon = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cMon);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-monday.png"))
                                                    .getImage(), 20, 10, this);
                
                obj.setColor(Color.gray);
                obj.setFont(Quicksand17);
                obj.drawString("Lunes", 55, 25);
            }
        };
        pMon.setBounds(40, 270, 150, 40);
        pMon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // the original goes and others comes
                pMon.setVisible(false);
                pTue.setVisible(true);
                pWed.setVisible(true);
                pThu.setVisible(true);
                pFri.setVisible(true);

                // the active comes and the others out
                pActiveMon.setVisible(true);
                pActiveTue.setVisible(false);
                pActiveWed.setVisible(false);
                pActiveThu.setVisible(false);
                pActiveFri.setVisible(false);

                // titles
                title = "Lunes";
                pTitle.setVisible(false);
                pTitle.setVisible(true);

                // enable the subjects for this day (bounds & visible)
                SO.setBounds(260, 150, 650, 90);
                hSO = "7am - 9am";
                SO.setVisible(true);

                LA.setBounds(260, 260, 650, 90);
                hLA = "9am - 11am";
                LA.setVisible(true);

                BD.setBounds(260, 370, 650, 90);
                hBD = "11am - 1pm";
                BD.setVisible(true);

                // turn off the others subjects
                RD.setVisible(false);
                LI.setVisible(false);
                TT.setVisible(false);
                IS.setVisible(false);
                IN.setVisible(false);
                IG.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                cMon = new Color(0x333A3D);
                pMon.setVisible(false);
                pMon.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                cMon = new Color(0x505D61);
                pMon.setVisible(false);
                pMon.setVisible(true);
            }
        });
        add(pMon);

        // Day 2:
        pActiveTue = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(active);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-tuesday-active.png")).getImage(), 20, 10, this);

                obj.setColor(Color.black);
                obj.setFont(Quicksand17);
                obj.drawString("Martes", 55, 25);
            }
        };
        pActiveTue.setBounds(40, 325, 150, 40);
        pActiveTue.setVisible(false);
        add(pActiveTue);

        pTue = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cTue);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-tuesday.png")).getImage(), 20, 10, this);

                obj.setColor(Color.gray);
                obj.setFont(Quicksand17);
                obj.drawString("Martes", 55, 25);
            }
        };
        pTue.setBounds(40, 325, 150, 40);
        pTue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                cTue = new Color(0x333A3D);
                pTue.setVisible(false);
                pTue.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                cTue = new Color(0x505D61);
                pTue.setVisible(false);
                pTue.setVisible(true);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                // the original goes and the other comes
                pTue.setVisible(false);
                pMon.setVisible(true);
                pWed.setVisible(true);
                pThu.setVisible(true);
                pFri.setVisible(true);

                // the active comes & turn off the others
                pActiveMon.setVisible(false);
                pActiveTue.setVisible(true);
                pActiveWed.setVisible(false);
                pActiveThu.setVisible(false);
                pActiveFri.setVisible(false);

                // titles
                title = "Martes";
                pTitle.setVisible(false);
                pTitle.setVisible(true);

                // enable the subjects for this day (bounds & visible)
                SO.setBounds(260, 150, 650, 90);
                hSO = "7am - 9am";
                SO.setVisible(true);

                IN.setBounds(260, 260, 650, 90);
                hIN = "10am - 11am";
                IN.setVisible(true);

                LA.setBounds(260, 370, 650, 90);
                hLA = "11am - 2pm";
                LA.setVisible(true);

                // out the others
                RD.setVisible(false);
                BD.setVisible(false);
                TT.setVisible(false);
                IG.setVisible(false);
                IS.setVisible(false);
                LI.setVisible(false);
            }
        });
        add(pTue);

        // Day 3
        pActiveWed = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                obj.setPaint(active);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-wednesday-active.png")).getImage(), 20, 10, this);

                obj.setColor(Color.black);
                obj.setFont(Quicksand17);
                obj.drawString("Miercoles", 55, 25);
            }
        };
        pActiveWed.setBounds(40, 380, 150, 40);
        pActiveWed.setVisible(false);
        add(pActiveWed);

        pWed = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cWed);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-wednesday.png")).getImage(), 20, 10, this);

                obj.setColor(Color.gray);
                obj.setFont(Quicksand17);
                obj.drawString("Miercoles", 55, 25);
            }
        };
        pWed.setBounds(40, 380, 150, 40);
        pWed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                cWed = new Color(0x333A3D);
                pWed.setVisible(false);
                pWed.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                cWed = new Color(0x505D61);
                pWed.setVisible(false);
                pWed.setVisible(true);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // the original goes and the other comes
                pMon.setVisible(true);
                pTue.setVisible(true);
                pWed.setVisible(false);
                pThu.setVisible(true);
                pFri.setVisible(true);
                // the active comes & turn off the others
                pActiveMon.setVisible(false);
                pActiveTue.setVisible(false);
                pActiveWed.setVisible(true);
                pActiveThu.setVisible(false);
                pActiveFri.setVisible(false);
                // titles
                title = "Miercoles";
                pTitle.setVisible(false);
                pTitle.setVisible(true);

                // enable the subjects for this day (bounds & visible)
                RD.setBounds(260, 130, 650, 90);
                hRD = "7am - 9am";
                RD.setVisible(true);

                IN.setBounds(260, 240, 650, 90);
                hIN = "9am - 12pm";
                IN.setVisible(true);

                TT.setBounds(260, 350, 650, 90);
                hTT = "1pm - 2pm";
                TT.setVisible(true);

                IS.setBounds(260, 460, 650, 90);
                hIS = "2pm - 4pm";
                IS.setVisible(true);

                // turn of the others
                SO.setVisible(false);
                LA.setVisible(false);
                BD.setVisible(false);
                IG.setVisible(false);
                LI.setVisible(false);
            }
        });
        add(pWed);

        // Day 4
        pActiveThu = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(active);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-thursday-active.png")).getImage(), 20, 10, this);

                obj.setColor(Color.black);
                obj.setFont(Quicksand17);
                obj.drawString("Jueves", 55, 25);
            }
        };
        pActiveThu.setBounds(40, 435, 150, 40);
        pActiveThu.setVisible(false);
        add(pActiveThu);

        pThu = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cThu);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-thursday.png")).getImage(), 20, 10, this);

                obj.setColor(Color.gray);
                obj.setFont(Quicksand17);
                obj.drawString("Jueves", 55, 25);
            }
        };
        pThu.setBounds(40, 435, 150, 40);
        pThu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                cThu = new Color(0x333A3D);
                pThu.setVisible(false);
                pThu.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                cThu = new Color(0x505D61);
                pThu.setVisible(false);
                pThu.setVisible(true);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // the original goes
                pMon.setVisible(true);
                pTue.setVisible(true);
                pWed.setVisible(true);
                pThu.setVisible(false);
                pFri.setVisible(true);
                // the active push in
                pActiveMon.setVisible(false);
                pActiveTue.setVisible(false);
                pActiveWed.setVisible(false);
                pActiveThu.setVisible(true);
                pActiveFri.setVisible(false);
                // titles
                title = "Jueves";
                pTitle.setVisible(false);
                pTitle.setVisible(true);

                // enable the subjects for this day (bounds & visible)
                IG.setBounds(260, 150, 650, 90);
                hIG = "9am - 11am";
                IG.setVisible(true);

                IS.setBounds(260, 260, 650, 90);
                hIS = "11am - 1pm";
                IS.setVisible(true);

                LI.setBounds(260, 370, 650, 90);
                hLI = "1pm - 3pm";
                LI.setVisible(true);

                // turn off the others
                BD.setVisible(false);
                SO.setVisible(false);
                LA.setVisible(false);
                RD.setVisible(false);
                IN.setVisible(false);
                TT.setVisible(false);
            }
        });
        add(pThu);

        // Day 5
        pActiveFri = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(active);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-friday-active.png")).getImage(), 20, 10, this);

                obj.setColor(Color.black);
                obj.setFont(Quicksand17);
                obj.drawString("Viernes", 55, 25);
            }
        };
        pActiveFri.setBounds(40, 490, 150, 40);
        pActiveFri.setVisible(false);
        add(pActiveFri);

        pFri = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cFri);
                obj.fillRoundRect(0, 0, 150, 40, 20, 20);

                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-friday.png")).getImage(), 20, 10, this);

                obj.setColor(Color.gray);
                obj.setFont(Quicksand17);
                obj.drawString("Viernes", 55, 25);
            }
        };
        pFri.setBounds(40, 490, 150, 40);
        pFri.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                cFri = new Color(0x333A3D);
                pFri.setVisible(false);
                pFri.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {

                cFri = new Color(0x505D61);
                pFri.setVisible(false);
                pFri.setVisible(true);
            }
            @Override
            public void mouseClicked(MouseEvent e) {

                pMon.setVisible(true);
                pTue.setVisible(true);
                pWed.setVisible(true);
                pThu.setVisible(true);
                pFri.setVisible(false);

                pActiveMon.setVisible(false);
                pActiveTue.setVisible(false);
                pActiveWed.setVisible(false);
                pActiveThu.setVisible(false);
                pActiveFri.setVisible(true);

                // titles
                title = "Viernes";
                pTitle.setVisible(false);
                pTitle.setVisible(true);

                // enable the subjects for this day (bounds & visible)
                IG.setBounds(260, 150, 650, 90);
                hIG = "7am - 10am";
                IG.setVisible(true);

                BD.setBounds(260, 260, 650, 90);
                hBD = "10am - 1pm";
                BD.setVisible(true);

                LI.setBounds(260, 370, 650, 90);
                hLI = "1pm - 3pm";
                LI.setVisible(true);

                // turn off the others
                LA.setVisible(false);
                RD.setVisible(false);
                TT.setVisible(false);
                IN.setVisible(false);
                IS.setVisible(false);
                SO.setVisible(false);
            }
        });
        add(pFri);
    }

    void ColorsCustom() {

        iSelector = new JLabel();
        iSelector.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-colorChooser.png")));
        iSelector.setBounds(122, 150, 20, 20);
        iSelector.setVisible(true);
        iSelector.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                ChooserL.setVisible(true);
                iSelectorC.setVisible(true);
                iSelector.setVisible(false);
            }
        });
        add(iSelector);

        iSelectorC = new JLabel();
        iSelectorC.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-btn-close.png")));
        iSelectorC.setBounds(122, 150, 20, 20);
        iSelectorC.setVisible(false);
        iSelectorC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                ChooserL.setVisible(false);
                iSelectorC.setVisible(false);
                iSelector.setVisible(true);
            }
        });
        add(iSelectorC);

        ChooserL = new JColorChooser();
        ChooserL.setBounds(25, 178, 430, 110);
        ChooserL.setVisible(false);
        ChooserL.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] panels = ChooserL.getChooserPanels();
        for (AbstractColorChooserPanel accp : panels) {
            if (!accp.getDisplayName().equals("Swatches")) { ChooserL.removeChooserPanel(accp); } //HSV, Swatches
        }
        ChooserL.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                cState = ChooserL.getColor(); repaint();
            }
        });
        add(ChooserL);
        /*
         * for(AbstractColorChooserPanel p:panels){
         * String displayName = p.getDisplayName();
         * switch (displayName) {
         * case "RGB":
         * Chooser.removeChooserPanel(p);
         * break;
         * case "HSL":
         * Chooser.removeChooserPanel(p);
         * break;
         * case "CMYK":
         * Chooser.removeChooserPanel(p);
         * break;
         * }
         * }
         */
    }

    void Subjects() {

        // Lenguajes y Automatas I
        LA = new JPanel() {
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cLA);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Lenguajes Autómatas I", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Ovando Brito Luis Alberto", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hLA, 0, 50);
            }
        };
        LA.setVisible(false);
        add(LA);

        // Sistemas operativos
        SO = new JPanel() {
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cSO);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Sistemas Operativos II", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Camacho Campero Jose Luis", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hSO, 0, 50);
            }
        };
        SO.setVisible(false);
        add(SO);

        // Administracion de bases de datos
        BD = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cBD);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Bases de datos III", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Perez Torres Jose Roberto", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hBD, 0, 50);
            }
        };
        BD.setVisible(false);
        add(BD);

        // Taller de Investigacion
        IN = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cIN);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);
                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Taller de Investigación I", 110, 45);
                obj.setFont(QuickSand18);
                obj.drawString("Escobar Dominguez Oscar", 105, 75);
                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hIN, 0, 50);
            }
        };
        IN.setVisible(false);
        add(IN);

        // Redes de datos
        RD = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cRD);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Redes de datos", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Cu Lara Silvia Carina", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hRD, 0, 50);
            }
        };
        RD.setVisible(false);
        add(RD);

        // Tutoria
        TT = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cTT);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Tutoria", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Chazaro Garcia Dora Maria", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hTT, 0, 50);
            }
        };
        TT.setVisible(false);
        add(TT);

        // Fundamentos de ingenieria de software
        IS = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cIS);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Ing. Software", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Prado Oseguera Diana Marisol", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hIS, 0, 50);
            }
        };
        IS.setVisible(false);
        add(IS);

        IG = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cIG);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Ingles VI", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Hugo Talavera Padrastro Simon", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hIG, 0, 50);
            }
        };
        IG.setVisible(false);
        add(IG);

        LI = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cLI);
                obj.fillRoundRect(90, 0, 500, 90, 30, 30);

                obj.setColor(white);
                obj.setFont(QuickSand40);
                obj.drawString("Lenguajes de Interfaz", 110, 45);

                obj.setFont(QuickSand18);
                obj.drawString("Ovando Brito Luis Alberto", 105, 75);

                obj.setColor(black);
                obj.setFont(Quicksand12);
                obj.drawString(hLI, 0, 50);
            }
        };
        LI.setVisible(false);
        add(LI);
    }

    void Appearance() {

        iDark = new JLabel();
        iDark.setBounds(240, 10, 20, 20);
        iDark.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-btn-dark.png")));
        iDark.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // icon
                iLight.setVisible(true);
                iDark.setVisible(false);

                // background
                background = Color.black;repaint();

                // colors
                white = Color.black;
                black = Color.white;

                // SO :
                cSO = new Color(0xff969d);
                // LA :
                cLA = new Color(0x5d97f5);
                // BD :
                cBD = new Color(0xc18deb);
                // IN :
                cIN = new Color(0xfad464);
                // RD :
                cRD = new Color(0x2ab07a);
                // TT :
                cTT = new Color(0x9062cc);
                // IS :
                cIS = new Color(0x90e8d9);
                // IG :
                cIG = new Color(0x4488db);
                // LI :
                cLI = new Color(0xfa7fc2);
            }
        });
        add(iDark);

        iLight = new JLabel();
        iLight.setBounds(240, 10, 20, 20);
        iLight.setIcon(new ImageIcon(getClass().getResource("/assets/img/viewHome/20-btn-light.png")));
        iLight.setVisible(false);
        iLight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // .icon
                iLight.setVisible(false);
                iDark.setVisible(true);
                
                // .background
                background = Color.white; repaint();

                white = Color.white;
                black = Color.black;

                // SO :
                cSO = new Color(0xff5964);
                // LA :
                cLA = new Color(0x004cc7);
                // BD :
                cBD = new Color(0xab62e5);
                // IN :
                cIN = new Color(0xffcc33);
                // RD :
                cRD = new Color(0x16c96d);
                // TT :
                cTT = new Color(0x4c1691);
                // IS :
                cIS = new Color(0x6ab6a9);
                // IG :
                cIG = new Color(0x075cc4);
                // LI :
                cLI = new Color(0xba4585);
            }
        });
        add(iLight);
    }

    void Structure() {

        btnClose = new JPanel();
        btnClose.setBounds(20, 20, 13, 13);
        btnClose.setOpaque(false);
        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                System.exit(DO_NOTHING_ON_CLOSE);
            }
        });
        add(btnClose);

        btnMin = new JPanel();
        btnMin.setBounds(39, 20, 13, 13);
        btnMin.setOpaque(false);
        btnMin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                setState(JFrame.ICONIFIED);
            }
        });
        add(btnMin);

        btnReload = new JPanel();
        btnReload.setBounds(58, 20, 13, 13);
        btnReload.setOpaque(false);
        btnReload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                new ViewHome()
                            .setVisible(true);
                dispose();
            }
        });
        add(btnReload);

        pCircles = new JPanel() {
            @Override
            public void paint(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // .buttonClose
                obj.setColor(new Color(0xFF7070));
                obj.fillOval(0, 0, 13, 13);
                // .buttonMin
                obj.setColor(new Color(0xF9C10C));
                obj.fillOval(19, 0, 13, 13);
                // .buttonReload
                obj.setColor(new Color(0x00D522));
                obj.fillOval(38, 0, 13, 13);
            }
        };
        pCircles.setBounds(20, 20, 80, 20);
        pCircles.setOpaque(false);
        add(pCircles);

        Circle = new JLabel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;

                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(cState);
                obj.setStroke(new BasicStroke(4));
                obj.drawOval(7, 9, 67, 66);
            }
        };
        Circle.setBounds(70, 90, 80, 80);
        Circle.setOpaque(false);
        add(Circle);

        pTop = new JPanel();
        pTop.setBounds(0, 0, 900, 25);
        pTop.setOpaque(false);
        pTop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });
        pTop.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {

                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });
        add(pTop);

        panelBackground = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                Graphics2D obj = (Graphics2D) g;
                obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                obj.setPaint(background);
                obj.fillRoundRect(20, 0, winWidht-21, winHeight-1, 30, 30);

                obj.setPaint(cGeneral);
                obj.fillRoundRect(0, 0, 240, winHeight-1, 30, 30);

                obj.setColor(background);
                obj.fillRect(226, 0, 14, winHeight-1);

                // .imageUser
                obj.drawImage(new ImageIcon(getClass().getResource("/assets/img/viewHome/66-user.png")).getImage(), 80, 100, this);

                // .textWelcome
                obj.setColor(Color.white);
                obj.setFont(font.Hello(1, 28));
                obj.drawString("Hola Angel", 47, 205);
            }
        };
        panelBackground.setBounds(0, 0, winWidht, winHeight);
        panelBackground.setOpaque(false);
        add(panelBackground);

    }


    // Objects & Variables

    int xMouse, yMouse;
    int winWidht = 900;
    int winHeight = 600;

    // Fonts
    Fonts font = new Fonts();

    Font Quicksand12 = font.QuicksandM(1, 12); // Time
    Font Quicksand17 = font.QuicksandM(0, 17); // Days
    Font QuickSand40 = font.QuicksandM(0, 40); // subjects
    Font QuickSand18 = font.QuicksandM(0, 18);

    // Strings
    String title = "";

    // Strings per Subjects
    String hSO = "";
    String hLA = "";
    String hBD = "";
    String hIN = "";
    String hLI = "";
    String hRD = "";
    String hTT = "";
    String hIS = "";
    String hIG = "";

    // General colors
    Color cGeneral = new Color(0x3A4346);
    Color cState = Color.black;
    Color white = Color.white;
    Color black = Color.black;
    Color active = new Color(0xEEFF71);
    Color background = Color.white;

    // Colors per Day
    Color cMon = new Color(0x505D61);
    Color cTue = new Color(0x505D61);
    Color cWed = new Color(0x505D61);
    Color cThu = new Color(0x505D61);
    Color cFri = new Color(0x505D61);

    // Colors per Subjects
    Color cSO = new Color(0xff5964);
    Color cLA = new Color(0x004cc7);
    Color cBD = new Color(0xab62e5);
    Color cIN = new Color(0xffcc33);
    Color cRD = new Color(0x16c96d);
    Color cTT = new Color(0x4c1691);
    Color cIS = new Color(0x6ab6a9);
    Color cIG = new Color(0x075cc4);
    Color cLI = new Color(0xba4585);

    // Swing components
    JPanel panelBackground, pTop, pCircles, pMon, pTue, pWed, pThu, pFri, pActiveMon,
            pActiveTue, pActiveWed, pActiveThu, pActiveFri, pTitle, LA, SO, BD, IN, RD, LI, TT, IS, IG
            ,btnClose, btnReload, btnMin;

    JLabel iDark, iLight, iSelectorC, iSelector, Circle;

    JColorChooser ChooserL;

} // class
