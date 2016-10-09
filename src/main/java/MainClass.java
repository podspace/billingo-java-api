import exceptions.BillingoException;


public class MainClass {
    public static void main(String[] args) throws BillingoException {
        Billingo billingo = new Billingo("public", "private", "cli");
        System.out.println(billingo.getClients());
    }
}
