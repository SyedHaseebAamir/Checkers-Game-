import java.awt.Color;
import javax.swing.ImageIcon;

public class GameBoardState {
    private Piece[][] board;

    public GameBoardState(Piece[][] board) {
        this.board = board;
    }

    public Piece getPiece(int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length) {
            return board[x][y];
        }
        return null;
    }

    public void setPiece(int x, int y, Piece piece) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length) {
            board[x][y] = piece;
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public int[][] getPossibleMoves(int x, int y) {
        Piece piece = getPiece(x, y);
        if (piece == null) return new int[0][0];

        int[][] directions;
        if (piece.isKing()) {
            directions = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {-2, -2}, {-2, 2}, {2, -2}, {2, 2}};
        } else if (piece.getColor() == Color.WHITE) {
            directions = new int[][]{{-1, -1}, {-1, 1}, {-2, -2}, {-2, 2}};
        } else {
            directions = new int[][]{{1, -1}, {1, 1}, {2, -2}, {2, 2}};
        }

        int[][] possibleMoves = new int[12][2];
        int index = 0;
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isValidMove(x, y, newX, newY)) {
                possibleMoves[index][0] = newX;
                possibleMoves[index][1] = newY;
                index++;
            }
        }

        int[][] result = new int[index][2];
        System.arraycopy(possibleMoves, 0, result, 0, index);
        return result;
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        if (toX < 0 || toX >= 8 || toY < 0 || toY >= 8) return false;
        if (getPiece(toX, toY) != null) return false;

        Piece piece = getPiece(fromX, fromY);
        if (piece == null) return false;

        int dx = toX - fromX;
        int dy = toY - fromY;

        if (piece.isKing()) {
            if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
                return true; // Normal move for king
            } else if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
                int midX = (fromX + toX) / 2;
                int midY = (fromY + toY) / 2;
                Piece midPiece = getPiece(midX, midY);
                return midPiece != null && midPiece.getColor() != piece.getColor(); // Capture move for king
            }
        } else {
            if (piece.getColor() == Color.WHITE) {
                if (dx == -1 && Math.abs(dy) == 1) {
                    return true; // Normal move for white
                } else if (dx == -2 && Math.abs(dy) == 2) {
                    int midX = (fromX + toX) / 2;
                    int midY = (fromY + toY) / 2;
                    Piece midPiece = getPiece(midX, midY);
                    return midPiece != null && midPiece.getColor() != piece.getColor(); // Capture move for white
                }
            } else {
                if (dx == 1 && Math.abs(dy) == 1) {
                    return true; // Normal move for black
                } else if (dx == 2 && Math.abs(dy) == 2) {
                    int midX = (fromX + toX) / 2;
                    int midY = (fromY + toY) / 2;
                    Piece midPiece = getPiece(midX, midY);
                    return midPiece != null && midPiece.getColor() != piece.getColor(); // Capture move for black
                }
            }
        }

        return false;
    }

    public void makeMove(int fromX, int fromY, int toX, int toY) {
        Piece piece = getPiece(fromX, fromY);
        setPiece(toX, toY, piece);
        setPiece(fromX, fromY, null);

        if (Math.abs(fromX - toX) == 2) {
            int midX = (fromX + toX) / 2;
            int midY = (fromY + toY) / 2;
            setPiece(midX, midY, null); // Capture the opponent's piece
        }

        if (!piece.isKing() && (toX == 0 || toX == 7)) {
            promotePiece(toX, toY);
        }
    }

    private void promotePiece(int x, int y) {
        Piece piece = getPiece(x, y);
        if (piece != null && !piece.isKing()) {
            ImageIcon kingIcon = new ImageIcon(piece.getColor() == Color.WHITE ? "WhiteKing.png" : "BlackKing.png");
            setPiece(x, y, new KingPiece(piece.getColor(), kingIcon));
        }
    }
}
