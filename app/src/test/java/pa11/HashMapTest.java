package pa11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
	@Test
    void main() {
        HashMap map = new HashMap();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.get("key"));
        map.put("key", "value");
        map.remove("key");

        System.out.println("All tests passed!");
    }
    
    @Test
    void test1() {
    	HashMap map = new HashMap();
    	map.put("name", "nom");
    	
    	assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertEquals("nom", map.get("name"));
        
        map.put("name", "name");//key already present
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
        assertEquals("name", map.get("name"));
        
        map.put("name1", "name");
        map.put("name2", "name");
        map.put("name3", "name");
        map.put("name4", "name");
        map.put("name5", "name");
        
        assertEquals(6, map.size());
        assertArrayEquals(map.keySet(), new String[] {"name", "name1", "name2", "name3", "name4", "name5"});
        
        assertArrayEquals(map.values(), new String[] {"name", "name", "name", "name", "name", "name"});
    }
}







