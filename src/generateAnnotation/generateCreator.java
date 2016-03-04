package generateAnnotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class generateCreator {
	public static void main(String[] args){
		File annotatedQuad=new File("metaData.quad");
		File creator=new File("creator.quad");
		
		BufferedReader reader=null;
		List<String> list = new ArrayList<String>();
		try{
			reader=new BufferedReader(new FileReader(annotatedQuad));
			String tempString=null;
			while((tempString=reader.readLine())!=null){
					list.add(tempString);
				}
			FileWriter creatorTripleWriter=new FileWriter(creator.getName(),true);
			BufferedWriter createTripleBuffer=new BufferedWriter(creatorTripleWriter);
			int length=list.size();
			String temp1,temp2,temp3,temp4;
			String name;
			long random1,random2,random3;//随机ID
			generateCreator g=new generateCreator();
			for(int i=0;i<length;i++){
				temp1=list.get(i);
				temp1=temp1.substring(temp1.indexOf("<"), temp1.indexOf(">")+1);
				temp2=" <http://yago-knowledge.org/resource/creator> ";
				name=g.getRandomEnglishName();
				temp3="\""+name+"\" ";
				random1=g.randomDataGenerater(10000, 99999);
				random2=g.randomDataGenerater(10000, 99999);
				random3=g.randomDataGenerater(1000, 9999);//生成metaData的ID
				temp4="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">."+"\n";
				createTripleBuffer.write(temp1+temp2+temp3+temp4);
			}
			reader.close();
			createTripleBuffer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//生成随机ID
	public long randomDataGenerater(long min,long max){
		long temp;
		temp=(long)(Math.random()*(max-min))+min;
		return temp;
	}
	
	//生成随机英文名
	public static final String[] FEMALE_FIRST_NAMES = {
	      "Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer", "Maria", "Susan",
	      "Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Helen", "Sandra", "Donna",
	      "Carol", "Ruth", "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah", "Jessica",
	      "Shirley", "Cynthia", "Angela", "Melissa", "Brenda", "Amy", "Anna", "Rebecca", "Virginia",
	      "Kathleen", "Pamela", "Martha", "Debra", "Amanda", "Stephanie", "Carolyn", "Christine",
	      "Marie", "Janet", "Catherine", "Frances", "Ann", "Joyce", "Diane", "Alice", "Julie",
	      "Heather", "Teresa", "Doris", "Gloria", "Evelyn", "Jean", "Cheryl", "Mildred", "Katherine",
	      "Joan", "Ashley", "Judith", "Rose", "Janice", "Kelly", "Nicole", "Judy", "Christina",
	      "Kathy", "Theresa", "Beverly", "Denise", "Tammy", "Irene", "Jane", "Lori", "Rachel",
	      "Marilyn", "Andrea", "Kathryn", "Louise", "Sara", "Anne", "Jacqueline", "Wanda", "Bonnie",
	      "Julia", "Ruby", "Lois", "Tina", "Phyllis", "Norma", "Paula", "Diana", "Annie", "Lillian",
	      "Emily", "Robin", "Peggy", "Crystal", "Gladys", "Rita", "Dawn", "Connie", "Florence",
	      "Tracy", "Edna", "Tiffany", "Carmen", "Rosa", "Cindy", "Grace", "Wendy", "Victoria", "Edith",
	      "Kim", "Sherry", "Sylvia", "Josephine", "Thelma", "Shannon", "Sheila", "Ethel", "Ellen",
	      "Elaine", "Marjorie", "Carrie", "Charlotte", "Monica", "Esther", "Pauline", "Emma",
	      "Juanita", "Anita", "Rhonda", "Hazel", "Amber", "Eva", "Debbie", "April", "Leslie", "Clara",
	      "Lucille", "Jamie", "Joanne", "Eleanor", "Valerie", "Danielle", "Megan", "Alicia", "Suzanne",
	      "Michele", "Gail", "Bertha", "Darlene", "Veronica", "Jill", "Erin", "Geraldine", "Lauren",
	      "Cathy", "Joann", "Lorraine", "Lynn", "Sally", "Regina", "Erica", "Beatrice", "Dolores",
	      "Bernice", "Audrey", "Yvonne", "Annette", "June", "Samantha", "Marion", "Dana", "Stacy",
	      "Ana", "Renee", "Ida", "Vivian", "Roberta", "Holly", "Brittany", "Melanie", "Loretta",
	      "Yolanda", "Jeanette", "Laurie", "Katie", "Kristen", "Vanessa", "Alma", "Sue", "Elsie",
	      "Beth", "Jeanne"};
	
	  private static final String[] MALE_FIRST_NAMES = {
	      "James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph",
	      "Thomas", "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven",
	      "Edward", "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy",
	      "Jose", "Larry", "Jeffrey", "Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond",
	      "Gregory", "Joshua", "Jerry", "Dennis", "Walter", "Patrick", "Peter", "Harold", "Douglas",
	      "Henry", "Carl", "Arthur", "Ryan", "Roger", "Joe", "Juan", "Jack", "Albert", "Jonathan",
	      "Justin", "Terry", "Gerald", "Keith", "Samuel", "Willie", "Ralph", "Lawrence", "Nicholas",
	      "Roy", "Benjamin", "Bruce", "Brandon", "Adam", "Harry", "Fred", "Wayne", "Billy", "Steve",
	      "Louis", "Jeremy", "Aaron", "Randy", "Howard", "Eugene", "Carlos", "Russell", "Bobby",
	      "Victor", "Martin", "Ernest", "Phillip", "Todd", "Jesse", "Craig", "Alan", "Shawn",
	      "Clarence", "Sean", "Philip", "Chris", "Johnny", "Earl", "Jimmy", "Antonio", "Danny",
	      "Bryan", "Tony", "Luis", "Mike", "Stanley", "Leonard", "Nathan", "Dale", "Manuel", "Rodney",
	      "Curtis", "Norman", "Allen", "Marvin", "Vincent", "Glenn", "Jeffery", "Travis", "Jeff",
	      "Chad", "Jacob", "Lee", "Melvin", "Alfred", "Kyle", "Francis", "Bradley", "Jesus", "Herbert",
	      "Frederick", "Ray", "Joel", "Edwin", "Don", "Eddie", "Ricky", "Troy", "Randall", "Barry",
	      "Alexander", "Bernard", "Mario", "Leroy", "Francisco", "Marcus", "Micheal", "Theodore",
	      "Clifford", "Miguel", "Oscar", "Jay", "Jim", "Tom", "Calvin", "Alex", "Jon", "Ronnie",
	      "Bill", "Lloyd", "Tommy", "Leon", "Derek", "Warren", "Darrell", "Jerome", "Floyd", "Leo",
	      "Alvin", "Tim", "Wesley", "Gordon", "Dean", "Greg", "Jorge", "Dustin", "Pedro", "Derrick",
	      "Dan", "Lewis", "Zachary", "Corey", "Herman", "Maurice", "Vernon", "Roberto", "Clyde",
	      "Glen", "Hector", "Shane", "Ricardo", "Sam", "Rick", "Lester", "Brent", "Ramon", "Charlie",
	      "Tyler", "Gilbert", "Gene"};
	  
	  public static final String[] LAST_NAMES = {
	      "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore",
	      "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
	      "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen",
	      "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker",
	      "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips",
	      "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris",
	      "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey", "Rivera", "Cooper",
	      "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James",
	      "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross",
	      "Henderson", "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes",
	      "Flores", "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander",
	      "Russell", "Griffin", "Diaz", "Hayes", "Myers", "Ford", "Hamilton", "Graham", "Sullivan",
	      "Wallace", "Woods", "Cole", "West", "Jordan", "Owens", "Reynolds", "Fisher", "Ellis",
	      "Harrison", "Gibson", "Mcdonald", "Cruz", "Marshall", "Ortiz", "Gomez", "Murray", "Freeman",
	      "Wells", "Webb", "Simpson", "Stevens", "Tucker", "Porter", "Hunter", "Hicks", "Crawford",
	      "Henry", "Boyd", "Mason", "Morales", "Kennedy", "Warren", "Dixon", "Ramos", "Reyes", "Burns",
	      "Gordon", "Shaw", "Holmes", "Rice", "Robertson", "Hunt", "Black", "Daniels", "Palmer",
	      "Mills", "Nichols", "Grant", "Knight", "Ferguson", "Rose", "Stone", "Hawkins", "Dunn",
	      "Perkins", "Hudson", "Spencer", "Gardner", "Stephens", "Payne", "Pierce", "Berry",
	      "Matthews", "Arnold", "Wagner", "Willis", "Ray", "Watkins", "Olson", "Carroll", "Duncan",
	      "Snyder", "Hart", "Cunningham", "Bradley", "Lane", "Andrews", "Ruiz", "Harper", "Fox",
	      "Riley", "Armstrong", "Carpenter", "Weaver", "Greene", "Lawrence", "Elliott", "Chavez",
	      "Sims", "Austin", "Peters", "Kelley", "Franklin", "Lawson"};
	 
	public final String[] EMAIL_SUFFIX={"qq.com","126.com","163.com","gmail.com",
		"163.net","msn.com","hotmail.com","yahoo.com.cn","sina.com","@mail.com","263.net","sohu.com",
		"21cn.com","sogou.com"
		};
	
	public final <T>T nextValue(T[] array){
		assert (array!=null && array.length>0);
		Random a=new Random();
		return array[a.nextInt(array.length)];
	}
	
	public final String getRandomEnglishName(){
		return getRandomEnglishFirstName()+" "+getRandomEnglishLastName();
	}
	
	public final String getRandomEnglishFirstName(){
		Random a=new Random();
		return a.nextBoolean()?nextValue(FEMALE_FIRST_NAMES):nextValue(MALE_FIRST_NAMES);
	}
	
	public final String getRandomEnglishLastName(){
		return nextValue(LAST_NAMES);
	}
	
	public final String getRandomEmailAddress(){
		return getRandomEnglishFirstName()+getRandomEnglishLastName()+"@"+nextValue(EMAIL_SUFFIX);
	}
}
