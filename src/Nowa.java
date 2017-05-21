/**
 * Created by Mońka on 2017-03-20.
 *//*


*/
/*import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.image.Image;*//*


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class Nowa extends Canvas implements Runnable//extends Application
{
    private Thread thread;
    private boolean running = false;
    private JFrame frame;

    public void run() {
    while (running){}
    }
    public static void main (String[] args)

    {





    }
    public void start(Stage theStage)
    {
        theStage.setTitle( "DynaBlaster" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 780, 780 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

       */
/* gc.setFill( Color.RED );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "Hello, World!", 60, 50 );
        gc.strokeText( "Hello, World!", 60, 50 );*//*
*/
/*

        Configuration x  = new Configuration();
        x.loadConfiguration();
        int[][] nowaMapa=x.getMap1();
        int pozX=0;
        int pozY=0;
        for (int[] index : nowaMapa)
        {
            for(int i=0;i<nowaMapa.length;i++) {

                Image stone = new Image("stoneCenter.png");
                Image ground = new Image("grass.png");
                Image box = new Image("box.png");
                if (index[i] == 1) {
                    gc.drawImage(stone, pozX, pozY);
                }
                else if(index[i] == 0) {
                    gc.drawImage(ground, pozX, pozY);
                }
                else if(index[i]==2){
                    gc.drawImage(box,pozX,pozY);
                }

                pozX+=60;
            }
            pozY+=60;
            pozX=0;

        }



        //Image earth = new Image( "stoneCenter.png" );
        //gc.drawImage( earth, 0, 0 );

        theStage.show();
    }*//*

}

*/
