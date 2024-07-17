package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		// programação defensiva
		if (rows < 1 || columns < 1) {
			// 'Erro ao criar tabuleiro: deve haver pelo menos 1 linha e 1 coluna 
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	// retorna a peça dada uma linha e uma coluna
	public Piece piece(int row, int column) {
		// programação defensiva
		if (!positionExists(row, column)) {
			// 'Posição não existe no tabuleiro'
			throw new BoardException("Position does not exist on the board!");
		}
		return pieces[row][column];
	}
	
	// sobrecarga do método anterior
	public Piece piece(Position position) {
		// programação defensiva
		if (!positionExists(position)) {
		// 'Posição não existe no tabuleiro'
			throw new BoardException("Position does not exist on the board!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// colocar a peça na posição no tabuleiro
	public void placePiece(Piece piece, Position position) {
		// programação defensiva
		if (thereIsAPiece(position)) {
			// 'Já existe uma peça na posição'
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece .position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	// testa se uma posição existe
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// testa se existe uma peça na posição
	public boolean thereIsAPiece(Position position) {
		// programação defensiva
		if (!positionExists(position)) {
		// 'Posição não existe no tabuleiro'
			throw new BoardException("Position does not exist on the board!");
		}		
		return piece(position) != null;
	}
}
