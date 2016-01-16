
public class Student {

	private String name ; // name
	 private double GPA ; // GPA
	 private int ES ; // extracurricular score
	 private int [] rankings ; // rankings of schools
	 private int school; // index of matched school
	 private int regret; // regret
	 
	 private boolean matchingHappened = false;
	 
      // constructors
	 public Student (){
		 this.GPA = 0;
		 this.ES = 0;
		 this.name ="";
		 this.school = -10;
	 }
	 public Student ( String name , double GPA , int ES , int nSchools ){
		 this.name = name;
		 this.GPA = GPA;
		 this.ES = ES;
		 this.rankings = new int [nSchools];
	 }
	
	 // getters
	 public String getName() { return this.name; }
	 public double getGPA() { return this.GPA; }
	 public int getES() { return this.ES; }
	 public int getRanking( int i ) { return this.rankings[i]; }
	 public int getSchool() { return this.school; }
	 public int getRegret() { return this.regret; }
	
	 // setters
	 public void setName ( String name ) { this.name = name; }
	 public void setGPA ( double GPA ) { this.GPA = GPA; }
	 public void setES ( int ES ) { this.ES = ES; }
	 public void setRanking ( int i , int r ) { this.rankings[i] = r; }
	 public void setSchool ( int i ) { this.school = i; }
	 public void setRegret ( int r ) { this.regret = r; }
	 public void setNSchools ( int n ) { this.rankings = new int [n]; } // set rankings array size
	 public void setMatchingHappened (boolean didMatchingHappen){ this.matchingHappened = didMatchingHappen;}
	
	 // find school ranking based on school ID
	 public int findRankingByID ( int ind ){return 5;}
	
	 // get new info from the user
	 public void editInfo ( School [] H , boolean canEditRankings ){}
	
	 // edit rankings
	 public void editRankings ( School [] H ){}
	
	 // print student info and assigned school in tabular format
	 public void print( School [] H , boolean rankingsSet ){
		 System.out.format("%-31s", this.getName());
		 System.out.format("%.2f", this.getGPA());
		 System.out.format("%4d", this.getES()); //changed from 4 to 5
//		 System.out.println("get school function returning " + this.getSchool());
		// System.out.println("The this.GetSchool is returning " + this.getSchool());
		
	//	 System.out.println("RS" + rankingsSet);
		 
		 
		 if ((rankingsSet) && this.getSchool()<=0){
			 
			 System.out.print("  -                          ");
		 }
		 else if (matchingHappened && (rankingsSet)){
			// System.out.println("System.out in else statement's this.School is " + this.getSchool());
			 System.out.format("  %-27s", H[ (this.getSchool()-1)].getName());
			 
		 }
		
		 else if((!rankingsSet)){
			 System.out.print("  -                          ");
			 //System.out.print("-");
			 
		}
		
/*		else if ((rankingsSet) && (matchingHappened)){
			 System.out.format("   %-27s", H[this.getSchool()-1].getName());
			 //When rankings and assignments are both done, this is the one that gets printed and it works.	
			
			
		 } */
		
		else if ((!matchingHappened) && (rankingsSet) && this.getSchool()<0){
			
			
			 System.out.format("   %-28s", H[this.getSchool()].getName());
		 }
		
		 
		 
	   if(rankingsSet){
		printRankings(H);
		}
	   else{
		   System.out.println("-");
		   
	   }
		 
	 }
	
	 // print the rankings separated by a comma
	 public void printRankings ( School [] H ){
		
		
		 for(int r = 1; r<=this.rankings.length; r++){ //Loop through scores array, compare w each student score
				//by looping through each student and calculating their score again
				
			 	for(int studentIndex = 0; studentIndex < this.rankings.length; studentIndex ++){ 
					 
					if( r == this.getRanking(studentIndex)){
						System.out.print(H[studentIndex].getName());
					if( r != this.rankings.length ) 
						System.out.print(", ");
					else System.out.println("");
					
					}
					
				
				}		
			}
	}
}
