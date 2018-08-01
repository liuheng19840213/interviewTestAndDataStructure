package Cooper.alg1_2_sort._04mergeSort;

/**
 * 演示归并排序
 */
public class MergeSort {
    private static Comparable[] tempArrs ;

    public static void sort(Comparable[] a){
        tempArrs= new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int left, int right) {
        if(right<=left){
            return;
        }
        int mid = left + (right - left)/2;
        sort(a,left,mid);
        sort(a,mid+1,right);
        merge(a, left, mid, right);
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

    public static void merge(Comparable[] a,int left,int mid,int right){
        int i = left;//左边数组的起始索引
        int j = mid + 1;//右边数组的起始索引
        //System.arraycopy(a, 0, tempArrs, 0, a.length);
        for (int k = left; k<a.length;k++){
            tempArrs[k]=a[k];
        }
        //归并回a
        for(int k = left;k<=right;k++){
            if(i>mid){
                a[k]=tempArrs[j++];
            }else if(j>right){
                a[k]=tempArrs[i++];
            }else { //左右都没用尽的情况下
                if(less(tempArrs[i],tempArrs[j])){
                    a[k]=tempArrs[i++];
                }else{
                    a[k]=tempArrs[j++];
                }
            }
        }
       /* //下面这个逻辑时严重错误的,应首先派出掉i > mid 和 j >right
        for(int k = left;k<=right;k++){
            if(less(tempArrs[j],tempArrs[i])){
                a[k]=tempArrs[j++];
            }else if(i>mid){
                a[k]=tempArrs[j++];
            }else if(j>right){
                a[k]=tempArrs[i++];
            }else{
                a[k]=tempArrs[i++];
            }
        }*/
    }

    public static void main(String[] args) {
        Integer[] arr={6,7,1,8,0,2,100,3,5,1,5,4,8,9};
        show(arr);
        sort(arr);
        System.out.println("----------------------------");
        show(arr);

    }
}


