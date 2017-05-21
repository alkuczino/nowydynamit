import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Rafał on 23.04.2017.
 */
class MyKeyListener extends KeyAdapter {
    Handler handler;

    public MyKeyListener(Handler handler){
        this.handler=handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key==KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
        for (int i=0;i<handler.element.size();i++){
            MapElement tmpElement=handler.element.get(i);
                if(tmpElement.getId()==ElementID.Player)
                {
                    if(key==KeyEvent.VK_D) tmpElement.setVelX(5);
                    if(key==KeyEvent.VK_A) {
                        tmpElement.setVelX(-5);
                    }
                    if(key==KeyEvent.VK_W) tmpElement.setVelY(-5);
                    if(key==KeyEvent.VK_S) tmpElement.setVelY(5);



        }



        }



    }

    //@Override
    /*public void keyPressed(KeyEvent e) {/*
                int key = e.getKeyCode();
                    if (key == KeyEvent.VK_W){
                        velY=2;
                    }
                else if (key == KeyEvent.VK_S){
                    velY=-2;
                }
                    else if (key == KeyEvent.VK_A){
                        velX=2;
                    }
                    else if (key == KeyEvent.VK_D){
                        velX=-2;
                    }*/
  //  }

    //@Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i=0;i<handler.element.size();i++){
            MapElement tmpElement=handler.element.get(i);
            if(tmpElement.getId()==ElementID.Player)
            {
                if(key==KeyEvent.VK_D) tmpElement.setVelX(0);
                if(key==KeyEvent.VK_A) tmpElement.setVelX(0);
                if(key==KeyEvent.VK_W) tmpElement.setVelY(0);
                if(key==KeyEvent.VK_S) tmpElement.setVelY(0);



            }


    }
}}



