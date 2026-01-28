class Stack {
    /*
        arr  :  array to store the stack where the index 0 is 
                the bottom most element in the stack
        top  :  top will point to the index which is the top 
                most element, top will keep moving right
                as we keep adding elements and keep moving 
                left as we keep popping off the stack
    */
    
    
    int arr[];
    int top;

    Stack(int size){
        arr = new int[size];
        top = -1;
    }
    public void push(int x){
        if( top == arr.length-1){
            System.out.print("ERROR : stack is already full\n");
            return ;
        }
        top++;
        arr[top] = x;
        System.out.print("PUSH successful\n");
    }

    public void pop(){
        if(top == -1){
            System.out.print("ERROR : stack is already empty\n");
            return ;
        }
        top = top-1;
        System.out.print("POP successful\n");
    }

    public int peek(){
        if(top == -1){
            System.out.print("ERROR : stack is currently empty\n");
            return ;
        }
        return arr[top];
    }

    public boolean isempty(){
        if( top == -1)return true;
        return false;
    }

    public int size(){
        return top+1;
    }
    public void print_stack(){
        for(int i=0;i<=top; i++){
            System.out.print(arr[i] + " ");
        }
    }

}

class S {
    public static void main(String[] args) {
        Stack s1 = new Stack(6);
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(10);
        s1.print_stack();
        s1.push(11);
        for(int i=0;i<6;i++ ){
            s1.pop();
        }
        s1.pop();
    }

}
