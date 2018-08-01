package Cooper.alg1_2_sort._02insetSort;

/**
 * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，
 * 现在要把第n个数找到相应位置并插入，
 * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 如果a[4]<a[1]则a[4]放入a[1];a[1],a[2],a[3]依次索引加1
 */

public class Insert {
    public static void sort(Comparable[] a){
        //从第二个数开始即a[1]
       for(int i= 1;i<a.length;i++){
           for(int j = i;j>0;j--){      //内循环使用的思路类似冒泡排序
               if(less(a[j],a[j-1] )){
                   exch(a, j, j-1);
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
