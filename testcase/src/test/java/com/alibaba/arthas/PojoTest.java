package com.alibaba.arthas;

import com.alibaba.arthas.Pojo;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class PojoTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  // Test written by Diffblue Cover.
  @Test
  public void getAgeOutputZero() {

    // Arrange
    final Pojo pojo = new Pojo();

    // Act and Assert result
    Assert.assertEquals(0, pojo.getAge());
  }

  // Test written by Diffblue Cover.
  @Test
  public void getHobbyOutputNull() {

    // Arrange
    final Pojo pojo = new Pojo();

    // Act and Assert result
    Assert.assertNull(pojo.getHobby());
  }

  // Test written by Diffblue Cover.
  @Test
  public void getNameOutputNull() {

    // Arrange
    final Pojo pojo = new Pojo();

    // Act and Assert result
    Assert.assertNull(pojo.getName());
  }

  // Test written by Diffblue Cover.
  @Test
  public void setHobbyInputNotNullOutputVoid() {

    // Arrange
    final Pojo pojo = new Pojo();

    // Act
    pojo.setHobby("\'");

    // Assert side effects
    Assert.assertEquals("\'", pojo.getHobby());
  }

  // Test written by Diffblue Cover.
  @Test
  public void setNameInputNotNullOutputVoid() {

    // Arrange
    final Pojo pojo = new Pojo();

    // Act
    pojo.setName("3");

    // Assert side effects
    Assert.assertEquals("3", pojo.getName());
  }
}
