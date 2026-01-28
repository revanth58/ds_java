class Queue{
    int size;  
    int arr[];  
    int start,length;
  /*
    size : max length of queue
    arr : the array to store the queue
    start : starting index of the queue's front element
    length : current no. of elements in the queue
  */
    // constructor that initializes everything and creates an "empty array of given queue size"
    Queue(int s){
        if(s<=0){
            System.out.print("ERROR : give a proper size\n");
        }
        start=length=0;
        size=s;
        arr = new int[size];
    }

    public void push(int x){
        if(length ==size){
            System.out.print("ERROR : queue already full..\n");
            return ;
        }
        length++;
        arr[(start+length-1)%size]=x;
    }

    public void pop(){
        if(length == 0){
            System.out.print("ERROR : queue is empty man..\n");
            return ;
        }
        length -=1;
        start = (start+1)%size;
    }

    public int peek(){
        if(length == 0){System.out.print("ERROR : queue is empty man..\n");}
        return arr[start];
    }

    public boolean isempty(){return length==0;}

    public void print_queue(){
        System.out.print("starting at " + start + " and length is " + length + "...\n");
        for(int i=0;i<length;i++){
            System.out.print(arr[(start+i)%size] + " ");
        }
        System.out.print("\n");
    }

    public int size(){
        return length;
    }
}

class Q{
    public static void main(String[] args){
        Queue q1 = new Queue(4);
        q1.push(1);
        q1.pop();
        q1.push(2);
        q1.pop();
        System.out.print("---------\n");
        for(int i=0;i<5;i++){
            q1.push(i);
        }
        q1.print_queue();
    }
}
