
abstract class AuthorizationHandler {
    protected AuthorizationHandler nextHandler;

    public void setNextHandler(AuthorizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void authorize(double amount);
}
class Cashier extends AuthorizationHandler {
    @Override
    public void authorize(double amount) {
        if (amount < 10000) {
            System.out.println("Cashier authorized withdrawal of Tk. " + amount);
        } else if (nextHandler != null) {
            System.out.println("Cashier forwarded withdrawal of Tk. " + amount);
            nextHandler.authorize(amount);
        } 
    }
}

class SeniorOfficer extends AuthorizationHandler {
    @Override
    public void authorize(double amount) {
        if (amount >= 10000 && amount <= 1000000) {
            System.out.println("Senior Officer authorized withdrawal of Tk. " + amount);
        } else if (nextHandler != null) {
            System.out.println("Senior Officer authorized withdrawal of Tk. " + amount);
            System.out.println("Senior Officer forwarded withdrawal of Tk. " + amount);
            nextHandler.authorize(amount);
        } 
    }
}

class Manager extends AuthorizationHandler {
    @Override
    public void authorize(double amount) {
        if (amount > 1000000) {
            System.out.println("Manager authorized withdrawal of Tk. " + amount);
        } 
    }
}


public class Main {
    public static void main(String[] args) {
       
        AuthorizationHandler cashier = new Cashier();
        AuthorizationHandler seniorOfficer = new SeniorOfficer();
        AuthorizationHandler manager = new Manager();

        
        cashier.setNextHandler(seniorOfficer);
        seniorOfficer.setNextHandler(manager);

        
        System.out.println("Attempting to withdraw Tk. 5,000:");
        cashier.authorize(5000);

        System.out.println("\nAttempting to withdraw Tk. 50,000:");
        cashier.authorize(50000);

        System.out.println("\nAttempting to withdraw Tk. 15,00,000:");
        cashier.authorize(1500000);
    }
}
