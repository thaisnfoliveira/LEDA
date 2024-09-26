package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) {
            return;
        }

        //caso base: array está ordenado
        if(leftIndex>=rightIndex){
            return;
        }

        //Percorremos o array uma vez fazendo as trocas necessárias
        for(int i = leftIndex; i< rightIndex; i++){
                if(array[i].compareTo(array[i+1]) > 0){
                    Util.swap(array, i, i+1);
                }
            }

        this.sort(array, leftIndex, rightIndex-1);
    }
}
