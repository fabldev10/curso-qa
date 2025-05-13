import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class EmailManager2 {

    public static HashSet<String> removeDuplicates(Collection<String> emails) {
        return new HashSet<>(emails);
    }

    public static Collection<String> generateRandomEmails(int count) {
        ArrayList<String> randomEmails = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String domain = "@example.com";
            String username = "user" + i;
            String email = username + domain;
            randomEmails.add(email);

            if (random.nextBoolean()) {
                // Agregar un correo duplicado al azar
                randomEmails.add(email);
            }
        }

        return randomEmails;
    }

    public static void main(String[] args) {
        Collection<String> randomEmails = generateRandomEmails(20);

        System.out.println("Correos electrónicos generados:");
        for (String email : randomEmails) {
            System.out.println(email);
        }

        HashSet<String> uniqueEmails = removeDuplicates(randomEmails);

        System.out.println("\nCorreos electrónicos únicos:");
        for (String email : uniqueEmails) {
            System.out.println(email);
        }
    }
}
