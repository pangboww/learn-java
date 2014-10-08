package piles;

import java.util.Vector;

public class PileVector implements Pile {

	public Vector<Object> pile;
	
	public PileVector(){
		this.pile = new Vector<Object>();
	}

    public PileVector(int size) {
        this.pile = new Vector<Object>(size);
    }

    public PileVector(Pile p) {
        this();
        Pile tmp = new PileVector();
        Object o = new Object();
        while(!p.empty()){
            tmp.push(p.pop());
        }

        while(!tmp.empty()){

            o=tmp.pop();
            this.push(o);
            p.push(o);
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
        if (o == null) return false;
        if (!(o instanceof Pile)) return false;
        if (this.size()!=((Pile) o).size()) return false;
        Pile tmp1 = new PileVector((Pile) o);
        Pile tmp2 = new PileVector(this);
        while (!tmp1.empty()){
            Object tmp = tmp1.pop();
            if (!tmp2.pop().equals(tmp)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int hash = 1;
        Pile tmp = new PileVector(this);
        while (!tmp.empty()){
            Object elt = tmp.pop();
            hash = (hash * prime)+(elt == null ? 0 : elt.hashCode());
        }
        return hash;
    }
	
}
