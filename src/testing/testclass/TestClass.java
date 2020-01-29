/** required package class namespace */
package testing.testclass;

/** required imports */
import collections.LinkedList;
import java.io.Serializable;
import tools.Numbers;
import tools.Text;


/**
 * TestClass.java - a test class for randomly generated data types
 * 
 * @author Mr. Wachs 
 * @since Dec 16, 2016
 */
public class TestClass extends BaseClass implements Serializable, 
        Comparable<Object>
{

    
    /** Class associated with this class, randomly generated data */
    public AssociateClass associate = new AssociateClass(1); 
    /** Class associated with this class, randomly generated data */
    public AssociateClass[] associateArray;    
    /** Randomly generated data for this class */
    public boolean[] booleanArray;
    /** Randomly generated data for this class */
    public int[] integerArray;
    /** Randomly generated data for this class */
    public double[] doubleArray;
    /** Randomly generated data for this class */
    public char[] characterArray;    
    /** Randomly generated data for this class */
    public String[] wordsArray;    
    /** Text class for generating text, shared */
    public static Text text = new Text();
    /** Numbers class for generating numbers, shared */
    public static Numbers numbers = new Numbers();
    /** constant for characters */
    public static final char ALPHA_LOW = 'a';
    /** constant for characters */
    public static final char ALPHA_HIGH = 'z';
    /** constant to delimit member data */
    public static final String DELIMIT = "|";    
    /** The text of all member data stored */
    private String values;
            
    /** 
     * Default constructor 
     */
    public TestClass() {
        this(5);
    }
    
    /**
     * Constructor sets class properties
     * 
     * @param length the size to make all arrays and random values
     */
    public TestClass(int length) {
        super(length);   
        associate      = new AssociateClass(length);
        booleanArray   = numbers.random(length);
        integerArray   = numbers.random(0, length, length);
        doubleArray    = numbers.random(0d, (double)length, length);
        characterArray = text.random(ALPHA_LOW, ALPHA_LOW, length);
        wordsArray     = text.randomWords(length);
        associateArray = new AssociateClass[length];        
        for (int i = 0; i < length; i++) {
            associateArray[i] = new AssociateClass(length);
        }
//        generateValues();
    }

    /**
     * String representation of this object
     * 
     * @return the string version of this object
     */
    @Override
    public String toString() {           
        return values;
    }
    
    /**
     * Returns a duplicate object using new memory
     * 
     * @return a clone of the object with new memory
     */
    public TestClass clone() {
        TestClass testClass      = new TestClass();
        testClass.associate      = this.associate.clone();        
        testClass.theBoolean     = this.theBoolean;
        testClass.theInteger     = this.theInteger;
        testClass.theDouble      = this.theDouble;
        testClass.theCharacter   = this.theCharacter;
        testClass.booleanArray   = new boolean[length]; 
        testClass.integerArray   = new int[length];
        testClass.doubleArray    = new double[length];
        testClass.characterArray = new char[length];
        testClass.wordsArray     = new String[length];        
        testClass.associateArray = new AssociateClass[length];
        for (int i = 0; i < length; i++) {
            testClass.booleanArray[i]   = this.booleanArray[i];
            testClass.integerArray[i]   = this.integerArray[i];
            testClass.doubleArray[i]    = this.doubleArray[i];
            testClass.characterArray[i] = this.characterArray[i];
            testClass.wordsArray[i]     = this.wordsArray[i];            
            testClass.associateArray[i] = this.associateArray[i];
        }           
        testClass.generateValues();
        return testClass;
    }
    
    /**
     * Determines if 2 objects are "equal" in this context
     * 
     * @param object the object to compare to
     * @return equal (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {      
        try {  
            TestClass that = (TestClass)object;
            return this.toString().equals(that.toString());
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("equals() Error: " + e.toString());
            return false;
        }   
    }
        
    /**
     * Compares two objects lexicographically
     *
     * @param object the other object to be compared to
     * @return the value 0 if the argument string is equal to
     *          this object; a value less than 0 if this object
     *          is lexicographically less than the argument; and a
     *          value greater than 0 if this object is
     *          lexicographically greater than the argument
     */
    @Override
    public int compareTo(Object object) {
        try {  
            TestClass that = (TestClass)object;
            return this.toString().compareTo(that.toString());   
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("compareTo() Error: " + e.toString());
            return -1;
        }        
    }
      
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param size the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList generateList(int size) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {       
            linkedList.add(new TestClass());            
        }
        return linkedList;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param size the size of the array to generate
     * @return an array of random objects
     */
    public static TestClass[] generateArray(int size) {
        TestClass[] array = new TestClass[size];
        for (int i = 0; i < size; i++) {       
            array[i] = new TestClass();            
        }
        return array;
    }
    
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param size the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList generateUniqueList(int size) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {
            TestClass test;
            boolean valid;
            do {      
                valid = true;
                test = new TestClass();
                for (int j = 0; j < i; j++) {
                    if (linkedList.get(j).equals(test)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);            
            linkedList.add(test);            
        }
        return linkedList;
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param size the size of the array to generate
     * @return a array of unique random objects
     */
    public static TestClass[] generateUniqueArray(int size) {
        TestClass[] array = new TestClass[size];
        for (int i = 0; i < size; i++) {
            TestClass test;
            boolean valid;
            do {      
                valid = true;
                test = new TestClass();
                for (int j = 0; j < i; j++) {
                    if (array[j].equals(test)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);  
            array[i] = test;          
        }
        return array;
    }
    
    /**
     * Returns a hash code value for the object from all the properties of 
     * this class, its inherited classes, and associated classes. It returns 
     * a consistent code each time which is a 1 or 2 digit number between 0-99
     * 
     * @return a hash code value for this object 
     */
    @Override
    public int hashCode() { 
        return TestClass.generate(values);
    }

    /**
     * Generates a one or two digit number (between 0 - 99) based on a hash
     * algorithm with the passed text
     * 
     * @param text the text to generate a number from
     * @return the one or two digit integer (between 0-99)
     */
    public static int generate(String text) {
        String[] values = text.split("[|]");
        String allText = "";
        for (int i = 0; i < values.length; i++) {
            allText += values[i];
        }
        String number = "0";
        int oneDigit = TestClass.numbers.random(0,100);
        if (oneDigit >= 0 && oneDigit <= 9) {
            int  mid       = (allText.length()-1) / 2;
            char character = allText.charAt(mid);
            number         = character + "";
        }
        else {
            int  mid1       = (allText.length()-1) / 2;
            int  mid2       = mid1 / 2;
            char character1 = allText.charAt(mid1);
            char character2 = allText.charAt(mid2);
            number          = character1 + "" + character2;
            
        }
        return Integer.parseInt(number);
    }
    
    /**
     * Generates all the values from all the properties of this class, its 
     * inherited classes, and associated classes.
     */
    protected void generateValues() {
        values  = Boolean.toString(super.theBoolean)     + TestClass.DELIMIT; 
        values += Integer.toString(super.theInteger)     + TestClass.DELIMIT; 
        values += Double.toString(super.theDouble)       + TestClass.DELIMIT; 
        values += Character.toString(super.theCharacter) + TestClass.DELIMIT; 
        values += associate.theString + TestClass.DELIMIT; 
        for (int i = 0; i < length; i++) {
            values += Boolean.toString(booleanArray[i])     + TestClass.DELIMIT; 
            values += Integer.toString(integerArray[i])     + TestClass.DELIMIT; 
            values += Double.toString(doubleArray[i])       + TestClass.DELIMIT; 
            values += Character.toString(characterArray[i]) + TestClass.DELIMIT;
            values += associateArray[i].theString           + TestClass.DELIMIT;
            for (int j = 0; j < wordsArray[i].length(); j++) {
                values += wordsArray[j] + TestClass.DELIMIT;                
            }
        }
    }
    
}