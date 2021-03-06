package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {

    private static Coordinate size;
    private static ArrayList<Coordinate> allCoordinates;
    private static Random random = new Random();

    public static Coordinate getSize() {
        return size;
    }

    //перебираем все координаты - очень удобный способ
    static void setSize(Coordinate size) {
        Ranges.size = size;
        allCoordinates = new ArrayList<>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoordinates.add(new Coordinate(x, y));
            }

        }
    }

    public static ArrayList<Coordinate> getAllCoordinates() {
        return allCoordinates;
    }

    //проверка не выходит-ли точка запределы массива(поля игры)
    static Boolean inRange(Coordinate coordinate) {

        return coordinate.y >= 0 && coordinate.y < size.y &&
                coordinate.x >= 0 && coordinate.x < size.x;
    }

    //получить рандомную координату
    static Coordinate getRandomCoordinate() {
        return new Coordinate(random.nextInt(size.x), random.nextInt(size.y));
    }

    //перебирать все кледки вокруг одной(вокруг бомбы)
    static ArrayList<Coordinate> getCoordAround(Coordinate coordinate) {
        Coordinate around;
        ArrayList<Coordinate> list = new ArrayList<Coordinate>();
        for (int x = coordinate.x - 1; x <= coordinate.x + 1; x++) {
            for (int y = coordinate.y - 1; y <= coordinate.y + 1; y++) {
                if (inRange(around = new Coordinate(x, y))) {
                    if (!around.equals(coordinate)) {
                        list.add(around);
                    }
                }

            }

        }
        return list;
    }
}
