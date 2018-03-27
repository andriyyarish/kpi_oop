package learn.observer;

public class ConcreteSubscriberB extends Subscriber<String> {

    public ConcreteSubscriberB(String name) {
        super(name);
    }

    @Override
    void update(String val) {
        System.out.println(String.format("Subscriber %s (type B): recieved msg -> %s",name, val));
    }
}
