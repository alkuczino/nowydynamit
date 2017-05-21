import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Rafał on 24.04.2017.
 */
public class UpperWall extends MapElement {
    Configuration c;
    ImageIcon upperWall = new ImageIcon("src//gora.png");
    Image upperWallImg = upperWall.getImage();
    ImageIcon life = new ImageIcon("src//life.png");
    Image lifeImg = life.getImage();
    String nick;

    public UpperWall(int x, int y,Configuration c,String nick, ElementID id) {
        super(x, y, id);
        this.c=c;
        this.nick=nick;
    }

    @Override
    public void update(LinkedList<MapElement> element) {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(upperWallImg,(int)x,(int)y,null);
        Font font = new Font("Comic Sans",Font.BOLD,35);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(nick,50,45);
        g.drawString(c.getLifeNumber()+"x",c.getMapSize()*64-90,45);
        g.drawImage(lifeImg,c.getMapSize()*64-55,12,null);
        g.drawString("0p",250,45);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
