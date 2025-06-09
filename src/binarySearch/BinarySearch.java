package binarySearch;

public class BinarySearch {
    static int[] a;
    public static void main(String[] args) {
        a = generateArray();
        long startIt = System.nanoTime();
        System.out.println(bSIterative(49));
        long endIt = System.nanoTime();
        long timeIt = endIt - startIt;

        System.out.println("Calculation time: " + (double) timeIt / 1_000_000 + " milliseconds");

        long startR = System.nanoTime();
        System.out.println(bSRecursive(0,a.length-1,49));
        long endR = System.nanoTime();
        long timeR = endR - startR;

        System.out.println("Calculation time: " + (double) timeR / 1_000_000 + " milliseconds");
    }

    private static int bSIterative(int key) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
//            System.out.println("this is l "+l);
//            System.out.println("this is h "+h);
            int m = (l+h)/2;
            if (a[m] == key) {
                return m;
            } else if (a[m] > key ) {

                h = m -1;
            }else {
                l = m + 1;
            }
        }
        return -1;
    }

    private static int bSRecursive(int l, int h, int key) {

        if (l == h) {
            if (a[l] == key) {
                return l;
            }else {
                return -1;
            }
        }

        int m = (l+h)/2;

        if (key == a[m]) {
            return m;
        }else if (key> a[m]) {
            return bSRecursive(m+1,h,key);
        }else {
            return bSRecursive(l,m-1,key);
        }
    }

    private static int[] generateArray() {
        int[] array = new int[100];
        for (int i = 0; i <= 99; i++) {
            array[i] = i+1;
        }
        return array;
    }
}
