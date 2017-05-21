import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;


import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
/**
 * Created by Rafał on 02.04.2017.
 */

/**
 * Główna klasa Gry
 */
public class Game extends Canvas implements Runnable//extends Application
    {
        public static String ip;
        public static int port;
        Handler handler;
        public static final long serialVersionUID = 1L;

        /**
         * Wątek gry
         */
        private Thread thread;
        /**
         * Zmienna sterująca wątkiem gry
         */
        private boolean running = false;
        /**
         * Główne okno
         */
        protected JFrame frame;
        /**
         * Obiekt klasy Configuration do wczytywania aktualnej konfiguracji gry
         */
        public Configuration x  ;



        public String nick= " ";

        /**
         *Metoda inicjalizująca
         */
        public void init(){

            handler = new Handler();
            handler.createLevel(x);
            handler.createUpperPanel(x,nick);
            handler.addPlayer();
            handler.addMonster();
            this.addKeyListener(new MyKeyListener(handler));
        }
        /**
         * Konstruktor obiektu klasy Game
         */
        public Game(String nick,Configuration x){
            Client.getMapSize(x,x.ip,Integer.toString(x.port));
            Client.getLevel(x,x.ip,Integer.toString(x.port));
            this.nick =nick;
            this.x  = x ;
            this.frame = new JFrame();
            this.frame.setResizable(false);
            this.frame.setTitle("DynaBlaster");
            this.frame.add(this);
            this.frame.pack();
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setLocationRelativeTo(null);
            this.frame.setVisible(true);

            /**
             * Wczytanie szerokości i wysokości na podstawie pliku konfiguracyjnego
             */
        int width = x.getMapSize()*64;
        int scale = 1;
        int heigth = 90+ x.getMapSize()*64;
        Dimension size = new Dimension(width*scale,heigth*scale);
        setPreferredSize(size);
        this.frame.setSize(size);

        }

        /**
         *  Główna pętla gry
         */
        public void run() {
            init();
            this.requestFocus();
            /**
             * FPS Counter
             */
            double ns = 1000000000.0 / 60.0;
            double delta = 0;

            int frames = 0;
            int updates = 0;

            long lastTime = System.nanoTime();
            long timer = System.currentTimeMillis();
            while (running){
                long now = System.nanoTime();

                delta += (now - lastTime) / ns;
                lastTime = now;

                while(delta >= 1) {
                    update();
                    updates++;
                    delta--;
                }
               render();
                frames++;

                if(System.currentTimeMillis() - timer >= 1000) {
                    timer += 1000;
                    frame.setTitle("DynaBlaster" + "  |  " + updates + " ups, " + frames + " fps");
                    frames = 0;
                    updates = 0;
                }
            }
        }
        public void update(){
            handler.update();

        }

        /**
         * Metoda służąca do renderowania obrazu i wyświetlania go na ekranie
         */
        public void render(){
                BufferStrategy bs = getBufferStrategy();
                if (bs==null) {
                    createBufferStrategy(2);
                    return;
                }
                Graphics g = bs.getDrawGraphics();

                handler.render(g);
                g.dispose();
                bs.show();


        }

        /**
         * Metoda uruchamiająca wątek gry
         */
        public synchronized void start(){
            running = true;
            thread = new Thread(this,"Display");
            thread.start();
        }

        /**
         * Metoda zatrzymująca wątek gry
         */
        public void stop(){
            running = false;
            try{
                thread.join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }}}

