import java.util.*;

public class CRC {
	 static String div(String num1,String num2)
	 {
	  int pointer = num2.length();
	  String result = num1.substring(0, pointer);
	  String remainder = "";
	  for(int i = 0; i < num2.length(); i++)
	  {
	   if(result.charAt(i) == num2.charAt(i))
	    remainder += "0";
	   else
	    remainder += "1";
	  }
	  while(pointer < num1.length())
	  {
		  
	   if(remainder.charAt(0) == '0')
	   {
	    remainder = remainder.substring(1, remainder.length());
	    remainder = remainder + String.valueOf(num1.charAt(pointer));
	    pointer++;
	   }
	   result = remainder;
	   remainder = "";
	   if(result.charAt(0)=='0')
	   {
		   remainder=result;
	   }
	   else
	   {
	   for(int i = 0; i < num2.length(); i++)
	   {
		   if(result.charAt(i) == num2.charAt(i))
			    remainder += "0";
			   else
			    remainder += "1";
	   }
	   }
	  }
	  return remainder.substring(1,remainder.length());
	 }
      public static void main(String agrs[])
      {
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println("Enter Divisor:");
    	  String divisor = sc.nextLine();
    	  System.out.println("Enter Data:");
    	  String data = sc.nextLine();
    	  String code = data;
    	  while(code.length() < (data.length() + divisor.length() - 1))
    	   code = code + "0";
    	  code = data + div(code,divisor);
    	  System.out.println("The CRC Code Word is: " + code);
    	  System.out.println("Please enter the received Code Word: ");
    	  String rec = sc.nextLine();
    	  if(Integer.parseInt(div(rec,divisor)) == 0)
    	   System.out.println("The received code word contains no errors.");
    	  else
    	   System.out.println("The received code word contains errors.");
    	  sc.close();
      }
}