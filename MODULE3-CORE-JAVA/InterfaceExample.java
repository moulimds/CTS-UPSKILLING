interface Playable {
    void play();  // Interface method
}

// Class implementing Playable interface
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the guitar 🎸");
    }
}

// Another class implementing Playable interface
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano 🎹");
    }
}

// Main class to test interface implementation
public class InterfaceExample {
    public static void main(String[] args) {
        // Instantiate classes
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        // Call play method
        guitar.play();   // Output: Playing the guitar
        piano.play();    // Output: Playing the piano
    }
}
