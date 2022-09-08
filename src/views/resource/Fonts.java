package views.resource;

import java.awt.*;
import java.io.*;

public class Fonts {

    Font H, QM, QR, QB;

    public Fonts() {
        
        try {

            InputStream f1 = getClass().getResourceAsStream("/assets/fonts/Hello.otf");
            H = Font.createFont(Font.TRUETYPE_FONT, f1);

            InputStream f2 = getClass().getResourceAsStream("/assets/fonts/Quicksand Medium.ttf");
            QM = Font.createFont(Font.TRUETYPE_FONT, f2);

            InputStream f3 = getClass().getResourceAsStream("/assets/fonts/Quicksand Regular.ttf");
            QR = Font.createFont(Font.TRUETYPE_FONT,f3);

            InputStream f4 = getClass().getResourceAsStream("/assets/fonts/Quicksand Bold.ttf");
            QB = Font.createFont(Font.TRUETYPE_FONT, f4);


        } catch(Exception ex) { }
    }

    
    public Font Hello(int style, int size) {
        Font a = H.deriveFont(style,size);
        return a;
    }
    
    public Font QuicksandM(int style, int size) {
        Font b = QM.deriveFont(style, size);
        return b;
    }
    
    public Font QuicksandR(int style, int size) {
        Font c = QR.deriveFont(style,size);
        return c;    
    }

    public Font QuicksandB(int style, int size) {
        Font d = QB.deriveFont(style,size);
        return d;
    }
}