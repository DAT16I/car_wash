public class WashCard extends Card {
   
   private String type;
   private int pin;
   private double amount;
   private int loyaltyPoints;
   private int discounts; 
   private boolean admin;  
   
   public WashCard (String type, int pin, double amount, int loyaltyPoints, boolean admin) {
      
      super(type, pin, amount);
      this.loyaltyPoints = loyaltyPoints;
      this.discounts = (loyaltyPoints - loyaltyPoints % 10 )/ 10;
      this.admin = admin;
   }
   
   public boolean getAdmin() {
      return this.admin;
   }
   
   public String getCardType() {
      return this.type; 
   }
   
   public void setCardType(String type) {
      this.type = type; 
   } 
     
   public int getCardPin() {
      return super.getCardPin(); 
   }
   
   public void setCardPin(int pin) {
      this.pin = pin; 
   }
   
   public double getCardAmount() {
      return super.getCardAmount(); 
   }
   
   public void setCardAmount(double amount) {
      this.amount = amount; 
   }
  
      
   public int getLoyaltyPoints() {
      return this.loyaltyPoints;
   }
   
   public void setLoyaltyPoints() {
      this.loyaltyPoints = loyaltyPoints;
   }    
   
   public int getDiscounts() {
      return this.discounts;    
   }
   
   
   public String toString() {
      return "----------------------------" + " " + "\n" + super.toString() + " " + "\nLoyalty points: " + this.loyaltyPoints + 
      " " + "\n Discounts: " + getDiscounts();
   }
   public void setNewAmount (double newAmount) {
     super.setCardAmount(newAmount);
     System.out.println ("NEW: " + newAmount);
  }
   

}