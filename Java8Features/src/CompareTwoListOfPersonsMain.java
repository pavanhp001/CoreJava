package CompareTwoListOfPersons;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CompareTwoListOfPersonsMain {
	
	public static <K, U> Collector<Map.Entry<K, U>, ?, Map<K, U>> entriesToMap() {
		return Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue());
	}
	
	/*public static Boolean hasKey() {
		return Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue());
	}*/

	public static void main(String[] args) {


		List<Person> people = Arrays.asList(
				new Person("1","pavan",1000l,"IT"),
		        new Person("2","pavan",6000l,"IT"), 
		        new Person("3","pavan",3000l,"IT"),
		        new Person("4","pavan",2000l,"IT"),
		        new Person("5","pavan",3000l,"IT"),
		        new Person("6","pavan",2000l,"IT"),
		        new Person("7","pavan",1000l,"IT"));
		
		List<Person> people1 = Arrays.asList(
				new Person("1","pavan",1000l,"IT"),
		        new Person("2","pavan",6000l,"IT"), 
		        new Person("3","pavan",3000l,"IT"),
		        new Person("4","pavan",1000l,"Medical"),
		        new Person("5","pavan",3000l,"IT"),
		        new Person("6","pavan",2000l,"IT"),
		        new Person("7","pavan",1000l,"BA"));
		
		
		// Group persons by their ID
		/*Map<String, List<Person>> peopleById = people.stream().collect(
		        Collectors.groupingBy(Person::getId));*/
		
		Map<String, Person> peopleMap = people.stream().collect(Collectors.toMap(person -> person.getId(), person -> person));
		
		//Map<String, Person> peopleMap1 = people1.stream().collect(Collectors.toMap(person -> person.getId(), person -> person));
		
		//Map<String, Person> peopleMap1 = people1.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		Map<String, Person> peopleMap1 = people1.stream().collect(Collectors.toMap((person) -> person.getId(), (person) -> person));
		
		//Map<String, Person> peopleMap1 = people1.stream().collect(entriesToMap());
		
		//Map<String, A> map = Stream.of(entry("A", a)).collect(entriesToMap());
		
		//Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
		
		System.out.println();
		System.out.println("========== peopleMap ===========");
		
		peopleMap
				.entrySet()
				.stream()
				.forEach(
						r -> {

							System.out.print(" Id : " + r.getKey()
									+ " salary : " + r.getValue().getSalary());
						});
		
		System.out.println();
		System.out.println("========== peopleMap1 ===========");

		peopleMap1
				.entrySet()
				.stream()
				.forEach(
						r -> {

							System.out.print(" Id : " + r.getKey()
									+ " salary : " + r.getValue().getSalary());
						});
		
		System.out.println();
		System.out.println("========= Map1 changes ========");
		
		
		peopleMap
				.entrySet()
				.stream()
				.filter(person -> !peopleMap1.get(person.getKey()).equals(person))
				.map(person -> person.getValue())
				.forEach(p -> System.out.println(p));
		
		
		for (Entry<String,Person>  personEntry : peopleMap.entrySet()) {
			
			System.out.println();
			Person p1 = peopleMap1.get(personEntry.getKey());
			Person p2 = personEntry.getValue();
			if(!p1.equals(p2)){
				System.out.println("P1 Data : " + p1.getId()+" Salary:  "+p1.getSalary());
				System.out.println("P2 Data : " + p2.getId()+" Salary:  "+p2.getSalary());
			}
		}
		
		
				
						
						
						//.collect(toList);
		
		

		Map<String, List<Person>> peopleById1 = people1.stream().collect(
		        Collectors.groupingBy(Person::getId));
		
		
		/*peopleById
				.entrySet()
				.stream()
				.forEach(
						r -> {

							System.out.println("Id : " + r.getKey()
									+ " salary : "
									+ r.getValue().get(0).getSalary());
						});
		
		peopleById
				.values()
				.stream()
				.filter(peopleWithSameId -> peopleWithSameId.size() > 1)
				.forEach(
						peopleWithSameId -> System.out
								.println("People with identical IDs: "
										+ peopleWithSameId));*/

	}

}
