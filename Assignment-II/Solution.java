import java.util.*;
public class Solution<Key extends Comparable<Key>, Value>  
{
    private Node root;
    int size;             // root of BST

    class Node 
    {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value val) 
        {
            this.key = key;
            this.val = val;
        }
    }
    public Solution()
    {
        size = 0;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty()
    {
        if(size == 0)
        {
        	return true;
        }
        return false;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() 
    {
      return size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) 
    {
    	if(key == null)
        {
	        throw new IllegalArgumentException("argument to get value() is null");
	    }
        Node x = root;
        while(x.key != key)
        {
        	//int cmp = key.compareTo(x.key);
        	//if(cmp < 0)
            if(key.compareTo(x.key)<0)
            {
        		x = x.left;
        	}
	        //else if(cmp > 0)
            else if(key.compareTo(x.key)>0)
            {
	        	x = x.right;
	        }
        }
        return x.val;
    }
    // /**
    //  * Inserts the specified key-value pair into the symbol table, overwriting the old 
    //  * value with the new value if the symbol table already contains the specified key.
    //  * Deletes the specified key (and its associated value) from this symbol table
    //  * if the specified value is {@code null}.
    //  *
    //  * @param  key the key
    //  * @param  val the value
    //  * @throws IllegalArgumentException if {@code key} is {@code null}
    //  */
    public void put(Key key, Value val) 
    {
        if(key==null)
        {
            throw new IllegalArgumentException("Key cannot be null");
        }
        Node newest = new Node(key,val);
        if(root == null)
        {
        	root = newest;
        }
        else{
        	Node x = root;
        	Node y;
        	while(true)
            {
        		y = x;
                if(key.compareTo(x.key)<0)
                {
        			x = x.left;
        			if(x == null)
                    {
        				y.left = newest;
        				size = size + 1;
        				return;
        			}
        		}
                else if(key.compareTo(x.key)>0)
                {
        			x = x.right;
        			if(x == null){
        				y.right = newest;
        				size = size + 1;
        				return;
        			}
        		}
                else
                {
                    x.val = val;
                    return;
                }
        	}
        }
        size = size + 1;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() 
    {
       if (isEmpty()) 
        {
            throw new NoSuchElementException("It is an empty");
        }

        Node x = root;
        /* loop down to find the leftmost leaf */
        while (x.left != null) 
        { 
            x = x.left; 
        }
        return x.key;  
    }    
    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
   public Key floor(Key key) 
   {
        if (key == null) 
        {
            throw new IllegalArgumentException("Argument to floor() is null ");
        }
        if (isEmpty()) 
        {
            throw new NoSuchElementException("called floor() with empty symboltable");
        }
        Node x = floor(root,key);
        if(x == null)
        {
            return null;
        }
        else 
        {
            return x.key;      
        }
    } 

    private Node floor(Node x, Key key) 
    {
        Node min = null;
        while (x != null)
        {
            int compare = key.compareTo(x.key);
            if(compare == 0) return x;
            if(compare > 0){
                min = x;
                x = x.right;
            }
            else{
                x = x.left;
            }
        }
        return min;
       
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
    public Key select(int rank) {
        if(rank<0 || rank>=size()) 
	{
		throw new IllegalArgumentException("error");
	} 	
        Node x = select(root, rank);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int t) 
    {
        int c = -1;
        ArrayList<Node> array = new ArrayList<Node>();
        Node current = x;
        while(!array.isEmpty() || current!=null)
        {
            if(current!=null)
            {
                array.add(current);
                current = current.left;
            } 
            else
            {
                current = array.remove(array.size()-1);
                c++;
                if(c==t) break;
                current = current.right;
            }
        }
        return current;
    } 
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
    public Iterable<Key> keys(Key lo, Key hi) 
    {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) 
    { 
        if (x == null)  
        return;  
    
        Node current = x;
        int cmp1 = lo.compareTo(current.key);
        int cmp = hi.compareTo(current.key);
        while (current != null) 
        {  
            if (current.left == null)  
            {   
                if (cmp1 <= 0 && cmp >= 0)
                {
                    queue.offer(current.key);    
                    current = current.right; 
                }  
                     
            }
            else 
            {  
                Node prenode = current.left;    
                while (prenode.right != null && prenode.right != current)  
                    prenode = prenode.right;  
      
                if (prenode.right == null)  
                {  
                    prenode.right = current;  
                    current = current.left;  
                }  
                else 
                {  
                    prenode.right = null;    
                    if (cmp1 <= 0 && cmp >= 0)  
                    {
                        queue.offer(current.key);   
                        current = current.right;
                    }  
                }  
            }
        }
    }
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) 
    { 
        Solution <String,Integer> obj = new Solution <String,Integer>();
        obj.put("ABDUL",1); 
        System.out.println(obj.get("ABDUL"));
        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL", 6);
        System.out.println(obj.get("SAI"));
        obj.put("TASHI", 4);
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.select(2));

        for(String s: obj.keys("ABDUL","TASHI"))
        {
            System.out.print(s+" ");
        }
        System.out.println("");
        obj.put("CHIMI", 5);
        obj.put("SAMAL", 4);
        System.out.println(obj.get("SAMAL"));
        obj.put("NIMA", 7);
        System.out.println(obj.size());
        System.out.println(obj.get("CHIMI"));
        System.out.println(obj.floor("CHIMA"));
        obj.put("SONAM", 8);
        for(String s: obj.keys("ABDUL","TASHI"))
        {
            System.out.print(s+" ");
        }
    }
}
