package Exceptions;

public class Exception_CheckInAlready extends RuntimeException {
  public Exception_CheckInAlready() {
    super("This reservation has already been checked in");
  }
}