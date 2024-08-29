// Problem 1: given a number, print its binary representation. 

// Input 1: number = 5
// Output 1: 101
// Input 2: number = 10
// Output 2: 1010
package SearchingAndSorting.NumberSystemAssignment;

import java.util.Scanner;
public class Ex1_Number {

    public static int decimalToBinary(int number) {
        int re,binary = 0,i=1;
        while(number!=0){
            re=number%2;
            number=number/2;
            binary=binary+(re*i);
            i=i*10;
        }
        return binary;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number: ");
            int number = sc.nextInt();
            int binary = decimalToBinary(number);
            System.out.println("Binary representation of " + number + " is: " + binary);
        }
    }
}
