import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;

public class Robot {
    private int X;
    private int Y;
    private Direction direction;

    public void MoveRobot(int currentX, int currentY, Direction nowDirection) {
        this.X = currentX;
        this.Y = currentY;
        this.direction = nowDirection;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    private void changeDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public void turnLeft() {
        System.out.println("Поворот против часовой стрелки");
        switch (direction) {
            case DOWN:
                changeDirection(Direction.RIGHT);
                break;
            case UP:
                changeDirection(Direction.LEFT);
                break;
            case LEFT:
                changeDirection(Direction.DOWN);
                break;
            case RIGHT:
                changeDirection(Direction.UP);
                break;
        }
    }

    public void turnRight() {
        System.out.println("Поворот по часовой стрелке");
        switch (direction) {
            case DOWN:
                changeDirection(Direction.LEFT);
                break;
            case UP:
                changeDirection(Direction.RIGHT);
                break;
            case LEFT:
                changeDirection(Direction.UP);
                break;
            case RIGHT:
                changeDirection(Direction.DOWN);
                break;
        }
    }

    public void stepForward() {
        System.out.println("Движение");
        switch (direction) {
            case DOWN:
                System.out.println("Вниз");
                this.Y--;
                break;
            case UP:
                System.out.println("Вверх");
                this.Y++;
                break;
            case LEFT:
                System.out.println("Налево");
                this.X--;
                break;
            case RIGHT:
                System.out.println("Направо");
                this.X++;
                break;
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void turn(Robot robot, Direction direction) {
        while (robot.getDirection() != direction) {
            if (robot.getDirection().ordinal() < direction.ordinal()) {
                robot.turnRight();
            } else robot.turnLeft();
        }
    }

    public static void go(Robot robot, int step) {
        for (int i = 0; i < step; i++) {
            robot.stepForward();
        }
    }
}