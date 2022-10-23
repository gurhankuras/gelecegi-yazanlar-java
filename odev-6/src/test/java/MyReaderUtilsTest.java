import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class MyReaderUtilsTest {

    @Test
    void givenEmpty_ThenReturnsEmptyList() {
        var words = MyReaderUtils.getWordsFromLine("");
        List<String> expectedWords = new ArrayList<>();
        assertLinesMatch(expectedWords, words);
    }
    @Test
    void givenMultipleWords_ThenReturns() {
        var words = MyReaderUtils.getWordsFromLine("this is a test");
        var expectedWords = List.of("this", "is", "a", "test");
        assertLinesMatch(expectedWords, words);
    }

    @Test
    void givenMultipleWordsWithSpacesAtEndAndBeginning_ThenReturnsWordListWithoutSpace() {
        var words = MyReaderUtils.getWordsFromLine("          this is a test  ");
        var expectedWords = List.of("this", "is", "a", "test");
        assertLinesMatch(expectedWords, words);
    }

    @Test
    void givenASingleWord_ThenReturnsSingleWordList() {
        var words = MyReaderUtils.getWordsFromLine("nyaa");
        var expectedWords = List.of("nyaa");
        assertLinesMatch(expectedWords, words);
    }

    @Test
    void givenASingleWordWithSpacesAtBeginningAndEnd_ThenReturnsSingleWordList() {
        var words = MyReaderUtils.getWordsFromLine("      nyaa   ");
        var expectedWords = List.of("nyaa");
        assertLinesMatch(expectedWords, words);
    }

    @Test
    void givenHasSpaceInTheMiddleOfWords_ThenReturnsWordListWithoutSpace() {
        var words = MyReaderUtils.getWordsFromLine("this is               pencil");
        var expectedWords = List.of("this", "is", "pencil");
        assertLinesMatch(expectedWords, words);
    }
}
