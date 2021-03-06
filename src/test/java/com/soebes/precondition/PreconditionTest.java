package com.soebes.precondition;

import static com.soebes.precondition.Precondition.requireGreaterThanZero;
import static com.soebes.precondition.Precondition.requireGreaterThanZeroInteger;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
          () -> requireGreaterThanZero((Long) null, "Null Message"));
    }

    @Test
    void requireGreaterThanZeroIAEWithGivenMessage() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> requireGreaterThanZero((Long) null, "The given Message")).withMessage("The given Message");
    }

    @Test
    void requireGreaterThanZeroWithZeroValue() {
      assertThatIllegalArgumentException().isThrownBy(() -> requireGreaterThanZero(0L, "The Zero Message"))
          .withMessage("The Zero Message");
    }

    @Test
    void should_return_same_object() {
      Long longValue = Long.MAX_VALUE;
      assertThat(requireGreaterThanZero(longValue, "The failure message")).isSameAs(longValue);
    }
  }

  @Nested
  @DisplayName("requireGreaterThanZero for Integer parameter Tests")
  class RequireGreaterThanZeroIntegerTests {

    @Test
    void requireGreaterThanZeroIAE() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> requireGreaterThanZeroInteger((Integer) null, "The Null Message"));
    }

    @Test
    void requireGreaterThanZeroIAEWithGivenMessage() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> requireGreaterThanZeroInteger((Integer) null, "The Null Message"))
          .withMessage("The Null Message");
    }

    @Test
    void requireGreaterThanZeroWithZeroValue() {
      assertThatIllegalArgumentException().isThrownBy(
          () -> requireGreaterThanZeroInteger(Integer.valueOf(0), "The Zero Message"))
          .withMessage("The Zero Message");
    }

    @Test
    void should_return_same_object() {
      Integer integerValue = Integer.MAX_VALUE;
      assertThat(requireGreaterThanZeroInteger(integerValue, "The failure message")).isSameAs(integerValue);
    }
  }
}
