package Exceptions;

public class Exception_NotYetCheckIn extends RuntimeException {
  public Exception_NotYetCheckIn() {
    super("This reservation has not been checked in");
  }
}