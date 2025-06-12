package Exercise_4;

public class User {
   private String name;
   private String email;
   private String sms;
   private String channel;


   //Constructor
   User( String name, String channel, String email,String sms){
      this.name = name;
      this.email = email;
      this.sms = sms;
      this.channel = channel;


   }

   //Getter
   public String getName(){
      return name;
   }

   public String getEmail(){
      return email;
   }

   public String getChannel(){
         return channel;
   }
   public String getSms(){return sms;}

   //Setter
   public void setName(String name){
      this.name = name;
   }

   public void setEmail(String email){
      this.email =email;
   }
   public void setChannel(String channel){
      this.channel = channel;
   }
   public void setSms(String sms){this.sms = sms;}

}
