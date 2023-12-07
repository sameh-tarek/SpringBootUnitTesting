package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtils();
       // System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @DisplayName("Multiply")
    @Test
    void testMultiply(){
        assertEquals(12, demoUtils.multiply(2,6), "2*6 should be 12");
    }

    @Test
    @DisplayName("Equals and not Equals")
    @Order(1)
    void testEqualsAndNotEquals(){
        System.out.println("Running test : testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1,9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    @Order(-5)
    void testNullAndNotNull(){
        System.out.println("Running test : testNullAndNotNull");

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "object should be null");
        assertNotNull(demoUtils.checkNull(str2), "object should be not null");
    }

    @DisplayName("Same and Not Same")
    @Test
    @Order(3)
    void testSameAndNotSame(){
        System.out.println("Running test : testSameAndNotSame");

        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "objects should not refer to same object");
    }

    @DisplayName("True and false")
    @Test
    @Order(4)
    void testTrueFalse(){
        System.out.println("Running test : testTrueFalse");

        int grade1= 10;
        int grade2= 5;

        assertTrue(demoUtils.isGreater(grade1, grade2), "this should return true");
        assertFalse(demoUtils.isGreater(grade2, grade1), "this should return false");
    }

    @DisplayName("Arrays Equals")
    @Test
    @Order(5)
    void testArrayEquals(){
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @DisplayName("Iterable equals")
    @Test
    @Order(6)
    void testIterableEquals(){
        List<String> theList = List.of("luv", "2", "code");

        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }

    @DisplayName("Lines match")
    @Test
    @Order(7)
    void testLinesMatch(){
        List<String> theList = List.of("luv", "2", "code");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @DisplayName("Throws and Does Not Throw")
    @Test
    @Order(8)
    void testThrowsAndDoesNotThrow(){
        assertThrows(Exception.class, () -> {demoUtils.throwException(-1); }, "should throw exception");
        assertDoesNotThrow( () -> {demoUtils.throwException(9); }, "should not throw exception");
    }

    @DisplayName("Timeout")
    @Test
    @Order(9)
    void testTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {demoUtils.checkTimeout();}, "method should execute in 3 seconds");
    }



/*    @AfterEach
    void setupAfterEach(){
        System.out.println("Running: @AfterEach");
        System.out.println();
    }

    @BeforeAll
    static void setupBeforeEachClass(){
        System.out.println("@BeforeAll executes only once  before all test methods execution in the class");
    }

    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("@AfterAll executes only once  After all test methods execution in the class");
    }*/
}
