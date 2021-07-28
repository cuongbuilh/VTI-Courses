package entity;

final public class SecondaryStudent extends  Student{
   public static int numOfSecondaryStudent = 0;

   public SecondaryStudent() throws OverStudentException{
      numOfSecondaryStudent++;
   }

   @Override
   public void study() {

   }
}
