/**
 * Created by Rafał on 02.04.2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Klasa opisująca możliwą do zniszczenia przeszkodę
 */
public class Box extends MapElement {
    int width=60,height=60;
    ImageIcon box = new ImageIcon("src//box.png");
    Image boxImg = box.getImage();
    public Box(int x, int y, ElementID id) {
        super(x, y, id);
    }

    @Override
    public void update(LinkedList<MapElement> element) {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(boxImg,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,(int)width,(int)height);

    }}
