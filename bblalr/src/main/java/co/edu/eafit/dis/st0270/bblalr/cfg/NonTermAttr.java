package co.edu.eafit.dis.st0270.bblalr.cfg;

public class NonTermAttr<T> extends NonTerm {
    private T attr;

    public NonTermAttr(Enum id, T attr) {
	super(id);
	
	this.attr = attr;
    }

    public T getAttr() {
	return attr;
    }
}
