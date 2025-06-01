package Exercise_5;
import java.util.ArrayList;
import java.util.List;


class Website implements Observable {
    private String url;
    private String update;
    private List<Observer> observers;

    public Website(String url) {
        this.url = url;
        this.update = "up to date";
        this.observers = new ArrayList<>();
    }

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
        notifyObservers();
    }

    // Observable methods
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Website " + url + " has a new update: " + update);
        }
    }
}