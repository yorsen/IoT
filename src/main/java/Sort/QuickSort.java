package Sort;

/**
 * @author yaosen.pys
 * @date 2021/05/23
 */
public class QuickSort {
    private int[] data;

    private void sort() {
        quickSort(data, 0, data.length - 1);
    }

    public QuickSort(int[] data) {
        this.data = data;
    }

    private void printValue() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private void quickSort(int[] value, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int key = value[begin];
        int i = begin;
        int j = end;

        while (i < j) {
            while (i < j && value[j] > key) {
                j--;
            }

            if (i < j) {
                value[i] = value[j];
                i++;
            }

            while (i < j && value[i] < key) {
                i++;
            }

            if (i < j) {
                value[j] = value[i];
                j--;
            }

            value[i] = key;

            quickSort(value, begin, i - 1);
            quickSort(value, i+1, end);
        }
    }

    public static void main(String[] args) {
        int[] value = new int[8];
        value[0] = 47;
        value[1] = 29;
        value[2] = 71;
        value[3] = 99;
        value[4] = 78;
        value[5] = 19;
        value[6] = 24;
        value[7] = 47;

        QuickSort sort = new QuickSort(value);
        sort.sort();
        sort.printValue();
    }
}
