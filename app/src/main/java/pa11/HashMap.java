package pa11;

public class HashMap {
	private class Tuple{
		String key;
		String val;
		public Tuple(String key, String val) {
			this.key = key;
			this.val = val;
		}
	}

	int size;
    int capacity;
    Tuple[] arr;
    public HashMap() {
    	capacity = 4;
        arr = new Tuple[4];
    }
    
    /** 
     *  Size of the map
     *  @return the number of elements in the map
     */
    public int size() {
    	return size;
    }

    /**
     *  Check if the map is empty
     *  @return a boolean indicating whether the map is empty
     */
    public boolean isEmpty() {
    	return size == 0;
    }

    /**
     *  Get the value associated with the key
     *  @param key the key to get the value for
     *  @return the value associated with the key, or null if no such entry exists
     */
    private Tuple getHelp(String s) {
    	if (s == null)
    		return null;
    	int val = 0;
    	for (int i=0; i<s.length(); i++)
    		val += (int) s.charAt(i);
    	
        val %= capacity;
        int i = 1;
        for (int dummy=0; dummy<capacity; dummy++) {
        	int next_probe = i*(i-1)/2;
        	if (arr[(val + next_probe) % capacity] == null)
        		return null;
        	if (s.equals(arr[(val + next_probe) % capacity].key)) {
        		return arr[(val + next_probe) % capacity];
        	}
        }
        return null;
    }
    
    public String get(String s) {
    	Tuple tup = this.getHelp(s);
    	if (tup != null)
    		return tup.val;
    	return null;
    }
    
    
    private void addHelper(String s, Tuple[] array, String value) {
    	size++;
    	if (size / (double) capacity > 0.5) {
    		capacity *= 2;
    		Tuple[] newArr = new Tuple[capacity];
    		for (int i=0; i< arr.length; i++) {
    			if (arr[i] != null && !"".equals(arr[i].key)) {
    				size--;
    				addHelper(arr[i].key, newArr, arr[i].val);
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
        	if (array[(val + next_probe) % capacity] == null || "".equals(array[(val + next_probe) % capacity].key)) {
        		array[(val + next_probe) % capacity] = new Tuple(s, value);
        		return;
        	}
        	i++;
        }
    }
    /**
     *  Add an entry to the map
     *  @param key the key to add
     *  @param value the value to add
     *  @return the old value associated with the key, or null if no such entry exists
     */
    public String put(String key, String value) {
    	Tuple prev = this.getHelp(key);
    	if (prev == null) {
    		this.addHelper(key, arr, value);
    		return null;
    	}
    	String res = prev.val;
    	prev.val = value;
    	return res;
    }

    /**
     *  Remove an entry from the map
     *  @param key the key to remove
     *  @return the value associated with the key, or null if no such entry exists
     */
    public String remove(String s) {
    	if (s == null)
    		return null;
    	int val = 0;
    	for (int i=0; i<s.length(); i++)
    		val += (int) s.charAt(i);
    	
        val %= capacity;
        int i = 1;
        for (int dummy=0; dummy<capacity; dummy++) {
        	int next_probe = i*(i-1)/2;
        	if (s.equals(arr[(val + next_probe) % capacity].key)) {
        		arr[(val + next_probe) % capacity] = new Tuple("", "");
        		size--;
        		return arr[(val + next_probe) % capacity].val;
        	}
        	if (arr[(val + next_probe) % capacity] == null)
        		return null;
        }
        return null;
    }

    /**
     *  Get all the keys in the map
     *  @return all the keys stored in the map
     */
    public String[] keySet() {
    	String[] res = new String[size];
        int idx = 0;
        for (int i=0; i<arr.length; i++) {
     	   if (arr[i] != null && !"".equals(arr[i].key)) {
     		   res[idx] = arr[i].key;
     		   idx++;
     	   }
        }
        return res;
    }

    /**
     *  Get all the values in the map
     *  @return all the values stored in the map
     */
    public String[] values() {
    	String[] res = new String[size];
        int idx = 0;
        for (int i=0; i<arr.length; i++) {
     	   if (arr[i] != null && !"".equals(arr[i].key)) {
     		   res[idx] = arr[i].val;
     		   idx++;
     	   }
        }
        return res;
    }
}
