package todopkg;

public class List {

	Task[] taskList;
	int noOfTasks;
	
	List(){
		noOfTasks = 0;
		taskList = new Task[10];
	}
	
	public Task getTaskById(int id) {
		return taskList[id];
	}
	
	public void addTask(String text){
		taskList[noOfTasks] = new Task(noOfTasks, text);
	}
	
	public void show() {
		for (int i = 0; i < noOfTasks; i++) {
			taskList[i].print();
		}
	}
}
