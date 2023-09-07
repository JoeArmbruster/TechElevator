import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MidModulePractice {
    public static void main(String[] args) {
        String president = "Lincoln";
        String[] speech = {"Fourscore", "and", "seven", "years", "ago"};

        displayStringArray(speech);

        char[] presidentLetters = stringToCharArray(president);
        displayCharArray(presidentLetters);

        String[] presidentOneLetterSubstrings = stringToOneLetterStringArray(president);
        displayStringArray(presidentOneLetterSubstrings);

        String[] presidentTwoLetterSubstrings = stringToTwoLetterStringArray(president);
        displayStringArray(presidentTwoLetterSubstrings);

        List<String> shortWords = removeLongWords(speech);
        System.out.println(shortWords);

        Map<Character, Integer> characterCount = getCharacterCount("aardvark");
        System.out.println(characterCount);
    }

    /*
    In the console, show each element in the String array in a comma-separated list
    Bonus: eliminate the tailing comma after the last item.
     */
    public static void displayStringArray(String[] strings) {
        int i = 0;
        for (; i < strings.length - 1; i++) {
            System.out.print(strings[i] + ", ");
        }
        System.out.println(strings[i]);
    }

    /*
    Show each char in the String array in a comma-separated list
    Bonus: eliminate the tailing comma after the last item.
     */
    public static void displayCharArray(char[] letters) {
        int i = 0;
        for (; i < letters.length - 1; i++) {
            System.out.print(letters[i] + ", ");
        }
        System.out.println(letters[i]);
    }

    /*
    Return a char array that contains each character from the String parameter
     */
    public static char[] stringToCharArray(String s) {
        char[] theLetters = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            theLetters[i] = s.charAt(i);
        }
        return theLetters;
    }

    /*
Return an array of one letter words generated from the String parameter.
"Dog" --> ["D", "o", "g"]
 */
    public static String[] stringToOneLetterStringArray(String s) {
        String[] oneLetterSubstrings = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            oneLetterSubstrings[i] = sub;
        }
        return oneLetterSubstrings;
    }

    /*
Return an array of two letter words generated from the String parameter.
    "N" --> []
    "At" --> ["At"]
    "Dog" --> ["Do", "og"]

*/
    public static String[] stringToTwoLetterStringArray(String s) {
        String[] twoLetterSubstrings = new String[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 2);
            twoLetterSubstrings[i] = sub;
        }
        return twoLetterSubstrings;
    }

    /*
    Return a List that contains every word from the words parameter that has 3
    characters or fewer
     */
    public static List<String> removeLongWords(String[] words) {
        List<String> shortWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() <= 3) {
                shortWords.add(word);
            }
        }
        return shortWords;
    }

    /*
    Return a Map <Character, Integer> that stores each character found in the String, along with a count of
    how many times that character is found
     */
    public static Map<Character, Integer> getCharacterCount(String s) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (characterCount.containsKey(letter)) {
                characterCount.put(letter, characterCount.get(letter) + 1);
            } else {
                characterCount.put(letter, 1);
            }
        }

        return characterCount;
    }
}
