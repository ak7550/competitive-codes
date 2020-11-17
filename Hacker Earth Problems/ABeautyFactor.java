import java.util.ArrayList;

import AkPackage.InputOutput;

/**
 * ABeautyFactor
 */
public class ABeautyFactor {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ABeautyFactor());
        while (!lines.isEmpty()) {
            String str[] = lines.remove(0).split(" ");
            int b = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]);
            ArrayList<Integer> ans = getResult(b, k);
            System.out.println("b= " + b + ", k= " + k + ", ans= " + ans);
        }
    }

    public static ArrayList<Integer> getResult(int b, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (b <= 0 || k <= 0 || b >= 10 || k >= 10)
            ans.add(-1);
        // else if (b < k) {

        // }
        else {
            for (int i = 0; i < k; i++)
                ans.add(i + 1);
            beautifulFactor(ans, 0, k - 1, b);
        }
        return ans;
    }

    public static int sum(ArrayList<Integer> arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr.get(i);
            // sum = sum / 10 + sum % 10;
        }
        return sum;
    }

    public static void beautifulFactor(ArrayList<Integer> arr, int start, int end, int b) {
        int sum = sum(arr, start, end);
        if (b == 0)
            b = 9;
        if (sum > b) {
            arr.set(end, start == 0 ? 9 : arr.get(end + 1) - 1);
            beautifulFactor(arr, start + 1, end - 1, b - 1);
        } else if (sum < b)
            arr.set(end, arr.get(end) + b - sum);
    }
}