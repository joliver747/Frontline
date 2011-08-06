public class SGClient extends Client{
  
  private SquareGameMP game;
  
  public String action(String event){
    return event;
  }
  
  public String response(){
    if(getMessage().equals("up");
    SquareGameMP.makeMove(getMessage());
  }
}