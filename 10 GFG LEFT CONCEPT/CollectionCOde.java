// ArrayList
List<Integer> al = new ArrayList<Integer>();
List<Integer> al = Arrays.asList(str)
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

al.set(1, "Dates")
al.contains("lichi")
Collections.sort(al);
al.isEmpty()

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
hm.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
hm.putIfAbsent(arr[0], new ArrayList<>());

for(Integer key : map.keySet()){
    if(map.get(key) > l/3)
        System.out.println(key)
}

for(Map.Entry<Character, Integer> e : map.entrySet()){
    pq.add(e);
    e.getKey();
    e.getValue();
}

hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println)....comparingByValue
hm.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println)


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