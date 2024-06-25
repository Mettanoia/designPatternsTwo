package n2.payment_gateway;

import n2.callback.Callback;

public final class PaymentGateway {

    private final Callback paymentMethod;

    public PaymentGateway(Callback paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double total){
        paymentMethod.exec();
    }

}
