package fr.player;

public enum Card {
    FORWARD("Forward", 18),
    LEFT("Left", 8),
    RIGHT("Right", 8),
    LASER("Laser", 3);

    private String name;
    private int number;

    Card(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() { return name; }

    public int getNumber() { return number; }


}
