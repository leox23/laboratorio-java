package model;

public class Answer {
    private Integer id;
    private String text;
    private Integer isRight;

    public Answer(Integer id, String text, Integer isRight) {
        this.id = id;
        this.text = text;
        this.isRight = isRight;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}