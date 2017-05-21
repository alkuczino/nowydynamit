/**
 * Created by Rafał on 01.04.2017.
 */


import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Klasa opisująca zwykłą podłogę
 */
public class Floor extends MapElement
{   int width=64,height=64;
    ImageIcon grass = new ImageIcon("src//grass.png");
    Image grassImg = grass.getImage();

    public Floor(int x, int y, ElementID id) {
        super(x, y, id);
    }

    @Override
    public void update(LinkedList<MapElement> element) {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(grassImg,(int)x,(int)y,null);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,(int)width,(int)height);

    }
}
