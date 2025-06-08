public class Test1234 {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 8, 4, 7, 6};
        int result = 0;
        int N = arr.length;
        for (int i = 1; i < N-1; i++) {
            if (arr[i] > (arr[i + 1] + arr[i - 1]) / 2) {
                    result =  result+1;
            }else continue;

            System.out.println(result);
        }
    }
}
