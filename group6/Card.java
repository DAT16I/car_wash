public class Card {

   private String type;
   private int pin;
   private double amount;
   
   
   public Card(String type, int pin, double amount){
      this.type = type;
      this.pin = pin;
      this.amount = amount;
   }
   
   public String getCardType(){
      return this.type; 
   }
   
   public void setCardType(String type){
      this.type = type; 
   }
   public int getCardPin(){
      return this.pin; 
   }
   
   public void setCardPin(int pin){
      this.pin = pin; 
   }
   public double getCardAmount(){
      return this.amount; 
   }
   
  //  public void setCardAmount(){
//       this.amount = amount; 
//    }
   public void setCardAmount(double amount){
      this.amount = amount; 
   }
   public String toString() {
      return "Type: " + this.type + " " + "\nPincode: " + Integer.toString(this.pin) + 
      " " + "\nBalance: " + Double.toString(this.amount) + " DKK";
   }

  public void setNewAmount (double newAmount) {
     this.amount = newAmount;
     System.out.println ("NEW: " + newAmount);
  }


}