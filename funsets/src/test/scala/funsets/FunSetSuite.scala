package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("test intersect method") {
    new TestSets {
      val s = intersect(s1, s2)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")

      val intersectSame = intersect(s3, s3)
      assert(contains(intersectSame, 3), "Intersect 3")
    }
  }

  test("test diff method") {
    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1), "Diff 1")
      assert(!contains(s, 2), "Diff 2")
    }
  }

  test("test filter method") {
    new TestSets {
      def testPredicate(param: Int): Boolean = {
        param == 1
      }
      val x1 = filter(s1, testPredicate)
      val x2 = filter(s2, testPredicate)
      val x3 = filter(s3, testPredicate)

      assert(contains(x1, 1), "filter 1")
      assert(!contains(x2, 1), "filter 2")
      assert(!contains(x3, 1), "filter 3")
    }
  }

  test("test forall method") {
    new TestSets {
      def testp(param: Int): Boolean = true
      
      var k = singletonSet(0)
      for(i <- -1000 to 1000) {
        k = union(k, singletonSet(i))
      }

      assert(forall(k, testp), "forall 1")
      
      def testn(param: Int): Boolean = {
        param != 1
      }

      assert(!forall(k, testn), "forall 2")
    }
  }

  test("test exists method") {
    new TestSets {
      def testp(param: Int): Boolean = false
      
      var k = singletonSet(0)
      for(i <- -1000 to 1000) {
        k = union(k, singletonSet(i))
      }

      assert(!exists(k, testp), "exist 1")

      def testn(param: Int): Boolean = {
        param == 1
      }

      assert(exists(k, testn), "exist 2")

      def testk(param: Int): Boolean = {
        param == 100000
      }

      assert(!exists(k, testk), "exist 3")
    }
  }

  test("test map method 1") {
    new TestSets {
      def mapAddTwo(param: Int): Int = param + 2

      val k = union(union(s1, s2), s3)

      val mappedSet = map(k, mapAddTwo)

      assert(!contains(mappedSet, 1), "map 1")
      assert(!contains(mappedSet, 2), "map 2")
      assert(contains(mappedSet, 3), "map 3")
      assert(contains(mappedSet, 4), "map 4")
    }
  }

  test("test map method 2") {
    new TestSets {
      def mapAddTwo(param: Int): Int = param * 2

      val k = union(union(s1, s2), s3)

      val mappedSet = map(k, mapAddTwo)

      assert(!contains(mappedSet, 1), "map 1")
      assert(contains(mappedSet, 2), "map 2")
      assert(!contains(mappedSet, 3), "map 3")
      assert(contains(mappedSet, 4), "map 4")
      assert(contains(mappedSet, 6), "map 6")
      assert(!contains(mappedSet, 1000000), "map 1000000")
    }
  }
}
