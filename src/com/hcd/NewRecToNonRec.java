package com.hcd;

public class NewRecToNonRec {

    public static void main(String[] args) {

//        Write the following recursive method as a non-recursive method using Dynamic Programming:
//        Submit the code as a single java file. The java file should have a main method that prints out the following calls:

        System.out.println(newRec(8,6));
        System.out.println(newRec(8,3));
        System.out.println(newRec(18,10));

        System.out.println(nonRec(8, 6));
        System.out.println(nonRec(8, 3));
        System.out.println(nonRec(18, 10));

    }

    public static int nonRec(int k, int t){

        int[][] result = new int[k+1][t+1];

        for (int i=0; i<3; i++){
            for (int j=0; j<t; j++){
                result[i][j] = 1;
            }
        }

        for (int j=0; j<3; j++){
            for (int i=3; i<k; i++){
                result[i][j] = 2;
            }
        }

        for (int i = 2; i<=k; i++){
            for (int j = 3; j<=t; j++){
                result[i][j] = result[i-1][j-1] + result[i-1][j-2] + result[i-2][j-3];
            }
        }

        return result[k][t];
    }


    public static int newRec(int k, int t){
        if (k<3) {
            return 1;
        }
        if (t<3) {
            return 2;
        }
        return newRec(k-1,t-1)+newRec(k-1,t-2)+newRec(k-2,t-3);
    }

}
