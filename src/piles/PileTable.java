package piles;

import tables.Table;

public class PileTable implements Pile {

	private int current;
	private Table pile;

    public PileTable(int n){
        super();
        this.pile = new Table(n);
        this.current = -1;
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
        for(int i=this.pile.size()-1; i>-1; i--){
            if (o.equals(this.pile.getValAt(i))) return 5-i;
        }
        return -1;
	}

    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < this.pile.size(); i++){
            s += "\n";
            s += pile.getValAt(i);
            System.out.print("test:"+i+"--"+pile.getValAt(i));
            if (i < this.pile.size()-1) s+= ",";
        }
        return s;
    }
}
