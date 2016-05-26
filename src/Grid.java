public class Grid {
	int height;
	int width;
	int[][] grid;
	public static final int NOT_VISITED = 0;
	public static final int VISITED = 1;
	public static final int BLOCKED = 2;
	public static final int ENDPOINT = 3;
	public static final int STARTPOINT = 4;
	
	int startX = 0, startY = 0, endX = 0, endY = 0;

	
	public int getStartY() {
		return startY;
	}


	public void setStartY(int startY) {
		this.startY = startY;
	}


	public int getEndX() {
		return endX;
	}


	public void setEndX(int endX) {
		this.endX = endX;
	}


	public int getEndY() {
		return endY;
	}


	public void setEndY(int endY) {
		this.endY = endY;
	}


	public int getStartX() {
		return startX;
	}


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
	
	public void clearSquare(int row, int col) {
		if (getState(row, col) != NOT_VISITED)
			set(row, col, NOT_VISITED);
	}
	
	public int getNumRows() {
		return height;
	}
	
	public int getNumCols() {
		return width;
	}
	
	
	public void set(int r, int c, int gridState) {
		grid[r][c] = gridState;
	}


	public void setStartX(int x) {
		this.startX = x;
		
	}


	
}