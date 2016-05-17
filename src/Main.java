import javax.swing.JOptionPane;

import processing.core.PApplet;

public class Main extends PApplet {

	Display display;
	Grid grid;
	int numRows = 20;
	int numCols = 20;

	int windowWidth = 640;
	int windowHeight = 550;
	
	int displayWidth = 620, displayHeight = 530;

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

		display.drawGrid(grid.getGrid()); // display the game
	}

	
	public int xPixelToIndex(int pixel, boolean isX) {
		int index = -1;
		
		if (isX) {
			double indexWidth = (double)(displayWidth)/(double)(grid.getNumCols());
			index = (int) (pixel/indexWidth);
		} 
		else {
			double indexHeight = (double)(displayWidth)/(double)(grid.getNumRows());
			index = (int) (pixel/indexHeight);
		}
		
		return index;
	}
	
	
	public void userClick() {
		if (mousePressed) {
			if (isInGrid(mouseX, mouseY)) {
				if (keyPressed) {
					if (key == 'e' || key == 'E') {
						grid.set(mouseX, mouseY, Grid.ENDPOINT);
					}
					else if (key == 's' || key == 'S') {
						grid.set(mouseX, mouseY, Grid.STARTPOINT);
					}
				}
				else grid.set(mouseX, mouseY, Grid.BLOCKED);
			}
		}
	}
	
	public boolean isInGrid(int x, int y) {
		if (!(x >= 0 && x <= displayWidth)) 
			return false;

		if (!(y >= 0 && y <= displayHeight)) 
			return false;

		else return true;

	}

}
