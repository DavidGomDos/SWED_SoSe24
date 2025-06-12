package Exercise_4;

//import Exercise_4.Website;
//import Exercise_4.websiteMonitorSystem;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        websiteMonitorSystem monitor = new websiteMonitorSystem();
      Website jedipedia = new Website("https://jedipedia.fandom.com/wiki/Jedipedia:Hauptseite");
      Website cnn = new Website("https://edition.cnn.com");
        String jedipediaHtml = "";
        String cnnHtml = "";
        String jedipediaHtml2 = "";
        String cnnHtml2 ="";
        try {
            //System.out.println(jedipedia.getHtml());
             jedipediaHtml = jedipedia.getHtml();
            //System.out.println(cnn.getHtml());
             cnnHtml = cnn.getHtml();
        } catch (IOException | InterruptedException e) {
            //e.printStackTrace();
            System.out.println("HTML ERROR");
        }  // Brauche ich einen try-catch block für jede Webseite ??



        User mike = new User("Mike","e-mail","mike@gmail.com","01234");
        User harry = new User("Harry","sms-boomer","harry@gmail.com","55566");
        monitor.register(harry,jedipedia);
        monitor.register(harry,cnn);
        monitor.register(mike,jedipedia);

        monitor.cancelSubscription(harry,jedipedia);
        monitor.modifySubscription(mike,jedipedia,cnn); // mike wechselt von jedipedia zu cnn

        //while loop checks website every 45 seconds
        while (true){
        monitor.checkForUpdates(mike);
        monitor.checkForUpdates(harry);
            try {
                Thread.sleep(45000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

