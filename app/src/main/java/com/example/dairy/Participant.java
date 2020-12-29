package com.example.dairy;

public class Participant extends Person{
   private int CardID;
   private static int lastCardID=1;

   public Participant(String fullName, long phone) {
      super(fullName, phone);
   }

   public int getCardID() {
      return CardID;
   }

   public static int getLastCardID() {
      return lastCardID;
   }
   private void increaseID(){
      lastCardID++;
   }

   public void setCardID() {
      CardID = getLastCardID();
      increaseID();
   }
}
