package applications;

import utils.ArrayList;

import java.util.Random;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();

        Random randomGen = new Random();
        for (int i = 0; i < 12; i++) {
            nums.add(randomGen.nextInt());
        }

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }
}
