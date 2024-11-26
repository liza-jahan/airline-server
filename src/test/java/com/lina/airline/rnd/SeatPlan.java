package com.lina.airline.rnd;

public class SeatPlan {
    public static void main(String[] args) {

        for (int row = 1; row <= 5; row++) {
            for (int i = 1; i <= 6; i++) {
                if (row == 1&&(i ==2 || i==3 ) ) {
                    // Row 1

                        System.out.print("\t");

                    //System.out.print(" * ");

                } else if (row >= 2 && row <= 4 &&(i ==3 ) ) {

                    System.out.print("\t");
                } else  {

                    System.out.print(" *\t");
                }
                }
            System.out.println();
            }

        }

    }
