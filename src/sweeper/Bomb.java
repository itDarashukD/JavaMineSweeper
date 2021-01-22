package sweeper;

class Bomb {

    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    //размещаем несколько бомб = totalBombs
    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i <totalBombs ; i++) {
            placeBomb();
        }

    }


    Box get (Coordinate coordinate){
        return bombMap.get(coordinate);
    }

    //для размещения одной бомбы со случайными координатами
    private void placeBomb() {
        Coordinate coordinate = Ranges.getRandomCoordinate();
        bombMap.set(coordinate, Box.BOMB);
        for (Coordinate around: Ranges.getCoordAround(coordinate)
             ) {bombMap.set(around,Box.NUM1);

        }
            
        }
    }


