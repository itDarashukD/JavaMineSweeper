package sweeper;

class Flag {
    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes=Ranges.getSize().x*Ranges.getSize().y;

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
        switch (flagMap.get(coordinate)){
            case FLAGED:setCloseToBox(coordinate);break;
            case CLOSED:setFlagToBox(coordinate);break;

        }
    }
    //указанным координатам установит флаг
    private void setFlagToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.FLAGED);

    }
//можно не только ставить флаги но и убирать
    private void setCloseToBox(Coordinate coordinate) {
        flagMap.set(coordinate,Box.CLOSED);
    }

     int getCountOdCloseBoxes() {

        return countOfClosedBoxes;
    }
}
