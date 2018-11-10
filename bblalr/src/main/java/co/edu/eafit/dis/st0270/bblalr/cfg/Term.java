package co.edu.eafit.dis.st0270.bblalr.cfg;

public class Term extends GrmSymSpec {

    private int col;
    private int line;
    private String text;
    
    public Term(Enum id) {
	super(id);
	
	this.text = id.name();
	this.col = this.line = 0;
    }

    public Term(Enum id, String text, int col, int line) {
	super(id);
	
	this.text = text;
	this.col = col;
	this.line = line;
    }

    public int getCol() {
	
	return this.col;
    }

    public int getLine() {

	return this.line;
    }

    public String getText() {

	return this.text;
    }

    public boolean equals(Object o) {

	return (o instanceof Term) && id.ordinal() == o.hashCode();
    }

    public int hashCode() {
	return id.ordinal();
    }
}
