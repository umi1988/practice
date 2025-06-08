class Stack{
    int stack[] = new int[4];
    int top=0;

    public void push(int data){
        if(top==5){
            System.out.println("Stack is full");
        }else{
            stack[top] = data;
            top++;
        }
    }

    public int pop(){
        int data=0;
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            top--;
            data = stack[top];
            stack[top] = 0;
        }
        return data;
    }

    public int peek(){
        int data;
        data = stack[top-1];
        return data;
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top<=0;
    }

    public void show(){
        for(int i : stack){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class StackImplDemo1 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        //System.out.println(stack.peek());
        stack.push(30);
       // System.out.println(stack.pop());
       System.out.println(stack.size());
       System.out.println(stack.isEmpty());
        stack.show();
    }
}
