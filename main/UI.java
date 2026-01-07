package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {

    GamePanel gp;
    Font arial_40, arial_80b;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    DecimalFormat dFormat = new DecimalFormat("0.00");

    double playTime;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80b = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished == true) {
            String text;
            int textLength;
            int x;
            int y;

            text = "Game Over, Congratulations!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - (textLength / 2);
            y = gp.screenHeight / 2 - (gp.tileSize * 3);

            g2.setColor(Color.yellow);
            g2.setFont(arial_80b);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        } else {

            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            // Time
            playTime += (double) 1 / 60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 65);

            // Notification System
            if (messageOn == true) {

                g2.setColor(new Color(0, 0, 0, 150));
                g2.fillRect(gp.tileSize / 2 - 5, gp.tileSize / 2 - 5, gp.tileSize, gp.tileSize);
                g2.setColor(Color.white);
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

                messageCounter++;
                if (messageCounter > 90) {
                    messageOn = false;
                    messageCounter = 0;
                }
            }
        }
    }
}
