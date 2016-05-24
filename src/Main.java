import javax.swing.JOptionPane;

import processing.core.PApplet;

public class Main extends PApplet {

	Display display;
	static Grid grid;
	static int numRows = 20;
	static int numCols = 20;

	int windowWidth = 640;
	int windowHeight = 550;

	static int displayWidth = 620;
	static int displayHeight = 530;

	boolean hasStart = false;
	boolean hasEnd = false;

	PathFinder p;

	public void setup() {
		size(windowWidth, windowHeight); // set the size of the screen.

		grid = new Grid(numRows, numCols);

		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, displayWidth, displayHeight);

		p = new PathFinder();

		// Set different grid values to different colors
		display.setColor(Grid.NOT_VISITED, color(255, 255, 255));
		display.setColor(Grid.BLOCKED, color(200, 200, 200));
		display.setColor(Grid.VISITED, color(0, 0, 255));
		display.setColor(Grid.ENDPOINT, color(255, 0, 0));
		display.setColor(Grid.STARTPOINT, color(0, 255, 0));

		display.setNumCols(numCols);
		display.setNumRows(numRows);
	}

	@Override
	public void draw() {
		background(200);

		if (hasStart && hasEnd) {
			p.findPath();
		}
		display.drawGrid(grid.getGrid()); // display the game
	}

	public static Grid getGrid() {
		return grid;
	}

	public static int pixelToIndex(int pixel, boolean isX) {
		int index = -1;

		if (isX) {
			double indexWidth = (double) (displayWidth) / (double) (grid.getNumCols());
			index = (int) (pixel / indexWidth);
		} else {
			double indexHeight = (double) (displayHeight) / (double) (grid.getNumRows());
			index = (int) (pixel / indexHeight);
		}

		return index;
	}

	public void mouseReleased() {

		if (isInGrid(mouseX, mouseY)) {
			int x = pixelToIndex(mouseX, true);
			int y = pixelToIndex(mouseY, false);

			if (keyPressed) {
				if (key == 'e' || key == 'E') {
					if (hasEnd) {
						grid.set(grid.getEndY(), grid.getEndX(), grid.NOT_VISITED);
					}

					grid.set(y, x, Grid.ENDPOINT);
					grid.setEndX(x);
					grid.setEndY(y);

					hasEnd = true;
				} else if (key == 's' || key == 'S') {
					if (hasStart) {
						grid.set(grid.getStartY(), grid.getStartX(), grid.NOT_VISITED);
					}
					

					grid.set(y, x, Grid.STARTPOINT);
					grid.setStartX(x);
					grid.setStartY(y);

					hasStart = true;
				}
			} else {
				if (grid.getState(y, x) == Grid.BLOCKED)
					grid.clearSquare(y, x);
				else if (grid.getState(y, x) != grid.STARTPOINT && grid.getState(y, x) != grid.ENDPOINT)
					grid.set(y, x, Grid.BLOCKED);
			}
		}
	}

	public static boolean isInGrid(int y, int x) {
		if (!(x >= 0 && x < displayWidth))
			return false;

		if (!(y >= 0 && y < displayHeight))
			return false;

		else
			return true;

	}

}
