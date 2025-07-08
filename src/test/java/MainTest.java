import org.example.Main;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainOutput() {
        // Call the main method
        Main.main(new String[]{});

        // Capture and verify the output
        String expectedOutput =
                "i = 1" + System.lineSeparator() +
                "i = 2" + System.lineSeparator() +
                "i = 3" + System.lineSeparator() +
                "i = 4" + System.lineSeparator() +
                "i = 5" + System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
}