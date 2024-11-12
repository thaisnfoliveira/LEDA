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
        //ele leva o maior elemento para o final e depois o 'exclui', chamando o bubble sort novamente com o maior índice -1, até que toda a lista esteja ordenada (leftIndex>=rightIndex)
        this.sort(array, leftIndex, rightIndex-1);
    }
}
