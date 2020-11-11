
public class  Wedding{
   public static final double UNPRINTED_RATE = 2.0;//final constant vairable
   
   private String brideEmail;
   private static int maxPhotoAllowed;
   private static int maxPhotoPrinted;
   
   public Wedding (){//default constructor
    
   }
   //accessors
   public int getMaxPhotoAllowed(){ return this.maxPhotoAllowed;}
   public int getMaxPhotoPrinted() {return this.maxPhotoPrinted;}
   public String getBrideEmail(){ return this.brideEmail;}
 
   public boolean setBrideEmail( String brideEmail){// brideEmail validation 
       if (!(brideEmail.contains("@")
            || (brideEmail.charAt(0) >= 'A' && brideEmail.charAt(0) <= 'Z')
             && brideEmail.contains(".")
            || (brideEmail.charAt(0) >= '0' && brideEmail.charAt(0) <= '9')
            && brideEmail.lastIndexOf("@") == brideEmail.indexOf("@")
            && brideEmail.lastIndexOf(".") > brideEmail.indexOf("@")
            && brideEmail.lastIndexOf(".") < (brideEmail.length() - 2)
            && (brideEmail.charAt(0) >= 'a' && brideEmail.charAt(0) <= 'z'))) 
                  { 
                    throw new IllegalArgumentException("error; invalid emial");
                  }
            this.brideEmail=brideEmail;
            return true;
            }
            
   //mututors
   public boolean setMaxPhotoAllowed( int maxPhotoAllowed){
      if ( maxPhotoAllowed<= 0) {
         throw new IllegalArgumentException("error; invalid input");// if true then throw error
      }  
      return true;
   }
   
   public boolean setMaxPhotoPrinted( int maxPhotoPrinted) {
      if ( maxPhotoPrinted<=0){
            throw new IllegalArgumentException("error; invalid input");// if true then throw error
         }
      return true;
   }
}