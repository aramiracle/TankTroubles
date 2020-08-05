package com.tanktroubles.view;

import com.tanktroubles.model.Bullet;
import com.tanktroubles.model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BulletTimerAction implements ActionListener {
	public final static int REFRESH_RATE = 50;

	private Bullet bullet;
	private World world;
	private MapPanel me;
	private int ticks = 0;

	public BulletTimerAction(Bullet bullet, World world, MapPanel me) {
		this.bullet = bullet;
		this.world = world;
		this.me = me;
	}

	public void actionPerformed(ActionEvent e) {
		ticks++;
		// check lifetime
		if (ticks == Bullet.AGE * 1000 / REFRESH_RATE) {
			((Timer) e.getSource()).stop();
			world.removeBullet(bullet);
		}

		world.proceedBullet(bullet);
		me.repaint();
	}
}
