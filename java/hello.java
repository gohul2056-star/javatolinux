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

public class hello{
    public static void main(String args[]){
        int m1,m2,m3,m4,m5;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter marks for subject 1: ");
        m1 = scan.nextInt();
        System.out.print("Enter marks for subject 2: ");
        m2 = scan.nextInt();
        System.out.print("Enter marks for subject 3: ");
        m3 = scan.nextInt();    
        System.out.print("Enter marks for subject 4: ");
        m4 = scan.nextInt();
        System.out.print("Enter marks for subject 5: ");
        m5 = scan.nextInt();
        int total = m1 + m2 + m3 + m4 + m5;
        int avg = total / 5;
        System.out.println("Total marks: " + total);
        System.out.println("Average marks:" + avg);
        if (avg > 40 ){
            System.out.println ("GOOD TO GO!!!");
        } 
    }
}
