package action;

import java.time.LocalDateTime;

public class Action {

   private int actionId;
   private LocalDateTime localDateTime;
   private int lineNo;
   private String text;
   private boolean isAddition;

   public Action(int actionId, LocalDateTime localDateTime, boolean isAddition, int lineNo, String text) {

      this.actionId = actionId;
      this.localDateTime = localDateTime;
      this.lineNo = lineNo;
      this.text = text;
      this.isAddition = isAddition;
   }

   public int getActionId() {
      return this.actionId;
   }

   public void setActionId(int id) {
      this.actionId = id;
   }

   public LocalDateTime getLocalDateTime() {
      return this.localDateTime;
   }

   public int getLineNo() {
      return this.lineNo;
   }

   public String getText() {
      return this.text;
   }

   public boolean getIsAddition() {
      return this.isAddition;
   }
}
