package Cooper.alg1_2_sort._03shellSort;

/**
 * a modification of InsertSort called hillSort
 * 任意间隔为h的元素是有序的就是h有序数组
 */
public class ShellSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h<N/3){
            h=h*3+1;
        }
        while(h>=1){
            for(int i= h;i<N;i++){
                for(int j = i;j>h-1;j=j-h){
                    if(less(a[j],a[j-h] )){
                        exch(a, j, j-h);
                    }
                }
            }
            h=h/3;
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

