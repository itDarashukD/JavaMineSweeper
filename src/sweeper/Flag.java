package sweeper;

class Flag {
    private Matrix flagMap;

    void start() {
        flagMap = new Matrix(Box.CLOSED);

    }

    Box get(Coordinate coordinate) {
        return flagMap.get(coordinate);
    }

    //указанным координатам установит поле ОПЕН
    void setOpenedToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.OPENED);

    }
}
