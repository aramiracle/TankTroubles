package com.tanktroubles.view;

import com.tanktroubles.model.*;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class MapPanel extends JPanel {
    private GameMap map;
	private World world;

    public MapPanel(World world) {
        this.world = world;
		this.map = this.world.getMap();
		setSize(this.world.getMap().getWidth(), this.world.getMap().getHeight());
		this.setFocusable(true);
		this.requestFocus();

		MapPanel me = this;
		this.addKeyListener(new KeyListener () {
			private Set<Integer> heldKeys = new HashSet<>();

			public synchronized void keyPressed(KeyEvent e) {
				heldKeys.add(e.getKeyCode());

				if (!heldKeys.isEmpty()) {
					for (Integer code : heldKeys) {
						switch (code) {
							case KeyEvent.VK_LEFT:
								world.getTanks().get(0).rotate(RotationDirection.LEFT);
								me.repaint();
								break;
							case KeyEvent.VK_RIGHT:
								world.getTanks().get(0).rotate(RotationDirection.RIGHT);
								me.repaint();
								break;
							case KeyEvent.VK_UP:
								world.moveTank(0, MovementDirection.FORWARD);
								me.repaint();
								break;
							case KeyEvent.VK_DOWN:
								world.moveTank(0, MovementDirection.BACKWARD);
								me.repaint();
								break;
							case KeyEvent.VK_SPACE:
								Bullet bullet = world.tankShoot(0);
								if (bullet != null) {
									new Timer(BulletTimerAction.REFRESH_RATE,
											new BulletTimerAction(bullet, world, me))
										.start();
								}
								me.repaint();
								break;
						}
					}
				}
			}
			public void keyTyped(KeyEvent e) {
			}
			public synchronized void keyReleased(KeyEvent e) {
				heldKeys.remove(e.getKeyCode());
			}
		});

	}

	private void drawMap(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i < map.cells.length; ++i) {
			for (int j = 0; j < map.cells[0].length; ++j) {
				Cell cell = map.cells[i][j];
				if (cell.isObstacle()) {
					g2d.setColor(new Color(125, 167, 116));
					g2d.fillRect((int) cell.pos.y - map.cellSize / 2,
							(int) cell.pos.x - map.cellSize / 2,
							map.cellSize, map.cellSize);
				}
			}
		}
    }

    private void drawTanks(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

		for (Tank tank : this.world.getTanks()) {
			g2d.setColor(new Color(80, 80, 80));
			int x = (int) tank.pos.x;
			int y = (int) tank.pos.y;
			g2d.fillOval( x, y, 20, 20);
			g2d.drawLine(x + 10, y + 10,
					x + 10 + (int)(20*Math.cos(Math.toRadians(tank.angle))),
					y + 10 + (int)(20*Math.sin(Math.toRadians(tank.angle))));
		}
    }

	private void drawBullets(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		for (Bullet bullet : world.getBullets()) {
			g2d.setColor(new Color(255, 0, 0));
			int x = (int) bullet.pos.x;
			int y = (int) bullet.pos.y;
			g2d.fillOval(x, y, 5, 5);
		}
	}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
        drawTanks(g);
		drawBullets(g);
    }
}