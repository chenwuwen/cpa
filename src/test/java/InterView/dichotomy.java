package InterView;

/**
 * Created by KANYUN on 2017/4/8.
 */
public class dichotomy {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8,9};
        System.out.println( dichotomyExec(arr,10));
    }

    public static Boolean dichotomyExec(int[] arr, int target) {
        boolean b = false;
        int l = arr.length-1;
        if (l> 0) {
            int start = 0;
            int end = l;
            while (end >= start) {
                int mid = (start + end) / 2;
                if (arr[mid] == target) {
                    b = true;
                    break;
                } else if (arr[mid] < target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return b;
    }
}