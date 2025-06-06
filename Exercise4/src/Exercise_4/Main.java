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
            System.out.println(jedipedia.getHtml());
             jedipediaHtml = jedipedia.getHtml();
            System.out.println(cnn.getHtml());
             cnnHtml = cnn.getHtml();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }  // Brauche ich einen try-catch block für jede Webseite ??

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(jedipedia.getHtml());
           jedipediaHtml = jedipedia.getHtml();
            System.out.println(cnn.getHtml());
            cnnHtml = cnn.getHtml();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }  // Brauche ich einen try-catch block für jede Webseite ??



        boolean changed1 = false;
        boolean changed2 = false;
        try {
            changed1 = jedipedia.hasChanged();
            changed2 = cnn.hasChanged();
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (changed1 == true){
            System.out.println("jedipedia hat ein update");
        }else{
            System.out.println("jedipedia ist gleich");}


        User mike = new User("Mike","e-mail","mike@gmail.com");
        User Harry = new User("Harry","sms-boomer","harry@gmail.com");
        monitor.register(Harry,jedipedia);
        monitor.register(Harry,cnn);
        monitor.register(mike,jedipedia);
    }
}

