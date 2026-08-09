import java.util.Scanner;

// public class hello{
// 	public static void main(String args[]){
// 	Scanner scanner = new Scanner(System.in); 
        
//         String name = scanner.nextLine();
//         int total =scanner.nextInt();
//         scanner.nextLine(); 
//         String dept =scanner.nextLine();
//         System.out.println("Enter your Name" + name);

//         System.out.println("Enter total Scorce" + total/10);
	    
        
//         System.out.println("Enter your Department" + dept);
        

	
	
	

// }
// }
// public class hello{
// public static void main(String args[]){
// 	int a =5;
// 	if (a%2==0){
// 	System.out.println("Even");
	
// }
// 	else {
// 	System.out.println("odd");
// }
// }
// }

// public class hello{
// public static void main(String args[]){
// 	int score = 80;
// 	if (score <= 50){
// 	System.out.println("You need to improve");

// }
// 	else if(score < 50 && score < 70){
// 	System.out.println("Good job");

// }
// 	else if (score>70){
// System.out.println("Excellent");
// }		

// }
// }

// public class hello{
    
//     public static void main(String args[]){
       
//         for(int i=7;i<=10;i++){
//             System.out.print(i + " ");
//         }
//         System.out.println();
//         for(int i=4;i<=6;i++){
//             System.out.print(i + " ");
//         }
//         System.out.println();
//         for(int i=2;i<=3;i++){
//             System.out.print(i + " ");
        
//         }
//         System.out.println();
//         System.err.println(1);
//     }
// }
// public class hello{
//     public static void main (String args[]){
//         int count =10;
//         int i =4;
//         while (i>=1){
//             int add = count - i + 1;
//             int num = add;
//             while (num <= count){
//                 System.out.print(num + " ");
//                 num ++;
//             } 
//             System.out.println();
//             count = count - i;
//             i--;
//         }
//     }
// }

//public class hello{
//     public static void main(String[] args){
//         String [] word = {"hello","world","java"};
//        for (String w: word){
//         System.out.print(w + " ");
//         }


//     }
// }

// class hello{

//     String studentId;

//     hello(){
//        int studentId = 11244010;
//         System.out.println(studentId);
//     }
//     void display(String Grade){
//         System.out.println("Student Name: Gohul M.R");
//         studentId = Grade;
//         System.out.println("Grade:" + studentId);

//     }
//     public static void main(String[] args){
//         hello id = new hello();
//         id.display("O");
       
        
//     }
// }

// class hello{
//     public static void main(String args[]){ 
        
//       int marks = 40;

// if(marks >= 50)
//     System.out.println("Pass");
// else
//     System.out.println("Fail");
//     }
// }

// class Hello{
//     public static int square(int a){
//     return a *a;
// }
// public static void main(String args[]){
// System.out.println(square(2));
// }
// }

// class Employee{
//     String name;
//     double salary;
//    // String role;
//     void display(){
//         System.out.println("Name:" + name);
//         System.out.println("Salary:" + salary);
//         //System.out.println("Role:" + role);
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         Employee e1 = new Employee();
//         e1.name = "Gohul M.R";
//         e1.salary = 50000;
//         //e1.role = "CEO";
//         e1.display();
//     }
// }


// class Book{
//     String title;
//     double price;
//     Book(String title, double price){
//         this.title = title;
//         this.price = price;
//     }
//     void display(){
//         System.out.println("Title:" + title);
//         System.out.println("Price:" + price);
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         Book b1 = new Book("Java Basics", 499.0);
//         b1.display();
//     }
// }

// class BankAccount{
//     private double balance;
//     public void setBalance(double balance){
//         this.balance = balance;
//     }
//     public double getBalance(){
//         return balance;
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         BankAccount myacc = new BankAccount();
//         myacc.setBalance(10000);
//         System.out.println(myacc.getBalance());

//     }
// }

// class vehicle{
//     String brand;
// }
// class Car extends vehicle{
//     int speed;
// }
// public class hello{
//     public static void main(String[] args){
//         Car mycar = new Car();
//         mycar.brand = "Toyata";
//         mycar.speed = 120;
//         System.out.println("Brand:" + mycar.brand);
//         System.out.println("Speed:" + mycar.speed);
//     }
// }


// class Person{
//     void introduce() {
//         System.out.println("I am a person");
//     }
// }

