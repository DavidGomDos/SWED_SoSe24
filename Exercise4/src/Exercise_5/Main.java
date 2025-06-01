package Exercise_5;
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Mike", "Mike.com", "sms");
        User user2 = new User("NotMike", "NotMike.com", "email");
        Website website1 = new Website("hello.com");
        Website website2 = new Website("goodbye.com");

        WebsiteMonitorSystem monitorSystem = new WebsiteMonitorSystem();

        monitorSystem.register(user1, website1);
        monitorSystem.register(user2, website2);

        website1.setUpdate("New update available\n");
        monitorSystem.cancelSubscription(user1, website1);
        monitorSystem.modifySubscription(user1, website1, website2);
        website2.setUpdate("Another update available\n");
    }
}