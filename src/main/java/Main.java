import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(4);
        stringList.add(3,1);
        System.out.println(Arrays.toString(stringList.getStringList()));
        stringList.add(1);
        stringList.add(1);
        System.out.println(Arrays.toString(stringList.getStringList()));
        stringList.add(15);
        System.out.println(Arrays.toString(stringList.getStringList()));

        StringListImpl stringList2 = new StringListImpl();
        long start2 = System.currentTimeMillis();
        stringList2.sortInsertionRecursion(stringList2.getStringList(),0,4999);
        System.out.println((System.currentTimeMillis()-start2)/1000 + " секунд. Сортировка вставкой");
        System.out.println(stringList2);

        long start3 = System.currentTimeMillis();
        if (stringList2.contains(stringList2.getStringList(), 99998)) {
            System.out.println("Запрашиваемый элемент есть в массиве");
        } else {
            System.out.println("Такого элемента нет");
        }
        System.out.println(System.currentTimeMillis()-start3 + " миллисекунд.");
    }

}