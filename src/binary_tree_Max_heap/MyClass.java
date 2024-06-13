package binary_tree_Max_heap;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Value : ");
        int value = input.nextInt();


        Max_Heap maxHeap= new Max_Heap(value);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);

        maxHeap.maxHeap();
        maxHeap.displayItems();

        System.out.println("-----------------------------------------------");


        System.out.println("Max Element in the Heap : "+maxHeap.remove());
        maxHeap.displayItems();
    }

}

class Max_Heap{

    int[] heap;
    int max_size;
    int size;

    public static final int Front=1;
    Max_Heap(int max_size){
        this.max_size= max_size;
        heap= new int[max_size];

        heap[0]=Integer.MAX_VALUE;

        size=0;

    }

    //Calculate Parent Position

    public int parentNode(int pos){
        return pos/2;
    }
    //calculate LeftChild Position
    public int  leftChild(int pos){
        return pos * 2;
    }

    //calculate RightChild Position

    public int rightChild(int pos){
        return (pos * 2)+1;
    }




    public boolean isLeaf(int pos){
        if(pos > (size/2) && pos <= size){
            return true;
        }return false;
    }


    public void swap(int pos1,int pos2){
        int temp=heap[pos1];
        heap[pos1]=heap[pos2];
        heap[pos2]=temp;

    }


    public void maxHeapFy(int pos){
        if(!(isLeaf(pos))){
            if(size >= leftChild(pos) && size >= rightChild(pos) ){

                if(heap[pos] < heap[leftChild(pos)] ||  heap[pos] < heap[rightChild(pos)]){
                    if(heap[leftChild(pos)] > heap[rightChild(pos)]){

                        swap(pos,leftChild(pos));
                        maxHeapFy(leftChild(pos));

                    }else{
                        swap(pos,rightChild(pos));
                        maxHeapFy(rightChild(pos));

                    }
                }

            }

        }
    }

    public void insert(int element){
        heap[++size]=element;
        int current = size;

        while(heap[current] > heap[parentNode(current)]){
            swap(current,parentNode(current));
            current=parentNode(current);
        }
    }


    public void maxHeap(){
        for(int i = size/2;i >= 1;i--){
            maxHeapFy(i);
        }
    }

    public int remove(){
        int poppup = heap[Front];
        heap[Front]=heap[size--];
        maxHeapFy(Front);
        return poppup;

    }


    public void displayItems(){
        for (int i=1;i <= size/2;i++){
            System.out.println("Parent Node : "+heap[i]);
            System.out.println("Left Child : "+heap[leftChild(i)]);
            System.out.println("Right Child : "+heap[rightChild(i)]);

        }

    }
}
