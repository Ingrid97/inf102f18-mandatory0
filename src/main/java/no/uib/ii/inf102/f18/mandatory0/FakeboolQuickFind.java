package no.uib.ii.inf102.f18.mandatory0;//Created by ingridjohansen on 22.09.2018.

import java.util.Scanner;

public class FakeboolQuickFind {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int accounts = scn.nextInt();
        int n = scn.nextInt();

        ingridQuickFind q = new ingridQuickFind(accounts);

        for (int i = 0; i < n; i++){
            int a = scn.nextInt();
            int b = scn.nextInt();
            q.connect(a, b);
        }
        q.print();
    }
}

/**
 * class for the quick find
 */
class ingridQuickFind{

    int[] quick;

    public ingridQuickFind(int l){
        quick = new int[l];
        for (int i = 0; i < l; i++){
            quick[i] = i;
        }
    }

    //connect two accounts
    public void connect(int a, int b){

        if (!isConnected(a, b)){

            int q_a = quick[a];
            int q_b = quick[b];

            //so the smalest becomes the root
            if (q_a > q_b){
                int x = q_a;
                q_a = q_b;
                q_b = x;
            }

            for (int i = 0; i < quick.length; i++){
                if (quick[i] == q_b){
                    quick[i] = q_a;
                }
            }
        }
    }

    public boolean isConnected(int a, int b){
        if (quick[a] == quick[b])
            return true;
        return false;
    }

    public void print(){
        for (int i = 0; i < quick.length; i++){
            System.out.print(quick[i] + " ");
        }
    }
}