import java.util.Arrays;

public class Tasks {

    //1
    public static int ertiCifri(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }


    //2
    public static int minSplit(int amount) {
        int[] coins = {1, 5, 10, 20, 50};
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int tetri : coins) {
            for (int i = tetri; i <= amount; i++) {
                if (dp[i - tetri] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - tetri] + 1);
                }
            }
        }

        return dp[amount];
    }



    //3
    public static int notContains(int[] array) {
        Arrays.sort(array);

        int smallestPositive = 1;

        for (int num : array) {
            if (num == smallestPositive) {
                smallestPositive++;
            } else if (num > smallestPositive) {
                return smallestPositive;
            }
        }

        return smallestPositive;
    }

    //4
    public static String Binary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int c = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || c > 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int sum = bitA + bitB + c;
            c = sum / 2;
            int bitSum = sum % 2;

            result.insert(0, bitSum);
            i--;
            j--;
        }

        return result.toString();
    }

    //5
    public static int countVariants(int stairsCount) {
        if (stairsCount <= 1) {
            return 1;
        }
        return countVariants(stairsCount - 1) + countVariants(stairsCount - 2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 2, 6, 4, 3, 3};
        int result1 = ertiCifri(nums);
        System.out.println("ar meordeba: " + result1);

        int amount = 54;
        int minCoins = minSplit(amount);
        System.out.println("Minimum number of coins change " + amount + " tetri: " + minCoins);

        int[] array = {1, 2, 4, 5, 2, 3, 7, 10};
        int result3 = notContains(array);
        System.out.println("minimaluri mteli ricxvi romelic ar aris masivshi: " + result3);

        String a = "1010";
        String b = "1011";
        String result4 = Binary(a, b);
        System.out.println("jami " + a + " da " + b + " aris: " + result4);

        int stairsCount = 6;
        int variants = countVariants(stairsCount);
        System.out.println("variantebis raodenoba " + 6 + " sartulianze: " + variants);
    }
}
