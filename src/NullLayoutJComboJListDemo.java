import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class NullLayoutJComboJListDemo extends JFrame implements ActionListener, ListSelectionListener {

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

        setSize(400,400 );
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

        comboBox.setFont(new Font("serif", Font.BOLD, 11));

        comboBox.setMaximumRowCount(4);

        comboBox.setSelectedIndex(0);

        comboBox.setBounds(50,50,250,20);
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

        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        countryList.setBounds(90,150,100,100);
    }


    public void actionPerformed(ActionEvent e) {

        JComboBox<Language> combo = (JComboBox<Language>) e.getSource();

        Language selectedLanguage = (Language) combo.getSelectedItem();

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
        int index=0;
        if (!countryList.isSelectionEmpty()) {
            ArrayList<String> selectedValuesList =  (ArrayList<String>)countryList.getSelectedValuesList();
            JOptionPane.showMessageDialog(null,"Country selected was " +
                    selectedValuesList.get(0),"Country Picked",JOptionPane.INFORMATION_MESSAGE);

            index = countryList.getSelectedIndex();

            if(index!=-1) {
                listModel.remove(index);
                JOptionPane.showMessageDialog(null, selectedValuesList.get(0) + " was removed from JList"
                        , "Country Removed", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}