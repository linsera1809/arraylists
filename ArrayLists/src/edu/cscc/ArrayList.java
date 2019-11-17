package edu.cscc;

import java.util.Arrays;

/**
 * @author Bobby Linse
 * Date: November 2019
 * Instructor: David Paulzer
 * School: Columbus State Community College
 * Assignment: Lab #1
 *
 * Description: This class is dedicated to the Java II assignment which
 * is to write a generic 'edu.cscc.ArrayList' class similar to the one in the given
 * lecture notes on array lists.
 */

public class ArrayList<E> {

    private E[] elements; // list of values
    private int size;

    public static final int DEFAULT_SIZE = 50;

    /**
     * Given a null Array, instantiate an arraylist of Default Size
     */
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * Given some size, an edu.cscc.ArrayList will be instantiated
     * @param arrSize
     */
    public ArrayList(int arrSize) {
        if (arrSize < 0) {
            throw new IllegalArgumentException("Array Size is less than zero. Size: " + arrSize);
        }
        elements = (E[]) new Object[arrSize];
        size = elements.length;
    }

    /**
     * @return size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Determine if the edu.cscc.ArrayList is empty
     * @return
     */
    public boolean isEmpty() {
        if(size==0){ return true; }
        else{ return false; }
    }

    /**
     * Clear all values from the array list
     */
    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Given some data, add to the array list
     * @param data
     */
    public void add(E data) {
        if (size < elements.length) {
            elements[size] = data;
        }

        else {
            size = size +1; //Allocate more space
            elements[size] = data;
        }
        size++;
    }

    /**
     * Given some index and some data, add it to the edu.cscc.ArrayList
     * @param index
     * @param data
     */
    public void add(int index, E data){
        if (index < 0 || index > size || index > size + 1) {
            throw new IndexOutOfBoundsException("The index is out of bounds. Index: " + index);
        }
        else {
            for (int i = size; i >= index + 1; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = data;
            size++;
        }
    }

    /**
     * Given an index, return an element in the arraylist
     * @param index
     * @return
     */
    public E get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("There was an issue getting your index. " +
                    "Index: " + index + ", Size: " + size);

        return (E) elements[index];
    }

    /**
     * Given some data, parse the edu.cscc.ArrayList and delete that element
     * @param data
     * @return
     */
    public E remove(E data){
        for(int i = 0; i < size; i++){
            if(get(i) == data ){
                E dataToBeRemoved = data;
                elements[i] = null;
                return dataToBeRemoved;
            }
        }
        return null;
    }

    /**
     * Given an index, remove the element.
     * @param index
     * @return
     */
    public E remove(int index){

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("There was an issue in " +
                    "removing the index, at Index: " + index);
        }
        else {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }

            E dataToBeRemoved = elements[size - 1];
            elements[size - 1] = null;
            size--;
            return dataToBeRemoved;
        }
    }

}
