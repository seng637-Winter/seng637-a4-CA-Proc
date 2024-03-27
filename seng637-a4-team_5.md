**SENG 637 - Dependability and Reliability of Software Systems**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#: 5     |     |
| -------------- | --- |
| Student Names: |     |
| Christopher Proc               |     |
| Sean Buchanan               |     |
| Christopher Brunet               |     |

# Introduction

The focus of this lab is on Mutation Testing and GUI Testing. Mutants will be injected into the JFreeChart classes used in Assignment 3 and will be tested against the test cases written for Assignment 3. The GUI testing will be completed on a website using the Selenium IDE. 

# Analysis of 10 Mutants of the Range class

Since our original test cases killed ~70% of mutants, we will examine 7 killed mutants, and 3 survived mutants.

### Killed (7):

1. Incremented (a++) double field "lower"

        public double getLowerBound() {
            return this.lower;
        }
    
    This mutation caused the value of lower to be incremented by 1. Our test caught this mutant using the assertEquals method as shown below:

        @Test
        public void getLowerBoundPosPosRange() {
            assertEquals("The lower bound of Range(10,20) should be 10", 10, posPosRange.getLowerBound(), .000000001d);
        }
    
    In this example, the mutation casued the value of lower to be 11, which does not equal 10.

1. Replaced double addition with division

        public double getCentralValue() {
            return this.lower / 2.0 + this.upper / 2.0;
        }   
    
    This mutation caused the addition operator to be changed to division. Our test caught this mutant using the assertEquals method as shown below:

        @Test
        public void getCentralValuePosPosEvenRange() {
            assertEquals("The median of Range(10,20) should be 15",
            15, posPosRange.getCentralValue(), .000000001d);
        }
    
    In this example, the return value was mutated to 0.5 which does not equal 15.

1. Substituted 2.0 with 1.0

        public double getCentralValue() {
            return this.lower / 2.0 + this.upper / 2.0;
        }   
    
    This mutation caused value first occuring value of 2.0 to be replaced with 1.0. Our test caught this mutant using the assertEquals method as shown below:

        @Test
        public void getCentralValuePosPosEvenRange() {
            assertEquals("The median of Range(10,20) should be 15",
            15, posPosRange.getCentralValue(), .000000001d);
        }
    
    In this example, the return value of this function is now 20 which does not equal 15. 

1. Negated double field lower

        public double getLength() {
            return this.upper - this.lower;
        } 
    
    This mutation caused the lower field to be replaced with the same value of opposite sign. Our test caught this mutant using the assertEquals method as shown below:

        @Test
        public void getLengthPosPosRange() {
            assertEquals("The length of Range(10,20) should be 10",
            10, posPosRange.getLength(), .000000001d);
        }
    
    In this example, lower was converted from 10 to -10, resulting in a return value 30 which does not equal 10. 

1. Removed conditional - replaced equality check with false

        public double constrain(double value) {
            double result = value;
            if (!contains(value)) {
                if (value > this.upper) {
                    result = this.upper;
                }
                else if (value < this.lower) {
                    result = this.lower;
                }
            }
            return result;
        }
    
    This mutation conditional "!contains(value)" to be set to false. Our test caught this mutant using the assertEquals method as shown below:

        @Test
        public void constrainEC1ShouldBeLowerPosPosRange() {
            assertEquals("The constrained value of 5 on Range(10,20) should be 10",
            10, posPosRange.constrain(5.0), .000000001d);
        }
    
    In this example, the first if statement is not entered, and result of 5 is returned which is not equal to 10.

1. Replaced boolean return with true

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            if (!(this.lower == range.lower)) {
                return false;
            }
            if (!(this.upper == range.upper)) {
                return false;
            }
            return true;
        } 
    
    This mutation caused if `(!(obj instanceof Range)) {return false;}` to be replaced with `(!(obj instanceof Range)) {return true;}`. Our test caught this mutant using the assertEquals method as shown below:

            @Test
            public void equalsNullRange() {
                Range actualRange = new Range(0.0, 10.0);
                assertEquals("Range.equals(null) should return false.", false, actualRange.equals(null));
            }
    
    In this example, the first if loop would be entered and the function would return true, which is not equal to the expected result of false.

1. Negated conditional

        public boolean isNaNRange() {
            return Double.isNaN(this.lower) && Double.isNaN(this.upper);
        } 
    
    This mutation `Double.isNaN(this.lower)` to be replaced with `!Double.isNaN(this.lower)`. Our test caught this mutant using the assertEquals method as shown below:

        @Test
        public void isNaNRangeUpperNaN() {
            Range range1 = new Range(0.0, Double.NaN);
            assertEquals("Range[0.0,NaN] should return isNanRange() == False", false, range1.isNaNRange());
        }
    
    In this example, the return value is true when the expected value should be false.

### Survived (3):

