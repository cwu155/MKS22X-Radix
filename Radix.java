import java.util.*;

public class Radix{
  public static MyLinkedList[] buckets = new MyLinkedList[10];
  public static String testResult = "[";
  public static int max, maxDigits;


  //Prints out buckets hopefully??
  public static String debug(){
    String result = "";
    for (MyLinkedList bucket : buckets){
      result += bucket + " ";
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

  }

  public static void main(String[] args) {
    int[] test = {13, 14, 22, 3, 16, 19, 20};
    for (int i = 0; i < test.length; i++){
      testResult += test[i] + " ";
    }
    testResult += "]";

    System.out.println("List: " + testResult);
    System.out.println(maxDigits(test)); //testing digits
  }
}
