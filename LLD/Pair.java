//Generics - Make Dynamic data types

public class Pair<T, V> {
    // The below dashes can be filled with Data Types which is usually a Keyword
    // But Generics allows us to create custom Data types
    // ------ first;
    // ------ second;
    T first;
    V last;
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
    }
}
