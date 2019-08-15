package com.soebes.precondition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.UnknownFormatConversionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Precondition}.
 *
 * @author Karl Heinz Marbaise
 */
class PreconditionTest {

  @Nested
  @DisplayName("requireGreaterThanZero for Long parameter Tests")
  class RequireGreaterThanZeroLongTests {

    @Test
    void requireGreaterThanZeroIAE() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> Precondition.requireGreaterThanZero((Long) null, "Null Message"));
    }

    @Test
    void requireGreaterThanZeroIAEWithGivenMessage() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> Precondition.requireGreaterThanZero((Long) null, "The given Message")).withMessage("The given Message");
    }

    @Test
    void requireGreaterThanZeroWithZeroValue() {
      assertThatIllegalArgumentException().isThrownBy(() -> Precondition.requireGreaterThanZero(0L, "The Zero Message"))
          .withMessage("The Zero Message");
    }

    @Test
    void should_return_same_object() {
      Long longValue = Long.MAX_VALUE;
      assertThat(Precondition.requireGreaterThanZero(longValue, "The failure message")).isSameAs(longValue);
    }
  }

  @Nested
  @DisplayName("requireGreaterThanZero for Integer parameter Tests")
  class RequireGreaterThanZeroIntegerTests {

    @Test
    void requireGreaterThanZeroIAE() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> Precondition.requireGreaterThanZeroInteger((Integer) null, "The Null Message"));
    }

    @Test
    void requireGreaterThanZeroIAEWithGivenMessage() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> Precondition.requireGreaterThanZeroInteger((Integer) null, "The Null Message"))
          .withMessage("The Null Message");
    }

    @Test
    void requireGreaterThanZeroWithZeroValue() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> Precondition.requireGreaterThanZeroInteger(Integer.valueOf(0), "The Zero Message"))
          .withMessage("The Zero Message");
    }

    @Test
    void should_return_same_object() {
      Integer integerValue = Integer.MAX_VALUE;
      assertThat(Precondition.requireGreaterThanZeroInteger(integerValue, "The failure message")).isSameAs(integerValue);
    }
  }

  void doSomethingWithoutAnyException() {
    return;
  }

  @Test
  void name() {
    int zeroValue = 0;
    assertThat(zeroValue);
  }

  void doSomethingWithException() {
    throw new IllegalStateException();
  }
  @Test
  void firstTest() {
    int zeroValue = 0;
    assertThat(zeroValue).isOne();

    int oneValue = 1;
    assertThat(oneValue).isOne();


    assertThatCode(() -> doSomethingWithoutAnyException()).doesNotThrowAnyException();
    assertThatIllegalStateException().isThrownBy(() -> doSomethingWithException()).withMessage("Test");

    assertThatExceptionOfType(UnknownFormatConversionException.class)
        .isThrownBy(() -> doSomethingWithException())
        .withMessage("XXX");
  }
}
