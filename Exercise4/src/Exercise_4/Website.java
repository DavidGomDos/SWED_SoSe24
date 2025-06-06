package Exercise_4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;


/*
public class Website2 {
    private String url;
    private String update;
    //Constructor
    Website2(String url){
        this.url = url;
        this.update = "up to date";
    }



    //Getter
    public String getUrl(){
        return  url;
    }

    public String getUpdate(){
        return update;
    }

    //Setter
    public void setUrl(String url){
        this.url=url;
    }

    public void setUpdate(String update){
        this.update = update;
    }
}  */

public class Website {
    private String url;
    private String lastHtml = "";
    public Website(String url) {
        this.url = url;
    }

    public String getHtml() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getUrl() {
        return url;
    }

    public boolean hasChanged() throws IOException, InterruptedException{
        String aktuelleHtml = getHtml();
        boolean changed = !aktuelleHtml.equals(lastHtml);
        lastHtml=aktuelleHtml;
        return changed;
    }


}
