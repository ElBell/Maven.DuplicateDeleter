package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    private int count;
    public StringDuplicateDeleter(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] nonDuplicates = new String[array.length];
        count = 0;
        for (String string : array) {
            if (getNumberOfOccurances(string) < maxNumberOfDuplications) {
                nonDuplicates[count] = string;
                count++;
            }
        }
        return getFinalArray(nonDuplicates);
        // Not sure if we can use Arrays.copyOfRange?
        // return Arrays.copyOfRange(nonDuplicates, 0, count);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] nonDuplicates = new String[array.length];
        count = 0;
        for (String string : array) {
            if (!(exactNumberOfDuplications == getNumberOfOccurances(string))) {
                nonDuplicates[count] = string;
                count++;
            }
        }
        return getFinalArray(nonDuplicates);
        // Not sure if we can use Arrays.copyOfRange?
        // return Arrays.copyOfRange(nonDuplicates, 0, count);
    }

    public String[] getFinalArray(String[] nonDuplicates) {
        String[] finalArray = new String[count];
        for (int i = 0; i < count; i++) {
            finalArray[i] = nonDuplicates[i];
        }
        return finalArray;
    }

    public int getNumberOfOccurances(String testString) {
        int count = 0;
        for (String string : array) {
            if (string.equals(testString)) {
                count++;
            }
        }
        return count;
    }
}
