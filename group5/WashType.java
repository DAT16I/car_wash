public class WashType {
   
   private String washName = "Unknown";
   private int timesUsed = 0;
   
   public WashType() {
      
   }
   
   public void setWashName(String washName) {
      this.washName = washName;
   }
   public String getWashName() {
      return this.washName;
   }
   public void setTimesUsed(int timesUsed) {
      this.timesUsed = timesUsed;
   }
   public int getTimesUsed() {
      return this.timesUsed;
   }
   
   public String toString() {
      return washName + System.getProperty("line.separator") + timesUsed 
      + System.getProperty("line.separator") + "-" + System.getProperty("line.separator");
   }
}