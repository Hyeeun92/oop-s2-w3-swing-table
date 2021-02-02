package com.company;

import javax.swing.*;
import java.awt.*;

public class SuperHeroes extends JPanel {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showTable();
            }
        });

    }

    public SuperHeroes(){

        super (new GridLayout(1,0));

        String[] columnName = {"Hero Name", "Real Name", "Tier", "Intelligence", "Strength","Speed"};
        Object[][] data = {
                {"Batman", "Bruce Wayne", 1, 90, 13, 20},
                {"Deadpool", "Wade Wilson", 3, 60, 25, 50},
                {"Thor", "Thor Odinson", 6, 80, 100, 100, 100},
                {"Hulk", "Bruce Banner", 6, 70, 100, 85, 100}
        };

        final JTable superHeroTable = new JTable(data, columnName);
        superHeroTable.setPreferredScrollableViewportSize(new Dimension(500,70));
        superHeroTable.setFillsViewportHeight(true);




        JScrollPane scrollPane = new JScrollPane(superHeroTable);
        add(scrollPane);
    }

    private static void showTable(){

        JFrame frame = new JFrame("Super Heroes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SuperHeroes table = new SuperHeroes();
        table.setOpaque(true);
        frame.setContentPane(table);

        frame.pack();
        frame.setVisible(true);
    }

}
