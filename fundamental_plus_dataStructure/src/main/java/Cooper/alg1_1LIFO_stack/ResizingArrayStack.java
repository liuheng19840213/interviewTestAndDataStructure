package Cooper.alg1_1LIFO_stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[10];

    private int n = 0; //this is num of Stack .instead of a.

    //is empty?
    public boolean isEmpty(){
        return n == 0;
    }
    //get size
    public int size(){
        return n;
    }

    //resize
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        //need to copy a[i] into temp[i]
        System.arraycopy(a, 0, temp, 0,n);
        a = temp;
        n = a.length;
    }

    public void push(Item item){
        if (n==a.length) {
            resize(2*a.length);
        }

        a[n]=item;
        n++;
    }

    public Item pop(){

        Item item = a[n-1];
        n--;
        a[n]=null;
        if(n>0&&n==a.length/4){
            resize(a.length/2);
        }
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = n;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
