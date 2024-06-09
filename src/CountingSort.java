public class CountingSort {
    public int[] sort(int[] arr) {
        int max = getMax(arr);
        int[] count = new int[max + 1];
        int[] output = new int[arr.length];

        for (int num : arr)
            count[num]++;

        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
        return arr;
    }

    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
