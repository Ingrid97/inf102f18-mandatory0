package no.uib.ii.inf102.f18.mandatory0;//Created by ingridjohansen on 25.09.2018.

public class ReversePolishHard {
    public static void main(String[] args) {

        Kattio scn = new Kattio(System.in, System.out);

        StringBuilder delString = new StringBuilder();


        ingridStackHard svar = new ingridStackHard(100001);

        String i;
        while (scn.hasMoreTokens()) {
            i = scn.getWord();
            switch (i.charAt(0)) {
                case '*':
                case '/':
                case '+':
                case '-':
                    StringBuilder a = new StringBuilder();
                    a.append(i);
                    //expr e = new expr(svar.popp(), a,svar.popp());
                    //svar.push(e);
                    break;
                default:
                    StringBuilder b = new StringBuilder();
                    b.append(i);
                    StringBuilder c = new StringBuilder();
                    b.append("");
                    expr h = new expr(c, b,c);
                    svar.push(h);
            }
        }
        System.out.println(svar.popp().print());
    }
}

class expr{
    StringBuilder left;
    StringBuilder exp;
    StringBuilder right;

    public expr(StringBuilder left, StringBuilder exp, StringBuilder right){
        this.left = right;
        this.exp = exp;
        this.right = left;
    }

    public StringBuilder print(){
        StringBuilder delString = new StringBuilder();
        delString.append('(');
        delString.append(left);
        delString.append(exp);
        delString.append(right);
        delString.append(')');
        return delString;
    }
}

/**
 * ingridStack:
 * En stack laget av en array og en teller
 */

class ingridStackHard {
    private expr[] liste;
    private int teller = 0;

    ingridStackHard(int n) {
        liste = new expr[n];
    }

    expr popp() {
        return liste[--teller];
    }

    void push(expr s) {
        liste[teller++] = s;
    }
}