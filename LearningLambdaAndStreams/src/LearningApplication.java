import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LearningApplication {

	public static void main(String[] args) {
		
		//Using a printer interface
			Printer printer = new Printer() {
				public void print(String msg) {
				System.out.println(msg);
		}
	};

	//check
	printer.print("printer check");
	
	//Using a lambdaPrinter
	Printer lambdaPrinter = m -> System.out.println(m);
	lambdaPrinter.print("lambda check");
	
	//Using a referenceMethodPrinter
	Printer methodReferencePrinter = System.out::println;
	methodReferencePrinter.print("Method reference is worked fine");	
	
	//Creating a printerHub
		Map<String, Printer> printerHub = new HashMap<>();
		printerHub.put("lambda", lambdaPrinter);
		printerHub.put("second", m -> {
			System.out.println("--=Начало сообщения=--");
			
				System.out.println(m);
				
			System.out.println("--=Конец сообщения=--");
		});
		
	printerHub.get("second").print("hello");
	
	
	List<String> names = Arrays.asList("John", "Steve", "Andrew", "Jack", "Jeremy");
	List<String> filtredNames = new ArrayList<>();
	for (String name : names) {
		//using if() for letter filtering
			if (name.startsWith("J")) {
				//Add new name who statr's With J to filtredNames list
				filtredNames.add(name);
			}
	}
	
	//Sorting use sort method
	filtredNames.sort(String::compareToIgnoreCase);
	
	
	//Using a stream to do same
	List<String> filtredNames2 = //create list
			names // called names
				.stream() // use a stream
				.filter(n -> n.startsWith("J")) //filtering
				.sorted(String::compareToIgnoreCase) // sorting
				.collect(Collectors.toList()); //add to collection filtredNames2
	
	
	//print the same methods
	System.out.println("filtredNames from for : " + filtredNames);
	System.out.println("filtredNames from stream : " + filtredNames2);
	
	
	//using default method colorPrint
	printerHub.get("lambda").colorPrint("test");
	printerHub.get("lambda").print("test lambda from printerHub");
}


		interface Printer {
			void print(String msg);
			default void colorPrint(String msg) {
				System.out.println("Default method, message:" + msg);
			}
		}
	
}