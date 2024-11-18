package com.lina.airline.rnd;

public class Matrix {
    public static void main(String[] args) {
        for (char a = 'A'; a < ('A'+26 ); a++) {
            for (int i = 1; i <= 6; i++) {
              if(i==3){
                  System.out.print("\t");
                  continue;
              }
                System.out.print(a+""+i+"\t");
            }
            System.out.println();
        }
    }
}
