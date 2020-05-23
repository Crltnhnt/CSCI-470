public class Exam2b
{

  public static void main(String[] args)
    {

      // part 1 - test Bdate
      // 3-input cxtr
      System.out.printf("%n");

      Bdate mayDay = new Bdate("05", "01", "20");
      System.out.printf("May Day is            %s%n", mayDay);

      Bdate xmas = new Bdate("12", "25", "20");
      System.out.printf("Xmas was              %s%n", xmas);

      Bdate dueDate = new Bdate("5", "7", "20");
      System.out.printf("Due date is           %s%n", dueDate);

      Bdate futureDate = new Bdate("5", "8", "20");
      System.out.printf("It once was           %s%n", futureDate);

      Bdate oldDate = new Bdate("5", "6", "20");
      System.out.printf("An old date is        %s%n", oldDate);
      System.out.printf("%n");

      // "copy cxtr" (i.e., equivalent of C++ copy cxtr)
      // first prove that oldDate2 gets the copied value
      // then prove that it is a true new object, not just a ptr to the old object

      Bdate oldDate2 = new Bdate(oldDate);
      System.out.printf("oldDate =             %s%n", oldDate);
      System.out.printf("oldDate2 =            %s%n", oldDate);

      oldDate = xmas;
      System.out.printf("oldDate now =         %s%n", oldDate);
      System.out.printf("but oldDate2 still =  %s%n", oldDate2);
      System.out.printf("%n");

      // test member & non-member Boolean fns
      System.out.printf("%b%n", dueDate.isNewYears());
      System.out.printf("%b%n", Bdate.isNewYears(dueDate));

      System.out.printf("%b%n", new Bdate("1", "1", "20").isNewYears());
      System.out.printf("%b%n", Bdate.isNewYears(new Bdate("01", "01", "21")));

      // part 2 - test Cf

      String w = "abcde";
      String x = "defgh";
      String y = "ab" + "cde";
      String z = "abc";
      String v = "axcxe";

      System.out.printf("%n");
      System.out.printf("two completely different strings:  %s%n", Cf.cf(w,x));
      System.out.printf("two related strings:               %s%n", Cf.cf(w,v));
      System.out.printf("two equivalent strings:            %s%n", Cf.cf(w,y));
      System.out.printf("two strings of different length:   |%s|%n", Cf.cf(w,z));
      System.out.printf("%n");
    }

}

