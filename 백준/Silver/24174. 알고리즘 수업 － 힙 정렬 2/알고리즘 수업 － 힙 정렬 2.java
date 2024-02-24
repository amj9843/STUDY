import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static int target = 0;
    public static int cnt = 0;

    public static void heapSort(int[] arr) throws Exception {
        for (int i = arr.length / 2 - 1 ; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size) throws Exception {
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        if (leftIdx < size && arr[maxIdx] > arr[leftIdx]) {
            maxIdx = leftIdx;
        }

        if (rightIdx < size && arr[maxIdx] > arr[rightIdx]) {
            maxIdx = rightIdx;
        }

        if (parentIdx != maxIdx) {
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) throws Exception {
        cnt++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        if (cnt == target) throw new Exception();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        target = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        try {
            heapSort(arr);
        } catch (Exception ignored) {

        }

        String[] answer = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = Integer.toString(arr[i]);
        }

        System.out.println((cnt < target) ? -1 : Arrays.stream(answer).collect(Collectors.joining(" ")));
        }
}