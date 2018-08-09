package com.robsonribeiroft;

import javax.swing.*;
import java.awt.*;

public class GameController {

    /*
     * Map[0,0] = [20, 40]
     * Map[0,1] = [408, 40]
     * Map[1,0] = [20, 425]
     * Map[1,1] = [410, 430]
     * Map[-1,-1] = [215, 230]*/
    public static final String TOP_LEFT = "20,40";
    public static final String TOP_RIGHT = "408,40";
    public static final String LOW_LEFT = "20,425";
    public static final String LOW_RIGHT = "410,430";
    public static final String MIDDLE = "215,230";
    private static String freePosition = MIDDLE;


    public static Point pointOnPosition(String position){
        String[] split = position.split(",");
        Point point = new Point();
        point.x = Integer.parseInt(split[0]);
        point.y = Integer.parseInt(split[1]);
        return point;
    }

    public static void setPiecesOnPosition(JButton btnRedOne, JButton btnRedTwo, JButton btnBlueOne, JButton btnBlueTwo){
        btnRedOne.setLocation(pointOnPosition(TOP_LEFT));
        btnRedTwo.setLocation(pointOnPosition(TOP_RIGHT));
        btnBlueOne.setLocation(pointOnPosition(LOW_LEFT));
        btnBlueTwo.setLocation(pointOnPosition(LOW_RIGHT));
    }

    /*
    public static boolean hasMovementAvailable(JButton button){
        Point point = button.getLocation();
        String btnPosition = point.x+","+point.y;
        if (btnPosition.equals(TOP_LEFT)){
        }
    }
    */


}
