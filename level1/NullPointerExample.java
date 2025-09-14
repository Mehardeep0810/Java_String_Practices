package Assigned5.level1;

public class NullPointerExample {

    public static void generateException() {
        String text = null;
        System.out.println(text.toUpperCase());
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Uncomment this to see the exception
        //generateException();

        // Refactored to handle the exception
        handleException();
    }
}