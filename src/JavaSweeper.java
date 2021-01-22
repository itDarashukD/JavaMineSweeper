import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sweeper.Box;
import sweeper.Coordinate;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame {

    private Game game;
    private JPanel panel;
    //можно вынести в ENUM
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;
    private final int BOMBS = 10;

    public static void main(String[] args) {

        new JavaSweeper();
    }


    private JavaSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        setImage();
        initPanel();
        initFrame();
    }

    //создаем окошко
    private void initFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaSweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon")); //иконка самой програмки влевом верхнем углу и в панели винды
        pack();

    }

    //инитифлизируем панель
    private void initPanel() {
        panel = new JPanel() {
            //отбражаем картинки из ресурсов
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coordinate coordinate : Ranges.getAllCoordinates()
                ) {
                    g.drawImage((Image) game.getBox(coordinate).image, coordinate.x * IMAGE_SIZE, coordinate.y * IMAGE_SIZE, this);
                }
            }
        };
        //добавляем работу мышкой
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //получили место куда кликнули мышкой и записали в переменную coordinate
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coordinate coordinate = new Coordinate(x, y);
                //при нажатии левой кнопкой мыши
                if (e.getButton()==MouseEvent.BUTTON1){
                    game.pressLeftButton(coordinate);
                    //обновить панель, иначе изменения не будут видны
                    panel.repaint();
                }


            }
        });
        panel.setPreferredSize(new

                Dimension(Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE));//задаем размеры окна

        add(panel);

    }

    //перебираем все инама BOX и присваиваем картинку каждому значению
    private void setImage() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name());
        }
    }

    //загружаем картинки из ресурсов
    private Image getImage(String name) {
        String fileName = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();

    }
}
