package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

  private final String testThisFile = "data.txt";

  @AfterEach
  void tearDown() {
    File file = new File(this.testThisFile);
    if (file.exists()) {
      file.delete();
    }
  }

  @Test
  void testLoadExpectedCsv() throws IOException {
    try (FileWriter writer = new FileWriter(this.testThisFile)) {
      writer.write("Bella,80" + System.lineSeparator());
      writer.write("Jacob,50" + System.lineSeparator());
    }

    Student[] loadedStudents = StudentDataPersistenceManager.loadStudentData();
    assertEquals(2, loadedStudents.length);
    assertEquals("Bella", loadedStudents[0].getName());
    assertEquals(80, loadedStudents[0].getGrade());
    assertEquals("Jacob", loadedStudents[1].getName());
    assertEquals(50, loadedStudents[1].getGrade());
  }

  @Test
  void testLoadStudentIsNull() throws IOException {
    new File(this.testThisFile).createNewFile(); // creates empty file

    Student[] loaded = StudentDataPersistenceManager.loadStudentData();
    assertEquals(0, loaded.length);
  }

  @Test
  void testLoadInvalidFormat() throws IOException {
    try (FileWriter writer = new FileWriter(this.testThisFile)) {
      writer.write("Bella-80" + System.lineSeparator()); // invalid separator
    }

    assertThrows(IOException.class, () -> {
      StudentDataPersistenceManager.loadStudentData();
    });
  }
}
