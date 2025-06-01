package Exercise_6;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Mike", "Mike.com", "sms");
        User user2 = new User("NotMike", "NotMike.com", "email");
        Website website1 = new Website("hello.com");
        Website website2 = new Website("goodbye.com");

        //Website Dummy
        website1.setHtmlContent("<html><body>Hello</body></html>");
        website2.setHtmlContent("<html><body>Hello</body></html>");


        WebsiteMonitorSystem monitorSystem = new WebsiteMonitorSystem();

        monitorSystem.register(user1, website1);
        monitorSystem.register(user2, website2);
        //Update Dummy
        website1.setUpdate("New update available\n");

        monitorSystem.cancelSubscription(user1, website1);
        monitorSystem.modifySubscription(user1, website1, website2);
        website2.setUpdate("Another update available\n");

        // Compare websites
        CompareWebsite contentSizeStrategy = new ContentSizeComparisonStrategy();
        CompareWebsite htmlContentStrategy = new HtmlContentComparisonStrategy();
        CompareWebsite textContentStrategy = new TextContentComparisonStrategy();

        boolean areIdenticalBySize = monitorSystem.compareWebsites(website1, website1, contentSizeStrategy);
        boolean areIdenticalByHtml = monitorSystem.compareWebsites(website2, website2, htmlContentStrategy);
        boolean areIdenticalByText = monitorSystem.compareWebsites(website1, website1, textContentStrategy);

        String str = Boolean.toString(areIdenticalByHtml);
        System.out.println(str);
        System.out.println("Websites identical by size: " + areIdenticalBySize);
        System.out.println("Websites identical by HTML: " + areIdenticalByHtml);
        System.out.println("Websites identical by text: " + areIdenticalByText);
    }
}
