import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyReader {
    final BufferedReader reader;

    MyReader(BufferedReader reader) {
        this.reader = reader;
    }

    public List<String> readWords() throws IOException {
        String line;
        List<String> words = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            words.addAll(MyReaderUtils.getWordsFromLine(line));
        }
        return words;
    }


    public String readAt(int lineNumber) throws IOException {
        String line;
        int currentLine = 0;

        while (true) {
            if (currentLine == lineNumber) {
                return reader.readLine();
            }

            if ((line = reader.readLine()) == null) {
                return null;
            }
            ++currentLine;
        }
    }
}
