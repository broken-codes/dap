package org.brokencodes.learning.dap.core.datastructures.holders;

/**
 * The {@link SingleLinkedListNode} class represents the node of a SingleLinkedList
 *
 * @param <T>
 */
public class SingleLinkedListNode<T> {

    private T data;

    private SingleLinkedListNode<T> next;

    public SingleLinkedListNode(T data) {
        this.data = data;
    }

    public SingleLinkedListNode(T data, SingleLinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleLinkedListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

}
