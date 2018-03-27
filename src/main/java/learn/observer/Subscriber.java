package learn.observer;

public abstract class Subscriber<T> {
    protected final String name;

    protected Subscriber(String name) {
        this.name = name;
    }

    abstract void update(T val);

}
