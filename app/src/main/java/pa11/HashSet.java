package pa11;

public class HashSet {

    int size;
    int capacity;
    String[] arr;
    
    public HashSet() {
        capacity = 4;
        arr = new String[4];
    }

    
    public int size() {
        return size;
    }

    /** 
     * Check if the set is empty
     * @return a boolean indicating whether the set is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    /**
     * Add an element to the set
     * @param s the element to add
     * @return the old value associated with the key, or null if no such entry exists
     */
    private void addHelper(String s, String[] array) {
    	size++;
    	if (size / (double) capacity > 0.5) {
    		capacity *= 2;
    		String[] newArr = new String[capacity];
    		for (int i=0; i< arr.length; i++) {
    			if (arr[i] != null && !"".equals(arr[i])) {
    				size--;
    				addHelper(arr[i], newArr);
    			}
    		}
    		arr = newArr;
    		array = arr;
    	}
    	
    	
    	int val = 0;
    	for (int i=0; i<s.length(); i++)
    		val += (int) s.charAt(i);
    	
        val %= capacity;
        int i = 1;
        while (true) {
        	int next_probe = i*(i-1)/2;
        	if (array[(val + next_probe) % capacity] == null || "".equals(array[(val + next_probe) % capacity])) {
        		array[(val + next_probe) % capacity] = s;
        		return;
        	}
        	i++;
        }
    }
    
    public void add(String s) {
    	if (!this.contains(s))
    		this.addHelper(s, arr);
    }

    /** 
     * Remove an element from the set
     * @param s the element to remove
     * @return the value associated with the key, or null if no such entry exists
     */
    public void remove(String s) {
    	if (s == null)
    		return;
    	int val = 0;
    	for (int i=0; i<s.length(); i++)
    		val += (int) s.charAt(i);
    	
        val %= capacity;
        int i = 1;
        for (int dummy=0; dummy<capacity; dummy++) {
        	int next_probe = i*(i-1)/2;
        	if (s.equals(arr[(val + next_probe) % capacity])) {
        		arr[(val + next_probe) % capacity] = "";
        		size--;
        		return;
        	}
        	if (arr[(val + next_probe) % capacity] == null)
        		return;
        }
    }

    /** 
     * Check if the set contains an element
     * @param s the element to check for
     * @return a boolean indicating whether the set contains the element
     */
    public boolean contains(String s) {
    	if (s == null)
    		return false;
    	int val = 0;
    	for (int i=0; i<s.length(); i++)
    		val += (int) s.charAt(i);
    	
        val %= capacity;
        int i = 1;
        for (int dummy=0; dummy<capacity; dummy++) {
        	int next_probe = i*(i-1)/2;
        	if (arr[(val + next_probe) % capacity] == null)
        		return false;
        	if (s.equals(arr[(val + next_probe) % capacity])) {
        		return true;
        	}
        }
        return false;
    }

    /** 
     * Clears the set
     */
    public void clear() {
    	size = 0;
        for (int i = 0; i<arr.length; i++)
        	arr[i] = null;
    }

    /** 
     * Convert the set to an array
     * @return an array containing all the elements in the set
     */
    public String[] toArray() {
       String[] res = new String[size];
       int idx = 0;
       for (int i=0; i<arr.length; i++) {
    	   if (arr[i] != null && !"".equals(arr[i])) {
    		   res[idx] = arr[i];
    		   idx++;
    	   }
       }
       return res;
    }

    /** 
     * Takes the intersection of the current set and the `other` set
     * @param other the set to intersect with
     * @return a new `HashSet` containing the intersection of the current set and the `other` set
     */
    public HashSet intersection(HashSet other) {
        HashSet res = new HashSet();
        String[] set1 = this.toArray();
        for (String st: set1)
        	if (other.contains(st))
        		res.add(st);
        return res;
    }

    /** 
     * Convert the set to a string
     * @param other the set to union with
     * @return a new `HashSet` containing the union of the current set and the `other` set
     */
    public HashSet union(HashSet other) {
    	HashSet res = new HashSet();
        String[] set1 = this.toArray();
        String[] set2 = other.toArray();
        for (String st: set1)
        	res.add(st);
        for (String st: set2)
        	res.add(st);
        return res;
    }

    /** 
     * Takes the difference of the current set and the `other` set 
     * @param other the set to take the difference with
     * @return a new `HashSet` containing the difference of the current set and the `other` set
     */
    public HashSet difference(HashSet other) {
    	HashSet res = new HashSet();
        String[] set1 = this.toArray();
        for (String st: set1)
        	if (!other.contains(st))
        		res.add(st);
        return res;
    }

    /** 
     * Check if the current set is a subset of the `other` set
     * @param other the set to check for a subset
     * @return a boolean indicating whether the current set is a subset of the `other` set
     */
    public boolean subset(HashSet other) {
        String[] set1 = this.toArray();
        for (String st: set1)
        	if (!other.contains(st))
        		return false;
        return true;
    }
        
}
