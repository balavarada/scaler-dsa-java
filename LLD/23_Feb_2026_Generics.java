
//Generics - Make Dynamic data types
import java.util.*;

// Generic Variables
class Pair<T, V> {
    // The below dashes can be filled with Data Types which is usually a Keyword
    // But Generics allows us to create custom Data types
    // ------ first;
    // ------ second;
    T first;
    V last;
}

// Generic Methods
class Utility {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Test {

    public static void main(String[] args) {

        Box<String> stringBox = new Box<>();
        stringBox.set("Java");
        String val = stringBox.get();

        Box<Integer> intBox = new Box<>();
        intBox.set(100);

        // Generic Methods
        String[] names = { "Divya", "Java" };
        Integer[] numbers = { 1, 2, 3 };

        Utility.printArray(names);
        Utility.printArray(numbers);
        // names reference is on stack
        // Array object is in heap
        // T does NOT exist in memory
        // It is removed during compilation (type erasure)
        // Generics affect compile-time safety, not runtime memory layout.
    }

}

// Example with Equals

class Point<X, Y> {

    private X x;
    private Y y;

    public Point(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Point))
            return false;

        Point<?, ?> other = (Point<?, ?>) obj;

        return java.util.Objects.equals(x, other.x) &&
                java.util.Objects.equals(y, other.y);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }
}

// Super and wildcards

class Animal {
}

class Dog extends Animal {
}

class Puppy extends Dog {
}

class Example {

    public static void addDogs(List<? super Dog> list) {
        list.add(new Dog());
        list.add(new Puppy()); // also allowed
        // list.add(new Animal()); ❌ not allowed
    }

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        addDogs(animals); // ✅ Animal is super of Dog
        addDogs(dogs); // ✅ Dog itself
        addDogs(objects); // ✅ Object is super of Dog

        // List<Puppy> puppies = new ArrayList<>();
        // addDogs(puppies); ❌ Puppy is NOT super of Dog
    }

    public static void printList(List<? extends Dog> d) {

        // List<? extends Dog>
        // Means:
        // A list of Dog OR any subclass of Dog
        for (int i = 0; i < d.size(); i++) {
            System.out.println(d.get(i));
        }
    }

    public static void printListTop(List<? super Dog> d) {

        // List<? super Dog>
        // Means:
        // A list of Dog OR any superclass of Dog
        for (int i = 0; i < d.size(); i++) {
            System.out.println(d.get(i));
        }
    }
}