package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jmock.Mockery;
import org.junit.rules.ExpectedException;

import org.junit.*;

public class RangeTest {
    private Range posPosRange;
    private Range zeroPosRange;
    private Range negZeroRange;
    private Range negNegRange;
    private Range negPosRange;
    private Range zeroLengthRange;
    private Range infInfRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	posPosRange = new Range(10, 20);
    	zeroPosRange = new Range(0,20);
    	negZeroRange = new Range(-20,0);
    	negNegRange = new Range(-20,-10);
    	negPosRange = new Range(-20,20);
    	zeroLengthRange = new Range(0,0);
    	infInfRange = new Range(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    // Range() TESTS
    // #1
    @Test
    public void rangeConstructorLowerGreaterThanUpperThrowsException() {
    	thrown.expect(IllegalArgumentException.class);
        Range expectedRange = new Range(5.0, 2.0);
    }
    
    // getLowerBound() TESTS
    // #1
    @Test
    public void getLowerBoundPosPosRange() {
        assertEquals("The lower bound of Range(10,20) should be 10",
        10, posPosRange.getLowerBound(), .000000001d);
    }
    
    // #2
    @Test
    public void getLowerBoundZeroPosRange() {
        assertEquals("The lower bound of Range(0,20) should be 0",
        0, zeroPosRange.getLowerBound(), .000000001d);
    }
    
    // #3
    @Test
    public void getLowerBoundNegZeroRange() {
        assertEquals("The lower bound of Range(-20,0) should be -20",
        -20, negZeroRange.getLowerBound(), .000000001d);
    }
    
    // #4
    @Test
    public void getLowerBoundNegNegRange() {
       assertEquals("The lower bound of Range(-20,-10) should be -20",
       -20, negNegRange.getLowerBound(), .000000001d);
    }
    
    // #5
    @Test
    public void getLowerBoundNegPosRange() {
        assertEquals("The lower bound of Range(-20,20) should be -20",
        -20, negPosRange.getLowerBound(), .000000001d);
    }
    
    // #6
    @Test
    public void getLowerBoundZeroLengthRange() {
        assertEquals("The lower bound of Range(0,0) should be 0",
        0, zeroLengthRange.getLowerBound(), .000000001d);
    }
    
    // #7
    @Test
    public void getLowerBoundInfInfRange() {
        assertEquals("The lower bound of Range(-inf,+inf) should be -inf",
        Double.NEGATIVE_INFINITY, infInfRange.getLowerBound(), .000000001d);
    }
    
    // getUpperBound() TESTS
    
    // #1
    @Test
    public void getUpperBoundPosPosRange() {
        assertEquals("The upper bound of Range(10,20) should be 20",
        20, posPosRange.getUpperBound(), .000000001d);
    }
    
    // #2
    @Test
    public void getUpperBoundZeroPosRange() {
        assertEquals("The upper bound of Range(0,20) should be 20",
        20, zeroPosRange.getUpperBound(), .000000001d);
    }
    
    // #3
    @Test
    public void getUpperBoundNegZeroRange() {
        assertEquals("The upper bound of Range(-20,0) should be 0",
        0, negZeroRange.getUpperBound(), .000000001d);
    }
    
    // #4
    @Test
    public void getUpperBoundNegNegRange() {
       assertEquals("The upper bound of Range(-20,-10) should be -10",
       -10, negNegRange.getUpperBound(), .000000001d);
    }
    
    // #5
    @Test
    public void getUpperBoundNegPosRange() {
        assertEquals("The upper bound of Range(-20,20) should be 20",
        20, negPosRange.getUpperBound(), .000000001d);
    }
    
    // #6 
    @Test
    public void getUpperBoundZeroLengthRange() {
        assertEquals("The upper bound of Range(0,0) should be 0",
        0, zeroLengthRange.getUpperBound(), .000000001d);
    }
    
    // #7
    @Test
    public void getUpperBoundInfInfRange() {
        assertEquals("The upper bound of Range(-inf,+inf) should be +inf",
        Double.POSITIVE_INFINITY, infInfRange.getUpperBound(), .000000001d);
    }
    
    // getLength() TESTS
 
    // #1
    @Test
    public void getLengthPosPosRange() {
        assertEquals("The length of Range(10,20) should be 10",
        10, posPosRange.getLength(), .000000001d);
    }
    
    // #2
    @Test
    public void getLengthZeroPosRange() {
        assertEquals("The upper bound of Range(0,20) should be 20",
        20, zeroPosRange.getLength(), .000000001d);
    }
    
    // #3
    @Test
    public void getLengthNegZeroRange() {
        assertEquals("The length of Range(-20,0) should be 20",
        20, negZeroRange.getLength(), .000000001d);
    }
    
    // #4
    @Test
    public void getLengthNegNegRange() {
       assertEquals("The length of Range(-20,-10) should be 10",
       10, negNegRange.getLength(), .000000001d);
    }
    
    // #5
    @Test
    public void getLengthNegPosRange() {
        assertEquals("The length of Range(-20,20) should be 40",
        40, negPosRange.getLength(), .000000001d);
    }
    
    // #6
    @Test
    public void getLengthZeroLengthRange() {
        assertEquals("The length of Range(0,0) should be 0",
        0, zeroLengthRange.getLength(), .000000001d);
    }
    
    // #7
    @Test
    public void getLengthInfInfRange() {
        assertEquals("The length of Range(-inf,+inf) should be +inf",
        Double.POSITIVE_INFINITY, infInfRange.getLength(), .000000001d);
    }
    
    // getCentralValue() TESTS
    
    // #1
    @Test
    public void getCentralValuePosPosEvenRange() {
        assertEquals("The median of Range(10,20) should be 15",
        15, posPosRange.getCentralValue(), .000000001d);
    }
    
    // #2
    @Test
    public void getCentralValueZeroPosRange() {
        assertEquals("The median of Range(0,20) should be 10",
        10, zeroPosRange.getCentralValue(), .000000001d);
    }
    
    // #3
    @Test
    public void getCentralValueNegZeroRange() {
        assertEquals("The median of Range(-20,0) should be -10",
        -10, negZeroRange.getCentralValue(), .000000001d);
    }
    
    // #4
    @Test
    public void getCentralValueNegNegRange() {
       assertEquals("The median of Range(-20,-10) should be -15",
       -15, negNegRange.getCentralValue(), .000000001d);
    }
    
    // #5
    @Test
    public void getCentralValueNegPosRange() {
        assertEquals("The median of Range(-20,20) should be 0",
        0, negPosRange.getCentralValue(), .000000001d);
    }
    
    // #6
    @Test
    public void getCentralValueZeroLengthRange() {
        assertEquals("The median of Range(0,0) should be 0",
        0, zeroLengthRange.getCentralValue(), .000000001d);
    }
    
    // #7
    @Test
    public void getCentralValueInfInfRange() {
        assertEquals("The median of Range(-inf,+inf) should be NaN",
        Double.NaN, infInfRange.getCentralValue(), .000000001d);
    }
    
    // #8
    @Test
    public void getCentralValuePosPosOddRange() {
    	assertEquals("The median of Range(10,21) should be 15.5",
        15.5, new Range(10, 21).getCentralValue(), .000000001d);
    }
    
    // #9
    @Test
    public void getCentralValueNegNegOddRange() {
    	assertEquals("The median of Range(-21,-10) should be -15.5",
        -15.5, new Range(-21, -10).getCentralValue(), .000000001d);
    }
    
    // constrain(double value) TESTS
    
    // #1
    @Test
    public void constrainEC1ShouldBeLowerPosPosRange() {
        assertEquals("The constrained value of 5 on Range(10,20) should be 10",
        10, posPosRange.constrain(5.0), .000000001d);
    }
    
    // #2
    @Test
    public void constrainEC2ShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 15 on Range(10,20) should be 15",
        15, posPosRange.constrain(15.0), .000000001d);
    }
    
    // #3
    @Test
    public void constrainEC3ShouldBeUpperPosPosRange() {
        assertEquals("The constrained value of 25 on Range(10,20) should be 20",
        20, posPosRange.constrain(25.0), .000000001d);
    }
    
    // #4
    @Test
    public void constrainLBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 10 on Range(10,20) should be 10",
        10, posPosRange.constrain(10.0), .000000001d);
    }
    
    // #5
    @Test
    public void constrainALBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 10.1 on Range(10,20) should be 10.1",
        10.1, posPosRange.constrain(10.1), .000000001d);
    }
    
    // #6
    @Test
    public void constrainBUBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 19.9 on Range(10,20) should be 19.9",
        19.9, posPosRange.constrain(19.9), .000000001d);
    }
    
    // #7
    @Test
    public void constrainUBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 20 on Range(10,20) should be 20",
        20, posPosRange.constrain(20.0), .000000001d);
    }
    
    // #8
    @Test
    public void constrainBLBShouldBeLowerPosPosRange() {
        assertEquals("The constrained value of 9.9 on Range(10,20) should be 10",
        10, posPosRange.constrain(9.9), .000000001d);
    }
    
    // #9
    @Test
    public void constrainAUBShouldBeUpperPosPosRange() {
        assertEquals("The constrained value of 20.1 on Range(10,20) should be 20",
        20, posPosRange.constrain(20.1), .000000001d);
    }
    
    // #10
    @Test
    public void constrainEC1ShouldBeLowerNegNegRange() {
        assertEquals("The constrained value of -25 on Range(-20,-10) should be -20",
        -20, negNegRange.constrain(-25.0), .000000001d);
    }
    
    // #11
    @Test
    public void constrainEC2ShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -15 on Range(-20,-10) should be -15",
        -15, negNegRange.constrain(-15.0), .000000001d);
    }
    
    // #12
    @Test
    public void constrainEC3ShouldBeUpperNegNegRange() {
        assertEquals("The constrained value of -5 on Range(-20,-10) should be -10",
        -10, negNegRange.constrain(-5), .000000001d);
    }
    
    // #13
    @Test
    public void constrainLBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -20 on Range(-20,-10) should be -20",
        -20, negNegRange.constrain(-20.0), .000000001d);
    }
    
    // #14
    @Test
    public void constrainALBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -19.9 on Range(-20,-10) should be -19.9",
        -19.9, negNegRange.constrain(-19.9), .000000001d);
    }
    
    // #15
    @Test
    public void constrainBUBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -10.1 on Range(-20,-10) should be -10.1",
        -10.1, negNegRange.constrain(-10.1), .000000001d);
    }
    
    // #16
    @Test
    public void constrainUBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of 20 on Range(-20,-10) should be -10",
        -10, negNegRange.constrain(-10.0), .000000001d);
    }
    
    // #17
    @Test
    public void constrainBLBShouldBeLowerNegNegRange() {
        assertEquals("The constrained value of -20.1 on Range(-20,-10) should be -20",
        -20, negNegRange.constrain(-20.1), .000000001d);
    }
    
    // #18
    @Test
    public void constrainAUBShouldBeUpperNegNegRange() {
        assertEquals("The constrained value of -9.9 on Range(-20,-10) should be -10",
        -10, negNegRange.constrain(-9.9), .000000001d);
    }
    
    // #19
    @Test
    public void constrainEC2ShouldBeValueNegPosRange() {
        assertEquals("The constrained value of 0 on Range(-20,20) should be 0",
        0, negPosRange.constrain(0), .000000001d);
    }
    
    // CONSTRAIN SPECIAL CASES
    
    // #20
    @Test
    public void constrainPositiveInfinityShouldBeUpper() {
        assertEquals("The constrained value of +inf on Range(-20,20)) should be 20",
        20, negPosRange.constrain(Double.POSITIVE_INFINITY), .000000001d);
    }
    
    // #21
    @Test
    public void constrainNegativeInfinityShouldBeLower() {
        assertEquals("The constrained value of -inf on Range(-20,20) should be -20",
        -20, negPosRange.constrain(Double.NEGATIVE_INFINITY), .000000001d);
    }
    
    // #22
    @Test
    public void constrainEC1ZeroLengthRangeShouldBeUpperAndLower() {
        assertEquals("The constrained value of 5 on Range(0,0) should be 0",
        0, zeroLengthRange.constrain(5), .000000001d);
    }
    
    // #22
    @Test
    public void constrainEC2ZeroLengthRangeShouldBeUpperAndLower() {
        assertEquals("The constrained value of -5 on Range(0,0) should be 0",
        0, zeroLengthRange.constrain(-5), .000000001d);
    }
    
    // #22
    @Test
    public void constrainEC3ZeroLengthRangeShouldBeUpperAndLower() {
        assertEquals("The constrained value of 0 on Range(0,0) should be 0",
        0, zeroLengthRange.constrain(0), .000000001d);
    }
   
    // toString() TESTS
    @Test
    public void toStringReturnsCorrectString() {
    	assertEquals("The toString method should return 'Range[<lower>,<upper>]",
    			"Range[10.0,20.0]", posPosRange.toString());
    }
   
    // hashCode() TESTS
    // #1
    @Test
    public void hashCodeEqualWhenIdentical() {
    	Range testRange = new Range(0,20);
    	assertEquals("The hashCode should be the same when calculated twice for the same object", testRange.hashCode(), testRange.hashCode());
    }
    
    // #2
    @Test
    public void hashCodeNotEqualWhenDifferent() {
    	Range testRange = new Range(0,20);
    	Range testRange2 = new Range(0,21);
    	assertNotEquals("The hashCode should be different when called for two separate objects", testRange.hashCode(), testRange2.hashCode());
    }
    
    // intersects(double, double) TESTS
    //#1
    @Test
    public void intersectsInsideLowerRange() {
    	assertEquals("The range [0,20] should intersect [-1.0, 5]", true, zeroPosRange.intersects(-1.0, 5.0));
    }
    
    //#2
    @Test
    public void intersectsInsideUpperRange() {
    	assertEquals("The range [0,20] should intersect [10, 40]", true, zeroPosRange.intersects(10.0, 40.0));
    }
    //#3
    @Test
    public void intersectsOutsideLowerRange() {
    	assertEquals("The range [0,20] should not intersect [-5.0, -2.0]", false, zeroPosRange.intersects(-5.0, -2.0));
    }
    
    //#4
    @Test
    public void intersectsOutsideUpperRange() {
    	assertEquals("The range [0,20] should not intersect [25, 40]", false, zeroPosRange.intersects(25.0, 40.0));
    }
    
    // intersects(Range) TESTS
    //#1
    @Test
    public void intersectsOverlappingRange() {
    	assertEquals("The range [0,20] should intersect [10,21]", true, zeroPosRange.intersects(posPosRange));
    }
    
    // combine(Range,Range) TESTS
    //#1
    @Test
    public void combineFirstRangeNull() {
    	assertEquals("Combine(null, Range x) should return Range x", posPosRange, Range.combine(null, posPosRange));
    }
    
    //#2
    @Test
    public void combineSecondRangeNull() {
    	assertEquals("Combine(Range x, null) should return Range x", posPosRange, Range.combine(posPosRange,  null));
    }
    
    //#3
    @Test
    public void combineValidRanges() {
    	Range range1 = new Range(0.0, 5.0);
    	Range range2 = new Range(2.5, 10.0);
    	Range range3 = new Range(0.0, 10.0);
    	assertEquals("Combine(Range[0.0,5.0], Range[2.5,10.0]) should return Range[0.0, 10.0]", range3, Range.combine(range1, range2));
    }
    
    // combineIgnoringNaN(Range,Range) tests
    // #1
    @Test
    public void combineIgnoringNaNFirstRangeNull() {
    	assertEquals("combineIgnoringNaN(null, Range X) should return Range x", posPosRange, Range.combineIgnoringNaN(null, posPosRange));
    }
    
    // #2
    @Test
    public void combineIgnoringNaNSecondRangeNull() {
    	assertEquals("combineIgnoringNaN(Range X, null) should return Range x", posPosRange, Range.combineIgnoringNaN(posPosRange, null));
    }
    // #3
    @Test
    public void combineIgnoringNaNFirstRangeNaNLower() {
    	
    	Range nanRange = new Range(Double.NaN, 5.0);
    	Range combinedRange = new Range(5.0, 20.0);
    	assertEquals("combineIgnoringNan(Range[NaN, 5.0], Range[10.0,20.0]) should return Range[5.0, 20.0]", 
    			combinedRange, Range.combineIgnoringNaN(nanRange, posPosRange));
    }
    
    // #4
    @Test
    public void combineIgnoringNaNSecondRangeNaNUpper() {
    
    	Range nanUpper = new Range(5.0, Double.NaN);
    	Range combinedRange = new Range(5.0, 20.0);
    	assertEquals("combineIgnoringNan(Range[5.0, NaN], Range[10.0,21.0]) should return Range[5.0, 20.0]", 
    			combinedRange, Range.combineIgnoringNaN(posPosRange, nanUpper));
    }
    
    //#5
    @Test
    public void combineIgnoringNaNAllValuesNaN() {
    	Range nanLower = new Range(Double.NaN, Double.NaN);
    	Range nanUpper = new Range(Double.NaN, Double.NaN);
    	
    	assertEquals("combineIgnoringNan(Range[NaN, NaN], Range[NaN, NaN]) should return null", null, Range.combineIgnoringNaN(nanLower, nanUpper));
    }
    
    //#6
    @Test
    public void combineIgnoringNaNNanRangeWithNullRange() {
    	Range nanLower = new Range(Double.NaN, Double.NaN);
    	
    	assertEquals("combineIgnorningNan(Range[NaN, NaN], null) returns null", null, Range.combineIgnoringNaN(nanLower, null));
    }
    
    // expandToInclude(Range, double) TESTS
    // #1
    @Test
    public void expandToIncludeNewValueAbove() {
    	Range expectedRange = new Range(10.0, 25.0);
    	assertEquals("expandToInclude(Range[10,21], 25) should return Range[10,25]", expectedRange, Range.expandToInclude(posPosRange, 25.0));
    }
    
    // #2
    @Test
    public void expandToIncludeNewValueBelow() {
    	Range expectedRange = new Range(0.0, 20.0);
    	assertEquals("expandToInclude(Range[10,20], 0) should return Range[0,20]", expectedRange, Range.expandToInclude(posPosRange, 0.0));
    }
    
    //#3
    @Test
    public void expandToIncludeContainedValue() {
    	assertEquals("expandToInclude(Range[10,21], 15) should return Range[10,21]", posPosRange, Range.expandToInclude(posPosRange, 15.0));
    }
    
    // #4
    @Test
    public void expandToIncludeWithNullRange() {
    	Range expectedRange = new Range(10.0, 10.0);
    	assertEquals("expandToInclude(null, 10.0) should return Range[10.0, 10.0]", expectedRange, Range.expandToInclude(null,  10.0));
    }
    
    // expand(Range, double, double) TESTS
    // #1
    @Test
    public void expandByDouble() {
    	Range actualRange = new Range(0.0, 10.0);
    	Range expectedRange = new Range(-10.0, 10.0);
    	assertEquals("expand(Range[0,10],1,0) should return Range[-10,10]",expectedRange, Range.expand(actualRange, 1, 0));
    }
    
    // #2
    @Test
    public void expandByNegativeMargin() {
    	Range actualRange = new Range(0.0, 10.0);
    	Range expectedRange = new Range(10.0, 20.0);
    	assertEquals("expand(Range[0,10],-2,0) should return Range[10,20]",expectedRange, Range.expand(actualRange, -2, 0));
    }
    
    // shift(Range, double) TESTS
    // #1
    @Test
    public void shiftUpwardsAcrossZero() {
    	Range actualRange = new Range(-5.0, -3.0);
    	Range expectedRange = new Range(0.0, 0.0);
    	assertEquals("shift(Range[-5,-3], 6) should return Range[0.0,0.0]", expectedRange, Range.shift(actualRange, 6));
    }
    
    // shift(Range, double, bool) TESTS
    // #1
    @Test
    public void shiftDownwardsAcrossZeroAllowZeroCrossing() {
    	Range actualRange = new Range(1.0, 2.0);
    	Range expectedRange = new Range(-1.0, 0.0);
    	assertEquals("shift(range[1,2],-2, true) should return Range[-1,0]", expectedRange, Range.shift(actualRange, -2, true));
    }
    
    // #2
    @Test
    public void shiftDownwardsAcrossZeroNoZeroCrossing() {
    	Range actualRange = new Range(1.0, 2.0);
    	Range expectedRange = new Range(0.0, 0.0);
    	assertEquals("shift(range[1,2],-2, false) should return Range[0,0]", expectedRange, Range.shift(actualRange, -2, false));
    }
    
    // #3
    @Test
    public void shiftUpwardsFromZeroNoZeroCrossing() {
    	Range actualRange = new Range(0.0, 10.0);
    	Range expectedRange = new Range(5.0, 15.0);
    	assertEquals("shift(range[0,10],5, false) should return Range[5,15]", expectedRange, Range.shift(actualRange, 5, false));
    }
    
    // scale(Range, double) TESTS
    // #1
    @Test
    public void scaleByPositiveFactorOf2() {
    	Range actualRange = new Range(0.0, 10.0);
    	Range expectedRange = new Range(0.0, 20.0);
    	assertEquals("scale(Range[0,10], 2) should return Range[0,20]", expectedRange, Range.scale(actualRange, 2));
    }
    
    // #2
    @Test
    public void scaleByNegativeFactor() {
    	Range actualRange = new Range(0.0, 10.0);
    	thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative 'factor' argument.");
        Range.scale(actualRange, -2);
    }
    
    // equals(Object) TESTS
    // #1
    @Test
    public void equalsNullRange() {
    	Range actualRange = new Range(0.0, 10.0);
    	assertEquals("Range.equals(null) should return false.", false, actualRange.equals(null));
    }
    
    //#2
    @Test
    public void equalsRangeWithSameLowerDifferentUpper() {
    	Range range1 = new Range(0.0, 10.0);
    	Range range2 = new Range(0.0, 12.0);
    	assertEquals("Range[0,10].equals(Range[0,12) should return false", false, range1.equals(range2));
    }
    
    // isNanRange() TESTS
    //#1
    @Test
    public void isNaNRangeUpperNaN() {
    	Range range1 = new Range(0.0, Double.NaN);
    	assertEquals("Range[0.0,NaN] should return isNanRange() == False", false, range1.isNaNRange());
    }
    
    //#2
    @Test
    public void isNaNRangeLowerNaN() {
    	Range range1 = new Range(Double.NaN, 0.0);
    	assertEquals("Range[NaN, 0.0] should return isNanRange() == False", false, range1.isNaNRange());
    }
    
  	//#3
    @Test
    public void isNaNRangeBothNaN() {
    	Range range1 = new Range(Double.NaN, Double.NaN);
    	assertEquals("Range[NaN, NaN] should return isNanRange() == True", true, range1.isNaNRange());
    }
    
    //#4
    @Test
    public void isNaNRangeNoNaN() {
    	Range range1 = new Range(0.0, 0.0);
    	assertEquals("Range[0.0, 0.0] should return isNanRange() == False", false, range1.isNaNRange());
    }
    
    @After
    public void tearDown() throws Exception {
    	posPosRange = null;
    	zeroPosRange = null;
    	negZeroRange = null;
    	negNegRange = null;
    	negPosRange = null;
    	zeroLengthRange = null;
    	infInfRange = null;
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
