package com.taobao.arthas.common;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

import com.taobao.arthas.common.OSUtils;
import com.taobao.arthas.common.UsageRender;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class UsageRenderTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  // Test written by Diffblue Cover.
  @PrepareForTest({UsageRender.class, OSUtils.class, System.class})
  @Test
  public void renderInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);
    PowerMockito.mockStatic(OSUtils.class);

    // Arrange
    final String usage = "BAZ";
    PowerMockito.doReturn(false).when(OSUtils.class);
    OSUtils.isCygwinOrMinGW();
    PowerMockito.when(System.console()).thenReturn(null);

    // Act
    final String actual = UsageRender.render(usage);

    // Assert result
    Assert.assertEquals("BAZ", actual);
  }
}
