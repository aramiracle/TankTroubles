package com.tanktroubles.model;

public class GameMap {
    public Cell[][] cells;
    public int cellSize;
    private int rows;
    private int cols;

    public GameMap(int cols, int rows, int cellSize) {
        this.cells =  new Cell[rows][cols];
        this.cellSize = cellSize;
        this.rows = rows;
        this.cols = cols;
    }

    public int getHeight() {
        return rows * cellSize;
    }

    public int getWidth() {
        return cols * cellSize;
    }

	public Cell getCellAt(Point2D point) {
		return cells[(int) (point.y / cellSize)][(int) (point.x / cellSize)];
	}

	public boolean isOnMap(Point2D point) {
		return point.x >= 0 &&
			point.y >= 0 &&
			point.x <= getWidth() &&
			point.y <= getHeight();
	}
}
