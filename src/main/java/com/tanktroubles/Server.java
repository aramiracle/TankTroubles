package com.tanktroubles;

import com.tanktroubles.model.GameMap;
import com.tanktroubles.model.World;
import com.tanktroubles.view.ServerWindow;
import javax.swing.JFrame;

public class Server {
    private int turn = 0;

    public static void main(String[] args) {
        try {
            GameMap map = MapReader.read("map.txt");
			World world = new World(map);
			ServerWindow window = new ServerWindow(world);

			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setTitle("abbas");
			window.setLayout(null);
			window.setSize(map.getWidth(), map.getHeight());
			window.setResizable(false);
			window.setVisible(true);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
