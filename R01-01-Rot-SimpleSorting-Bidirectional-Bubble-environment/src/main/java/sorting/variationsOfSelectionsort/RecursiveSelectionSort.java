package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) {
            return;
        }

        //Caso base: array está ordenado
        if(leftIndex >= rightIndex){
            return;
        }
        
        int min = leftIndex;
        for(int i = leftIndex + 1; i<rightIndex + 1; i++){
            if(array[i].compareTo(array[min]) < 0){
                min = i;
            }
        }

        Util.swap(array, leftIndex, min);
        this.sort(array, leftIndex + 1, rightIndex);
    }

}

