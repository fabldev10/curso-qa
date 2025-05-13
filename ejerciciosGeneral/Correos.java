import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class Correos {
    public static void main(String[] args) {
        ArrayList<String> correos = new ArrayList<>();
        HashSet<String> correosHS = new HashSet<>(3);
        correos.add("fabian@gmail.com");
        correos.add("juan@gmail.com");
        correos.add("juan@gmail.com");
        correos.add("fabian@gmail.com");
        correos.add("julian@gmail.com");

       
        HashSet<String> uniqueEmails = removeDuplicates(correos);

        System.out.println("Correos electrónicos únicos:");
        for (String email : uniqueEmails) {
            System.out.println(email);
        }
    }

    public static HashSet<String> removeDuplicates(Collection<String> correos) {
        return new HashSet<>(correos); 
    }

    
}