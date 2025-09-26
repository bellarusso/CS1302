package edu.westga.cs1302.javafx_sample_starter.model.task;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.Data;

class TestConstructor {

  @Test
  public void testConstructorSetInfo() {
    Data task = new Data("Chore 1", "Walk the dog", "high");
    assertEquals("Chore 1", task.getName());
    assertEquals("Walk the dog", task.getDescription());
    assertEquals("high", task.getPriority());
  }

  @Test
  public void testConstructorEmptyDescription() {
    Data task = new Data("Chore 1", "", "high");

    assertEquals("Chore 1", task.getName());
    assertEquals("", task.getDescription());
    assertEquals("high", task.getPriority());
  }

  @Test
  public void testConstructorWithNullValues() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Data(null, null, null);
    });
  }

}