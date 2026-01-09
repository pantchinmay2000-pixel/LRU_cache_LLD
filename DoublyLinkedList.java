public class DoublyLinkedList<K,V> {
    Node <K,V> head;
    Node <K,V> tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head; 
    }

    public void addFront(Node<K,V>node) {
        Node<K,V> nNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nNode;
        nNode.prev = node;
    }

    public void removeBack() {
        Node<K,V> pNode = tail.prev;
        tail.prev = pNode.prev;
        pNode.prev.next = tail;
        pNode.next = null;
        pNode.prev = null;
    }

    public void remove(Node<K,V>node) {
        Node<K,V>pNode = node.prev;
        Node<K,V>nNode = node.next;
        pNode.next = nNode;
        nNode.prev = pNode;
        node.next = null;
        node.prev = null;
    }

    public void get(Node<K,V>node) {
        remove(node);
        addFront(node);
    }

    public void put(Node<K,V>node) {
        addFront(node);
    }

    public Node<K,V> getBack() {
        return tail.prev;
    }
}
