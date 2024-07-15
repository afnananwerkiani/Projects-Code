public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList<>(6);
        myArrayList.add(14);
        myArrayList.add(84);
        myArrayList.add(25);
        myArrayList.add(65);
        myArrayList.add(19);
        myArrayList.add(48);

        System.out.println(myArrayList.toString());

        myArrayList.find(19);
        myArrayList.get(5);

        myArrayList.update(2, 69);
        System.out.println(myArrayList.toString());
//        myArrayList.remove(69);
        System.out.println(myArrayList.toString());

        System.out.println(" ");
        myArrayList.add(865);

        myArrayList.clear();
        System.out.println(myArrayList.toString());
    }
}
