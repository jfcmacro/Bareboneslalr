package co.edu.eafit.dis.st0270.bblalr.cfg;

import java.util.Map;
import java.util.List;

public class CFG {

    private List<Term> sigma;
    private List<NonTerm> v;
    private Map<NonTerm, List<GrmSymSpec>> prods;
    private NonTerm axiom;

    public CFG(List<Term> sigma,
	       List<NonTerm> v,
	       Map<NonTerm, List<GrmSymSpec>> prods,
	       NonTerm axiom) {

	this.sigma = sigma;
	this.v = v;
	this.prods = prods;
	this.axiom = axiom;
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
