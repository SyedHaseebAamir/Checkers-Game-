import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameMove {
    public GameBoardState gameBoard;
    private boolean isWhiteTurn;
    private JFrame gameFrame;
    private JFrame mainMenuFrame;

    public GameMove(GameBoardState gameBoard, JFrame gameFrame, JFrame mainMenuFrame) {
        this.gameBoard = gameBoard;
        this.gameFrame = gameFrame;
        this.mainMenuFrame = mainMenuFrame;
        this.isWhiteTurn = true; // White starts first
    }

    public boolean makeMove(int fromX, int fromY, int toX, int toY) {
        if (isValidMove(fromX, fromY, toX, toY)) {
            Piece piece = gameBoard.getPiece(fromX, fromY);
            gameBoard.setPiece(toX, toY, piece);
            gameBoard.setPiece(fromX, fromY, null);

            // Handle capture
            if (Math.abs(toX - fromX) == 2 && Math.abs(toY - fromY) == 2) {
                int midX = (fromX + toX) / 2;
                int midY = (fromY + toY) / 2;
                if (gameBoard.getPiece(midX, midY) != null) {
                    gameBoard.setPiece(midX, midY, null);
                }
            }

            // Handle promotion to King
            if ((piece.getColor() == Color.WHITE && toX == 0) || (piece.getColor() == Color.BLACK && toX == 7)) {
                piece.promoteToKing();
                gameBoard.setPiece(toX, toY, new KingPiece(piece.getColor(), piece.getIcon()));
            }

            // Switch turn only if no capture or no more captures possible
            if (Math.abs(toX - fromX) != 2 || !hasCaptureMove(toX, toY)) {
                isWhiteTurn = !isWhiteTurn;
            }
            return true;
        }
        return false;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public boolean checkForWin() {
        boolean whiteExists = false;
        boolean blackExists = false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = gameBoard.getPiece(row, col);
                if (piece != null) {
                    if (piece.getColor() == Color.WHITE) {
                        whiteExists = true;
                    } else if (piece.getColor() == Color.BLACK) {
                        blackExists = true;
                    }
                }
            }
        }

        return !whiteExists || !blackExists;
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        if (toX < 0 || toX >= 8 || toY < 0 || toY >= 8 || fromX < 0 || fromX >= 8 || fromY < 0 || fromY >= 8) {
            return false;
        }

        Piece piece = gameBoard.getPiece(fromX, fromY);
        if (piece == null) {
            return false;
        }

        Piece target = gameBoard.getPiece(toX, toY);
        if (target != null) {
            return false;
        }

        if (piece.isKing()) {
            return isValidKingMove(fromX, fromY, toX, toY);
        } else if (piece.getColor() == Color.WHITE && isWhiteTurn) {
            return isValidWhiteMove(fromX, fromY, toX, toY);
        } else if (piece.getColor() == Color.BLACK && !isWhiteTurn) {
            return isValidBlackMove(fromX, fromY, toX, toY);
        }
        return false;
    }

    private boolean isValidKingMove(int fromX, int fromY, int toX, int toY) {
        if (Math.abs(toX - fromX) == 1 && Math.abs(toY - fromY) == 1) {
            return true;
        }

        if (Math.abs(toX - fromX) == 2 && Math.abs(toY - fromY) == 2) {
            int midX = (fromX + toX) / 2;
            int midY = (fromY + toY) / 2;
            Piece middlePiece = gameBoard.getPiece(midX, midY);
            return middlePiece != null && middlePiece.getColor() != gameBoard.getPiece(fromX, fromY).getColor();
        }

        return false;
    }

    private boolean isValidWhiteMove(int fromX, int fromY, int toX, int toY) {
        return (toX - fromX == -1 && Math.abs(toY - fromY) == 1) ||
               (toX - fromX == -2 && Math.abs(toY - fromY) == 2 && gameBoard.getPiece((fromX + toX) / 2, (fromY + toY) / 2) != null && gameBoard.getPiece((fromX + toX) / 2, (fromY + toY) / 2).getColor() == Color.BLACK);
    }

    private boolean isValidBlackMove(int fromX, int fromY, int toX, int toY) {
        return (fromX - toX == -1 && Math.abs(fromY - toY) == 1) ||
               (fromX - toX == -2 && Math.abs(fromY - toY) == 2 && gameBoard.getPiece((fromX + toX) / 2, (fromY + toY) / 2) != null && gameBoard.getPiece((fromX + toX) / 2, (fromY + toY) / 2).getColor() == Color.WHITE);
    }

    public void highlightPossibleMoves(int fromX, int fromY, JButton[][] squares, Color highlightColor) {
        clearHighlight(squares);
        Piece piece = gameBoard.getPiece(fromX, fromY);
        if (piece == null) return;

        List<int[]> validMoves = piece.getValidMoves(fromX, fromY, gameBoard);
        for (int[] move : validMoves) {
            int newX = move[0];
            int newY = move[1];
            squares[newX][newY].setBackground(highlightColor);
            squares[newX][newY].repaint();
        }
    }

    public void clearHighlight(JButton[][] squares) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col].setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.BLACK);
            }
        }
    }

    private boolean hasCaptureMove(int x, int y) {
        Piece piece = gameBoard.getPiece(x, y);
        if (piece == null) return false;

        List<int[]> validMoves = piece.getValidMoves(x, y, gameBoard);
        for (int[] move : validMoves) {
            if (Math.abs(move[0] - x) == 2 && Math.abs(move[1] - y) == 2) {
                return true;
            }
        }
        return false;
    }

    public void setGameBoard(GameBoardState gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setGameFrame(JFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
}
