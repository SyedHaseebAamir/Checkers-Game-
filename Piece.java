import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class Piece {
    protected Color color;
    protected ImageIcon icon;

    public Piece(Color color, ImageIcon icon) {
        this.color = color;
        this.icon = icon;
    }

    public Color getColor() {
        return color;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public boolean isKing() {
        return false;
    }

    public abstract List<int[]> getValidMoves(int x, int y, GameBoardState boardState);

    public void promoteToKing() {
        if (this.color == Color.WHITE) {
            this.setIcon(new ImageIcon("WhiteKing.png"));  // Ensure this path is correct
        } else {
            this.setIcon(new ImageIcon("BlackKing.png"));  // Ensure this path is correct
        }
    }
}
