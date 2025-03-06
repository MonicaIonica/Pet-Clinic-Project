package org.example.configs;

import java.util.NoSuchElementException;

public class InvalidMismatchException extends NoSuchElementException {
  public InvalidMismatchException(String NoAppointments) {
    super(NoAppointments);
  }
}
