package ru.orlovvv;

import java.util.Arrays;
import java.util.Scanner;

/* 1) Fn=Fn−1+Fn−2 просто рекурсивно вызываю и получаю результат
   2) заполняю массив при рождении детей и затем просто "сдвигаю" массив и считаю количество кроликов в итоге
   3) создал переменный для хранения индекса двух массивов и пока они не превышают длину исходных массивов то идет
      сравнение и запись в новый массив, иначе записывается число из массива, данные которого еще не записаны
 */

public class Main {

    public static void main(String[] args) {

        int[] a = {0, 2, 2};
        int[] b = {1, 3, 5, 7, 9};

        Scanner sc = new Scanner(System.in);
        System.out.println("1)rabbits \n2)mortalRabbits \n3)sortMerge");
        int task = sc.nextInt();

        switch (task) {
            case 1:
                System.out.println("Месяцев = ");
                int month = sc.nextInt();
                System.out.println("k = ");
                int k = sc.nextInt();
                System.out.println(rabbits(month, k));
                break;
            case 2:
                System.out.println("Месяцев = ");
                int m = sc.nextInt();
                System.out.println("k = ");
                int k2 = sc.nextInt();
                System.out.println(mortalRabbits(m, k2));
                break;
            case 3:
                System.out.println(Arrays.toString(sort2(a, b)));
                break;
        }
    }

    private static long rabbits(int month, int k) {

        return month < 2 ? month : rabbits(month - 1, k) + rabbits(month - 2, k) * k;

    }

    private static long mortalRabbits(int month, int k) {

        long[] arr = new long[month];
        arr[0] = 1;
        long result = 0;

        for (int i = 1; i < month; i++) {
            long child = 0;
            for (int j = 1; j < k; j++) {
                child += arr[j];
            }

            if (k - 1 >= 0) System.arraycopy(arr, 0, arr, 1, k - 1);
            arr[0] = child;
        }

        for (int j = 0; j < k; j++) {
            result += arr[j];
        }
        return result;

    }


    private static int[] sort2(int[] a, int[] b) {

        int[] newArray = new int[a.length + b.length];
        final int SIZE = newArray.length;
        int indexA = 0, indexB = 0, element;

        for (int i = 0; i < SIZE; i++) {
            if (indexA > a.length - 1) {
                element = b[indexB];
                indexB += 1;
                newArray[i] = element;
            } else if (indexB > b.length - 1) {
                element = a[indexA];
                indexA += 1;
                newArray[i] = element;
            } else if (a[indexA] > b[indexB]) {
                element = b[indexB];
                indexB += 1;
                newArray[i] = element;
            } else {
                element = a[indexA];
                indexA += 1;
                newArray[i] = element;
            }
        }
        return newArray;
    }

}



