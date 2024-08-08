// ARRAY AND STRING
sb.append("a").append("b");
sb.append("a" + "b");
sb.insert(0, "c");



// ArrayList
List<Integer> al = new ArrayList<Integer>();
List<Integer> al = Arrays.asList(str);
Vector<String> v = new Vector<String>();

// converting list to array
String[] arr = al.toArray(new String[al.size()])
Arrays.toString(arr)

al.remove(index);
al.remove(Integer.valueOf(Object));
al.size()

al.add("Mango");
al.add(2, "Lichi")
al.addAll(arr)
al.addAll(2, arr)

v.add("umesh");
v.addElement("irfan");
Enumeration e = v.elements();
while(e.hasMoreElements()){
    System.out.println(e.nextElement());
}

al.set(1, "Dates")
al.contains("lichi")
al.isEmpty()

// we can sort 1) String objects  2) Wrapper class Objects   3) User-defined Objects
// String and Wrapper class implement the Comparable interface. So if we store the objects of string or wrapper 
// classes it will be comparable
class Student implements Comparable<Student>
public int compareTo(Student st){
    if(age == st.age) return 0;
    else if(age > st.age) return 1; // reverse k lye age < st.age
    else return -1;
}

class Student implements Comparator<Student>
public int compare(Object o1, Object o2){
    Student s1 = (Student)o1;
    Student s2 = (Student)o2;

    if(s1.age == s2.age) return 0;
    else if(s1.age > s2.age) return 1; // reverse k lye age < st.age
    else return -1;

    return s1.age.compareTo(s2.age);
}

Comparator<Student> s1 = Comparator.comparing(Student::getName);
Comparator<Student> s1 = Comparator.comparing(Student::getName, Comparator.nullsFirst(String::compareTo)); // nullsLast
// comparing(keyExtraction),  thenComparing(keyExtraction),  naturalOrder(),  reversed(),  reverseOrder()
// nullFirst(comparator),   nullLast(comparator)
Collections.sort(al, s1);

Arrays.sort(arr, (p1, p2) -> p1.x - p2.x);
Arrays.sort(arr, String :: compareToIgnoreCase);
Arrays.sort(arr, Comparator.nullFirst(Comparator.naturalOrder()))

// Sort first by name and then by roll number
Arrays.sort(arr, Comparator.comparing(Student :: getName).thenComparing(Student::getRoll))

Collections.sort(al);
Collections.sort(al, Collections.reverseOrder());
Collections.sort(str, (a,b) -> Integer.compare(a.length(), b.length()));
Collections.sort(str, (a,b) -> a.length() - b.length());

Collections.addAll(al,"Mango","Lichi","Dates");
Collections.addAll(al, strArr);

Collections.max(al);
Collections.min(al);

for(String fruit : al) System.out.println(fruit);
for(Boook b : al) System.out.println(b.id    b.author     b.publisher    b.quality)


// LINKED LIST
LinkedList<String> ll = new LinkedList<String>();
ll.add("Divya")
iterator<String> itr = ll.iterator();  ll.descendingIterator();
while(itr.hasNext())    itr.next(); ...........hasPrevious()

ll.addAll(ll2);
ll.addAll(1, ll3)
ll.addFirst("Deeksha")
ll.addLast("Swati")

ll.remove("Divya")
ll.remove(index)
ll.removeAll(ll1)
ll.removeLast()
ll.removeFirst()
ll.removeFirstOccurance()
ll.removeLastOccurance()
ll.clear()


// SET
HashSet<String> hs = new HashSet<>();
LinkedHashSet<String> lhs = new LinkedHashSet<>();
TreeSet<String> ts = new TreeSet<>();
TreeSet<String> ts = new TreeSet<>(Comparator.reverseOrder());

hs.add("one")
hs.addAll(hs2)
hs.remove("two")
hs.removeAll(hs2)
hs.removeIf(str -> str.contains("three"))
hs.clear()

ts.pollFirst(); // lowest value
ts.pollLast(); // Highest value
ts.headSet("C") // C k phle, C nt included....returns group of element that are less then then specific element
ts.subSet("A", "E") // A se E tk , E nt included .... return set of element that lie b/w the given range
ts.tailSet("C") // C k bd , C included........returns set of element that are greate then or equal to specific element
ts.isEmpty()



