package Exercise_6;

import java.util.ArrayList;
import java.util.List;

class Website implements Observable {
    private String url;
    private String update;
    private String htmlContent;
    private String textContent;
    private List<Observer> observers;
    boolean aBoolean;

    public Website(String url) {
        this.url = url;
        this.update = "up to date";
        this.observers = new ArrayList<>();
        this.aBoolean = aBoolean;
    }

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public String getUpdate() {
        return update;
    }

    public boolean getaBoolean(){
        return aBoolean;
    }

    public void setUpdate(String update) {
        this.update = update;
        notifyObservers();
    }

    public void setaBoolean(boolean aBoolean){
        this.aBoolean = aBoolean;
    }

    public int getContentSize() {
        return htmlContent != null ? htmlContent.length() : 0;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
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
