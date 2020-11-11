import javax.swing.JOptionPane;
public class ServerImplementation {
   public static void main(String[] args) {
   
   //Server[] serverInfo= new Server[MAX_CAPACITY];
   int serverEntered=0;
   do{
      Server aServer= serverInfo ();
      serverEntered++;
   }while((JOptionPane.showConfirmDialog(null, "enter another photo? ","confirm",JOptionPane.YES_NO_OPTION)
             == JOptionPane.YES_OPTION)  );//&& serverEntered<=MAX_CAPACITY
  } 
   public static void serverInfo (){
   Server server= new Server();
   String servType="";
      do{
         try{
            servType = JOptionPane.showInputDialog("enter server type: ");// getting user input
            }
         catch(IllegalArgumentException e){
            JOptionPane.showInputDialog("error: enter server type");
            }
        }while(!server.setServerType(servType));
      
   }
   
   
  
}