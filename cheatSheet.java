// Collections
  // for interface that inherit from Collections, methods can all be applied
addAll, clear, contains, containsAll, equals, hashCode, isEmpty, iterator, remove, removeAll, retainAll, size, toArray, toArray;
  // other functions: 
Collections.reverse(list);

// HashMap 
containsKey(Object key)
containsValue(Object value)
get(Object key). // Returns or null if this map contains no mapping for the key.
map.getOrDefault(idNum, "John Doe"));
for (Object each: map.values()) {}
boolean map.isEmpty();
map.remove(Object key);
// copy a map, need to initialize another map first 


// HashSet
Set<Integer> set = new HashSet<Integer>();
set.add();
set.clear();
set.contains();
set.isEmpty();
set.remove();
set.size();

// TreeMap 
// Concept: implement Map interface using a tree: guarantees the elements be sorted in an ascending order 
// worse general performace than HashMap/ Linked HashMap 
void clear();
boolean containsKey();
map.firstKey();
map.lastKey();
Set<Integer> keysLessThan3 = map.headMap(3).keySet();
Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

// Queue<E>
boolean add(E e); // fail to insert in capacity restricted case
boolean offer (E e);
  // subtype od Collection class, inherits all the methods 
size();
isEmpty();
contains();
clear();
equals();

// String: 
str.length();
string1.equals(string2); // == compare the reference 
replace(char oldChar, char newChar);
split(String regex);
substring(int beginIndex);
substring(int beginIndex, int endIndex);
toCharArray();
// return string representation
static String valueOf(boolean b/ char c/ char[] data/ double d/ float f/ int i/ Object obj);
str.toLowerCase();
str.toUpperCase();
// replace string 
StringBuilder myName = new StringBuilder("domanokz");
myName.setCharAt(4, 'x');
myName.toString();

String newName = myName.substring(0,4)+'x'+myName.substring(5);

  
// Array: []
array.length;
Arrays.sort(int[]);
boolean arrlist.contains(Object item); 
boolean list.add(Object item);
// add several items together: 
res.add(Arrays.asList(num[i], num[lo], num[hi]));
arr.get(intdex);

// boolean (primitive type)
boolean[] array = new boolean[size]; // initialized to false 
// Boolean: warpper object for a boolean 

// Conversion 
String str = "testString";
char[] charArray = str.toCharArray();
