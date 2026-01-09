public class Main {
    public static void main(String[] args) {
        LRU<Integer, String> lru = new LRU<>(2);
        
        Node<Integer, String> node1 = new Node<>(1, "One");
        Node<Integer, String> node2 = new Node<>(2, "Two");
        Node<Integer, String> node3 = new Node<>(3, "Three");
        
        lru.put(node1);
        lru.put(node2);
        
        @SuppressWarnings("unused")
        String v = lru.get(node1);
        lru.put(node3); 

        String vu = lru.get(node2);
        if(vu != null) {
            System.out.println("Value for key 1: " + vu);
        } else {
            System.out.println("Key 1 not found");
        }

    }
}
