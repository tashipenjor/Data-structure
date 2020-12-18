import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root; 
    int size=0;            // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
               // number of nodes in subtree

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
          
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    // public Solution() {
    // }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        
        if(size==0){
            return true;
        }
        return false;
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;

      
       
    }

    // return number of key-value pairs in BST rooted at x
    // private int size(Node x) {

    //     if (x == null) return 0;
    //     else return x.size;
       
    // }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public Value get(Key key) {
    //     return get(root, key);
        
    // }

    public Value get(Key key) {
        if(key==null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        Node t=root;
        while(t.key!=key){

            int cmp=key.compareTo(t.key);
            
            if(cmp<0){
             t=t.left;
            }
            else if(cmp>0){
             t=t.right;
            }
        }
        if(t.key==key){
            return t.val;
        }
        return t.val;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the
     * old value with the new value if the symbol table already contains the
     * specified key. Deletes the specified key (and its associated value) from this
     * symbol table if the specified value is {@code null}.
     *
     * @param key  the key
     * @param val  the value
     * @param size
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
     public void put(Key key, Value val) {
        Node newNode = new Node(key,val);
        if(root == null)root = newNode;
        else{
            Node curNode = root;
            Node parent;
            while(true){
                parent = curNode;
                int cmp = key.compareTo(curNode.key);
                if(cmp < 0){
                    curNode = curNode.left;
                    if(curNode == null){
                        parent.left = newNode;
                        size = size + 1;
                        return;
                    }
                    else if(curNode.key == key){
                        curNode.val = val;
                        return;
                    }
                }
                else if(cmp > 0){
                    curNode = curNode.right;
                    if(curNode == null){
                        parent.right = newNode;
                        size = size + 1;
                        return;
                    }
                    else if(curNode.key == key){
                        curNode.val = val;
                        return;
                    }
                }
            }
        }
        size = size + 1;
    }

   

    // /**
    //  * Returns the smallest key in the symbol table.
    //  *
    //  * @return the smallest key in the symbol table
    //  * @throws NoSuchElementException if the symbol table is empty
    //  */
    public Key min() {
        if(isEmpty()==true) throw new NoSuchElementException("NO Key! Program cannot find MIN");
        else {
            Node t=root;
            while(t.left!=null){
                t=t.left;
            }
            return t.key;
        }
       
    } 

    public Key max() {

       if(isEmpty()){
        throw new NoSuchElementException("There is no element in the tree");
       }
       else{
            Node t = root;
            while(t.left != null){
                t = t.left;
            }
            return t.key;
       }

    }


    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if(isEmpty()){
            throw new NoSuchElementException("No element.");
        }
        Node t = root;
        Node newest = null;
        while(t != null){
            newest = t;
            int cmp = key.compareTo(newest.key);
            if(key == null){
                throw new IllegalArgumentException("calls floor() with a null key");
            }
            if(cmp == 0){
                return newest.key;
            }
            if(cmp < 0){
                t = newest.left;
            } 
            else if(cmp > 0){
                t = newest.right;
                int cm = key.compareTo(t.key);
                if(cm < 0){
                    return newest.key;
                }
                else{
                    t = newest.right;
                }
            }
        }
        return newest.key;
    } 

    // private Node floor(Node x, Key key) {
    //     return null;
       
    // } 

     public Key select(Key key){
        if(isEmpty()){
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node t = root;
        Node newest = null;
        while(t != null){
            newest = t;
            int cmp = key.compareTo(newest.key);
            if(key == null){
                throw new IllegalArgumentException("calls floor() with a null key");
            }
            if(cmp > 0){
                t = newest.right;
            }
            //This condition is for checking floor of given key in left side
            else if(cmp < 0){
                t = newest.left;
                //This condition checks if key is greater than left parent then it returns the curNode 
                int cm = key.compareTo(newest.key);
                if(cm > 0 ){
                    return t.key;
                }
                //This is for if the key is still less then left parent
                else{
                    t = newest.left;
                } 
            }
        }
        return newest.key;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
     
    } 

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        if (x == null)  
        return;  
    
        Node curNode = x;
        int cm = lo.compareTo(curNode.key);
        int cmp = hi.compareTo(curNode.key);
          
      
        while (curNode != null) {  
      
            if (curNode.left == null)  
            {   
                if (cm <= 0 && cmp >= 0)  queue.offer(curNode.key);    
                curNode = curNode.right;  
            }  
      
            else {  
                Node pre = curNode.left;    
                while (pre.right != null && pre.right != curNode)  
                    pre = pre.right;  
      
                if (pre.right == null)  
                {  
                    pre.right = curNode;  
                    curNode = curNode.left;  
                }  
                else {  
                    pre.right = null;    
                    if (cm <= 0 && cmp >= 0)  queue.offer(curNode.key);   
                    curNode = curNode.right;  
                }  
            }
        }
        
    }


    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    // public Key select(int k) {
        
    // }

    // // Return key of rank k. 
    // private Node select(Node x, int k) {
        
         
    // } 

   

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    // public Iterable<Key> keys(Key lo, Key hi) {
     
    // } 

    // private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        
    // } 

   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 

       Solution <String, Integer> obj = new Solution <String, Integer>();
        obj.put("Ada",1);
        obj.put("Ballerina",3);
        System.out.println(obj.get("Ada"));
        obj.put("Html",5);
        obj.put("Java",7);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("Ballerina"));
       // System.out.println(obj.select(3));
        obj.keys("Ada","Java");
        System.out.println();
        obj.put("Java",8);
        obj.put("Dart",9);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        System.out.println(obj.keys("Ballerina","Java"));

        
     }
}