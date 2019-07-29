package com.shekar.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortingComparator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }

    }
}

class Player {
    String name;
    Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score < b.score) {
            return 1;
        } else if (a.score > b.score) {
            return -1;
        } else {
            if (a.name.compareTo(b.name) < 1) {
                return -1;
            } else if(a.name.compareTo(b.name) >= 1) {
                return 1;
            }
        }
        return 0;
    }
}
