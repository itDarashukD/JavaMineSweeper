package sweeper;

class Bomb {

    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixBombCounts();
    }

    //размещаем несколько бомб = totalBombs
    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }

    }


    Box get(Coordinate coordinate) {
        return bombMap.get(coordinate);
    }
    //максимальное количество бомб
    private void fixBombCounts(){
        int maxBombs=Ranges.getSize().x*Ranges.getSize().y/2;
        if (totalBombs >maxBombs) {
            totalBombs=maxBombs;
        }
    }

    //для размещения одной бомбы со случайными координатами
    private void placeBomb() {
        while (true) {
            Coordinate coordinate = Ranges.getRandomCoordinate();//создаем коорд для размещения бомбы
            if (Box.BOMB == bombMap.get(coordinate))//если на этом месте бомба уже есть ,то пропускаем     continue;
                continue;
            bombMap.set(coordinate, Box.BOMB);
            incNumbersAroundBombs(coordinate);
            break;
        }
    }

    //размещение вокруг каждой бомбы единичек 1
    private void incNumbersAroundBombs(Coordinate coordinate) {
        for (Coordinate around : Ranges.getCoordAround(coordinate)
        ) {
            if (Box.BOMB != bombMap.get(around)) { //проверяем не установленая ли на месте куда мы хотим установить единицу -  БОМБА
                bombMap.set(around, bombMap.get(around).getNextNumbewBox());//установка других цифр около бомб
            }


        }
    }


}