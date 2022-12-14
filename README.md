# JavaModuleDemo
Assignments for Java module
===================================================================================================================
## First task
- **/src/main/java/org/example/assignment1/Solution.java (uses recursion, not optimal when very long Strings need to be searched through)
- **/src/main/java/org/example/assignment1/Solution2.java

**Notes:**
- For this part of the assignment both the specified word that is being searched for ("BALLOON" in the given instructions) and the Strings that are being searched through ("BAONXXOLL", "BAOOLLNNOLOLGBAX" and so on) are hardcoded. I have also added another search with my own word and Strings to search through.

## 1. Exceptions
- Custom exceptions (**/src/main/java/org/example/assignment2/exceptions):
  - EmptyFileException.java
  - IncorrectFilePathException.java
  - ReaderNotInitializedException.java
  - StringFormatException.java
  - StringLengthOutOfBoundsException.java
- Class with methods for reading from a file and writing in a file (**/src/main/java/org/example/assignment2/readers/ReadWriteFromFile.java)
- Class with implementation of solution method and method that reads input strings from file and writes solutions in result file (**/src/main/java/org/example/assignment2/FileIOSolution.java)

**Notes:**
- Custom exceptions used in class **ReadWriteFromFile.java** and class **FileIOSolution.java** (method **validateInputString** used for validating strings read from file).

## 2. Testing
- Test class for ReadWriteFromFile.java  (**\src\test\java\org\example\assignment2\readers\ReadWriteFromFileTest.java)
- Test class for RefactoredSolutionForTesting.java  (****\src\test\java\org\example\assignment3\RefactoredSolutionForTestingTest.java)

**Notes:**
- Refactored **ReadWriteFromFile.java** and **FileIOSolution.java** (created classes **RefactoredSolutionForTesting.java** and **Result.java** in package **\src\main\java\org\example\assignment3**).
