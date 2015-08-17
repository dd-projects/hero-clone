package com.heroclone.api.helper;

import java.util.Random;

public class RandomHelper {
    private static Random rand = new Random();
    public static int randInt(int min, int max) {
        int ret = rand.nextInt((max - min) + 1) + min;
        return ret;
    }
}
