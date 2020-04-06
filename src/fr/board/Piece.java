package fr.board;

public enum Piece {
    TURTLE("Turtle"),
    JEWEL("Jewel"),
    STONEWALL("StoneWall"),
    ICEWALL("IceWall"),
    EMPTY("Empty");

    private String name;

    Piece(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
