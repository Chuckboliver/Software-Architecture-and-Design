import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();
        StringSubscriber alphabetSubscriber = new AlphabetSubscriber();
        StringSubscriber numberSubscriber = new NumberSubscriber();
        StringSubscriber symbolSubscriber = new SymbolSubscriber();
        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(numberSubscriber);
        publisher.subscribe(symbolSubscriber);

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("String input : ");
            String str = scanner.nextLine();
            if(str.equals("/quit")) {
                publisher.unsubscribe(alphabetSubscriber);
                publisher.unsubscribe(numberSubscriber);
                publisher.unsubscribe(symbolSubscriber);
                System.out.println("Quit!!!");
                break;
            }
            else {
                publisher.publish(str);
            }
        }
    }
}