// class Student extends Person {
//     @Override
//     void introduce() {
//         System.out.println("I am a student");
//     }
// }

// public class hello{
//     public static void main(String[] args){
//         Person p = new Student();
//         p.introduce();

//     }
// }

// abstract class Shape {
//     abstract void draw();
// }

// class Circle extends Shape {
//     @Override
//     void draw(){
//         System.out.println("Drawing a Circle");
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         Shape s = new Circle();
//         s.draw();
//     }
// }

// interface Payment{
//     void pay();
// }

// class CreditCardPayment implements Payment{
//     @Override
//     public void pay(){
//         System.out.println("Payment Done Using Credit Card");
//     }
// }

// public class hello{
//     public static void main(String[] args){
//         Payment paye = new CreditCardPayment();
//         paye.pay();
//     }
// }

// class hello{
//     public static void main(String[] args){
//         int[] num = {1,2,3};
//         try{
//             System.out.println(num[5]);
//                 }
//         catch (ArrayIndexOutOfBoundsException e){
//             System.out.println("Array is limited to 3 elements");
//         }
//         finally{
//             System.out.println("Program can be continued");
//         }
//     }
// } 
// import java.util.ArrayList;
// class hello{
//     public static void main(String[] args){
//         ArrayList<Integer> numbers = new ArrayList<>();
//         numbers.add(10);
//         numbers.add(20);
//         numbers.add(30);
//         numbers.add(40);
//         int sum = 0;
//         for (Integer num : numbers){
//             sum += num;
//         }
//         System.out.println("Sum = " + sum);
//     }
// }



import java.util.Scanner;
// 	Scanner scanner = new Scanner(System.in); 
        
//         String name = scanner.nextLine();
//         int total =scanner.nextInt();
//         scanner.nextLine(); 
//         String dept =scanner.nextLine();
//         System.out.println("Enter your Name" + name);

//         System.out.println("Enter total Scorce" + total/10);
	    
        
//         System.out.println("Enter your Department" + dept);
        

	
	
	

// }
// }
// public class hello{
// public static void main(String args[]){
// 	int a =5;
// 	if (a%2==0){
// 	System.out.println("Even");
	
// }
// 	else {
// 	System.out.println("odd");
// }
// }
// }

// public class hello{
// public static void main(String args[]){
// 	int score = 80;
// 	if (score <= 50){
// 	System.out.println("You need to improve");

// }
// 	else if(score < 50 && score < 70){
// 	System.out.println("Good job");

// }
// 	else if (score>70){
// System.out.println("Excellent");
// }		

// }
// }

// public class hello{
    
//     public static void main(String args[]){
       
//         for(int i=7;i<=10;i++){
//             System.out.print(i + " ");
//         }
//         System.out.println();
//         for(int i=4;i<=6;i++){
//             System.out.print(i + " ");
//         }
//         System.out.println();
//         for(int i=2;i<=3;i++){
//             System.out.print(i + " ");
        
//         }
//         System.out.println();
//         System.err.println(1);
//     }
// }
// public class hello{
//     public static void main (String args[]){
//         int count =10;
//         int i =4;
//         while (i>=1){
//             int add = count - i + 1;
//             int num = add;
//             while (num <= count){
//                 System.out.print(num + " ");
//                 num ++;
//             } 
//             System.out.println();
//             count = count - i;
//             i--;
//         }
//     }
// }

//public class hello{
//     public static void main(String[] args){
//         String [] word = {"hello","world","java"};
//        for (String w: word){
//         System.out.print(w + " ");
//         }


//     }
// }

// class hello{

//     String studentId;

//     hello(){
//        int studentId = 11244010;
//         System.out.println(studentId);
//     }
//     void display(String Grade){
//         System.out.println("Student Name: Gohul M.R");
//         studentId = Grade;
//         System.out.println("Grade:" + studentId);

//     }
//     public static void main(String[] args){
//         hello id = new hello();
//         id.display("O");
       
        
//     }
// }



// public class hello{
//     public static void main (String args[]){
//         System.out.println ("hello gitHub");

//     }}

// public class hello {
//     public static void main (String args[]){
//         int score;
//         System.out.print("Enter your score: ");
//         Scanner scan = new Scanner(System.in);
//         score = scan.nextInt();
//         if (score < 50){
//             System.out.println("You need to improve");

//         }
//         else if(score < 70){
//             System.out.println ("Good job");

