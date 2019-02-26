package com.zipcodewilmington.looplabs;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    private int count;
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] nonDuplicates = new Integer[array.length];
        count = 0;
        for (int number : array) {
            if (getNumberOfOccurances(number) < maxNumberOfDuplications) {
                nonDuplicates[count] = number;
                count++;
            }
        }
        return getFinalArray(nonDuplicates);
        // Not sure if we can use Arrays.copyOfRange?
        // return Arrays.copyOfRange(nonDuplicates, 0, count);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] nonDuplicates = new Integer[array.length];
        count = 0;
        for (int number : array) {
            if (!(exactNumberOfDuplications == getNumberOfOccurances(number))) {
                nonDuplicates[count] = number;
                count++;
            }
        }
        return getFinalArray(nonDuplicates);
        // Not sure if we can use Arrays.copyOfRange?
        // return Arrays.copyOfRange(nonDuplicates, 0, count);
    }

    public int getNumberOfOccurances(int testInteger) {
        int count = 0;
        for (int number : array) {
            if (number == testInteger) {
                count++;
            }
        }
        return count;
    }

    public Integer[] getFinalArray(Integer[] nonDuplicates) {
        Integer[] finalArray = new Integer[count];
        for (int i = 0; i < count; i++) {
            finalArray[i] = nonDuplicates[i];
        }
        return finalArray;
    }
}
