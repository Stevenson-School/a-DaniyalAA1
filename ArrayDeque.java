
/*
For this implementation, your operations are subject to the following rules:

add and remove must take constant time, except during resizing operations.
get and size must take constant time.
The starting size of your array should be 8.
Implement all the methods listed above in “The Deque API” section.

In addition, you also need to implement:

public ArrayDeque(): Creates an empty array deque.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class ArrayDeque<T> implements Deque<T>, Iterable<T>{ // name of the generic type has to be consistent
    // front is at position 0;

    private T[] arr;

    protected int nextFirst; // position in the array where an item will go if addFirst is called

    //addFirst and addLast have to be adjacent to each other

    private int nextLast; // position in the array where an item will go if addLast is called

    private int size; // how many items are in the array

    private final int RFACTOR = 2;
    public ArrayDeque() {
        arr = (T[]) new Object[8]; // java does not like generic arrays
        // cast as an item
        nextFirst = 0;
        nextLast = nextFirst + 1;
        size = 0;
    }
    private void resize(int capacity){ // resize without using arrayCopy
        // reconfigure nextFirst and nextLast
        // nextFirst = 0;
        // nextLast = nextFirst + size;
        T[] tempArr =  (T[]) new Object[capacity];
        for(int i = 0; i < size();i++){
            tempArr[i+1] = get(i);
        }
        nextFirst = 0;
        nextLast = nextFirst + size + 1;
        arr = tempArr;
        //nextFirst = 0;
        // nextLast = nextFirst + size + 1;
    }

    @java.lang.Override
    public void addFirst(T item) { // resize the array to add a space for the new value
        // shift everything over
        if(size == arr.length) {
            resize(arr.length * RFACTOR);
        }
       // resize(RFACTOR);
        arr[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst -1, arr.length);
       //nextFirst++;
        size++;
    }
    @java.lang.Override
    public void addLast(T item) {
        if(size == arr.length) {
            resize(arr.length * RFACTOR);
        }
        arr[nextLast] = item;
        // nextLast++;
        nextLast = (nextLast + 1) % arr.length;
        size++;
    }

    @java.lang.Override
    public boolean isEmpty() {
        return size == 0;
    }

    @java.lang.Override
    public int size() {
        return size;
    }

    @java.lang.Override
    public T removeFirst() {
        T stored = arr[nextFirst + 1];
        arr[nextFirst + 1] = null;
        // nextFirst--;
        // nextFirst = (nextFirst -1) % arr.length;
        // nextFirst = (nextFirst -1) % arr.length;
        nextFirst++;
        size = size -1;
        return stored;
    }

    @java.lang.Override
    public T removeLast() {
        T stored = arr[nextLast -1];
        arr[nextLast -1] = null;
        nextLast--;
        size--;
        return stored;
    }

    @java.lang.Override
    public T get(int index) {
        // has to be in relation to the first
        // think about first
        return arr[(nextFirst + 1 + index) % arr.length];
    }



    @java.lang.Override
    public void printDeque() {
        for(int i = 0; i < size();i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public List<T> toList() { //primarily for the testing class
        List<T> list = new ArrayList<>();
        // use the get method
        for(int i = 0; i < size(); i++){
            list.add(get(i));
        }
        return list;
    }

    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T>{
        int position;

        @Override
        public boolean hasNext(){
            return position < size();
        }

        @Override
        public T next(){
            return arr[position++];
        }
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object instanceof ArrayDeque o){
            if(size() != o.size()) {
                return false;
            }
            for(int i = 0; i < size(); i++){
                if(!get(i).equals(o.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String ret = "{";
        for(int i = 0; i < size;i++){
            ret += get(i) + ", ";
        }
        ret += "}";
        return ret;
    }

//    This is the default code given
//    @Override
//    public String toString(){
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }

    public static void main(String[] args) {
        ArrayDeque<Double> deck = new ArrayDeque<>();
        deck.addLast(2.3);
        deck.addLast(0.0);
        deck.addFirst(4.7);
        System.out.println(deck);


        ArrayDeque<Double> deck2 = new ArrayDeque<>();
        deck2.addLast(2.3);
        deck2.addLast(0.0);
        deck2.addFirst(4.7);
        System.out.println(deck2);
        System.out.println(deck.equals(deck2));
        for(Double d: deck2){
            System.out.println(d);
        }
        System.out.println();

        for(Double d: deck){
            System.out.println(d);
        }


        Comparator<Integer> ic = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) o1 - o2;
            }
        };
        MaxArrayDeque<Integer> maxDeck = new MaxArrayDeque<>();
        maxDeck.addFirst(1);
        maxDeck.addLast(2);
        maxDeck.addLast(3);
        System.out.println(maxDeck.max(ic));



        //System.out.println(deck);
        //System.out.println(deck.toString());
        //deck.resize(8);
        //System.out.println(deck.toString());
    }
}
