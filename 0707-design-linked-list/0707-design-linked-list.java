class MyLinkedList {
    class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;

        Node curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
        } else {
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;

        if(index == 0){
            addAtHead(val);
            return;
        }

        Node curr = head;
        for(int i = 0; i < index - 1; i++){
            curr = curr.next;
        }

        Node node = new Node(val);
        node.next = curr.next;
        curr.next = node;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        if(index == 0){
            head = head.next;
        } else {
            Node curr = head;
            for(int i = 0; i < index - 1; i++){
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }

        size--;
    }
}