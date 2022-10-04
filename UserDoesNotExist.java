public class UserDoesNotExist extends RuntimeException {
    public UserDoesNotExist() {
        System.err.println("Sorry User doesn't exist : ");
    }

    public UserDoesNotExist(String message) {
        System.err.println("Sorry User doesn't exist : "+message);
    }
}
