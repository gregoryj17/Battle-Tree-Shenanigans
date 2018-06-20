import java.util.*;
import java.io.*;

public class battletreeanalysis{
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner scan = new Scanner(new File("battletreestuff.txt"));
		PrintWriter write = new PrintWriter("battletreesets.txt");
		while(scan.hasNextLine()){
			String output = "";
			output+=scan.nextLine();
			output+="\n";
			scan.nextLine();
			output+=scan.nextLine()+"\r";
			output+=scan.nextLine()+"\r";
			output+=scan.nextLine()+"\r";
			output+=scan.nextLine()+"\r";
			output+="\n";
			scan.nextLine();
			scan.nextLine();
			output+=scan.nextLine();
			scan.nextLine();
			write.println(output);
			
		}
		write.close();
	
	}
}
