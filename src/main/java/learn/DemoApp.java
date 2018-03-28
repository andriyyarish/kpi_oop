package learn;

import learn.observer.*;
import learn.observer.publish.Publisher;
import learn.observer.publish.PublisherImpl;
import learn.observer.subscribe.ConcreteSubscriberA;
import learn.observer.subscribe.ConcreteSubscriberB;
import learn.observer.subscribe.Subscriber;

import java.util.Arrays;
import java.util.Collection;

public class DemoApp {


    public static void main(String[] args) {
        Collection<String> msg = Arrays.asList("hello", "update one", "good news", "bad news");
        Source<String> source = new Twiter(msg);
        Publisher publisher = new PublisherImpl(source);

        Subscriber<String> subscriberA = new ConcreteSubscriberA("Jimmy");
        Subscriber<String> subscriberA2 = new ConcreteSubscriberA("Donald");
        Subscriber<String> subscriberB = new ConcreteSubscriberB("Bob");

        publisher.subscribe(subscriberA);
        publisher.subscribe(subscriberB);
        publisher.notifySubscribers();

        System.out.println("\nInit new msgs and add one more subscriber: ->>>>>");
        Collection<String> newMsg = Arrays.asList("second part", "second good news");
        ((Twiter)source).addMessages(newMsg);
        publisher.subscribe(subscriberA2);
        publisher.notifySubscribers();

        System.out.println("\nUnsubscribe somebody and init new msgs: ->>>>>>>>");
        publisher.unsubscribe(subscriberA);
        Collection<String> lastMsg = Arrays.asList("the last nems");
        ((Twiter)source).addMessages(lastMsg);
        publisher.notifySubscribers();


    }
}
