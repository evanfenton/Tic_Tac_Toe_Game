import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ButtonListener implements ActionListener{
    private int number;
    private ClientFrame frame;
    private PrintWriter socketOut;
    
    public ButtonListener(int n, ClientFrame cf, PrintWriter so){
        number= n;
        frame= cf;
        socketOut= so;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setButton(number, frame.getMark());
        socketOut.println(number);
    }
}
