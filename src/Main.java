import javax.swing.JOptionPane;

import processing.core.PApplet;

public class Main extends PApplet {

	Display display;
	Grid grid;
	int numRows = 25;
	int numCols = 25;

	int windowWidth  = 640;
	int windowHeight = 550;
	
	int displayWidth  = 620;
	int displayHeight = 530;

	boolean hasStart = false;
	boolean hasEnd   = false;
	
	int endX = 0, endY = 0;
	int startX = 0, startY = 0;
	
	
	public void setup() {
		size(windowWidth, windowHeight); // set the size of the screen.

		grid = new Grid(numRows, numCols);

		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, displayWidth, displayHeight);


		// Set different grid values to different colors
		display.setColor(Grid.NOT_VISITED, color(255, 255, 255));
		display.setColor(Grid.BLOCKED, color(200, 200, 200));
		display.setColor(Grid.VISITED, color(188, 208, 214));
		display.setColor(Grid.ENDPOINT, color(255, 0, 0));
		display.setColor(Grid.STARTPOINT, color(0, 255, 0));

		display.setNumCols(numCols);
		display.setNumRows(numRows);
	}

	@Override
	public void draw() {
		background(200);

		//userClick();
		display.drawGrid(grid.getGrid()); // display the game
	}

	
	public int pixelToIndex(int pixel, boolean isX) {
		int index = -1;
		
		if (isX) {
			double indexWidth = (double)(displayWidth)/(double)(grid.getNumCols());
			index = (int) (pixel/indexWidth);
		} 
		else {
			double indexHeight = (double)(displayHeight)/(double)(grid.getNumRows());
			index = (int) (pixel/indexHeight);
		}
		
		return index;
	}
	
	
	public void mouseReleased() {
		
		//if (mousePressed) {
			if (isInGrid(mouseX, mouseY)) {
				int x = pixelToIndex(mouseX, true);
				int y = pixelToIndex(mouseY, false);
				
				if (keyPressed) {
					if (key == 'e' || key == 'E') {
						if (hasEnd) {
							grid.set(endY, endX, grid.NOT_VISITED);
						}
		
						grid.set(y, x, Grid.ENDPOINT);
						endX = x;
						endY = y;
						
						hasEnd = true;
					}
					else if (key == 's' || key == 'S') {
						if (hasStart) {
							grid.set(startY, startX, grid.NOT_VISITED);
						}
		
						grid.set(y, x, Grid.STARTPOINT);
						startX = x;
						startY = y;
						
						hasStart = true;
					}
				}
				else {
					if (grid.getState(y, x) == Grid.BLOCKED) 
						grid.set(y, x, Grid.NOT_VISITED);
					else
						grid.set(y, x, Grid.BLOCKED);
				}
			}
		}
	//}
	
	
	public boolean isInGrid(int x, int y) {
		if (!(x >= 0 && x <= displayWidth)) 
			return false;

		if (!(y >= 0 && y <= displayHeight)) 
			return false;

		else return true;

	}

}
