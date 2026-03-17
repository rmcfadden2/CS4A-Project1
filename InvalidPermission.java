public class InvalidPermission extends Exception{
    // Does not need public String message; since we extend exception
    // it extends it internally;

    // Should I include a date for when the error is recieved? 
    public InvalidPermission(String message)
    {
        // Store error message in Exception class
        super(message);
    }


}
