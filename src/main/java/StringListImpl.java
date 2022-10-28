import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] stringList;
    private int size;

    public StringListImpl() {
        stringList = new String[10];
    }
    public StringListImpl(int length) {
        size = length;
        this.stringList = new String[length];
    }

    @Override
    public String add(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == null) {
                stringList[i] = item;
                System.out.println("Строка " + '"' + item + '"' + " была успешно добавлена");
                break;
            }
            if (stringList.length == i + 1) {
                size++;
                String[] temp = stringList;
                stringList = new String[size];
                for (int j = 0; j < temp.length; j++) {
                    stringList[j] = temp[j];
                }
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) throws ArrayIndexOutOfBoundsException {
        try {
            stringList[index] = item;
            System.out.println("Строка " + '"' + item + '"' + " на позицию " + index + " была успешно добавлена");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: добавление " + item + " на позицию " + index + " запрещено. Неверное значение границ массива.");
        }
        return item;
    }

    @Override
    public String remove(String item) throws IllegalArgumentException {
        try {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    stringList[i] = null;
                    System.out.println("Строка " + '"' + item + '"' + " была успешно удалена");
                    return item;
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
    public boolean contains(String item) throws NullPointerException {
        try {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    System.out.println("Строка " + '"' + item + '"' + " найдена. Она находится на позиции " + i);
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Строка " + '"' + item + '"' + " не найдена.");
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
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
    public int lastIndexOf(String item) {
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
    public String get(int index) throws ArrayIndexOutOfBoundsException {
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
        for (String s : stringList) {
            if (s == null) {
                counter--;
            }
        }
        System.out.println("Размер списка: " + counter);
        return counter;
    }

    @Override
    public boolean isEmpty() {
        for (String s : stringList) {
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
    public String[] toArray() {
        return Arrays.copyOf(stringList, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(stringList);
    }
}
