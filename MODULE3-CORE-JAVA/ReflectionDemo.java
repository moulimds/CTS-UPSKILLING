import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Load the class dynamically
        Class<?> cls = Class.forName("MyClass");

        // Create an instance
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Get all declared methods
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("\nMethod: " + method.getName());
            System.out.print("Parameters: ");
            Parameter[] params = method.getParameters();
            for (Parameter p : params) {
                System.out.print(p.getType().getSimpleName() + " " + p.getName() + "  ");
            }

            // Invoke method dynamically
            if (method.getName().equals("sayHello")) {
                method.invoke(obj, "Mouli");
            } else if (method.getName().equals("add")) {
                Object result = method.invoke(obj, 5, 7);
                System.out.println("\nResult of add: " + result);
            }
        }
    }
}
