hm.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

for(Integer key : map.keySet()){
    if(map.get(key) > l/3)
        System.out.println(key)
}

for(Map.Entry<Character, Integer> e : map.entrySet()){
    pq.add(e);
    e.getKey();
    e.getValue();
}

hm.putIfAbsent(arr[0], new ArrayList<>());

char a[] = s.toCharArray();

Arrays.equals(a1, a2);

int[] b = a.clone();

System.arraycopy(source array, source pos, dest array, dest pos, length);

int[] b = Arrays.copyOf(original array, length);

int[] b = Arrays.copyOfRange(original array, initial index, final index);

al.remove(index);

al.remove(Integer.valueOf(Object));


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