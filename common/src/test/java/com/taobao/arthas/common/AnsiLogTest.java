package com.taobao.arthas.common;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

import com.taobao.arthas.common.AnsiLog;
import com.taobao.arthas.common.OSUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.logging.Level;

@RunWith(PowerMockRunner.class)
public class AnsiLogTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void blackInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.black(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void blueInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.blue(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void cyanInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.cyan(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void enableColorOutputFalse() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final boolean actual = AnsiLog.enableColor();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void greenInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.green(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void levelOutputNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final Level actual = AnsiLog.level();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void magentaInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.magenta(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void redInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.red(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void whiteInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.white(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({AnsiLog.class, OSUtils.class, System.class})
  @Test
  public void yellowInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String msg = "3";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = AnsiLog.yellow(msg);

    // Assert result
    Assert.assertEquals("3", actual);
  }
}
