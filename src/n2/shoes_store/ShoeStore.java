package n2.shoes_store;

import n2.payment_gateway.PaymentGateway;

import java.util.Set;

public final class ShoeStore {

    private Set<Shoe> order;
    private final PaymentGateway paymentGateway;

    public ShoeStore(Set<Shoe> order, PaymentGateway paymentGateway) {
        this.order = Set.copyOf(order);
        this.paymentGateway = paymentGateway;
    }

    public Set<Shoe> getOrder() {
        return Set.copyOf(order);
    }

    public void addShoeToOrder(Shoe shoe) {
        order.add(shoe);
    }

    public void processOrder() {
        paymentGateway.pay(
                order.stream()
                        .mapToDouble(shoe -> shoe.price)
                        .reduce(0.0, Double::sum)
        );
    }

}
