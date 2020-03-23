package org.example;

import java.awt.*;

public class RegularPolygon extends Polygon  {
    /**
     *
     * @param x0
     * @param y0
     * @param radius
     * @param sides
     * fixeaza in fiecte de centul dat de coordonatele(x0,y0) , raza si nr de fete varfurile, figura ceruta
     */
    public RegularPolygon(int x0, int y0, int radius, int sides) {
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }

}
