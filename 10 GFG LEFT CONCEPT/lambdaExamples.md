using lambda expression in place of comparator object
           Collections.sort(al, (o1, o2) -> (o1 > o2) ? -1 :
                                       (o1 < o2) ? 1 : 0);

Sorting TreeSet using Lambda Expression: