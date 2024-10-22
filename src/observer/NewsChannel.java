package observer;

public class NewsChannel implements Observer {
    private String channelName;
    private String lastReceivedNews;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String news) {
        this.lastReceivedNews = news;
        displayNews();
    }

    private void displayNews() {
        System.out.println(channelName + " breaking news: " + lastReceivedNews);
    }

    public String getLastReceivedNews() {
        return lastReceivedNews;
    }
}