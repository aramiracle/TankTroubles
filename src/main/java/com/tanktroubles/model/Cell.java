package com.tanktroubles.model;

public class Cell extends GameObject {
    private char type;

    public Cell(Point2D pos, char ch) {
        this.pos = pos;
        this.type = ch;
    }

    public Boolean isObstacle() {
        return this.type == '#';
    }

    @Override
    public Rectangle getBoundingBox() {
        return null;
    }
}
