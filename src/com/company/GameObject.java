package com.company;

import java.util.Random;


public class GameObject {

    public double x, y;
    public int width, height;
    public Design design;
    public int value, speed = 8;
    public boolean moving = false, remove = false, hasMoved = false;

    Random random = new Random();

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
        //this gives 50/50 chance to set value as 2 or 4 but it has to be 10% chance for 4 and 90% chance for 2
        this.value = (random.nextBoolean() ? 2 : 4);
        createDesign();
        this.width = design.width;
        this.height = design.height;
    }


    public void createDesign() {

    }


    public void update() {
    }


    public void render() {
        Render.renderDesign(design, (int) x, (int) y);
    }

}
