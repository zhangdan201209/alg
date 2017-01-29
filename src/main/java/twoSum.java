import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dz on 1/29/17.
 */
public class twoSum {

    protected static final String error = "Can't find twoSum on target";

    /**
     * Brute Force with O(n2)
     *
     * @param numbers
     * @param target
     * @return
     * @throws Exception
     */
    public static int[] alg1(int[] numbers, int target) throws Exception {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && numbers[i] != 0 && numbers[j] != 0) {
                    return new int[]{i, j};
                }
            }
        }
        throw new Exception(error);
    }

    /**
     * HashMap O(n) plus O(n) space
     *
     * @param numbers
     * @param target
     */
    public static int[] alg2(int []numbers, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x), i};
            }
            map.put(x,i);
        }
        throw new Exception(error);
    }

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 7, 5};
        int target = 6;
        try {
            int[] result = twoSum.alg2(numbers, target);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
