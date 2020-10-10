package org.brokencodes.learning.dap.core.datastructures.linear;

import org.brokencodes.learning.dap.core.datastructures.holders.SingleLinkedListNode;

import java.util.Optional;

public class SingleLinkedList<T> {

    private int occupied;

    private SingleLinkedListNode<T> head;
    private SingleLinkedListNode<T> tail;

    /**
     * Create the instance of {@link SingleLinkedList}
     */
    public SingleLinkedList() {
        head = new SingleLinkedListNode<T>(null);
        tail = head;
    }

    /**
     * Add a new node to {@link SingleLinkedList} in O(1) time.
     *
     * @param data data that needs to be inserted
     */
    public void add(T data) {
        final SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(data);
        tail.setNext(newNode);
        occupied++;
    }

    /**
     * Removes the element from {@link SingleLinkedList}
     *
     * @throws IndexOutOfBoundsException
     */
    public void delete(int index) throws IndexOutOfBoundsException {
        if (0 > index) {
            throw new IndexOutOfBoundsException(String.format("Given index: {} is less than 0", index));
        }
        if (index > occupied) {
            throw new IndexOutOfBoundsException(String.format("Size of the linked list is less than {}", index));
        }
        int currentPosition = 0;
        SingleLinkedListNode<T> currentNode = this.head;
        // Take us to the node whose successor needs to be deleted.
        while (currentPosition < index) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        occupied--;
    }

    /**
     * Delete data from {@link SingleLinkedList}
     *
     * @param data the data that needs to be removed from {@link SingleLinkedList}
     * @return optional data
     */
    public Optional<Integer> delete(T data) {
        SingleLinkedListNode<T> currentNode = this.head;
        int currentPosition = 0;
        if ((currentNode = currentNode.getNext()) != null) {
            currentPosition++;
            if (currentNode.getData().equals(data)) {
                occupied--;
                return Optional.of(currentPosition);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the element at the given index from {@link SingleLinkedList}
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if (0 > index) {
            throw new IndexOutOfBoundsException(String.format("Given index: {} is less than 0", index));
        }
        if (index > occupied) {
            throw new IndexOutOfBoundsException(String.format("Size of the linked list is less than {}", index));
        }
        int currentPosition = 0;
        SingleLinkedListNode<T> currentNode = this.head;
        // Take us to the node whose successor needs to be deleted.
        while (currentPosition < index) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getNext().getData();
    }

    /**
     * Returns the number of elements in {@link SingleLinkedList}
     *
     * @return
     */
    public long size() {
        return occupied;
    }
}
