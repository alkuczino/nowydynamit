import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Rafał on 24.04.2017.
 */

/**
 * Klasa do testów
 */
public class Test extends MapElement{

    public Test(int x, int y, ElementID id){
        super(x,y,id);
    }
    @Override
    public void update(LinkedList<MapElement> element) {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
