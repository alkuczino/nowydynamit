import javax.swing.*;

/**
 * Created by Mońka on 2017-04-23.
 */
public class Gamegame {
    public static void main(String[] args) {

        //MOJA Obsluga zdarzen
       /* Menu mainMenu = new Menu();

        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(350, 100);
        mainMenu.setVisible(true);

*/
        Configuration c = new Configuration();
        Gui go = new Gui(c);


        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(350, 100);
        go.setVisible(true);


    }
}
