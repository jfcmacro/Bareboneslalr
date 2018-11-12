package co.edu.eafit.dis.st0270.bblalr.frontend;

public interface Parser<T> {
    public T parse();
    public void setLexer(Lexer lexer);
    public void reset();
}
