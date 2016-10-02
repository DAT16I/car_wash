public class WashType {

   private String name;
   private int price;
   private int points;
   
   public WashType(String name, int price, int points) {
      this.name = name;
      this.price = price;
      this.points = points;
   }
   
   public String getWashTypeName() {
      return this.name; 
   }
   
   public void setWashTypeName(String name) {
      this.name = name; 
   } 
   
   public int getWashTypePrice() {
      return this.price; 
   }
   
   public void setWashTypePrice(int price) {
      this.price = price; 
   }
   
   public int getWashTypePoints() {
      return this.points; 
   }
   
   public void setWashTypePoints(int points) {
      this.points = points; 
   }
   
   
   public String toString() {
      return "----------------------------\n" + 
      "Wash Type: " + " " + getWashTypeName() + "\nPrice: " + getWashTypePrice() + " DKK" + 
      "\nLoyalty points: " + getWashTypePoints();
      
   }

  



}