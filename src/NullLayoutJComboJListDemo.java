import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class NullLayoutJComboJListDemo extends JFrame implements ActionListener, ListSelectionListener, KeyListener {

    private JComboBox<Language> comboBox;
    private JList<String> countryList;
    private DefaultListModel<String> listModel;


    public NullLayoutJComboJListDemo( ) {

        super("Null Layout with JCombo and JList Demo");

        setLayout(null);

        createJComboBox();

        createJList();

        add(comboBox);

        add(countryList);

        add(new JScrollPane(countryList));

        setSize(450,400 );
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main( String[] args ) {
        NullLayoutJComboJListDemo frame = new NullLayoutJComboJListDemo();
    }


    private void createJComboBox(){

        ArrayList<Language> languages = new ArrayList<Language>();

        languages.add(new Language(1,"English"));
        languages.add(new Language(2,"French"));
        languages.add(new Language(3,"Spanish"));
        languages.add(new Language(4,"Japanese"));
        languages.add(new Language(5,"Chinese"));

        comboBox = new JComboBox<Language>(languages.toArray(new Language[]{}));

        comboBox.addItem(new Language(6,"Polish"));
        comboBox.addItem(new Language(7,"Russian"));

        comboBox.addActionListener(this);

        comboBox.setToolTipText("A combo-box to allow you select languages");

        comboBox.setBackground(Color.WHITE);

        comboBox.addKeyListener(this);

        comboBox.setFont(new Font("serif", Font.BOLD, 11));

        comboBox.setMaximumRowCount(4);

        comboBox.setSelectedIndex(0);

        comboBox.setBounds(180,60,230,20);

    }


    private void createJList(){
        listModel = new DefaultListModel<>();

        listModel.addElement("Ireland");
        listModel.addElement("United Kingdom");
        listModel.addElement("France");
        listModel.addElement("Portugal");
        listModel.addElement("Spain");
        listModel.addElement("Switzerland");
        listModel.addElement("Italy");
        listModel.addElement("Norway");

        countryList = new JList<>(listModel);

        countryList.addListSelectionListener(this);

        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        countryList.setBounds(40,60,80,120);
    }


    public void actionPerformed(ActionEvent e) {

        JComboBox<Language> combo = (JComboBox<Language>) e.getSource();

        Language selectedLanguage = (Language) combo.getSelectedItem();

        if(comboBox.getItemCount()>0)
            if (selectedLanguage.getName().equals("Spanish"))
                JOptionPane.showMessageDialog(null,"Buenos Dias!",
                        "Greetings in " + selectedLanguage.getName(),JOptionPane.INFORMATION_MESSAGE);
            else if (selectedLanguage.getName().equals("French"))
                JOptionPane.showMessageDialog(null,"Bonjour!",
                        "Greetings in " + selectedLanguage.getName(),JOptionPane.INFORMATION_MESSAGE);
            else if(selectedLanguage.getName().equals("Japanese")) {
                JOptionPane.showMessageDialog(null,"Removed Japanese from the combo-box",
                        "Language Removed",JOptionPane.INFORMATION_MESSAGE);
                combo.removeItem(selectedLanguage);
            }
    }

    public void valueChanged(ListSelectionEvent e) {

        String allCountriesSelected="";
        ArrayList<String> selectedValuesList;

        if(!countryList.isSelectionEmpty()) {
            selectedValuesList = (ArrayList<String>) countryList.getSelectedValuesList();

            for (String s : selectedValuesList) {
                allCountriesSelected += s + "\n";
            }

            JOptionPane.showMessageDialog(null, "Countries selected were:\n\n" +
                    allCountriesSelected, "Countries Picked", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public void keyTyped(KeyEvent e) {

        int comboBoxSize = comboBox.getItemCount();
        JOptionPane.showMessageDialog(null,"There are " + comboBoxSize + " items in this combo-box",
                "Item Count",JOptionPane.INFORMATION_MESSAGE);

        if(e.getKeyChar()>'0' && e.getKeyChar()<= '0' + comboBoxSize){
            int charAsNum = Character.getNumericValue(e.getKeyChar());
            JOptionPane.showMessageDialog(null,"Item selected was: " + comboBox.getItemAt(charAsNum-1),
                    "Language Picked",JOptionPane.INFORMATION_MESSAGE);
        }

    }


    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_C)
            comboBox.removeAllItems();


    }


    public void keyReleased(KeyEvent e) {

        comboBox.setBackground(Color.GREEN);
        getContentPane().setBackground(Color.yellow);

    }
}