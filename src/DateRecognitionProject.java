//Programmer: Marissa Gonçalves
//Date: September 22, 2017
//Purpose: This program allows to recognize the day of the week and the specified year, according to its input.

import java.util.Scanner;

public class DateRecognitionProject

{

    	public static void main (String[]args)

	{

                //define a scanner
		Scanner keyboard = new Scanner (System.in);


                //allow the user to enter a date and use trim method to extract the date
		System.out.print("Enter a date: ");
                String date = keyboard.nextLine();
                date = date.trim();



                //allow a comma to be included in the date, or else an error can occur
                int commaIndex = date.indexOf(",");
		if (commaIndex == -1)
		{
			System.out.println ("Error: the date contains no comma.");
			System.exit (1);
		}



                //allow the month and day to be extracted and separated, or else another error can happen
                String monthAndDay = date.substring (0, commaIndex).trim();
                int blankIndex = monthAndDay.indexOf(" ");
                if (blankIndex == -1)
                {
		        System.out.println ("Error: the date contains no space between the month and day.");
			System.exit (1);
	        }



                //allow the month name to have the first letter capitalized, while the other letters are all in lower case.
                String monthName = monthAndDay.substring (0, blankIndex).trim().toLowerCase();
                monthName = Character.toUpperCase(monthName.charAt(0)) + monthName.substring(1);



                //allow the day and year to be extracted sepreately
		String dayString = monthAndDay.substring (blankIndex + 1).trim();
		String yearString = date.substring (commaIndex + 1).trim();



                //convert the year into an integer
                int year = 0;
                try
                {
                    year = Integer.parseInt (yearString);

                }
                catch (NumberFormatException e)
                {
                     System.out.println ("Error: the year " + yearString + " is non-numeric.");
	             System.exit (1);
                }


                //input must be larger than 1582, or else there is an error
                if (year < 1582)
	        {
	             System.out.println ("Error: invalid year " + year);
	             System.out.println ("Info: year value " + year + " must be an integer greater than or equal to 1582.");
	             System.exit(1);
	        }



                 //make sure that the month, sum amd month length variables are mentioned before the switch statement
		int month = 0;
		int sum = 0;
                int monthLength = 0;
                final int JAN = 31;
                final int FEB;
                final int MAR = 31;
                final int APR = 30;
                final int MAY = 31;
                final int JUN = 30;
                final int JUL = 31;
                final int AUG = 31;
                final int SEP = 30;
                final int OCT = 31;
                final int NOV = 30;
                final int DEC = 31;


                //convert the day into a String character, mention the conditions when applying to all leap years
                boolean leapYear = (year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0)));
                FEB = leapYear ? 29 : 28;

                 //convert the day into a String character
                int day = 0;
                try
                {
                    day = Integer.parseInt (dayString);
                }
                catch (NumberFormatException e)
                {
                     System.out.println ("Error: the day " + dayString + " is non-numeric.");
	             System.exit (1);
                }


                //use the switch statement to clarify what month names the user should input, in order to make the program run
                //the month must allow the correct day input, based on the Gregorian and leap years, or else an error occurs
                switch (monthName)
		     {
		       case "January":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 1;
		       sum = 0;
                       monthLength = JAN;
		       break;




		       case "February":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 2;
		       sum = JAN;
                       monthLength = FEB;
		       break;



		       case "March":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 3;
		       sum = JAN + FEB;
                       monthLength = MAR;
		       break;



		       case "April":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 4;
		       sum = JAN + FEB + MAR;
                       monthLength = APR;
		       break;



		       case "May":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 5;
                       sum = JAN + FEB + MAR + APR;
                       monthLength = MAY;
		       break;




		       case "June":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 6;
                       sum = JAN + FEB + MAR + APR + MAY;
                       monthLength = JUN;
		       break;




		       case "July":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 7;
                       sum = JAN + FEB + MAR + APR + MAY + JUN;
                       monthLength = JUL;
		       break;




		       case "August":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 8;
                       sum = JAN + FEB + MAR + APR + MAY + JUN + JUL;
                       monthLength = AUG;
		       break;




		       case "September":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 9;
                       sum = JAN + FEB + MAR + APR + MAY + JUN + JUL + AUG;
                       monthLength = SEP;
		       break;




		       case "October":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 10;
                       sum = JAN + FEB + MAR + APR + MAY + JUN + JUL + AUG + SEP;
                       monthLength = OCT;
		       break;




		       case "November":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 11;
		       sum = JAN + FEB + MAR + APR + MAY + JUN + JUL + AUG + SEP + OCT;
                       monthLength = NOV;
		       break;




		       case "December":
                       //month, month-name days and the sum of preceding days, values should be mentioned for each month name, for Zeller's algorithm to work
		       month = 12;
		       sum = JAN + FEB + MAR + APR + MAY + JUN + JUL + AUG + SEP + OCT + NOV;
                       monthLength = DEC;
		       break;



		       default:
		           System.out.println ("Error: invalid month name " + monthName);
			   System.out.println ("Info: Enter one of the following, case insensitive: January, February");
			   System.out.println ("March, April, May, June, July, August, September, Ocotber, November, December.");
			   System.exit (1);
              }



                        //the month must allow the correct day input, based on the Gregorian and leap years, or else an error occurs
                        if (day < 1 || day > monthLength)
		        {
			    System.out.println ("Error: invalid day number " + day);
			    System.out.println ("Info: day value " + day + " must be an integer from 1 through " + monthLength + " in " + monthName + " " + year + ".");
			    System.exit(1);
		        }



              //input the day and sum values into a variable called dayOfYear, in order to complete Zeller's algorithm
              //use letters as variables and mathematical equations, in order to determine the numerical calculation of varaible z
              int dayOfYear = day + sum;
              int w = (14 - month) / 12;
              int m = month + (12 * w);
              int x = year - w;
              int y = x % 100;
              int c = x / 100;
              int d = day;
              int z = (d + ((26 * m) + 26) / 10 + y + (y / 4) + (c / 4) + (5 * c)) % 7;


              //use a switch statement based on the final value of z, to print the final outputs, including the day of the year and the day name of the week
              switch (z)
              {
              case 0:
                          System.out.println (monthName + " " + day + ", " + year + " is Saturday, day " + dayOfYear + ".");
              break;

              case 1:
			  System.out.println (monthName + " " + day + ", " + year + " is Sunday, day " + dayOfYear + ".");
              break;

              case 2:
			  System.out.println (monthName + " " + day + ", " + year + " is Monday, day " + dayOfYear + ".");
              break;

              case 3:
			  System.out.println (monthName + " " + day + ", " + year + " is Tuesday, day " + dayOfYear + ".");
              break;

              case 4:
			  System.out.println (monthName + " " + day + ", " + year + " is Wednesday, day " + dayOfYear + ".");
              break;

              case 5:
			  System.out.println (monthName + " " + day + ", " + year + " is Thursday, day " + dayOfYear + ".");
              break;

              case 6:
			  System.out.println (monthName + " " + day + ", " + year + " is Friday, day " + dayOfYear + ".");
              break;
	          }


        }
}
