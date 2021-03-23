package todopkg;

import java.io.PrintWriter;

public aspect AspectMain {

    	/* User */
		pointcut callCreateUser(String u): call(* *.User(String)) && args(u);
		before(String u): callCreateUser(u){
			if (u.length() > 50) {
				throw new IllegalStateException("Name is too long");
			}
		}
	    pointcut callReadName(): call(* *.readName());
	    after() returning (User usr): callReadName()  {
	    	System.out.println("User registered as " + usr.name);
	    }
	    
	    /* List */
	    pointcut addTaskToList(List list): call(* *.addTask(String)) && target(list);
	    pointcut callReadTaskFor(User u): call(* *.readTaskFor(User)) && args(u);
	    
	    before(List list): addTaskToList(list) {
	    	if(list.noOfTasks >= 10) {
	    		throw new IllegalStateException("List is full.");
	    	}
	    }
	    after(List list): addTaskToList(list) {
	    	System.out.println("Task was succesfully added to your list.");
	    	list.noOfTasks++;
	    }
	    after(List list) returning (Exception e): addTaskToList(list){
	    	System.out.println(e);
	    }
	    
	    before(User u): callReadTaskFor(u){
			System.out.println("What is your task, " + u.name + "?");
	    }
	    
	    pointcut callPrintList(): call(* *.List.show());
	    before(): callPrintList() {
			System.out.println("Id \t Text \t\t Status");
			System.out.println("==============================================");
	    }
	    after(): callPrintList() {
	    	System.out.println("==============================================");
	    }
	    
	    /* Task */
	    pointcut resolveTask(): call(* *Task.resolveTask());
	    after(): resolveTask() {
	    	System.out.println("Task was marked as resolved.");
	    }
	    
	    
}

