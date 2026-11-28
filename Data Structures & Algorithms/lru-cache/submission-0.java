class LRUCache {

    static class Node{

        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){

            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final java.util.Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    
    }
    
    public int get(int key) {

        if(!map.containsKey(key)){

            return -1;
        }

        Node node = map.get(key);
        remove(node);
        inserthead(node);

        return node.value;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){

            Node node = map.get(key);

            node.value = value;

            remove(node);
            inserthead(node);

        }

        else{

            if(map.size() == capacity){

                Node lru = tail.prev;

                remove(lru);
                map.remove(lru.key);
            }

            Node node = new Node(key, value);

            map.put(key, node);
            inserthead(node);
        }
        
    }

    public void remove(Node node){

        node.prev.next = node.next; //a -> c;
        node.next.prev = node.prev; // a <- c;
    }

    public void inserthead(Node node){

        node.next = head.next; //b -> a;
        node.prev = head; // head <- b;

        head.next.prev = node; // b <- a;
        head.next = node; // head -> b;
    }
}
