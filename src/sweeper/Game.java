package sweeper;

public class Game {

  private   Bomb bomb;
  private Flag flag;

    public Game(int cols, int rows,int bombs) {
        Ranges.setSize(new Coordinate(cols, rows));
        bomb =new Bomb(bombs);
        flag = new Flag();

    }

    public void start() {

       bomb.start();
        flag.start();
    }

    public Box getBox(Coordinate coordinate) {
            //если верхний сло открыт, то показываем нижний слой
         if (flag.get(coordinate)==Box.OPENED){
             return bomb.get(coordinate);
         }
         else
        //возвращием верхний слой
        return flag.get(coordinate);
    }
//открыть указанное поле нажатием левой кнопки мыши
    public void pressLeftButton(Coordinate coordinate) {

        flag.setOpenedToBox(coordinate);

    }
    //  нажатием левой кнопки мыши установить флаг
    public void pressRightButton(Coordinate coordinate) {
        flag.toggleFlagetToBox(coordinate);
    }
}
