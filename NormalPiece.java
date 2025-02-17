import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NormalPiece extends Piece {

    public NormalPiece(Color color, ImageIcon icon) {
        super(color, icon);
    }

    @Override
    public List<int[]> getValidMoves(int x, int y, GameBoardState boardState) {
        List<int[]> moves = new ArrayList<>();
        int direction = (color == Color.WHITE) ? -1 : 1;

        // Normal move
        int[] dx = {direction, direction};
        int[] dy = {1, -1};

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (boardState.isValidMove(x, y, newX, newY)) {
                moves.add(new int[]{newX, newY});
            }

            // Check for capturing moves
            newX = x + 2 * dx[i];
            newY = y + 2 * dy[i];
            if (boardState.isValidMove(x, y, newX, newY)) {
                moves.add(new int[]{newX, newY});
            }
        }

        return moves;
    }

    @Override
    public void promoteToKing() {
        if (color == Color.WHITE) {
            setIcon(new ImageIcon("WhiteKing.png"));
        } else {
            setIcon(new ImageIcon("BlackKing.png"));
        }
    }
}
