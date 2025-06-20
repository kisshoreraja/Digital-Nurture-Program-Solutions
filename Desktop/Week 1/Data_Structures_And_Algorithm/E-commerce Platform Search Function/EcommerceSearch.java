import java.util.*;

public class EcommerceSearch {
    private static final Map<String, List<String>> catalog = new HashMap<>();

    public static void main(String[] args) {
        populateCatalog();

        Scanner input = new Scanner(System.in);
        System.out.print(" Enter a product keyword to search: ");
        String query = input.nextLine().trim().toLowerCase();

        List<String> matchedProducts = findMatchingProducts(query);
        displayResults(query, matchedProducts);

        input.close();
    }

    private static void populateCatalog() {
        catalog.put("Electronics", List.of("Smartphone", "Laptop", "Headphones", "Tablet"));
        catalog.put("Fashion", List.of("T-Shirt", "Jeans", "Sneakers", "Wristwatch"));
        catalog.put("Groceries", List.of("Rice", "Wheat Flour", "Sugar", "Salt"));
    }

    private static List<String> findMatchingProducts(String keyword) {
        List<String> results = new ArrayList<>();
        for (var category : catalog.entrySet()) {
            for (String item : category.getValue()) {
                if (item.toLowerCase().contains(keyword)) {
                    results.add(item + " [Category: " + category.getKey() + "]");
                }
            }
        }
        return results;
    }

    private static void displayResults(String keyword, List<String> results) {
        System.out.println();
        if (results.isEmpty()) {
            System.out.println(" No products found for: \"" + keyword + "\"");
        } else {
            System.out.println(" Products found:");
            results.forEach(product -> System.out.println(" - " + product));
        }
    }
}
