package model;

/**
 * Clase tipo player, con atributos id, name y score que representa el modelo player de la base de datos
 */
public class Player {
    private Integer id;
    private String name;
    private Integer score;

    public Player(Integer id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Player(String name, Integer score) {
        this.id = null;
        this.name = name;
        this.score = score;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
