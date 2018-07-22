package problem.search.entity;

public class Result {
    private String key;
    private int occur;
    private int line;
    private String sentence;

    public Result()
    {

    }
    public Result(String key, int occur, int line, String sentence) {
        this.key = key;
        this.occur = occur;
        this.line = line;
        this.sentence = sentence;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getOccur() {
        return occur;
    }

    public void setOccur(int occur) {
        this.occur = occur;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
