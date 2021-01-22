package sweeper;

public class Game {

    Bomb bomb;

    public Game(int cols, int rows) {
        Ranges.setSize(new Coordinate(cols, rows));
    }

    public void start() {
        bombMap = new Matrix(Box.BOMB);
    }

    public Box getBox(Coordinate coordinate) {
        return bombMap.get(coordinate);
    }
}
