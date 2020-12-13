import javax.swing.*;
import java.awt.*;

public class RandomShapesAndColours extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int randomShape, randomFill, randomWidth, randomHeight,randomX,randomY,randomX2,randomY2;
        Color randomColour;

        for(int i=0;i<20;i++) {

            randomShape = (int)(Math.random()*3+1);
            randomColour = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
            randomFill =  (int)(Math.random()*2);
            randomWidth = (int)(Math.random()*48+3);
            randomHeight = (int)(Math.random()*48+3);
            randomX = (int)(Math.random()*490);
            randomY = (int)(Math.random()*490);
            randomX2 = (int)(Math.random()*490);
            randomY2 = (int)(Math.random()*490);


            g.setColor(randomColour);

            switch(randomShape){
                case 1:
                    if(randomFill==0)
                        g.drawOval(randomX,randomY,randomWidth,randomHeight);
                    else
                        g.fillOval(randomX,randomY,randomWidth,randomHeight);
                    break;

                case 2:
                    if(randomFill==0)
                        g.drawRect(randomX,randomY,randomWidth,randomHeight);
                    else
                        g.fillRect(randomX,randomY,randomWidth,randomHeight);
                    break;
                case 3:
                    randomX2 = (int)(Math.random()*490);
                    randomY2 = (int)(Math.random()*490);
                    g.drawLine(randomX,randomY,randomX2,randomY2);
            }
        }
    }
}
