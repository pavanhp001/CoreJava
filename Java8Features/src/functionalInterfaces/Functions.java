package functionalInterfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functions {
	
	public static double squareLazy(Supplier<Double> lazyValue) {
		System.out.println("lazyValue.get() : "+lazyValue.get()); //lazyValue.get() : 9.0
	    return Math.pow(lazyValue.get(), 2);
	}

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Samuel", "John", "Freddy");
		
		System.out.println("=============Predicates==================");
		System.out.println("Predicates : The Predicate functional interface is a specialization of a Function that receives a generified value and returns a boolean. A typical use case of the Predicate lambda is to filter a collection of values:");
		
		List<String> filtersNames = names.stream().filter(name -> name.startsWith("J")).collect(Collectors.toList());
		System.out.print("FilerNames : ");
		filtersNames.forEach(name -> System.out.print(" "+name));
		System.out.println();
		System.out.println("=============Consumers ==================");
		
		
		List<Integer> nos = Arrays.asList(5,2,5,7,4);
		nos.stream().sorted().forEach(no -> System.out.print(" " + no)); //  2 4 5 5 7 sorted() will not sort the array values
		System.out.println();
		nos.forEach(no -> System.out.print(" " + no)); //5 2 5 7 4
		List<Integer> newNumbers = nos.stream().sorted().collect(Collectors.toList());
		System.out.println();
		newNumbers.forEach(no -> System.out.print(" " + no));//2 4 5 5 7
		System.out.println();
		names.stream().sorted();
		
		//forEach(Consumer<? super String> action)
		names.forEach(name -> System.out.print(" " + name));
		System.out.println();
		
		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);
		System.out.println("=============BiConsumer ==================");
		//forEach(BiConsumer<? super String,? super Integer> action):void
		ages.forEach((name,age) -> System.out.println(" name : "+name+" age: "+age));
		System.out.println();
		System.out.println("=============Suppliers ==================");
		System.out.println("The Supplier functional interface is yet another Function specialization that does not take any arguments. It is typically used for lazy generation of values. For instance, let’s define a function that squares a double value. It will receive not a value itself, but a Supplier of this value");
		
		Supplier<Double> lazyValue = () -> {
		   // Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			
			try {
				Thread.sleep(1000, 2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    return 9d; 
		};
		
		Double valueSquared = squareLazy(lazyValue); 
		System.out.println("valueSquared: "+valueSquared); // valueSquared: 81.0
		
		int[] fibs = {0, 1};
		Stream<Integer> fibonacci = Stream.generate(() -> { //Supplier<T> generate(Supplier<T> supplier)
		    int result = fibs[1];
		    int fib3 = fibs[0] + fibs[1];
		    fibs[0] = fibs[1];
		    fibs[1] = fib3;
		    return result;
		});
		
		fibonacci.limit(10).forEach(s -> System.out.print(", "+s));
		
		System.out.println();
		
		System.out.println("=============Functions ==================");
		System.out.println();
		
		Function<Integer, String> intToString = Object::toString;
		
		Function<String, String> quote = s -> "'" + s + "'";
		
		System.out.println("Function : "+intToString.apply(new Integer(5))); //Function : 5   (Integer to string)
		
		System.out.println("Function : "+quote.apply("pavan")); //Function : 'pavan'  (string to string)
		
		//Function<Integer, String> quoteIntToString = quote.compose(intToString);
		
		System.out.println("=============Map.computeIfAbsent ==================");
		

		Map<String, Integer> nameMap = new HashMap<>();
		nameMap.put("ravi", new Integer(6));
		/*computeIfAbsent(key, mappingFunction){
		 * 	if (map.get(key) == null) { 
		 * 		V newValue = mappingFunction.apply(key); ----> passed function like s -> s.length()
		 * 		f (newValue != null) 
		 * 			map.put(key, newValue);
				} 
			}
		 */

		// nameMap.computeIfAbsent(key, mappingFunction)
		// map.computeIfAbsent(key, k -> new Value(f(k)));
		Integer value = nameMap.computeIfAbsent("John", s -> s.length());
		System.out.println("value : " + value); //value : 4
		
		Integer stringValue = nameMap.computeIfAbsent("pavan", String::length);
		System.out.println("stringValue : " + stringValue); //stringValue : 5
		
		Integer existingValue = nameMap.computeIfAbsent("ravi", String::length);
		System.out.println("existingValue : " + existingValue); //existingValue : 6  print 6 insteed 4 becouse it existing value
		
		

	}

}
