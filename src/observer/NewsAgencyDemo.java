package observer;

public class NewsAgencyDemo {
    public static void main(String[] args) {
        // Create news agency
        NewsAgency reuters = new NewsAgency("Reuters");

        // Create different types of observers
        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");
        OnlineNewsPortal googleNews = new OnlineNewsPortal("Google News");
        NewsSubscriber subscriber1 = new NewsSubscriber("Mobile App User");

        // Register observers
        reuters.addObserver(cnn);
        reuters.addObserver(bbc);
        reuters.addObserver(googleNews);
        reuters.addObserver(subscriber1);

        // Test Case 1: Publishing breaking news
        System.out.println("=== Test Case 1: Breaking News ===");
        reuters.publishNews("Breaking: Major scientific breakthrough announced!");

        // Test Case 2: Remove an observer and publish again
        System.out.println("\n=== Test Case 2: Remove Observer ===");
        reuters.removeObserver(bbc);
        System.out.println("BBC has been removed from observers");
        reuters.publishNews("Update: Stock market reaches all-time high!");

        // Test Case 3: Add new observer and publish
        System.out.println("\n=== Test Case 3: Add New Observer ===");
        NewsChannel fox = new NewsChannel("Fox News");
        reuters.addObserver(fox);
        System.out.println("Fox News has joined as an observer");
        reuters.publishNews("Breaking: International space mission launches successfully!");

        // Test Case 4: Multiple news agencies
        System.out.println("\n=== Test Case 4: Multiple News Agencies ===");
        NewsAgency ap = new NewsAgency("Associated Press");
        ap.addObserver(cnn);
        ap.addObserver(fox);  // Fixed: using 'fox' instead of 'foxNews'
        ap.publishNews("Breaking: Major sports event results announced!");
    }
}