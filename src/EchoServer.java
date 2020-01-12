import EchoApp.EchoPOA;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EchoServer extends EchoPOA {

    final AtomicInteger runningCount = new AtomicInteger(0);
    final Integer limit = 1;
    final String ErrorMessage = "limit exceeded";

    @Override
    public String echoString() {
        if (runningCount.incrementAndGet() <= limit) { //increment number of clients and check

            doSomeThing();
            runningCount.decrementAndGet();
            return "Hello World!!!!!!!";

        } else {
            runningCount.decrementAndGet();
            System.out.println(ErrorMessage);
            return ErrorMessage;
        }

    }

    private void doSomeThing() {
        try {
            for (int i = 1; i < 5; i++) {
                Thread.sleep(i * 1000);
                System.out.println("sleep " + i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
