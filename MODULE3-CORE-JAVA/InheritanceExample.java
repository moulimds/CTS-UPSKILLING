// Base class
class Animal {
    // Method to be overridden
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass that extends Animal
class Dog extends Animal {
    // Overriding makeSound()
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

// Main class to test the inheritance
public class InheritanceExample {
    public static void main(String[] args) {
        // Instantiate Animal object
        Animal genericAnimal = new Animal();
        genericAnimal.makeSound();  // Output: Some generic animal sound

        // Instantiate Dog object
        Dog dog = new Dog();
        dog.makeSound();  // Output: Bark
    }
}
