import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc = new Scanner(System.in);  
		String name = sc.next();  
		System.out.println("Hello world I am " + name);*/
		static String filename = "Input your filename here";
    		public static void main(String[] args) {
		System.out.println("Hello world I'm TDTU");
		int count= 0;
		try{
		    Scanner sc = new Scanner(new FileReader(new File(filename)) );
		    while (sc.hasNext()){
			String line = sc.next();
			System.out.println("Helo world, I'm " + line);
			count++;
		    }

		} catch(IOException e){

		}
		System.out.println("Total " + count + " students");
    }  
	} 

}
  
 
  
