import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/example.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            MyReader reader = new MyReader(bufferedReader);

            // 1. readAt
            final String line = reader.readAt(1);
            System.out.println(line);

            System.out.println("---------------");

            // 2. readWords
            final List<String> words = reader.readWords();
            for (var word: words) {
                System.out.println(word);
            }
        }
        catch(IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
}