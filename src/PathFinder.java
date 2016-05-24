import java.util.ArrayList;

public class PathFinder {
	//ArrayList<Integer> frontier = new ArrayList<Integer>();
	Grid grid = Main.getGrid();
	
	int currentX = grid.getStartX();
	int currentY = grid.getStartY();
	
	
	public void findPath() {
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
		
		System.out.println("CurrentX: " + currentX + "\tCurrentY: " + currentY);

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
