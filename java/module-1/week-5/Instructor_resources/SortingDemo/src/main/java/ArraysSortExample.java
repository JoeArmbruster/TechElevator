import java.util.Arrays;

public class ArraysSortExample {

    public static void main(String[] args) {

        //String arr[] ={"duck", "eagle", "chicken", "Kingfisher", "bluebird"};
        int arr[] = {5, 8, 4, 6, 2, 1, 6};

        System.out.println("Array Before Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Arrays.sort(arr);  // but how does Arrays.sort() know what order we want?
        // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
        // what happens if we capitalize?

        System.out.println("Array After Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}