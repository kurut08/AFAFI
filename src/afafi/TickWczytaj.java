package afafi;
//Przykładowy sposób wczytywania
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Clock;
import java.util.Scanner;
public class TickWczytaj {
    public static void Wczytaj() {
        try {
            String data = "";
            File myObj = new File("zapis.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

            long y = Clock.systemUTC().millis();
            long x = Long.parseLong(data);
            System.out.println(y);
            System.out.println(x);
            System.out.println("Od uruchomienia minely "+((y-x)/100)+" ticki");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}