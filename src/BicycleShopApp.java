import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BicycleShopApp extends JFrame implements ActionListener {

    JMenu fileMenu, bikeMenu;
    JMenuItem item=null;

    public BicycleShopApp( ) {
        super("Bike Shop System");

        Container pane = getContentPane();
        pane.setBackground(new Color(250,150,69));

        createFileMenu();
        createBikeMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(bikeMenu);

        ImageIcon icon = new ImageIcon("D:\\OOP_Java\\Sem3Lab14\\Lab14\\bike.png");
        setIconImage(icon.getImage());

        setSize(400,400 );
        setVisible(true);
    }

    public static void main( String[] args ) {
        BicycleShopApp frame = new BicycleShopApp();
    }


    private void createFileMenu(){

        fileMenu = new JMenu("File");

        String[] itemNames = {"New","Open","Save","Quit"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            if(i==3)
                fileMenu.addSeparator();

            fileMenu.add(item);
        }
    }


    private void createBikeMenu(){

        bikeMenu = new JMenu("Bicycle");

        String[] itemNames = {"Add","Amend","Remove","View"};

        for (String itemName : itemNames) {

            item = new JMenuItem(itemName);
            item.addActionListener(this);
            bikeMenu.add(item);
        }
    }


    public void actionPerformed(ActionEvent e) {

        int choice;

        if(e.getActionCommand().equals("New"))
            JOptionPane.showMessageDialog(null,"Creating a new file to store bicycle details",
                    "New File",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Open"))
            JOptionPane.showMessageDialog(null,"Opening the file that stores bicycle details",
                    "Opening File",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Save"))
            JOptionPane.showMessageDialog(null,"Saving the file that stores bicycle details",
                    "Saving File",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Quit")) {
            choice = JOptionPane.showConfirmDialog(null, "Are you sure you wish to quit the application?",
                    "Exiting Application", JOptionPane.YES_NO_CANCEL_OPTION);

            if(choice==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"Saving the file that stores bicycle details before terminating",
                        "Saving File",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

        }
        else if(e.getActionCommand().equals("Add"))
            JOptionPane.showMessageDialog(null,"Adding new bicycle details",
                    "Adding Bike",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Amend"))
            JOptionPane.showMessageDialog(null,"Amending bicycle details",
                    "Amending Bike",JOptionPane.INFORMATION_MESSAGE);
        else if(e.getActionCommand().equals("Remove"))
            JOptionPane.showMessageDialog(null,"Removing bicycle details",
                    "Removing Bike",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"Viewing bicycle details",
                    "Viewing Bike",JOptionPane.INFORMATION_MESSAGE);
    }
}