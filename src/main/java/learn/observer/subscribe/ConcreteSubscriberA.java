package learn.observer.subscribe;

public class ConcreteSubscriberA extends Subscriber<String> {

    public ConcreteSubscriberA(String name) {
        super(name);
    }

    @Override
    public void update(String val) {
        System.out.println(String.format("Subscriber %s type(A): recieved msg -> %s", name, val));
    }
}
