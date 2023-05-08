package afafi;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.Clock;

public class TickZapisz {
    public static void Zapisz() {
        try {
            File file = new File("zapis.txt");
            if (file.createNewFile()) {
                System.out.println("Utworzono zapis");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("zapis.txt");
            long tick = Clock.systemUTC().millis();
            myWriter.write(""+tick);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}