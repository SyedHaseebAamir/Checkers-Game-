public class Move {
    private int fromX;
    private int fromY;
    private int toX;
    private int toY;

    public Move(int fromX, int fromY, int toX, int toY) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }

    public int getFromX() {
        return fromX;
    }

    public void setFromX(int fromX) {
        this.fromX = fromX;
    }

    public int getFromY() {
        return fromY;
    }

    public void setFromY(int fromY) {
        this.fromY = fromY;
    }

    public int getToX() {
        return toX;
    }

    public void setToX(int toX) {
        this.toX = toX;
    }

    public int getToY() {
        return toY;
    }

    public void setToY(int toY) {
        this.toY = toY;
    }

    @Override
    public String toString() {
        return "Move{" +
                "fromX=" + fromX +
                "fromY=" + fromY +
                "toX=" + toX +
                "toY=" + toY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (fromX != move.fromX) return false;
        if (fromY != move.fromY) return false;
        if (toX != move.toX) return false;
        return toY == move.toY;
    }

    @Override
    public int hashCode() {
        int result = fromX;
        result = 31 * result + fromY;
        result = 31 * result + toX;
        result = 31 * result + toY;
        return result;
    }
}
