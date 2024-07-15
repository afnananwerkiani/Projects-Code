public class HashTable {
    int[] Table;
    int numofCollisions = 0;
    int numofOccupiedCells = 0;
    int thresholdRehash = 5;

    HashTable(int s) {
        int size = s + (s / 3);
        int newSize = getPrime(size);
        Table = new int[newSize];
    }

    private int getPrime(int n) {
        while (true) {
            if (isPrime(n))
                return n;
            n++;
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public int Hash(int key) {
        return key % Table.length;
    }

    public int Rehash(int key, int i) {
        return (Hash(key) + i) % Table.length;
    }

    public void insert(int key) {
        int hash = Hash(key);
        int i = 0;
        while (Table[hash] != 0) {
            hash = Rehash(key, i);
            i++;
            if (i >= thresholdRehash) {
                System.out.println("Threshold reached for key " + key + ". Cannot insert.");
                return;
            }
            numofCollisions++;
        }
        Table[hash] = key;
        numofOccupiedCells++;
        if (numofOccupiedCells > Table.length / 3) {
            rehash();
        }
    }

    public boolean search(int key) {
        int hash = Hash(key);
        int i = 0;
        while (Table[hash] != 0) {
            if (Table[hash] == key) {
                System.out.println("Key " + key + " found at index " + hash);
                return true;
            }
            hash = Rehash(key, i);
            i++;
        }
        System.out.println("Key " + key + " not found.");
        return false;
    }

    private void rehash() {
        int newSize = getPrime(Table.length * 2);
        int[] newTable = new int[newSize];
        for (int key : Table) {
            if (key != 0) {
                int newHash = Hash(key);
                int i = 0;
                while (newTable[newHash] != 0) {
                    newHash = Rehash(key, i);
                    i++;
                }
                newTable[newHash] = key;
            }
        }
        Table = newTable;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < Table.length; i++) {
            str = str + "[" + i + "] " + Table[i] + "\n";
        }
        str += "Number of collisions: " + numofCollisions + "\n";
        return str;
    }
}