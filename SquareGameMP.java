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

public class SquareGameMP extends JPanel implements ActionListener{
  
  private int[][] board;
  private int turn1, turn2;
  private Image blue1, blue2, red1, red2, back, btar, rtar;
  private javax.swing.Timer t;
  private boolean redWin, blueWin;
  
  public SquareGameMP(){
    redWin = false;
    blueWin = false;
    addKeyListener(new TAdapter());
    turn1 = 0;
    turn2 = 2;
    board = new int[10][10];
    board[0][0] = 3;
    board[9][0] = 4;
    board[0][9] = 1;
    board[9][9] = 2;
    ImageIcon r = new ImageIcon(this.getClass().getResource("Red.jpg"));
    red1 = r.getImage();
    ImageIcon b = new ImageIcon(this.getClass().getResource("Blue.jpg"));
    blue1 = b.getImage();
    ImageIcon g = new ImageIcon(this.getClass().getResource("Blue.jpg"));
    blue2 = g.getImage();
    ImageIcon y = new ImageIcon(this.getClass().getResource("Red.jpg"));
    red2 = y.getImage();
    ImageIcon w = new ImageIcon(this.getClass().getResource("Back.jpg"));
    back = w.getImage();
    ImageIcon rt = new ImageIcon(this.getClass().getResource("RedTar.jpg"));
    rtar = rt.getImage();
    ImageIcon bt = new ImageIcon(this.getClass().getResource("BlueTar.jpg"));
    btar = bt.getImage();
    setFocusable(true);
    t = new javax.swing.Timer(600,this);
    t.start();
  }
  
  public void switchTurn1(){
    turn1++;
    if (turn1 > 1)
      turn1 = 0;
  }
  
  public void switchTurn2(){
    turn2++;
    if (turn2 > 3)
      turn2 = 2;
  }
  
