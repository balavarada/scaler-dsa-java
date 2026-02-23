//Generics - Make Dynamic data types

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
