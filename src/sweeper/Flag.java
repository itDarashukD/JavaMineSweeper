package sweeper;

class Flag {
    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().x * Ranges.getSize().y;

    }

    Box get(Coordinate coordinate) {
        return flagMap.get(coordinate);
    }

    //указанным координатам установит поле ОПЕН
    void setOpenedToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.OPENED);
        countOfClosedBoxes--;

    }


    //если стоит флаг то закрыть клетку, если она закрыта,то ставить флаг
    public void toggleFlagetToBox(Coordinate coordinate) {
        switch (flagMap.get(coordinate)) {
            case FLAGED:
                setCloseToBox(coordinate);
                break;
            case CLOSED:
                setFlagToBox(coordinate);
                break;

        }
    }

    //указанным координатам установит флаг
    private void setFlagToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.FLAGED);

    }

    //можно не только ставить флаги но и убирать
    private void setCloseToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.CLOSED);
    }

    int getCountOdCloseBoxes() {

        return countOfClosedBoxes;
    }

    void setBombedToBox(Coordinate coordinate) {

        flagMap.set(coordinate, Box.BOMBED);
    }

    //если закрыто - открыть
    public void setOpenedtoCloseBombBox(Coordinate coord) {

        if (flagMap.get(coord) == Box.CLOSED) {
            flagMap.set(coord, Box.OPENED);
        }

    }

    //если клетка помечена флагом то возможно ошибка
    public void setNoBombToFlagedSafeBox(Coordinate coord) {

        if (flagMap.get(coord) == Box.FLAGED) {
            flagMap.set(coord, Box.NOBOMB);
        }

    }

      int getCountOfFlaggedBoxesAround(Coordinate coordinate) {
        int count = 00;
        for (Coordinate around : Ranges.getCoordAround(coordinate)
        ) {
            if (flagMap.get(around) == Box.FLAGED) {
                count++;

            }
        }
        return count;
    }
}
