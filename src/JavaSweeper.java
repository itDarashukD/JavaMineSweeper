import javax.swing.*;
import java.awt.*;

import sweeper.Box;
import sweeper.Coordinate;

public class JavaSweeper extends JFrame {

    private JPanel panel;
    //можно вынести в ENUM
    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {

        new JavaSweeper();
    }


    private JavaSweeper() {
        setImage();
        initPanel();
        initFrame();
    }

    //создаем окошко
    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaSweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon")); //иконка самой програмки влевом верхнем углу и в панели винды


    }
    //инитифлизируем панель

    private void initPanel() {
        panel = new JPanel() {
            //отбражаем картинки из ресурсов
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values()
                ) {
                    Coordinate coordinate = new Coordinate(box.ordinal() * IMAGE_SIZE, 0);

                    g.drawImage((Image) box.image, coordinate.x,coordinate.y, this);

                }

            }
        };

        panel.setPreferredSize(new

                Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));//задаем размеры окна

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
