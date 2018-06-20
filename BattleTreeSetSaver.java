import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class BattleTreeSetSaver {

	/* Name
	 * "Attacks:"
	 * Move 1
	 * Move 2
	 * Move 3
	 * Move 4
	 * "Hold Item:"
	 * Item
	 * \n
	 */
	
	public static ArrayList<Pokemon> mons;
	private static DecimalFormat df = new DecimalFormat("##.#");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan=new Scanner(new File("battletreesets.txt"));
		String line="";
		String name="";
		String move1="";
		String move2="";
		String move3="";
		String move4="";
		String item="";
		mons=new ArrayList<Pokemon>();
		do{
			name=scan.nextLine();
			name=name.replace(" ","");
			line=scan.nextLine();
			move1=scan.nextLine();
			move2=scan.nextLine();
			move3=scan.nextLine();
			move4=scan.nextLine();
			line=scan.nextLine();
			item=scan.nextLine();
			boolean exists=false;
			for(int i=0;i<mons.size();i++){
				if(mons.get(i).getName().equals(name)){
					exists=true;
					break;
				}
			}
			if(!exists)mons.add(new Pokemon(name));
			int index=-1;
			for(int i=0;i<mons.size();i++){
				if(mons.get(i).getName().equals(name)){
					index=i;
					break;
				}
			}
			if(index!=-1){
				mons.get(index).addMove(move1);
				mons.get(index).addMove(move2);
				mons.get(index).addMove(move3);
				mons.get(index).addMove(move4);
				mons.get(index).addItem(item);
				mons.get(index).addSet();
			}
			line=scan.nextLine();
		}while(!line.equals("END"));
		scan.close();
		for(int dist=mons.size();dist>1;dist--)
		{
			boolean didSwap=false;
			for(int i=0;i<dist-1;i++)
			{
				if(mons.get(i).getName().compareTo(mons.get(i+1).getName())>0)
				{
					Pokemon temp=mons.get(i);
					mons.set(i,mons.get(i+1));
					mons.set(i+1,temp);
					didSwap=true;
				}
			}
			if(!didSwap)break;
		}
		for(int i=0;i<mons.size();i++){
			try {
				PrintWriter out = new PrintWriter("data/"+mons.get(i).getName()+".txt");
				mons.get(i).sort();
				ArrayList<String> moves=mons.get(i).getMoves();
				ArrayList<Integer> mFreq=mons.get(i).getMFreq();
				ArrayList<String> items=mons.get(i).getItems();
				ArrayList<Integer> iFreq=mons.get(i).getIFreq();
				int sets=mons.get(i).getSets();
				out.println(mons.get(i).getName()+", "+sets+" sets");
				out.println("Moves:");
				for(int j=0;j<moves.size();j++){
					out.println(moves.get(j)+" * "+mFreq.get(j)+", \r"+df.format(100.0*mFreq.get(j)/sets)+"% of sets");
				}
				out.println("\n");
				out.println("Items:");
				for(int j=0;j<items.size();j++){
					out.println(items.get(j)+" * "+iFreq.get(j)+", \r"+df.format(100.0*iFreq.get(j)/sets)+"% of sets");
				}
				out.close();
			} catch (FileNotFoundException e) {}
		}
		try{
			PrintWriter out=new PrintWriter("data/245monscombined.txt");
			for(int i=0;i<mons.size();i++){
				mons.get(i).sort();
				ArrayList<String> moves=mons.get(i).getMoves();
				ArrayList<Integer> mFreq=mons.get(i).getMFreq();
				ArrayList<String> items=mons.get(i).getItems();
				ArrayList<Integer> iFreq=mons.get(i).getIFreq();
				int sets=mons.get(i).getSets();
				out.println(mons.get(i).getName()+", "+sets+" sets");
				out.println("Moves:");
				for(int j=0;j<moves.size();j++){
					out.println(moves.get(j)+" * "+mFreq.get(j)+", \r"+df.format(100.0*mFreq.get(j)/sets)+"% of sets");
				}
				out.println("\n");
				out.println("Items:");
				for(int j=0;j<items.size();j++){
					out.println(items.get(j)+" * "+iFreq.get(j)+", \r"+df.format(100.0*iFreq.get(j)/sets)+"% of sets");
				}
				out.println();
			}
			out.close();
		}catch(Exception e){}
		try{
			PrintWriter out = new PrintWriter("pokemonlist.txt");
			for(int i=0;i<mons.size();i++){
				out.println(mons.get(i).getName());
			}
			out.close();
		}catch(Exception e){}
	}

}
