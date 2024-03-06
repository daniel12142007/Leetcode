import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    //334. Increasing Triplet Subsequence(00:32:29)
    public static boolean increasingTriplet(int[] nums) {
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

    //    1768. Merge Strings Alternately(00:08:38)
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