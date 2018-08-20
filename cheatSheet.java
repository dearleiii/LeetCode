// 1. HashMap 
containsKey(Object key)
containsValue(Object value)
get(Object key). // Returns or null if this map contains no mapping for the key.
map.getOrDefault(idNum, "John Doe"));
for (Object each: map.values()) {}
boolean map.isEmpty();
map.remove(Object key);
// copy a map, need to initialize another map first 


// 2. HashSet
Set<Integer> set = new HashSet<Integer>();
set.add();
set.clear();
set.contains();
set.isEmpty();
set.remove();
set.size();

// 3. TreeMap 
// Concept: implement Map interface using a tree: guarantees the elements be sorted in an ascending order 
// worse general performace than HashMap/ Linked HashMap 
void clear();
boolean containsKey();
map.firstKey();
map.lastKey();
Set<Integer> keysLessThan3 = map.headMap(3).keySet();
Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

// 4. String: 
str.length();
string1.equals(string2); // == compare the reference 
replace(char oldChar, char newChar);
split(String regex);
substring(int beginIndex);
substring(int beginIndex, int endIndex);
toCharArray();
// return string representation
static String valueOf(boolean b/ char c/ char[] data/ double d/ float f/ int i/ Object obj);

// 5. Array: []
array.length;

// 8. boolean (primitive type)
boolean[] array = new boolean[size]; // initialized to false 
// Boolean: warpper object for a boolean 

// 2. Conversion 
String str = "testString";
char[] charArray = str.toCharArray();
