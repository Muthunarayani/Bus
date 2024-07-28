import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
public class BusReservationAndTicketingSystem {


		// TODO Auto-generated method stub
		private static final String CHARACTER_SET = "123456789";
		private static Random rnd = new Random();

		public static String randomString(int length){
		    StringBuilder builder = new StringBuilder();
		    for(int i = 0; i < length; i++){
		        builder.append(CHARACTER_SET.charAt(rnd.nextInt(CHARACTER_SET.length())));
		    }
		    return builder.toString();
		}
		
		public static void main(String args[]) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			String user, password, yn, search, again, choice;
			int to = 0, y = 1, z = 0, end = 0, r = 1;
			int available[] = new int[6];
			int ticketI[][] = new int[100][3];
			String ticketS[][] = new String[100][4];
			double ticketD[][] = new double[100][3];
			Map<String, String[][]> passengerMap=new HashMap<String, String[][]>();
			double pay[] = new double[20];
			double change[] = new double[20];
			
			Map<String,Object> bus1=new HashMap<String, Object>() {{
				put("b_no", "1");
			    put("name", "DAZZLING TOURS ");
			    put("seater_amount", 550.00);
			    put("sleeper_amount", 1110.00);
			}};
			
			Map<String,Object> bus2=new HashMap<String, Object>() {{
				put("b_no", "2");
				put("name", "BLUE WINGS     ");
			    put("seater_amount", 600.00);
			    put("sleeper_amount", 1320.00);
			}};
			
			Map<String,Object> bus3=new HashMap<String, Object>() {{
				put("b_no", "3");
			    put("name", "BUSY BEE WHEELS");
			    put("seater_amount", 650.00);
			    put("sleeper_amount",1320.00);
			}};
			
			Map<String,Object> bus4=new HashMap<String, Object>() {{
				put("b_no", "4");
			    put("name", "DRAGON RIDERS  ");
			    put("seater_amount", 590.00);
			    put("sleeper_amount", 1190.00);
			}};
			
			Map<String,Object> bus5=new HashMap<String, Object>() {{
				put("b_no", "5");
			    put("name", "GOLDEN WAYS    ");
			    put("seater_amount", 560.00);
			    put("sleeper_amount", 1030.00);
			}};
			
			String dest[] = { " ", "DAZZLING TOURS", "BLUE WINGS", "BUSY BEE WHEELS","DRAGON RIDERS", "GOLDEN WAYS" };
			double fare[] = { 0, 550, 1200, 670, 720, 1030 };
			Map<String, Map<String,Object>> busMap=new HashMap<String, Map<String,Object>>();
			busMap.put(bus1.get("b_no").toString(), bus1);
			busMap.put(bus2.get("b_no").toString(), bus2);
			busMap.put(bus3.get("b_no").toString(), bus3);
			busMap.put(bus4.get("b_no").toString(), bus4);
			busMap.put(bus5.get("b_no").toString(), bus5);

