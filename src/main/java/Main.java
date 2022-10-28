
public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(2);
        System.out.println(stringList); // Вывод на экран массива
        stringList.add("Something");
        System.out.println(stringList); // Вывод на экран массива
        stringList.add("Something1");
        System.out.println(stringList); // Вывод на экран массива
        stringList.add("Something2");
        System.out.println(stringList); // Вывод на экран массива
        stringList.set(0,"Замена");
        System.out.println(stringList); // Вывод на экран массива
        stringList.remove("Замена1");
        stringList.remove("Замена1");
        stringList.add(1,"Something5");
        stringList.add(6,"Something5");
        stringList.set(1,"Замена1");
        stringList.add("Something2");
        stringList.add("Something5");
        stringList.set(4,"Something3");
        System.out.println(stringList); // Вывод на экран массива
//        stringList.indexOf("Something5");
//        stringList.lastIndexOf("Something5");
        stringList.get(2);
        stringList.size();
        stringList.isEmpty();
        stringList.clear();
        System.out.println(stringList); // Вывод на экран массива
        stringList.isEmpty();
        String[] stringList1 = stringList.toArray();
        System.out.println(stringList1.toString()); // Вывод на экран массива

    }
}