package piles;

import tables.Table;

public class PileTable implements Pile {

	private int current;
	private Table pile;

    public PileTable(){
        this(10);
    }

    public PileTable(int n){
        this.pile = new Table(n);
        this.current = -1;
    }

    public PileTable(Pile p) {
        this(p.size());
        Pile tmp = new PileTable(p.size());
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
        return current == -1;
	}

	@Override
	public boolean full() {
        return current == this.pile.size()-1;
	}

	@Override
	public Object peek() {
		if (current == -1) return null;
        else return pile.getValAt(current);
	}

	@Override
	public Object pop() {
		if (current == -1) return null;
        else {
            Object o = this.pile.getValAt(current);
            pile.setValAt(current,null);
            current -= 1;
            return o;
        }
	}

	@Override
	public boolean push(Object o) {
        if (this.current >= this.pile.size()-1) return false;
        else {
            current += 1;
            this.pile.setValAt(current,o);
            return true;
        }
	}

	@Override
	public int search(Object o) {
		if (current == -1) return -1;
        for(int i=0; i<this.size(); i++){
            if (o.equals(this.pile.getValAt(i))) return i+1;
        }
        return -1;
	}

    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < this.size(); i++){
            s += "\n";
            s += pile.getValAt(i);
            if (i < this.size()-1) s+= ",";
        }
        return s;
    }

	@Override
	public int size() {
		return this.current+1;
	}

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (!(o instanceof Pile)) return false;
        if (this.size()!=((Pile) o).size()) return false;
        Pile tmp1 = new PileTable((Pile) o);
        Pile tmp2 = new PileTable(this);
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
        Pile tmp = new PileTable(this);
        while (!tmp.empty()){
            Object elt = tmp.pop();
            hash = (hash * prime)+(elt == null ? 0 : elt.hashCode());
        }
        return hash;
    }
}
