/**
 * Circular Linked List implementation
 * The list supports usual operations such as:add,delete or find
 */
public class CircularLinkedList {


    private Node head = null;
    private Node tail = null;

    /**
     * Add node to linked list(update head and tail accordingly)
     * @param value stored value in the new node
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else tail.nextNode = newNode;

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Find if a node with given value exists in the list
     * @param searchValue value of a node to search for
     * @return boolean True or False depending if the value is found or not
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Delete node with given value,if any
     * @param valueToDelete value of the node to be deleted
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Find successor of a node
     * @param currentNode reference node to find successor
     * @return null if empty list otherwise there will always be a successor
     */
    public Node getNode(Node currentNode){
        if (currentNode != null) {
            return currentNode.nextNode != null ? currentNode.nextNode : null;
        }
        return null;
    }

    /**
     * Getter of head
     * @return head
     */
    public Node getHead() {
        return head;
    }

    /**
     * Getter of tail
     * @return tail
     */
    public Node getTail() {
        return tail;
    }

}