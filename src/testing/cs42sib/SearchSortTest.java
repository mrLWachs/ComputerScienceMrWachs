
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.Simulator;
import io.System;
import testing.testclass.TestClass;


/**
 * PermanentStorageTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class SearchSortTest 
{

    /**
     * Default constructor, set class properties
     */
    public SearchSortTest() {
        Simulator.header("Searching and Sorting Test started...");
        
        for (int i = 0; i < 1; i++) {
            TestClass test = new TestClass();
            System.out.println(test.toString());
        }
        
        Simulator.header("Searching and Sorting Test completed!");
    }   

}
