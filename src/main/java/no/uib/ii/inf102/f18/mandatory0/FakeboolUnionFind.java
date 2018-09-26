package no.uib.ii.inf102.f18.mandatory0;//Created by ingridjohansen on 24.09.2018.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FakeboolUnionFind {

    public static int[] uArray;

    public static void main(String[] args) {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader scn = new BufferedReader(read);

        try{
            String[] list = scn.readLine().split(" ");
            int users = Integer.parseInt(list[0]);
            int N = Integer.parseInt(list[1]);

            // assign all users to point at there selvs
            uArray = new int[users];
            for (int i = 0; i < users; i++){
                uArray[i] = i;
            }

            //loops over to either print or union
            for (int i = 0; i < N; i++){
                String[] s = scn.readLine().split(" ");

                if (s.length == 2){
                    int num = Integer.parseInt(s[1]);
                    System.out.println(find(num));
                } else {
                    int num1 = Integer.parseInt(s[1]);
                    int num2 = Integer.parseInt(s[2]);
                    union(num1, num2);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int find(int f){
        int root = f;

        // finds the root element
        while( root !=  uArray[root] )
            root =  uArray[root];

        //uses compression to optimize the algorithm
        while(f != root) {
            int next =  uArray[f];
            uArray[f] = root;
            f = next;
        }
        return root;
    }

    public static void union(int v, int w){
        int newV = find(v);
        int newW = find(w);

        //the lowest value becomes the root
        if ( newV < newW){
            uArray[newW] = newV;
        } else {
            uArray[newV] = newW;
        }
    }
}
