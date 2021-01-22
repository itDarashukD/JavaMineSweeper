package sweeper;

class Flag {
    private Matrix flagMap;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        //открыть центральную клетку
        flagMap.set(new Coordinate(4,4) ,Box.OPENED);
    }

    Box get(Coordinate coordinate) {
        return flagMap.get(coordinate);
    }
}
