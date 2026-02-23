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