import java.util.ArrayList;

public class Pokemon {
	public String name;
	public ArrayList<String> moves=new ArrayList<String>();
	public ArrayList<Integer> mFreq=new ArrayList<Integer>();
	public ArrayList<String> items=new ArrayList<String>();
	public ArrayList<Integer> iFreq=new ArrayList<Integer>();
	public int sets=0;
	
	public Pokemon(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addMove(String move){
		if(move.equals(" "))return;
		if(moves.contains(move)){
			int index=moves.indexOf(move);
			mFreq.set(index, mFreq.get(index)+1);
		}
		else{
			moves.add(move);
			mFreq.add(1);
		}
	}
	
	public ArrayList<String> getMoves(){
		return moves;
	}
	
	public ArrayList<Integer> getMFreq(){
		return mFreq;
	}
	
	public void addSet(){
		sets++;
	}
	
	public int getSets(){
		return sets;
	}
	
	public void addItem(String item){
		if(items.contains(item)){
			int index=items.indexOf(item);
			iFreq.set(index, iFreq.get(index)+1);
		}
		else{
			items.add(item);
			iFreq.add(1);
		}
	}
	
	public ArrayList<String> getItems(){
		return items;
	}
	
	public ArrayList<Integer> getIFreq(){
		return iFreq;
	}
	
	public void sort(){
		for(int dist=mFreq.size();dist>1;dist--)
		{
			boolean didSwap=false;
			for(int i=0;i<dist-1;i++)
			{
				if(mFreq.get(i)<mFreq.get(i+1))
				{
					int temp=mFreq.get(i);
					mFreq.set(i,mFreq.get(i+1));
					mFreq.set(i+1,temp);
					String stemp=moves.get(i);
					moves.set(i,moves.get(i+1));
					moves.set(i+1,stemp);
					didSwap=true;
				}
			}
			if(!didSwap)break;
		}
		for(int dist=iFreq.size();dist>1;dist--)
		{
			boolean didSwap=false;
			for(int i=0;i<dist-1;i++)
			{
				if(iFreq.get(i)<iFreq.get(i+1))
				{
					int temp=iFreq.get(i);
					iFreq.set(i,iFreq.get(i+1));
					iFreq.set(i+1,temp);
					String stemp=items.get(i);
					items.set(i,items.get(i+1));
					items.set(i+1,stemp);
					didSwap=true;
				}
			}
			if(!didSwap)return;
		}
	}
	
}
