package com.MultiThreading;

public class MazeProblem {
    public static int maze(int cr , int cc , int er , int ec){
        if (cr > er || cc > ec) {
            return 0; // out of bounds
        }
        if (cr == er && cc == ec) {
            return 1; // reached destination
        }
        return maze(cr+1, cc , er,ec) + maze(cr , cc+1 , er, ec);

    }

    public static void main(String[] args) {
        System.out.println(maze(1,1,4,4));
    }
}
