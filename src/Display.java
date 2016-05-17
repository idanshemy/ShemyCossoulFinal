import java.util.LinkedHashMap;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PImage;
//THIS ONE IS OURS!!!!!!!!!
public class Display {
	
	
	// Colors used for empty locations.
	private static final int EMPTY_COLOR = 0xFFFFFFFF;

	private PApplet p; // the applet we want to display on

	private int x, y, w, h; // (x, y) of upper left corner of display
	// the width and height of the display

	private float dx, dy; // calculate the width and height of each box
	// in the field display using the size of the field
	// and the width and height of the display

	private int rows, cols;

	// A map for storing colors for participants in the simulation
	private Map<Object, Integer> colors;
	

	public Display(PApplet p, int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.p = p;

		colors = new LinkedHashMap<Object, Integer>();
	}

	public void drawGrid(int[][] f) {
		int piece;

		int numcols = f[0].length;
		int numrows = f.length;

		for (int i = 0; i < numrows; i++) {
			for (int j = 0; j < numcols; j++) {
				int gridState = f[i][j];
				int gridColor = 0;

				if (gridState == Grid.NOT_VISITED) {
					gridColor = this.EMPTY_COLOR;
				} else {
					gridColor = getColor(gridState);
				}

				p.fill(gridColor);
				p.rect(x + j * dx, y + i * dy, dx, dy);

			}
		}
	}
	
	private Integer getColor(int pieceType) {
		Integer col = colors.get(pieceType);
		
		if (col == null) { // no color defined for this class
			return Grid.NOT_VISITED;
		} else {
			return col;
		}
	}

	public void setColor(int gridState, int color) {
		colors.put(gridState, color);	
	}

	public void setNumCols(int numCols) {
		rows = numCols;
		dx = w / rows;
	}
	
	public void setNumRows(int numRows) {
		cols = numRows;
		dy = h / cols;
	}
}
