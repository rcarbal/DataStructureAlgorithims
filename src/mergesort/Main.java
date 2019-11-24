package mergesort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 7, -22};

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }

    // 20, 35, -15, 7, 55, 7, -22
    public static void mergeSort(int[] input, int start, int end){

        // for recursion you need a breaking condition
        // you will break out when you have a one element array.
        if (end - start < 2){
            return;
        }

        // if you have more than one element array you need to partition the
        // array that has been passed.

        // for the first indication start will be 0 and end will be 7
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start , mid, end);

    }

    public static void merge(int[] input, int start, int mid, int end){

        // we are always merging sorted arrays.
        // when we vall merge the left partition the left partition and right partition are sorted.
        // We know that mid is the first element in the right side, and one greater then the last element than the left side.
        // input[mid - 1] is the last element in the left partition and input mid is the first element in the right.
        // if the last element in the left is <= to first element in the right partition
        // that means that all the elements left element are smaller than the elements in the right partition.

        if (input[mid -1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end)  {
            // We compare the current element in the left partition with the current element in the right partition.
            // We will write the smaller of the two to the temporary array.
            // Since merge sort is stable we have an equals.
            // If the element in the left array is equals to the element in the write array, it will be written first.
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // handle the left over elements
        // If we have elements remaining in the left partition , we have to copy them into the temp array.
        // But if we have elements remaining in the right partition we don't have to do anything.

        // This line says:
        // Start at the input array, start at i which is the position of 55.
        // start the temp index add 3 so we can handle 3 elements and that is where we will copy 55 to.
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
}
