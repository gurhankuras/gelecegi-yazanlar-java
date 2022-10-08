import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        var result = getLettersAndCounts(input);

        System.out.println(result);
    }

    // O(n^2)
    static String getLettersAndCounts(String input) {
        var letters = new ArrayList<Character>();
        var counts = new ArrayList<Integer>();

        for(var i = 0; i < input.length(); ++i) {
            var letter = input.charAt(i);
            var index = letters.indexOf(letter);
            if (index == -1) {
                letters.add(letter);
                counts.add(1);
            }
            else {
                counts.set(index, counts.get(index) + 1);
            }
        }

        var builder = new StringBuilder();
        for(var i = 0; i < letters.size(); ++i) {
           builder.append(letters.get(i))
                   .append(counts.get(i));
        }

        return builder.toString();
    }
}