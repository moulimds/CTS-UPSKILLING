public class Main {
    public static void main(String[] args) {
        String message = StringUtils.greet("Mouli");
        System.out.println(message);
    }
}

class StringUtils {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}
