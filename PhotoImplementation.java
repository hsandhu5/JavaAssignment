
import javax.swing.JOptionPane;
public class PhotoImplementation {
   public static void main(String[] args) {

   int maxPhotosAllowed = coupleInfo();// 
   PhotoBooth[] photos = new PhotoBooth[maxPhotosAllowed];// intaiting the object array 

   int photosTaken = 0;

    do {
       PhotoBooth aphoto= photoInfo();//
       photos[photosTaken] = aphoto;// 
       photosTaken++;   
    }while((JOptionPane.showConfirmDialog(null, "enter another photo? ","confirm",JOptionPane.YES_NO_OPTION)
             == JOptionPane.YES_OPTION) && photosTaken<=maxPhotosAllowed );// keeping looping until user enter YES and photosTaken less than equal to maxPhotosAllowed
   
   // Getting nullPointer exception for some reason for SearchEmail METHOD BELOW
   //SearchEmail(photos);
   printFinalReport(photos);// calling the printFinalReport method
 } 

   public static int coupleInfo(){
   Wedding couple= new Wedding();
   String email = "";
      do{
         try{
            email = JOptionPane.showInputDialog("enter brides email");// getting user input
            }
         catch(IllegalArgumentException e){
            JOptionPane.showInputDialog("error: enter brides email");
            }
        }while(!couple.setBrideEmail(email));// setting the brideEmail in the couple object
      
   int max_photos = 0;
      do{
         try{
            max_photos = Integer.parseInt(JOptionPane.showInputDialog("enter max photos"));
            }
         catch(IllegalArgumentException e){
            JOptionPane.showInputDialog("error: invalid max photos input");
            }
        }while(!couple.setMaxPhotoAllowed(max_photos));// setting the maxphotosallowed in the couple object
       
   int max_photos_printed = 0;
      do{
         try{
            max_photos_printed = Integer.parseInt(JOptionPane.showInputDialog("enter max photos to be printed"));
            }
         catch(IllegalArgumentException e){
            JOptionPane.showInputDialog("error: invalid max printed input");
            }
        }while(!couple.setMaxPhotoPrinted(max_photos_printed));// setting the maxphotoprinted in the couple object
    return max_photos;
    }
    public static PhotoBooth  photoInfo(){
    
    PhotoBooth photo= new PhotoBooth();// intiating new object
    
    photo.setTitle(JOptionPane.showInputDialog( "enter the photo title"));// user input for setting the photo title
    
    photo.setNoOfParticipants(Integer.parseInt(JOptionPane.showInputDialog("enter number of participants")));
    int emailCounter=1;
    
    while(emailCounter<=photo.getnoOfParticipants()){
      try{
          photo.setEmail(JOptionPane.showInputDialog( "enter participants email "));// setting and validing email 
         }
      catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "error ");
            }
       emailCounter++;// incrementing the counter
       
      }  
    int option;
    option= JOptionPane.showConfirmDialog(null, "would you like to print? ","confirm",JOptionPane.YES_NO_OPTION);
      if ( option== JOptionPane.YES_OPTION){
         PhotoBooth.setPrintedIncrement();
      }
    return photo;// returning the photo object
    }

   public static void SearchEmail(PhotoBooth[] photos){
   boolean found= false;
   int searchCounter=0;
   do{
   String search="";
    { 
      try{ 
         search =JOptionPane.showInputDialog("enter the email you want to search");
         }
      catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, " error: try again");
            }
         int photoCounter = 0;
         for( int x=0; x<photos.length; x++){
            String[] a = new String[photos[x].getParticipantsEmails().length];
            for(int j=0; j<a.length;j++) {
               //JOptionPane.showMessageDialog(null, photos[j].getParticipantsEmail(j));
               if(search.equals(photos[j].getParticipantsEmail(j))){
                  photoCounter++;
               }
            }
           // PhotoBooth.setEmailSearch(search);
            }
            JOptionPane.showMessageDialog(null,photoCounter);
         } 
      }while(!(JOptionPane.showConfirmDialog(null, "search another email? ","confirm",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)); 
   }
   public static void printFinalReport(PhotoBooth[] photos){
      for(int i = 0; i<photos.length;i++){//looping through the array to print
      JOptionPane.showMessageDialog( null, photos[i].toString());
      
      }
   }
}