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

        List <Website> websites = subscriptions.get(user);

        System.out.println(user.getName() + " has subscribed to " + website.getUrl());

        //System.out.println(user.getName() + website.getUrl());
    }

    public void checkForUpdates(){
        for(Website website : websiteSubscribers.keySet()){
                website.setUpdate("New update available\n");
                notifyUsers(website);
        };
    }

    public void notifyUsers(Website website){
        List<User> users = websiteSubscribers.get(website);
        for (User user : users) {
            String message = "Website " + website.getUrl() + " has a new update: " + website.getUpdate();
            sendNotification(user, message);
        }
    }

    public void sendNotification(User user,String msg){
        System.out.println("\n");
        if(user.getChannel() == "email"){
            System.out.printf("e-mail to " + user.getEmail()+" "+ msg );
        }else {
            System.out.printf("sms to " + user.getName() +" "+ msg);
        }
    }

    public void modifySubscription(User user, Website oldWebsite, Website newWebsite) {
        if (subscriptions.containsKey(user)) {
            subscriptions.get(user).remove(oldWebsite);
            subscriptions.get(user).add(newWebsite);
            System.out.println(user.getName() + " modified the subscription from: " + oldWebsite.getUrl() + " to " + newWebsite.getUrl());
        }
    }

    public void cancelSubscription(User user, Website website) {
        if (subscriptions.containsKey(user)) {
            subscriptions.get(user).remove(website);
            websiteSubscribers.get(website).remove(user);
            System.out.println(user.getName() + " canceled the subscription for: " + website.getUrl());
        }
    }


}
