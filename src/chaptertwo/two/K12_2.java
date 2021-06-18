package chaptertwo.two;

import chaptertwo.one.Example;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * 题目中的max(M, N/M)
 *      如果一味的追球最少的额外空间，就会导致时间效率非常低，
 *      为了中和额外空间和时间效率，选择一个适合的M是必要的。
 *      max(M, N/M)就指出了这一点。
 * @author gxx
 * @create 2021-06-17 20:34
 */
public class K12_2 {

    public static void main(String[] args) {

        int arraySize = 100000;
        int blockSize = 100;

        Comparable[] array = generateRandomArray(arraySize);

        Stopwatch timer = new Stopwatch();
        selectionSortBlocks(array, blockSize);

        Comparable[] aux = new Comparable[blockSize];

        for (int i = arraySize / blockSize - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int low = j * blockSize;
                int middle = (j + 1) * blockSize - 1;
                int high = middle + blockSize;
                merge(array, aux, low, middle, high);
            }
        }
        StdOut.println("time: " + timer.elapsedTime());

    }

    private static Comparable[] generateRandomArray(int arrayLength) {
        Comparable[] array = new Comparable[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = StdRandom.uniform();
        }
        return array;
    }

    private static void selectionSortBlocks(Comparable[] array, int blocksize) {
        for (int i = 0; i < array.length; i += blocksize) {
            selectionSort(array, i, i + blocksize - 1);
        }
    }

    private static void selectionSort(Comparable[] array, int low, int high) {
        for (int i = low; i <= high; i++) {
            int minIndex = i;

            for (int j = i + 1; j <= high; j++) {
                if (Example.less(array[j], array[minIndex])) {
                    minIndex = j;
                }
            }
            Comparable temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    private static void merge(Comparable[] array, Comparable[] aux, int low, int middle, int high) {
        int auxIndex = 0;
        for (int i = low; i <= middle; i++) {
            aux[auxIndex] = array[i];
            auxIndex++;
        }
        int indexLeft = 0;
        int indexRight = middle + 1;
        int arrayIndex= low;
        while (indexLeft < aux.length && indexRight <= high) {
            if (Example.less(aux[indexLeft], array[indexRight])) {
                array[arrayIndex] = aux[indexLeft];
                indexLeft++;
            } else {
                array[arrayIndex] = array[indexRight];
                indexRight++;
            }
            arrayIndex++;
        }

        while (indexLeft < aux.length) {
            array[arrayIndex] = aux[indexLeft];
            indexLeft++;
            arrayIndex++;
        }
    }
}
