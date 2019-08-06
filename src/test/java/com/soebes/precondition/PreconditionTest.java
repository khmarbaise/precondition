package com.soebes.precondition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Precondition}.
 *
 * @author Karl Heinz Marbaise
 */
class PreconditionTest {

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

  @Test
  void requireGreaterThanZeroIAEInteger() {
    assertThatIllegalArgumentException().isThrownBy(
        () -> Precondition.requireGreaterThanZeroInteger((Integer) null, "The Null Message"));
  }

  @Test
  void requireGreaterThanZeroIAEWithGivenMessageInteger() {
    assertThatIllegalArgumentException().isThrownBy(
        () -> Precondition.requireGreaterThanZeroInteger((Integer) null, "The Null Message"))
        .withMessage("The Null Message");
  }

  @Test
  void requireGreaterThanZeroWithZeroValueInteger() {
    assertThatIllegalArgumentException().isThrownBy(
        () -> Precondition.requireGreaterThanZeroInteger(Integer.valueOf(0), "The Zero Message"))
        .withMessage("The Zero Message");
  }

  @Test
  void should_return_same_objectInteger() {
    Integer integerValue = Integer.MAX_VALUE;
    assertThat(Precondition.requireGreaterThanZeroInteger(integerValue, "The failure message")).isSameAs(integerValue);
  }
}
