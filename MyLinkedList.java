public class MyLinkedList{
  private class Node{
    private Node next, prev;
    private Integer data;

    public Node (Integer value, Node start, Node end){
      prev = start;
      next = end;
      data = value;
    }
      public Node next(){
        return next;
      }
      public Node prev(){
        return prev;
      }
      public void setNext(Node other){
        next = other;
      }
      public void setPrev(Node other){
        prev = other;
      }
      public Integer getData(){
        return data;
      }
      public Integer setData(Integer i){
        data = i;
        return data;
      }
      public String toString(){
        return Integer.toString(data);
      }
    }

    private Node start;
    private Node end;
    private int length;

    public MyLinkedList(){
      start = end;
      length = 0;
    }

    public void clear(){
      start = null;
      end = null;
      length = 0;
    }

    public int size(){
      return length;
    }

    public String toString(){
      String result = "";
      int i = 0;
      Node current = start;
         while (current != null && i < length-1){
           result += current.getData() + ", ";
           current = current.next();
           i++;
         }
      return "[" + result + end + "]";
    }

    private Node getNthNode(int index){
      Node current = start;
      Node result = current;

      for (int i = 0; i < length; i++){
        if (i == index){
          result = current;
        } else {
          current = current.next();
        }
      }
      return result;
    }

    public boolean add(Integer value){
        Node newNode = new Node(value, start, end);
        Node newEndNode = new Node(value, start, null);
        if (start == null){
          start = newNode;
          end = newNode;
        } else {
          end.setNext(newEndNode);
          end = end.next();
          end.setPrev(end.prev());
        }
        length += 1;
        return true;
    }


    public void add(int index, Integer value){
      if (index > length || index < 0){
        System.out.println("Bad index value!");
      } else if (index == 0){
        Node newNode = new Node (value, null, start);
        start = newNode;
        length += 1;
      } else {
        Node original = this.getNthNode(index);
        Node originalPrev = this.getNthNode(index-1);
        Node newNode = new Node(value, originalPrev, original);
        original.setPrev(newNode);
        originalPrev.setNext(newNode);
        length += 1;
      }
    }

    public void extend(MyLinkedList other){
        int thisSize = this.size();
        int otherSize = other.size();
        Node end = this.end;
        end.setNext(other.start);
        (other.start).setPrev(end);
        this.length += other.length;
      }

    public static void main(String[] args) {
      MyLinkedList test = new MyLinkedList();
      MyLinkedList other = new MyLinkedList();
      for (int i = 0; i < 10; i++){
        test.add(i);
        other.add(-i);
      }

      test.extend(other);

      System.out.println("Test Size: " + test.size());
      System.out.println(test);
      System.out.println("---------------------------");
      System.out.println("Other Size: " + other.size());
      System.out.println(other);

    }
  }
