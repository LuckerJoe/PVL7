package pvl7;
import java.util.ArrayList;
import java.util.List;

public class pvl7 implements Ipvl7{
	
	int id;
	ArrayList<pvl7>connections;
	static int numberlist=0;
	public static ArrayList<pvl7>alle=new ArrayList<pvl7>();
	public List<List<Integer>>nGons=new ArrayList<List<Integer>>();
	
	public pvl7() {
		
	}
	
    @Override
    public int newNode() { //hier zu void ändern?
    	pvl7 node=new pvl7();
    	node.connections=new ArrayList<pvl7>();
    	node.id=numberlist;
		numberlist++;
		alle.add(node);
        return 0;
    }

    @Override
    public boolean setEdge(int from, int to) {
    	//System.out.println("NUmberList:"+numberlist);
    	if(to>=numberlist||from>=numberlist)
			return false;
    	if(to<0||from<0)
    		return false;
    	if(to==from)
    		return false;
		if(alle.get(from).setConnections(alle.get(to))==true && alle.get(to).setConnections(alle.get(from))==true)
			return true;
		return false;
    }

    @Override
    public List<List<Integer>> getEdges() {
    	List<List<Integer>> liste=new ArrayList<List<Integer>>();
    	for(int i=0; i<alle.size(); i++) {
			List<Integer> temp =new ArrayList<Integer>();
			
    		for(int k=0; k<alle.get(i).connections.size(); k++) {
    			temp.add(alle.get(i).connections.get(k).getId());
    		}
    		liste.add(temp);
    	}
        return liste;
    }

	@Override
    public List<List<Integer>> getNGons(int n) {
		ArrayList<Integer>temp=new ArrayList<Integer>();
        for(int k=0; k<alle.size(); k++) {
        	this.rek(n, k, k, temp);
        }
    
        for(int i=0; i<nGons.size(); i++) {
        	nGons.get(i).remove(nGons.get(i).size()-1); //removes the final startIndex!
        }
        return this.nGons;
    }
	
	void rek(int n, int startwert, int index, ArrayList<Integer>temp){
		for(int i=0; i<temp.size(); i++) {
			if(temp.size()==(n)) {
				if(index!=startwert)
					return;
			}
			else {
				if(temp.get(i)==index) {//gibt es einen doppelten wert
					return;
				}
			}
		}

		temp.add(index);
		
		if(temp.size()==n+1) {
			if(isDuplicate(temp)) {
				System.out.println("Duplikat: "+temp);
				temp.remove(temp.size()-1);
				return;
			}
			System.out.println("Kein Duplikat: "+temp);
			nGons.add(new ArrayList<>(temp)); //neues Array notwendig, da ansonsten nur die Kopie übergeben wird
			//Die Kopie verschwindet, sobald unten mehrfach "remove" aufgerufen wird
			temp.remove(temp.size()-1);
			return;
		}
		
		for(int i=0; i<alle.get(index).connections.size(); i++) {
			rek(n, startwert, alle.get(index).connections.get(i).getId(), temp);
		}
		
		temp.remove(temp.size()-1);
		return;
	}
	
    private boolean isDuplicate(ArrayList<Integer>temp) {
		
    	int check=0;
    	for(int i=0; i<nGons.size(); i++) {
    		check=0;
    		for(int k=0; k<temp.size(); k++) {
    			if(nGons.get(i).contains(temp.get(k))) {
    				check++;
    			}
    		}
    		if(check>=alle.size()-1) {
    			return true;
    		}
    	}
    	return false;
	}

	@Override
    public boolean hasFullCircle() {
    	ArrayList<Integer>temp=new ArrayList<Integer>();
        if(this.findCircle(0, temp))
        	return true;
        return false;
    }
    
    boolean findCircle(int index, ArrayList<Integer>temp) {
    	System.out.println(index);
    	for(int i=0; i<temp.size(); i++) {
			if(temp.size()==(alle.size())) {
				if(index!=0)
					return false;
				else System.out.println("Final: "+index);
			}
			else {
				if(temp.get(i)==index) {
					return false;
				}
			}
		}
    	
		temp.add(index);
		
		System.out.println("Temp: "+temp);
		
		if(temp.size()==alle.size()+1) {
			temp.remove(temp.size()-1);
			return true;
		}
		
		
		for(int i=0; i<alle.get(index).connections.size(); i++) {
			System.out.println(index+"-"+i);
			if(findCircle(alle.get(index).connections.get(i).getId(), temp)==true) {
				return true;
			}
		}
		temp.remove(temp.size()-1);
		return false;
    }
    
	public int getId(){
		return this.id;
	}
	
	public boolean setConnections(pvl7 node) {
		for(int i=0; i<this.connections.size();i++) {
			if(this.connections.get(i)==node)
				return false;
		}
		this.connections.add(node);
		return true;
	}
	
}
