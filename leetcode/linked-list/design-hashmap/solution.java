class CustomLinkedList {
    private final int key;
    private int value;
    public CustomLinkedList next;

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
    public CustomLinkedList getNext(){
        return next;
    }
    public void setValue(int value){
        this.value = value;
    }
}
class CustomHashMap {
    private int capacity;
    private CustomLinkedList[] bucket;
    public CustomHashMap(int capacity){
        this.capacity = capacity;
        this.bucket = new CustomLinkedList[capacity];
        for(int i=0;i<capacity;i++){
            this.bucket[i] = null;
        }
    }
    public int getIndex(int key){
        return key % capacity;
    }
    public void put(int key,int value){
        int index = getIndex(key);
        if(bucket[index]==null){
            bucket[index] = new CustomLinkedList(key,value);
            return;
        }
        CustomLinkedList customLinkedList = bucket[index];
        while(customLinkedList!=null){
            if(customLinkedList.getKey()==key){
                customLinkedList.setValue(value);
                return;
            }
            customLinkedList = customLinkedList.next;
        }
        customLinkedList = bucket[index];
        while(customLinkedList.getNext()!=null){
            customLinkedList = customLinkedList.getNext();
        }
        customLinkedList.next = new CustomLinkedList(key,value);

    }
    public int get(int key){
        int index = getIndex(key);
        CustomLinkedList customLinkedList = bucket[index];
        if(customLinkedList==null){
            return -1;
        }
        while(customLinkedList!=null){
            if(customLinkedList.getKey()==key){
                return customLinkedList.getValue();
            }
            customLinkedList  = customLinkedList.next;
        }
        return -1;
    }
    public void remove(int key){
        int index = getIndex(key);
        CustomLinkedList customLinkedList = bucket[index];
        if(customLinkedList==null){
            return;
        }
        if(customLinkedList.getKey()==key){
            bucket[index] = customLinkedList.next;
            return;
        }
        CustomLinkedList prev=null;
        while(customLinkedList!=null){
            if(customLinkedList.getKey()==key){
                if(prev!=null){
                    prev.next = customLinkedList.next;
                    prev = prev.next;
                }
            }
            prev = customLinkedList;
            customLinkedList = customLinkedList.next;
        }
    }
}
class MyHashMap {

    private CustomHashMap customHashMap;
    public MyHashMap(){
        this.customHashMap = new CustomHashMap(10000000);
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

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */