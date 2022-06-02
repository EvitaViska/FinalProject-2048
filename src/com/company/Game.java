package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static List<GameObject> objects;

    public static boolean moving = false, hasMoved = true, somethingIsMoving = false;
    public  static int direction = 0;

    private Random random = new Random();


    public Game() {
        init();
    }


    public void init() {
        objects = new ArrayList<GameObject>();
        moving = false;
        hasMoved = true;
        somethingIsMoving = false;
        spawn();
    }


    public void update() {
        if (KeyBoard.keyUp(KeyEvent.VK_R)) {
            init();
        }

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update();
        }

        checkForValueIncrease();
        movingLogic();
    }


    private void checkForValueIncrease() {
        for (int i = 0; i < objects.size(); i++) {
            for (int j = 0; j < objects.size(); j++) {
                if (i == j) continue;
                if (objects.get(i).x == objects.get(j).x && objects.get(i).y == objects.get(j).y) {
                    objects.get(j).remove = true;
                    objects.get(i).value *= 2;
                    objects.get(i).createDesign();
                }
            }
        }

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).remove) objects.remove(i);
        }
    }


    private void spawn() {

    }


    private void movingLogic() {
        somethingIsMoving = false;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).moving) {
                somethingIsMoving = true;
            }
        }

        if (!somethingIsMoving) {
            moving = false;
            for (int i =0; i < objects.size(); i++) {
                objects.get(i).hasMoved = false;
            }
        }

        if (!moving && hasMoved) {
            spawn();
            hasMoved = false;
        }

        if (!moving && !hasMoved) {
            if (KeyBoard.keyDown(KeyEvent.VK_A)) {
                hasMoved = true;
                moving = true;
                direction = 0;
            }
        }
    }


    public void render() {
        Render.renderBackground();

        //something is not right
        Render.renderDesign(new Design(100, 100, 0xffffff00), 100, 100);

        for (int i = 0; i < Main.pixels.length; i++) {
            Main.pixels[i] = Render.pixels[i];
        }
    }


    public void renderText(Graphics2D g) {

    }

}
