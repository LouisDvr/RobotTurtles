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

    public static Piece getPieceByName(String name) {

        switch (name) {
            case "Jewel":
                return Piece.JEWEL;
            case "StoneWall":
                return Piece.STONEWALL;
            case "IceWall":
                return Piece.ICEWALL;
            case "Empty":
                return EMPTY;
            default:
                return Piece.TURTLE;
        }
    }

}
