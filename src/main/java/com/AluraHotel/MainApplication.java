package com.AluraHotel;

import com.AluraHotel.views.MenuPrincipal;

import java.awt.*;

public class MainApplication {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


}
