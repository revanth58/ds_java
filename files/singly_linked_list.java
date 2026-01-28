class Node{
    /*
        every node contains 2 things : value, next
        value : stores the value in our current node
        next  : references the next node in the list

        To give a list, you only need to pass the head node
    */
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
            }else prev.next = p;
            prev=p;
        }p.next=null;
        return head;
    }

    public static void ll_print(Node head){
        Node p=head;
        while (p!=null){
            System.out.println(p.value);
            p=p.next;
        }
    }

    public static void ll_search(Node head, int key){
        Node p=head;
        while(p!=null){
            if(p.value == key){
                System.out.println("YES");return ;
            }
            p=p.next;
        }
        System.out.println("NO");
    }

    public static void ll_append_end(Node head, int new_value){
        if(head==null){head = new Node(new_value,null); return ;}
        Node p=head;
        while(p.next !=null)p=p.next;
        p.next=new Node(new_value,null);
    }

    public static void ll_append_start(Node head, int new_value){
        Node p= new Node(new_value);
        p.next=head;
        head=p;
    }

    public static void ll_insert(Node head, int index, int new_value){
        if(index == 0){
            ll_append_start(head,new_value);
            return;
        }

        Node p=head;
        for(int i=0;i<index-1;i++){
            p=p.next;
        }
        Node q=new Node(new_value);
        Node r=p.next;
        p.next=q;q.next=r;
    }

    public static Node ll_reverse(Node head){
        Node prev=null,curr=head,next=head.next;
        while(curr !=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args){
        System.out.println("linked list implementation");
        int arr1[] = {323,454,65,34,56,78,0,9,35,4,23,11};
        Node head = ll_builder(arr1);
        //ll_print(head);
        ll_search(head,35);
        ll_search(head,25);
        ll_append_end(head,88);
        

        ll_insert(head,10,9999);
        head = ll_reverse(head);
        ll_print(head);
    }
}
