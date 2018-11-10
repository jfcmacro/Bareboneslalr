package co.edu.eafit.dis.st0270.bblalr.cfg;

public class PilotState extends GrmSym {

    public PilotState(Enum id) {
	super(id);
    }

    public boolean equals(Object o) {
	return o instanceof PilotState && id.ordinal() == o.hashCode();
    }
}
