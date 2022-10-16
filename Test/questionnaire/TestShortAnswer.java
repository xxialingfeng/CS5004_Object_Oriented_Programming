package questionnaire;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test class for Short Answer question.
 */
public class TestShortAnswer {
  ShortAnswer short1;
  ShortAnswer short2;
  private static final String shortText = "Are you ok with the rest of the food?"
      + "What the biggest day in you life, and why you think it that way "
      + "In what way do you think you are eligible for a fee waiver "
      + "Which of the course do you think is most helpful for you"
      + "If the world is going to an end, what would you do "
      + "Do you think it is better for students attending classes online during covid? "
      + "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, "
      + "consectetur, adipisci velit, sed quia non numquam eius modi tempora "
      + "incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim"
      + " ad minima veniam, quis nostrum exercitationem ullam corporis suscipit "
      + "laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum"
      + " iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae "
      + "consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";

  /**
   * Declares and initializes short answer objects.
   */
  @Before
  public void SetUp() {
    short1 = new ShortAnswer("Input your mood today", true);
    short2 = new ShortAnswer("Input your color today", false);
  }

  /**
   * Test bad short answer objects.
   * with IllegalArg.
   */
  @Test
  public void TestBadShortAnswer() {
    try {
      ShortAnswer short3 = new ShortAnswer("", true);
    } catch (IllegalArgumentException e) {
      System.out.println( e.getMessage());
    }

    try {
      ShortAnswer short4 = new ShortAnswer(null, true);
    } catch (IllegalArgumentException e) {
      System.out.println( e.getMessage());
    }
  }

  /**
   * This is a test GetPrompt method.
   */
  @Test
  public void TestGetPrompt() {
    Assert.assertEquals("Input your mood today", short1.getPrompt());
    Assert.assertEquals("Input your color today", short2.getPrompt());
  }

  /**
   * This is a test isRequired method.
   */
  @Test
  public void TestIsRequired() {
    Assert.assertTrue(short1.isRequired());
    Assert.assertFalse(short2.isRequired());
  }

  /**
   * This is a test bad answer method.
   */
  @Test
  public void TestBadAnswer() {
    try {
      short2.answer(shortText);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      short1.answer(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      short1.answer("");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test Legal answer method.
   */
  @Test
  public void TestGoodAnswer() {
    Assert.assertEquals("", short1.getAnswer());
    short1.answer("I don't know");
    Assert.assertEquals("I don't know", short1.getAnswer());
    short2.answer("No lo se");
    Assert.assertEquals("No lo se", short2.getAnswer());
  }

  /**
   * Test copy method.
   */
  @Test
  public void TestCopy() {
    // Test attributes of copy and original.
    Question Short1Copy = short1.copy();
    Assert.assertEquals(Short1Copy.getPrompt(), short1.getPrompt());
    Assert.assertEquals(Short1Copy.isRequired(), short1.isRequired());
    Assert.assertEquals(Short1Copy.getAnswer(), short1.getAnswer());

    // deep test copy and original not the same
    Assert.assertNotSame(Short1Copy, short1);
  }
}
