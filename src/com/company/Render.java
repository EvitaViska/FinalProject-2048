package com.company;

public class Render {

    public static int width = Main.WIDTH, height = Main.HEIGHT;
    public static int[] pixels = new int[width * height];

    public static void renderBackground() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[x + y * width] = 0xfff4f4f4;

                if (x % 100 < 3 || x % 100 > 97 || y % 100 < 3 || y % 100 > 97) {
                    pixels[x + y * width] = 0xffcccccc;
                }
            }
        }
    }

    public static void renderDesign(Design design, int xp, int yp) {
        if (xp < -design.width || xp > width || yp < -design.height || yp > height) return;

        for (int y = 0; y < design.height; y++) {
            int yy = y +yp;
            if (yy < 0 || yy > height) continue;
            for (int x = 0; x < design.width; x++) {
                int xx = x + xp;
                if (xx < 0 || xx > width) continue;
                int color1 = design.pixels[x + y * design.width];
                if (color1 == 0xffff00ff) continue;
                else pixels[xx + yy * width] = color1;
            }
        }
    }

}
