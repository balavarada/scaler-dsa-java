
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// public abstract class 25_Feb_2026_Generics{

// }
// [Generics & Collections Lab]
// Comparator to sort Items by name
class NameComparator implements Comparator<Items> {
    @Override
    public int compare(Items o1, Items o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

// Implement a base class item extends comparable
class Items implements Comparable<Items> {
    private String id;
    private String name;
    private int price;
    private int qty;

    public Items(String id, String name, int price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    @Override
    public int compareTo(Items o) {
        return Integer.compare(this.price, o.price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    // Comparator to sort the collections
    public static Comparator<Items> priceComparator = new Comparator<Items>() {
        @Override
        public int compare(Items o1, Items o2) {
            return Integer.compare(o1.getPrice(), o2.getPrice());
        }
    };
}

// Electronics class extending Items
class Electronics extends Items {
    private int warrantyMonths;

    public Electronics(String id, String name, int price, int qty, int warrantyMonths) {
        super(id, name, price, qty);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}

class Main {

    public static void main(String[] args) {
        List<Items> itemsList = new ArrayList<>();
        Items item1 = new Items("1", "a2", 100, 10);
        Items item2 = new Items("2", "a1", 150, 5);
        Items item3 = new Items("3", "a3", 13, 1);
        Items item4 = new Items("4", "a4", 6, 1);

        // Add regular items
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);

        // Add Electronics items
        Electronics e1 = new Electronics("E1", "Laptop", 50000, 2, 24);
        Electronics e2 = new Electronics("E2", "Smartphone", 30000, 5, 12);
        Electronics e3 = new Electronics("E3", "Tablet", 20000, 3, 18);
        itemsList.add(e1);
        itemsList.add(e2);
        itemsList.add(e3);

        System.out.println("--- Sorted by Name (All Items) ---");
        NameComparator na = new NameComparator();
        Collections.sort(itemsList, na);
        for (Items item : itemsList) {
            System.out.println(item.getName() + " " + item.getPrice());
        }

        System.out.println("\n--- Sorted by Price (All Items) ---");
        Collections.sort(itemsList, Items.priceComparator);
        for (Items item : itemsList) {
            System.out.println(item.getName() + " " + item.getPrice());
        }
    }
}