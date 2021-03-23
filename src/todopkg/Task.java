package todopkg;

public class Task {
	
	int id;
	String text;
	boolean isCompleted;
	
	Task(int i, String t){
		id = i;
		text = new String(t);
		isCompleted = false;
	}
	
	public void resolveTask() {
		isCompleted = true;
	}

	public void print() {
		String completed = isCompleted ? "completed" : "pending";
		System.out.println(String.valueOf(id) + " \t" + text + " \t" + completed );
	}
}
