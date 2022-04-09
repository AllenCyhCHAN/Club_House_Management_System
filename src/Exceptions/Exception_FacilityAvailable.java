package Exceptions;

public class Exception_FacilityAvailable extends RuntimeException{
  public Exception_FacilityAvailable() {
    super("This facility is vacant");
  }
}