// 1. HashMap 
containsKey(Object key)
containsValue(Object value)
get(Object key). // Returns or null if this map contains no mapping for the key.
map.getOrDefault(idNum, "John Doe"));

// 2. HashSet


// 3. TreeMap 
// Concept: implement Map interface using a tree: guarantees the elements be sorted in an ascending order 
// worse general performace than HashMap/ Linked HashMap 
void clear();
boolean containsKey();
map.firstKey();
map.lastKey();
Set<Integer> keysLessThan3 = map.headMap(3).keySet();
Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();


// 2. Conversion 
String str = "testString";
char[] charArray = str.toCharArray();
