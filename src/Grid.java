public class Grid {
	int height;
	int width;
	int[][] grid;
	public static final int NOT_VISITED = 0;
	public static final int VISITED = 1;
	public static final int BLOCKED = 2;
	public static final int ENDPOINT = 3;
	public static final int STARTPOINT = 4;

	
	public Grid(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		this.grid = new int[height][width];
	}
	

	public int[][] getGrid() {
		return grid;
	}
	
	public int getState(int r, int c) {
		return grid[r][c];
	}
	
	public void blockSpace(int row, int col) {
		grid[row][col] = BLOCKED; 
	}
	
	public int getNumRows() {
		return height;
	}
	
	public int getNumCols() {
		return width;
	}
	
//	public void clickToBlock() {
//		//int row = Y COORDINATE OF MOUSE
//		//int col = X COORDINATE OF MOUSE
//
//		if (!isInGrid(row, col)) 
//			return;
//		
//		blockSpace(row, col);
//	}
	
	public void set(int r, int c, int gridState) {
		grid[r][c] = gridState;
	}
	
}