			for (int i = 1; i < 4;) {
				System.out.println("****************************");
				System.out.println("**  BUS TICKETING SYSTEM  **");
				System.out.println("****************************");
				System.out.println();
				System.out.println("****************************");
				System.out.println("** Login                  **");
				System.out.println("****************************");
				System.out.print("Enter Username: ");
				user = in.readLine();
				System.out.print("Enter Password: ");
				password = in.readLine();
				System.out.println("****************************");
				System.out.println();
				
				for (int o = 1; o <= 5; o++) {
					available[o] = 20;
				}

				if (user.equals("admin") && password.equals("admin")) {

					for (int x = 1; x == 1;) {
						// the MAIN MENU//
						System.out.println("****************************");
						System.out.println("** Menu                   **");
						System.out.println("****************************");
						System.out.println("* [1] Bus Info             *");
						System.out.println("* [2] Book Ticket          *");
						System.out.println("* [3] Ticket Payment       *");
						System.out.println("* [4] View Ticket          *");
						System.out.println("* [5] Exit                 *");
						System.out.println("****************************");
						System.out.println();
						
						for (x = 1; x == 1;) {
							System.out.print("Enter Menu : ");
							choice = in.readLine();
							System.out.println();

							if (choice.equals("1")) {
								System.out.println("***********************************************");
								System.out.println("** [1] Bus Info **");
								System.out.println("***********************************************");
								
								System.out.println("***********************************************");
								System.out.println("* Bus [Number] Name | Available Seat         **");
								System.out.println("***********************************************");
								if(busMap!=null) {
									for (Entry<String, Map<String, Object>> bus : busMap.entrySet()) {
										System.out.println("* ["+bus.getValue().get("b_no")+"]    "+bus.getValue().get("name")+" | " + available[1] + " *");
									}
								}
								System.out.println("***********************************************");
								System.out.println("Note : ");
								System.out.println("* Passenger above Age 60 will get 20% off on thier Ticket ");
								System.out.println("* Passenger below Age 3 will get 50% off on thier Ticket ");
								System.out.println("***********************************************");
								System.out.println();
								
								x = 0;
							}else if (choice.equals("2")) {
								System.out.println("***********************************************");
								System.out.println("** [2] Book Ticket **");
								System.out.println("***********************************************");
								
								int print = 1;
								System.out.println("********************************************************************************");
								System.out.println("* Bus [Number] Name | Seater Amount | Sleeper Amount | Available Seat  **");
								System.out.println("********************************************************************************");
								if(busMap!=null) {
									for (Entry<String, Map<String, Object>> bus : busMap.entrySet()) {
										System.out.println("* ["+bus.getValue().get("b_no")+"]    "+bus.getValue().get("name")+" | " +bus.getValue().get("seater_amount")+" | " +bus.getValue().get("sleeper_amount")+" | " + available[1] + " *");
									}
								}
								System.out.println("********************************************************************************");
								System.out.println("Note : ");
								System.out.println("* Passenger above Age 60 will get 20% off on thier Ticket ");
								System.out.println("* Passenger below Age 3 will get 50% off on thier Ticket ");
								System.out.println("********************************************************************************");
								System.out.println();
								
								if ((available[1] == 0) && (available[2] == 0) && (available[3] == 0) && (available[4] == 0) && (available[5] == 0)) {
									System.out.println("Sorry, We don't have available seats for all Destination!");
									x = 0;
								} else {
									
									for (x = 1; x == 1;) {
										System.out.print("Enter Bus Number : ");
										to = Integer.parseInt(in.readLine());

										if (to < 1 || to > 5) {
											System.out.println("Invalid Input!");
											x = 1;
										}

										for (int d = 1; d <= 5; d++) {
											if (to == d) {
												if (available[to] == 0) {
													System.out.println("Sorry, We don't have available seat!");
													x = 1;
												}
												x = 0;
											}
										}
									}
									System.out.println();
									
									for (x = 1; x == 1;) {
										System.out.print("Enter Your Name : ");
										ticketS[z][0] = in.readLine();

										x = 0;

										for (int l = 0; l < z; l++) {
											if (ticketS[l][0].equalsIgnoreCase(ticketS[z][0])) {
												System.out.println("Sorry, Passenger's name have already used!");
												x = 1;
											}
										}
									}

									//String dest[] = { " ", "DAZZLING TOURS", "BLUE WINGS", "BUSY BEE WHEELS","DRAGON RIDERS", "GOLDEN WAYS" };
									//double fare[] = { 0, 550, 1200, 670, 720, 1030 };

									// converted integer to string, transfer to storage array//
									Map<String, Object> bus=busMap.get(String.valueOf(to));
									ticketS[z][1] = bus.get("name").toString();//dest[to];

										System.out.print("Sleeper or Seater You Want:");
										ticketS[z][0] = in.readLine();
										if(ticketS[z][0].equalsIgnoreCase("seater")){
											ticketD[z][0] = (double)bus.get("seater_amount");//fare[to];

										}
										if(ticketS[z][0].equalsIgnoreCase("sleeper")){
											ticketD[z][0] = (double)bus.get("sleeper_amount");
										}


									// inputing for Number of Passenger's//
									for (x = 1; x == 1;) {
										System.out.print("No of Tickets You Want : ");
										ticketI[z][0] = Integer.parseInt(in.readLine());

										// subtract the available seat by the the number inputed//
										for (int p = 1; p <= 5; p++) {
											if (to == p) {
												print = 1;
												available[to] = available[to] - ticketI[z][0];

												if (available[to] < 0|| available[to]>20){
													System.out.print("Sorry, We don't have seat available for "+ ticketI[z][0] + " person\n");
													available[to] = available[to] + ticketI[z][0];
													System.out.print("We only have " + available[to] + " seat available\n");
													x = 1;
													print = 0;
												} else {
													x = 0;
												}
											}
										}
									}
									
									ticketS[z][2] = randomString(15);
									ticketI[z][1] = 0;
									ticketI[z][2] = 0;
									
									String[][] passengers=new String[100][3];
									for (int j = 0; j<ticketI[z][0];j++) {
										System.out.println("Enter Passenger "+(j+1)+" Detail");
										System.out.print("|-- Enter Name : ");
										passengers[j][0] =in.readLine();
										System.out.print("|-- Enter Age : ");
										passengers[j][1] =in.readLine();
										int age=Integer.parseInt(passengers[j][1]);
										if(age>=60) {
											ticketI[z][1]=ticketI[z][1]+1;
										}else if(age<=3) {
											ticketI[z][2]=ticketI[z][2]+1;
										}
										System.out.println();
									}
									
									System.out.println();
									passengerMap.put(ticketS[z][2], passengers);
									if (print == 1) {
										System.out.println("***************************************");
										System.out.println("*        Ticket Detail             *");
										System.out.println("***************************************");
										System.out.println("PNR Number: " + ticketS[z][2]);
										System.out.println("Passenger Name: " + ticketS[z][0]);
										System.out.println("Bus Name : " + ticketS[z][1]);
										System.out.println("Bus Amount/Seat : $" + ticketD[z][0]);
										System.out.println("No Of Passenger: " + ticketI[z][0]);
										System.out.println("No Of Passenger with Age > 60: " + ticketI[z][1]);
										System.out.println("No Of Passenger with Age < 3: " + ticketI[z][2]);
										System.out.println("***************************************");
										
										int passengerCount=1;
										for (String[] passenger : passengers) {
											if(passenger[0]!=null) {
												System.out.println("Passenger "+passengerCount+" Detail ");
												System.out.println("|-- Name : "+passenger[0]);
												System.out.println("|-- Age : "+passenger[1]);
												passengerCount++;
											}else {
												break;
											}
										}
										System.out.println("***************************************");

										ticketS[z][3] = "0";
										
										double seniorCitizenDiscount = (ticketD[z][0] - (ticketD[z][0] * 0.2)) * ticketI[z][1];
										double childDiscount = (ticketD[z][0] - (ticketD[z][0] * 0.5)) * ticketI[z][2];
										ticketD[z][2] = ((ticketI[z][0] - ticketI[z][1]-ticketI[z][2]) * ticketD[z][0]) + seniorCitizenDiscount+ childDiscount;
										
										System.out.println("Ticket Amount : $" + ticketD[z][2]);
										if (ticketS[z][3].equals("x")) {
											System.out.println("Pay: $" + pay[z]);
											System.out.println("Change: $" + change[z]);
											System.out.println("Status: PAID");
										} else {
											System.out.println("Status: NOT PAID");
										}
										System.out.println("***************************************");
										x = 0;
									}
									System.out.println();
									z++;
								}
							}

							else if (choice.equals("3")) {

								for (x = 1; x == 1;) {
									System.out.println("***********************************************");
									System.out.println("** [3] Ticket Payment                        **");
									System.out.println("***********************************************");

									System.out.print("Enter PNR Number: ");
									search = in.readLine();
									System.out.println();
									
									int s = 1;
									for (int b = 0; b < z; b++) {
										if (search.equalsIgnoreCase(ticketS[b][2])) {
											System.out.println("***************************************");
											System.out.println("*        Ticket Detail             *");
											System.out.println("***************************************");
											System.out.println("PNR Number: " + ticketS[b][2]);
											System.out.println("Passenger Name: " + ticketS[b][0]);
											System.out.println("Bus Name : " + ticketS[b][1]);
											System.out.println("Bus Amount/Seat : $" + ticketD[b][0]);
											System.out.println("No Of Passenger: " + ticketI[b][0]);
											System.out.println("No Of Passenger with Age > 60: " + ticketI[b][1]);
											System.out.println("No Of Passenger with Age < 3: " + ticketI[b][2]);
											System.out.println("***************************************");
											
											String[][] passengers=passengerMap.get(ticketS[b][2]);
											int passengerCount=1;
											for (String[] passenger : passengers) {
												if(passenger[0]!=null) {
													System.out.println("Passenger "+passengerCount+" Detail ");
													System.out.println("|-- Name : "+passenger[0]);
													System.out.println("|-- Age : "+passenger[1]);
													passengerCount++;
												}else {
													break;
												}
											}
											System.out.println("***************************************");
											s = 0;
											x = 0;

											if (ticketS[b][3].equals("x")) {
												System.out.println("Ticket Already Paid!");
												x = 0;
											} else {
												ticketS[b][3] = "x";

												for (x = 1; x == 1;) {
													System.out.println("\nTicket Amount : $" + ticketD[b][2]);
													System.out.print("Enter Amount To Pay : ");
													pay[b] = Double.parseDouble(in.readLine());
													change[b] = pay[b] - ticketD[b][2];

													if (change[b] < 0) {
														System.out.println("Invalid Input!");
														x = 1;
													} else {
														System.out.println("Change : $" + change[b]);
														System.out.println("");
														x = 0;
													}
												}
											}
											System.out.println("***************************************");
										}
									}
									if (s == 1) {
										System.out.println("PNR Number Not Found!");
										for (int q = 1; q == 1;) {

											System.out.print("Do you wish to continue with this transaction? [Y/N]: ");
											again = in.readLine();

											if (again.equalsIgnoreCase("y")) {
												q = 0;
											} else if (again.equalsIgnoreCase("n")) {
												q = 0;
												x = 0;

											} else {
												System.out.println("\nInvalid input!\n");
											}

										}
									}
								}
								System.out.println();
							}

							else if (choice.equals("4")) {
								
								System.out.println("***********************************************");
								System.out.println("** [4] View Ticket                           **");
								System.out.println("***********************************************");

								for (int sx = 1; sx <= 3;) {
									System.out.print("Enter PNR Number : ");
									search = in.readLine();

									int s = 1;
									for (x = 0; x <= z; x++) {
										if (search.equalsIgnoreCase(ticketS[x][2])) {
											System.out.println("***************************************");
											System.out.println("*        Ticket Detail             *");
											System.out.println("***************************************");
											System.out.println("PNR Number : " + ticketS[x][2]);
											System.out.println("Passenger Name : " + ticketS[x][0]);
											System.out.println("Bus Name : " + ticketS[x][1]);
											System.out.println("Bus Amount/Seat : $" + ticketD[x][0]);
											System.out.println("No Of Passenger : " + ticketI[x][0]);
											System.out.println("No Of Passenger with Age > 60: " + ticketI[x][1]);
											System.out.println("No Of Passenger with Age < 3: " + ticketI[x][2]);
											System.out.println("***************************************");
											String[][] passengers=passengerMap.get(ticketS[x][2]);
											int passengerCount=1;
											for (String[] passenger : passengers) {
												if(passenger[0]!=null) {
													System.out.println("Passenger "+passengerCount+" Detail ");
													System.out.println("|-- Name : "+passenger[0]);
													System.out.println("|-- Age : "+passenger[1]);
													passengerCount++;
												}else {
													break;
												}
											}
											System.out.println("***************************************");
											System.out.println("Ticket Amount : $" + ticketD[x][2]);
											if (ticketS[x][3].equals("x")) {
												System.out.println("Pay: $" + pay[x]);
												System.out.println("Change: $" + change[x]);
												System.out.println("Status: PAID");
											} else {
												System.out.println("Status: NOT PAID");
											}
											System.out.println("***************************************");
											s = 0;
											sx = 4;
										}
									}

									if (s == 1) {
										System.out.println("PNR Number not found!");
										sx++;
									}

								}
							}

							else if (choice.equals("5")) {
								end = 1;
								x = 0;
								System.out.println("Thank You!");
							}

							else {
								System.out.println("Invalid Input!");
								x = 1;
							}
						}

						for (y = 1; y == 1;) {
							if (end == 1) {
								break;
							}
							System.out.print("Do you want to continue: ");
							yn = in.readLine();

							if (yn.equalsIgnoreCase("y")) {
								x = 1;
								y = 0;
							} else if (yn.equalsIgnoreCase("n")) {
								System.out.println("\nThank You!!!");
								break;
							} else {
								System.out.println("Invalid Input!!!");
								y = 1;
							}
						}
					}
					i = 4;
				} else {
					System.out.println("\nInvalid user or password!\n");
					i++;
				}

			}

		}
	

	}


