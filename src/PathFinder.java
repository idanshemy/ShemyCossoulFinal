import java.util.ArrayList;

public class PathFinder {
	//ArrayList<Integer> frontier = new ArrayList<Integer>();
	Grid grid = Main.getGrid();
	
	public void findPath() {
		int startX = grid.getStartX();
		int startY = grid.getStartY();
		int endX = grid.getEndX();
		int endY = grid.getEndY();
		
		if (startX < endX) {
			grid.set(startY, startX + 1, grid.VISITED);
		}
		if (startX > endX) {
			grid.set(startY, startX - 1, grid.VISITED);
		}
		if (startY < endY) {
			grid.set(startY + 1, startX, grid.VISITED);
		}
		if (startY < endY) {
			grid.set(startY - 1, startX, grid.VISITED);
		}
	}
}
