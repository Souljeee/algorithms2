import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //2.1
        System.out.println("Задание 1");
        Random r = new Random();
        int[] a = new int[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(10);
        }
        a[5] = 13;

        long sortTimeStart = System.nanoTime();
        Arrays.sort(a);
        long sortTimeEnd = System.nanoTime();

        long searchTimeStart = System.nanoTime();
        int s = Arrays.binarySearch(a,7);
        long searchTimeEnd = System.nanoTime();

        System.out.println(Arrays.toString(a));
        System.out.println("Время выполнения сортировки: "+(sortTimeEnd-sortTimeStart));
        System.out.println("Индекс икомого элемента: "+s);
        System.out.println("Время выполнения поиска: "+(searchTimeEnd - searchTimeStart));
        System.out.println();

        //2.2
        System.out.println("Задание 2");
        int key = 6;

        //линейный поиск
        System.out.println("Линейный поиск");
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(10);
        }
        int searchIndex1 = 0;
        System.out.println(Arrays.toString(a));
        long linearSearchTimeStart = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            if(a[i] == key){
                searchIndex1 = i;
            }
        }
        if(searchIndex1 == 0){
            System.out.println("Элемент не найден!");
        }else {
            System.out.println("Индекс искомого элемента:" + searchIndex1);
        }
        long linearSearchTimeEnd = System.nanoTime();
        System.out.println("Время выполнения: "+ (linearSearchTimeEnd-linearSearchTimeStart));


        //Бинарный поиск
        System.out.println("Бинарный поиск");
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        long binarySearchTimeStart = System.nanoTime();
        int low = 0;
        int hight = a.length-1;
        int searchIndex = 0;

        while(low <= hight){
            int mid  = (low+hight)/2;
            if(a[mid] == key){
                searchIndex = mid;
                break;
            }else if(a[mid] < key){
                low = mid + 1;
            }else if(a[mid] > key){
                hight = mid -1;
            }
        }
        if (searchIndex == 0){
            System.out.println("Элемент не найден!");
        }else{
            System.out.println("Индекс искомого элемента: "+searchIndex);
        }
        long binarySearchTimeEnd = System.nanoTime();
        System.out.println("Время выполнения: "+(binarySearchTimeEnd - binarySearchTimeStart));
        System.out.println();


        //2.3
        System.out.println("Задание 3");
        int a1[] = new int[400];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = r.nextInt(500);
        }
        long fastSearchTimeStart = System.nanoTime();
        Arrays.sort(a1);
        long fastSearchTimeEnd = System.nanoTime();
        System.out.println("Время выполнения быстрой сортировки: "+(fastSearchTimeEnd - fastSearchTimeStart));
        System.out.println();

        //2.4
        System.out.println("Задание 4");
        for (int i = 0; i < a1.length; i++) {
            a1[i] = r.nextInt(500);
        }
        boolean stop = false;
        int t = 0;

        long bubbleSortTimeStart = System.nanoTime();
        while(!stop){
            stop = true;
            for (int i = 0; i < a1.length-1; i++) {
                if(a1[i] > a1[i+1]){
                    stop = false;
                    t = a1[i];
                    a1[i] = a1[i+1];
                    a1[i+1] = t;
                }
            }
        }
        long bubbleSortTimeEnd = System.nanoTime();
        System.out.println("Время выполнения сортировки пузырьком: "+ (bubbleSortTimeEnd-bubbleSortTimeStart));
        System.out.println();


        //2.5
        System.out.println("Задание 5");
        for (int i = 0; i < a1.length; i++) {
            a1[i] = r.nextInt(500);
        }
        long selectionSortTimeStart = System.nanoTime();
        for (int i = 0; i < a1.length -1; i++) {
            int min = i;
            for (int j = i+1; j < a1.length; j++) {
                if(a1[j] < a1[min]){
                    min = j;
                }
            }
            t = a1[i];
            a1[i] = a1[min];
            a1[min] = t;
        }
        long selectionSortTimeEnd = System.nanoTime();
        System.out.println("Время сортировки методом выбора: "+ (selectionSortTimeEnd - selectionSortTimeStart));
        System.out.println();

        //2.6
        System.out.println("Задание 6");
        for (int i = 0; i < a1.length; i++) {
            a1[i] = r.nextInt(500);
        }

        long insertionSortTimeStart = System.nanoTime();
        int in;
        for (int i = 1; i < a1.length; i++) {
            t = a1[i];
            in = i;
            while (in > 0 && a1[in-1] >= t){
                a1[in] = a1[in-1];
                --in;
            }
            a1[in] = t;
        }
        long insertionSortTimeEnd = System.nanoTime();
        System.out.println("Время сортировки методом вставки: "+(insertionSortTimeEnd-insertionSortTimeStart));



    }
}
