package com.unesco.core.models.shedule;

public class FieldOfKnowledgeDTO {

   private long id;
   private String name;

   public long getId() {
      return id;
   }
   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }

   public FieldOfKnowledgeDTO() {
      this.name = "";
   }
}