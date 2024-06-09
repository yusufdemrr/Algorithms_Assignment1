abstract class SearchAlgorithm {
    public abstract int search(int[] arr, int x);
}

class LinearSearch extends SearchAlgorithm {
    @Override
    public int search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}

class BinarySearch extends SearchAlgorithm {
    @Override
    public int search(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (high - low > 1) {
            int mid = (high + low) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (arr[low] == x) {
            return low;
        } else if (arr[high] == x) {
            return high;
        }
        return -1;
    }
}

