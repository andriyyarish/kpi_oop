package learn.observer;

public interface Publisher {
    void subscriBe(Subscriber s);

    void unsubscribe(Subscriber s);

    void provideUpdate();
}
