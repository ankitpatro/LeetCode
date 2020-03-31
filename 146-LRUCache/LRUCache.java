package Leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    //creating doubly linked list to store the nodes having key and value.
    //Doubly LinkedList provides O(1) for deletion
    private class DoublyLinkedListNode{
        int key;
        int value;
        DoublyLinkedListNode previous;//points to previous node
        DoublyLinkedListNode next;// points to next node
    }
    
    private void addNode(DoublyLinkedListNode node)
    {
        // Add a new node after the head
        
        node.previous = head; //new node's previous will point to head
        node.next = head.next; // new node's next will point to head's former next node
        
        head.next.previous = node; // Former head's next's previous now points to new node
        head.next = node;//head's next points to the new node
        
    }
    
    private void removeNode(DoublyLinkedListNode node)
    {
        DoublyLinkedListNode nextNode = node.next; // before removing a node, make a copy of node's next pointer
        DoublyLinkedListNode prevNode = node.previous; // before removing a node, make a copy of node's previous pointer
        
        prevNode.next = nextNode; //now to remove the node from the doublyLinkedList, de-reference it by pointing node's previous's next to next of node to be deleted.
        nextNode.previous = prevNode;//also by pointing node's next's previous to the previous of node to be deleted.
    }
    /*
    * This function is called whenever we try to access a Node from Cache
    */
    private void moveToFront(DoublyLinkedListNode node)
    {
        removeNode(node); //whenever a node is accessed, remove that node from the doubly linked list
        addNode(node);// and add it after the head of the doubly linked list
    }

    /**
     * This function is called whenever there's an cache overflow condition.
     * the case where the cache's size is equal to its capacity. In that case addition of new node can happen only when we delete the
     * last node in the doubly linked list
     * @return key of the cache/node
     */
    private int removeLast()
    {
        DoublyLinkedListNode lastNode = tail.previous;// last element in the doubly linked list
        removeNode(lastNode); //remove from the doubly linked list
        return lastNode.key; // return statement is required to
        
    }
    
    private Map<Integer, DoublyLinkedListNode> cache = new HashMap<>(); //map to get the value corresponding to a particular key
    private int size; // current size of the map
    private int capacity; // max capacity of the cache
    private DoublyLinkedListNode head, tail; //maintain head and tail nodes. Addition and deletion of node happens between them

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        
        head = new DoublyLinkedListNode();
        tail = new DoublyLinkedListNode();
        
        head.next = tail; // initially head's next points to tail
        tail.previous = head;// and tail's previous points to head, means there's no node between head and tail and thus size of cache is  0;
        
    }
    
    public int get(int key) {
        DoublyLinkedListNode node = cache.get(key); //fetch the node by passing key to cache
        if(node == null) return -1; // if key isn't present, return -1
        
        moveToFront(node); // else the node is present in the map and since this node is recently used so it would be moved to the front of the doubly linked list
        return node.value; // return its value
        
    }
    
    public void put(int key, int value) {
        DoublyLinkedListNode node = cache.get(key); // get the node from the cache using the key
        
        if(node == null) // if node isn't present in the cache
        {
           DoublyLinkedListNode newNode = new DoublyLinkedListNode(); // create a new node
            newNode.key = key;// set the new node's key
            newNode.value = value;// set the new node's value
            cache.put(key, newNode);// put the new node in the cache
            
            addNode(newNode); // add the new node to the doubly linked list as well
            ++size; // increase the current size of the cache after every insertion

            if (size > capacity)
            {

                cache.remove(removeLast()); // if current size of the cache is greater than its maximum capacity, delete the last node to add a new node
                --size; //after removal, decrease the size by 1 (now current size will be equal to its maximum capacity)
            }
        }
        
        else
        {
            node.value = value;
            moveToFront(node); // move to front of the doubly linked list,  since recently accessed
        }
        
    }
}

