package io.classwarfare;

import java.util.Random;

/**
 * Created by markhauenstein on 5/13/16.
 */
public class Dice {
    Random random = new Random();
    public int rolldie(){
       return (random.nextInt(5)+1);
    }
}