//         }
//         else {
//             System.out.println("Excellent");
//         }
//     }
// }

// public class hello{
//     public static void main(String args[]){
//         int m1,m2,m3,m4,m5;
//         Scanner scan = new Scanner(System.in);
//         System.out.print("Enter marks for subject 1: ");
//         m1 = scan.nextInt();
//         System.out.print("Enter marks for subject 2: ");
//         m2 = scan.nextInt();
//         System.out.print("Enter marks for subject 3: ");
//         m3 = scan.nextInt();    
//         System.out.print("Enter marks for subject 4: ");
//         m4 = scan.nextInt();
//         System.out.print("Enter marks for subject 5: ");
//         m5 = scan.nextInt();
//         int total = m1 + m2 + m3 + m4 + m5;
//         int avg = total / 5;
//         System.out.println("Total marks: " + total);
//         System.out.println("Average marks:" + avg);
//         if (avg > 40 ){
//             System.out.println ("GOOD TO GO!!!");
//         } 
//     }
// }
// public class hello {
//     public static void main(String[] args) {
//         String color;
//         System.out.println("Enter a color: ");
//         Scanner signal = new Scanner(System.in);
//         color = signal.nextLine();
//         if (color.equals("red")) {
//             System.out.println("STOP");
//         } else if (color.equals("yellow")) {
//             System.out.println("SLOW DOWN");
//         } else if (color.equals("green") || color.equals("blue")) {
//             System.out.println("GO");
//         } else {
//             System.out.println("ARE YOU COLOR BLIND?");
//         }
//     }
// }

// public class hello{
//     public static void main(String args[]){
//         int age;
//         int salary;
//         int loan;
//         Scanner scan = new Scanner(System.in);
//         System.out.print("Enter your age:");
//         age = scan.nextInt();
//         System.out.print("Enter your salary:");
//         salary = scan.nextInt();
//         if (age >= 26 && salary >= 20000){
//             System.out.println("You are eligible for a loan");    
//         }
//         else {
//             System.out.println("You are not eligible for a loan");
//         }
//         System.out.print("Enter the loan amount you want to apply for:");
//         loan =scan.nextInt();
//         if (loan <= 60000){
//             System.out.println("Your loan is approved");
//         }
//         else{
//             System.out.println("Maximum loan amount is 60000");
//         }
//     }
// }

// 

// public class hello{
//     public static void main(String args[]){
//         int a;
//         int b=10;
//         for(a=5;a<=b;a++){
//             System.out.println(a + " ");
//         }
        
//     }
// }

// 

// public class hello{
//     public static void main(String args[]){
//         int a;
//         Scanner scan = new Scanner(System.in);
//         System.out.print("Enter the size of the array:");
//         a = scan.nextInt();
//         int [] numbers = new int[a];
//         for (int i=0;i<a;i++){
//             System.out.print("Enter number " + (i+1) + ":");
//             numbers[i] = scan.nextInt();
//         }
//         for (int i = 0; i<a;i++){
//             System.out.print(numbers[i]);
//         }


//     }
// }

// public class hello{
//     public static void main(String args[]){
//         System.out.println("enter the array index:");
//         Scanner scan = new Scanner(System.in);
//         int i = scan.nextInt();
//              int[] arr = {12, 9, 5, 18, 2};
//      int sum = 0;
//      for (; i<arr.length;i++){
//         sum += arr[i];    
//      }
//      if (sum % 2 ==0){
//         System.out.println("Even");
//      }
//      else{
//         System.out.println("odd");
//      }

//     }
// }
// import java.util.Scanner;

// public class hello{
// 	public static void main(String args[]){
// 	Scanner scanner = new Scanner(System.in); 
        
//         String name = scanner.nextLine();
//         int total =scanner.nextInt();
//         scanner.nextLine(); 
//         String dept =scanner.nextLine();
//         System.out.println("Enter your Name" + name);

//         System.out.println("Enter total Scorce" + total/10);
	    
        
//         System.out.println("Enter your Department" + dept);
        

	
	
	

// }
// }
// public class hello{
// public static void main(String args[]){
// 	int a =5;
// 	if (a%2==0){
// 	System.out.println("Even");
	
// }
// 	else {
// 	System.out.println("odd");
// }
// }
// }

// public class hello{
// public static void main(String args[]){
// 	int score = 80;
// 	if (score <= 50){
// 	System.out.println("You need to improve");

