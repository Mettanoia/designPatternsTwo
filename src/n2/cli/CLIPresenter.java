package n2.cli;

import n2.shoes_store.ShoeStore;

import java.util.function.Function;

final public class CLIPresenter {

    private final ShoeStore shoeStore;

    public CLIPresenter(ShoeStore shoeStore) {
        this.shoeStore = shoeStore;
    }

    public void printData(Function<Double, String> formatter) {

        double total = shoeStore.getOrder().stream()
                .mapToDouble(shoe -> shoe.price)
                .reduce(0, Double::sum);

        System.out.println("Total: " + formatter.apply(total));

    }

}
