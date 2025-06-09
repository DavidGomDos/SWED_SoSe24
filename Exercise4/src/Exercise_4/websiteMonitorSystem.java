package Exercise_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class websiteMonitorSystem {
    private Map<User, List<Website>> subscriptions;
    private Map<Website, List<User>> websiteSubscribers;

    public websiteMonitorSystem(){
        this.websiteSubscribers = new HashMap<>();
        this.subscriptions = new HashMap<>();
    }

    //maps befüllen

    public void register(User user, Website website){
        subscriptions.putIfAbsent(user, new ArrayList<>()); //  user "erhält liste" falls noch er noch keine hat
        subscriptions.get(user).add(website);

        websiteSubscribers.put(website, new ArrayList<>());
        websiteSubscribers.get(website).add(user);

        //List <Website> websites = subscriptions.get(user); ??

        System.out.println("Subscriptions:");
        for (Map.Entry<User, List<Website>> entry : subscriptions.entrySet()) {
            System.out.println(entry.getKey().getName() + " → " +
                    entry.getValue().stream().map(Website::getUrl).toList());
        }


    }

    public void checkForUpdates(){
        for(Website website : websiteSubscribers.keySet()){ // für jede INstanz der Klasse Website

        };
    }

    public void notifyUsers(Website website){ // Verfasse Nachricht
        List<User> users = websiteSubscribers.get(website);
        for (User user : users) {
            String message = "Exercise_4.Website " + website.getUrl() + " has a new update: " + website.getUpdate();
            sendNotification(user, message);
        }
    }

    public void sendNotification(User user, String msg){ //Verschicke Nachricht
        System.out.println("\n");
        if(user.getChannel() == "email"){
            System.out.printf("e-mail to " + user.getEmail()+" "+ msg );
        }else {
            System.out.printf("sms to " + user.getName() +" "+ msg);
        }
    }
/*
    public void modifySubscription(User user, Website oldWebsite, Website newWebsite) {
        if (this.subscriptions.containsKey(user)) {
            ((List)this.subscriptions.get(user)).remove(oldWebsite);
            ((List)this.subscriptions.get(user)).add(newWebsite);
            System.out.println(user.getName() + " modified the subscription from: " + oldWebsite.getUrl() + " to " + newWebsite.getUrl());
        }
    }

    public void cancelSubscription(User user, Website website) {
        if (this.subscriptions.containsKey(user)) {
            ((List)this.subscriptions.get(user)).remove(website);
            ((List)this.websiteSubscribers.get(website)).remove(user);
            System.out.println(user.getName() + " canceled the subscription for: " + website.getUrl());
        }
    }
*/

}



