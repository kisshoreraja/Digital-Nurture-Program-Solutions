public class Logger {
    // Step 1: Create a private static instance of the class
    private static Logger singleInstance = null;

    // Step 2: Make the constructor private so that this class cannot be instantiated from outside
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Step 3: Provide a public static method to get the instance of the class
    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    // Sample logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
