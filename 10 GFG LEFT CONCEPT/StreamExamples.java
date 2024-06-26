import java.util.*;  
import java.util.stream.Collectors;  

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
} 

public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>(); 

        // Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f)); 

        // Filtering Collection by using Stream
        List<Float> productPriceList2 = productsList.stream()  
                                     .filter(p -> p.price > 30000)// filtering data  
                                     .map(p->p.price)        // fetching price  
                                     .collect(Collectors.toList()); // collecting as list  
        System.out.println(productPriceList2);  // [90000.0]

        // Filtering and Iterating Collection
        productsList.stream()  
                             .filter(product -> product.price == 30000)  
                             .forEach(product -> System.out.println(product.name));  // Dell Laptop

        // reduce() Method in Collection
        //  // This is more compact approach for filtering data 
        Float totalPrice = productsList.stream()  
                    .map(product->product.price)  
                    .reduce(0.0f,(sum, price)->sum+price);   // accumulating price  
        System.out.println(totalPrice); // 201000.0  
        // More precise code   
        float totalPrice2 = productsList.stream()  
                .map(product->product.price)  
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class  
        System.out.println(totalPrice2); // 201000.0 

        // Sum by using Collectors Methods
        double totalPrice3 = productsList.stream()  
                        .collect(Collectors.summingDouble(product->product.price));  
        System.out.println(totalPrice3);  // 201000.0

        // Find Max and Min Product Price
        // max() method to get max Product price     
        Product productA = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1: -1).get();    
        System.out.println(productA.price);   // 90000.0 
        // min() method to get min Product price    
        Product productB = productsList.stream().min((product1, product2) -> product1.price > product2.price ? 1: -1).get();    
        System.out.println(productB.price); // 25000.0
        
        // count() Method in Collection
        long count = productsList.stream()  
                    .filter(product->product.price<30000)  
                    .count();  
        System.out.println(count);  // 3

        // Convert List into Set
        Set<Float> productPriceList =   
            productsList.stream()  
            .filter(product->product.price < 30000)   // filter product on the base of price  
            .map(product->product.price)  
            .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
        System.out.println(productPriceList);  // [25000.0, 28000.0]

        // Convert List into Map
        Map<Integer,String> productPriceMap =   
            productsList.stream()  
                        .collect(Collectors.toMap(p->p.id, p->p.name));         
        System.out.println(productPriceMap);  // {1=HP Laptop, 2=Dell Laptop, 3=Lenevo Laptop, 4=Sony Laptop, 5=Apple Laptop}

        // Method Reference in stream
        List<Float> productPriceList =   
                productsList.stream()  
                            .filter(p -> p.price > 30000) // filtering data  
                            .map(Product::getPrice)         // fetching price by referring getPrice method  
                            .collect(Collectors.toList());  // collecting as list  
        System.out.println(productPriceList);  // [90000.0]

        // sorted    distinct     limit(returns 1st n element)    skip(skip 1st n element)
    }  
} 



PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
    (a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue - a.getValue()
);

PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a,b) -> a[1] - b[1]
);



// Java Stream Iterating
import java.util.stream.*;  
public class JavaStreamExample {  
    public static void main(String[] args){  
        Stream.iterate(1, element->element+1)  
        .filter(element->element%5==0)  
        .limit(5)  
        .forEach(System.out::println);   
    }  
}  


// leetcode 3194 minimum average to largest and smallest
List<Double> averages = IntStream.range(0, nums.length / 2)  // creates a stream of integers from 0 to n/2 - 1.
            .mapToDouble(i -> (nums[i] + nums[nums.length - 1 - i]) / 2.0)  // maps each index i to the average of
            // the i-th smallest and i-th largest elements.
            .boxed() // converts the DoubleStream to a Stream<Double>
            .collect(Collectors.toList()); // collects the averages into a List<Double>

            // boxed() method in Java Streams is used to convert a primitive stream (e.g., IntStream, DoubleStream,
            // LongStream) to a stream of their corresponding wrapper types (e.g., Stream<Integer>, Stream<Double>,
            //  Stream<Long>).
        
        // finds the minimum value in the list of averages using a comparator for Double.
        return averages.stream().min(Double::compare).orElse(Double.NaN....or -1.0);

        double minAverage = IntStream.concat(
            IntStream.concat(calculateAverages(nums1), calculateAverages(nums2)),
            calculateAverages(nums3))
            .min()
            .orElse(-1.0);.