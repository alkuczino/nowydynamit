/**
 * Created by Rafał on 01.04.2017.
 */

import java.awt.*;
import java.util.LinkedList;

/**
 * Klasa opisująca element planszy
 */
public abstract class MapElement {
    /**
     * Paremetry opisujące połóżenie elementu na planszy
     */
    protected double x,y;
    /**
     * Identyfikator obiektu
     */
    protected ElementID id;
    /**
     * Parametry opisujące prędkość obiektu w odpowiedniej osi
     */
    public int velX,velY;

    /**
     * Konstruktor elementu planszy
     * @param x
     * @param y
     * @param id
     */
    public MapElement(int x, int y, ElementID id){
        this.x=x;
        this.y=y;
        this.id=id;
    };

    /**
     * Metoda aktualizująca stan obiektu
     * @param element
     */
    public abstract void update(LinkedList<MapElement> element);

    /**
     * Metoda rysująca obiekt
     * @param g
     */
    public abstract void render(Graphics g);

    /**
     * Metoda służąca do obsługi kolizji
     * @return
     */
    public abstract Rectangle getBounds();


    /**
     * Getter położenia w osi X
     * @return
     */
    public double getX() {
        return x;
    }
    /**
     * Getter położenia w osi Y
     * @return
     */
    public double getY() {
        return y;
    }
    /**
     * Getter prędkości w osi X
     * @return
     */
    public double getVelX() {
        return velX;
    }
    /**
     * Getter prędkości w osi Y
     * @return
     */
    public double getVelY() {
        return velY;
    }
    /**
     * Setter położenia w osi X
     * @return
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Setter położenia w osi Y
     * @return
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Setter prędkości w osi X
     * @return
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }
    /**
     * Setter prędkości w osi Y
     * @return
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     * Getter identyfikatora elementu
     * @return
     */
    public ElementID getId() {
        return id;
    }


}
