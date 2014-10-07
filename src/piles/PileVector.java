package piles;

import java.util.Vector;

public class PileVector implements Pile {

	public Vector<Object> pile;
	
	public PileVector(){
		this.pile = new Vector<Object>();
	}
	
	public PileVector(Pile p){
		Vector<Object> t = new Vector<Object>();
		this.pile = new Vector<Object>();
		for (int i=0;i<p.size();i++){
			Object x = p.pop();
			System.out.print(x);
			t.add(x);
		}
		for (int i=t.size()-1;i>=0;i--){
			this.push(t.elementAt(i));
			p.push(t.elementAt(i));
		}
	}
	
	@Override
	public boolean empty() {
		return this.pile.isEmpty();
	}

	@Override
	public boolean full() {
		return true;
	}

	@Override
	public Object peek() {
		if (this.empty()) return null;
		else return this.pile.lastElement();
	}

	@Override
	public Object pop() {
		if (this.empty())return null;
		else {
			Object p = this.peek();
			this.pile.remove(this.pile.size()-1);
			return p;
		}
	}

	@Override
	public boolean push(Object o) {
		return this.pile.add(o);
	}

	@Override
	public int search(Object o) {
        int index = this.pile.lastIndexOf(o);
        if (index == -1)  return index;
        else return (this.pile.size()-index);
	}
	
	@Override
	public String toString(){
		String s = "";
        for (int i = 0; i < this.pile.size(); i++){
            s += "\n";
            s += pile.elementAt(i);
            if (i < this.pile.size()-1) s+= ",";
        }
		return s;
	}

	@Override
	public int size() {
		return this.pile.size();
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof PileVector){
			return true;
		}
		else return false;
	}
	
}
