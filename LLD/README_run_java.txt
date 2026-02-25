# Java Daily Practice: Compile & Run

This script will help you compile and run your Java files with any filename, as long as your main class is named Main (case-sensitive) and is not public.

## Usage

1. Open your terminal and navigate to your LLD directory:
   cd "C:/Users/Thanuj Varada/Documents/bala/Scaler/github/scaler-dsa-java/LLD"

2. Compile your Java file (replace with your actual filename):
   javac 25_Feb_2026_Generics.java

3. Run the Main class:
   java Main

---

## Troubleshooting
- If you get `ClassNotFoundException`, make sure:
  - You are in the LLD directory.
  - The class is named `Main` (capital M).
  - There is a `Main.class` file in the directory.
- If you want to run a different class with a main method, use its class name in the `java` command.

---

## Quick Bash Script
You can copy-paste this into your terminal (replace the filename as needed):

```
javac 25_Feb_2026_Generics.java && java Main
```

---

Happy coding!
