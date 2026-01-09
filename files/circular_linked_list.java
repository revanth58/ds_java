class Node{
    int value;
    Node next;
    Node(int data){        // constructor1
        this.value = data;
    }
    Node(int data, Node nxt){  //constructor2
        this.value=data;
        this.next = nxt;
    }
}

class LL{
    
    public static Node ll_builder(int arr[]){
        Node head = null,prev=null,p=null;

        for(int i=0; i<arr.length; i++){
            p=new Node(arr[i]);
            if(head==null){
                head=p;
            }
            else prev.next = p;
            
            prev=p;
        }
        p.next=head;
        
        return head;
    }

    public static void ll_print(Node head){
        Node p=head;
        System.out.println(head.value);
        p=head.next;
        while( p!= head){
            System.out.println(p.value);
            p=p.next;
        }
    }

    public static void main(String[] args){
        System.out.println("circular linked list implementation");
        int arr1[] = {323,454,65,34,56,78,0,9,35,4,23,11};
        Node head = ll_builder(arr1);
        ll_print(head);
    }
}