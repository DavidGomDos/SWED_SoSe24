public class User {
   private String name;
   private String email;
   private String channel;


   //Constructor
   User( String name, String email, String channel){
      this.name = name;
      this.email = email;
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

}
