/**
 * Created by dz on 1/29/17.
 */
public class twoSumSorted extends twoSum {

    /**
     * Using bst to find target O(nlgn)
     * @param numbers
     * @param target
     * @return
     * @throws Exception
     */
    public static int[] alg(int[] numbers, int target) throws Exception {
        for (int i = 0; i < numbers.length; i++) {
            int j = bst(numbers, i + 1, target - numbers[i]);
            if (j != -1) {
                return new int[]{i, j};
            }

        }
        throw new Exception(error);
    }

    /**
     * Doulbe pointer on sorted Array
     * @param numbers
     * @param target
     * @return
     * @throws Exception
     */
    public static int[] alg2(int[] numbers, int target) throws Exception{
        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum<target){
                i++;
            } else if(sum>target){
                j--;
            } else{
                return new int[]{i,j};
            }
        }
        throw new Exception(error);
    }
    private static int bst(int[] A, int start, int target) {
        int L = start;
        int R = A.length;
        while(L<R){
            int M = (L+R)/2;
            if(A[M]<target){
                L=M+1;
            } else if(A[M]>target){
                R=M;
            } else{
                return M;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 5, 7};
        int target = 6;
        try {
            int[] result = twoSumSorted.alg2(numbers, target);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
