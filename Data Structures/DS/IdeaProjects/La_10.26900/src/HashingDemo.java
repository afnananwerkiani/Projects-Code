import java.util.Random;

class HashingDemo {
    public static void main(String args[]) {
        HashTable H = new HashTable(100);
        Random R = new Random();
        for (int i = 0; i < 1000; i++) {
            int key = R.nextInt(900) + 100;
            H.insert(key);
        }
        System.out.println(H);
        int searchKey = R.nextInt(900) + 100;
        H.search(searchKey);
        System.out.println("Search for key " + searchKey + ": " + H);
    }
}