import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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