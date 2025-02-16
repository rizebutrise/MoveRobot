import java.awt.*;

public class MoveRobot {
    private int X;
    private int Y;
    private Direction direction;

    public MoveRobot(int currentX, int currentY, Direction nowDirection) {
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

    public static void moveRobot(MoveRobot robot, int toX, int toY) {

        if (robot.getY() < toY) {
            while (robot.getDirection() != Direction.UP) robot.turnRight();
            while (robot.getY() < toY) robot.stepForward();
        } else if (robot.getY() > toY) {
            while (robot.getDirection() != Direction.DOWN) robot.turnRight();
            while (robot.getY() > toY) robot.stepForward();
        }
        if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT) robot.turnRight();
            while (robot.getX() < toX) robot.stepForward();
        } else if (robot.getX() > toX) {
            while (robot.getDirection() != Direction.LEFT) robot.turnRight();
            while (robot.getX() > toX) robot.stepForward();

        }
    }
}
