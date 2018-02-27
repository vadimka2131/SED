package com.unesco.core.ViewModel.Journal;

import java.util.ArrayList;
import java.util.List;

public class Journal
{
   private List<Student> students;
   private int[] dates;
   private List<JournalCell> journalCell;

   public Journal(List<Student> Students, int[] Dates)
   {
      students = Students;
      dates = Dates;
      journalCell = new ArrayList<>();

      for (Student student : students)
      {
         for (int date : dates)
         {
            journalCell.add(new JournalCell(student, date));
         }
      }
   }

   List<JournalCell> getAllStudentCells(int date)
   {
      List<JournalCell> result = new ArrayList<>();
      for (JournalCell cell : journalCell)
      {
         if(cell.getDate()==date)
            result.add(cell);
      }
      return result;
   }

   List<JournalCell> getAllDateCells(Student student)
   {
      List<JournalCell> result = new ArrayList<>();
      for (JournalCell cell : journalCell)
      {
         if(cell.getStudent()==student)
            result.add(cell);
      }
      return result;
   }


   public List<Student> getStudents() {
      return students;
   }
   public void setStudents(List<Student> students) {
      this.students = students;
   }

   public int[] getDates() {
      return dates;
   }
   public void setDates(int[] dates) {
      this.dates = dates;
   }

   public List<JournalCell> getJournalCell() {
      return journalCell;
   }
   public void setJournalCell(List<JournalCell> journalCell) {
      this.journalCell = journalCell;
   }

}
