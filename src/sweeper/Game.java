package sweeper;

public class Game {

    private Bomb bomb;
    private Flag flag;
    private GameState gameState;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coordinate(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
        gameState = GameState.PLAYED;
    }

    public void start() {

        bomb.start();
        flag.start();
    }

    public GameState getGameState() {
        return gameState;
    }

    public Box getBox(Coordinate coordinate) {
        //если верхний сло открыт, то показываем нижний слой
        if (flag.get(coordinate) == Box.OPENED) {
            return bomb.get(coordinate);
        } else
            //возвращием верхний слой
            return flag.get(coordinate);
    }

    //открыть указанное поле нажатием левой кнопки мыши
    public void pressLeftButton(Coordinate coordinate) {
//        flag.setOpenedToBox(coordinate);

        openBox(coordinate);
        checkWinner();
    }

    //проверка может мы уже победили
    private void checkWinner() {
        if (gameState == GameState.PLAYED) {
            if (flag.getCountOdCloseBoxes() == bomb.getTotalBombs()) {//если количество закрытых боксов = количеству бомб
                gameState = GameState.WINNER;
            }
        }
    }

    private void openBox(Coordinate coordinate) {
        switch (flag.get(coordinate)) {
            case OPENED:
                return;
            case FLAGED:
                return;
            case CLOSED://когда клетка закрыта
                switch (bomb.get(coordinate)) {
                    case ZERO:
                        openBoxesAround(coordinate);
                        return;//если нажали на пустую клетку - открываем все рядом пустые
                    case BOMB:
                        return;
                    default:
                        flag.setOpenedToBox(coordinate);
                        return;//если снизу цифра
                }
        }

    }

    //если нажали на пустую клетку - открываем все рядом пустые
    private void openBoxesAround(Coordinate coordinate) {
        flag.setOpenedToBox(coordinate);//отрываем текующую клетку
        for (Coordinate around : Ranges.getCoordAround(coordinate)//отрываем рядом стекущей клеткой
        ) {
            openBox(around);

        }


    }

    //  нажатием левой кнопки мыши установить флаг
    public void pressRightButton(Coordinate coordinate) {
        flag.toggleFlagetToBox(coordinate);
    }
}
