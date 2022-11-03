import java.util.Arrays;

public class StringListImpl implements StringList {
    private Integer[] stringList;
    private int size;

    public StringListImpl() {
        stringList = generateRandomArray();
    }

    public StringListImpl(int length) {
        size = length;
        this.stringList = new Integer[length];
    }

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[5000];
        for (Integer i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

    public Integer[] getStringList() {
        return stringList;
    }

    public void setStringList(Integer[] stringList) {
        this.stringList = stringList;
    }

    private static void swapElements(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    void sortInsertionRecursion(Integer[] arr, int i, int n) {

        int temp = arr[i];
        int j = i;
        while (j > 0 && arr[j - 1] >= temp) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = temp;

        if (i + 1 <= n) {
            sortInsertionRecursion(arr, i+1, n);
        }
    }

    void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private void grow() {
        size = size + size / 2;
        Integer[] temp = stringList;
        stringList = new Integer[size];
        for (int j = 0; j < temp.length; j++) {
            stringList[j] = temp[j];
        }
    }

    @Override
    public Integer add(Integer item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == null) {
                stringList[i] = item;
                System.out.println("Строка " + '"' + item + '"' + " была успешно добавлена");
                break;
            }
            if (stringList.length == i + 1) {
                grow();
            }
        }
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        try {
            if (stringList[index] == null) {
                stringList[index] = item;
                System.out.println("Строка " + '"' + item + '"' + " на позицию " + index + " была успешно добавлена");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: добавление " + item + " на позицию " + index + " запрещено. Неверное значение границ массива.");
        }
        return item;
    }

    @Override
    public Integer set(int index, Integer item) throws ArrayIndexOutOfBoundsException {
        try {
            stringList[index] = item;
            System.out.println("Строка " + '"' + item + '"' + " на позицию " + index + " была успешно добавлена");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: добавление " + item + " на позицию " + index + " запрещено. Неверное значение границ массива.");
        }
        return item;
    }

    @Override
    public String removeByContent(Integer item) throws IllegalArgumentException {
        try {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    stringList[i] = null;
                    System.out.println("Строка " + '"' + item + '"' + " была успешно удалена");
                    return Integer.toString(item);
                }
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Строка " + '"' + item + '"' + " не была найдена.");
        }
        return "Error: Строка " + '"' + item + '"' + " не была найдена.";
    }

    @Override
    public String remove(int index) throws ArrayIndexOutOfBoundsException {
        try {
            stringList[index] = null;
            System.out.println("Строка по номеру " + '"' + index + '"' + " была успешно удалена");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Строка " + '"' + index + '"' + " выходит за рамки массива.");
        }
        return Integer.toString(index);
    }

    @Override
    public boolean contains(Integer[] arr, int element) throws NullPointerException {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        try {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    System.out.println("Строка " + '"' + item + '"' + " найдена. Она находится на позиции " + i);
                    return i;
                }
            }
        } catch (NullPointerException e) {
            return -1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (stringList[i] == null) {
                i--;
            }
            if (stringList[i].equals(item)) {
                System.out.println("Строка " + '"' + item + '"' + " найдена. Она находится на позиции " + i);
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) throws ArrayIndexOutOfBoundsException {
        try {
            return stringList[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error. Введенный элемент выходит за границы массива.");
        }
        return stringList[index];
    }

    @Override
    public boolean equals(StringListImpl otherList) {

        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        int counter = stringList.length;
        for (Integer s : stringList) {
            if (s == null) {
                counter--;
            }
        }
        System.out.println("Размер списка: " + counter);
        return counter;
    }

    @Override
    public boolean isEmpty() {
        for (Integer s : stringList) {
            if (s != null) {
                System.out.println("Список не пуст");
                return false;
            }
        }
        System.out.println("Список пуст");
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null) {
                stringList[i] = null;
            }
        }
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(stringList, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(stringList);
    }
}
