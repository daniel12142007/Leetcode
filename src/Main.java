public class Main {
    public static void main(String[] args) {

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