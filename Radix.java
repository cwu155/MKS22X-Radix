import java.util.*;

public class Radix{
  @SuppressWarnings("unchecked")
  // public static MyLinkedList<Integer> [] buckets = new MyLinkedList[20];
  // public static MyLinkedList<Integer> temp = new MyLinkedList<Integer>();
  public static int digit,max;

  public static int maxDigits(int[] data){
    for (int i = 0; i < data.length; i++){
      if (Math.abs(data[i]) >= max){
        max = Math.abs(data[i]);
      }
    }
    return ((int) Math.log10(max) + 1);

    //Alternative - seems slower
    // String s;
    // for (int i = 0; i < data.length-1; i++){
    //   s = Integer.toString(Math.abs(data[i]));
    //   if (s.length() < (Integer.toString(Math.abs(data[i+1])).length())){
    //     max = Integer.toString(Math.abs(data[i+1]));
    //   }
    // }
    // return max.length();
  }

  public static void radixsort(int[]data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer> [] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();

    //Instantiate buckets
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

    digit = 0;
    while (digit < maxDigits(data)) { //each pass through the array

      //Put numbers into respective buckets
      for (int i = 0; i < data.length; i++){
        if (data[i] > 0){ //positive number
          if (digit == 0){
            buckets[(data[i] % 10)].add(data[i]);
          } else {
            buckets[(int)(data[i]/Math.pow(10, digit)) % 10].add(data[i]);
          }
        } else { //negative number
          if (digit == 0){
            buckets[-(data[i] % 10)].add(data[i]);
          } else {
            buckets[(int)(data[i]/Math.pow(10, digit)) % 10].add(data[i]);
          }
        }
      }

      //Link all buckets
      for (int i = 0; i < 20; i++){
        temp.extend(buckets[i]);
        buckets[i].clear();
      }

      //Reform data
      int orig = temp.size();
      for (int i = 0; i < orig; i++){
        data[i] = temp.removeFront();
      }

      digit++;
    }
  }

  public static void main(String[] args) {
    // int[] test = {23, 33, 13, 14, 19, 44, -12, -22, 1};
    // radixsort(test);
    // for (int i = 0; i < test.length; i++){
    //   testResult += test[i] + " ";
    // }
    // testResult += "]";
    //System.out.println("Sorted? List: " + testResult);
    // System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    // int[]MAX_LIST = {1000000000,500,10};
    // for(int MAX : MAX_LIST){
    //   for(int size = 31250; size < 2000001; size*=2){
    //     long qtime=0;
    //     long btime=0;
    //     //average of 5 sorts.
    //     for(int trial = 0 ; trial <=5; trial++){
    //       int []data1 = new int[size];
    //       int []data2 = new int[size];
    //       for(int i = 0; i < data1.length; i++){
    //         data1[i] = (int)(Math.random()*MAX);
    //         data2[i] = data1[i];
    //       }
    //       long t1,t2;
    //       t1 = System.currentTimeMillis();
    //       radixsort(data2);
    //       t2 = System.currentTimeMillis();
    //       qtime += t2 - t1;
    //       t1 = System.currentTimeMillis();
    //       Arrays.sort(data1);
    //       t2 = System.currentTimeMillis();
    //       btime+= t2 - t1;
    //       if(!Arrays.equals(data1,data2)){
    //         System.out.println("FAIL TO SORT!");
    //         System.exit(0);
    //       }
    //     }
    //     System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    //   }
    //   System.out.println();
    // }
    System.out.println((48723/100) % 10);

  }
}
