public class Costumer {
   
   private int cardID;
   private int cardBalance;
   
   public Costumer() {
      
   }
   
   public void setCardID(int cardID) {
      this.cardID = cardID;
   }
   public int getCardID() {
      return this.cardID;
   }
   public void setCardBalance(int cardBalance) {
      this.cardBalance = cardBalance;
   }
   public int getCardBalance() {
      return this.cardBalance;
   }
   
   
   public String toString() {
      return cardID + System.getProperty("line.separator") + cardBalance 
      + System.getProperty("line.separator") + "-" + System.getProperty("line.separator");
   }
}