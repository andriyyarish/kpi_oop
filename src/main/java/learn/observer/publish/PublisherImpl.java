package learn.observer.publish;

import learn.observer.Source;
import learn.observer.subscribe.Subscriber;

import java.util.LinkedList;
import java.util.List;

public class PublisherImpl implements Publisher {
    private final List<Subscriber> subscribers = new LinkedList<>();
    private final Source<String> source;

    public PublisherImpl(Source<String> source) {
        this.source = source;
    }

    @Override
    public void subscribe(Subscriber s){
        subscribers.add(s);
    }

    @Override
    public void unsubscribe(Subscriber s){
        subscribers.remove(s);
    }

    @Override
    public void notifySubscribers(){
        getMsgFromSource().
                forEach(msg -> subscribers.forEach(sb -> sb.update(msg)));

    }

    private List<String> getMsgFromSource(){
        List<String> res = new LinkedList<>();
        while (source.hasNext())
            res.add(source.get());
        return res;
    }
}
