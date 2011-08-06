import javax.swing.JFrame;

public class SquareGameRunner extends JFrame{
  
  public SquareGameRunner(){
    add(new SquareGame());
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 522);
    setLocationRelativeTo(null);
    setTitle("Square Game");
    
    setResizable(false);
    setVisible(true);
  }
  
  public static void main(String[] args){
    new SquareGameRunner();
  }
}