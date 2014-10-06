package piles;

import java.util.Objects;
import java.util.Vector;

public class PileVector implements Pile {

	protected Vector<Object> pile;
	
	public PileVector(){
		super();
		this.pile = new Vector<Object>();
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
}
