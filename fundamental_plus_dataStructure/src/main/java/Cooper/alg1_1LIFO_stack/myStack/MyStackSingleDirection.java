package Cooper.alg1_1LIFO_stack.myStack;

public class MyStackSingleDirection {
    private Node first;
    private Node last;
    private int size;

    public MyStackSingleDirection() {

    }

    class Node { //写内部类的原因是因为不能被别人访问 每一个Node防三洋东西
        Node prev;
        Node next;
        Object ele;

        public Node(Object ele) {
            this.ele = ele;
        }
    }

    //前面加
    public void addFirst(Object ele) {
        Node node = new Node(ele);
        if (size == 0) {
            this.first = node;//MyStack的第一个节点就是当前这个
            this.last = node;//最后一个也是当前这个
        }
        this.first.prev = node;//将待加入的node设置为第一个节点的prev
        //node.prev = null;			//根本不需要这句,node.prev本来就是null;默认的,这是废话,因为node.next,node.prev  =null
        node.next = this.first;
        //System.out.println(node.next.ele);
        this.first = node;
        //System.out.println(first.ele);
        //node.next = this.first;   this.first = node;这两句话次序不能换

        size++; //一定不要忘记  size++;
    }

    //后面加
    public void addLast(Object ele) {
        Node node = new Node(ele);
        if (size == 0) {
            this.first = node;
            this.last = node;
        }

        node.prev = this.last;
        this.last.next = node;
        this.last = node;
        size++; //不要忘记啊
    }

    //查找
    public boolean search(Object ele) {
        //Node node = new Node(ele);
        boolean b = false;
        Node current = this.first;//从第一个节点开始遍历
        for (int i = 0; i < size; i++) {
            if (!current.ele.equals(ele)) {
                if (current == null) {
                    return b;
                }
                current = current.next;//指针后移
            } else {
                b = true;
            }
        }
        return b;
    }

    //删除
    public void delete(Object ele) throws NullElementException {
        Node current = this.first;

        if (ele == null) {
            throw new NullElementException("搜索空目标");
        }

        for (int i = 0; i < size; i++) {
            if (!current.ele.equals(ele)) {
                if (current.next == null) { //到末尾啦
                    System.out.println("所要删除的数不存在");
                    return;
                }
                current = current.next;
            }//else{
            //break;
            //}
        }
        //上面的遍历过了都没事,则必定存在ele

        if (current == first) {
            current.next.prev = null;
            first = current.next;
        } else if (current == last) {
            current.prev.next = null;
            last = current.prev;
        } else {
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
        size--;
    }

    //清空
    public void clear() {
        Node current = this.first;
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            current = null;
        }
        size = 0;
    }

    //替换
    public void replace(Object ele1, Object ele2) throws NullElementException {
        Node current = this.first;

        if (size == 0) {
            throw new NullElementException("无被替换目标");
        }

        for (int i = 0; i < size; i++) {
            if (!current.ele.equals(ele1)) {
                if (current.next == null) { //到末尾啦
                    System.out.println("所要删除的数不存在");
                    return;
                }
                current = current.next;
            } else {
                break;
            }
        }
        current.ele = ele2;
    }

    //指定索引插入一个值
    public void insert(int index, Object ele) throws Exception {
        Node current = this.first;
        if (index < 0) {
            throw new NegativeException("不该有的赋负值");

            //return; //一定要加这句,或者抛异常  索引非法不可以size++;
        } else if (index + 1 > size) {
            throw new ArrayIndexOutOfBoundsException("索引超过了链表的空间");
        } else if (index == size - 1) {
            this.addLast(ele);
            return; //这里要return,因为之前加过size++
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            //注意,所有的有关插入 ,都是先改插入的节点,再改链表上的节点
            Node node = new Node(ele);
            node.next = current.next;
            current.next.prev = node;
            node.prev = current;
            current.next = node;

        }
        size++;

    }

    //转为字符串
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size == 0) {
            sb.append("]");
        }

        Node current = first; //不要将此句放入循环中, 否则每次都创建新的对象
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                sb.append(current.ele).append(",");
                current = current.next;
            } else {
                sb.append(this.last.ele).append("]"); //不要忘记.ele
            }
        }
        return sb.toString();
        //ele= this.first.next.ele;  与current = current.next;的区别
    }

}

class NullElementException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NullElementException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public NullElementException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}

class NegativeException extends Exception{

    public NegativeException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public NegativeException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}

