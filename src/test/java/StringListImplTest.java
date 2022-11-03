import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringListImplTest {


    @Test
    public void addItemPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        Integer actual = stringList.add(5);
        Integer expected = 5;
        assertEquals(actual, expected);
    }

    @Test
    public void addIndexPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        Integer actual = stringList.add(0, 2);
        Integer expected = 2;
        assertEquals(actual, expected);

        int expectedIndex = 0;
        int actualIndex = stringList.indexOf(2);
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void setPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        Integer actual = stringList.set(0, 3);
        Integer expected = 3;
        assertEquals(actual, expected);

        int expectedIndex = 0;
        int actualIndex = stringList.indexOf(3);
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void getIndexPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(4);
        Integer actual = stringList.get(0);
        Integer expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void removeItemPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 5);
        stringList.remove(0);
        Integer actual = stringList.get(0);
        Integer expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void removeIndexPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 6);
        stringList.remove(0);
        Integer actual = stringList.get(0);
        Integer expected = null;
        assertEquals(actual, expected);
    }

    //    @Test
//    public void containsItemPositiveTest() {
//        StringListImpl stringList = new StringListImpl(2);
//        stringList.add(0,7);
//        assertTrue(stringList.contains(7));
//    }

    @Test
    public void sortingPositiveTest() {
        StringListImpl stringList = new StringListImpl(4);
        stringList.add(0, 7);
        stringList.add(1, 4);
        stringList.add(2, 1);
        stringList.add(3, 999);
        stringList.sortInsertion(stringList.getStringList());
        Integer[] expected = new Integer[]{1,4,7,999};
        System.out.println(Arrays.toString(stringList.getStringList()));
        System.out.println(Arrays.toString(expected));
        assertEquals(Arrays.toString(stringList.getStringList()), Arrays.toString(expected));
    }
    @Test
    public void sortingRecursivePositiveTest() {
        StringListImpl stringList = new StringListImpl(4);
        stringList.add(0, 7);
        stringList.add(1, 4);
        stringList.add(2, 1);
        stringList.add(3, 999);
        stringList.sortInsertionRecursion(stringList.getStringList(),0,3);
        Integer[] expected = new Integer[]{1,4,7,999};
        System.out.println(Arrays.toString(stringList.getStringList()));
        System.out.println(Arrays.toString(expected));
        assertEquals(Arrays.toString(stringList.getStringList()), Arrays.toString(expected));
    }
    @Test
    public void containsItemPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 7);
        assertTrue(stringList.contains(stringList.getStringList(),7));
    }
    @Test
    public void containsItemNegativeTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 7);
        stringList.add(1, 126);
        assertFalse(stringList.contains(stringList.getStringList(),66734));
    }

    @Test
    public void indexOfPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 8);
        stringList.add(1, 8);
        int expected = -1;
        assertEquals(expected, stringList.indexOf(89));
    }

    @Test
    public void lastIndexOfPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 9);
        stringList.add(1, 10);
        int expected = 1;
        assertEquals(expected, stringList.lastIndexOf(10));
    }

    @Test
    public void sizePositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 11);
        stringList.add(1, 12);
        int expected = 2;
        assertEquals(expected, stringList.size());
    }

    @Test
    public void isEmptyFalseTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 13);
        assertFalse(stringList.isEmpty());
    }

    @Test
    public void isEmptyTrueTest() {
        StringListImpl stringList = new StringListImpl(2);
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void clearPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0, 14);
        stringList.add(1, 15);
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

}
