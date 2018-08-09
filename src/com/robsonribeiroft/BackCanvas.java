package com.robsonribeiroft;

import java.awt.*;

public class BackCanvas extends Canvas {

    public void paint(Graphics g){
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("background.jpg");
        g.drawImage(i, 500,500,this);
    }
}
