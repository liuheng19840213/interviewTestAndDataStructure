package Cooper.alg1_2_sort._06heapSort;

import Cooper.alg1_2_sort.SortUtil;

/**
 * 堆就是所谓的优先队列
 */
public class MyHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MyHeap(int maxN) {
        pq = (Key[]) new Comparable[maxN +1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    /**
     * insert , the key can only be inserted into the last position
     * remember : after this operation, the size is still N.
     * @param v
     */
    public void insert(Key v){
        pq[++N]= v;
        swim(N);
    }

    /**
     * idea: 1. get pq[1] at first
     * 2 then exchange pq[1] with the smallest ele that is pq[N] in order to keep the structure integrated
     *   however at this time, the first ele is the smallest one, i have to sink it
     * 3 then sink pq[1]
     * @return
     */
    public Key delMax(){
        Key max = pq[1];
        SortUtil.exch(pq, 1, N--);  //虽然--了, 比如原来的N = 10, --后 N =9 但是pq[]的length还是10, 但是成员变量N =9 了
        pq[N + 1] = null;       //所以如果我的目的是设置P[10]=null, 这里需要P[N+1] = null  understatnd?
        sink(1);
        return max;
    }

    private void swim(int k){
        while(k >1 && SortUtil.less(pq[k/2], pq[k])){
            SortUtil.exch(pq, k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if (j<N && SortUtil.less(pq[j],pq[j+1])){
                j++;
            }
            if(!SortUtil.less(pq[k], pq[j])){
                break;
            }
            SortUtil.exch(pq, k,j);
            k = j;
        }
    }

}
