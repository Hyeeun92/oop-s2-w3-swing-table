package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleTable extends JPanel {

    private static boolean DEBUG = true;

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

        });
    }

    public SimpleTable() {
        super(new GridLayout(1,0));

        //set up the column names

        String[] columnNames = {"First Name", "Last Name", "Sport", "# of years", "Vegetarian"};
        Object[][] data = {
                {"Kate", "Smith", "Snowboarding", 5, false},
                {"John", "Doe", "Rowing", 3, true},
                {"Sue", "Black", "Knitting", 2, false},
                {"Jame", "White", "Speed Reading", 28, true},
                {"Joe", "Brown", "Pool", 10, false}
        };


        //set up the data for the table

        //set up the table
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG){
            table.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e){
                    printDebugData(table);

                }
            });
        }

        //add a scroll pane to the panel and then add table to the scroll pane

        JScrollPane scrollPane = new JScrollPane(table);

        //add the scroll pane to this panel

        add(scrollPane);
    }
    private static void createAndShowGUI() {
        if (DEBUG) {
            System.out.println("Hello world");
        }

        JFrame frame = new JFrame("SimpleDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimpleTable newContentPane = new SimpleTable();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);

    }

    private void printDebugData(JTable table){
        System.out.println("Mouse is clicked");

        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();

        javax.swing.table.TableModel model = table.getModel();
        System.out.println("value of Data : ");

        for (int i = 0; i<numRows; i++){
            System.out.println("    row " + i + ": ");
            for(int j = 0; j<numCols; j++){
                System.out.println("    " + model.getValueAt(i,j));

            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

}
