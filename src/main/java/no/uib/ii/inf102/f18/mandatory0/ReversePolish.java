package no.uib.ii.inf102.f18.mandatory0;//Created by ingridjohansen on 18.09.2018.

import java.util.Scanner;

public class ReversePolish {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] stykke = scn.nextLine().split(" ");
        ingridStack svar = new ingridStack(5000);

        for(int i = 0; i < stykke.length; i++){

            if(stykke[i].equals("*") || stykke[i].equals("+") || stykke[i].equals("-") || stykke[i].equals("/")){

                String holder = svar.popp();
                String delString = "(" + svar.popp()  +  stykke[i]  + holder + ")";
                svar.push(delString);

            } else {
                svar.push(stykke[i]);
            }
        }
        System.out.println(svar.popp());
    }
}

/**
 * ingridStack:
 * En stack laget av en array og en teller
 */

class ingridStack{
    public String[] liste;
    int teller = 0;

    public ingridStack(int n){
        liste = new String[n];
    }

    String popp() {
        if (teller == 0) {
            return "Stacken er tom";
        } else {
            String ret = liste[teller-1];
            teller--;
            return ret;
        }
    }

    String peek() {
        if (teller == 0) {
            return "Stacken er tom";
        } else {
            return liste[teller - 1];
        }
    }

    void push(String s) {
        liste[teller] = s;
        teller++;
    }
}
