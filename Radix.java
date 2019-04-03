import java.util.*;

public class Radix{
  @SuppressWarnings("unchecked")
  public static MyLinkedList<Integer> [] buckets = new MyLinkedList[20];
  public static String testResult = "[";
  public static int max, maxDigits;


  //Prints out buckets hopefully??
  public static String debug(){
    String result = "";

    for (int i = 0; i < 20; i++){
      result += "Bucket " + i + ": " + buckets[i] + '\n';
    }
    return result;
  }

  public static int maxDigits(int[] data){
    for (int i = 0; i < data.length; i++){
      if (data[i] >= max){
        max = data[i];
      }
    }
    return ((int) Math.log10(max) + 1);
  }

  public static void radixsort(int[]data){
    //Instantiate buckets
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

    //Put numbers into respective buckets
    for (int i = 0; i < data.length; i++){
      if (data[i] > 0){ //positive number
        buckets[(data[i] % 10) + 10].add(data[i]);
      } else { //negative number
        buckets[-(data[i] % 10)].add(data[i]);
      }
    }

  }

  public static void main(String[] args) {
    //int[] test = {13, 14, 22, 3, 16, 19, 20};
    int[] test = {-100, 13, 14, 429, -12, 37, 46, 1, 288};
    for (int i = 0; i < test.length; i++){
      testResult += test[i] + " ";
    }
    testResult += "]";

    radixsort(test);
    System.out.println("List: " + testResult);
    System.out.println(debug());
  }
}
