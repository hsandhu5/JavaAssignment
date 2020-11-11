
public class PhotoBooth extends Wedding{// super class
   //public constant variable 
   public static final int MAX_NO_OF_PARTICIPANTS=5;
   public static int takenIncrement;
   public static int printedIncrement;
   public static int participantCounter;
   public double refundTotal;
   
   private int noOfParticipants;
   private String title;
   private String[] participantsEmails;
   private String emailSearch;
      
   public PhotoBooth(){//default constructor
   super();
   this.participantsEmails= new String[MAX_NO_OF_PARTICIPANTS];
   }
 
   // accessors
   public int getnoOfParticipants(){ return this.noOfParticipants;}
   public String getTitle(){ return this.title;}
   public static int getParticipantCounter(){ return participantCounter;}
     
    public String getParticipantsEmail( int index){
        if ( index < 0 || index >= participantCounter){
          throw new IllegalArgumentException("error; title required");
          }
       return this.participantsEmails[index];   
    }
   
   public String[] getParticipantsEmails() {
      String[] tempArray= new String [this.noOfParticipants];
      for ( int x=0; x< this.noOfParticipants; x++)
         tempArray[x]= this.getParticipantsEmail(x);
      }
      return tempArray;
   }
          
  public void setTitle( String title){
  if ( title==null || title.equals(""))
   {
      throw new IllegalArgumentException("error; title required");
      }
   takenIncrement++;
   this.title=title;   
   }
   // mutators  
   public void setNoOfParticipants( int noOfParticipants){
      if ( noOfParticipants > MAX_NO_OF_PARTICIPANTS || noOfParticipants<=0){// if stattement if participants between 1-5
         throw new IllegalArgumentException("error; invalid number of participants, must enter between 1-5");
      }
      this.noOfParticipants= noOfParticipants;
   }
   
   public void setEmail( String email){// email validation
   if (!(email.contains("@")
            || (email.charAt(0) >= 'A' && email.charAt(0) <= 'Z')
             && email.contains(".")
            || (email.charAt(0) >= '0' && email.charAt(0) <= '9')
            && email.lastIndexOf("@") == email.indexOf("@")
            && email.lastIndexOf(".") > email.indexOf("@")
            && email.lastIndexOf(".") < (email.length() - 2)
            && (email.charAt(0) >= 'a' && email.charAt(0) <= 'z'))) 
            { 
              throw new IllegalArgumentException("error; invalid emial");
            }
         this.participantsEmails[participantCounter]=email;
         participantCounter++;// incrementing counter for the participants in each photo
      }
   
   public static void setPrintedIncrement(){
      printedIncrement++;
   }
   
 /*  public static boolean setEmailSearch( String emailSearch){ 
     boolean found = false;  
     
      for( int x=0; x< participantCounter;x++){
         if(emailSearch.equals(this.getParticipantsEmail(x))){
         found = true;   
         }
//          else { 
//          throw new IllegalArgumentException("error; invalid email");
//         }
      }
//      for(int x=0; x<participantsEmails.length; x++){
//         if(emailSearch.equals(participantsEmails[x])){
//             found = true;   
//            }
     return found;
   }*/
   
   public double RefundTotal (double refundTotal){
    int total= super.getMaxPhotoPrinted()- printedIncrement; 
    refundTotal+= UNPRINTED_RATE*total;   
    return refundTotal;        
   }
   
   public String toString(){// special purpose  method for printing final report
     String output= "Final Report" ;
     output+="\n Couple Photo Title: "+ this.getTitle() + "\n Participants Emails: ";
     if ( participantCounter > 0){
         output+= "Email: "+"\n";
         for( int x=0; x< participantCounter;x++){// using the for loop to itirate throught the array to print
            output+= this.getParticipantsEmail(x)+ "\n";
         }
     }
     output+= "\n" +" number of photographs taken: "+takenIncrement + "\n number of photographs printed: "+ printedIncrement + "\n refund amount: "+ refundTotal;
      return output;
   }
}
   
  