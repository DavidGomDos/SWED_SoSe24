public class Website {
    private String url;
    private String update;
    //Constructor
    Website(String url){
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


}