1. Removed conditional - replaced equality check with false

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            if (!(this.lower == range.lower)) {
                return false;
            }
            if (!(this.upper == range.upper)) {
                return false;
            }
            return true;
        } 
    
    This mutation replaced !(this.lower == range.lower) with false. This mutation survived the test in the case where the upper values are equal or obj is not a valid range object.

        @Test
        public void equalsNullRange() {
            Range actualRange = new Range(0.0, 10.0);
            assertEquals("Range.equals(null) should return false.", false, actualRange.equals(null));
        }
    
    In this example, the parameter is not a valid range object and this mutation survived. 

1. Equal to less or equal

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            if (!(this.lower == range.lower)) {
                return false;
            }
            if (!(this.upper == range.upper)) {
                return false;
            }
            return true;
        } 
    
    This mutation !(this.lower == range.lower) with !(this.lower <= range.lower). This mutation survived the test in the case where the upper values are equal or obj is not a valid range object.

        @Test
        public void equalsNullRange() {
            Range actualRange = new Range(0.0, 10.0);
            assertEquals("Range.equals(null) should return false.", false, actualRange.equals(null));
        }
    
    In this example, the parameter is not a valid range object and this mutation survived. 

1. Decremented (a--) double field lower

        public boolean isNaNRange() {
            return Double.isNaN(this.lower) && Double.isNaN(this.upper);
        }
    
    This mutation casued the value of lower to be decremented by 1. This mutation survived the test as it did not affect the output of the function.

        @Test
        public void isNaNRangeUpperNaN() {
            Range range1 = new Range(0.0, Double.NaN);
            assertEquals("Range[0.0,NaN] should return isNanRange() == False", false, range1.isNaNRange());
        }
    
    In this example, the return value of the function will be false regardless of the value of lower. 

# Report all the statistics and the mutation score for each test class

Initial Mutation Score of Range Tests:

Initial Mutation Score of DataUtilities Tests:

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

By introducing small alterations to the source code, mutation testing evaluates the effectiveness of existing test cases in detecting these changes. This process helps uncover weaknesses in the test suite, ensuring that the tests are thorough and capable of catching potential bugs.

One advantage of mutation testing is its ability to identify redundant or ineffective test cases, leading to more efficient testing strategies. Additionally, it promotes a deeper understanding of the codebase and encourages developers to write more resilient tests.

A disadvantage of mutation testing is that it can be computationally intensive and time-consuming, especially for large codebases, which may deter its widespread adoption.

# Explain your SELENUIM test case design process

Test cases were written to assess unique functionalities of the SUT (Shop Smart Canada Website). Some of the core functionalities examined were:
- User Profile Functionality
    - Log In
    - Edit Account Details
    - Sign Out
- Shopping Functionality
    - Adding products to cart
    - Editing cart
    - Proceding to checkout
- Product Search Functionality

For each of these functionalities, various tests were designed to ensure the GUI responded to events appropriately. 

In designing each test case, the team performed each of the functionalities on the SUT to gain an understanding of expected behaviour. Once this exploration was complete, functionalities were split into numerous tests which allowed for better error tracking and readability of test cases (For example, the shopping functionality, which consists of adding a product to a cart, updating the quantity of items in the cart, then proceding to checkout was split into 3 tests).

# Explain the use of assertions and checkpoints

Assertions were used in each test case to ensure the expected result occured for each test. Various types of assertions were used. For example, when updating the quantity of items in the cart, assert text was used to ensure the change had been reflected in the checkout price. A different example would be for when a user signs in, assert title was used to ensure the user was directed to the appropriate next page.

# how did you test each functionaity with different test data

Each functionality was tested with various test data to ensure a certain degree of robustness when possible. Examples of this include creating tests to asses the result of both valid login credentials and invalid credentials. Another example for the search function was to test a valid product which returns many results as well as incoherent text which should be expected to return 0 results.

# How the team work/effort was divided and managed

Part 1: 
This section was completed synchronously by the entire group. The team ran the Pit Mutation Tests, analyzed the results based on the test cases written in assignment 3, and analyzed 10 different mutants killed or survived by Range tests. Finally, the group implemented updates to increase the mutation scores of each test suite.

Part 2:
Each member was responsible for designing GUI test cases for 1 one the core website functionalities (minimum 2 test cases per functionality). After the test cases were for each functionality were designed. Each member implemented the test cases designed by another member in Selenium. This allowed for team members to double check the developed test cases with a second pair of eyes. 

All members contributed equally to the writing of the lab report. 

# Difficulties encountered, challenges overcome, and lessons learned
One of the challenges encountered during the GUI testing was due to the asynchronous nature of websites, where an assertion would fail before the new content of the website could load. This challenge was overcome by using the 'wait' functionality to ensure proper order of operations for each test.

# Comments/feedback on the assignment itself
The GUI testing portion of this lab provided a great opportunity to write tests for common user interfaces, and learn how tools like Selenium may be used to automate tests for a large, professional website with many functionalities.