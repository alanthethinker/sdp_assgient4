package observer;

public class NewsSubscriber implements Observer {
    private String subscriberName;
    private String receivedNews;

    public NewsSubscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String news) {
        this.receivedNews = news;
        displayNotification();
    }

    private void displayNotification() {
        System.out.println(subscriberName + " received notification: " + receivedNews);
    }

    public String getReceivedNews() {
        return receivedNews;
    }
}