package Cooper.alg1_1LIFO_stack;

//中序表达式转后续表达式
import java.util.Stack;
public class InfixToPostfix {
    private String infixToPostfix(String str)
    {
        Stack<String> dataStack = new Stack<>();
        Stack<String> optrStack = new Stack<>();

        for (int i = 0; i < str.length(); i++)
        {
            if(isDigital(str.charAt(i)))	//处理数字
                dataStack.push(String.valueOf(str.charAt(i)));//如果是数字压入dataStack
            else if(isOperator(str.charAt(i)))	//处理操作符
                optrStack.push(String.valueOf(str.charAt(i)));
            else if(str.charAt(i) == ')')	//处理右括号的情况,遇到右括号则将datastatck中的
            {
                String d1 = dataStack.pop();
                String d2 = dataStack.pop();
                String opt = optrStack.pop();
                String ext = d2 + d1 + opt;
                dataStack.push(ext);
            }
            else if(str.charAt(i) == '(')
                continue;
        }

        while(optrStack.size() > 0)     //optrStack.size() > 0,必然意味着dataStack有两个值,这是很容易理解的
        {
            String d1 = dataStack.pop();
            String d2 = dataStack.pop();
            String opt = optrStack.pop();
            String ext = d2 + d1 + opt;
            dataStack.push(ext);
        }
        return dataStack.pop();
    }
    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    private boolean isDigital(char ch)
    {
        return ch <= '9' && ch >= '0';
    }
    public static void main(String[] args)
    {
        String str = "(1+2)*(3*(4+5))";
        InfixToPostfix ip = new InfixToPostfix();
        String res = ip.infixToPostfix(str);
        System.out.println(res);
    }

}
