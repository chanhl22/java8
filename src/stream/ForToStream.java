package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForToStream {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);

        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            arr2.add(arr1.get(i));
        }

        System.out.println(arr2);

        List<Integer> arr3 = arr1.stream()
                .collect(Collectors.toList());

        System.out.println(arr3);
    }
}
