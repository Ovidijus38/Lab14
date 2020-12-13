import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RandomGraphicsTest extends JFrame {

    private RandomShapesAndColours panel;

    public RandomGraphicsTest( ) {

        super("Random Graphics");
        panel = new RandomShapesAndColours();
        add(panel,BorderLayout.CENTER);

        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){

                if(e.getKeyCode()==KeyEvent.VK_SPACE)
                    repaint();

                if(e.getKeyCode()==KeyEvent.VK_T)
                {
                    panel.setFocusable(true);
                    setSize(300,300);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setVisible(true);
                    repaint();
                }

            }
        });

        panel.setFocusable(true);
        setSize(500,500 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main( String[] args ) {
        RandomGraphicsTest frame = new RandomGraphicsTest();
    }

    private void drawALine(){
        Graphics g = panel.getGraphics();

        g.setColor(Color.CYAN);
        g.drawLine(150,200,300,300);
    }

    public void actionPerformed(ActionEvent e) {
        drawALine();
    }
}
