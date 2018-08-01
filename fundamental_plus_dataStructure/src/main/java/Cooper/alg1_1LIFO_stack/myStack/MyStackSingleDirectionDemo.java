package Cooper.alg1_1LIFO_stack.myStack;

public class MyStackSingleDirectionDemo {
	public static void main(String[] args) throws NullElementException {
		MyStackSingleDirection list = new MyStackSingleDirection();
		list.addFirst("A");
		list.addFirst("C");
		list.addFirst("B");
		list.addFirst("D");
		list.addFirst("E");
		String str = list.toString();
		System.out.println(str);
		//list.addFirst("F");
		
		
		list.clear();
		System.out.println(list.toString());
		
		System.out.println("---------------");
		list.addLast("A");
		list.addLast(2);
		list.addLast("C");
		list.addLast("D");
		list.addLast(true);
		list.addLast("F");
		list.addLast("G");
		System.out.println(list.toString());
		
		System.out.println("---------------");
		boolean b = list.search("s");
		System.out.println(b);
		
		
		list.delete("F");
		list.delete("G");
		list.delete("C");
		list.delete("D");
		System.out.println(list.toString());
		
		System.out.println("---------------");
		
		list.replace(true, "4");
		System.out.println(list.toString());
		
		System.out.println("---------------");
		list.addLast("C");
		list.addLast("E");
		list.addLast("d");
		System.out.println(list.toString());
		try {
			list.insert(3, "B");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.toString());
	}
	
	
}
