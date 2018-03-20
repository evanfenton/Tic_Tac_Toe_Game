import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientFrame extends JFrame{
    
    private JButton [] buttons;
    private JTextField messageBox, name, mark;
    private JPanel board, textBoxes;
    
    public ClientFrame(){
        super();
        setLayout(new GridLayout(1,2));
        
        buttons= new JButton[9];
        
        board= new JPanel();
        board.setLayout(new GridLayout(3,3));
        
        for(int i=0; i<9; i++){
            buttons[i]= new JButton();
            board.add(buttons[i]);
        }
        
        messageBox= new JTextField();
        name= new JTextField();
        mark= new JTextField();
        
        textBoxes= new JPanel();
        textBoxes.setLayout(new GridLayout(3,2));
        
        textBoxes.add(new JLabel("Game Messages"));
        textBoxes.add(messageBox);
        textBoxes.add(new JLabel("Name"));
        textBoxes.add(name);
        textBoxes.add(new JLabel("Mark"));
        textBoxes.add(mark);
        
        add(board);
        add(textBoxes);
        
        pack();
        setVisible(true);
        
    }
    
    public void registerListeners(ButtonListener [] b){
        
        for(int i=0; i<9; i++){
            buttons[i].addActionListener(b[i]);
        }
    }
    
    public void setButton(int bNum, char m){
        buttons[bNum].setText(String.valueOf(m));
        buttons[bNum].setEnabled(false);
    }
    
    public void setMessage(String msg){
        messageBox.setText(msg);
    }
    
    public String getName(boolean try_again){
        String n;
        
        if(try_again){
            n= JOptionPane.showInputDialog("Invalid entry, please try again:");
        }
        else{
            n= JOptionPane.showInputDialog("Enter your name:");
        }
        name.setText(n);
        return n;
    }
    
    public void setMark(char m){
        mark.setText(String.valueOf(m));
    }
    
    public char getMark(){
        return mark.getText().charAt(0);
    }
    
}
