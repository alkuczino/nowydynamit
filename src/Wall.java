/**
 * Created by Rafał on 01.04.2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Klasa opisująca przeszkodę niemożliwą do zniszczenia
 */
public class Wall extends MapElement {
    int width=64,height=64;
    ImageIcon wall = new ImageIcon("src//stoneCenter.png");
    Image wallImg = wall.getImage();

    public Wall(int x, int y, ElementID id) {
        super(x, y, id);
    }

    @Override
    public void update(LinkedList<MapElement> element) {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(wallImg,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,(int)width,(int)height);

    }
}
