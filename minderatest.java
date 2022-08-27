package devskiller;

import java.util.*;

public class Exercise {
    public String findFirstRepeatedWords(String paragraph) throws IllegalArgumentException {
        String wordToReturn = null;
        
        //base condition to check if null or empty
        if (paragraph == null || paragraph.isEmpty())
            return null;
        
        //getting first sentence
        String sentence = paragraph.split("[.]")[0];
        
        //storing word frequency in LinkedHashMap which maintains insertion order
        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        for(String word: sentence.split(" ")) {
            //replacing all special chars with empty
            word = word.replaceAll("[^a-zA-Z]", "").trim().toLowerCase();
            if (wordsMap.get(word) == null) {
                wordsMap.put(word, 0);
            }
            wordsMap.put(word, wordsMap.get(word) + 1);
        }
        
        for(Map.Entry<String, Integer> entry: wordsMap.entrySet()) {
            if (entry.getValue() > 1) {
                //storing first repeated key and exiting loop
                wordToReturn = entry.getKey();
                break;
            }
        }
        
        if (wordToReturn == null)
            throw new IllegalArgumentException();
        else 
            return wordToReturn;
    }
}
