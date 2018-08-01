package Cooper.alg1_3_search._01binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 10, 11};
        int i = binarySearch(arr, 3);
        System.out.println(i);

    }

    /*
     * 循环实现二分查找算法arr 已排好序的数组x 需要查找的数-1 无法查到数据
     */
    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
