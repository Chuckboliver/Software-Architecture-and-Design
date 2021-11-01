import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String> {
    public abstract void onSubscribe(Flow.Subscription subscription);

    public abstract void onNext(String str);

    public abstract boolean checkString(String str);

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public void onComplete() {
        System.out.println("Done!!!");
    }
}
