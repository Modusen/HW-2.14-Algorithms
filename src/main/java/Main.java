import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        StringListImpl stringList = new StringListImpl();
//        long start = System.currentTimeMillis();
//        StringListImpl.sortBubble(stringList.getStringList());
//        System.out.println((System.currentTimeMillis()-start)/1000 + " секунд. Сортировка пузырьковая");
//
//        StringListImpl stringList1 = new StringListImpl();
//        long start1 = System.currentTimeMillis();
//        StringListImpl.sortSelection(stringList1.getStringList());
//        System.out.println((System.currentTimeMillis()-start1)/1000 + " секунд. Сортировка выбором");

        StringListImpl stringList2 = new StringListImpl();
        long start2 = System.currentTimeMillis();
        stringList2.sortInsertion(stringList2.getStringList());
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