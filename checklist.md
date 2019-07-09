# OS PR Checklist
## Intent
For each test that you add, ask:
1. Does this test *verify* that the method does *what the developers want it to do*?
1. Does the test-case look like a real-life use of the method?
1. Is the test clear and readable? (See **Style**)

You can think of your test class like a list of things that the tested class should do. If you look at a test-case and think *"wow, I wouldn't expect that method with those inputs to give that output"* (or even *"wow, I wouldn't expect anyone to call that method with inputs like that"*), then you might need to reconsider your tests (or maybe report a bug).

## Style
### General
1. Where possible, try to match the format and style of the existing tests
1. Make sure there are no redundant `import`s, and no redundant `@Rule`s
1. Make sure that test methods don't have unnecessary `throws`
1. [Don't access class fields directly](https://www.tutorialspoint.com/java/java_encapsulation.htm) (even if they are public) unless you absolutely have to. Use a `get`/`set` method instead
1. Make sure you haven't left any ugly test-gen method names in
1. Try to give each test method a name that makes sense (and matches the style of the project's existing tests)
1. Use comments (only) when they are needed to clarify the test-case
1. Don't include tests for code that isn't in the tested class (e.g. default constructor)
1. Keep lines <= 80 characters
1. Test methods should be in the same order as the tested methods (eg. 1st Test method is for the 1st Method)

### Code Style
1. Use the same indentation (number of spaces or tabs) as the project
1. Use the same curly bracket style (end of line or on new line) as the project
1. Try to avoid the use of wildcard imports
1. If the line is longer than 80 characters then break the method calls into new lines
   ```java
   //Don't do this:
   Classname c = Powermock.mock(classname.class).when("123456789123456789456").thenReturn("111111111111111111111111111111");

   //Do this break before the '.methodname' or '(':
   Classname c = 
   	Powermock.mock(classname.class)
	       .when("123456789123456789456")
	       .thenReturn(
                      "1111111111111111111111111111111111111"
		);
   ```

### Input Values
1. Simple numerical input values should usually be inlined into the assertion
1. `byte`s should not be explicitly cast unless they are `<-128` or `>127`
1. Try to avoid long decimals - if a number is > 10<sup>10</sup>, does it need 8 decimal places?
1. If a simple input (short array, simple object) is used only once, it can usually be inlined into the assertion
1. If the same value is used many times in many tests, it might be clearer to make it a global variable
1. If the same value is used many times in a single test method, it might be clearer to make it a local variable
1. Try to give the input/output variables sensible names (e.g. `distance` or `success` instead of `retval`)
1. Try to use the simplest constructors (with the fewest parameters) that are adequate for the test-case

### Assertions
1. Use `assertTrue` and `assertFalse`, not `assertEquals(true, ...`
1. Make sure that the `assert` parameters are the right way round (expected first)
1. Import the individual methods in `Assert` (or `Assert.*`) if the other tests in the project do
1. Put `assertNull` and `assertNotNull` at the top of test method.
1. Put a blank newline between different test-cases in one test method, unless each test-case is one line
   * If each test-case is one line, it might make sense to put a newline between different return values:
     ```java
     assertTrue(isPrime(2))
     assertTrue(isPrime(5))
     
     assertFalse(isPrime(6))
     assertFalse(isPrime(8))
     ```
1. Put each assertion directly after the statement(s) which determines its truth:
   ```java
   //Don't do this:
   int a = calculateSomething(10);
   int b = calculateSomething(20);
   int c = calculateSomething(-5);

   assertEquals(2, a);
   assertEquals(3, b);
   assertEquals(10, c);

   //Do this instead:
   int a = calculateSomething(10);
   assertEquals(2, a);

   int b = calculateSomething(20);
   assertEquals(3, b);

   int c = calculateSomething(-5);
   assertEquals(10, c);

1. With reference to the above example, if the line is <= 80 characters do this instead:
   ```java
   assertEquals(2, calculateSomething(10));
   assertEquals(3, calculateSomething(20));
   assertEquals(10, calculateSomething(-5));
   ```

1. If the line is <= 80 characters and you have an object input
   ```java
   //Don't do this:
   String foo = "bar";
   byte bytes = 2;

   assertEquals("a", compare(foo));
   assertEquals(4, compare(bytes));

   //Do this instead:
   assertEquals("a", compare("bar"));
   assertEquals(4, compare((byte) 2));
   ```

1. If the line is <= 80 characters and you have an array input
   ```java
   //Don't do this:
   final int[] A = {};
   final int[] B = {1,2,3};

   assertEquals(0L, compare(A, B));

   //Do this instead:
   assertEquals(0L, compare(new int[0], new int[]{1, 2, 3}));
   ```

1. If the line is > 80 characters and you have an array input
   ```java
   //Don't do this:
   Assert.assertArrayEquals(new byte[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 ,3}, CommonUtils.getBytes());

   //Do this instead:
   byte[] bytes = new byte[]{
        0, 1, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0, 1,
        1, 2, 3, 1, 0, 2, 3, 0
   };

   Assert.assertArrayEquals(bytes, CommonUtils.getBytes());
   ```

1. If the line is > 80 characters then break the assertions into new lines
   ```java
   //if you are able to break the assert into new lines then break after the expected ',':
   assertEquals("4561234897846313", 
		compare("12135415463", "123154689478979")
   );

   //if not break after the '(':
   assertEquals(
		"4561231231165465414897846313", 
		compare("12135415463", "123154689478979")
   );

   //else assign the values to a new variable:
   int ex = "4561231231165465414897846313";
   int val1 = "12135415463";
   int val2 = "123154689478979";

   assertEquals(ex, compare(val1, val2));
   ```

### Exceptions
1. Put `thrown.expect` statements directly before the statement which throws the exception
1. Don't use any assertions after `thrown.expect`

### Floating Points
1. The letter `d` or `f` after floating point numbers should be the same case everywhere it appears in your class
1. Try to use `delta` consistently between test-cases
1. If the source code happens to include (in comments) some specification of how precise the method is meant to be, use that as your `delta`

If you can, try to choose input values so that the output can be represented exactly.  
For example, let's say there is a method:
```java
float divide(float a, float b){
	return a / b;
}
```
If I choose `a = 1` and `b = 3`, then I'll get `1/3`, which can't be represented exactly so I'll need some `delta > 0`.  
But if I choose `a = 4, b = 2`, then the result is `2`, which is stored exactly, and my `delta` can be 0.  
Note that this test isn't any less *useful* because nobody is testing Java's ability to divide numbers with and without decimal points.

Of course, most of the time it is harder to choose input values like this.
