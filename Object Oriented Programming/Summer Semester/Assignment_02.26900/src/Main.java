import java.util.ArrayList;

class KeyValuePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class CustomHashMap<K, V> {
    private ArrayList<KeyValuePair<K, V>> itemList;

    public CustomHashMap() {
        itemList = new ArrayList<>();
    }

    public void put(K key, V value) {
        KeyValuePair<K, V> pair = findPairByKey(key);
        if (pair != null) {
            pair.setValue(value);
        } else {
            itemList.add(new KeyValuePair<>(key, value));
        }
    }

    public V get(K key) {
        KeyValuePair<K, V> pair = findPairByKey(key);
        return pair != null ? pair.getValue() : null;
    }

    public void remove(K key) {
        KeyValuePair<K, V> pair = findPairByKey(key);
        if (pair != null) {
            itemList.remove(pair);
        }
    }

    private KeyValuePair<K, V> findPairByKey(K key) {
        for (KeyValuePair<K, V> pair : itemList) {
            if (pair.getKey().equals(key)) {
                return pair;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> customMap = new CustomHashMap<>();

        customMap.put("key1", 10);
        customMap.put("key2", 20);
        customMap.put("key3", 30);

        System.out.println(customMap.get("key2")); // Output: 20

        customMap.remove("key1");

        System.out.println(customMap.get("key1")); // Output: null
    }
}
