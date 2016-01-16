import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pro3_prasadd5 {
	public static BufferedReader input = new BufferedReader(
			new InputStreamReader(System.in));

	public static int numStudentsToAdd = 0;
	public static int numStudentsAdded = 0;
	public static int numSchoolsToAdd = 0;
	public static int numSchoolsAdded = 0;
	public static boolean didMatchingHappen = false;

	public static double totalSchoolRegret = 0;
	public static double averageSchoolRegret = 0;
	public static double averageRegretPerPerson = 0;
	public static double averageStudentRegret = 0;

	public static boolean checkUserInput(String s) {
		if (s.equals("S") || s.equals("s")) {
			return true;
		}
		if (s.equals("H") || s.equals("h")) {
			return true;
		}
		if (s.equals("A") || s.equals("a")) {
			return true;
		}
		if (s.equals("E") || s.equals("e")) {
			return true;
		}
		if (s.equals("P") || s.equals("p")) {
			return true;
		}
		if (s.equals("M") || s.equals("m")) {
			return true;
		}
		if (s.equals("D") || s.equals("d")) {
			return true;
		}
		if (s.equals("R") || s.equals("r")) {
			return true;
		}
		if (s.equals("Q") || s.equals("q")) {
			return true;
		} else
			return false;
	}

	public static String getUserInput(String prompt) {
		String userinput = "";
		boolean valid;
		do {
			valid = true;
			System.out.print(prompt);
			try {

				userinput = input.readLine();
				if (checkUserInput(userinput)) {

					return userinput;

				} else

					System.out.println("");
				System.out.println("ERROR: Invalid menu choice!");
				System.out.println("");
				displayMenu(); // Display the menu again
				valid = false;
			} catch (NumberFormatException e) {

				System.out.println("");
				System.out.println("ERROR: Invalid menu choice!");
				System.out.println("");
				displayMenu();
				valid = false;

			} catch (IOException e) {

				System.out.println("");
				System.out.println("ERROR: Invalid menu choice!");
				System.out.println("");
				displayMenu();
				valid = false;

			}
		} while (!valid);

		return userinput;
	}

	public static void displayMenu() {

		System.out.println("JAVA STABLE MARRIAGE PROBLEM v1");
		System.out.println("");
		System.out.println("S - Enter students");
		System.out.println("H - Enter high schools");
		System.out.println("A - Assign rankings");
		System.out.println("E - Edit students and schools");
		System.out.println("P - Print students and schools");
		System.out.println("M - Match students and schools");
		System.out.println("D - Display matches and statistics");
		System.out.println("R - Reset database");
		System.out.println("Q - Quit");
		System.out.println("");

	} // Display the menu

	public static boolean checkEditInput(String s) {
		if (s.equalsIgnoreCase("H")) {
			return true;
		}
		if (s.equalsIgnoreCase("S")) {
			return true;
		}
		if (s.equalsIgnoreCase("Q")) {
			return true;
		} else
			return false;
	}

	public static String getEditInput(String prompt) {
		String userinput = "";
		boolean valid;

		do {
			valid = true;
			System.out.print(prompt);
			try {

				userinput = input.readLine();
				if (checkEditInput(userinput)) {

					return userinput;

				} else {
					valid = false;
					System.out.println("");

					System.out.println("ERROR: Invalid menu choice!");

					displayEditMenu(); // Display the menu again

				}
			} catch (NumberFormatException e) {

				System.out.println("");
				System.out.println("ERROR: Invalid menu choice!");
				System.out.println("");

				displayEditMenu();
				valid = false;

			} catch (IOException e) {

				System.out.println("");
				System.out.println("ERROR: Invalid menu choice!");
				// System.out.println("");
				displayEditMenu();
				valid = false;
			}
		} while (!valid);

		return userinput;
	}

	public static void clearStudentRankings(Student[] S) {
		for (int i = 0; i < numStudentsAdded; i++) {
			for (int j = 0; j < numSchoolsAdded; j++)
				S[i].setRanking(j, -1);
		}
	}

	public static int getStudents(Student[] S) {
		// Populate array.Pass it to other functions in their parameters
		// Check size of the array, when we print student x, x = size and
		// increment from there
		// ClearRankings(); Clear the rankings and assignments every time this
		// is called

		// Hold the number of students already entered
		// clearStudentRankings(S);

		int i; // Index counter to loop through student array

		String name = "";
		double GPA = 0;
		int ES = 0;

		System.out.println("");
		numStudentsToAdd = getInteger("Number of students to add: ", 0,
				Integer.MAX_VALUE);

		// For loop, index count starts at #of people already in array so as to
		// not write over existing elements
		// Index goes from length (element + 1 ) all the way up to how many
		// students are to be added + how many are there already

		for (i = numStudentsAdded; i < (numStudentsToAdd + numStudentsAdded); i++) {

			System.out.println("");
			System.out.println("Student " + (i + 1) + ":");
			System.out.print("Name: ");
			try {
				name = input.readLine();
			} catch (NumberFormatException e) {

				System.exit(0);
			} catch (IOException e) {
				System.exit(0);
			}
			// System.out.println("Current index is " + i );
			GPA = getDouble("GPA: ", 0.00, 4.00);

			ES = getInteger("Extracurricular score: ", 0, 5);

			S[i] = new Student(name, GPA, ES, 0);

		}

		numStudentsAdded += numStudentsToAdd;
		return (numStudentsAdded);
	}

	// Declare array of student objects in main function and pass it in
	// Get student information from user and return the number of students.
	// Call this when S is pressed.
	// Prompt user for number of students to add (keep a counter of how many
	// student objects are already in the array
	// With the number we return, we'll start the count from there if more
	// students are added

	public static int getSchools(School[] H) {

		int i = 0;

		String name = "";
		double alpha = 0.00;
		int nStudents = 0;

		// clearSchoolsRankings(H);
		System.out.println("");
		numSchoolsToAdd = getInteger("Number of schools to add: ", 0,
				Integer.MAX_VALUE);

		// nStudents = numSchoolsAdded + numSchoolsToAdd;

		for (i = numSchoolsAdded; i < (numSchoolsToAdd + numSchoolsAdded); i++) {

			System.out.println("");
			System.out.println("School " + (i + 1) + ":");
			System.out.print("Name: ");
			try {
				name = input.readLine();
			} catch (NumberFormatException e) {

				System.exit(0);
			} catch (IOException e) {
				System.exit(0);
			}
			// System.out.println("Current index is " + i );
			alpha = getDouble("GPA weight: ", 0.00, 1.00);

			H[i] = new School(name, alpha, numStudentsAdded);

		}

		numSchoolsAdded += numSchoolsToAdd;
		return (numSchoolsAdded);

	}

	public static double calcStudentScore(double alpha, double GPA, int ES) {
		double score = ((alpha * (GPA)) + ((1 - alpha) * ES));

		return score;
	}

	public static boolean isUniqueRank(Student[] S, int rank, int nStudents,
			int nSchools, int currentStudentsIndex) {

		// System.out.println("Error in isAlreadyEntered1: schoolIndex is " +
		// schoolIndex + " while S[i].getSchool is " + S[i].getSchool());
		for (int j = 0; j < nSchools; j++)

			if ((S[currentStudentsIndex].getRanking(j)) == (rank)) {
				// System.out.println("");
				// System.out.println("S[i].getSchool is " + S[i].getSchool());
				// System.out.println("Error in isAlreadyEntered2: schoolIndex is "
				// + schoolIndex + " while S[i] is " + i);
				// System.out.println("Error! School index " + (schoolIndex) +
				// " is already entered.");
				System.out.println("ERROR: Rank " + rank + " already used!");
				return false;

			}

		return true;

	}

	public static boolean assignRankings(Student[] S, School[] H,
			int nStudents, int nSchools) {
		// Get each student�s school rankings and calculate each school�s
		// rankings of students, and return whether
		// or not ranking happened
		// Even if we got the rank before, we get the rank again.

		// Use nSchools to assign ranking size for Student class in the
		// following for loop
		boolean isAlreadyEntered = true;
		boolean valid = true;
		if (!didMatchingHappen) {
			totalSchoolRegret = 0;
			averageSchoolRegret = 0;
			averageRegretPerPerson = 0;
			averageStudentRegret = 0;

			// Let's clear regret for each student
			for (int i = 0; i < numStudentsAdded; i++) {
				S[i].setRegret(0);
			}
		}

		if (nStudents <= 0) {
			System.out.println("");
			System.out.println("ERROR: No students are loaded!");
			System.out.println("");

			return false;
		}
		if (nSchools <= 0) {
			System.out.println("");
			System.out.println("ERROR: No schools are loaded!");
			System.out.println("");

			return false;
		}

		for (int i = 0; i < nStudents; i++) {
			System.out.println("");
			System.out.println("Student " + S[i].getName() + "'s rankings:");
			S[i].setNSchools(nSchools);

			for (int j = 0; j < nSchools; j++) {

				do {
					valid = true;
					int rating = getInteger(
							("School " + H[j].getName() + ": "), 1, nSchools);
					isAlreadyEntered = isUniqueRank(S, rating, nStudents,
							nSchools, i);

					if (!isAlreadyEntered) {
						valid = false;
					}

					else {
						S[i].setRanking(j, rating);
						valid = true;

					}
					if (didMatchingHappen) {

						// System.out.println("Pulling out " + i +
						// " and the rankung returned is " + j);

						int currentSchoolRanking = S[i].getRanking(j);
						// System.out.println("The currentSchool rating is " +
						// currentSchoolRanking);

						int studentRegret = currentSchoolRanking - 1;
						// System.out.println("The student " + S[i].getName() +
						// " 's regret is "+ S[i].getRegret());
						S[i].setRegret(studentRegret);

					}

				} while (!valid);

			}

		}

		// Schools rank students now.
		for (int schoolsIndex = 0; schoolsIndex < numSchoolsAdded; schoolsIndex++) {

			double[] scoreArray = new double[nStudents];

			for (int i = 0; i < nStudents; i++) {
				// Populate unsorted score of arrays (arr1 in our diagram)
				scoreArray[i] = calcStudentScore(H[schoolsIndex].getAlpha(),
						S[i].getGPA(), S[i].getES());
			}
			Arrays.sort(scoreArray); // now that the array is sorted, let's loop
										// through the students again
			// And compare with the sorted array
			// loop thru each student again

			for (int j = 0; j < numStudentsAdded; j++) { // Loop through scores
															// array, compare w
															// each student
															// score
				// by looping through each student and calculating their score
				// again
				for (int studentIndex = 0; studentIndex < numStudentsAdded; studentIndex++) { // Loop
																								// thru
																								// sorted
																								// array
					// Find first element's value/score stored, search and find
					// out which student it is.
					// Store the student's index in student objects and assign
					// it a rank.
					if (scoreArray[j] == calcStudentScore(
							H[schoolsIndex].getAlpha(),
							S[studentIndex].getGPA(), S[studentIndex].getES())) {

						// System.out.println("The school index is" +
						// schoolsIndex +
						// " and student index printed right now is " +
						// studentIndex + " and the rank is: " + (nStudents-j));

						H[schoolsIndex].setRanking((studentIndex),
								(nStudents - j));

						// THIS WORKS!!!
						// System.out.println( H[schoolsIndex].getName() +
						// "'s rank for student " + studentIndex + " is " +
						// (nStudents-j));

						// int studentRegret =
						// S[studentIndex].getRanking(schoolsIndex);
						// updateStudentRegret(S,studentIndex, studentRegret);

						// int schoolRegret =
						// H[schoolsIndex].getRanking(studentIndex);
						// updateSchoolRegret(H, schoolsIndex, schoolRegret);

					}
					if (didMatchingHappen) {
						// updateSchoolRegret (H, schoolsIndex, schoolRegret);

						int currentStudentRanking = H[schoolsIndex]
								.getRanking(studentIndex);
						int schoolRegret = currentStudentRanking - 1;

						H[schoolsIndex].setRegret(schoolRegret);
						// System.out.println("School1 " +
						// H[schoolsIndex].getName() + " 's regret is" +
						// schoolRegret);

					}

				}
			}

		}

		System.out.println("");
		return true;

	}

	public static void displayEditMenu() {

		System.out.println("");
		System.out.println("Edit data");
		System.out.println("---------");
		System.out.println("S - Edit students");
		System.out.println("H - Edit high schools");
		System.out.println("Q - Quit");
		System.out.println("");

	}

	public static void editData(Student[] S, School[] H, int nStudents,
			int nSchools, boolean rankingsSet) {
		String optionChosen = "";
		boolean valid = true;

		do {

			displayEditMenu();
			optionChosen = getEditInput("Enter choice: ");
			valid = true;

			if (checkEditInput(optionChosen)) {

				if (optionChosen.equalsIgnoreCase("Q")) {
					System.out.println("");
					System.out.println("");
					// System.out.println("");
					return;
				}

				if (optionChosen.equalsIgnoreCase("S")) {

					if (numStudentsAdded <= 0) {
						System.out.println("");
						System.out.println("ERROR: No students are loaded!");

						// displayEditMenu();

						// optionChosen = getEditInput("Enter choice: ");
						valid = false;
					}

					else {

						editStudents(S, H, nStudents, nSchools, rankingsSet);
						// System.out.println("Hello 5");
						displayEditMenu();
						// valid = true;
						// System.out.println("");
						optionChosen = getEditInput("Enter choice: ");
						if (checkEditInput(optionChosen)) {
							valid = true;
						}

						if (optionChosen.equalsIgnoreCase("Q")) {
							System.out.println("");
							System.out.println("");
							// System.out.println("");
							return;
						}

					}

				}
				if (optionChosen.equalsIgnoreCase("H")) {

					// System.out.println("N schools is " + nSchools);
					if (numSchoolsAdded <= 0) {

						System.out.println("");
						System.out.println("ERROR: No schools are loaded!");
						// displayEditMenu();
						valid = false;
					}

					else {

						editSchools(S, H, nSchools, rankingsSet);
						// System.out.println("Hello 5");
						displayEditMenu();
						// valid = true;
						// System.out.println("");
						optionChosen = getEditInput("Enter choice: ");
						if (checkEditInput(optionChosen)) {
							valid = true;
						}

						if (optionChosen.equalsIgnoreCase("Q")) {
							System.out.println("");
							System.out.println("");
							// System.out.println("");
							return;
						}

					}

					// valid = true;
				}

			}

		} while (!valid);
	}

	// Sub-area menu to edit students and schools

	public static void editStudents(Student[] S, School[] H, int nStudents,
			int nSchools, boolean rankingsSet) {
		String name = "";
		String editRankingsOption = "";
		boolean valid = false;

		do {
			System.out.println("");

			System.out
					.println(" #  Name                            GPA  ES  Assigned school            Preferred school order");
			System.out
					.println("----------------------------------------------------------------------------------------------");

			for (int i = 0; i < nStudents; i++) {
				System.out.print(" " + (i + 1) + ". ");
				S[i].print(H, rankingsSet);
				// [i].printRankings(H);
			}
			System.out
					.println("----------------------------------------------------------------------------------------------");

			int studentIndToEdit = getInteger("Enter student (0 to quit): ", 0,
					nStudents);
			if (studentIndToEdit == 0) {

				return;
			}

			System.out.println("");
			System.out.print("Name: ");
			try {
				name = input.readLine();
			} catch (NumberFormatException e) {

				System.exit(0);
			} catch (IOException e) {
				System.exit(0);
			}

			S[studentIndToEdit - 1].setName(name);
			S[studentIndToEdit - 1].setGPA(getDouble("GPA: ", 0.00, 4.00));
			S[studentIndToEdit - 1].setES(getInteger("Extracurricular score: ",
					0, 5));

			if (rankingsSet) {

				do {
					System.out.print("Edit rankings (y/n): ");
					valid = true;
					try {
						editRankingsOption = input.readLine();
					} catch (IOException e) {
						System.out.println("ERROR: Choice must be 'y' or 'n'!");
						valid = false;
					} catch (NumberFormatException e) {
						System.out.println("ERROR: Choice must be 'y' or 'n'!");
						valid = false;
					}
					if (editRankingsOption.equalsIgnoreCase("y")) {

						System.out.println("");
						System.out.println("Student "
								+ S[studentIndToEdit - 1].getName()
								+ "'s rankings:");
						S[studentIndToEdit - 1].setNSchools(nSchools);

						for (int j = 0; j < nSchools; j++) {
							int rating = getInteger(
									("School " + H[j].getName() + ": "), 1,
									nSchools);

							S[studentIndToEdit - 1].setRanking(j, rating);

							int currentSchoolRanking = S[studentIndToEdit - 1]
									.getRanking(j);
							int studentRegret = currentSchoolRanking - 1;
							// System.out.println("The student " +
							// S[studentIndToEdit].getName() + " 's regret is "+
							// S[studentIndToEdit].getRegret());

							if (didMatchingHappen) {

								S[studentIndToEdit - 1]
										.setRegret(studentRegret);

							}

							// updateStudentRegret(S, )
							// int matchedSchoolIndex =
							// S[studentIndToEdit-1].getSchool();
							// int regret =
							// S[studentIndToEdit-1].getRanking(matchedSchoolIndex)-1;
							// System.out.println("The student's regret for this choice is : "
							// + regret);

							// S[studentIndToEdit-1].setRegret(r);

						}

					}
					if (editRankingsOption.equalsIgnoreCase("N")) {
						valid = true;
					}

				} while (!valid);

			}

		} while (true);

	}

	// Sub-area to edit students. The edited student�s regret is updated if
	// needed. Any existing school
	// rankings and regrets are re-calculated after editing a student.

	public static void editSchools(Student[] S, School[] H, int nSchools,
			boolean rankingsSet) {
		String name = "";
		String editRankingsOption = "";
		boolean valid = false;

		if (nSchools <= 0) {

			System.out.println("ERROR: No schools are loaded!");
			System.out.println("");
			return;
		}

		do {
			System.out.println("");
			System.out
					.println(" #  Name                          Weight  Assigned student           Preferred student order");
			System.out
					.println("--------------------------------------------------------------------------------------------");

			for (int i = 0; i < nSchools; i++) {
				System.out.print(" " + (i + 1) + ". ");
				H[i].print(S, rankingsSet);
				System.out.println("");
				// [i].printRankings(H);
			}
			System.out
					.println("--------------------------------------------------------------------------------------------");

			int schoolIndToEdit = getInteger("Enter school (0 to quit): ", 0,
					nSchools);
			if (schoolIndToEdit == 0) {
				return;
			}
			System.out.println("");

			System.out.print("Name: ");
			try {
				name = input.readLine();
			} catch (NumberFormatException e) {

				System.exit(0);
			} catch (IOException e) {
				System.exit(0);
			}
			// changing this array right hur
			H[schoolIndToEdit - 1].setName(name); // So far works
			H[schoolIndToEdit - 1].setAlpha(getDouble("GPA weight: ", 0.00,
					1.00));

			double[] scoreArray = new double[numStudentsAdded];

			for (int i = 0; i < numStudentsAdded; i++) {
				// Populate unsorted score of arrays (arr1 in our diagram)
				scoreArray[i] = calcStudentScore(
						H[schoolIndToEdit - 1].getAlpha(), S[i].getGPA(),
						S[i].getES());
			}
			Arrays.sort(scoreArray); // now that the array is sorted, let's loop
										// through the students again
			// And compare with the sorted array
			// loop thru each student again

			for (int j = 0; j < numStudentsAdded; j++) { // Loop through scores
															// array, compare w
															// each student
															// score
				// by looping through each student and calculating their score
				// again
				for (int studentIndex = 0; studentIndex < numStudentsAdded; studentIndex++) { // Loop
																								// thru
																								// sorted
																								// array
					// Find first element's value/score stored, search and find
					// out which student it is.
					// Store the student's index in student objects and assign
					// it a rank.
					if (scoreArray[j] == calcStudentScore(
							H[schoolIndToEdit - 1].getAlpha(),
							S[studentIndex].getGPA(), S[studentIndex].getES())) {

						// System.out.println("The school index is" +
						// schoolsIndex +
						// " and student index printed right now is " +
						// studentIndex + " and the rank is: " + (nStudents-j));

						H[schoolIndToEdit - 1].setRanking((studentIndex),
								(numStudentsAdded - j));
						int currentStudentRanking = H[schoolIndToEdit - 1]
								.getRanking(studentIndex);
						int schoolRegret = currentStudentRanking - 1;

						if (didMatchingHappen) {
							H[schoolIndToEdit - 1].setRegret(schoolRegret);
							// updateSchoolRegret (H, schoolIndToEdit-1,
							// schoolRegret);
						}
						// System.out.println("School1 " +
						// H[schoolIndToEdit-1].getName() + " 's regret is" +
						// schoolRegret);

						// THIS WORKS!!!
						// System.out.println( H[schoolsIndex].getName() +
						// "'s rank for student " + studentIndex + " is " +
						// (nStudents-j));

						// int studentRegret =
						// S[studentIndex].getRanking(schoolsIndex);
						// updateStudentRegret(S,studentIndex, studentRegret);

						// int schoolRegret =
						// H[schoolsIndex].getRanking(studentIndex);
						// updateSchoolRegret(H, schoolsIndex, schoolRegret);

					}

				}
			}

			/*
			 * if(rankingsSet){
			 * 
			 * do{ System.out.print("Edit rankings (y/n): "); valid = true; try{
			 * editRankingsOption = input.readLine(); } catch(IOException e){
			 * System.out.println("ERROR: Choice must be 'y' or 'n'!"); valid =
			 * false; } catch(NumberFormatException e){
			 * System.out.println("ERROR: Choice must be 'y' or 'n'!"); valid =
			 * false; } if (editRankingsOption.equalsIgnoreCase("y")){
			 * 
			 * System.out.println(""); System.out.println("Student " +
			 * H[schoolIndToEdit-1].getName() + "'s rankings:"); //
			 * H[schoolIndToEdit-1].setNSchools(nSchools);
			 * 
			 * for(int j = 0; j < nSchools ; j ++ ){ int rating =
			 * getInteger(("School " + H[j].getName() + ": "),1, nSchools);
			 * 
			 * H[schoolIndToEdit-1].setRanking(j, rating); }
			 * 
			 * 
			 * } if(editRankingsOption.equalsIgnoreCase("N")){ valid = true; }
			 * 
			 * }while(!valid);
			 * 
			 * 
			 * 
			 * 
			 * }
			 */

		} while (true);

	}

	// Sub-area to edit schools. Any existing rankings and regret for the edited
	// school are updated.

	public static void printStudents(Student[] S, School[] H, int nStudents,
			boolean rankingsSet) {

		String name = "";
		String editRankingsOption = "";
		boolean valid = false;

		if (numStudentsAdded <= 0) {
			System.out.println("");
			System.out.println("ERROR: No students are loaded!");
			System.out.println("");
			return;

		}

		System.out.println("");
		System.out.println("STUDENTS:");
		System.out.println("");

		System.out
				.println(" #  Name                            GPA  ES  Assigned school            Preferred school order");
		System.out
				.println("----------------------------------------------------------------------------------------------");

		for (int i = 0; i < nStudents; i++) {
			System.out.print(" " + (i + 1) + ". ");
			S[i].print(H, rankingsSet);
			// [i].printRankings(H);
		}

		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out.println("");

	}

	// Print students to the screen, including matched school (if one exists).

	public static void printSchools(Student[] S, School[] H, int nSchools,
			boolean rankingsSet) {

		String name = "";
		String editRankingsOption = "";
		boolean valid = false;

		if (nSchools <= 0) {

			System.out.println("ERROR: No schools are loaded!");
			System.out.println("");
			return;

		}

		System.out.println("SCHOOLS:");

		System.out.println("");
		System.out
				.println(" #  Name                          Weight  Assigned student           Preferred student order");
		System.out
				.println("--------------------------------------------------------------------------------------------");
		for (int i = 0; i < nSchools; i++) {

			System.out.print(" " + (i + 1) + ". ");
			H[i].print(S, rankingsSet);
			System.out.println("");
			// [i].printRankings(H);
		}
		System.out
				.println("--------------------------------------------------------------------------------------------");
		System.out.println("");

	}

	// Print schools to the screen, including matched student (if one exists).

	public static void clearCurrentMatched(Student[] S, School[] H,
			int nStudents, int nSchools) {
		for (int i = 0; i < nSchools; i++) {

			H[i].setStudent(-10);

		}
		for (int j = 0; j < nSchools; j++) {
			S[j].setSchool(-10);
		}

	}

	public static void clearMatches(Student[] S, School[] H, int nStudents,
			int nSchools) {

		for (int i = 0; i < nStudents; i++) {
			S[i].setSchool(-1);
		}
		for (int j = 0; j < nSchools; j++) {
			H[j].setStudent(-1);
		}

	}

	public static boolean isAlreadyEntered(Student[] S, int schoolIndex,
			int nStudents) {
		for (int i = 0; i < nStudents; i++) {
			// System.out.println("Error in isAlreadyEntered1: schoolIndex is "
			// + schoolIndex + " while S[i].getSchool is " + S[i].getSchool());

			if ((S[i].getSchool()) == (schoolIndex)) {
				// System.out.println("");
				// System.out.println("S[i].getSchool is " + S[i].getSchool());
				// System.out.println("Error in isAlreadyEntered2: schoolIndex is "
				// + schoolIndex + " while S[i] is " + i);
				// System.out.println("Error! School index " + (schoolIndex) +
				// " is already entered.");
				return false;

			}

		}

		return true;

	}

	// public static void updateStudentRegret(Student[] S, int i, int regret){
	// Index of student who's regret we want to update.
	// S[i].setRegret(regret);
	// }

	// public static void updateSchoolRegret(School [] H,int schoolIndex, int
	// schoolRegret){
	// H[schoolIndex].setRegret(schoolRegret);
	// }

	public static boolean match(Student[] S, School[] H, int nStudents,
			int nSchools, boolean rankingsSet) {
		// Set it to at least 25, bc there will not be more than 25
		boolean isAlreadyEntered = true;
		boolean valid = false;
		int schoolIndex = -1;

		// clearCurrentMatched(S,H, nStudents, nSchools); //IT WORKED !!!
		if (numStudentsAdded <= 0) {
			System.out.println("");
			System.out.println("ERROR: No students are loaded!");
			System.out.println("");
			return false;
		}
		if (nSchools <= 0) {
			System.out.println("");
			System.out.println("ERROR: No schools are loaded!");
			System.out.println("");
			return false;
		}

		if (nStudents != nSchools) {
			System.out.println("");
			System.out
					.println("ERROR: The number of students and schools must be equal!");
			System.out.println("");
			return false;
		}

		if (!rankingsSet) {
			System.out.println("");
			System.out.println("");

			System.out
					.println("ERROR: Student and school rankings must be set before matching!");
			System.out.println("");
			return false;
		}

		System.out.println("");

		for (int i = 0; i < nStudents; i++) {

			do {
				valid = true;

				schoolIndex = getInteger(("Enter school index for student "
						+ (i + 1) + " (" + S[i].getName() + "): "), 1,
						nStudents);
				isAlreadyEntered = isAlreadyEntered(S, schoolIndex, nStudents);

				// System.out.println("The value of isAlreadyEntered is " +
				// isAlreadyEntered);

				if (!isAlreadyEntered) {
					// System.out.println("This silly statement should not execute");
					valid = false;
				}
				// System.out.println("The entered school index happens to be "
				// + schoolIndex);

				if (isAlreadyEntered) {

					valid = true;
					H[schoolIndex - 1].setStudent(i); // Assign the school the
														// student's index
														// address
					S[i].setSchool(schoolIndex); // Assign the student the
													// school's index address
													// now

					// Set regret now
					int currentSchoolRanking = S[i].getRanking(schoolIndex - 1);

					int studentRegret = currentSchoolRanking - 1;

					S[i].setRegret(studentRegret);

					// System.out.println("Student1 " + S[i].getName() +
					// " 's regret is " + S[i].getRegret());

					// Give the student object the index of the school it was
					// assigned
					// System.out.println("School " + (schoolIndex -1) +
					// " 's index of assigned student is" +
					// H[schoolIndex-1].getStudent());
					// System.out.println("Student" + i + " 's index of
					// assigned high school contains the value " +
					// S[i].getSchool());

					// Now we update the school's regret
					int currentStudentRanking = H[schoolIndex - 1]
							.getRanking(i);
					int schoolRegret = currentStudentRanking - 1;
					H[schoolIndex - 1].setRegret(schoolRegret);

					// System.out.println("School2 " +
					// H[schoolIndex-1].getName() + " 's regret is " +
					// H[schoolIndex-1].getRegret());

				}

				// int [] arrayofIndexesAlreadyPut = new int [i]; //size is the
				// same as students
				// arrayofIndexesAlreadyPut[i] = ( schoolIndex -1 ); //Store
				// index that has already been chosen by students

			} while (!valid);

		}
		for (int i = 0; i < nStudents; i++) { // Set matching true variable in
												// every student object
			S[i].setMatchingHappened(true);
		}

		for (int i = 0; i < nSchools; i++) {
			H[i].setMatchingHappened(true);
		}

		System.out.println("");
		return true;

	}

	// Match students and schools, and return whether or not matching happened.
	//
	public static void displayMatches(Student[] S, School[] H, int nStudents,
			int nSchools) {

		double totalStudentRegret = 0;
		totalSchoolRegret = 0;

		boolean isStable = true;

		// If no matches exist, return
		if (!didMatchingHappen) {
			System.out.println("");
			System.out.println("ERROR: No matches exist!");
			System.out.println("");
			return;
		}

		if (nStudents <= 0) {
			System.out.println("");
			System.out.println("ERROR: No students are loaded!");
			System.out.println("");
			return;
		}
		if (nSchools <= 0) {
			System.out.println("");
			System.out.println("ERROR: No schools are loaded!");
			System.out.println("");
			return;
		}

		for (int i = 0; i < numStudentsAdded; i++) {

			totalStudentRegret += S[i].getRegret();
			// System.out.println("The total student regret was " +
			// totalStudentRegret);

			averageStudentRegret = (totalStudentRegret / numStudentsAdded);
		}
		// System.out.println("Total student regret is " + totalStudentRegret);

		for (int HS = 0; HS < numSchoolsAdded; HS++) {

			totalSchoolRegret += H[HS].getRegret();
			// System.out.println("The total School regret was "+
			// totalSchoolRegret);

			averageSchoolRegret = totalSchoolRegret / numStudentsAdded;

		}
		// System.out.println("Total school regret is " + totalSchoolRegret);

		averageRegretPerPerson = (totalStudentRegret + totalSchoolRegret)
				/ (numSchoolsAdded + numStudentsAdded);

		System.out.println("");
		System.out.println("Matches:");
		System.out.println("--------");

		for (int nameIndex = 0; nameIndex < numSchoolsAdded; nameIndex++) {

			System.out.println(H[nameIndex].getName() + ": "
					+ S[(H[nameIndex].getStudent())].getName());

		}
		System.out.println("");

		// Check stability. YOLO

		for (int school = 0; school < nSchools; school++) {
			for (int x = 0; x < nStudents; x++) {

				int matchedSchoolIndex = H[school].getStudent();

				int matchedRanking = H[school].getRanking(matchedSchoolIndex);
				if ((matchedRanking) > H[school].getRanking(x)) {

					int higherRankStudentIndex = x;

					int higherRankStudentsMatchIndex = S[higherRankStudentIndex]
							.getSchool();

					if (S[higherRankStudentIndex]
							.getRanking(higherRankStudentsMatchIndex - 1) > S[higherRankStudentIndex]
							.getRanking(school)) {
						isStable = false;
					}

					else
						isStable = true;

				}

			}
		}

		if (!isStable) {
			System.out.println("Stable matching? No");
		}
		if (isStable) {
			System.out.println("Stable matching? Yes");
		}

		System.out.printf("Average student regret: %.2f\n",
				(averageStudentRegret));
		System.out.printf("Average school regret: %.2f\n",
				(averageSchoolRegret));
		System.out.printf("Average total regret: %.2f\n",
				(averageRegretPerPerson));
		System.out.println("");

	}

	// Display matches and statistics.

	public static boolean matchingCanProceed(int nStudents, int nSchools,
			boolean rankingsSet) {
		if (nStudents <= 0) {
			return false;
		}
		if (nSchools <= 0) {
			return false;
		}
		if (nStudents != nSchools) {
			return false;
		}
		if (!rankingsSet) {
			return false;
		}

		return true;

	}

	// Check that the conditions to proceed with matching are satisfied.

	public static void main(String[] args) {
		String OptionChosen = "";
		int numSchools = -1; // Holds number of High Schools entered
		int numStudents = -1; // Holds number of students entered
		boolean didRankingHappen = false;
		School[] schoolArray = new School[25]; // Initialize array of School
												// objects
		Student[] studentArray = new Student[25]; // Initialize array of Student
													// objects
		boolean Quit = false;

		do {
			displayMenu();

			OptionChosen = getUserInput("Enter choice: ");

			if (checkUserInput(OptionChosen)) {

				if (OptionChosen.equalsIgnoreCase("Q")) {

					System.out.println("");
					System.out.println("Sayonara!");
					System.exit(0);

				}

				if (OptionChosen.equalsIgnoreCase("S")) {

					didRankingHappen = false;

					numStudents = getStudents(studentArray);
					System.out.println("");

				}

				if (OptionChosen.equalsIgnoreCase("H")) {
					didRankingHappen = false;

					numSchools = getSchools(schoolArray);
					System.out.println("");

				}
				if (OptionChosen.equalsIgnoreCase("A")) {

					/*
					 * if (numSchools <= 0){
					 * 
					 * System.out.println("");
					 * System.out.println("ERROR: No schools are loaded!");
					 * System.out.println("");
					 * 
					 * 
					 * } if(numStudents <=0){ System.out.println("");
					 * System.out.println("ERROR: No students are loaded!");
					 * System.out.println("");
					 * 
					 * }
					 */
					didRankingHappen = assignRankings(studentArray,
							schoolArray, numStudents, numSchools);
					// System.out.println("The state of didRankingHappen is" +
					// didRankingHappen );

				}
				if (OptionChosen.equalsIgnoreCase("E")) {

					editData(studentArray, schoolArray, numStudents,
							numSchools, didRankingHappen);

				}

				if (OptionChosen.equalsIgnoreCase("M")) {
					didMatchingHappen = false;
					clearMatches(studentArray, schoolArray, numStudents,
							numSchools);
					didMatchingHappen = match(studentArray, schoolArray,
							numStudents, numSchools, didRankingHappen);
				}

				if (OptionChosen.equalsIgnoreCase("P")) {

					printStudents(studentArray, schoolArray, numStudents,
							didRankingHappen);
					printSchools(studentArray, schoolArray, numSchools,
							didRankingHappen);
				}
				if (OptionChosen.equalsIgnoreCase("D")) {
					displayMatches(studentArray, schoolArray, numStudents,
							numSchools);
				}

				if (OptionChosen.equalsIgnoreCase("R")) {

					for (int i = 0; i < numStudentsAdded; i++) {
						studentArray[i].setES(-1);
						studentArray[i].setGPA(-1);
						studentArray[i].setMatchingHappened(false);
						studentArray[i].setName("");
						studentArray[i].setNSchools(0);

						studentArray[i] = null;

						// studentArray[i].setRegret(-1);
						// studentArray[i].setSchool(0);
					}

					for (int j = 0; j < numSchoolsAdded; j++) {
						schoolArray[j].setAlpha(0);
						schoolArray[j].setMatchingHappened(false);
						schoolArray[j].setName("");
						schoolArray[j].setNStudents(0);
						schoolArray[j].setRegret(0);
						schoolArray[j].setStudent(0);
						schoolArray[j] = null;

					}

					numStudentsToAdd = 0;
					numStudentsAdded = 0;
					numSchoolsToAdd = 0;
					numSchoolsAdded = 0;
					didMatchingHappen = false;

					totalSchoolRegret = 0;
					averageSchoolRegret = 0;
					averageRegretPerPerson = 0;
					averageStudentRegret = 0;

					numSchools = 0; // Holds number of High Schools entered
					numStudents = 0; // Holds number of students entered

					System.out.println("");
					System.out.println("Database cleared!");
					System.out.println("");

				}

			}

		} while (!Quit);

	}

	public static double getDouble(String prompt, double LB, double UB) {
		double value = 0;
		boolean valid;
		do {
			valid = true;
			System.out.print(prompt);
			try {
				value = Double.parseDouble(input.readLine());
				if (value < LB || value > UB) {
					valid = false;

					System.out.println("");
					System.out
							.printf("ERROR: Input must be a real number in [0.00, %.2f]!\n",
									UB);
					System.out.println("");

				}
			}

			catch (NumberFormatException e) {

				System.out.println("");
				System.out
						.printf("ERROR: Input must be a real number in [0.00, %.2f]!\n",
								UB);
				System.out.println("");
				valid = false;

			} catch (IOException e) {

				System.out.println("");
				System.out
						.printf("ERROR: Input must be a real number in [0.00, %.2f]!\n",
								UB);
				System.out.println("");
				valid = false;

			}

		} while (!valid);
		return value;

	}

	public static int getInteger(String prompt, int LB, int UB) {

		boolean valid;
		int value = -1;

		do {

			valid = true;
			System.out.print(prompt);

			try {
				value = Integer.parseInt(input.readLine());
				if ((prompt == "Number of schools to add: " || prompt == "Number of students to add: ")
						&& (value < LB || value > UB)) {

					System.out.println("");
					System.out.println("ERROR: Input must be an integer in ["
							+ LB + ", infinity]!");
					System.out.println("");
					valid = false;

				}

				else if (value < LB || value > UB) {
					valid = false;
					System.out.println("");
					System.out.println("ERROR: Input must be an integer in ["
							+ LB + ", " + UB + "]!");
					System.out.println("");

				}

			} catch (NumberFormatException e) {
				if (prompt == "Number of schools to add: "
						|| prompt == "Number of students to add: ") {

					System.out.println("");
					System.out.println("ERROR: Input must be an integer in ["
							+ LB + ", infinity]!");
					System.out.println("");
					valid = false;

				}

				else {
					System.out.println("");
					System.out.println("ERROR: Input must be an integer in ["
							+ LB + ", " + UB + "]!");
					System.out.println("");

					valid = false;
				}

			}

			catch (IOException e) {

				if (prompt == "Number of schools to add: "
						|| prompt == "Number of students to add: ") {

					System.out.println("");
					System.out.println("ERROR: Input must be an integer in ["
							+ LB + ", infinity]!");
					System.out.println("");
					valid = false;

				}

				else {
					System.out.println("");
					System.out.println("ERROR: Input must be an integer in ["
							+ LB + ", " + UB + "]!");
					System.out.println("");

					valid = false;
				}

			}

		} while (!valid);
		return value;
	}

}
