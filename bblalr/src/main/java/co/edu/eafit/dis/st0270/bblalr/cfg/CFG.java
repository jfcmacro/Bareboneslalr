package co.edu.eafit.dis.st0270.bblalr.cfg;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.EnumSet;

public class CFG {

    private Set<Term> sigma;
    private Set<NonTerm> v;
    private Map<NonTerm, List<List<GrmSymSpec>>> prods;
    private NonTerm axiom;

    public CFG(EnumSet sigma,
	       EnumSet v,
	       Map<Enum, List<List<Enum>>> prods,
	       INonTerm axiom)
	throws CFGException {

	createSetTerm(sigma);
	createSetNonTerm(v);
	createAxiom(axiom);
	createProds(prods);
    }

    // private boolean isEnumTermClass(Enum e) {
    // 	return enumTermClass.equals(e.getClass());
    // }

    // private boolean isEnumNonTermClass(Enum e) {
    // 	return enumNonTermClass.equals(e.getClass());
    // }

    private int getOrdinal(ITerm e) {
	return ((Enum) e).ordinal();
    }

    private int getOrdinal(INonTerm e) {
	return ((Enum) e).ordinal();
    }

    private void createSetTerm(EnumSet<ITerm> sigma) {

	if (sigma.isEmpty())
	    throw new CFGException("No values in EnumSet<TermEnum>");

	this.sigma = new HashSet<>();

	for (ITerm e : sigma)
	    this.sigma.add(new Term(getOrdinal(e)));
    }

    private void createSetNonTerm(EnumSet<INonTerm> v) {
	if (v.isEmpty())
	    throw new CFGException("No values in EnumSet<NonTermEnum>");

	this.v = new HashSet<>();
	for (INonTerm e : v)
	    this.v.add(new Term(getOrdinal(e)));
    }

    private void createAxiom(Enum start)
	throws CFGException {
	this.axiom = new NonTerm(start.ordinal());
	if (!this.nonterms.contains(this.axiom))
	    throw new CFGException("Axiom is not in v");
    }

    private void createProds(Map<Enum, List<List<Enum>>> prods)
	throws CFGException {
	this.prods = new Map<>();

	for (Map.entry<Enum, List<List<Enum>>> entry : prods.entrySet()) {
	    NonTerm nt = new NonTerm(entry.getKey().ordinal());

	    if (!this.nonterms.contains(nt))
		throw new CFGException("NonTerm: " + nt +
				       " not defined in V");

	    List<List<Enum>> listProds = entry.getValue();
	    List<List<GrmSymSpec >> listofLists = new List<>();

	    for (List<Enum> listseq : listProds) {
		List<GrmSymSpec> list = new List<>();
		for (Enum e : listseq) {
		    if (isEnumTermClass(e)) {
			list.add(new Term(e.ordinal()));
		    }
		    else if (isEnumNonTermClass(e)) {
			list.add(new NonTerm(e.ordinal()));
		    }
		    else {
			throw new CFGException("Invalid enumeration" + e.getClass());
		    }
	        }
		listofLists.add(list);
	    }
	    this.prods.put(nt, listProds);
	}
    }

    public List<Term> getTerms() {
	return this.sigma;
    }

    public List<NonTerm> getNonTerms() {
	return this.v;
    }

    public Map<NonTerm, List<GrmSymSpec>> getProds() {
	return prods;
    }

    public NonTerm getAxiom() {
	return axiom;
    }
}
