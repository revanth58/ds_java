class Node{
    int value;
    Node next, prev;

    Node(int data){
        this.value=data;
    }
}

class LL{    
    public static Node[] create_dlist(int arr[]){
        Node head=null, prev=null,p=null;
        for(int i=0;i<arr.length;i++){
            p=new Node(arr[i]);
            if(head==null){
                head=p;head.prev=null;
            }
            else {
                prev.next=p;p.prev=prev;
            }
            prev=p;
        }
        p.next=null;
        
        Node d_list[] = new Node[2];
        d_list[0]=head;
        d_list[1]=p;
        return d_list;
    }

    public static void ll_print(Node head){
        Node p=head;
        while (p!=null){
            System.out.println(p.value);
            p=p.next;
        }
    }

    public static void ll_print_reverse(Node tail){
        Node p=tail;
        while (p!=null){
            System.out.println(p.value);
            p=p.prev;
        }
    }

    public static Node ll_insert(Node head, int index, int new_value){
        if( index == 0){
            Node p=new Node(new_value);
            p.next=head;
            p.prev=null;
            head.prev=p;
            return p;
        }
        Node p=new Node(new_value);
        Node q=head;
        for(int i=0;i<index-1;i++){
            q=q.next;
        }
        Node r=q.next;
        q.next=p;p.next=r;
        r.prev=p;p.prev=q;
        return head;
    }

    public static void main(String[] args){
        System.out.println("doubly linked list implementation");
        int arr1[] = {323,454,65,34,56,78,0,9,35,4,23,11};
        Node d_list[] = create_dlist(arr1);
        //ll_print(d_list[0]);
        //System.out.println("printing in reverse....");
        //ll_print_reverse(d_list[1]);
        d_list[0] = ll_insert(d_list[0],10,9999);
        ll_print(d_list[0]);
    }
}