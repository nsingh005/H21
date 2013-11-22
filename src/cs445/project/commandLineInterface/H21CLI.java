package cs445.project.commandLineInterface;

public class H21CLI {
	public static void main(String args[]){
		if(args.length < 1) {
			System.out.println("Insufficient arguments!!");
			return;
		}
		
		String command = args[0];
		
		if(command.compareTo("admin") == 0) {
			HostelAdmin.adminApp(args);
		}
		else if(command.compareTo("search") == 0){
			SearchBeds.searchApp(args);
		}
		else if(command.compareTo("book") == 0) {
			BookingApp.bookApp(args);
		}
		else if(command.compareTo("user") == 0) {
			UserApp.userApp(args);
		}
		else {
			System.out.println("Invalid argument passed!!");
		}		
	}
	
	void printHelp() {
		System.out.println("h21 admin/search/book/user [--options]");
		System.out.println("  To display help for a particular command "
				+ " Enter \"h21 <command_name>\"");
	}

}
