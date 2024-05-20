public class Main {
    public static void main(String[] args) {
       User user1 = new User("Mike","Mike.com","sms");
       User user2 = new User("NotMike","Notmike.com","e-mail");
       Website website1 = new Website("hello.com");
       Website website2 = new Website("goodybe.com");


       websiteMonitorSystem test = new websiteMonitorSystem();

       test.register(user1,website1);
       test.register((user2),website2);

       test.checkForUpdates();
       test.cancelSubscription(user1,website1);
       test.modifySubscription(user1,website1,website2);
       test.checkForUpdates();

    }


}