package week2;

public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int n = arr.length;
//        boolean swap = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
//                    swap=true;
                }
            }
//            if (!swap) break;
//            swap=false;
        }
    }

}
