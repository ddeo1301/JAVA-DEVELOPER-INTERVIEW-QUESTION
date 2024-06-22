 1) - Using lambda expression in place of comparator object
           
            Collections.sort(al, (o1, o2) -> (o1 > o2) ? -1 :
                                       (o1 < o2) ? 1 : 0);


 2) - Sorting TreeSet using Lambda Expression:

            TreeSet<Integer> h = new TreeSet<Integer>((o1, o2) -> (o1 > o2) ? 
                                                        -1 : (o1 < o2) ? 1 : 0);


 3) - Sorting elements of TreeMap using Lambda Expression: Sorting will be done on the basis of the keys and not its value. 

            TreeMap<Integer, String> m = new TreeMap<Integer, String>((o1, o2) -> (o1 > o2) ? 
                                                                         -1 : (o1 < o2) ? 1 : 0);


4) - It is also possible to specify a reverse comparator via a lambda expression directly in the call to the TreeSet() constructor

            // Pass a reverse comparator to TreeSet() via a lambda expression
            TreeSet<String> ts=new TreeSet<String>((aStr,bStr) -> bStr.compareTo(aStr));
            

 5) - Converting ArrayList to HashMap in Java 8 using a Lambda Expression

            list.forEach(
                        (n) -> { map.put(n.getkey(), n.getvalue()); });


 6) - Check if a String Contains Only Alphabets in Java Using Lambda Expression

                public static boolean isStringOnlyAlphabet(String str){
                        return (
                                (str != null) && (!str.equals(""))
                                && (str.chars().allMatch(Character::isLetter))
                            );
                }



- LAMBDA EXPRESSION SYNTAX

 7) - Sorting according to x axis

                class Point{
                    int x, y;

                    Point(int x, int y){
                        this.x = x;
                        this.y = y;
                    }
                }

                class GFG{
                    public static void main(String[] args){
                        Point arr[] = {
                            new Point(10, 20),
                            new Point(5, 30),
                            new Point(30, 40)
                        }

                        Arrays.sort(arr, (p1, p2) -> p1.x - p2.x);
                    }
                }


 8) - METHOD REFERENCE IN JAVA

                String[] a = {....};
                String[] a = {....};

                if(Arrays.equals(a, b, String :: compareToIgnoreCase))
                System.out.println("YES");
                else
                System.out.println("NO");


 9) MARKS AVERAGE
  
                class Student{
                    int roll;
                    int marks;
                    String name;

                    Student(int r, String n, int m){
                        roll = r;
                        name = n;
                        marks = m;
                    }

                    int getRoll(){
                        return roll;
                    }

                    String getName(){
                        return name;
                    }

                    int getMarks(){
                        return marks;
                    }
                }

                double res = Arrays.stream(arr)
                                .mapToInt(x -> x.getMarks())
                                .average()
                                .getAsDouble()


