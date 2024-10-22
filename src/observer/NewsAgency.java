package observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Observable {
    private List<Observer> observers;
    private String latestNews;
    private String agencyName;

    public NewsAgency(String agencyName) {
        this.agencyName = agencyName;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestNews);
        }
    }

    public void publishNews(String news) {
        System.out.println("\n" + agencyName + " is publishing news: " + news);
        this.latestNews = news;
        notifyObservers();
    }

    public String getLatestNews() {
        return latestNews;
    }

    public List<Observer> getObservers() {
        return new ArrayList<>(observers);
    }
}
