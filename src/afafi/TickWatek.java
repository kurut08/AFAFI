package afafi;

import java.time.*;
public class TickWatek extends Thread {
    public long start, stop;
    public void run() {
        Clock clock = Clock.systemUTC();
        Duration duration = Duration.ofNanos(1000);
        Clock clock1 = Clock.offset(clock, duration);
        start = clock.millis();
        stop = clock1.millis();
        while(true) {
            start = clock1.millis();
        }
    }

    public long getStart() {
        return start;
    }
    public long getStop() {
        return stop;
    }
}
