import java.util.Arrays;

public class HeapSortRev {
    public static void main(String[] args)
    {
        final int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        minHeapify(arr);
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(final int[] arr) throws NullPointerException {
        if (arr == null) throw new NullPointerException("arr cannot be null");
        minHeapify(arr);
        for (int len = arr.length; len > 1; --len){
            swapElements(arr, 0, len - 1);
            heapify(arr, 0, len - 1);
        }
    }
    public static void minHeapify(final int[] arr) throws NullPointerException {
        if (arr == null) throw new NullPointerException("arr cannot be null");
        final int lastNonLeafNode = arr.length / 2 - 1;
        for (int i = lastNonLeafNode; i >= 0; --i){
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(final int[] arr, final int elementIndex, final int len){
        final int leftChildIndex = getLeftChildIndex(elementIndex);
        final int rightChildIndex = getRightChildIndex(elementIndex);

        int minIndex = elementIndex;
        if (leftChildIndex < len){
            if (arr[leftChildIndex] < arr[minIndex]){
                minIndex = leftChildIndex;
            }
        }
        if (rightChildIndex < len){
            if (arr[rightChildIndex] < arr[minIndex]){
                minIndex = rightChildIndex;
            }
        }
        if (minIndex != elementIndex){
            swapElements(arr, elementIndex, minIndex);
            heapify(arr, minIndex, len);
        }
    }

    private static int getLeftChildIndex(final int elementIndex){
        return 2 * elementIndex + 1;
    }
    private static int getRightChildIndex(final int elementIndex){
        return 2 * elementIndex + 2;
    }
    private static void swapElements(final int[] arr, final int index1, final int index2){
        final int buf = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = buf;
    }
}
