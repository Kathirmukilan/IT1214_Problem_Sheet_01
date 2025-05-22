class Student {
	private String name;
	private int exam1, exam2, exam3;
	
	public Student (String name, int exam1, int exam2, int exam3){
		this.name=name;
		this.exam1=exam1;
		this.exam2=exam2;
		this.exam3=exam3;
	}
	
	public String getName(){
		return name;
	}
	
	public int getExam1(){
		return exam1;
	}
	
	public int getExam2(){
		return exam2;
	}
	
	public int getExam3(){
		return exam3;
	}
	
	public double calculateAverage(){
		return (exam1+exam2+exam3)/3.0;
	}
}

class validator {
	public static int validscore (int score)throws Exception{
		if(score>=0 && score <=100){
			return score;
		}
		
		else {
			throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
		}
}
}

public class Q_05{
	public static void main(String[] args){
		
		try{
		int exam1 = validator.validscore(75);
		int exam2 = validator.validscore(100);
		int exam3 = validator.validscore(90);
		
		Student scc=new Student("John",exam1,exam2,exam3);
		
		System.out.println("Student : "+scc.getName());
		System.out.println("Exam 01 : "+scc.getExam1());
		System.out.println("Exam 02 : "+scc.getExam2());
		System.out.println("Exam 03 : "+scc.getExam3());
		System.out.printf("Average : "+scc.calculateAverage());
		}
		
		catch(Exception e){
			System.out.println("Exception is "+e.getMessage());
		}		
	}
}
