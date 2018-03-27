package learn.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Twiter implements Source<String> {

    private final Collection<String> messagesStream;
    private int currentMsgIndex = -1;

    public Twiter(Collection<String> list){
        messagesStream = new ArrayList<String>(list);
    }

    public boolean hasNext() {
        return currentMsgIndex < messagesStream.size()-1;
    }

    public String get() {
        currentMsgIndex ++;
        return ((ArrayList<String>)messagesStream).get(currentMsgIndex);
    }

    public void addMessages(Collection<String> msg){
        messagesStream.addAll(msg);
    }
}
