package com.tanktroubles.view;


import javax.swing.*;
import com.tanktroubles.MapReader;
import com.tanktroubles.view.MapPanel;
import com.tanktroubles.model.GameMap;
import com.tanktroubles.model.World;


public class ServerWindow extends JFrame {
	private World world;

    public ServerWindow(World world) {
		super();
		this.world = world;
		initUI();

    }

    private void initUI() {
        MapPanel mapPanel = new MapPanel(world);
        add(mapPanel);
		mapPanel.setLocation(0, 0);
    }
}
