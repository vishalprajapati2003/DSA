// Q2. Implement a Map in java which takes the input and print the list in sorted order based on value.

// Input:   5 Rahul, 7 Lakshman, 1 Ram, 4 Krrish, 2 Lakshay
// Output: {Krish=4,Lakshay=2,Lakshman=7,Rahul=5,Ram=1}
package HashMap.Assignment;

import java.util.Scanner;
import java.util.TreeMap;

public class Ex2_HashMap {
     public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of key-value pairs:");
            int n = sc.nextInt();
            // TreeMap is used to store key-value pairs in sorted order so use TreeMap
            TreeMap<String, Integer> map = new TreeMap<>();
            System.out.println("Enter the key-value pairs:");
            for (int i = 0; i < n; i++) {
                String key = sc.next();
                int value = sc.nextInt();
                map.put(key, value);
            }

            System.out.println(map);
        }
    }
}
