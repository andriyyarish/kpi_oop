package learn.observer;

public interface Source <T> {
    boolean hasNext();
    T get();
}
