package ClassMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {


    public static void main(String[] args) {

        Map<Object, Object> map1 = new HashMap<>();

        map1.put("city", "philadelphia");
        map1.put("zipCode", 19147);
        System.out.println("this is teh map :" + map1);


        Object[] entriesArray1 = map1.entrySet().toArray(new Map.Entry[0]);

        for (Object entry1 : entriesArray1) {
            System.out.println("Key-Value Pairs Array: : " + entry1);
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "alex");
        map.put(2, "lora");

        //Convert and Print Keys as an Array
        Integer[] keysArray = map.keySet().toArray(new Integer[0]);
        System.out.println("Keys Array: " + Arrays.toString(keysArray));

        //Convert and Print Values as an Array
        String[] valuesArray = map.values().toArray(new String[0]);
        System.out.println("Values Array: " + Arrays.toString(valuesArray));

        //Convert and Print Key-Value Pairs as an Array
        String[] entriesArray = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .toArray(String[]::new);

        System.out.println("Entries Array: " + Arrays.toString(entriesArray));


        // Convert map to an array of Map.Entry
        Map.Entry<Integer, String>[] entryArray = map.entrySet().toArray(new Map.Entry[0]);
        // Print the array
        for (Map.Entry<Integer, String> entry : entryArray) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }


    }
}






