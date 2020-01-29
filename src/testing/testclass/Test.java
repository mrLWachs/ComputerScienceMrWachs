

/** required package class namespace */
package testing.testclass;

import collections.LinkedList;

 
/**
 * Test.java - description
 *
 * @author Mr. Wachs
 * @since Jan. 29, 2020, 12:51:24 p.m.
 */
public class Test 
{

    private static TestClass test = new TestClass();
    
    public static Boolean getBoolean() {
        return (Boolean)test.theBoolean;
    }
    
    public static Integer getInteger() {
        return (Integer)test.theInteger;
    }
    
    public static Double getDouble() {
        return (Double)test.theDouble;
    }
    
    public static Character getCharacter() {
        return (Character)test.theCharacter;
    }
    
    public static String getString() {
        return (String)test.associate.theString;
    }
    
    public static Boolean[] getBooleanArray() {
        Boolean[] array = new Boolean[test.booleanArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Boolean)test.booleanArray[i];
        }
        return array;
    }
    
    public static Integer[] getIntegerArray() {
        Integer[] array = new Integer[test.integerArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Integer)test.integerArray[i];
        }
        return array;
    }
    
    public static Double[] getDoubleArray() {
        Double[] array = new Double[test.doubleArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Double)test.doubleArray[i];
        }
        return array;
    }

    public static Character[] getCharacterArray() {
        Character[] array = new Character[test.characterArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Character)test.characterArray[i];
        }
        return array;
    }

    public static String[] getStringArray() {
        String[] array = new String[test.associateArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (String)test.associateArray[i].theString;
        }
        return array;
    }
    
    public static LinkedList<Boolean> getBooleanList() {
        return new LinkedList<Boolean>(getBooleanArray());
    }
    
    public static LinkedList<Integer> getIntegerList() {
        return new LinkedList<Integer>(getIntegerArray());
    }
    
    public static LinkedList<Double> getDoubleList() {
        return new LinkedList<Double>(getDoubleArray());
    }
    
    public static LinkedList<Character> getCharacterList() {
        return new LinkedList<Character>(getCharacterArray());
    }
    
    public static LinkedList<String> getStringList() {
        return new LinkedList<String>(getStringArray());
    }
    
    
}
