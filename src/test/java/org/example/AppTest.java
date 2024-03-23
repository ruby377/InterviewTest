package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AppTest {
    private final App app = new App();

    @Test
    public void testApp() {
        assertEquals("d", app.reduceString("aabcccbbad"));
        assertEquals("d", app.reduceStringAdvanced("abcccbad"));
    }
}
