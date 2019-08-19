package com.taobao.arthas.common;

import com.taobao.arthas.common.JavaVersionUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.Properties;

public class JavaVersionUtilsTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  // Test written by Diffblue Cover.
  @Test
  public void javaVersionStrInput1OutputNull() {

    // Arrange
    final Properties props = new Properties();
    props.setProperty("foo", "BAZ");

    // Act and Assert result
    Assert.assertNull(JavaVersionUtils.javaVersionStr(props));
  }
}
