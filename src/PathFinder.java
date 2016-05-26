import java.util.ArrayList;

public class PathFinder {
	// ArrayList<Integer> frontier = new ArrayList<Integer>();
	Grid grid = Main.getGrid();

	int currentX = grid.getStartX();
	int currentY = grid.getStartY();
	
	boolean isFirstTime = true;

	public int getCurrentX() {
		return currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void findPath() {
		//System.out.println(grid.getStartX() + " " + grid.getStartY());
		//System.out.println(currentX + " " + currentY);

		int endX = grid.getEndX();
		int endY = grid.getEndY();

		if (getCurrentX() < endX && Main.isInGrid(getCurrentY(), getCurrentX() + 1)) {
			setCurrentX(getCurrentX() + 1);
			grid.set(getCurrentY(), getCurrentX(), grid.VISITED);

		}
		if (getCurrentX() > endX && Main.isInGrid(getCurrentY(), getCurrentX() - 1)) {
			setCurrentX(getCurrentX() - 1);
			grid.set(getCurrentY(), getCurrentX(), grid.VISITED);

		}
		if (getCurrentY() < endY && Main.isInGrid(getCurrentY() + 1, getCurrentX())) {
			setCurrentY(getCurrentY() + 1);
			grid.set(getCurrentY(), getCurrentX(), grid.VISITED);

		}
		if (getCurrentY() > endY && Main.isInGrid(getCurrentY() - 1, getCurrentX())) {
			setCurrentY(getCurrentY() - 1);
			grid.set(getCurrentY(), getCurrentX(), grid.VISITED);
		}

	}

	public void findPath(int currentX, int currentY) {
		if (!isFirstTime) {
			System.out.println("FALSE");
			return;
		}
		
		//System.out.println(grid.getStartX() + " " + grid.getStartY());
		//System.out.println(currentX + " " + currentY);

		int endX = grid.getEndX();
		int endY = grid.getEndY();

		if (currentX < endX && Main.isInGrid(currentY, currentX + 1)) {
			setCurrentX(currentX + 1);
			grid.set(currentY, currentX, grid.VISITED);

		}
		if (currentX > endX && Main.isInGrid(currentY, currentX - 1)) {
			setCurrentX(currentX - 1);
			grid.set(currentY, currentX, grid.VISITED);

		}
		if (currentY < endY && Main.isInGrid(currentY + 1, currentX)) {
			setCurrentY(currentY + 1);
			grid.set(currentY, currentX, grid.VISITED);

		}
		if (currentY > endY && Main.isInGrid(currentY - 1, currentX)) {
			setCurrentY(currentY - 1);
			grid.set(currentY, currentX, grid.VISITED);
		}

		
		isFirstTime = false;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public boolean isAtEndpoint(int r, int c) {
		if (r == grid.getEndY() + 1 || r == grid.getEndY() - 1) {
			if (c == grid.getEndX() + 1 || c == grid.getEndX() - 1) {
				return true;
			}
		}
		return false;
	}
}
