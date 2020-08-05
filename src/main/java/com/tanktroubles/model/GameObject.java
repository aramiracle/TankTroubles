package com.tanktroubles.model;

public abstract class GameObject {
    public Point2D pos;

    public boolean isCollidingWith(GameObject object) {
        Rectangle me = this.getBoundingBox();
        Rectangle other = object.getBoundingBox();
        return me.hasIntersectionWith(other);
    }

    public abstract Rectangle getBoundingBox();
}
