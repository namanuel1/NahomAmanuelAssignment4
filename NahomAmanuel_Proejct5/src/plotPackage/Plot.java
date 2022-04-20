package plotPackage;

public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	public Plot(Plot copy) {
		x = copy.getX();
		y = copy.getY();
		width = copy.getWidth();
		depth = copy.getDepth();
	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;

	}

	public boolean overlaps(Plot plot) {
		boolean firstOverlapsxy1 = (plot.x >= x && plot.x < (x + width)) && (plot.y >= y && plot.y < (y + depth));
		boolean firstOverlapsxy2 = (x >= plot.x && x < (plot.x + width)) && (y >= plot.y && y < (plot.y + plot.depth));
		boolean secondOverlapsxy1 = (plot.x + plot.width) > x && (plot.x + plot.width) < (x + width) && plot.y >= y && plot.y <= (y + depth);
		boolean secondOverlapsxy2 = (x + width) > plot.x && (x + width) < (plot.x + plot.width) && y >= plot.y && y <= (plot.y + plot.depth);
		boolean thirdOverlapsxy1 = plot.x >= x && plot.x < (x + width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) <= (y + depth);
		boolean thirdOverlapsxy2 = x >= plot.x && x < (plot.x + plot.width) && (y + depth) > plot.y && (y + depth) <= (plot.y + plot.depth);
		boolean fourthOverlapsxy1 = (plot.x + plot.width) > x && (plot.x + plot.width) <= (x + width) && (plot.y + plot.depth) > y
				&& (plot.y + plot.depth) <= (y + depth);
		boolean fourthOverlapsxy2 = (x + width) > plot.x && (x + width) <= (plot.x + plot.width) && (y + depth) > plot.y
				&& (y + depth) <= (plot.y + plot.depth);

		return firstOverlapsxy1 || firstOverlapsxy2 || secondOverlapsxy1 || secondOverlapsxy2 || thirdOverlapsxy1 || thirdOverlapsxy2
				|| fourthOverlapsxy1 || fourthOverlapsxy2;
	}

	public boolean encompasses(Plot plot) {
		boolean xValue = plot.x >= x;
		boolean yValue = plot.y >= y;
		boolean widthValue = plot.x + plot.width <= x + width;
		boolean depthValue = plot.y + plot.depth <= y + depth;

		return xValue && yValue && widthValue && depthValue;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	@Override
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}

}
