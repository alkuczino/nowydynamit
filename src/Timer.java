import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Rafał on 24.04.2017.
 */
public class Timer extends MapElement{


    String timeLeft;
    Configuration c;
    public Timer(int x, int y,Configuration c, ElementID id) {
        super(x, y, id);
        this.c=c;
        timeLeft = Integer.toString((int) c.getRoundTime());
    }


    @Override
    public void update(LinkedList<MapElement> element) {

    }

    @Override
    public void render(Graphics g) {
        Font font = new Font("Comic Sans",Font.BOLD,35);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(this.timeLeft,400,45);


    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }
}
