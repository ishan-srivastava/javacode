package Packman_ishan;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Ishan on 8/31/2016.
 */
public class Pack implements KeyListener {
    public static Graphics graphics,graphics1;public static Image mainImage;
    static Image[] bot;
    static int herox = 0, heroy = 600,vc=0;
    static Image bg, hero, coin, go;
    static JPanel panel;
    static int[] bposx = new int[5];
    static int[] bposy = new int[5];
    static int coinx[] = new int[172], coiny[] = new int[172], p1 = -1,p2=-1;

    private static AudioClip loopAudio;


    public static void main(String[] args) {
        int i, m, n;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setPreferredSize(new Dimension(1300, 700));
        panel.setFocusable(true);
        frame.add(panel);


        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


        try {
            Thread.sleep(030);
        } catch (InterruptedException e) {
        }

        Image b1 = null;
        Image b2 = null;
        Image b3 = null;
        Image b4 = null;
        Image go = null;
        AudioClip loopaudio=null;
        bg = null;
        hero = null;
        //AudioClip loopAudio=null;
        try {

            b1 = ImageIO.read(Pack.class.getResource("../images/bot1.png"));
            b2 = ImageIO.read(Pack.class.getResource("../images/mini_bot2.png"));
            b3 = ImageIO.read(Pack.class.getResource("../images/mini_bot3.png"));
            b4 = ImageIO.read(Pack.class.getResource("../images/mini_bot4.png.png"));
            go = ImageIO.read(Pack.class.getResource("../images/go.jpg"));
            bg = ImageIO.read(Pack.class.getResource("../images/packman_bCKGROUND.png"));
            hero = ImageIO.read(Pack.class.getResource("../images/hero.png"));
            coin = ImageIO.read(Pack.class.getResource("../images/coin.png"));
            Pack.loopAudio=Applet.newAudioClip(Pack.class.getResource("../images/242857_4284968-lq.wav"));
           // Pack.loopAudio= Applet.newAudioClip(Pack.class.getResource("C:\\Users\\Ishan\\IdeaProjects\\packman\\src\\images\\abcd.wav"));
        } catch (IOException e) {
            //show user a error popup and exit the game.
            return;
        }
            Pack abc=new Pack();
        mainImage= new BufferedImage(1300, 700, BufferedImage.TYPE_INT_RGB);


        bot = new Image[]{b1, b2, b3, b4};
        initialSetup();
        graphics1=panel.getGraphics();
        graphics1.drawImage(mainImage, 0, 0, null);
        panel.requestFocus();
        panel.addKeyListener(new Pack());


        while (true) {            graphics = mainImage.getGraphics();


            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
            }

            n = bposx[0];
            m = bposy[0];
            botmove(n, m, 0);

            n = bposx[1];
            m = bposy[1];
            botmove(n, m, 1);

            n = bposx[2];
            m = bposy[2];
            botmove(n, m, 2);

            n = bposx[3];
            m = bposy[3];
            botmove(n, m, 3);

            for(i=0;i<4;i++)
            {
                if(herox==bposx[i]&&heroy==bposy[i])
                {graphics.clearRect(0, 0, 1400, 700);
                    graphics.drawImage(bg, 0, 0, null);

                    graphics.drawImage(b1, bposx[0], bposy[0], null);
                    graphics.drawImage(b2, bposx[1], bposy[1], null);
                    graphics.drawImage(b3, bposx[2], bposy[2], null);
                    graphics.drawImage(b4, bposx[3], bposy[3], null);
                    for (i=0;i<=p1;i++)
                        graphics.drawImage(coin,coinx[i]+21,coiny[i]+21,null);
                    graphics.drawImage(hero, herox, heroy, null);
                    graphics1.clearRect(0, 0, 1400, 700);
                    graphics1.drawImage(mainImage, 0, 0, null);
                    try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }graphics1.clearRect(0,0,1400,700);
                    graphics1.drawImage(go, 0, 0, null);
                    System.out.println("margaye tum"); try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }System.exit(0);
                }
            }

            graphics.clearRect(0, 0, 1400, 700);
            graphics.drawImage(bg, 0, 0, null);

            graphics.drawImage(b1, bposx[0], bposy[0], null);
            graphics.drawImage(b2, bposx[1], bposy[1], null);
            graphics.drawImage(b3, bposx[2], bposy[2], null);
            graphics.drawImage(b4, bposx[3], bposy[3], null);
            for (i=0;i<=p1;i++)
            graphics.drawImage(coin,coinx[i]+21,coiny[i]+21,null);
            System.out.println("p is"+p1);
            graphics.drawImage(hero, herox, heroy, null) ;
            graphics1.clearRect(0, 0, 1400, 700);
            graphics1.drawImage(mainImage, 0, 0, null);


            graphics.dispose();
        }


    }


    private static void initialSetup() {
        Graphics graphics = mainImage.getGraphics();
        int i, a, b, j, k, flag = 0, a1 = -1, b1 = -1;

        bposx[4] = 0;
        bposy[4] = 600;


        graphics.drawImage(bg, 0, 0, null);  //background
        graphics.drawImage(hero, herox, heroy, null);  //hero placed
        Random random = new Random();
        for (i = 0; i <= 3; i++) { //placing of bots
            a = random.nextInt(13);
            b = random.nextInt(7);
            for (j = 0; j < i; j++) {
                if (bposx[j] == a && bposy[j] == b) {
                    i--;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                flag = 0;
                continue;
            }
            if (a == 0 || b == 6) {
                i--;
                continue;
            }
            if (a == 0 || b == 5) {
                i--;
                continue;
            }
            if (a == 1 || b == 6) {
                i--;
                continue;
            }

            bposx[i] = a * 100;
            a1 = a;
            b1 = b;
            bposy[i] = b * 100;
            System.out.println("x is" + bposx[i] + " " + bposy[i]);
            graphics.drawImage(bot[i], (a * 100), (b * 100), null);

        }int o=1;
        for (i = 0; i <= 1200; i = i + 100) {//coins genrating function
            for (j = 0; j <= 600; j = j + 100) {
                flag = 0;if(i==0&&j==600){continue;}
                for (k = 0; k <= 4; k++) {
                    if (i == bposx[k] && j == bposy[k]) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    coinx[++p1] = i;
                    coiny[++p2] = j;

                    graphics.drawImage(coin, (i + 21), (j + 21), null);
                }
            }
        }
//        System.out.println("p is"+p1);

    }


    static void botmove(int a, int b, int z) {
        int rand[] = new int[4], k;
        rand[0] = 0;
        rand[1] = 0;
        rand[2] = 0;
        rand[3] = 0;
        int flag = 0, j;
        if (a == 0) flag = 1;                               //deewar h ki nai?   1
//        if (flag == 0) {
//            for (j = 0; j < 4; j++) {System.out.println("a");
//                if (j == z) {
//                    j++;
//                    continue;
//                }if(j==4)j=3;
//                if ((a - 100) == bposx[j])                      //bot hai ki nai     1
//                {
//                    flag = 1;
//                    break;
//                }
//            }
//        }
//        if (flag == 0) {
            for (j = 0; j <= p1; j++) {
                if ((a - 100) == coinx[j]&&b==coiny[j]) {
                    flag = 1;
                    break;
                }
            }
//        }
        if (flag == 0) {
            rand[0] = 1;
        }
        flag = 0;


        if (b == 0) flag = 1;                               //deewar h ki nai?   2
//        if (flag == 0) {
//            for (j = 0; j < 4; j++) {System.out.println("b");
//                if (j == z) {
//                    j++;
//                    continue;
//                }if(j==4)j=3;
//                if ((b - 100) == bposy[j])                      //bot hai ki nai    2
//                {
//                    flag = 1;
//                    break;
//                }
//            }
//        }
//        if (flag == 0) {
            for (j = 0; j <=p1; j++) {
                if ((b - 100) == coiny[j]&&a==coinx[j]) {
                    flag = 1;
                    break;
                }
            }
//        }
       if (flag == 0) {
            rand[1] = 1;
        }
        flag = 0;


        if (a == 1200) flag = 1;                               //deewar h ki nai?   3
//        if (flag == 0) {
//            for (j = 0; j < 4; j++) {System.out.println("c");
//                if (j == z) {
//                    j++;
//                    continue;
//                }if(j==4)j=3;
//                if ((a + 100) == bposy[j])                      //bot hai ki nai    3
//                {
//                    flag = 1;
//                    break;
//                }
//            }
//        }
//        if (flag == 0) {
            for (j = 0; j <= p1; j++) {
                if ((a + 100) == coinx[j]&&b==coiny[j]) {
                    flag = 1;
                    break;
                }
            }
//        }
        if (flag == 0) {
            rand[2] = 1;
        }
        flag = 0;


        if (b == 600) flag = 1;                               //deewar h ki nai?    4
//        if (flag == 0) {
//            for (j = 0; j < 4; j++) {System.out.println("d");
//                if (j == z) {
//                    j++;System.out.println("d1");
//                    continue;
//                }if(j==4)j=3;
//                if ((b + 100) == bposy[j])                      //bot hai ki nai    4
//                {System.out.println("d2");
//                    flag = 1;
//                    break;
//                }
//            }
//        }
//        if (flag == 0) {
            for (j = 0; j <= p1; j++)                                    //coin h ki nai    4
            {
                if ((b + 100) == coiny[j]&&a==coinx[j]) {
                    flag = 1;
                    break;
                }
            }
//        }
        if (flag == 0) {
            rand[3] = 1;
        }
        flag = 0;
        Random random = new Random();
        int i;
        k=random.nextInt(4);
        for(i=1;i<=4;i++)
        {    flag=0;
            if(rand[k]==1){flag=1;break;}
            k=k+1;
            k=k%4;
        }
        if(flag==1){
        if (k == 0)
            bposx[z] = bposx[z] - 100;
        if (k == 1)
            bposy[z] = bposy[z] - 100;
        if (k == 2)
            bposx[z] = bposx[z] + 100;
        if (k == 3)
            bposy[z] = bposy[z] + 100;}


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i, j;int flag=0;
        if (e.getKeyCode() == 37) {loopAudio.play();
            System.out.println("left me aaya tha");                       //left h

            if((herox==0)){flag=1;}
            for(i=0;i<=p1;i++)
            {
                if((herox-100)==coinx[i]&&heroy==coiny[i])
                {
                    for(j=i;j<p1;j++)
                    {
                        coinx[j]=coinx[j+1];
                        coiny[j]=coiny[j+1];
                        flag=2;
                    }p1--;p2--;
                }
            }
            if((flag%2)==0)
                herox=herox-100;


        }
        if (e.getKeyCode() == 38) {loopAudio.play();
            System.out.println("up me aaya tha");                       //left h

            if((heroy==0)){flag=1;}
            for(i=0;i<=p1;i++)
            {
                if((heroy-100)==coiny[i]&&herox==coinx[i])
                {
                    for(j=i;j<p1;j++)
                    {
                        coinx[j]=coinx[j+1];
                        coiny[j]=coiny[j+1];
                        flag=2;
                    }p1--;p2--;
                }
            }
            if((flag%2)==0)
                heroy=heroy-100;


        }
        if (e.getKeyCode() == 39) {loopAudio.play();
            System.out.println("right me aaya tha");                       //left h

            if((herox==1200)){flag=1;}
            for(i=0;i<=p1;i++)
            {
                if((herox+100)==coinx[i]&&heroy==coiny[i])
                {
                    for(j=i;j<p1;j++)
                    {
                        coinx[j]=coinx[j+1];
                        coiny[j]=coiny[j+1];
                        flag=2;
                    }p1--;p2--;
                }
            }
            if(flag%2==0)
                herox=herox+100;}



        if (e.getKeyCode() == 40) {loopAudio.play();
            System.out.println("down me aaya tha");                       //left h
            //down h
            if((heroy==600)){flag=1;}
            for(i=0;i<=p1;i++)
            {
                if((heroy+100)==coiny[i]&&herox==coinx[i])
                {
                    for(j=i;j<p1;j++)
                    {
                        coinx[j]=coinx[j+1];
                        coiny[j]=coiny[j+1];
                        flag=2;
                    }p1--;p2--;
                }
            }
            if((flag%2)==0)
                heroy=heroy+100;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
