import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String> {

    private Set<Flow.Subscriber<? super String>> subscriberSet;

    public StringPublisher() {
        this.subscriberSet = new LinkedHashSet<>();
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        this.subscriberSet.add(subscriber);
    }

    public void unsubscribe(Flow.Subscriber<? super String> subscriber) {
        this.subscriberSet.remove(subscriber);
    }

    public void publish(String str) {
        for(Flow.Subscriber<? super String> subscriber: this.subscriberSet) {
            if(((StringSubscriber)subscriber).checkString(str)) {
                subscriber.onNext(str);
            }
        }
    }
}
