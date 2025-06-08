
class Node{
    int data;
    Node next;
}

class LinkedList{
    Node head;

    public void insertAtEnd(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head == null){
            head = node;
        }else{
            Node n = head;
            while(n.next!= null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head  = node;

    }

    public void insertAtAnyLoc(int index, int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
       
        if(index ==0){
            insertAtStart(data);
        }
        else{
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;   
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteAt(int index){
        if(index ==0){
            head = head.next;
        }else{
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index-1; i++) {
                n = n.next;   
            }
            n1 = n.next;
            n.next = n1.next;
            System.out.println("n1 -- "+ n1.data);
            n1 = null;
        }
    }

    public void show(){
        Node node = head; 
        while(node.next!= null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}

class LinkedListDemo{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(9);
        list.insertAtEnd(5);
        list.insertAtEnd(18);
        list.insertAtEnd(2);
        list.insertAtStart(25);
        list.insertAtAnyLoc(3, 57);
        list.insertAtAnyLoc(0, 100);
        list.insertAtAnyLoc(0, 2000);
        list.insertAtAnyLoc(0, 2500);
        list.deleteAt(7);
        
        list.show();
    }
}
