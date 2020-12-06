import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import samplejunit.JUnit5Example;

class JUnit5ExampleTest
{

    @Test
    void testExample1()
    {
        JUnit5Example obj = new JUnit5Example();
        assertEquals(obj.getUpperMessage("Hello World!"), "HELLO WORLD!");
    }

    @Test
    void testExample2()
    {
        JUnit5Example obj = new JUnit5Example();
        assertEquals(obj.getUpperMessage("Hello World!"), "HELLO WORLD!");
    }

    @Test
    void testExample3()
    {
        JUnit5Example obj = new JUnit5Example();
        assertEquals(obj.getUpperMessage("Hello World!"), "HELLO WORLD!");
    }
}
