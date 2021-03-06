package homework5;

import java.util.Arrays;
import java.util.Iterator;

public class RubberArray {
    private int[] arr;

    public Object get(int index){
        if (index >= arr.length){
           return null;}
        return arr[index];
    }

    public void remove(int index){
        if (arr != null){
            if(index<arr.length){
                int [] newArr = new int[arr.length-1];
                for (int i = 0; i < arr.length; i++) {
                    if (i < index){
                        newArr[i] = arr[i];}
                    else if (i > index) {
                        newArr[i-1] = arr[i];
                    }
                }
                arr = newArr;
            }
        }

    }

    public void add(int value){
        if (arr == null) {
            arr = new int[1];
            arr[0] = value;
        }
        else{
            int [] newArr = Arrays.copyOf(arr,arr.length+1);
            newArr[arr.length] = value;
            arr = newArr;
        }
    }

    public int getMax(){
        int result = arr[0];
        for (int elem:arr){
             result = Math.max(result,elem);
           }
        return result;
    }
    public int getMin(){
        int result = arr[0];
        for (int elem:arr){
            result = Math.min(result,elem);
        }
        return result;
    }

    public double getAverage(){
        int resultSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            resultSum += arr[i];
        }

        return Double.valueOf(resultSum)/(arr.length-1);
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }


    public Iterator iterator(){
        return new Itr() ;
    }

    private class Itr implements Iterator{
        int cursor = 0;
        @Override
        public boolean hasNext(){return cursor< arr.length;}

        @Override
        public Object next(){return arr[cursor++];}




    }

}
