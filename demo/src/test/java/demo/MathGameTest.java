package demo;

import demo.MathGame;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class MathGameTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  // Test written by Diffblue Cover.
  @Test
  public void primeFactorsInputNegativeOutputIllegalArgumentException() {

    // Arrange
    final MathGame mathGame = new MathGame();
    try {

      // Act
      thrown.expect(IllegalArgumentException.class);
      mathGame.primeFactors(-21);
    } catch (IllegalArgumentException ex) {

      // Assert side effects
      Assert.assertEquals(1, mathGame.illegalArgumentCount);
      throw ex;
    }
  }
}
