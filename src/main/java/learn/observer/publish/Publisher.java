package learn.observer.publish;

import learn.observer.subscribe.Subscriber;

public interface Publisher {
    void subscribe(Subscriber s);

    void unsubscribe(Subscriber s);

    void notifySubscribers();
}
