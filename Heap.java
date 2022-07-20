import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Heap  {
    public final phoneBook[] Heap;
    public int size;
    private final int maxsize;
    private final phoneBookComparator comparator;
    private static final int FRONT =1;
    public Heap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new phoneBook[this.maxsize + 1];
        Heap[0] = new phoneBook("",  null , null ,null);
        comparator = new phoneBookComparator();
    }
    public int parent(int pos){return pos/2;}
    public int leftChild(int pos){return(2 * pos);}
    public int rightChild(int pos){return(2 * pos)+1;}
    private boolean isLeaf(int pos){
        if (pos >(size/2) && pos <= size ) {
            return true;
        }
        return false;
    }
    private void swap(int fpos,int spos){
        phoneBook tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;

    }
    private void minHeapify(int pos){
        if (!isLeaf(pos)) {
            if (comparator.compare(Heap[pos],Heap[leftChild(pos)])>0
                    || comparator.compare(Heap[pos], Heap[rightChild(pos)]) > 0)
            {
                if (comparator.compare(Heap[leftChild(pos)],Heap[rightChild(pos)]) < 0) {
                    swap(pos,leftChild(pos));
                    minHeapify(leftChild(pos));

                }
                else{
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    public void insert(phoneBook element){
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;
        while   (comparator.compare(Heap[current],Heap[parent(current)])< 0){
            swap(current,parent(current));
            current = parent(current);
        }
    }
    public void delete(String key){
        if (size <= 0) {
            return;
        }
        int current = find(key);
        if (current < 0) return;
        swap(size,current);
        Heap[size] = null;
        size--;
        System.out.println(current);
        if (leftChild(current)<= size || rightChild(current) <= size)  {
            while (comparator.compare(Heap[current],Heap[leftChild(current)]) > 0 || comparator.compare(Heap[current],Heap[rightChild(current)]) > 0){
                int swapped;
                if (comparator.compare(Heap[rightChild(current)],Heap[leftChild(current)])< 0 )
                    swapped = rightChild(current);
                else
                    swapped = leftChild(current);
                swap(current,swapped);
                current = swapped;
                //System.out.println(current);
                //System.out.println(leftChild(current)+" "+ rightChild(current));
                if(leftChild(current) > size || rightChild(current)> size) break ;
            }
        }
    }
    public int find(String key){
        phoneBook tmp = new phoneBook(key, null, null, null);
        int current= 0;
        while(comparator.compare(Heap[current],tmp) !=0){
            current++;
            if (comparator.compare(Heap[current], tmp)== 0)
                return current;
            else {
                System.out.println("NOT FOUND");
                break;
            }
        }
        return -1;
    }
    public phoneBook search(String key){
        for (int i = 1; i < size; i++) {
            if (Heap[i].getName().equals(key)) {
                return Heap[i];
            }
        }
        return new phoneBook( "Not found");
    }
    public int numberOfNodes() {return size;}
    public void inOrder(phoneBook root,int w){
        String[] s=new String[size];
        for (int i = 0; i < size; i++) {
            s[i] = Heap[i].getName();
        }
        int size = s.length;
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < s.length; j++) {
                System.out.println(i);
                if (s[i].compareTo(s[j])>0) {
                    System.out.println(s[i]);
                    String temp =s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        for (String f: s) {
            System.out.println(f);
        }
    }
    public int heightOfTree(){return (int)(Math.log(size)/Math.log(2)) +1;}
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println("Parent :" + Heap[i].getName());
            if (2 * i <= size)
                System.out.println("leftChild :" + Heap[2 * i].getName());
            if (2 * i + 1 <= size)
                System.out.println("Right Child :" + Heap[2 * i + 1].getName());
            System.out.println();
        }
    }


    public phoneBook remove () {
        phoneBook popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
    class phoneBookComparator implements Comparator<phoneBook> {
        @Override
        public int compare(phoneBook o1, phoneBook o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    }
}


