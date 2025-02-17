import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel {
    private JButton[][] squares;
    private GameMove gameMove;
    private Piece selectedPiece;
    private int selectedX, selectedY;
    private JLabel turnLabel, whiteWinsLabel, blackWinsLabel;
    private boolean vsBot = false;
    private boolean practiceSolo = false;
    private JFrame mainMenuFrame;
    private int keyboardSelectedX = 0;
    private int keyboardSelectedY = 0;
    private int whiteWins = 0;
    private int blackWins = 0;

    public GameBoard(JFrame mainMenuFrame, boolean practiceSolo) {
        this.mainMenuFrame = mainMenuFrame;
        this.practiceSolo = practiceSolo;
        
        setLayout(new BorderLayout());
        

        if (!practiceSolo) {
            JPanel topPanel = createTopPanel();
            add(topPanel, BorderLayout.NORTH);
        }

        JPanel boardPanel = createBoardPanel();
        JPanel bottomPanel = createBottomPanel();

        add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        turnLabel = new JLabel("Turn: White");
        whiteWinsLabel = new JLabel("White Wins: 0");
        blackWinsLabel = new JLabel("Blue Wins: 0");

        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(turnLabel, gbc);

        gbc.gridx = 1;
        topPanel.add(whiteWinsLabel, gbc);

        gbc.gridx = 2;
        topPanel.add(blackWinsLabel, gbc);

        return topPanel;
    }

    private JPanel createBoardPanel() {
        JPanel boardPanel = new JPanel(new GridLayout(8, 8));
        squares = new JButton[8][8];
        Piece[][] initialBoard = new Piece[8][8];
        initializePieces(initialBoard);
        gameMove = new GameMove(new GameBoardState(initialBoard), new JFrame(), mainMenuFrame);

        initializeBoard(boardPanel);
        return boardPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton resetBoardButton = new JButton("Reset Board");
        JButton backToMainMenuButton = new JButton("Back to Main Menu");

        resetBoardButton.addActionListener(e -> resetBoard());
        backToMainMenuButton.addActionListener(e -> backToMainMenu());

        bottomPanel.add(resetBoardButton);
        bottomPanel.add(backToMainMenuButton);

        return bottomPanel;
    }

    private void resetScore() {
        whiteWins = 0;
        blackWins = 0;
        updateScoreLabels();
    }

    private void backToMainMenu() {
        mainMenuFrame.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    private void updateScoreLabels() {
        whiteWinsLabel.setText("White Wins: " + whiteWins);
        blackWinsLabel.setText("Blue Wins: " + blackWins);
    }

    private void initializeBoard(JPanel boardPanel) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col] = new JButton();
                squares[row][col].setOpaque(true);
                squares[row][col].setBorderPainted(false);
                squares[row][col].setBackground((row + col) % 2 != 0 ? Color.WHITE : Color.BLACK);
                squares[row][col].addActionListener(new SquareListener(row, col));

                Piece piece = gameMove.gameBoard.getPiece(row, col);
                if (piece != null) {
                    squares[row][col].setIcon(piece.getIcon());
                }

                boardPanel.add(squares[row][col]);
            }
        }
    }

    private void initializePieces(Piece[][] board) {
        ImageIcon whiteIcon = new ImageIcon("white.png");
        ImageIcon blackIcon = new ImageIcon("black.png");

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row < 3 && (row + col) % 2 != 0) {
                    board[row][col] = new NormalPiece(Color.BLACK, blackIcon);
                } else if (row > 4 && (row + col) % 2 != 0) {
                    board[row][col] = new NormalPiece(Color.WHITE, whiteIcon);
                } else {
                    board[row][col] = null;
                }
            }
        }
    }

    private class SquareListener implements ActionListener {
        private int row, col;

        public SquareListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            handleMouseSelection(row, col);
        }
    }

    private synchronized void handleMouseSelection(int row, int col) {
        if (selectedPiece == null) {
            selectedPiece = gameMove.gameBoard.getPiece(row, col);
            if (selectedPiece != null && (practiceSolo || (selectedPiece.getColor() == Color.WHITE && gameMove.isWhiteTurn()) ||
                    (selectedPiece.getColor() == Color.BLACK && !gameMove.isWhiteTurn()))) {
                selectedX = row;
                selectedY = col;
                gameMove.highlightPossibleMoves(selectedX, selectedY, squares, Color.GREEN);
            } else {
                selectedPiece = null;
            }
        } else {
            if (gameMove.makeMove(selectedX, selectedY, row, col)) {
                updateBoard();
                gameMove.clearHighlight(squares);
                selectedPiece = null;
                if (gameMove.checkForWin()) {
                    updateWins();
                }
                if (!practiceSolo) {
                    switchTurn();
                }
            } else {
                selectedPiece = null;
                gameMove.clearHighlight(squares);
            }
        }
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (!gameMove.isWhiteTurn() || practiceSolo) {
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    if (keyboardSelectedX > 0) keyboardSelectedX--;
                    break;
                case KeyEvent.VK_DOWN:
                    if (keyboardSelectedX < 7) keyboardSelectedX++;
                    break;
                case KeyEvent.VK_LEFT:
                    if (keyboardSelectedY > 0) keyboardSelectedY--;
                    break;
                case KeyEvent.VK_RIGHT:
                    if (keyboardSelectedY < 7) keyboardSelectedY++;
                    break;
                case KeyEvent.VK_SPACE:
                    handleKeyboardSelection();
                    break;
            }
            updateKeyboardHighlight();
        }
    }

    private synchronized void handleKeyboardSelection() {
        if (selectedPiece == null) {
            selectedPiece = gameMove.gameBoard.getPiece(keyboardSelectedX, keyboardSelectedY);
            if (selectedPiece != null && (practiceSolo || selectedPiece.getColor() == Color.BLACK)) {
                selectedX = keyboardSelectedX;
                selectedY = keyboardSelectedY;
                gameMove.highlightPossibleMoves(selectedX, selectedY, squares, Color.YELLOW);
            } else {
                selectedPiece = null;
            }
        } else {
            if (gameMove.makeMove(selectedX, selectedY, keyboardSelectedX, keyboardSelectedY)) {
                updateBoard();
                gameMove.clearHighlight(squares);
                selectedPiece = null;
                if (gameMove.checkForWin()) {
                    updateWins();
                    resetBoard();
                }
                if (!practiceSolo) {
                    switchTurn();
                }
            } else {
                selectedPiece = null;
                gameMove.clearHighlight(squares);
            }
        }
    }

    private void updateKeyboardHighlight() {
        gameMove.clearHighlight(squares);
        squares[keyboardSelectedX][keyboardSelectedY].setBackground(Color.YELLOW);
        squares[keyboardSelectedX][keyboardSelectedY].repaint();
    }

    private void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = gameMove.gameBoard.getPiece(row, col);
                if (piece != null) {
                    squares[row][col].setIcon(piece.getIcon());
                } else {
                    squares[row][col].setIcon(null);
                }
            }
        }
    }
    
