import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsDemo extends JFrame implements ActionListener {

    private GraphicsPanel panel;

    public GraphicsDemo( ) {

        super("Graphics Demo");
        panel = new GraphicsPanel();
        add(panel,BorderLayout.CENTER);

        JButton jb = new JButton("Press Me!");
        jb.addActionListener(this);
        add(jb,BorderLayout.SOUTH);

        setSize(400,400 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main( String[] args ) {
        GraphicsDemo frame = new GraphicsDemo();
    }

    private void drawALine(){
        Graphics g = panel.getGraphics();

        g.setColor(Color.CYAN);
        g.drawLine(150,200,300,300);

        g.setColor(Color.BLACK);
        g.drawLine(160,220,320,320);
    }

    public void actionPerformed(ActionEvent e) {
        drawALine();

    }
}
