import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    public MaxArrayDeque(){

    }

    public MaxArrayDeque(Comparator<T> c){
        comp = c;
    }

    // super is by default being called

    // returns the maximum element in the deque as governed by the
    // previously given Comparator. If the MaxArrayDeque is empty, return null

    public T max(){
        //check if empty
        if (size() == 0){
            return null;
        }
        T maxVal = get(nextFirst+1); // second , not first
        // for each loop to go through it
        for(T thing: this){
            // use the instance variable comp
            if(comp.compare(thing, maxVal) > 0){ // > 0 means it is greater
                // we get compare from Comparator
                // comparing the first and second
                maxVal = thing;

            }
        }
        return maxVal;

    }

    // returns the maximum element in the deque as governed by
    // the parameter Comparator c
    // If the MaxArrayDeque is empty, simply return null

    public T max(Comparator<T> c){
        // check if empty
        if(size() == 0){
            return null;
        }
        T maxVal = get(nextFirst+1);
        for(T thing : this){
            // use c
            if(c.compare(thing, maxVal) > 0){
                // now it is the new maximum value
                maxVal = thing;
            }
        }
        return maxVal;
    }
}
