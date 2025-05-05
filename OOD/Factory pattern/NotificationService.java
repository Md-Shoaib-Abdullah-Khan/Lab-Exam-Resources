public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory nf =  NotificationFactory.getInstance();

       Notification n =  nf.createNotification("Email");
       n.notifyUser("sent");
    }
}
