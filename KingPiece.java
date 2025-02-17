import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KingPiece extends Piece {

    public KingPiece(Color color, ImageIcon icon) {
        super(color, icon);
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public List<int[]> getValidMoves(int x, int y, GameBoardState boardState) {
        List<int[]> moves = new ArrayList<>();
        int[] dx = {-1, 1, -1, 1};
        int[] dy = {-1, 1, 1, -1};

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (boardState.isValidMove(x, y, newX, newY)) {
                moves.add(new int[]{newX, newY});
            }
        }

        return moves;
    }
}
