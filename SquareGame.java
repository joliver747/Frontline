import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SquareGame extends JPanel implements ActionListener{
  
  private int[][] board;
  private int turn;
  private Image blue, green, red, yellow, back, btar, gtar, rtar, ytar;
  private javax.swing.Timer t;
  
  public SquareGame(){
    addKeyListener(new TAdapter());
    turn = 0;
    board = new int[10][10];
    board[0][0] = 1;
    board[0][9] = 2;
    board[9][0] = 3;
    board[9][9] = 4;
    ImageIcon r = new ImageIcon(this.getClass().getResource("Red.jpg"));
    red = r.getImage();
    ImageIcon b = new ImageIcon(this.getClass().getResource("Blue.jpg"));
    blue = b.getImage();
    ImageIcon g = new ImageIcon(this.getClass().getResource("Green.jpg"));
    green = g.getImage();
    ImageIcon y = new ImageIcon(this.getClass().getResource("Yellow.jpg"));
    yellow = y.getImage();
    ImageIcon w = new ImageIcon(this.getClass().getResource("Back.jpg"));
    back = w.getImage();
    ImageIcon rt = new ImageIcon(this.getClass().getResource("RedTar.jpg"));
    rtar = rt.getImage();
    ImageIcon gt = new ImageIcon(this.getClass().getResource("GreenTar.jpg"));
    gtar = gt.getImage();
    ImageIcon yt = new ImageIcon(this.getClass().getResource("YellowTar.jpg"));
    ytar = yt.getImage();
    ImageIcon bt = new ImageIcon(this.getClass().getResource("BlueTar.jpg"));
    btar = bt.getImage();
    setFocusable(true);
    t = new javax.swing.Timer(600,this);
    t.start();
  }
  
  public void switchTurn(){
    turn++;
    if (turn > 3)
      turn = 0;
  }
  
  public String find(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] == (turn + 1)){
          return "" + i + j;
        }
      }
    }
    return "";
  }
  
  public void moveUp(){
    String place = find();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (r != 0 && board[r-1][c] == 0){
      board[r-1][c] = turn+1;
      board[r][c] = 0;
    }
  }
  
  public void moveDown(){
    String place = find();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (r != 9 && board[r+1][c] == 0){
      board[r+1][c] = turn+1;
      board[r][c] = 0;
    }
  }
  
  public void moveRight(){
    String place = find();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (c != 9 && board[r][c+1] == 0){
      board[r][c+1] = turn+1;
      board[r][c] = 0;
    }
  }
  
  public void moveLeft(){
    String place = find();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (c != 0 && board[r][c-1] == 0){
      board[r][c-1] = turn+1;
      board[r][c] = 0;
    }
  }
  
  public void paint(Graphics g){
    super.paint(g);
    g.drawImage(back,0,0,this);
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0){
          if (board[i][j] == 1){
            if (turn == 0)
              g.drawImage(rtar,j*50,i*50,this);
            else
              g.drawImage(red,j*50,i*50,this);
          }
          if (board[i][j] == 2){
            if (turn == 1)
              g.drawImage(btar,j*50,i*50,this);
            else
              g.drawImage(blue,j*50,i*50,this);
          }
          if (board[i][j] == 3){
            if (turn == 2)
              g.drawImage(gtar,j*50,i*50,this);
            else
              g.drawImage(green,j*50,i*50,this);
          }
          if (board[i][j] == 4){
            if (turn == 3)
              g.drawImage(ytar,j*50,i*50,this);
            else
              g.drawImage(yellow,j*50,i*50,this);
          }
        }
      }
    }
  }
  
  private class TAdapter extends KeyAdapter{
    public void keyPressed(KeyEvent e){
      int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_LEFT)
          moveLeft();
        if (keycode == KeyEvent.VK_RIGHT)
          moveRight();
        if (keycode == KeyEvent.VK_UP)
          moveUp();
        if (keycode == KeyEvent.VK_DOWN)
          moveDown();
        if (keycode == KeyEvent.VK_SHIFT){
          switchTurn();
        }
        repaint();
    }
  }
  
  public void actionPerformed(ActionEvent arg0){
  }
  
  public void print(){
    String ans = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        ans+= board[i][j] + " ";
      }
      ans += "\n";
    }
    System.out.println(ans);
  }

}