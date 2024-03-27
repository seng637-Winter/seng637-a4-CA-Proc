package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DataUtilitiesTest extends DataUtilities {
	
	private int[] rows1 = {0,1}; 
	private int[] cols1 = {0,1}; 

	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    // calculateColumnTotal() TESTS

    // #1
    @Test
    public void calculateColumnTotalNullDataShouldThrowException() {
    	thrown.expect(IllegalArgumentException.class);
        DataUtilities.calculateColumnTotal(null, 1);
    }
    
    // #2
    @Test
    public void calculateColumnTotalOfColumn0ShouldReturn3() {   
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(twoByThreeValues2D).getRowCount();
            will(returnValue((2))); 
            
            oneOf(twoByThreeValues2D).getColumnCount();
            will(returnValue((3))); 
            
	        oneOf(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(twoByThreeValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(0, 2);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(twoByThreeValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 2);
	        will(returnValue((2)));
	        
        }});
        
    	assertEquals("The sum of column 0 should return 3",
    		        3, DataUtilities.calculateColumnTotal(twoByThreeValues2D, 0), .000000001d);
    }
    
    // #3
    @Test
    public void calculateColumnTotalOfColumn1ShouldReturn2() { 
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(twoByThreeValues2D).getRowCount();
            will(returnValue((2))); 
            
            oneOf(twoByThreeValues2D).getColumnCount();
            will(returnValue((3))); 
            
	        oneOf(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(twoByThreeValues2D).getValue(0, 1);
	        will(returnValue((null)));
	        
	        oneOf(twoByThreeValues2D).getValue(0, 2);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(twoByThreeValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 2);
	        will(returnValue((2)));
	        
        }});
        
    	assertEquals("The sum of column 1 should return 2",
    		        2.0, DataUtilities.calculateColumnTotal(twoByThreeValues2D, 1), .000000001d);
    }
    
    // #4
    @Test
    public void calculateColumnTotalOfColumn2ShouldReturn3() {
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(twoByThreeValues2D).getRowCount();
            will(returnValue((2))); 
            
            oneOf(twoByThreeValues2D).getColumnCount();
            will(returnValue((3))); 
            
	        oneOf(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(twoByThreeValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(0, 2);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(twoByThreeValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 2);
	        will(returnValue((2)));
	        
        }});
        
    	assertEquals("The sum of column 0 should return 3",
    		        3, DataUtilities.calculateColumnTotal(twoByThreeValues2D, 2), .000000001d);
    }

    
    // calculateRowTotal() TESTS
    
 // #1
    @Test
    public void calculateRowTotalNullDataShouldThrowException() {
    	thrown.expect(IllegalArgumentException.class);
        DataUtilities.calculateRowTotal(null, 1);
    }
    
    // #2
    @Test
    public void calculateRowTotalOfRow0ShouldReturn2() {   
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D threeByTwoValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(threeByTwoValues2D).getRowCount();
            will(returnValue((3))); 
            
            oneOf(threeByTwoValues2D).getColumnCount();
            will(returnValue((2))); 
            
	        oneOf(threeByTwoValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(threeByTwoValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(threeByTwoValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(threeByTwoValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(threeByTwoValues2D).getValue(2, 0);
	        will(returnValue((3))); 
	        
	        oneOf(threeByTwoValues2D).getValue(2, 1);
	        will(returnValue((3)));
	        
        }});
        
    	assertEquals("The sum of row 0 should return 2",
    		        2, DataUtilities.calculateRowTotal(threeByTwoValues2D, 0), .000000001d);
    }
    
    // #3
    @Test
    public void calculateRowTotalOfRow1ShouldReturn4() { 
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D threeByTwoValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(threeByTwoValues2D).getRowCount();
            will(returnValue((3))); 
            
            oneOf(threeByTwoValues2D).getColumnCount();
            will(returnValue((2))); 
            
	        oneOf(threeByTwoValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(threeByTwoValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(threeByTwoValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(threeByTwoValues2D).getValue(1, 1);
	        will(returnValue((null)));
	        
	        oneOf(threeByTwoValues2D).getValue(2, 0);
	        will(returnValue((3))); 
	        
	        oneOf(threeByTwoValues2D).getValue(2, 1);
	        will(returnValue((3)));
	        
        }});
        
    	assertEquals("The sum of row 1 should return 4",
    		        4.0, DataUtilities.calculateColumnTotal(threeByTwoValues2D, 1), .000000001d);
    }
    
    // #4
    @Test
    public void calculateRowTotalOfRow2ShouldReturn6() {
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D threeByTwoValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(threeByTwoValues2D).getRowCount();
            will(returnValue((3))); 
            
            oneOf(threeByTwoValues2D).getColumnCount();
            will(returnValue((2))); 
            
	        oneOf(threeByTwoValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(threeByTwoValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(threeByTwoValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(threeByTwoValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(threeByTwoValues2D).getValue(2, 0);
	        will(returnValue((3))); 
	        
	        oneOf(threeByTwoValues2D).getValue(2, 1);
	        will(returnValue((3)));
	        
        }});
        
    	assertEquals("The sum of row 2 should return 6",
    		        6, DataUtilities.calculateRowTotal(threeByTwoValues2D, 2), .000000001d);
    }
    
    // createNumberArray() TESTS
    
    // #1
    @Test
    public void createNumberArrayNullArrayShouldThrowException() {
        double[] array = null;
    	thrown.expect(IllegalArgumentException.class);
        DataUtilities.createNumberArray(array);
    }
    
    // #2
    @Test
    public void validArrayShouldReturnNumberArray() {
        double[] array = {1.0, 2.0, 3.0};
        Number[] expected = {1.0, 2.0, 3.0};
        assertEquals("Arrays are the same length", expected.length, DataUtilities.createNumberArray(array).length);
        assertArrayEquals("Results should be the same", expected, DataUtilities.createNumberArray(array));  
    }
    
    // #3
    @Test
    public void emptyArrayShouldReturnEmptyNumberArray() {
    	double[] array = {};
        Number[] expected = {};
        assertEquals("Arrays are the same length", expected.length, DataUtilities.createNumberArray(array).length);
        assertArrayEquals("Results should be the same", expected, DataUtilities.createNumberArray(array));  
    }
    
    // createNumberArray2D() TESTS
    
    // #1
    @Test
    public void createNumberArray2DNullArrayShouldThrowException() {
        double[][] array = null;
    	thrown.expect(IllegalArgumentException.class);
        DataUtilities.createNumberArray2D(array);
    }
    
    // #2
	@Test
    public void validArray2DShouldReturnNumberArray() {
        double[][] array = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
        Number[][] expected = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
        assertEquals("Arrays are the same length", expected.length, DataUtilities.createNumberArray2D(array).length);
        assertArrayEquals("Results should be the same", expected, DataUtilities.createNumberArray2D(array)); 
    }
    
    // #3
    @Test
    public void empty2DArrayShouldReturnEmptyNumberArray() {
    	double[][] array = {};
        Number[][] expected = {};
        assertEquals("Arrays are the same length", expected.length, DataUtilities.createNumberArray2D(array).length);
        assertArrayEquals("Results should be the same", expected, DataUtilities.createNumberArray2D(array)); 
    }
    
    // getCumulativePercentages() TESTS
    
    // #1
    @Test
    public void getCumulativePercentagesNullDataShouldThrowException() {
    	thrown.expect(IllegalArgumentException.class);
        DataUtilities.getCumulativePercentages(null);
    }
    
    // #2
    @Test
    public void getCumulativePercentagesSingleKeyedValueShouldReturn1() {
    	org.jmock.Mockery KeyedValuesDataMock= new Mockery();
    	final KeyedValues data = KeyedValuesDataMock.mock(KeyedValues.class);
    	KeyedValuesDataMock.checking(new org.jmock.Expectations()
        {{
        	atLeast(1).of(data).getItemCount();
            will(returnValue(1));
            
        	atLeast(1).of(data).getValue(0);
            will(returnValue((10))); 
            
            oneOf(data).getKey(0);
            will(returnValue((0)));
	        
        }});
    	
    	assertEquals("The key 0 in data {0, 10} should return 1", 
    			1.0, DataUtilities.getCumulativePercentages(data).getValue(0));
    }
    
    // #3
    @Test
    public void getCumulativePercentagesValidKeyedValuesShouldReturnPercentages() {
    	org.jmock.Mockery KeyedValuesDataMock= new Mockery();
    	final KeyedValues data = KeyedValuesDataMock.mock(KeyedValues.class);
    	KeyedValuesDataMock.checking(new org.jmock.Expectations()
        {{
        	atLeast(1).of(data).getItemCount();
            will(returnValue(3));         
            
            atLeast(1).of(data).getKey(0);
            will(returnValue((0)));
            
            atLeast(1).of(data).getKey(1);
            will(returnValue((1)));
            
            atLeast(1).of(data).getKey(2);
            will(returnValue((2)));
           
            atLeast(1).of(data).getValue(0);
            will(returnValue((2))); 
            
            atLeast(1).of(data).getValue(1);
            will(returnValue((3))); 
            
            atLeast(1).of(data).getValue(2);
            will(returnValue((5))); 
	        
        }});
    	
    	assertEquals("The key 0 in data should return 0.2", 
    			0.2, DataUtilities.getCumulativePercentages(data).getValue(0));
    	assertEquals("The key 1 in data should return 0.5", 
    			0.5, DataUtilities.getCumulativePercentages(data).getValue(1));
    	assertEquals("The key 3 in data should return 1.0", 
    			1.0, DataUtilities.getCumulativePercentages(data).getValue(2));
    }
    
    // #4
    @Test
    public void getCumulativePercentagesValidKeyedValuesWithAllZeroValuesShouldReturnInfinity() {
    	org.jmock.Mockery KeyedValuesDataMock= new Mockery();
    	final KeyedValues data = KeyedValuesDataMock.mock(KeyedValues.class);
    	KeyedValuesDataMock.checking(new org.jmock.Expectations()
        {{
        	atLeast(1).of(data).getItemCount();
            will(returnValue(3));         
            
            atLeast(1).of(data).getKey(0);
            will(returnValue((0)));
            
            atLeast(1).of(data).getKey(1);
            will(returnValue((1)));
            
            atLeast(1).of(data).getKey(2);
            will(returnValue((2)));
           
            atLeast(1).of(data).getValue(0);
            will(returnValue((0))); 
            
            atLeast(1).of(data).getValue(1);
            will(returnValue((0))); 
            
            atLeast(1).of(data).getValue(2);
            will(returnValue((0))); 
	        
        }});
    	
    	assertEquals("The key 0 in data should return NaN", 
    			Double.NaN, DataUtilities.getCumulativePercentages(data).getValue(0));
    	assertEquals("The key 1 in data should return NaN", 
    			Double.NaN, DataUtilities.getCumulativePercentages(data).getValue(1));
    	assertEquals("The key 3 in data should return NaN", 
    			Double.NaN, DataUtilities.getCumulativePercentages(data).getValue(1));
    }
    
    // #5
    @Test
    public void getCumulativePercentagesValidKeyedValuesWithValuesSummingZeroShouldReturnInfinity() {
    	org.jmock.Mockery KeyedValuesDataMock= new Mockery();
    	final KeyedValues data = KeyedValuesDataMock.mock(KeyedValues.class);
    	KeyedValuesDataMock.checking(new org.jmock.Expectations()
        {{
        	atLeast(1).of(data).getItemCount();
            will(returnValue(3));         
            
            atLeast(1).of(data).getKey(0);
            will(returnValue((0)));
            
            atLeast(1).of(data).getKey(1);
            will(returnValue((1)));
            
            atLeast(1).of(data).getKey(2);
            will(returnValue((2)));
           
            atLeast(1).of(data).getValue(0);
            will(returnValue((2))); 
            
            atLeast(1).of(data).getValue(1);
            will(returnValue((3))); 
            
            atLeast(1).of(data).getValue(2);
            will(returnValue((-5))); 
	        
        }});
    	
    	assertEquals("The key 0 in data should return NaN", 
    			Double.NaN, DataUtilities.getCumulativePercentages(data).getValue(0));
    	assertEquals("The key 1 in data should return NaN", 
    			Double.NaN, DataUtilities.getCumulativePercentages(data).getValue(1));
    	assertEquals("The key 3 in data should return NaN", 
    			Double.NaN, DataUtilities.getCumulativePercentages(data).getValue(1));
    }
    
    // #6
    @Test
    public void getCumulativePercentagesValidKeyedValuesWithValuesSummingNegativeShouldReturnPercentages() {
    	org.jmock.Mockery KeyedValuesDataMock= new Mockery();
    	final KeyedValues data = KeyedValuesDataMock.mock(KeyedValues.class);
    	KeyedValuesDataMock.checking(new org.jmock.Expectations()
        {{
        	atLeast(1).of(data).getItemCount();
            will(returnValue(3));         
            
            atLeast(1).of(data).getKey(0);
            will(returnValue((0)));
            
            atLeast(1).of(data).getKey(1);
            will(returnValue((1)));
            
            atLeast(1).of(data).getKey(2);
            will(returnValue((2)));
           
            atLeast(1).of(data).getValue(0);
            will(returnValue((2))); 
            
            atLeast(1).of(data).getValue(1);
            will(returnValue((3))); 
            
            atLeast(1).of(data).getValue(2);
            will(returnValue((-15))); 
	        
        }});
    	
    	assertEquals("The key 0 in data should return -0.2", 
    			-0.2, DataUtilities.getCumulativePercentages(data).getValue(0));
    	assertEquals("The key 1 in data should return -0.5", 
    			-0.5, DataUtilities.getCumulativePercentages(data).getValue(1));
    	assertEquals("The key 3 in data should return 1.0", 
    			1.0, DataUtilities.getCumulativePercentages(data).getValue(2));
    }
    
    //----------------------Assignment 3 classes----------------------------------
    @Test
    public void testEqualWithNull() {
    	double[][] arr = {{1,2},{3,4}};
    	//behaviour is undefined for two nulls (assumed false here)
    	assertFalse("Should return false", DataUtilities.equal(null, arr));
    	assertFalse("Should return false", DataUtilities.equal(arr, null));
    	assertTrue("Should return true", DataUtilities.equal(null, null));
    	
    }
    
    @Test
    public void notEqualDifferentSize() {
    	double[][] arr1 = {{1,2},{3,4}};
    	double[][] arr2 = {{1,2},{3}};
    	double[][] arr3 = {{1,2}};
    	assertFalse("Should return false", DataUtilities.equal(arr1, arr2));
    	assertFalse("Should return false", DataUtilities.equal(arr2, arr1));
    	assertFalse("Should return false", DataUtilities.equal(arr3, arr1));
    	assertFalse("Should return false", DataUtilities.equal(arr1, arr3));
    }
    
    @Test
    public void notEqualSameSize() {
    	double[][] arr1 = {{1,2},{3,4}};
    	double[][] arr2 = {{1,2},{3,6}};
    	double[][] arr3 = {{56,3},{3,6}};
    	assertFalse("Should return false", DataUtilities.equal(arr1, arr2));
    	assertFalse("Should return false", DataUtilities.equal(arr2, arr1));
    	assertFalse("Should return false", DataUtilities.equal(arr3, arr1));
    	assertFalse("Should return flase", DataUtilities.equal(arr2,  arr3));
    }
    
    @Test 
    public void equal() {
    	double[][] arr1 = {{1,2},{3,4}};
    	double[][] arr2 = {{1,2},{3,4}};
    	double[][] arr3 = {{},{}};
    	
    	assertTrue("Should return true", DataUtilities.equal(arr1, arr2));
    	assertTrue("Should return true", DataUtilities.equal(arr2, arr1));
    	assertTrue("Should return true", DataUtilities.equal(arr3, arr3));
    }
    
    @Test
    public void cloneEmpty() {
    	double[][] empty = {{}};
    	assertEquals(DataUtilities.clone(empty), empty);
    }
    
    @Test
    public void cloneNull() {
    	double[][] empty = null;
    	thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null 'source' argument.");
    	assertEquals(DataUtilities.clone(empty), empty);
    }
    
    @Test
    public void cloneHalfEmpty() {
    	double[][] halfEmpty = {{5}};
    	assertEquals(DataUtilities.clone(halfEmpty), halfEmpty);
    }
    
    @Test
    public void cloneNormalArray() {
    	double[][] arr = {{5,5},{-3,2}};
    	assertEquals(DataUtilities.clone(arr), arr);
    }
    
 // #1
    @Test
    public void calculateColumnTotalWithValidRowsNullDataShouldThrowException() {
    	int[] arr = {0};
    	thrown.expect(IllegalArgumentException.class);
        DataUtilities.calculateColumnTotal(null, 1, arr);
    }
    
    // #2
    @Test
    public void calculateColumnTotalWithValidRowsOfColumn0ShouldReturn3() {
    	int[] rows = {0,1};
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(twoByThreeValues2D).getRowCount();
            will(returnValue((2))); 
            
            oneOf(twoByThreeValues2D).getColumnCount();
            will(returnValue((3))); 
            
	        oneOf(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(twoByThreeValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(0, 2);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(twoByThreeValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 2);
	        will(returnValue((2)));
	        
        }});
        
    	assertEquals("The sum of column 0, row 1,2 should return 3",
    		        3.0, DataUtilities.calculateColumnTotal(twoByThreeValues2D, 0, rows1), .000000001d);
    }
    
    // #3
    @Test
    public void calculateColumnTotalWithValidRowsOfColumn1ShouldReturn2() { 
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(twoByThreeValues2D).getRowCount();
            will(returnValue((2))); 
            
            oneOf(twoByThreeValues2D).getColumnCount();
            will(returnValue((3))); 
            
	        oneOf(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(twoByThreeValues2D).getValue(0, 1);
	        will(returnValue((null)));
	        
	        oneOf(twoByThreeValues2D).getValue(0, 2);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(twoByThreeValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 2);
	        will(returnValue((2)));
	        
        }});
        
    	assertEquals("The sum of column 1 should return 2",
    		       2.0, DataUtilities.calculateColumnTotal(twoByThreeValues2D, 1, rows1), .000000001d);
    }
    
    // #4
    @Test
    public void calculateColumnTotalWithValidRowsOfColumn2ShouldReturn3() {
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(twoByThreeValues2D).getRowCount();
            will(returnValue((2))); 
            
            oneOf(twoByThreeValues2D).getColumnCount();
            will(returnValue((3))); 
            
	        oneOf(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(twoByThreeValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(0, 2);
	        will(returnValue((1)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(twoByThreeValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(twoByThreeValues2D).getValue(1, 2);
	        will(returnValue((2)));
	        
        }});
        
    	assertEquals("The sum of column 0 should return 3",
    		        3, DataUtilities.calculateColumnTotal(twoByThreeValues2D, 2, rows1), .000000001d);
    }

    
    @Test
    public void calculateRowTotalWithValidColsNullDataShouldThrowException() {
    	thrown.expect(IllegalArgumentException.class);
        DataUtilities.calculateRowTotal(null, 1, cols1);
    }
    
    // #2
    @Test
    public void calculateRowTotalOfRowWithValidCols0ShouldReturn2() {   
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D threeByTwoValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(threeByTwoValues2D).getRowCount();
            will(returnValue((3))); 
            
            oneOf(threeByTwoValues2D).getColumnCount();
            will(returnValue((2))); 
            
	        oneOf(threeByTwoValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(threeByTwoValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(threeByTwoValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(threeByTwoValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(threeByTwoValues2D).getValue(2, 0);
	        will(returnValue((3))); 
	        
	        oneOf(threeByTwoValues2D).getValue(2, 1);
	        will(returnValue((3)));
	        
        }});
        
    	assertEquals("The sum of row 0 should return 2",
    		        2, DataUtilities.calculateRowTotal(threeByTwoValues2D, 0, cols1), .000000001d);
    }
    
    // #3
    @Test
    public void calculateRowTotalWithValidColsOfRow1ShouldReturn0() { 
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D threeByTwoValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(threeByTwoValues2D).getRowCount();
            will(returnValue((3))); 
            
            oneOf(threeByTwoValues2D).getColumnCount();
            will(returnValue((2))); 
            
	        oneOf(threeByTwoValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(threeByTwoValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(threeByTwoValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(threeByTwoValues2D).getValue(1, 1);
	        will(returnValue((null)));
	        
	        oneOf(threeByTwoValues2D).getValue(2, 0);
	        will(returnValue((3))); 
	        
	        oneOf(threeByTwoValues2D).getValue(2, 1);
	        will(returnValue((3)));
	        
        }});
        
    	assertEquals("The sum of row 1 should return 2",
    		        2.0, DataUtilities.calculateRowTotal(threeByTwoValues2D, 1, cols1), .000000001d);
    }
    
    // #4
    @Test
    public void calculateRowTotalWithValidColsOfRow2ShouldReturn6() {
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D threeByTwoValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	oneOf(threeByTwoValues2D).getRowCount();
            will(returnValue((3))); 
            
            oneOf(threeByTwoValues2D).getColumnCount();
            will(returnValue((2))); 
            
	        oneOf(threeByTwoValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        oneOf(threeByTwoValues2D).getValue(0, 1);
	        will(returnValue((1)));
	        
	        oneOf(threeByTwoValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        oneOf(threeByTwoValues2D).getValue(1, 1);
	        will(returnValue((2)));
	        
	        oneOf(threeByTwoValues2D).getValue(2, 0);
	        will(returnValue((3))); 
	        
	        oneOf(threeByTwoValues2D).getValue(2, 1);
	        will(returnValue((3)));
	        
        }});
        
    	assertEquals("The sum of row 2 should return 6",
    		        6, DataUtilities.calculateRowTotal(threeByTwoValues2D, 2, cols1), .000000001d);
    }
    
    // MUTATION TESTS
    
    @Test
    public void testEqualWithFirstNull() {
    	double[][] arr = {{1,2},{3,4}};
    	assertFalse("Should return false", DataUtilities.equal(null, arr));
    	
    }
    
    @Test
    public void testEqualWithSecondNull() {
    	double[][] arr = {{1,2},{3,4}};
    	assertFalse("Should return false", DataUtilities.equal(arr, null));
    }
    
    @Test
    public void calculateColumnTotalWithValidRowsCol0Equals21() {
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	atLeast(1).of(twoByThreeValues2D).getRowCount();
            will(returnValue((6))); 
            
            atLeast(1).of(twoByThreeValues2D).getColumnCount();
            will(returnValue((1))); 
            
            atLeast(1).of(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(1, 0);
	        will(returnValue((2))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(2, 0);
	        will(returnValue((3))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(3, 0);
	        will(returnValue((4))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(4, 0);
	        will(returnValue((5))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(5, 0);
	        will(returnValue((6))); 
        }});
        
        int[] rows = {0,1,2,3,4,5};
    	assertEquals("The sum of column 0 should return 21",
    		        21, DataUtilities.calculateColumnTotal(twoByThreeValues2D, 0, rows), .000000001d);
    }
    
    @Test
    public void calculateRowTotalWithValidRowsCol0Equals21() {
    	org.jmock.Mockery Values2DMock= new Mockery();
    	final Values2D twoByThreeValues2D = Values2DMock.mock(Values2D.class);
        Values2DMock.checking(new org.jmock.Expectations()
        {{
        	atLeast(1).of(twoByThreeValues2D).getRowCount();
            will(returnValue((1))); 
            
            atLeast(1).of(twoByThreeValues2D).getColumnCount();
            will(returnValue((6))); 
            
            atLeast(1).of(twoByThreeValues2D).getValue(0, 0);
	        will(returnValue((1))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(0, 1);
	        will(returnValue((2))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(0, 2);
	        will(returnValue((3))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(0, 3);
	        will(returnValue((4))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(0, 4);
	        will(returnValue((5))); 
	        
	        atLeast(1).of(twoByThreeValues2D).getValue(0, 5);
	        will(returnValue((6))); 
        }});
        
        int[] cols = {0,1,2,3,4,5};
    	assertEquals("The sum of column 0 should return 21",
    		        21, DataUtilities.calculateRowTotal(twoByThreeValues2D, 0, cols), .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
