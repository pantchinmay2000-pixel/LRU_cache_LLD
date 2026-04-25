import java.util.HashMap;
import java.util.Map;

public class LRU<K,V> {
    Map<K, Node<K,V>> map;
    DoublyLinkedList<K,V> dll;
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoublyLinkedList<>();
    }

    public V get(Node<K,V>node) {
        if(map.containsKey(node.key)) {
            Node<K,V> nNode = map.get(node.key);
            dll.get(nNode);
            System.out.println("Accessed: " + nNode.key + " -> " + nNode.value);
            return nNode.value;
        } else {
            return null;
        }
    }

    public void put(Node<K,V>node) {
        if(map.containsKey(node.key)) {
            Node<K,V>nNode = map.get(node.key);
            nNode.value = node.value;
            dll.get(nNode);

        }
        else {
            if(map.size() == capacity) {
                Node<K,V> nNode = dll.getBack();
                dll.removeBack();
                map.remove(nNode.key);
                System.out.println("Evicted: " + nNode.key + " -> " + nNode.value);
            }
            dll.addFront(node);
            map.put(node.key, node);
        }
        System.out.println("Added: " + node.key + " -> " + node.value);
    }

    public void removeNode(Node<K,V>node) {
        if(map.containsKey(node.key)) {
            Node<K,V> nNode = map.get(node.key);
            dll.remove(nNode);
            map.remove(node.key);
            System.out.println("Removed: " + nNode.key + " -> " + nNode.value);
        }
    }
        
}
