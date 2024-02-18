public class Main {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pgr"));
    }

    //    1768. Merge Strings Alternately(00:08:38)
    public static String mergeAlternately(String word1, String word2) {
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