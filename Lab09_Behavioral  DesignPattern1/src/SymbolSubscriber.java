import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribe to " + subscription);
    }

    @Override
    public void onNext(String str) {
        System.out.println("Symbol in " + str);
        try {
            FileWriter writer = new FileWriter("symbol.txt", true);
            PrintWriter printer = new PrintWriter(writer);
            printer.println(str);
            printer.close();
            writer.close();
            System.out.println("Write successful");
        } catch (IOException e) {
            System.out.println("Error!!!");
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkString(String str) {
        return str.matches(".*[!-/:-@\\[-`{-~].*");
    }
}
