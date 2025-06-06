package Exercise_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WebsiteMonitorSystem {
    private final Map<User, List<Website>> subscriptions;

    public WebsiteMonitorSystem() {
        this.subscriptions = new HashMap<>();
    }

    public void register(User user, Website website) {
        subscriptions.putIfAbsent(user, new ArrayList<>());
        subscriptions.get(user).add(website);
        website.addObserver(user);
        System.out.println(user.getName() + " has subscribed to " + website.getUrl());
    }

    public void modifySubscription(User user, Website oldWebsite, Website newWebsite) {
        if (subscriptions.containsKey(user)) {
            subscriptions.get(user).remove(oldWebsite);
            subscriptions.get(user).add(newWebsite);
            oldWebsite.removeObserver(user);
            newWebsite.addObserver(user);
            System.out.println(user.getName() + " modified the subscription from: " + oldWebsite.getUrl() + " to " + newWebsite.getUrl());
        }
    }

    public void cancelSubscription(User user, Website website) {
        if (subscriptions.containsKey(user)) {
            subscriptions.get(user).remove(website);
            website.removeObserver(user);
            System.out.println(user.getName() + " canceled the subscription for: " + website.getUrl());
        }
    }

    public boolean compareWebsites(Website website1, Website website2, CompareWebsite strategy) {
        return strategy.compare(website1, website2);
    }
}
