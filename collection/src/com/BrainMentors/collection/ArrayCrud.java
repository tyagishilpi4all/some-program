package com.BrainMentors.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

class Question implements Comparable<Question>{
	int id;
	String question;
	String answers[] = new String[4];
	String rans;
	int score;
	
	@Override
	public int compareTo(Question object) {
		
		return this.question.compareTo(object.question);
	}
	@Override
	public boolean equals(Object object) {
		if(this==object) {
			return true;
		}
		else {
			if(object instanceof Question) {
				Question ques = (Question) object;
				if(this.id == ques.id) {
					return true;
				}
			}
		}
		return false;
	}
	
	Question(int id){
		this.id = id;
	}
	Question(int id,String name,String ans[],String rans,int score){
		this.id = id;
		this.question = name;
		this.answers = ans;
		this.rans = rans;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Question[id=" +id+", question="+ question+", answers=" +Arrays.toString(answers)+", rans=" +rans+", score= "+ score+"]";
	}
}

class QuestionOperations{
	ArrayList<Question> questionList = new ArrayList<>();
	void add(Question question) {
		questionList.add(question);
		System.out.println("Question added....");
	}
	
	void traverse() {
		
		//for(int i=0; i<questionList.size(); i++) {
			//Question question = questionList.get(i);
			//System.out.println(question);
		//}
		
		//Iterator<Question> q = questionList.iterator();
		//while(q.hasNext()) {
		//	System.out.println(q.next());
		//}
		
		//ListIterator<Question> q = questionList.listIterator();
		//while(q.hasNext()) {
			//System.out.println(q.next());
		//}
		
		//while(q.hasPrevious()) {
		//	System.out.println(q.previous());
		//}
		
		//for(Question question: questionList) {
			//System.out.println(question);
		//}
		
		questionList.forEach(questionObject->System.out.println(questionObject));
	}
	 int search(int id) {
		 Question question = new Question(id);
		 System.out.println(questionList.contains(question)?"found":"not found");
		 return questionList.indexOf(question);
	 }
	 void delete(int id) {
		 //Question question = new Question(id);
		 //String result = questionList.remove(question)?"deleted":"not deleted";
		 //System.out.println(result);
		 
		 int index = search(id);
		 if(index>=0) {
			 questionList.remove(index);
			 traverse();
		 }
	 }
}
public class ArrayCrud {
	
	static Scanner scanner = new Scanner(System.in);
	QuestionOperations qp = new QuestionOperations();
	public void menu() {
		System.out.println("Array crud start");
		while(true) {
			System.out.println("1. Add");
			System.out.println("2. Delete");
			System.out.println("3. Search");
			System.out.println("4. Update");
			System.out.println("5. Sort");
			System.out.println("6. Traverse");
			System.out.println("7. Sum");
			System.out.println("8. Count");
			System.out.println("9. Exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			if(choice==1) {
				System.out.println("Enter the question id");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the question name");
				String name = scanner.nextLine();
				System.out.println("Enter the option A");
				String OptionA = scanner.nextLine();
				System.out.println("Enter the option B");
				String OptionB = scanner.nextLine();
				System.out.println("Enter the option C");
				String OptionC = scanner.nextLine();
				System.out.println("Enter the option D");
				String OptionD = scanner.nextLine();
				String answers[] = {OptionA,OptionB,OptionC,OptionD};
				System.out.println("Enter the ans");
				String rans = String.valueOf(scanner.next().charAt(0)).toLowerCase();
				System.out.println("answers....");
				System.out.println("Enter the Score");
				int score = scanner.nextInt();
				Question question = new Question(id,name,answers,rans,score);
				qp.add(question);
			}
			else 
				if(choice==6) {
					qp.traverse();
				
			}
			else 
				if(choice==3) {
					System.out.println("Enter the id for search");
					qp.search(scanner.nextInt());
			}
			else 
				if(choice==2) {
					System.out.println("Enter the id for delete");
					qp.delete(scanner.nextInt());
			}
		}
	}
	public static void main(String[] args) {
		ArrayCrud obj = new ArrayCrud();
		obj.menu();
	}

}
