class CustomLinkedList {
    private final int key;
    private int value;
    public CustomLinkedList next; // Made public for direct access in CustomHashMap

    public CustomLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    public int getKey() {
        return key;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }
}

class CustomHashMap {
    private static final int DEFAULT_CAPACITY = 100000; // More reasonable capacity
    private CustomLinkedList[] bucket;
    private int capacity;

    public CustomHashMap(){
        this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity){
        this.capacity = capacity;
        this.bucket = new CustomLinkedList[capacity];
        // Java arrays of object types are initialized with null by default, no explicit loop needed.
    }

    private int getIndex(int key){
        return key % capacity;
    }

    public void put(int key, int value){
        int index = getIndex(key);
        CustomLinkedList current = bucket[index];

        // Traverse the list to check if key already exists
        while(current != null){
            if(current.getKey() == key){
                current.setValue(value); // Update value if key found
                return;
            }
            current = current.next;
        }

        // If key not found, add new node at the head of the list (O(1) insertion)
        CustomLinkedList newNode = new CustomLinkedList(key, value);
        newNode.next = bucket[index]; // Link new node to the old head
        bucket[index] = newNode;      // Update bucket to point to new node
    }

    public int get(int key){
        int index = getIndex(key);
        CustomLinkedList current = bucket[index];

        while(current != null){
            if(current.getKey() == key){
                return current.getValue();
            }
            current = current.next;
        }
        return -1; // Key not found
    }

    public void remove(int key){
        int index = getIndex(key);
        CustomLinkedList current = bucket[index];

        if(current == null){
            return; // Bucket is empty, nothing to remove
        }

        // Case 1: The head node matches the key
        if(current.getKey() == key){
            bucket[index] = current.next; // Remove head by pointing bucket to the next node
            return;
        }

        // Case 2: Node to be removed is not the head
        CustomLinkedList prev = current; // prev starts at the head
        current = current.next;         // current starts from the second node

        while(current != null){
            if(current.getKey() == key){
                prev.next = current.next; // Link previous node to current's next, effectively removing current
                return; // Key found and removed, exit
            }
            prev = current;         // Advance prev to current
            current = current.next; // Advance current
        }
    }
}

class MyHashMap {
    private CustomHashMap customHashMap;

    public MyHashMap(){
        // Use the CustomHashMap with a more reasonable default capacity
        this.customHashMap = new CustomHashMap();
    }

    public void put(int key, int value) {
        customHashMap.put(key, value);
    }

    public int get(int key) {
        return customHashMap.get(key);
    }

    public void remove(int key) {
        customHashMap.remove(key);
    }
}