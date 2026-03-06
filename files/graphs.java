class Queue{
    int size;
    int arr[];
    int start,length;
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


class G{

    public static void BFS(int[][] E, int n){
        Queue q = new Queue(E.length);
        q.push(n);
        int visited[] = new int[E.length];
        visited[n] = 1;
        while(q.isEmpty() == false){
            int x=q.peek();
            System.out.print(x + " ");
            q.pop();
            
            for(int i=0;i<E[x].length;i++){
                if(visited[E[x][i]] == 0){
                    q.push(E[x][i]);
                    visited[E[x][i]]=1;
                }
            }
        }System.out.print("\n");
    }

    public int time = 0;
    public int visited[];
    public int previsit[];
    public int postvisit[];

    public  void explore(int[][] E,int n){
        if(visited[n]==1)return ;
        visited[n] = 1;
        time++; previsit[n]=time;
        for(int i=0;i<E[n].length;i++){
            if(visited[E[n][i]] == 0){
                explore(E,E[n][i]);
            }
        }
        time++; postvisit[n]=time;
    }

    public  void DFS(int[][] E){
        int V = E.length;
        visited = new int[V];
        previsit = new int[V];
        postvisit = new int[V];
        for(int i=1;i<V;i++){
            if(visited[i]==0)explore(E,i);
        }
        System.out.print("previsit times : ");
        for(int i=1;i<V;i++){
            System.out.print(previsit[i]+ " ");
        }
        System.out.print("\npostvisit times : ");
        for(int i=1;i<V;i++){
            System.out.print(postvisit[i]+ " ");
        }System.out.println();
    }


    public void main(String[] args){
        int [][] E= {
            {},{2,3,6},{1,3,4},{1,2,4,6},
            {2,3},{6},{1,3,5},{8},
            {7,9},{8}
        // E is your adjacency list
        // of edges indexed by 
        // vertex numbers
        };
        BFS(E,1);
    }

}
