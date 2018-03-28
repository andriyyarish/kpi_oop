package learn.observer.subscribe;

public abstract class Subscriber<T> {
    protected final String name;

    protected Subscriber(String name) {
        this.name = name;
    }

    public abstract void update(T val);

}
