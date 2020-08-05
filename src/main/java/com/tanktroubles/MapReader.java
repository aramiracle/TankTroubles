package com.tanktroubles;

import com.tanktroubles.model.Cell;
import com.tanktroubles.model.GameMap;
import com.tanktroubles.model.Point2D;

import java.io.*;
import java.util.*;

public class MapReader {
    public static GameMap read(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cols = Integer.parseInt(st.nextToken());
        int rows = Integer.parseInt(st.nextToken());
        int cellSize = Integer.parseInt(br.readLine());

        GameMap map = new GameMap(rows, cols, cellSize);

        String str;
        int j = 0;
        while ((str = br.readLine()) != null && j < rows) {
            for (int i = 0; i < str.length(); ++i) {
                map.cells[j][i] = new Cell(new Point2D((j + 0.5) * cellSize, (i + 0.5) * cellSize),
                        str.charAt(i));
            }
            ++j;
        }

        return map;
    }
}

