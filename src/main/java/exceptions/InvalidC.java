package exceptions;


public class InvalidC extends Exception{
    private String username;
    public InvalidC(String username) {
        super(String.format("Invalid username %s!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
