public class School {

	private String name; // name

	private double alpha; // GPA weight

	private int[] rankings; // rankings of students

	private int student; // index of matched student

	private int regret; // regret

	private boolean matchingHappened = false;

	// constructors

	public School() {

		this.name = "";

		this.alpha = 0;

		this.rankings = new int[25];

		this.initializeRankings();

	}

	public School(String name, double alpha, int nStudents) {

		this.name = name;

		this.alpha = alpha;

		this.rankings = new int[25];

		this.initializeRankings();

	}

	// getters

	public String getName() {
		return this.name;
	}

	public double getAlpha() {
		return this.alpha;
	}

	public int getRanking(int i) {
		return this.rankings[i];
	}

	public int getStudent() {
		return this.student;
	} // Return index of matched student

	public int getRegret() {
		return this.regret;
	}

	public int getRankingLength() {
		return this.rankings.length;
	}

	// setters

	public void setName(String name) {
		this.name = name;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public void setRanking(int i, int r) {
		this.rankings[i] = r;
	}

	public void setStudent(int i) {
		this.student = i;
	}

	public void setRegret(int r) {
		this.regret = r;
	}

	public void setNStudents(int n) {
		this.rankings = new int[n];
	} // set rankings array size

	public void setMatchingHappened(boolean didMatchingHappen) {
		this.matchingHappened = didMatchingHappen;
	}

	public void initializeRankings() {

		for (int i = 0; i < getRankingLength(); i++)

			this.setRanking(i, -1);

	}

	// find student ranking based on student ID

	public int findRankingByID(int ind) {
		return 2;
	}

	// get new info from the user

	public void editInfo(Student[] S, boolean canEditRankings) {
	}

	// calculate rankings based on weight alpha

	public void calcRankings(Student[] S) {
	}

	// print school info and assigned student in tabular format

	public void print(Student[] S, boolean rankingsSet) {

		System.out.format("%-32s", this.getName());

		System.out.format("%.2f", this.getAlpha());

		// System.out.println("This.GETSTUDENT IN SCHOOL IS RETURNING " +
		// S[this.getStudent()].getName());

		if (!rankingsSet && !matchingHappened) {

			// System.out.print("   -                          -");

			System.out.print("  -                          -");

		}

		else if ((!matchingHappened) && rankingsSet) {

			// System.out.println("This 3 is happening");

			// System.out.format("   %-27s", S[this.getStudent()].getName());

			// System.out.print("-");

			System.out.print("  -                          ");

			printRankings(S);

		}

		else if (matchingHappened) {

			System.out.format("  %-27s", S[this.getStudent()].getName());

			// System.out.println("This school's regret is " +
			// this.getRegret()); REGRET FUCKING WORKS

			printRankings(S);

		}

		// else if ((!rankingsSet)){

		// System.out.print("  -                          ");

		// }

		// else if (rankingsSet){

		// }

		else if (!matchingHappened) {

			System.out.print("-");

		}
		;

	}

	// print the rankings separated by a comma

	public void printRankings(Student[] S) {

		for (int r = 1; r < this.getRankingLength(); r++) { // Loop through
															// scores array,
															// compare w each
															// student score

			// by looping through each student and calculating their score again

			for (int studentIndex = 0; studentIndex < getRankingLength(); studentIndex++) {

				if (r == this.getRanking(studentIndex)) {

					System.out.print(S[studentIndex].getName());

					if (this.rankings[r] == -1) {

						break;

					}

					else {

						System.out.print(", ");

					}

				}

			}

		}

	}

}