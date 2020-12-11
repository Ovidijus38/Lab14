import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JMenuFrame extends JFrame implements ActionListener
{
    JMenu fileMenu;
    JMenu editMenu;
    JLabel response;

    public JMenuFrame() {

        super("Demonstrating Menus");

        setLayout(new GridBagLayout());

        // invoke some user-defined methods to create two menus (and their menu items)
        // this is done just to make the constructor shorter but is good programming practice
        createFileMenu();
        createEditMenu();

        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.yellow);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        response = new JLabel("Menu Tester" );
        add(response);

        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(250,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        JMenuFrame frame = new JMenuFrame();
    }

    // when a menu-item is clicked, response starts here
    public void actionPerformed(ActionEvent event) {
        String  menuName;
        menuName = event.getActionCommand();

        if (menuName.equals("Quit"))
            System.exit(0);
        else
            response.setText("Menu Item '" + menuName + "' is selected.");
    }

    //Creates File menu and its menu items
    private void createFileMenu( ) {
        JMenuItem    item;

        fileMenu = new JMenu("File");

        item = new JMenuItem("New");
        item.addActionListener( this );

        fileMenu.add( item );

        item = new JMenuItem("Open");
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save");
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save As");
        item.addActionListener( this );
        fileMenu.add( item );

        fileMenu.addSeparator(); //adds a horizontal separator line

        item = new JMenuItem("Quit");
        item.addActionListener( this );
        fileMenu.add( item );
    }

    //Creates Edit  menu and its menu items

    private void createEditMenu( ) {
        JMenuItem    item;

        editMenu = new JMenu("Edit");

        item = new JMenuItem("Cut");
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Copy");
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Paste");
        item.addActionListener( this );
        editMenu.add( item );
    }
}
