import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }

    //643. Maximum Average Subarray I(00:30:00)
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int l1 = 0;
        int l2 = 0;
        int count = 0;
        while (l1 < nums.length) {
            while (l1 - count < k) {
                sum += nums[l1];
                l1++;
            }
            if (sum > max) {
                max = sum;
            } else {
                sum -= nums[l2];
                l2++;
                count++;
            }
        }
        return (double) max / k;
    }

    //1679. Max Number of K-Sum Pairs(00:09:00)
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int right = nums.length - 1;
        int left = 0;
        int count = 0;
        while (left < right) {
            if (nums[right] + nums[left] == k) {
                right--;
                left++;
                count++;
            }
            if (nums[right] + nums[left] > k)
                right--;
            if (nums[right] + nums[left] < k)
                left++;

        }
        return count;
    }

    //392. Is Subsequence(00:20:05 Failure)(00:30:12 Success)
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        int count = 0;
        if (s.equals(""))
            return true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(t);
        for (char c : s.toCharArray()) {
            boolean a = true;
            if (index < stringBuilder.indexOf(String.valueOf(c))) {
                count++;
                index = stringBuilder.indexOf(String.valueOf(c));
                stringBuilder.replace(index, index + 1, " ");
                a = false;
            }
            if (index < stringBuilder.lastIndexOf(String.valueOf(c)) && a) {
                count++;
                index = stringBuilder.lastIndexOf(String.valueOf(c));
                stringBuilder.replace(index, index + 1, " ");
            }
            a = true;
            if (count == s.length())
                return true;
        }
        return false;
    }

    //283. Move Zeroes(00:42:18)
    public void moveZeroes(int[] numbers) {
        int[] array = new int[numbers.length];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                array[count] = numbers[i];
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            numbers[i] = array[i];
        }
    }

    //443. String Compression(00:25:30 Failure)(00:56:12 Failure)(00:04:16 Success)
    public int compress(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            } else {
                stringBuilder.append(chars[i]);
                if (count > 1)
                    stringBuilder.append(count);
                count = 1;
            }
        }
        for (int i = 0; i < stringBuilder.toString().toCharArray().length; i++) {
            chars[i] = stringBuilder.charAt(i);
        }
        return stringBuilder.length();
    }

    //334. Increasing Triplet Subsequence(00:32:29)
    public boolean increasingTriplet(int[] nums) {
        if (Arrays.stream(nums).max().getAsInt() == 2 && Arrays.stream(nums).min().getAsInt() > 0)
            return false;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int i1 = i; i1 >= 0; i1--) {
                if (nums[i] > nums[i1]) {
                    for (int i2 = i1; i2 >= 0; i2--) {
                        if (nums[i1] > nums[i2])
                            return true;
                    }
                }
            }
        }
        return false;
    }

    //151. Reverse Words in a String(00:15:47)
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("14.12.2007");
                stringBuilder.append(c);
                stringBuilder.append("14.12.2007");
            } else {
                stringBuilder.append(c);
            }
        }
        String[] strings = stringBuilder.toString().split("14.12.2007");
        String result = "";
        for (int i = strings.length - 1; i >= 0; i--)
            result = result + strings[i];
        return result.trim().replaceAll("\\s+", " ");
    }

    //345. Reverse Vowels of a String(00:29:42 Failure)(00:18:40 Success)
    public String reverseVowels(String s) {
        String check = "aeiouAEIOU";
        int countIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (check.indexOf(c) != -1) {
                stringBuilder.append(c);
                countIndex++;
            }
        }
        countIndex--;
        char[] result = stringBuilder.toString().toCharArray();
        stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (check.indexOf(c) != -1) {
                stringBuilder.append(result[countIndex]);
                countIndex--;
            } else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }


    //605. Can Place Flowers(00:25:47)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed[0] == 0 && flowerbed.length == 1)
            return true;
        for (int i = 1; i < flowerbed.length; i++) {
            if (i - 1 > 0 && i + 1 < flowerbed.length && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                count++;
            }
            if (i + 1 < flowerbed.length && flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                count++;
            }
            if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                flowerbed[flowerbed.length - 2] = 1;
                count++;
            }
        }
        return count >= n;
    }

    //1431. Kids With the Greatest Number of Candies(00:08:33)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        for (int candy : candies) {
            list.add(checkCandies(candies, candy + extraCandies));
        }
        return list;
    }

    boolean checkCandies(int[] candies, int count) {
        if (Arrays.stream(candies).max().getAsInt() <= count)
            return true;
        return false;
    }

    //1071. Greatest Common Divisor of Strings(00:48:39)
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int gbcValue = gcb(str1.length(), str2.length());
        return str2.substring(0, gbcValue);
    }

    int gcb(int x, int y) {
        if (y == 0)
            return x;
        else return gcb(y, x % y);
    }

    //1768. Merge Strings Alternately(00:08:38)
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.max(word1.getBytes().length, word2.getBytes().length); i++) {
            if (i < word1.getBytes().length) {
                stringBuilder.append(word1.charAt(i));
            }
            if (i < word2.getBytes().length) {
                stringBuilder.append(word2.charAt(i));
            }
        }
        return String.valueOf(stringBuilder);
    }
}