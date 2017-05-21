import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Created by Mońka on 2017-04-23.
 */

/**
 * Interfejs graficzny
 */
public class Gui extends JFrame {
    private JButton game;
    private JButton highScores;
    private JButton help;
    private JButton exit;
    public Configuration c;
    public Gui(Configuration c ){
        super("Dynablaster");

        setLayout(new FlowLayout());
        this.c = c;
        game=new JButton("Game");
        add(game);

        highScores= new JButton("High Scores");
        add(highScores);

        help= new JButton("Help");
        add(help);

        exit= new JButton("Exit");
        add(exit);

        HandlerClass handler= new HandlerClass();
        help.addActionListener(handler);

        HandlerClass1 handler1 = new HandlerClass1();
        highScores.addActionListener(handler1);

        HandlerClass2 handler2 = new HandlerClass2();
        HandlerClass3 handler3= new HandlerClass3();
        exit.addActionListener(handler3);
        game.addActionListener(handler2);



    }

    private class HandlerClass implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, String.format("Celem gry jest zniszczenie przeciwników \n" +
                    "za pomocą bomb oraz odnalezienie drzwi \n" +
                    "do następnego poziomu. Trudność wzrasta\n" +
                    " wraz ze zwiększaniem się poziomu. W czasie\n" +
                    " gry gracz może napotkać ukryte w cegiełkach\n" +
                    " dodatki ułatwiające wysadzenie przeciwników\n" +
                    " (np. dodatkowe bomby, szybsze bieganie).", event.getActionCommand()));
        }
    }

    private class HandlerClass1 implements ActionListener{
        public void actionPerformed(ActionEvent event){



            JOptionPane.showMessageDialog(null,c.getHighScoreNames()[0] +"   " + c.getPoints()[0]);
        }
    }
    private class HandlerClass2 implements ActionListener{
        public void actionPerformed(ActionEvent event){
            setVisible(false);

            Object[] options = {"Easy","Medium","Hard"};
                    int choice = JOptionPane.showOptionDialog(null,"Easy, medium or hard","Choose difficulty",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
                switch (choice) {

                    case 0:
                        JOptionPane.showMessageDialog(null, "You chose:" + "Easy");
                        break;

                    case 1:
                    JOptionPane.showMessageDialog(null, "You chose:" + "Medium");
                    break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "You chose:" + "Hard");
                        break;
                }
            String nick= JOptionPane.showInputDialog("Enter your nick");
            JOptionPane.showMessageDialog(null, "Your nick is:" + nick);
           Nick nick1   =   new Nick(0,0,nick,ElementID.Nick);
            Game game = new Game(nick,c);
            game.start();

        }
    }
    private class HandlerClass3 implements ActionListener{
        public void actionPerformed(ActionEvent event){

            System.exit(0);
        }
    }
}
