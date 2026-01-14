package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {

        super(gp);
        direction = "down";
        speed = 1;

        solidArea = new Rectangle(0, 0, 48, 48);
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        getNPCImage();
    }

    public void getNPCImage() {

        up1 = setup("/res/npc/oldman_up_1");
        up2 = setup("/res/npc/oldman_up_2");
        down1 = setup("/res/npc/oldman_down_1");
        down2 = setup("/res/npc/oldman_down_2");
        left1 = setup("/res/npc/oldman_left_1");
        left2 = setup("/res/npc/oldman_left_2");
        right1 = setup("/res/npc/oldman_right_1");
        right2 = setup("/res/npc/oldman_right_2");
    }

    public void setAction() {

        Random random = new Random();
        int i = random.nextInt(100) + 1;
        if (i < 25) {
            direction = "up";
        } else if (i < 50) {
            direction = "down";
        } else if (i < 75) {
            direction = "left";
        } else {
            direction = "right";
        }
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
    }

}
