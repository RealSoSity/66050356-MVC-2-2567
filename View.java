import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    //Component declaration
        private JPanel inputPanel;
        private JTextField idField;
        private JComboBox<String> typeBox;
        private JTextField dateField;
        private JTextField vaccineField;
        private JCheckBox fireProofBox;
        private JTextField pollutionField;
        private JTextField flightField;
        private JButton addButton;
        private JButton reportButton;
        private DefaultTableModel tableModel;
    
    public View(){
        //Set-up Frame
        this.setTitle("Magic Pets Management");
        this.setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Set-up Component for GUI(View)
        inputPanel = new JPanel(new GridLayout(6, 2));
        idField = new JTextField();
        typeBox = new JComboBox<>(new String[]{"Phoenix", "Dragon", "Owl"});
        dateField = new JTextField();
        vaccineField = new JTextField();
        fireProofBox = new JCheckBox("Fire Proof Certificate (Phoenix)");
        pollutionField = new JTextField("Pollution Level (Dragon)");
        flightField = new JTextField("Flight Distance (Owl)");
        addButton = new JButton("Add Pet");

        inputPanel.add(new JLabel("ID:")); inputPanel.add(idField);
        inputPanel.add(new JLabel("Type:")); inputPanel.add(typeBox);
        inputPanel.add(new JLabel("Health Check Date:")); inputPanel.add(dateField);
        inputPanel.add(new JLabel("Vaccines:")); inputPanel.add(vaccineField);
        inputPanel.add(fireProofBox);
        inputPanel.add(pollutionField);
        inputPanel.add(flightField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying pets
        tableModel = new DefaultTableModel(new Object[]{"ID", "Type", "Health Check Date", "Vaccines", "Accepted"}, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button to show report
        reportButton = new JButton("Show Report");
        add(reportButton, BorderLayout.SOUTH);
    }

    //Get Input(String) from textField
    public String getIdField(){
        return idField.getText();
    }

    //AddActionListener to Button for make it can perform process
    public void addPetsActionListener(ActionListener ae){
        addButton.addActionListener(ae);
    }

    //AddActionListener to Report button
    public void reportActionListener(ActionListener ae){
        reportButton.addActionListener(ae);
    }

    //Getter get type
    public String getTypeSelected(){
        return typeBox.getSelectedItem().toString();
    }
    //Get Date
    public String getDate(){
        return dateField.getText();
    }

    //Get Vaccines
    public int getVaccineCount(){
        return Integer.parseInt(vaccineField.getText());
    } 

    //Show error or message
    public void showMessage(String e){
        JOptionPane.showMessageDialog(rootPane, e);
    }



    
}
