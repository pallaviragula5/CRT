import java.io.*;
import java.util.*;
public class StudentManagementSystem{
	static HashMap<Integer,String> studentMap=new HashMap<>();
	static final String FILE_NAME="students.txt";
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int choice;
		do{
			System.out.println("\n--Student Management Menu--");
			System.out.println("1.Add Student");
			System.out.println("2.Save to File");
			System.out.println("3.Load from File");
			System.out.println("4.Search by ID");
			System.out.println("5.Remove Student");
			System.out.println("6.Display All students");
			System.out.println("0.Exit");
			System.out.print("Enter Choice:");
			choice=sc.nextInt();
			switch(choice){
				case 1->addStudent(sc);
				case 2->saveToFile();
				case 3->loadFromFile();
				case 4->searchStudent(sc);
				case 5->removeStudent(sc);
				case 6->displayAll();
				case 0->System.out.println("Existing program.");
				default->System.out.println("Invalid choice.Try again.");
			}
		}while(choice!=0);
		sc.close();
	}
	static void addStudent(Scanner sc){
		System.out.println("Enter student ID:);
		int id=sc.nextInt(); 
		sc.nextLine();
		System.out.println("Enter Student Name:);
		String name=sc.nextLine();
		if(studentMap.containsKey(id)){
			System.out.println("ID already exists!);
		}else{
			studentMap.put(id,name);
			System.out.println("Student added.");
		}
	}
	static void saveToFile(){
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_NAME))){
			for(Map.Entry<Integer,String> entry:studentMap.entrySet()){
				bw.write(entry.getKey()+"."+entry.getValue());
				bw.newLine();
			}
				