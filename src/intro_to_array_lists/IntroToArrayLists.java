package intro_to_array_lists;

import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String> s = new ArrayList<String>();
		
		//   Don't forget to import the ArrayList class
		
		//2. Add five Strings to your list
		s.add("first string");
		s.add("second string");
		s.add("third string");
		s.add("fourth string");
		s.add("fifth string");
		
		//3. Print all the Strings using a standard for-loop
		System.out.println("Standard for loop:");
		for( int i=0; i < s.size(); i++) {
			System.out.println( s.get(i) );
		}
		
		//4. Print all the Strings using a for-each loop
		System.out.println("\nFor each loop:");
		for( String eachStr : s ) {
			System.out.println(eachStr);
		}
		
		//5. Print only the even numbered elements in the list.
		System.out.println("\nEven numbered elements:");
		for( int i=0; i < s.size(); i+=1) {
			if( i % 2 == 0 ) {
				System.out.println(s.get(i));
			}
		}
		
		//6. Print all the Strings in reverse order.
		System.out.println("\nReverse order");
		for( int i = (s.size() - 1); i >= 0; --i ){
			System.out.println(s.get(i));
		}
		
		//7. Print only the Strings that have the letter 'e' in them.
		String charToSearch = "d";
		System.out.print("\nOnly strings containing " + charToSearch + ":");
		for( int i=0; i < s.size(); ++i) {
			String eachStr = s.get(i);
			System.out.print("\n" + eachStr + ": ");
			if( eachStr.contains(charToSearch) ) {
				System.out.print( "contains " + charToSearch );
			}
		}
	}
}
