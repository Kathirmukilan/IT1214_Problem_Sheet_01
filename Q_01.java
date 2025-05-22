class Student {
	private int studentId;
	private String name;
	private int daysAttended;
	
	public Student(int studentId, String name, int daysAttended){
		this.studentId=studentId;
		this.name=name;
		this.daysAttended=daysAttended;
	}
	
	public int getStudentID(){
		return studentId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setDaysAttended(int daysAttended){
		this.daysAttended=daysAttended;
	}
	
	public void printDetails(){
		System.out.println("Student ID : "+studentId);
		System.out.println("Name : "+name);
		System.out.println("Days Attended : "+daysAttended);
		System.out.println();
	}
}

class Classroom {
	private Student[] students=new Student[10];
	private int studentCount=0;
	
	public void addStudent(Student n){
		if(studentCount<10){
			students[studentCount]=n;
			studentCount++;
		}
		
		else{
			System.out.println("Classroom is reached it's maximum. Cannot add more Students right now");
		}
	}
	
	public void updateAttendace(int id, int newDays){
		boolean found=false;
		for(int i=0; i<studentCount;i++){
			if(students[i].getStudentID()==id){
				students[i].setDaysAttended(newDays);
				found=true;
				break;
			}
		}
		
		if(!found){
			System.out.println();
			System.out.println("Student with ID "+id+" not found.");
			System.out.println();
		}
	}
	
	public void displayStudents(){
		System.out.println("------Student Attendance-------");
		for(int i=0; i<studentCount;i++){
			students[i].printDetails();
		}
	}
}

public class Q_01{
	public static void main(String[] args){
		Classroom classroom=new Classroom();
		
		classroom.addStudent(new Student(101,"Alice Smith",12));
		classroom.addStudent(new Student(102,"Bob Jones",15));
		classroom.addStudent(new Student(103,"Carol Lee",10));
		
		classroom.updateAttendace(102,16);
		
		classroom.updateAttendace(104,8);
		
		classroom.displayStudents();
	}
}
