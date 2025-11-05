package com.starttohkar.practice;

import java.util.LinkedList;

public class CustomHashMap<K,V> {
    /**
    1. Entry Class
    This is a simple container for each key-value pair.
    - It stores a key and its associated value.
    - Used inside the buckets to hold actual data.
     */
    public static class Entry<K,V>{
        K key;
        V value;

        Entry(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    private final int INITIAL_CAPACITY = 16;
    /**
    2. Buckets
    - The hashmap uses an array of linked lists.
    - Each index in the array is a bucket that holds entries with the same hash index (i.e., collisions).
     */

    /**
     * Why Use LinkedLists?
     * This design uses separate chaining to handle collisions:
     * Multiple keys can hash to the same index.
     * Instead of overwriting, we store them in a list at that index.
     */
    private LinkedList<Entry<K, V>>[] buckets;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }
    /**
    3. Hash Function
    - Converts a key into an array index.
    - Uses Java’s built-in hashCode() and ensures it's within bounds of the array.
     */
    private int getBucketIndex(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    /**
    put(K key, V value)
    - Adds or updates a key-value pair.
    - Calculates the bucket index.
    - If the key already exists, updates the value.
    - If not, adds a new entry to the bucket.
     */
    public void put(K key, V value){
        int index = getBucketIndex(key);
        if(buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K,V> entry : buckets[index]){
            if(entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    /**
      get(K key)
     - Retrieves the value for a given key.
     - Finds the correct bucket using the hash function.
     - Searches the bucket for the key.
     - Returns the value if found, otherwise returns null.
     */
    public V get(K key){
        int index = getBucketIndex(key);
        LinkedList<Entry<K,V>> bucket = buckets[index];
        if(bucket != null){
            for (Entry<K, V> entry : buckets[index]){
                if(entry.key.equals(key)){
                    return entry.value;
                }
            }
        }
        return null;
    }
    /**
    Deletes a key-value pair.
    - Finds the correct bucket.
    - Searches for the key and removes the entry.
    - Decreases the size counter.
     */
    public boolean remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }
    /**
    size()
    -Returns the number of key-value pairs stored.
    */
    public int size() {
        return size;
    }
    /**
     * Prints all key-value pairs in the hashmap.
     */
    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Entry<K, V>> bucket = buckets[i];
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    System.out.println("Key: " + entry.key + ", Value: " + entry.value);
                }
            }
        }
    }


    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        System.out.println(map.size());
        System.out.println("Value for 'banana': " + map.get("banana"));
        map.remove("apple");
        map.printMap();
        System.out.println(map.size());
    }
}