private void updateWins() {
    if (gameMove.isWhiteTurn()) {
        blackWins++;
    } else {
        whiteWins++;
    }
    updateScoreLabels();
    JOptionPane.showMessageDialog(this, (gameMove.isWhiteTurn() ? "Blue" : "White") + " Wins!");
    resetBoard(); // Reset the board after a win
}

    private void resetBoard() {
    Piece[][] initialBoard = new Piece[8][8];
    initializePieces(initialBoard);
    gameMove.setGameBoard(new GameBoardState(initialBoard)); // Update the game board state
    updateBoard();
    selectedPiece = null; // Reset the selected piece
    gameMove.clearHighlight(squares); // Clear any highlights
    if (!practiceSolo) {
        turnLabel.setText("Turn: White"); // Reset the turn label if not in practice solo mode
    }
}

    private void switchTurn() {
        if (gameMove.isWhiteTurn()) {
            turnLabel.setText("Turn: White");
        } else {
            turnLabel.setText("Turn: Blue");
            requestFocusInWindow();
        }
    }

    public void setVsBot(boolean vsBot) {
        this.vsBot = vsBot;
    }

    public void display() {
        JFrame frame = new JFrame("Checkers Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(this);
        frame.setVisible(true);
        gameMove = new GameMove(gameMove.gameBoard, frame, mainMenuFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainMenuFrame = new JFrame("Main Menu");
            mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenuFrame.setSize(800, 800);
            MainMenu mainMenu = new MainMenu();
            mainMenuFrame.add(mainMenu);
            mainMenuFrame.setVisible(true);
            
        });
    }
}
