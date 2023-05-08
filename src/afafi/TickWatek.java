package afafi;

import java.time.*;
public class TickWatek extends Thread {
    public void run() {
        Clock clock = Clock.systemUTC();
        Duration duration = Duration.ofNanos(1000);
        Clock clock1 = Clock.offset(clock, duration);
        long start = clock.millis();
        long stop = clock1.millis();
        while(true) {
            stop = clock1.millis();
            if (stop - start > 1000) {
                start = stop;
                System.out.println("Tick");
                stop = clock1.millis();
            }
        }
    }
}
