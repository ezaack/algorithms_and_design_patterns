package br.com.study.strucktsandalgorithms.structs;

/********************************************************************************************************************
 * The chalenge here is make a dinamic array using just de very basic tools of the Java. So I w'ont use Collections and Stream.
 *
 * The choiced
 */
public class DinamicArray<T> {

    private T[] staticArray;
    private int currentIndex;
    private int arrayLenth;

    public DinamicArray(T[] paramArray) {
        arrayLenth = paramArray.length * 2;
        currentIndex = -1;
        this.staticArray = (T[]) new Object[arrayLenth];
        mergeArray(paramArray);

    }

    public DinamicArray() {
        currentIndex = -1;
        arrayLenth = 1;
        this.staticArray = (T[]) new Object[arrayLenth];
    }

    public void put(T item) {
        if (arrayLenth == (currentIndex + 1)) {
            improveArraysSize();
        }
        staticArray[++currentIndex] = item;
    }

    public T pop() {
        T removedItem = staticArray[currentIndex];
        staticArray[currentIndex--] = null;
        return removedItem;
    }

    public T get(int index) {
        if (index <= currentIndex) {
            return staticArray[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public int indexOf(T item) {
        for (int index = 0; index <= currentIndex; index++) {
            if (staticArray[index].equals(item)) {
                return index;
            }
        }
        return -1;
    }

    public int lenth() {
        return currentIndex + 1;
    }

    // so, thats it's none of the business of the users...
    private void improveArraysSize() {
        T[] temporaryArray = staticArray;

        arrayLenth *= 2;
        staticArray = (T[]) new Object[arrayLenth];
        mergeArray(temporaryArray);
    }

    private void mergeArray(T[] paramArray) {
        currentIndex = -1;
        for (T item : paramArray) {
            staticArray[++currentIndex] = item;
        }
    }
}
