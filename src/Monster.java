/**
 * Created by Rafał on 01.04.2017.
 */
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import static java.lang.Math.abs;

/**
 * Klasa opisująca potwora
 */


public class Monster extends MapElement {
    int tmp = 0;
    double rand = 0;
    ImageIcon monster_up = new ImageIcon("src//monster.png");
    Image monster_upImg = monster_up.getImage();
    Image currentDirection = monster_upImg;
    int width = 40, height = 40;
    private Handler handler;

    public Monster(int x, int y, Handler handler, ElementID id) {
        super(x, y, id);
        this.handler = handler;
    }


    @Override
    public void update(LinkedList<MapElement> element) {
        this.monsterMove();
        Collision(element);
        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {

        if (velX > 0 && abs(velX) > abs(velY)) {
            g.drawImage(monster_upImg, (int) x, (int) y, null);
        } else if (velX < 0 && abs(velX) > abs(velY)) {
            g.drawImage(monster_upImg, (int) x, (int) y, null);
        } else if (velY > 0 && abs(velY) > abs(velX)) {
            g.drawImage(monster_upImg, (int) x, (int) y, null);
        } else if (velY < 0 && abs(velY) > abs(velX)) {
            g.drawImage(monster_upImg, (int) x, (int) y, null);
        } else
            g.drawImage(monster_upImg, (int) x, (int) y, null);


    }

    private void Collision(LinkedList<MapElement> element) {
        for (int i = 0; i < handler.element.size(); i++) {
            MapElement tmpElement = handler.element.get(i);
            if (tmpElement.getId() == ElementID.Wall || tmpElement.getId() == ElementID.Box) {
                if (getBoundsTop().intersects(tmpElement.getBounds())) {
                    this.setY(y + 5);

                    velX = 0;
                    velY = 0;

                }
                if (getBounds().intersects(tmpElement.getBounds())) {
                    this.setY(y - 5);

                    velX = 0;
                    velY = 0;

                }
                if (getBoundsRight().intersects(tmpElement.getBounds())) {
                    this.setX(x - 5);

                    velX = 0;
                    velY = 0;

                }
                if (getBoundsLeft().intersects(tmpElement.getBounds())) {
                    this.setX(x + 5);

                    velX = 0;
                    velY = 0;

                }
            }
        }
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) y + (height / 2), (int) width / 2, (int) height / 2);

    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) y, (int) width / 2, (int) height / 2);

    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) x + width - 5, (int) y + 5, (int) 5, (int) height - 10);

    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);

    }

    public void monsterMove() {
        Monster e = null;
        for (int i = 0; i < handler.element.size(); i++) {
            MapElement tmpElement = handler.element.get(i);
            if (tmpElement.getId() == ElementID.Monster) {
                e = (Monster) tmpElement;
            }
        }
        this.tmp++;
        if(this.tmp%25==0){
           this.rand = Math.random()*4;
        }

        if (rand < 1) {
            e.setVelX(3);
            for (int i = 0; i < handler.element.size(); i++) {
                MapElement tmpElement = handler.element.get(i);
                if (tmpElement.getId() == ElementID.Wall || tmpElement.getId() == ElementID.Box) {
                    if (getBoundsRight().intersects(tmpElement.getBounds())) {
                        double r = Math.random()*3;
                            this.rand = 1.5;

                    }
                }
            }
        }

            if (rand > 1 && rand < 2) {
                e.setVelX(-3);
                for (int i = 0; i < handler.element.size(); i++) {
                    MapElement tmpElement = handler.element.get(i);
                    if (tmpElement.getId() == ElementID.Wall || tmpElement.getId() == ElementID.Box) {
                        if (getBoundsLeft().intersects(tmpElement.getBounds())) {
                                this.rand = 0;




                        }
                    }
                }
            }
                if (rand > 2 && rand < 3) {
                    e.setVelY(3);

                        e.setVelX(-3);
                        for (int i = 0; i < handler.element.size(); i++) {
                            MapElement tmpElement = handler.element.get(i);
                            if (tmpElement.getId() == ElementID.Wall || tmpElement.getId() == ElementID.Box) {
                                if (getBounds().intersects(tmpElement.getBounds())) {

                                        this.rand = 3.5;



                            }}
                        }
                    }

                    if (rand > 3 && rand < 4) {
                        e.setVelY(-3);


                            for (int i = 0; i < handler.element.size(); i++) {
                                MapElement tmpElement = handler.element.get(i);
                                if (tmpElement.getId() == ElementID.Wall || tmpElement.getId() == ElementID.Box) {
                                    if (getBoundsTop().intersects(tmpElement.getBounds())) {
                                        this.rand =2.5;

                                }
                            }
                        }

                    }



        }}


