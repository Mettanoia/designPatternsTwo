package n1.stock_market;

import n1.common.PublisherSkeleton;
import n1.common.Subscriber;

import java.util.Set;

public final class StockMarketAgent extends PublisherSkeleton {

    StockMarketAgent(Set<Subscriber> subscribers) {
        super(subscribers);
    }

    void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

}
