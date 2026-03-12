import java.util.Scanner;
import java.util.Arrays;


class N{
    //  not implementing linear search, do it yourself

    public int binary_search(int[] arr, int key){
        int start =0, end = arr.length-1;
        while(start != end){
            if(arr[(start+end)/2] == key)return (start+end)/2;
            if(arr[(start+end)/2] < key){
                start = (start+end)/2 + 1;
                continue;
            }else{
                end = (start+end)/2;
            }
        }
        System.out.println("failed at " + start);
        return -1;
    }

    public void bubble_sort(int[] arr){
        int x[] = Arrays.copyOf(arr, arr.length);
        int z=1;
        int temp;
        while(z!=0){
            z=0;
            for(int i=0;i<x.length-1;i++){
                if(x[i] > x[i+1]){
                    temp = x[i];
                    x[i] = x[i+1];
                    x[i+1] = temp;z++;
                }
            }
        }
        for(int i=0;i<x.length;i++){
            System.out.print(x[i] + " ");
        }
        System.out.println("");
    }

    public void selection_sort(int[] arr){
        int x[] = Arrays.copyOf(arr, arr.length);
        int temp;
        for(int i=0;i<x.length-1;i++){
            for(int j=i+1;j<x.length;j++){
                if(x[j]<x[i]){
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
        for(int i=0;i<x.length;i++){
            System.out.print(x[i] + " ");
        }
        System.out.println("");
    }

    public void insertion_sort(int[] arr){
        int[] x = Arrays.copyOf(arr, arr.length);int key;
        for(int i=1;i<x.length;i++){
            if(x[i] >= x[i-1])continue;
            key = x[i];
            for(int j=i;j>=0;j--){
                if(j==0){x[j] = key; break;}
                if(x[j-1]>key){
                    x[j] = x[j-1];
                }
                else {
                    x[j] = key;break;
                }
            }
        }
        for(int i=0;i<x.length;i++){
            System.out.print(x[i] + " ");
        }
        System.out.println("");
    }

    public void main(String[] args){
        int arr[] = {45, -2, 8, -15, 60, 23, -7, 10, -30, 5, -50, 18, -25, 3, 99, -1, 14, -40, 72, -10};
        in_sort(arr);
        bitch_sort(arr);
        s_sort(arr);
    }
}