// }
// 	else if(score < 50 && score < 70){
// 	System.out.println("Good job");

// }
// 	else if (score>70){
// System.out.println("Excellent");
// }		

// }
// }

// public class hello{
    
//     public static void main(String args[]){
       
//         for(int i=7;i<=10;i++){
//             System.out.print(i + " ");
//         }
//         System.out.println();
//         for(int i=4;i<=6;i++){
//             System.out.print(i + " ");
//         }
//         System.out.println();
//         for(int i=2;i<=3;i++){
//             System.out.print(i + " ");
        
//         }
//         System.out.println();
//         System.err.println(1);
//     }
// }
// public class hello{
//     public static void main (String args[]){
//         int count =10;
//         int i =4;
//         while (i>=1){
//             int add = count - i + 1;
//             int num = add;
//             while (num <= count){
//                 System.out.print(num + " ");
//                 num ++;
//             } 
//             System.out.println();
//             count = count - i;
//             i--;
//         }
//     }
// }

//public class hello{
//     public static void main(String[] args){
//         String [] word = {"hello","world","java"};
//        for (String w: word){
//         System.out.print(w + " ");
//         }


//     }
// }

// class hello{

//     String studentId;

//     hello(){
//        int studentId = 11244010;
//         System.out.println(studentId);
//     }
//     void display(String Grade){
//         System.out.println("Student Name: Gohul M.R");
//         studentId = Grade;
//         System.out.println("Grade:" + studentId);

//     }
//     public static void main(String[] args){
//         hello id = new hello();
//         id.display("O");
       
        
//     }
// }

// class hello{
//     public static void main(String args[]){ 
        
//       int marks = 40;

// if(marks >= 50)
//     System.out.println("Pass");
// else
//     System.out.println("Fail");
//     }
// }

// class Hello{
//     public static int square(int a){
//     return a *a;
// }
// public static void main(String args[]){
// System.out.println(square(2));
// }
// }

// class Employee{
//     String name;
//     double salary;
//    // String role;
//     void display(){
//         System.out.println("Name:" + name);
//         System.out.println("Salary:" + salary);
//         //System.out.println("Role:" + role);
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         Employee e1 = new Employee();
//         e1.name = "Gohul M.R";
//         e1.salary = 50000;
//         //e1.role = "CEO";
//         e1.display();
//     }
// }


// class Book{
//     String title;
//     double price;
//     Book(String title, double price){
//         this.title = title;
//         this.price = price;
//     }
//     void display(){
//         System.out.println("Title:" + title);
//         System.out.println("Price:" + price);
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         Book b1 = new Book("Java Basics", 499.0);
//         b1.display();
//     }
// }

// class BankAccount{
//     private double balance;
//     public void setBalance(double balance){
//         this.balance = balance;
//     }
//     public double getBalance(){
//         return balance;
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         BankAccount myacc = new BankAccount();
//         myacc.setBalance(10000);
//         System.out.println(myacc.getBalance());

//     }
// }

// class vehicle{
//     String brand;
// }
// class Car extends vehicle{
//     int speed;
// }
// public class hello{
//     public static void main(String[] args){
//         Car mycar = new Car();
//         mycar.brand = "Toyata";
//         mycar.speed = 120;
//         System.out.println("Brand:" + mycar.brand);
//         System.out.println("Speed:" + mycar.speed);
//     }
// }


// class Person{
//     void introduce() {
//         System.out.println("I am a person");
//     }
// }

// class Student extends Person {
//     @Override
//     void introduce() {
//         System.out.println("I am a student");
//     }
// }

// public class hello{
//     public static void main(String[] args){
//         Person p = new Student();
//         p.introduce();

//     }
// }

// abstract class Shape {
//     abstract void draw();
// }

// class Circle extends Shape {
//     @Override
//     void draw(){
//         System.out.println("Drawing a Circle");
//     }
// }
// public class hello{
//     public static void main(String[] args){
//         Shape s = new Circle();
//         s.draw();
//     }
// }

// interface Payment{
//     void pay();
// }

// class CreditCardPayment implements Payment{
//     @Override
//     public void pay(){
//         System.out.println("Payment Done Using Credit Card");
//     }
// }

// public class hello{
//     public static void main(String[] args){
//         Payment paye = new CreditCardPayment();
//         paye.pay();
//     }
// }

