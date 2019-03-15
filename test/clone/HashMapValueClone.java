package ink.nota.common.test.clone;

import java.util.HashMap;
import java.util.Map;

public class HashMapValueClone<K,V> extends HashMap<K, V>{
	
	private HashMap<K, V> map = new HashMap<>();
	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		overPutMapEntries(m, true);
	    }
	
	public static void main(String[] args) {
		HashMapValueClone<Object, Object> map = new HashMapValueClone<>();
		
//		map.putAll(m);
	
	}
	
//	@Override
	final void overPutMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();
        if (s > 0) {
           
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
//                putVal(hash(key), key, value, false, evict);
            }
        }
    }

}
