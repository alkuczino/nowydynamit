import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


/**
 * Created by Mońka on 2017-04-23.
 */
public class Menu extends JFrame {
    private JTextField item1;
    private JTextField item2;
    private JTextField item3;
    private JTextField item4;

    public Menu(){
        super("Dynablaster");
        setLayout(new FlowLayout());

        item1=new JTextField("Game");
        add(item1);

        item2=new JTextField("High scores");
        add(item2);

        item3=new JTextField("Help");
        add(item3);

        item4=new JTextField("Exit");
        add(item4);

        thehandler handler= new thehandler();
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);

    }
    private class thehandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
        String string= "";
            if (event.getSource() != item1)
                string = String.format("field1: %s", event.getActionCommand());
            JOptionPane.showMessageDialog(null, string);

        }
    }
}
