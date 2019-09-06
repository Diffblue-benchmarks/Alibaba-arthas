package com.taobao.arthas.core.util;

import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Matchers.isA;
import static org.mockito.Matchers.isNull;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import com.taobao.arthas.core.util.ObjectUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Array;

@RunWith(PowerMockRunner.class)
public class ObjectUtilsTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  // Test written by Diffblue Cover.

  @Test
  public void containsConstantInput0NotNullFalseOutputFalse() {

    // Arrange
    final Enum[] enumValues = {};
    final String constant = ",";
    final boolean caseSensitive = false;

    // Act
    final boolean actual = ObjectUtils.containsConstant(enumValues, constant, caseSensitive);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void containsConstantInput0NotNullOutputFalse() {

    // Arrange
    final Enum[] enumValues = {};
    final String constant = "a\'b\'c";

    // Act
    final boolean actual = ObjectUtils.containsConstant(enumValues, constant);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void containsElementInput0NullOutputFalse() {

    // Arrange
    final Object[] array = {};
    final Object element = null;

    // Act
    final boolean actual = ObjectUtils.containsElement(array, element);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void containsElementInput1NegativeOutputFalse() {

    // Arrange
    final Object[] array = {0};
    final Object element = -2_147_483_648;

    // Act
    final boolean actual = ObjectUtils.containsElement(array, element);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void containsElementInput1ZeroOutputFalse() {

    // Arrange
    final Object[] array = {null};
    final Object element = 0;

    // Act
    final boolean actual = ObjectUtils.containsElement(array, element);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void containsElementInput1ZeroOutputTrue() {

    // Arrange
    final Object[] array = {0};
    final Object element = 0;

    // Act
    final boolean actual = ObjectUtils.containsElement(array, element);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void containsElementInputNullNullOutputFalse() {

    // Arrange
    final Object[] array = null;
    final Object element = null;

    // Act
    final boolean actual = ObjectUtils.containsElement(array, element);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getDisplayStringInputNegativeOutputNotNull() {

    // Arrange
    final Object obj = -10_000_000;

    // Act
    final String actual = ObjectUtils.getDisplayString(obj);

    // Assert result
    Assert.assertEquals("-10000000", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getDisplayStringInputNullOutputNotNull() {

    // Arrange
    final Object obj = null;

    // Act
    final String actual = ObjectUtils.getDisplayString(obj);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ObjectUtils.class, System.class})
  @Test
  public void getIdentityHexStringInputNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);

    // Arrange
    final Object obj = null;
    PowerMockito.when(System.identityHashCode(or(isA(Object.class), isNull(Object.class))))
        .thenReturn(0);

    // Act
    final String actual = ObjectUtils.getIdentityHexString(obj);

    // Assert result
    Assert.assertEquals("0", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void identityToStringInputNullOutputNotNull() {

    // Arrange
    final Object obj = null;

    // Act
    final String actual = ObjectUtils.identityToString(obj);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ObjectUtils.class, System.class})
  @Test
  public void identityToStringInputZeroOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);

    // Arrange
    final Object obj = 0;
    PowerMockito.when(System.identityHashCode(or(isA(Object.class), isNull(Object.class))))
        .thenReturn(0);

    // Act
    final String actual = ObjectUtils.identityToString(obj);

    // Assert result
    Assert.assertEquals("java.lang.Integer@0", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isArrayInputNullOutputFalse() {

    // Arrange
    final Object obj = null;

    // Act
    final boolean actual = ObjectUtils.isArray(obj);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isArrayInputZeroOutputFalse() {

    // Arrange
    final Object obj = 0;

    // Act
    final boolean actual = ObjectUtils.isArray(obj);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isCheckedExceptionInputNullOutputTrue() {

    // Arrange
    final Throwable ex = null;

    // Act
    final boolean actual = ObjectUtils.isCheckedException(ex);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isCompatibleWithThrowsClauseInputNull0OutputFalse() {

    // Arrange
    final Throwable ex = null;
    final Class[] declaredExceptions = {};

    // Act
    final boolean actual = ObjectUtils.isCompatibleWithThrowsClause(ex, declaredExceptions);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isCompatibleWithThrowsClauseInputNullNullOutputFalse() {

    // Arrange
    final Throwable ex = null;
    final Class[] declaredExceptions = null;

    // Act
    final boolean actual = ObjectUtils.isCompatibleWithThrowsClause(ex, declaredExceptions);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void isEmptyInput0OutputTrue() {

    // Arrange
    final Object[] array = {};

    // Act
    final boolean actual = ObjectUtils.isEmpty(array);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isEmptyInputNullOutputTrue() {

    // Arrange
    final Object[] array = null;

    // Act
    final boolean actual = ObjectUtils.isEmpty(array);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeClassNameInputNullOutputNotNull() {

    // Arrange
    final Object obj = null;

    // Act
    final String actual = ObjectUtils.nullSafeClassName(obj);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeClassNameInputZeroOutputNotNull() {

    // Arrange
    final Object obj = 0;

    // Act
    final String actual = ObjectUtils.nullSafeClassName(obj);

    // Assert result
    Assert.assertEquals("java.lang.Integer", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeEqualsInputNullNullOutputTrue() {

    // Arrange
    final Object o1 = null;
    final Object o2 = null;

    // Act
    final boolean actual = ObjectUtils.nullSafeEquals(o1, o2);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nullSafeHashCodeInput0OutputPositive() {

    // Arrange
    final Object[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive2() {

    // Arrange
    final boolean[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive3() {

    // Arrange
    final byte[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive4() {

    // Arrange
    final char[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive5() {

    // Arrange
    final double[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive6() {

    // Arrange
    final float[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive7() {

    // Arrange
    final int[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive8() {

    // Arrange
    final long[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput0OutputPositive9() {

    // Arrange
    final short[] array = {};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(7, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputNegative() {

    // Arrange
    final float[] array = {0.0f};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(-8_388_391, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputPositive() {

    // Arrange
    final boolean[] array = {false};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(1454, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nullSafeHashCodeInput1OutputPositive2() {

    // Arrange
    final Object[] array = {null};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(217, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputPositive3() {

    // Arrange
    final byte[] array = {(byte)-122};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(95, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputPositive4() {

    // Arrange
    final boolean[] array = {true};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(1448, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputPositive5() {

    // Arrange
    final char[] array = {'\u0006'};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(223, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nullSafeHashCodeInput1OutputZero() {

    // Arrange
    final Object[] array = {-217};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputZero2() {

    // Arrange
    final double[] array = {0.0};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputZero3() {

    // Arrange
    final int[] array = {-217};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputZero4() {

    // Arrange
    final long[] array = {4_294_967_079L};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInput1OutputZero5() {

    // Arrange
    final short[] array = {(short)-217};

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero() {

    // Arrange
    final Object[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero2() {

    // Arrange
    final boolean[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero3() {

    // Arrange
    final byte[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero4() {

    // Arrange
    final char[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero5() {

    // Arrange
    final double[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero6() {

    // Arrange
    final float[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero7() {

    // Arrange
    final int[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero8() {

    // Arrange
    final long[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeHashCodeInputNullOutputZero9() {

    // Arrange
    final short[] array = null;

    // Act
    final int actual = ObjectUtils.nullSafeHashCode(array);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nullSafeToStringInput0OutputNotNull() {

    // Arrange
    final Object[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull2() {

    // Arrange
    final boolean[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull3() {

    // Arrange
    final byte[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull4() {

    // Arrange
    final char[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull5() {

    // Arrange
    final long[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull6() {

    // Arrange
    final float[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull7() {

    // Arrange
    final int[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull8() {

    // Arrange
    final short[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput0OutputNotNull9() {

    // Arrange
    final double[] array = {};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull() {

    // Arrange
    final boolean[] array = {true};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{true}", actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nullSafeToStringInput1OutputNotNull2() {

    // Arrange
    final Object[] array = {null};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{,}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull3() {

    // Arrange
    final byte[] array = {(byte)-5};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{-5}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull4() {

    // Arrange
    final char[] array = {'\u0001'};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{\'\u0001\'}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull5() {

    // Arrange
    final int[] array = {-5};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{-5}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull6() {

    // Arrange
    final short[] array = {(short)-5};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{-5}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull7() {

    // Arrange
    final long[] array = {9L};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{9}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull8() {

    // Arrange
    final double[] array = {0x1.00b2bep+0 /* 1.00273 */};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{1.00272}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput1OutputNotNull9() {

    // Arrange
    final float[] array = {-0x1.89c05ap+16f /* -100800.0 */};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{--800.0}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull() {

    // Arrange
    final boolean[] array = {true, true};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{true, true}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull2() {

    // Arrange
    final byte[] array = {(byte)43, (byte)104};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{43, 104}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull3() {

    // Arrange
    final char[] array = {'\u0001', '\u0000'};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{\'\u0001\', \'\u0000\'}", actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nullSafeToStringInput2OutputNotNull4() {

    // Arrange
    final Object[] array = {null, null};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{foo, foo}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull5() {

    // Arrange
    final short[] array = {(short)43, (short)-32_768};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{43, -32768}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull6() {

    // Arrange
    final int[] array = {0, -100_000_000};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{0, -100000000}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull7() {

    // Arrange
    final long[] array = {3L, 7L};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{3, 7}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull8() {

    // Arrange
    final double[] array = {-0x1.000022p+2 /* -4.00001 */, -0x1.000002p+0 /* -1.0 */};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{--4.0, --1.0}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInput2OutputNotNull9() {

    // Arrange
    final float[] array = {-0x1.00008ep+0f /* -1.00001 */, -0x1.c30c9ep+22f /* -7.38999e+06 */};

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("{--1.0, --89991.0}", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull() {

    // Arrange
    final Object[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull2() {

    // Arrange
    final boolean[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull3() {

    // Arrange
    final byte[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull4() {

    // Arrange
    final char[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull5() {

    // Arrange
    final int[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull6() {

    // Arrange
    final short[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull7() {

    // Arrange
    final long[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull8() {

    // Arrange
    final float[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nullSafeToStringInputNullOutputNotNull9() {

    // Arrange
    final double[] array = null;

    // Act
    final String actual = ObjectUtils.nullSafeToString(array);

    // Assert result
    Assert.assertEquals("null", actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void toObjectArrayInputNullOutput0() {

    // Arrange
    final Object source = null;

    // Act
    final Object[] actual = ObjectUtils.toObjectArray(source);

    // Assert result
    Assert.assertArrayEquals(new Object[] {}, actual);
  }
}
