package model;

/**
 * Clase tipo Answer, contiene su id, su contenido, y si es correcta.
 */
public record Answer(String text, Integer isRight) {
    public String getText() {
        return text;
    }
    public Integer getIsRight() {
        return isRight;
    }
}
