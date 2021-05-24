package Sort;

/**
 * @author yaosen.pys
 * @date 2021/05/23
 */
public class HeapSort {
    /**
     * 堆序号从0开始计算
     */
    private int[] data;

    private boolean asc;

    public HeapSort(int[] value, boolean asc) {
        this.data = value;
        this.asc = asc;
    }

    private void heapSort() {
        sort(1, data.length);
    }

    private void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private void sort(int begin, int end) {
        for (int i = end / 2; i >= begin; i--) {
            if (asc) {
                modifyLarge(i, end);
            } else {
                modifySmall(i, end);
            }
        }

        exchange(1, end);

        if (begin < end) {
            sort(begin, end - 1);
        }
    }

    private int parent(int i) {
        return i << 1;
    }

    private int leftChild(int i) {
        return i << 1;
    }

    private int rightChild(int i) {
        return (i << 1) + 1;
    }

    private void modifyLarge(int i, int length) {
        if (i > length) {
            return;
        }
        int left = leftChild(i);
        int right = rightChild(i);

        int exchangeIndex = i;
        if (left < length && right < length) {
            if (value(left) > value(right) && value(left) > value(i)) {
                exchange(left, i);
                exchangeIndex = left;
            } else if (value(right) > value(left) && value(right) > value(i)) {
                exchange(right, i);
                exchangeIndex = right;
            }
        }

        if (left < length) {
            if (value(left) > value(i)) {
                exchange(left, i);
                exchangeIndex = left;
            }
        }

        if (exchangeIndex != i) {
            modifyLarge(exchangeIndex, length);
        }
    }

    private void modifySmall(int i, int length) {
        if (i > length) {
            return;
        }
        int left = leftChild(i);
        int right = rightChild(i);

        int exchangeIndex = i;
        if (left < length && right < length) {
            if (value(left) < value(right) && value(left) < value(i)) {
                exchange(left, i);
                exchangeIndex = left;
            } else if (value(right) < value(left) && value(right) < value(i)) {
                exchange(right, i);
                exchangeIndex = right;
            }
        }

        if (left < length) {
            if (value(left) < value(i)) {
                exchange(left, i);
                exchangeIndex = left;
            }
        }

        if (exchangeIndex != i) {
            modifySmall(exchangeIndex, length);
        }
    }

    private void exchange(int i, int j) {
        int temp = value(i);
        data[i - 1] = data[j - 1];
        data[j - 1] = temp;
    }

    private int value(int index) {
        return data[index - 1];
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

        HeapSort sort = new HeapSort(value, false);
        sort.heapSort();

        sort.print();
    }
}
