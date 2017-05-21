import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 *
 * Created by Rafał on 24.04.2017.
 */

/**
 * Klasa przechowująca wszystkie obiekty znajdujące się na planszy
 */
public class Handler {
    protected Image currentDirection;


    /**
     * Lista obiektów
     */
    public LinkedList<MapElement> element = new LinkedList<MapElement>();
    /**
     * Pomocniczy element mapy
     */
    private MapElement tmpElement;

    /**
     * Metoda aktualizująca stan elementów na mapie
     */
    public void update() {
        for (int i = 0; i < element.size(); i++) {

            tmpElement = element.get(i);
            tmpElement.update(element);
        }

    }

    /**
     * Metoda służąca do renderowania elementów
     * @param g
     */
    public void render(Graphics g) {
        for (int i = 0; i < element.size(); i++) {

            tmpElement = element.get(i);
            tmpElement.render(g);
        }
    }

    /**
     * Metoda dodająca element do listy
     * @param element
     */
    public void addElement(MapElement element) {
        this.element.add(element);
    }

    /**
     * Metoda usuwająca element z listy
     * @param element
     */
    public void removeElement(MapElement element) {
        this.element.remove(element);
    }


    /**
     * Metoda tworząca górny panel
     * @param c
     */
    public void createUpperPanel(Configuration c, String nick){
        int pozX=0;
        int pozY=0;
        int[][]tmpMap=c.getMap1();
        for (int[] i :tmpMap)
        {
            tmpElement = new UpperWall(pozX,pozY,c,nick,ElementID.UpperWall);
            addElement(tmpElement);
            pozX+=64;

        }

        tmpElement= new Timer(c.getMapSize()*60,150,c,ElementID.Timer);

        addElement(tmpElement);






    }

    /**
     * Metoda generująca poziom na podstawie pliku konfiguracyjnego
     * @param c
     */
    public void createLevel(Configuration c)
    {
        int[][]tmpMap=c.getMap1();
        int pozX=0;
        int pozY=90;

        for (int[] index : tmpMap) {

            for (int i = 0; i < tmpMap.length; i++) {
                if (index[i] == 1) {
                    tmpElement = new Wall(pozX,pozY,ElementID.Wall);
                    addElement(tmpElement);
                } else if (index[i] == 0) {
                    tmpElement = new Floor(pozX,pozY,ElementID.Floor);
                    addElement(tmpElement);
                } else if (index[i] == 2) {
                    tmpElement = new Box(pozX,pozY,ElementID.Box);
                    addElement(tmpElement);
                }

                pozX += 64;
            }
            pozY += 64;
            pozX = 0;
        }}

    /**
     * Metoda dodająca gracza
     */
    public void addPlayer(){
        tmpElement = new Player(80,160,this,ElementID.Player);
        addElement(tmpElement);

    }
    public void addMonster(){
        tmpElement = new Monster(300,160,this,ElementID.Monster);
        addElement(tmpElement);
    }
}
