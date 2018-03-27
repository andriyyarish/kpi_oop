package learn;

import learn.observer.*;

import java.util.Arrays;
import java.util.Collection;

public class App {
    public static void main(String[] args) {
        Collection<String> msg = Arrays.asList("hello", "update one", "good news", "bad news");
        Source<String> source = new Twiter(msg);
        Publisher publisher = new PublisherImpl(source);

        Subscriber<String> subscriberA = new ConcreteSubscriberA("Jimmy");
        Subscriber<String> subscriberA2 = new ConcreteSubscriberA("Donald");
        Subscriber<String> subscriberB = new ConcreteSubscriberB("Bob");

        publisher.subscriBe(subscriberA);
        publisher.subscriBe(subscriberB);

        publisher.provideUpdate();

        Collection<String> newMsg = Arrays.asList("second part", "second good news");
        ((Twiter)source).addMessages(newMsg);

        publisher.subscriBe(subscriberA2);
        publisher.provideUpdate();

        publisher.unsubscribe(subscriberA);
        Collection<String> lastMsg = Arrays.asList("the last nems");
        ((Twiter)source).addMessages(lastMsg);
        publisher.provideUpdate();


    }
}