// MAP
Map<Integer, String> hm = new HashMap<>();
HashTable<Integer, String> hm = new HashTable<Integer, String>();
hm.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
hm.putIfAbsent(arr[0], new ArrayList<>()); // (103,"Divyashu")
hm.putAll(hm2)

hm.containsKey("Apple");
hm.containsValues(3);
Integer[] valueArray = new Integer[hm.size()];
hm.values.toArray(valueArray)

hm.remove(100) // key
hm.remove("Divya") // value
hm.remove(102, "Rahul")

hm.replace(102, "Gaurav")
hm.replace(102, "Vijay", "Rahul")
hm.replaceAll((k,v) -> "Ajay")

hm.keySet()    hm.values()    hm.entrySet()

for(Integer key : map.keySet()){
    if(map.get(key) > l/3)
        System.out.println(key)
}

for(Map.Entry<Character, Integer> e : hm.entrySet()){ // or just Map.Entry m = hm.entrySet()
    pq.add(e);
    e.getKey();
    e.getValue();
}

hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println)....comparingByValue
hm.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println)

NavigableMap<Integer, String> tm = new TreeMap<Integer, String>();
TreeMap<Integer, String> tm = new TreeMap<>(Comparator.reverseOrder());
tm.firstKey();
tm.lastKey();
tm.descendingKeySet();
tm.remove("one");
tm.descendingMap(); // according to keys
tm.headMap(102, true); // whose keys are <= specified key 
tm.headMap(102); // whose keys are < specified key 
tm.tailMap(102, true); // whose keys are >= specified key
tm.tailMap(102); // whose keys are >= specified key
tm.subMap(100,false,102,true) // 100 excluded and 102 included
tm.subMap(100,102) // 100 included and 102 excluded


// QUEUE
PriorityQueue<String> pq = new PriorityQueue<String>();
pq.add("Amit");
pq.offer("Amit")

pq.element();
pq.peek();

pq.remove();
pq.poll();

PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
    (a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue - a.getValue()
);

PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a,b) -> a[1] - b[1]
);

PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
pq.addAll(hm.values());

Deque<String> dq = new ArrayDeque<String>();
dq.offerFirst("Jai"); offerLast("vijay")
dq.pollFirst(); pollLast()




char a[] = s.toCharArray();
Arrays.equals(a1, a2);
int[] b = a.clone();
System.arraycopy(source array, source pos, dest array, dest pos, length);
int[] b = Arrays.copyOf(original array, length);
int[] b = Arrays.copyOfRange(original array, initial index, final index);




hm.equals(hm2);

System.out.println("%.6f\n", .....);   // for 6 digit decimal



// 2D Array to ArrayList in Graph
for(int i = 0; i < mat.length; i++){
    list.get(mat[i][1]).add(mat[i][0]);
}

// copy 2D Array
int[][] copy = new int[mat.length];
for(int i = 0; i < mat.length; i++){
    copy[i] = mat[i].clone();
}



// ENUM
enum days{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY, SATURDAY
}
Set<days> s = EnumSet.of(days.TUESDAY, days.WEDNESDAY);
Set<days> s2 = EnumSet.allOf(days.class)
System.out.println(s2); // Week Days:[SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY]
Set<days> s3 = EnumSet.noneOf(days.class)
System.out.println(s3); // Week Days:[]
Iterator<days> it = s.iterator();
while(it.hasNext())  System.out.println(it.next()); // TUESDAY, WEDNESDAY

public enum Days {  
    Monday, Tuesday, Wednesday, Thursday  
};
EnumMap<Days, String> map = new EnumMap<Days, String>(Days.class);  
   map.put(Days.Monday, "1");  
for(Map.Entry m:map.entrySet()){    
    System.out.println(m.getKey()+" "+m.getValue());    
}


// lazy and early(eager) initialization
// 1) Early (Eager) Initialization
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

// 2) Lazy Initialization
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

// 3) Thread-Safe Lazy Initialization with Double-Checked Locking :- to ensure that the singleton instance is
// created only once, even in a multi-threaded environment.
public class ThreadSafeLazySingleton {
    private static volatile ThreadSafeLazySingleton instance;

    private ThreadSafeLazySingleton() {}

    public static ThreadSafeLazySingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeLazySingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeLazySingleton();
                }
            }
        }
        return instance;
    }
}

