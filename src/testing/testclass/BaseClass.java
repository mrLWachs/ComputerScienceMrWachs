
/** required package class namespace */
package testing.testclass;

/** required imports */
import java.io.Serializable;

/**
 * BaseClass.java - a base class for the testing class to inherit from
 primitive data properties
 * 
 * @author Mr. Wachs 
 * @since Dec 1, 2016
 */
public class BaseClass implements Serializable, Comparable<Object>
{
        
    /** Randomly generated data for this class */
    protected boolean theBoolean;
    /** Randomly generated data for this class */
    protected int theInteger;
    /** Randomly generated data for this class */
    protected double theDouble;
    /** Randomly generated data for this class */
    protected char theCharacter;
    /** The text of all member data stored */
    private String values;
    /** The length for size generations */ 
    public static int length;  
    
    
    /**
     * Default Constructor sets class properties
     * 
     * @param length the size to make all arrays and random values
     */
    public BaseClass(int length) {    
        this.length  = length;
        theBoolean   = TestClass.numbers.random();
        theInteger   = TestClass.numbers.random(0, length);
        theDouble    = TestClass.numbers.random(0d, (double)length);
        theCharacter = TestClass.text.random(TestClass.ALPHA_LOW, 
                                             TestClass.ALPHA_HIGH);
        values  = Boolean.toString(theBoolean)     + TestClass.DELIMIT; 
        values += Integer.toString(theInteger)     + TestClass.DELIMIT; 
        values += Double.toString(theDouble)       + TestClass.DELIMIT; 
        values += Character.toString(theCharacter) + TestClass.DELIMIT;
    }

    /**
     * Constructor sets class properties
     * 
     * @param values text of all member data stored
     * @param theBoolean Boolean value
     * @param theInteger integer value
     * @param theDouble double value
     * @param theCharacter character value
     */
    public BaseClass(String values,
                     boolean theBoolean,
                     int theInteger,
                     double theDouble,
                     char theCharacter) {    
        this.values       = values;
        this.theBoolean   = theBoolean;
        this.theInteger   = theInteger;
        this.theDouble    = theDouble;
        this.theCharacter = theCharacter;
        values  = Boolean.toString(theBoolean)     + TestClass.DELIMIT; 
        values += Integer.toString(theInteger)     + TestClass.DELIMIT; 
        values += Double.toString(theDouble)       + TestClass.DELIMIT; 
        values += Character.toString(theCharacter) + TestClass.DELIMIT;
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
     * Determines if 2 objects are "equal" in this context
     * 
     * @param object the object to compare to
     * @return equal (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        try {  
            BaseClass that = (BaseClass)object;
            return this.toString().equals(that.toString());
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("equals() Error: " + e.toString());
            return false;
        } 
    }
    
    /**
     * Returns a duplicate object using new memory
     * 
     * @return a clone of the object with new memory
     */
    @Override
    public BaseClass clone() {
        return new BaseClass(this.values,
                             this.theBoolean,
                             this.theInteger,
                             this.theDouble,
                             this.theCharacter);
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
            BaseClass that = (BaseClass)object;
            return this.toString().compareTo(that.toString()); 
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("compareTo() Error: " + e.toString());
            return -1;
        }
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

}