package com.shekar.codesignal;

public class AlternatingSort {

    public static void main(String[] args) {

        int[] a = {-92, -23, 0, 45, 89, 96, 99, 95, 89, 41, -17, -48};
        System.out.println(alternatingSort(a));

    }

    public static boolean alternatingSort(int[] a) {

        int N = a.length;
        int[] b = new int[N];

        int i = 0;
        int j = N-1;
        for (int k = 0; k < N; k++) {
            if (k % 2 == 0) {
                b[k] = a[i++];
            } else {
                b[k] = a[j--];
            }

            if(k > 0) {
                if (b[k] < b[k-1]) {
                    return false;
                }
            }
        }

        return true;
    }

}