// class hello{
//     public static void main(String[] args){
//         int[] num = {1,2,3};
//         try{
//             System.out.println(num[5]);
//                 }
//         catch (ArrayIndexOutOfBoundsException e){
//             System.out.println("Array is limited to 3 elements");
//         }
//         finally{
//             System.out.println("Program can be continued");
//         }
//     }
// } 
// import java.util.ArrayList;
// class hello{
//     public static void main(String[] args){
//         ArrayList<Integer> numbers = new ArrayList<>();
//         numbers.add(10);
//         numbers.add(20);
//         numbers.add(30);
//         numbers.add(40);
//         int sum = 0;
//         for (Integer num : numbers){
//             sum += num;
//         }
//         System.out.println("Sum = " + sum);
//     }
// }

// import java.util.HashMap;
// class hello{
// public static void main(String[] args){
// 	HashMap <Integer, String> students = new HashMap();
// 	students.put(101, "Gohul");
// 	students.put(102, "Rahul");
// 	students.put(103, "Priya");
// 	System.out.println(students.get(102));
// }
// }

// import java.util.HashSet;
// class hello{
// 	public static void main(String[] args){
// 		HashSet<String> fruits = new HashSet<>();
// 		fruits.add("Apple");
// 		fruits.add("Banana");
// 		fruits.add("Apple");
// 		fruits.add("Mango");
// 		System.out.println(fruits);
// 	}
// }

// import java.io.FileWriter;
// import java.io.IOException;
// class Student{
// 	public void student(){
// 	try{
// 		FileWriter writer = new FileWriter("notes.txt");
// 		writer.write("Learning Java");
// 		writer.close();
// 		System.out.println("Saved Successfully");
// 	}
// 	catch (IOException e) {
// 		System.out.println("An error occurred while writing to the file.");
// 	}
// 	}
	
// }
// public class hello{
// 	public static void main(String[] args){
// 		Student s = new Student();
// 		s.student();
// 	}
// }


//@FunctionalInterface
// interface  Square{
//     int find(int n);
// } 
// public class hello{
//     public static void main(String[] args){
//         Square s = (n) -> n * n;
//         System.out.println(s.find(5));
//     }
// }

// @FunctionalInterface
// interface Message{
//     void show();

// }

// public class hello{
//     public static void main(String[] args){

//         Message m = () -> System.out.println("welcome to java 8");
//         m.show();
//     }
// }

// import java.util.ArrayList;

// class City{

    

//     ArrayList<String> cities = new ArrayList<>();
//     City(){
//     cities.add("Chennai");
//     cities.add("Madurai");
//     cities.add("Coimbatore");
//     }

//     void display(){

//     cities.forEach(System.out::println);

//     }

// }

// class Square{

//     ArrayList<Integer> num = new ArrayList<>();
//     int n;
//     Square(){
//         num.add(2);
//         num.add(3);
//         num.add(4);
//     }
//     void display(){
//         System.out.println(n * n);
//         num.forEach(System.out::println);
//     }

// }

// public class hello {
//     public static void main(String[] args){
//         City c1 = new City();
//         Square s = new Square();
//         s.display();
//         c1.display();
//     }
// }

// import java.util.ArrayList;

// class hello{
//     public static void main(String[] args){
//     ArrayList<Integer> num = new ArrayList<>();
    
//     num.add(12);
//     num.add(25);
//     num.add(8);
//     num.add(40);
//     num.add(19);

//     num.stream()
//         .filter (n -> n > 20)
//         .forEach(System.out::println);


//     }
// }

// import java.util.ArrayList;

// class hello{
//     public static void main(String[] args){
//         ArrayList<Integer> marks = new ArrayList<>();
//         marks.add(60);
//         marks.add(75);
//         marks.add(90);
//         marks.stream()
//             .map(n -> n+10)
//             .forEach(System.out::println);


//     }
// }

import java.util.ArrayList;

// class hello{
//     public static void main(String[] args){
//         ArrayList<Integer> numbers = new ArrayList<>();
//         numbers.add(5);
//         numbers.add(10);
//         numbers.add(15);
//         numbers.add(20);
//         numbers.add(25);
//         numbers.add(30);
//         numbers.stream()
//             .filter(n -> n > 10)
//             .map(n -> n*3)
//             .forEach(System.out::println);


//     }
// }

