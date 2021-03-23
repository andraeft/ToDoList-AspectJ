package todopkg;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner ( System.in );

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User usr = readName();
		
		readTaskFor(usr);
		
		displayMenuFor(usr);
	}
	
	static User readName() {
		System.out.println("Hello. What is your name?");	
		String name = in.nextLine();
		return new User(name);
	}
	
	static void readTaskFor(User u) {	
		String text = in.nextLine();
		u.toDoList.addTask(text);
	    displayMenuFor(u);
	}
	
	static void solveTaskFor(User u) {
		System.out.println("Id of solved task:");	
		String id = in.nextLine();
		u.toDoList.getTaskById(Integer.parseInt(id)).resolveTask();
	}
	
	static void displayMenuFor(User u) {
		System.out.println ( "Here are your options: \n1) Add new task \n2) Resolve a task \n3) View your to do list \n4) Quit" );
	    System.out.println ( "What is your choice, " + u.name + "?" );
	    switch ( in.nextLine() ) {
	      case "1":
	        readTaskFor(u);
	        break;
	      case "2":
	        solveTaskFor(u);
	        break;
	      case "3":
	        u.toDoList.show();
	        displayMenuFor(u);
	        break;
	      case "4":
	    	System.out.println("Thank you for your time. Bye!");
	    	System.exit(1);
	    	break;
	      default:
	        System.err.println ( "Unrecognized option. Try again!" );
	        displayMenuFor(u);
	        break;
	    }
	}

}
