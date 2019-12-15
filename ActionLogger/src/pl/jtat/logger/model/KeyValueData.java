package pl.jtat.logger.model;

public class KeyValueData<K,V> {

    private K key;
    private V value;

    public KeyValueData(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
