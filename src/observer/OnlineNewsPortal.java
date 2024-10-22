package observer;

public class OnlineNewsPortal implements Observer {
    private String portalName;
    private String currentNews;

    public OnlineNewsPortal(String portalName) {
        this.portalName = portalName;
    }

    @Override
    public void update(String news) {
        this.currentNews = news;
        updateWebsite();
    }

    private void updateWebsite() {
        System.out.println(portalName + " website updated with: " + currentNews);
    }

    public String getCurrentNews() {
        return currentNews;
    }
}