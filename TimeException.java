import java.util.Scanner;

public class TimeException extends Exception{
	
	String errorMessage;
	
	public TimeException (String errorMessage) {
		
		this.errorMessage = errorMessage;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sn = new Scanner(System.in);
		boolean stop = false;
		
		while (stop == false) {
			try {
			System.out.println("Please enter in number format starting with the HH, a colon, and the minutes: ");
			String time = sn.next();
			String [] timeFormat = time.split(":");
			int hour = Integer.parseInt(timeFormat[0]);
			int minutes = Integer.parseInt(timeFormat[1]);
			
			if(hour < 0 || hour > 24) 
				throw new TimeException("Invalid Hour");
			if(minutes < 0 || minutes > 59)
				throw new TimeException("Invalid minutes");
			if(hour > 12) {
				hour = hour - 12;
				System.out.println("The time is "  + hour + ":" + minutes + " PM");
			}
			else if(hour == 12 && minutes > 0) {
				if(minutes < 10) {
					System.out.println("The time is "  + hour + ":" + "0"+ minutes + " PM");
				}else
				System.out.println("The time is "  + hour + ":" + minutes + " PM");
			}
			else if(hour == 12 && minutes == 0) {
				System.out.println("The time is "  + hour + ":" + "0"+ minutes + " AM");
			}else {
				if(minutes < 10) {
					System.out.println("The time is "  + hour + ":" + "0"+ minutes + " AM");
				}else
				System.out.println("The time is "  + hour + ":" + minutes + " AM");
			}
			
			
		
			
			} catch (NumberFormatException ex){
				System.out.println(ex.getMessage());
			} catch (TimeException ex) {
				System.out.println( ex.getMessage());
			}
			
			System.out.print("\nDo you want to continue? (y or n?)");
			String answer = sn.next();
			answer.toLowerCase();
			if(answer.equals("n") || answer.equals("no"))
				System.out.println("\nProgram terminated");
				stop = true;
			
		}//end while loop

	}//end main method

}
//end class