package patterns.behavioural.chain.of.responsibility.cqs;

public class Query {
    public String creatureName;
    public enum Argument {
        ATTACK, DEFENSE
    }
    public Argument argument;
    public int result;

    public Query(String creatureName, Argument argument, int result) {
        this.creatureName = creatureName;
        this.argument = argument;
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
