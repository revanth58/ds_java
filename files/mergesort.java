class m{

    public void merge(int x1,int y1, int x2,int y2,int a[]){
        int L[] = new int[y1-x1+1];
        int R[] = new int[y2-x2+1];

        for(int i=x1;i<=y1;i++){
            L[i-x1] = a[i];
        }
        for(int i=x2;i<=y2;i++){
            R[i-x2] = a[i];
        }

        int p=x1,q=x2;

        for(int i=x1;i<=y2;i++){
            if(p== y1+1){
                for(;i<=y2;i++){
                    a[i] = R[q-x2];q++;
                }break;
            }
            if(q== y2+1){
                for(;i<=y2;i++){
                    a[i] = L[p-x1];p++;
                }break;
            }
            if(L[p-x1]<R[q-x2]){
                a[i] = L[p-x1];p++;
            }else {
                a[i] = R[q-x2];q++;
            }
        }
    }

    public void mergesort(int x,int y, int a[]){
        int z=(x+y)/2;
        if(x==y){
            return ;
        }
        mergesort(x,z,a);
        mergesort(z+1,y,a);
        merge(x,z,z+1,y,a);
    }


    public void main(String[] args){
        int a[] = {1000,70,12,11,15,102,968,1,10, 14, 28, 11, 7, 16, 30, 50, 25, 18};
        mergesort(0,a.length-1,a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }System.out.println("");
    }
}