package Cooper.alg1_2_sort._05quickSort;

import java.util.Random;

public class QuickSort {
    public static void sort(Comparable[] a){
        //shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int left, int right) {
        if (left>=right) {
            return;
        }
        int j = partition(a,left,right);
        sort(a,left,j-1);
        sort(a,j+1,right);
    }

    /**
     *
     * @param a
     * @param left
     * @param right
     * @return  返回的是切分点
     */
    private static int partition(Comparable[] a, int left, int right) {     //right传进来的的是a.length-1 not alength plz do not forget
        //一开始随意设定a[left]为切分元素:初始切分元素
        int i = left;
        int j = right+1;
        Comparable temp = a[left];
        while(true){
            while(less(a[++i],temp)){   //第一个是a[1]=7相当于找到了  不进入循环此时已经++i,定位i=1
                if(i==right){//要考虑到l增加到right的情况, 有可能右边所有的数都比temp小
                    break;
                }
            }
            while(less(temp, a[--j])){  //第一个为a[7]=3,
                if(j==left){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exch(a, i, j);
        }
        exch(a, left, j);
        return j;

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
    /**
     * Rearrange the elements of an array in random order.
     */
    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + uniform(N-i);     // between i and N-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    /**
     * Return an integer uniformly between 0 and N-1.
     */
    public static int uniform(int N) {
        return new Random().nextInt(N);
    }

    public static void main(String[] args) {
        Integer[] arr={6,7,1,8,0,2,10,3};
        show(arr);
        sort(arr);
        System.out.println("----------------------------");
        System.out.println(isSorted(arr));
        show(arr);

    }


}
