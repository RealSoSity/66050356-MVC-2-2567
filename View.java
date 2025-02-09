import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    //Component declaration
    private JTextField textField;
    private JButton ansButton;
    
    public View(){
        //Set-up Frame
        this.setTitle("Title");
        this.setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Set-up Component
        JPanel inputPanel = new JPanel();
        textField = new JTextField(30);
        ansButton = new JButton("Calculate");
        
        //Add component to inputPanel
        inputPanel.add(new JLabel("ID : "));
        inputPanel.add(textField);
        inputPanel.add(ansButton);



        //Add Component to Frame
        this.add(inputPanel, BorderLayout.NORTH);
    }
}
