package demo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Ishan on 9/12/2016.
 */
public class Tic implements KeyListener {
    public static  JPanel panel;public static int p;public static int[][] a=new int[3][3];public static int a1,a2,i,j;
    public static Graphics graphics;public static Random random=new Random();;
    public static Image board=null,o=null,x=null;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        p=0;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        a1=random.nextInt(3);
      a2=random.nextInt(3);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,500));
        panel.setFocusable(true);
        frame.add(panel);


        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);

        panel.requestFocus();
        panel.addKeyListener(new Tic());

        for(i=0;i<3;i++){
            for(j=0;j<3;j++)
                a[i][j]=3;
        }

        try {
            board= ImageIO.read(Tic.class.getResource("../images/board.png"));
            x= ImageIO.read(Tic.class.getResource("../images/x.png"));
            o= ImageIO.read(Tic.class.getResource("../images/o.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }



        graphics=panel.getGraphics();
        graphics.drawImage(board,100,100,null);

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(p==0){
            if (e.getKeyCode() == 49)
            {p=1;graphics.drawImage(x,90,130,null);a[0][0]=1;
                analise();}
            if (e.getKeyCode() == 50)
            {p=1;graphics.drawImage(x,200,130,null);a[0][1]=1;
                analise();}
            if (e.getKeyCode() == 51)
            {p=1;graphics.drawImage(x,310,130,null);a[0][2]=1;
                analise();}
            if (e.getKeyCode() == 52)
            {p=1;graphics.drawImage(x,90,230,null);a[1][0]=1;
                analise();}
            if (e.getKeyCode() == 53)
            {p=1;graphics.drawImage(x,200,230,null);a[1][1]=1;
                analise();}
            if (e.getKeyCode() == 54)
            {p=1;graphics.drawImage(x,310,230,null);a[1][2]=1;
                analise();}
            if (e.getKeyCode() == 55)
            {p=1;graphics.drawImage(x,90,330,null);a[2][0]=1;
                analise();}
            if (e.getKeyCode() == 56)
            {p=1;graphics.drawImage(x,200,330,null);a[2][1]=1;
                analise();}
            if (e.getKeyCode() == 57)
            {p=1;graphics.drawImage(x,310,330,null);a[2][2]=1;
                analise();}
        }


        else
        {
            if (e.getKeyCode() == 49)
            {p=2;graphics.drawImage(x,90,130,null);a[0][0]=1;
                analise();}
            if (e.getKeyCode() == 50)
            {p=2;graphics.drawImage(x,200,130,null);a[0][1]=1;
                analise();}
            if (e.getKeyCode() == 51)
            {p=2;graphics.drawImage(x,310,130,null);a[0][2]=1;
                analise();}
            if (e.getKeyCode() == 52)
            {p=2;graphics.drawImage(x,90,230,null);a[1][0]=1;
                analise();}
            if (e.getKeyCode() == 53)
            {p=2;graphics.drawImage(x,200,230,null);a[1][1]=1;
                analise();}
            if (e.getKeyCode() == 54)
            {p=2;graphics.drawImage(x,310,230,null);a[1][2]=1;
                analise();}
            if (e.getKeyCode() == 55)
            {p=2;graphics.drawImage(x,90,330,null);a[2][0]=1;
                analise();}
            if (e.getKeyCode() == 56)
            {p=2;graphics.drawImage(x,200,330,null);a[2][1]=1;
                analise();}
            if (e.getKeyCode() == 57)
            {p=2;graphics.drawImage(x,310,330,null);a[2][2]=1;
                analise();}
        }
    }
        public static void analise(){
           if(p==1) {if(a[0][0]==1||a[2][2]==1||a[0][2]==1||a[2][0]==1)
           {
               graphics.drawImage(o,((1*100)+120),((1*100)+120),null);a[1][1]=0;return;}
               if(a[1][1]==1)
               {graphics.drawImage(o,((0*100)+120),((0*100)+120),null);a[0][0]=0;}
               else{graphics.drawImage(o,((a1*100)+120),((a2*100)+120),null);a[a1][a2]=0;}}
           else
           {System.out.println("else enter h");int jeet=0;int khaali=0;
               int cnt=0,hai=0;               //pehli row
               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[0][i]==0)
                       jeet++;
                   if(a[0][i]==3)
                       khaali++;
                   if(jeet==2&&khaali==1)
                   {
                       for(i=0;i<3;i++)
                       {
                           if(a[0][i]==3)
                           {graphics.drawImage(o,((i*100)+120),120,null);return;}

                       }

                   }

               }

               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[1][i]==0)
                       jeet++;
                   if(a[1][i]==3)
                       khaali++;
                   if(jeet==2&&khaali==1)
                   {
                       for(i=0;i<3;i++)
                       {
                           if(a[1][i]==3)
                           {graphics.drawImage(o,((i*100)+120),220,null);return;}

                       }

                   }

               }

               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[2][i]==0)
                       jeet++;
                   if(a[2][i]==3)
                       khaali++;
                   if(jeet==2&&khaali==1)
                   {
                       for(i=0;i<3;i++)
                       {
                           if(a[2][i]==3)
                           {graphics.drawImage(o,((i*100)+120),320,null);return;}

                       }

                   }

               }


               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[i][0]==0)
                       jeet++;
                   if(a[i][0]==3)
                       khaali++;
                   if(jeet==2&&khaali==1)
                   {
                       for(i=0;i<3;i++)
                       {
                           if(a[i][0]==3)
                           {graphics.drawImage(o,120,((i*100)+120),null);return;}

                       }

                   }

               }



               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[i][1]==0)
                       jeet++;
                   if(a[i][1]==3)
                       khaali++;
                   if(jeet==2&&khaali==1)
                   {
                       for(i=0;i<3;i++)
                       {
                           if(a[i][1]==3)
                           {graphics.drawImage(o,220,((i*100)+120),null);return;}

                       }

                   }

               }


               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[i][2]==0)
                       jeet++;
                   if(a[i][2]==3)
                       khaali++;
                   if(jeet==2&&khaali==1)
                   {
                       for(i=0;i<3;i++)
                       {
                           if(a[i][2]==3)
                           {graphics.drawImage(o,320,((i*100)+120),null);return;}

                       }

                   }

               }

               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[i][i]==0)
                       jeet++;
                   if(a[i][i]==3)
                       khaali++;
                   if(jeet==2&&khaali==1)
                   {
                       System.out.println("yo");
                       for(i=0;i<3;i++)
                       {
                           if(a[i][i]==3)
                           {graphics.drawImage(o,((i*100)+120),((i*100)+120),null);return;}

                       }

                   }

               }

               jeet=0;khaali=0;
               for(i=0;i<3;i++)
               {
                   if(a[2-i][i]==0)
                       jeet++;
                   if(a[2-i][i]==3)
                   { khaali++;}
                   if(jeet==2&&khaali==1)
                   {  System.out.println("yo1");
                       for(i=0;i<3;i++)
                       {
                           if(a[2-i][i]==3)
                           {
                               System.out.println(2-i+"  "+i);
                               graphics.drawImage(o,((i*100)+120),(((2-i)*100)+120),null);return;}

                       }

                   }

               }




               if(a[0][1]!=0&&a[0][0]!=0&&a[0][2]!=0)
               {           for(i=0;i<3;i++)
                             { if(a[0][i]==1)cnt++;}
                            if(cnt==2){hai=1;
                           for(i=0;i<3;i++)
                           { if(a[0][i]==3){a[0][i]=0;graphics.drawImage(o,((i*100)+120),120,null);
                               System.out.println("1");return;}}}

                 cnt=0; }



               if(a[1][1]!=0&&a[1][0]!=0&&a[1][2]!=0)  //doosri row
               {           for(i=0;i<3;i++)
               { if(a[1][i]==1)cnt++;}
                   if(cnt==2){hai=1;
                       for(i=0;i<3;i++)
                       { if(a[1][i]==3){a[1][i]=0;graphics.drawImage(o,((i*100)+120),220,null);System.out.println("2");return;}}}

                   cnt=0;  }



               if(a[2][1]!=0&&a[2][0]!=0&&a[2][2]!=0) //teesri row
               {           for(i=0;i<3;i++)
               { if(a[2][i]==1)cnt++;}
                   if(cnt==2){hai=1;
                       for(i=0;i<3;i++)
                       { if(a[2][i]==3){a[2][i]=0;graphics.drawImage(o,((i*100)+120),320,null);System.out.println("3");return;}}}

                   cnt=0; }



               if(a[0][0]!=0&&a[1][0]!=0&&a[2][0]!=0)
               {           for(i=0;i<3;i++)
               { if(a[i][0]==1)cnt++;}
                   if(cnt==2){hai=1;
                       for(i=0;i<3;i++)
                       { if(a[i][0]==3){a[i][0]=0;graphics.drawImage(o,120,((i*100)+120),null);return;}}}

                   cnt=0;  }


               if(a[0][1]!=0&&a[1][1]!=0&&a[2][1]!=0)
               {           for(i=0;i<3;i++)
               { if(a[i][1]==1)cnt++;}
                   if(cnt==2){hai=1;
                       for(i=0;i<3;i++)
                       { if(a[i][1]==3){a[i][1]=0;graphics.drawImage(o,220,((i*100)+120),null);return;}}}

                   cnt=0;  }


               if(a[0][2]!=0&&a[1][2]!=0&&a[2][2]!=0)
               {           for(i=0;i<3;i++)
               { if(a[i][2]==1)cnt++;}
                   if(cnt==2){hai=1;
                       for(i=0;i<3;i++)
                       { if(a[i][2]==3){a[i][2]=0;graphics.drawImage(o,320,((i*100)+120),null);return;}}}

                   cnt=0;  }


               if(a[0][0]!=0&&a[1][1]!=0&&a[2][2]!=0)
               {           for(i=0;i<3;i++)
               { if(a[i][i]==1)cnt++;}
                   if(cnt==2){hai=1;
                       for(i=0;i<3;i++)
                       { if(a[i][i]==3){a[i][i]=0;graphics.drawImage(o,((i*100)+120),((i*100)+120),null);return;}}}

                   cnt=0;  }


               if(a[0][2]!=0&&a[1][1]!=0&&a[2][0]!=0)
               {           for(i=0;i<3;i++)
               { if(a[2-i][i]==1)cnt++;}
                   if(cnt==2){hai=1;
                       for(i=0;i<3;i++)
                       { if(a[2-i][i]==3){a[2-i][i]=0;graphics.drawImage(o,((i*100)+120),(((2-i)*100)+120),null);return;}}}

                   cnt=0;  }
               System.out.println("random h");
int y=0;
               for (i=0;i<3;i++){
                   for(j=0;j<3;j++) {if(a[i][j]!=0&&a[i][j]!=1){a1=i;a2=j;
                       System.out.println(a1+"   "+a2);y=1;break;}
                   }
                   if(y==1)break;}a[a1][a2]=0;
               if(a1==0&&a2==0)
               {graphics.drawImage(o,120,120,null); }
               if(a1==0&&a2==1)
               {graphics.drawImage(o,220,120,null); }
               if(a1==0&&a2==2)
               {graphics.drawImage(o,320,120,null); }
               if(a1==1&&a2==0)
               {graphics.drawImage(o,120,220,null); }
               if(a1==1&&a2==1)
               {graphics.drawImage(o,220,220,null); }
               if(a1==1&&a2==2)
               {graphics.drawImage(o,320,220,null); }
               if(a1==2&&a2==0)
               {graphics.drawImage(o,120,320,null); }
               if(a1==2&&a2==1)
               {graphics.drawImage(o,220,320,null); }
               if(a1==2&&a2==2)
               {graphics.drawImage(o,320,320,null); }
               }
        }
}




