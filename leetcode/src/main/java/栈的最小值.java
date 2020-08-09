import java.util.Stack;

/**
 * @Classname 栈的最小值
 * @Description TODO
 * @Date 2020/4/25 20:33
 * @Created by Ma
 */
public class 栈的最小值 {

    Stack<Integer> stackMin;
    Stack<Integer> stackHelp;
    /** initialize your data structure here. */
    public 栈的最小值() {
        stackMin = new Stack();
        stackHelp = new Stack();
    }

    public void push(int x) {
        if(stackMin.empty()){
            stackMin.push(x);
        }else if(stackMin.peek()>x){
            stackMin.push(x);
        }else{
            stackMin.push(stackMin.peek());
        }
        stackHelp.push(x);
    }

    public void pop() {
        stackHelp.pop();
        stackMin.pop();
    }

    public int top() {

        return stackHelp == null ? 0 : stackHelp.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
