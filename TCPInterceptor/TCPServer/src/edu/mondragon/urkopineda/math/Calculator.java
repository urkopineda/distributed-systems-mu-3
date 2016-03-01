package edu.mondragon.urkopineda.math;

/**
 * Created by urko on 1/03/16.
 */
public class Calculator {

    public static long gcd(long x, long y) {
        if ((x == 0) || (y == 0)) return x + y;
        return gcd(y, x % y);
    }

    public static long lcm(long x, long y) {
        return x * (y / gcd(x, y));
    }

}
