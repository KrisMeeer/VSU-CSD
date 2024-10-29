import java.util.*;

    public class ProperNouns {

        public static List<String> findProperNouns(String text) {
            Set<String> properNounsSet = new HashSet<>();
            String[] sentences = text.split("[.!?]");

            for (String sentence : sentences) {
                int iter = 0;
                sentence = sentence.trim();
                if (!sentence.isEmpty()) {
                    String[] words = sentence.split("[,\\s]+");

                    for (String word : words) {
                        iter+=1;
                        if (Character.isUpperCase(word.charAt(0)) && word.length() > 1 && iter != 1) {
                            properNounsSet.add(word);
                        }
                    }
                }
            }

            return new ArrayList<>(properNounsSet);
        }
    }

