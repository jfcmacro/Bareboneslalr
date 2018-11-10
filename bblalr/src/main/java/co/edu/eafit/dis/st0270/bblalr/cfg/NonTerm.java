package co.edu.eafit.dis.st0270.bblalr.cfg;

public class NonTerm extends GrmSymSpec {

    public NonTerm(Enum id) {
	super(id);
    }

    public boolean equals(Object o) {
	return (o instanceof NonTerm) && id.ordinal() == o.hashCode();
    }
}
