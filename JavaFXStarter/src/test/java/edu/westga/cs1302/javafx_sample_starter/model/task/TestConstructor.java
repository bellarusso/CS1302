package edu.westga.cs1302.javafx_sample_starter.model.task;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample_starter.model.Data;

class TestConstructor {

  @Test
  public void testConstructorWithValidInputs() {
    Data task = new Data("Chore 1", "Walk the dog", "high");
    assertEquals("Chore 1", task.getName());
    assertEquals("Walk the dog", task.getDescription());
    assertEquals("high", task.getPriority());
  }

  @Test
  public void testConstructorEmptyOrNullDescription() {
    Data task1 = new Data("Chore 1", "", "high");
    assertEquals("", task1.getDescription());

    Data task2 = new Data("Chore 2", null, "medium");
    assertEquals("", task2.getDescription());
  }

  @Test
  public void testConstructorInvalidNameThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> new Data(null, "description", "high"));
    assertThrows(IllegalArgumentException.class, () -> new Data("", "description", "high"));
  }

  @Test
  public void testConstructorInvalidPriorityThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> new Data("Chore 1", "Walk the dog", null));
    assertThrows(IllegalArgumentException.class, () -> new Data("Chore 1", "Walk the dog", ""));
  }

  @Test
  public void testConstructorEmptyNameThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Data("", "Walk the dog", "high");
    });
  }

  @Test
  public void testSetDescriptionValidNoNull() {
    Data task = new Data("Chore 1", "Walk the dog", "high");
    task.setDescription("Feed the dog");
    assertEquals("Feed the dog", task.getDescription());
    task.setDescription("");
    assertEquals("", task.getDescription());
    task.setDescription(null);
    assertEquals("", task.getDescription());
  }

  @Test
  public void testStringReturnsName() {
    Data task = new Data("Chore 1", "Walk the dog", "high");
    assertEquals("Chore 1", task.toString());
  }

}