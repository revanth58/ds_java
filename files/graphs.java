class Queue {
    int arr[];
    int size;
    boolean isempty;
    int start; int end;
    Queue(int s){
        arr = new int[s];
        size=s;
        isempty = true;
    }

    public void push(int x){
        if(isempty == true){
            isempty = false;
            start = end = 0;
            arr[start] = x;
            //System.out.print("push into empty queue\n");
            return ;
        }
        if((end - start) % size == size-1){
            //System.out.print("ERROR : queue full\n");
            return ;
        }
        end = (end+1)%size;
        arr[end] = x;
        //System.out.print("PUSH successful\n");
    }

    public void pop(){
        if(isempty == true){
            //System.out.print("ERROR : queue already empty\n");
            return ;
        }
        if(start == end) {
            isempty = true;
            start=end=0;
            //System.out.print("POP successful. Queue now empty\n");
            return ;
        }
        start = (start +1 )%size;
        //System.out.print("POP successful\n");
    }

    public int peek(){
        if(isempty == true) {/*System.out.print("ERROR : queue empty\n");*/ return -1;}
        return arr[start];
    }

    public boolean isEmpty(){
        return isempty;
    }

    public int Size(){
        if(isempty == true) return 0;
        return 1 + ((end - start)%size) + (((end - start)%size <0)? size:0) ; 
    }

    public void print_queue(){
        if(isempty == true){
            //System.out.print("ERROR : queue empty\n");
            return ;
        }

        //System.out.print("starting at " + start +"...\n");
        for(int i=0;i<Size();i++){
            //System.out.print(arr[(start + i)%size] + " ");
        }//System.out.print("ending at " +end+ "...\n");
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