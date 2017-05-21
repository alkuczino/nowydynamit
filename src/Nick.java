import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Rafał on 24.04.2017.
 */
public class Nick extends MapElement {
    /**
     * Konstruktor elementu planszy
     *
     * @param x
     * @param y
     * @param id
     */

    String nick;
    public Nick(int x, int y,String nick, ElementID id) {
        super(x, y, id);
        this.nick=nick;
    }

    @Override
    public void update(LinkedList<MapElement> element) {

    }

    @Override
    public void render(Graphics g) {
        Font font = new Font("Comic Sans",Font.BOLD,35);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(this.nick,50,45);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
