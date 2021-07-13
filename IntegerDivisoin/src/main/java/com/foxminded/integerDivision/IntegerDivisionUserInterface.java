package com.foxminded.integerDivision;

import java.util.Scanner;

import com.foxminded.integerDivision.logicForDivision.DivisonMaker;

public class IntegerDivisionUserInterface {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
 
        System.out.println("Write dividned and divisor (divisor can't be 0 and dividend shoud be > than divisor)..");
        System.out.println("only positive numbers");
        int dividend = in.nextInt();
        int divisor = in.nextInt();

        DivisonMaker divisonMaker = new DivisonMaker();
        divisonMaker.makeDivision(dividend, divisor);
        

        in.close();
    }
}
