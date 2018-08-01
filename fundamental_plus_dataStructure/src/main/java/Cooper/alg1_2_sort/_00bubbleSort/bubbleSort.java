package Cooper.alg1_2_sort._00bubbleSort;

/**
 * 写一个冒泡排序
 */
public class bubbleSort {
    public static void sort(Comparable[] a){
       for(int i = 1;i<=a.length;i++){
            for (int j= 1;j<=a.length-i;j++){
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }
            }
       }
    }

    private static boolean less(Comparable v, Comparable a){
        return v.compareTo(a) <0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private static void show(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i] +" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        //测试数组元素是否有序
        for(int i =1;i<a.length;i++){
            if (less(a[i],a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr={6,7,1,8,0,2};
        show(arr);
        sort(arr);
        System.out.println("----------------------------");
        show(arr);

    }
}
