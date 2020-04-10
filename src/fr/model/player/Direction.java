package fr.model.player;

public enum Direction {

    NORTH("North"),
    EAST("East"),
    SOUTH("South"),
    WEST("West");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    public String toString() { return name; }

}
