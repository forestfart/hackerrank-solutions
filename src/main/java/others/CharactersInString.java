package others;

import java.util.*;

public class CharactersInString {

    public static void main (String args[]) {
        String input = new String("The Academy");
        String result = new String();
        input = input.toLowerCase();
        char[] characters = input.toCharArray();
        Map<Character, Integer> charactersMap = new HashMap<Character, Integer>();
        for (char elememnt : characters) {

            if (charactersMap.containsKey(elememnt)) {
                charactersMap.put(elememnt, charactersMap.get(elememnt) + 1);
            } else {
                charactersMap.put(elememnt, 1);
            }
        }

        Iterator iterable = charactersMap.entrySet().iterator();

       /* while (iterable.hasNext()) {
            Map.Entry element = (Map.Entry) iterable.next();
            result += String.format("'%c':%d,", element.getKey(), element.getValue());
        }*/

        for (int i = 0; i < input.length(); i++) {
            //Map.Entry element = (Map.Entry) iterable.next();
            if (charactersMap.get(input.charAt(i)) != null)
            result += String.format("'%c':%d,", input.charAt(i), charactersMap.get(input.charAt(i)));
            charactersMap.remove(input.charAt(i));
        }
        System.out.print(result.substring(0, result.length()-1));
    }
}
