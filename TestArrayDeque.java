import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*; // star at the end imports everything within the assert package
import org.junit.Test;

//import


public class TestArrayDeque{
    // tests the ArrayDeque.resize(int refactor) method

    @Test
    public void testResize(){
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for(int i = 0; i < 11;i++){
            arr.addLast(i);
        }

        arr.toList();
        List<Integer> expected = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        List<Integer> actual = arr.toList();

        assertEquals(expected, actual);





    }

    @Test
    public void testSize(){
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(15);
        arr.addLast(20);
        arr.addFirst(25);
        arr.removeLast();
        assertFalse(arr.isEmpty());
        int expected = 2;
        assertEquals(expected, arr.size());



    }
    @Test
    public void testAddFirst(){
        ArrayDeque<Integer> newArr = new ArrayDeque<>();
        newArr.addFirst(10);
        newArr.addLast(20);
        newArr.addFirst(30);

        List<Integer> expected = Arrays.asList(30,10,20);
        assertEquals(newArr.size(),3);
        assertFalse(newArr.isEmpty());
        List<Integer> actual = newArr.toList();
        assertEquals(expected, actual);




    }

    @Test
    public void testAddLast(){
        ArrayDeque<Integer> newArr = new ArrayDeque<>();
        newArr.addLast(10);
        newArr.addLast(20);
        newArr.addLast(30);
        List<Integer> expected = Arrays.asList(10,20,30);
        assertEquals(newArr.size(),3);
        assertFalse(newArr.isEmpty());
        List<Integer> actual = newArr.toList();
        assertEquals(expected, actual);


    }

    @Test
    public void testRemoveFirst(){
        ArrayDeque<Integer> newArr = new ArrayDeque<>();
        newArr.addFirst(10);
        newArr.addFirst(20);
        newArr.addFirst(30);
        newArr.removeFirst();

        List<Integer> expected = Arrays.asList(20,10);
        assertEquals(2, newArr.size());
        assertFalse(newArr.isEmpty());
        List<Integer> actual = newArr.toList();
        assertEquals(expected, actual);



        //List<Integer> expected = Arrays.asList;

    }
    @Test
    public void testRemoveLast(){
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(10);
        arr.addFirst(20);
        arr.addFirst(30);
        arr.removeLast();

        List<Integer> expected = Arrays.asList(30,20);
        List<Integer> actual = arr.toList();

        assertEquals(2,arr.size());
        assertEquals(expected,actual);





        //List<Integer> expected = Arrays.asList;

    }

    @Test
    public void testRemoves(){
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(5);
        arr.addFirst(15);
        arr.addLast(20);
        arr.addLast(30);
        arr.removeFirst();
        arr.removeLast();

        List<Integer> expected = Arrays.asList(5,20);
        assertFalse(arr.isEmpty());
        assertEquals(expected, arr.toList());
    }

}
