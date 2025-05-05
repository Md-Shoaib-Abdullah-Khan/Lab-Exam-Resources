public class NotificationFactory {
   private static NotificationFactory nf = new NotificationFactory();
   private void NotificationFactory(){

   }
   public static NotificationFactory getInstance(){
      return nf;
   }
    public Notification createNotification(String type){
        if(type .equalsIgnoreCase("SMS")){
            return new SMSnotification();
         }		
         if(type.equalsIgnoreCase("Email")){
            return new EmailNotification();
            
         } else if(type.equalsIgnoreCase("Push")){
            return new PushNotification();
            
         }
         else{
            return null;
         } 
    }
}
