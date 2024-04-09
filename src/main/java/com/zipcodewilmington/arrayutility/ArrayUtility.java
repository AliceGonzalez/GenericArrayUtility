package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T>{
    public final T[] array;

    public ArrayUtility(T[] array){
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer count = 0;

        ArrayList<T> mergedArray = new ArrayList<>();

        for(T element : arrayToMerge) {
            mergedArray.add((T) element);
        }
        mergedArray.addAll(Arrays.asList(array));
        for(T val : mergedArray){
            if(val.equals(valueToEvaluate)){
                count++;
            }
        }

        return count;
    }


    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T val : array){
            if(val.equals(valueToEvaluate)){
                count ++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommon = null;
        int maxCount = 0;

        ArrayList<T> mergedArray = new ArrayList<>();
        mergedArray.addAll(Arrays.asList(array));
        mergedArray.addAll((Collection<? extends T>) Arrays.asList(arrayToMerge));

        for (int i = 0; i < mergedArray.size(); i++) {
            int count = 0;
            for (int j = 0; j < mergedArray.size(); j++) {
                if (mergedArray.get(i).equals(mergedArray.get(j))){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount= count;
                mostCommon =  mergedArray.get(i);

            }
        }
        return (T) mostCommon;
    }

    public <T> T[] removeValue(T value) {

        ArrayList<T> list = (ArrayList<T>) new ArrayList<>(Arrays.asList(array));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                list.remove(value);
            }
        }

        T[] result = (T[]) list.toArray((T[]) Array.newInstance(value.getClass(), list.size()));

        return result;
    }

}
