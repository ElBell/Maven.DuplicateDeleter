package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;
    private int count;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public T[] removeDuplicates(int maxNumberOfDuplications) {
        T[] nonDuplicates = array.clone();
        count = 0;
        for (T element : array) {
            if (getNumberOfOccurances(element) < maxNumberOfDuplications) {
                nonDuplicates[count] = element;
                count++;
            }
        }
        return Arrays.copyOfRange(nonDuplicates, 0, count);
    }

    public T[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        T[] nonDuplicates = array.clone();
        count = 0;
        for (T element : array) {
            if (!(exactNumberOfDuplications == getNumberOfOccurances(element))) {
                nonDuplicates[count] = element;
                count++;
            }
        }
        return Arrays.copyOfRange(nonDuplicates, 0, count);
    }

    public int getNumberOfOccurances(T object) {
        int count = 0;
        for (T element : array) {
            if (element == object) {
                count++;
            }
        }
        return count;
    }
}
