import java.util.*;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<Integer, List<String>> results = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int asciiSum = 0;
            String curr = strs[i];
            int stringLength = curr.length();
            for (int j = 0; j < stringLength; j++) {
                asciiSum += curr.charAt(j);
            }

            if (results.get(asciiSum) == null) {
                List<String> resultsArray = new ArrayList<>();
                resultsArray.add(curr);
                results.put(asciiSum, resultsArray);
            } else {
                results.get(asciiSum).add(curr);
            }
        }

        return new ArrayList<>(results.values());
    }

    public static void moveZeroes(int[] nums) {
        /*        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{1, 0});*/
//        moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});

        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int j = count; j < n; j++) {
            nums[j] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static int maxSubArray(int[] nums) {
        //       System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(maxSubArray(new int[]{1}));
//        System.out.println(maxSubArray(new int[]{-2, 1}));
//        System.out.println(maxSubArray(new int[]{-2, -3, -1}));
//        System.out.println(maxSubArray(new int[]{8, -19, 5, -4, 20}));
//        System.out.println(maxSubArray(new int[]{-2, -1}));
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArray(new int[]{1,2,-1,-2,2,1,-2,1}));
//        System.out.println(maxSubArray(new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4}));

        int result = Integer.MIN_VALUE;
        int tempResult = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentPosition = nums[i];
            tempResult = Math.max(currentPosition, tempResult + currentPosition);
            result = Math.max(result, tempResult);
        }
        return result;
    }

/*    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int result = Integer.MIN_VALUE;
        int tempResult = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (tempResult == Integer.MIN_VALUE) {
                tempResult = nums[i - 1] + nums[i];
                continue;
            }

            if (nums[i] > 0 && tempResult < nums[i]) {
                tempResult = nums[i];
                continue;
            }

            int temp = tempResult + nums[i];
            int forwardTemp = Integer.MIN_VALUE;
            if (i != nums.length-1) {
                forwardTemp = temp + nums[i+1];
            }

            if(temp < forwardTemp && result < forwardTemp) {
                result = forwardTemp;
                tempResult = Integer.MIN_VALUE;
                i++;
                continue;
            }

            if (tempResult > temp && result < tempResult) {
                result = tempResult;
                tempResult = Integer.MIN_VALUE;
                continue;
            }
        }

        int max = Math.max(result, tempResult);

        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }

        return max;

    }*/

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i : nums) {
            int value = result.getOrDefault(i, 0);
            result.put(i, value + 1);
        }

        return result.entrySet().stream().filter(iSet -> iSet.getValue() == 1).findFirst().get().getValue();
    }
}
