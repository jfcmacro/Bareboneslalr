package co.edu.eafit.dis.st0270.bblalr.cfg;

public abstract class GrmSym {
    protected Enum id;

    public GrmSym(Enum id) {
	this.id = id;
    }

    public int hashCode() {
	return id.ordinal();
    }
}
