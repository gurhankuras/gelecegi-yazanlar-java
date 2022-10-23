import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyReaderUtils {
    public static List<String> getWordsFromLine(String line) {
        if (line.isBlank()) {
            return Collections.emptyList();
        }
        int wordStartIndex = 0;
        int wordEndIndex = 0;
        String trimmedLine = line.trim();

        char lastChar = trimmedLine.charAt(trimmedLine.length() - 1);
        List<String> lineWords = new ArrayList<>();
        for(int i = 0; i < trimmedLine.length(); ++i) {
            var ch = trimmedLine.charAt(i);
            wordEndIndex = i;
            if (i == trimmedLine.length() - 1) {
                lineWords.add(trimmedLine.substring(wordStartIndex, wordEndIndex + 1));
                continue;
            }

            if (ch == ' ' && lastChar != ch) {
                lineWords.add(trimmedLine.substring(wordStartIndex, wordEndIndex).trim());
                wordStartIndex = i + 1;
            }

            if (ch == ' ' && lastChar == ch) {
                wordStartIndex = i + 1;
            }
            lastChar = ch;
        }
        return lineWords;
    }

}
