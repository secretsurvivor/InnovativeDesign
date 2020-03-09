/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innovativedesign;

import ChartPack.NChart;
import ChartPack.PieChart.NPieChartC;
import DesktopPack.NLayered;
import DesktopPack.NMenuBar;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import ChartPack.BarChart.NBarChartC;


/**
 *
 * @author 18074751
 */
public class InnovativeDesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nebula GUI Test");
        NLayered layer = new NLayered();
        NMenuBar menuBar = new NMenuBar();

        frame.add(layer, BorderLayout.CENTER);
        layer.LookAndFeel("Windows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);

        menuBar.addMenu("File");  // 0
        menuBar.addMenu("Tools"); // 1
        menuBar.add(0, "Exit", (ActionEvent e) -> {frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));});

        JInternalFrame searchIFrame = new SearchIFrame();{
        menuBar.add(1, "Search", searchIFrame);
        layer.add(searchIFrame, JLayeredPane.DEFAULT_LAYER);}

        JInternalFrame iframe = new JInternalFrame("Test");{
        iframe.setVisible(true);
        iframe.setResizable(true);
        iframe.setSize(200, 100);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setIconifiable(true);
        layer.add(iframe, JLayeredPane.DEFAULT_LAYER);}

        JInternalFrame pieChartIFrame = new JInternalFrame("Pie Chart: \"H://\"");
        NPieChartC pi = NChart.createPieChartJComponent(new File("/H:/"));
        pieChartIFrame.add(pi, BorderLayout.CENTER);
        pieChartIFrame.setSize(500, 250);
        pieChartIFrame.setResizable(true);
        pieChartIFrame.setClosable(true);
        menuBar.add(1, "Pie Chart", pieChartIFrame);
        layer.add(pieChartIFrame, JLayeredPane.DEFAULT_LAYER);
        
        JInternalFrame BarChartIFrame = new JInternalFrame("Bar Chart: \"H://\"");
        NBarChartC bar = NChart.createBarChartJComponent(new File("/H:/"));
        BarChartIFrame.add(bar, BorderLayout.CENTER);
        BarChartIFrame.setSize(600, 450);
        BarChartIFrame.setResizable(true);
        BarChartIFrame.setClosable(true);
        menuBar.add(1, "Bar Chart", BarChartIFrame);
        layer.add(BarChartIFrame, JLayeredPane.DEFAULT_LAYER);
       
        
        ImageIcon icon = new ImageIcon("\\\\brookesf1\\s76\\17007976\\NetBeansProjects\\InnovativeDesign\\src\\resources\\PieChart.png");
        pieChartIFrame.setFrameIcon(icon);
        ImageIcon icon2 = new ImageIcon("\\\\brookesf1\\s76\\17007976\\NetBeansProjects\\InnovativeDesign\\src\\resources\\SpaceMonitoring.png");
        searchIFrame.setFrameIcon(icon2);
        ImageIcon img = new ImageIcon("\\\\brookesf1\\s76\\17007976\\NetBeansProjects\\InnovativeDesign\\src\\resources\\NebulaLogo.png");
        frame.setIconImage(img.getImage());

        layer.setVisible(true);
        //layer.setSize(500, 500);
        frame.setSize(1200, 700);
        frame.setVisible(true);
    }
}
