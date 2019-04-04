public class MyLinkedList<E>{
  public class Node{
    private Node next, prev;
    private E data;

    @SuppressWarnings("unchecked")
    public Node (E value, Node start, Node end){
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
      public E getData(){
        return data;
      }
      public E setData(E i){
        data = i;
        return data;
      }
      public String toString(){
        return "" + data;
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
      if (length == 0){
        return "[]";
      }

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

    public boolean add(E value){
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

    public E removeFront(){
        Node remove = this.start;
        if (length == 1){
          start = null; end = null;
        } else {
          start = start.next();
        }
        length -= 1;
        return remove.getData();
    }

    public void extend(MyLinkedList<E> other){

      if (other.length == 0){
        return;
      }

      if (length == 0) {
       start = other.start;
      } else {
        int thisSize = this.size();
        int otherSize = other.size();
        end.setNext(other.start);
        (other.start).setPrev(end);
      }
        this.end = other.end;
        this.length += other.length;
    }

    public static void main(String[] args) {
      MyLinkedList test = new MyLinkedList();
      MyLinkedList other = new MyLinkedList();

      System.out.println("Test: " + test);
      System.out.println("Other: " + other);


      for (int i = 0; i < 1; i++){
        test.removeFront();
        //other.removeFront();
      }

      System.out.println("Test Size: " + test.size());
      System.out.println(test);
      System.out.println("---------------------------");
      System.out.println("Other Size: " + other.size());
      System.out.println(other);

    }
  }
