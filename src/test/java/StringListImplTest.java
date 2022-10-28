import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringListImplTest {


    @Test
    public void addItemPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        String actual = stringList.add("name");
        String expected = "name";
        assertEquals(actual, expected);
    }
    @Test
    public void addIndexPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        String actual = stringList.add(0,"name");
        String expected = "name";
        assertEquals(actual, expected);

        int expectedIndex = 0;
        int actualIndex = stringList.indexOf("name");
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void setPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        String actual = stringList.set(0,"name");
        String expected = "name";
        assertEquals(actual, expected);

        int expectedIndex = 0;
        int actualIndex = stringList.indexOf("name");
        assertEquals(actualIndex, expectedIndex);
    }
    @Test
    public void getIndexPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add("name");
        String actual = stringList.get(0);
        String expected = "name";
        assertEquals(actual, expected);
    }

    @Test
    public void removeItemPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0,"name");
        stringList.remove("name");
        String actual = stringList.get(0);
        String expected = null;
        assertEquals(actual, expected);
    }
    @Test
    public void removeIndexPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0,"name");
        stringList.remove(0);
        String actual = stringList.get(0);
        String expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void containsItemPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0,"name");
        assertTrue(stringList.contains("name"));
    }
    @Test
    public void indexOfPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0,"name");
        stringList.add(1,"name");
        int expected = -1;
        assertEquals(expected, stringList.indexOf("name1"));
    }
    @Test
    public void lastIndexOfPositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0,"name");
        stringList.add(1,"name2");
        int expected = 1;
        assertEquals(expected, stringList.lastIndexOf("name2"));
    }
    @Test
    public void sizePositiveTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0,"name");
        stringList.add(1,"name2");
        int expected = 2;
        assertEquals(expected, stringList.size());
    }
    @Test
    public void isEmptyFalseTest() {
        StringListImpl stringList = new StringListImpl(2);
        stringList.add(0,"name");
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
        stringList.add(0,"name");
        stringList.add(1,"name1");
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

}
