package Exercise_4;

//import Exercise_4.Website;
//import Exercise_4.websiteMonitorSystem;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        websiteMonitorSystem monitor = new websiteMonitorSystem();
      Website jedipedia = new Website("https://jedipedia.fandom.com/wiki/Jedipedia:Hauptseite");
      Website cnn = new Website("https://edition.cnn.com");
        try {
            System.out.println(jedipedia.getHtml());
            System.out.println(cnn.getHtml());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }  // Brauche ich einen try-catch block für jede Webseite ??


        User mike = new User("Mike","mike@gmail.com","e-mail");
        User Harry = new User("Harry","harry@gmail.com","sms-boomer");
        monitor.register(Harry,jedipedia);
        monitor.register(Harry,cnn);
        monitor.register(mike,jedipedia);
    }
}

