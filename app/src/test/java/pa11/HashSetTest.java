package pa11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

class HashSetTest {

    @Test 
    void EmptySet() {
        HashSet set = new HashSet();
        assertEquals(set.size(), 0);
    }
    
    @Test
    void test1() {
    	HashSet set = new HashSet();
    	set.add("jj");
    	assertEquals(set.size(), 1);
    	set.add("jj"); //duplicate
    	assertEquals(set.size(), 1);
    	assertTrue(set.contains("jj"));
    	set.add("l");
    	assertEquals(set.size(), 2);
    	set.add("_");
    	assertEquals(set.size(), 3);
    	set.add("123");
    	assertEquals(set.size(), 4);
    	set.add("+=");
    	assertEquals(set.size(), 5);
    	set.add("@%");
    	assertEquals(set.size(), 6);
    	
    	set.remove("plplplp");
    	assertEquals(set.size(), 6);
    	
    	assertTrue(Arrays.equals(set.toArray(), new String[] {"jj", "@%", "123", "+=", "l", "_"}));
    	
    	set.remove("l");
    	assertEquals(set.size(), 5);
    }
    
    @Test
    void test2() {
    	HashSet set1 = new HashSet();
    	HashSet set2 = new HashSet();
    	
    	assertEquals(0, set1.intersection(set2).size());
    	assertEquals(0, set1.union(set2).size());
    	assertEquals(0, set1.difference(set2).size());
    	assertEquals(true, set1.subset(set2));
    	
    	set1.add("kl");
    	assertEquals(0, set1.intersection(set2).size());
    	assertEquals(1, set1.union(set2).size());
    	assertEquals(1, set1.difference(set2).size());
    	assertEquals(false, set1.subset(set2));
    	
    	set2.add("kl");
    	set2.add("ooo");
    	assertEquals(1, set1.intersection(set2).size());
    	assertEquals(2, set1.union(set2).size());
    	assertEquals(0, set1.difference(set2).size());
    	assertEquals(true, set1.subset(set2));
    }
}
