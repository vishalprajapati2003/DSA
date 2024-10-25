package Greedy.Assignment;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPloat = ((i - 1) < 0 || flowerbed[i - 1] == 0);
                boolean emptyRightPloat = ((i + 1) >= flowerbed.length || flowerbed[i + 1] == 0);

                if (emptyLeftPloat && emptyRightPloat) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int flowerbed[] = { 1, 0, 0, 0, 1 };
        int n = 1;
        System.out.println("The desired output is :  " + canPlaceFlowers(flowerbed, n));
    }
}
