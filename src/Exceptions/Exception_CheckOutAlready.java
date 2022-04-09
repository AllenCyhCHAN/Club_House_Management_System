package Exceptions;

public class Exception_CheckOutAlready extends RuntimeException {
  public Exception_CheckOutAlready() {
    super("This reservation has already been checked out");
  }
}