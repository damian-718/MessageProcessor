import java.util.*;
import java.util.stream.Collectors;

public class NameFilter2 implements Runnable{

    private ArrayList<String> names = new ArrayList<>();

    public NameFilter2(ArrayList<String> names){
        this.names = names;
    }

    @Override
    public void run(){

        // // think of this like for each name in names
        // for (String name : names) {
        //     if (name.length() > 3) {
        //         String processed = name.toUpperCase();
        //         System.out.println(processed);
        //     }
        // }

        // // names.length for array, length() for string length, size() for arraylist
        // for (int i = 0; i < names.size(); i++) {
        //     if (names.get(i).length() > 3) {
        //         String processed = names.get(i).toUpperCase();
        //         System.out.println(processed);
        //     }
        // }

        // Map<String, String> map = new HashMap<>();
        // map.put("A", "B");
        // map.put("C", "D");

        Map<String, String> result = names.stream()
                .filter(name -> name.length() > 3)   // keep names longer than 3
                .collect(Collectors.toMap(
                        name -> name,                // key: original name
                        name -> name.toUpperCase()   // value: processed name
                ));

        // result is a map (aka dictionary) not arraylist
        result.forEach((k, v) -> System.out.println(k + " -> " + v));
        
    }
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Tom", "Jerry", "Amy", "Christopher", "Max", "John"));

        NameFilter2 filter = new NameFilter2(names);
        Thread thread = new Thread(filter);

        thread.start();
    }
}