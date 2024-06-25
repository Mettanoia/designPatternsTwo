import n2.cli.CLIPresenter;
import n2.payment_gateway.PaymentGateway;
import n2.shoes_store.Shoe;
import n2.shoes_store.ShoeStore;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        PaymentGateway paymentGateway = new PaymentGateway(() -> System.out.println("Paying with credit card")); // Callback and Dependency Injection

        Set<Shoe> shoeSet = new HashSet<>();
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            Shoe shoe = new Shoe(20.0 + (80.0 - 20.0) * random.nextDouble()) {};
            shoeSet.add(shoe);
        }

        ShoeStore shoeStore = new ShoeStore(shoeSet, paymentGateway); // Constructor injection
        CLIPresenter cli = new CLIPresenter(shoeStore); // Constructor injection

        cli.printData(euros -> (euros * 63.07) + " ₱"); // Dependency Injection
        cli.printData(euros -> (euros * 89.51) + " ₹");

    }
}