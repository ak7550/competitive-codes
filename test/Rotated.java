public class Rotated {
    public static void main(String[] args) {
        int[] a = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(a, target));
    }

    private static int search(int[] a, int target) {

        int minIndex = getMinIndex(a);

        System.out.println("smallest element is: " + a[minIndex]);
        System.out.println("index is: " + minIndex);

        int ans1 = search(a, 0, minIndex, target), ans2 = search(a, minIndex + 1, a.length - 1, target);

        if (ans1 == -1 && ans2 == -1) {
            return -1;
        } else if (ans1 != -1) {
            return ans1;
        } else if (ans2 != -1) {
            return ans2;
        }
        return -1;
    }

    private static int search(int arr[], int start, int end, int target) {
        return -1;
    }

    private static int getMinIndex(int arr[]) {
        int start = 0, end = arr.length - 1;
        int minIndex = 0, min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (min < arr[mid]) {
                min = arr[mid];
                minIndex = mid;
            }
            if (arr[start] < arr[mid]) {
                // sorted scenario
                if (min < arr[start]) {
                    min = arr[start];
                    minIndex = start;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return minIndex;
    }

    public int search2(int[] a, int target) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            // System.out.println(l+" "+m+" "+h);
            if (a[m] == target)
                return m;
            if (a[l] <= a[m]) { // left is sorted
                if (target >= a[l] && target < a[m])
                    h = m - 1;
                else
                    l = m + 1;
            } else {
                if (target > a[m] && target <= a[h])
                    l = m + 1;
                else
                    h = m - 1;
            }
        }
        return -1;
    }
}

//1) find the smallest number
// break the array into two diff sorted array
// implement b search into both array

// 4,5,6,7,0,1,2
// ^s    ^m     ^e
//4,7 ==> 7>4 ==> sorted ==> arr[start, mid] ==> arr[start] ==> a probable smallest
// arr[start] <= arr[mid] ==> sorted ==> arr[start] is a probable smallest element ==> minimumIndex = start ==> start = mid+1;
// continue my search into the left ==> end = mid;
