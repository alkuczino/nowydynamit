import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import static java.lang.Math.abs;

/**
 * Klasa opisująca gracza
 * Created by Rafał on 01.04.2017.
 */

public class Player extends MapElement {



    ImageIcon player_up = new ImageIcon("src//player_up.png");
    ImageIcon player_down = new ImageIcon("src//player_down.png");
    ImageIcon player_left = new ImageIcon("src//player_left.png");
    ImageIcon player_right = new ImageIcon("src//player_right.png");
    Image player_upImg = player_up.getImage();
    Image player_downImg = player_down.getImage();
    Image player_leftImg = player_left.getImage();
    Image player_rightImg = player_right.getImage();
    Image currentDirection = player_rightImg;
    int width=40,height=40;
    private Handler handler;

    public Player(int x, int y, Handler handler, ElementID id) {
        super(x, y, id);
        this.handler=handler;
    }


    @Override
    public void update(LinkedList<MapElement> element) {
        Collision(element);
        x+=velX;
        y+=velY;

    }

    @Override
    public void render(Graphics g) {

        if(velX>0&&abs(velX)>abs(velY)){
        g.drawImage(player_rightImg,(int)x,(int)y,null);
        }
        else if (velX<0&&abs(velX)>abs(velY))
        {
            g.drawImage(player_leftImg,(int)x,(int)y,null);}

        else if (velY>0&&abs(velY)>abs(velX))
    {
        g.drawImage(player_downImg,(int)x,(int)y,null);
    }
        else if (velY<0&&abs(velY)>abs(velX))
        {
            g.drawImage(player_upImg,(int)x,(int)y,null);}

        else
                g.drawImage(player_upImg,(int)x,(int)y,null);



    }

    private void Collision (LinkedList<MapElement> element)
    {
        for (int i=0; i<handler.element.size();i++)
        {
            MapElement tmpElement = handler.element.get(i);
            if(tmpElement.getId() == ElementID.Wall||tmpElement.getId() == ElementID.Box)
            {
                if(getBoundsTop().intersects(tmpElement.getBounds())){
                    this.setY(y+5);

                    velX=0;
                    velY=0;

                }
                if(getBounds().intersects(tmpElement.getBounds())){
                    this.setY(y-5);

                    velX=0;
                    velY=0;

                }
                if(getBoundsRight().intersects(tmpElement.getBounds())){
                    this.setX(x-5);

                    velX=0;
                    velY=0;

                }
                if(getBoundsLeft().intersects(tmpElement.getBounds())){
                    this.setX(x+5);

                    velX=0;
                    velY=0;

                }
            }
        }
    }




    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)((int)x+(width/2)-((width/2)/2)),(int)y+(height/2),(int)width/2,(int)height/2);

    }
    public Rectangle getBoundsTop() {
        return new Rectangle((int)((int)x+(width/2)-((width/2)/2)),(int)y,(int)width/2,(int)height/2);

    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int)x+width-5,(int)y+5,(int)5,(int)height-10);

    }public Rectangle getBoundsLeft() {
        return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);

    }

}
