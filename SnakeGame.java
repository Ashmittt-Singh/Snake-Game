import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGame extends JFrame {
    private Board board;
    private Snake snake;

    public SnakeGame() {
        board = new Board();
        snake = new Snake();

        add(board);
        pack();
        setResizable(false);

        // Add keyboard event listener to handle user input
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    snake.setDirection(Snake.Direction.UP);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    snake.setDirection(Snake.Direction.DOWN);
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    snake.setDirection(Snake.Direction.LEFT);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    snake.setDirection(Snake.Direction.RIGHT);
                }
            }
        });

        // Start game loop
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.update();
                board.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.setVisible(true);
    }
}

class Board extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Render game board and snake here
    }
}

class Snake {
    private int x, y;
    private Direction direction;

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public Snake() {
        x = 10; 
        y = 10;
        direction = Direction.UP;
    }

    public void update() {
        // Update snake position based on direction
        switch (direction) {
            case UP:
                y -= 10;
                break;
            case DOWN:
                y += 10;
                break;
            case LEFT:
                x -= 10;
                break;
            case RIGHT:
                x += 10;
                break;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}