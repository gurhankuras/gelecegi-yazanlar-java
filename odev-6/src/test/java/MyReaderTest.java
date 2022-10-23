import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class MyReaderTest {
    String line1 = "this is a";
    String line2 = "nice extension";
    String line3 = "zaa df";

    private List<String> getWordsResult() {
        return List.of(line1.concat(" ").concat(line2).concat(" ").concat(line3).split(" "));
    }

    @Test
    void readAt_givenHas3Lines_WhenReadsFirst_ThenReturnsFirstLine() throws IOException {
        // Arrange
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn(line1, line2, line3, null);
        var sut = new MyReader(reader);

        // Act
        final String result = sut.readAt(0);

        // Assert
        assertEquals(line1, result);
    }

    @Test
    void readAt_givenHas3Lines_WhenReadsTheMiddle_ThenReturnsSecondLine() throws IOException {
        // Arrange
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn(line1, line2, line3, null);
        var sut = new MyReader(reader);

        // Act
        final String result = sut.readAt(1);

        // Assert
        assertEquals(line2, result);
    }

    @Test
    void readAt_givenHas3Lines_WhenReadsLastLine_ThenReturnsThirdLine() throws IOException {
        // Arrange
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn(line1, line2, line3, null);
        var sut = new MyReader(reader);

        // Act
        final String result = sut.readAt(2);

        // Assert
        assertEquals(line3, result);
    }


    @Test
    void readWords_ReturnsWords() throws IOException {
        // Arrange
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn(line1, line2, line3, null);
        var sut = new MyReader(reader);
        final List<String> expected = List.of();

        // Act
        final List<String> result = sut.readWords();

        // Assert
        assertLinesMatch(getWordsResult(), result);
    }
}