  public String find1(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] == (turn1 + 1)){
          return "" + i + j;
        }
      }
    }
    return "";
  }
  
  public String find2(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] == (turn2 + 1)){
          return "" + i + j;
        }
      }
    }
    return "";
  }
  
  public void moveUp1(){
    String place = find1();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (r != 0 && board[r-1][c] == 0){
      board[r-1][c] = turn1+1;
      board[r][c] = 0;
    }
  }
  
  public void moveDown1(){
    String place = find1();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (r != 9 && board[r+1][c] == 0){
      board[r+1][c] = turn1+1;
      board[r][c] = 0;
    }
  }
  
  public void moveRight1(){
    String place = find1();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (c != 9 && board[r][c+1] == 0){
      board[r][c+1] = turn1+1;
      board[r][c] = 0;
    }
  }
  
  public void moveLeft1(){
    String place = find1();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (c != 0 && board[r][c-1] == 0){
      board[r][c-1] = turn1+1;
      board[r][c] = 0;
    }
  }
  
  public void moveUp2(){
    String place = find2();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (r != 0 && board[r-1][c] == 0){
      board[r-1][c] = turn2+1;
      board[r][c] = 0;
    }
  }
  
  public void moveDown2(){
    String place = find2();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (r != 9 && board[r+1][c] == 0){
      board[r+1][c] = turn2+1;
      board[r][c] = 0;
    }
  }
  
  public void moveRight2(){
    String place = find2();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (c != 9 && board[r][c+1] == 0){
      board[r][c+1] = turn2+1;
      board[r][c] = 0;
    }
  }
  
  public void moveLeft2(){
    String place = find2();
    int r = Integer.parseInt(place.substring(0,1));
    int c = Integer.parseInt(place.substring(1,2));
    if (c != 0 && board[r][c-1] == 0){
      board[r][c-1] = turn2+1;
      board[r][c] = 0;
    }
  }
  
  public void paint(Graphics g){
    super.paint(g);
    g.drawImage(back,0,0,this);
    if (redWin){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++){
          g.drawImage(red1,j*50,i*50,this);
        }
      }
    }
    else if (blueWin){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++){
          g.drawImage(blue1,j*50,i*50,this);
        }
      }
    }
    else {
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++){
          if (board[i][j] != 0){
            if (board[i][j] == 1){
              if (turn1 == 0)
                g.drawImage(rtar,j*50,i*50,this);
              else
                g.drawImage(red1,j*50,i*50,this);
            }
            if (board[i][j] == 2){
              if (turn1 == 1)
                g.drawImage(rtar,j*50,i*50,this);
              else
                g.drawImage(red2,j*50,i*50,this);
            }
            if (board[i][j] == 3){
              if (turn2 == 2)
                g.drawImage(btar,j*50,i*50,this);
              else
                g.drawImage(blue1,j*50,i*50,this);
            }
            if (board[i][j] == 4){
              if (turn2 == 3)
                g.drawImage(btar,j*50,i*50,this);
              else
                g.drawImage(blue2,j*50,i*50,this);
            }
          }
        }
      }
    }
  }
  
  private class TAdapter extends KeyAdapter{
    public void keyPressed(KeyEvent e){
      int keycode = e.getKeyCode();
      if (!redWin && !blueWin){
        if (keycode == KeyEvent.VK_LEFT)
          moveLeft1();
        if (keycode == KeyEvent.VK_RIGHT)
          moveRight1();
        if (keycode == KeyEvent.VK_UP)
          moveUp1();
        if (keycode == KeyEvent.VK_DOWN)
          moveDown1();
        if (keycode == KeyEvent.VK_SHIFT)
          switchTurn1();
        if (keycode == KeyEvent.VK_A)
          moveLeft2();
        if (keycode == KeyEvent.VK_D)
          moveRight2();
        if (keycode == KeyEvent.VK_W)
          moveUp2();
        if (keycode == KeyEvent.VK_S)
          moveDown2();
        if (keycode == KeyEvent.VK_F)
          switchTurn2();
      }
      repaint();
      if (blueLoss())
        redWin();
      else if (redLoss())
        blueWin();
      if (keycode == KeyEvent.VK_R){
        board = new int[10][10];
        board[0][0] = 3;
        board[9][0] = 4;
        board[0][9] = 1;
        board[9][9] = 2;
        turn1 = 0;
        turn2 = 2;
        redWin = false;
        blueWin = false;
        repaint();
      }
    }
  }
  
  public boolean blueLoss(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] == 1 || board[i][j] == 2){
          if (i < board.length - 2){
            if (board[i+1][j] == 3 || board[i+1][j] == 4){
              if (board[i+2][j] == 1 || board[i+2][j] == 2){
                return true;
              }
            }
          }
          if (j < board.length - 2){
            if (board[i][j+1] == 3 || board[i][j+1] == 4){
              if (board[i][j+2] == 1 || board[i][j+2] == 2){
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean redLoss(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] == 3 || board[i][j] == 4){
          if (i < board.length - 2){
            if (board[i+1][j] == 1 || board[i+1][j] == 2){
              if (board[i+2][j] == 3 || board[i+2][j] == 4){
                return true;
              }
            }
          }
          if (j < board.length - 2){
            if (board[i][j+1] == 1 || board[i][j+1] == 2){
              if (board[i][j+2] == 3 || board[i][j+2] == 4){
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public void redWin(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        board[i][j] = 5;
      }
    }
    redWin = true;
    repaint();
  }
  
  public void blueWin(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        board[i][j] = 5;
      }
    }
    blueWin = true;
    repaint();
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
  
  private class SGClient extends Client{
    private String myLastAction;
    
    public string welFareProgramerAction(String t){
      myLastAction = t;
      action();
    }
    public String action(){
      return myLastAction; 
    }
    
    public String response(){
      String msg = getMessage();
      if (msg.equals("u"))
        
    }
    
  }
}