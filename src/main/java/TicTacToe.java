package ttt;

import java.util.Random;


public class TicTacToe {

    TicTacToe() {

    }

    public String random() {
        Random r = new Random();
        return "#" + r.nextInt(10);
    }


    public static void main(String[] args) {
        System.out.println("GRADLE IS WORKING!");
    }
}
