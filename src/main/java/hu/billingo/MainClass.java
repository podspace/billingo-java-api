package hu.billingo;

import com.fasterxml.jackson.core.type.TypeReference;
import hu.billingo.exceptions.BillingoException;
import hu.billingo.models.Client;


public class MainClass {
    public static void main(String[] args) throws BillingoException {
        Client c = Json.fromJson("{\"name\":\"test\",\"email\":\"test@me.me\",\"taxcode\":\"12345678901\",\"billing_address\":{\"street_name\":\"Alma\",\"street_type\":\"street\",\"house_nr\":\"23\",\"block\":\"A\",\"entrance\":\"2\",\"floor\":\"1\",\"door\":\"3\",\"city\":\"Hatvan\",\"postcode\":\"3000\",\"country\":\"Magyar ország\"}}",
            new TypeReference<Client>() {
            });

        Billingo billingo = new Billingo("public",
            "private",
            "cli");

        System.out.println(billingo.createClient(c));
        System.out.println(billingo.getClients());
    }
}
