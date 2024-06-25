package n1.common;

import java.util.Set;

public abstract class PublisherSkeleton implements Publisher {

    protected Set<Subscriber> subscribers;

    protected PublisherSkeleton(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void notifySuscribers() {
        subscribers.forEach(Subscriber::update);
    }

}
