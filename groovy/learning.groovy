// https://www.tutorialspoint.com/groovy/groovy_basic_syntax.htm

class Example {

   static def HelloWorld(){
      println('Hello World');
   }

   static int sum(int a = 0, int b = 0){
      return a + b;
   }

   // it has to be static so it doesnt need an instance of Example
   static class Classy {
      int x;

      public int getX(){
         return x;
      }

      public int setX(int setX){
         x = setX;
      }
   }

   static void stringFunc(){
      String sample = "Hello world"; 
      println(sample[4]);
		
      // print the 1st character in the string starting from the back 
      println(sample[-1]); 
      println(sample[1..2]);// prints a string starting from Index 1 to 2 
      println(sample[4..2]);// prints a string starting from Index 4 back to 2 
   }

   static void lists(){

      // Adding items

      def guitars = ['Epiphone', 'Fender'];
      guitars.push('Chapman');
      guitars[3] = 'Ibanez';
      guitars << 'Yamaha';
      println guitars; // [Epiphone, Fender, Chapman, Ibanez, Yamaha]
         
      guitars.plus(4, 'ESP');
      println guitars; // [Epiphone, Fender, Chapman, Ibanez, Yamaha]
         
      def guitarsWithPlus = guitars.plus(2, 'ESP');
      println guitarsWithPlus; // [Epiphone, Fender, ESP, Chapman, Ibanez, Yamaha]
         
      guitars.add(0, 'Dean Guitars');
      println guitars; // [Yamaha, Epiphone, Fender, Chapman, Ibanez, Dean Guitars]
         
      guitars.addAll(2, ['Pasadena', 'Stagg']); // [Yamaha, Epiphone, Pasadena, Stagg, Fender, Chapman, Ibanez, Yamaha]
      println guitars;

      // Removing items 
      def poppedElement = guitars.pop();
      println poppedElement;

      guitars.remove(0);
      println guitars;

      // Item lookup
      def findStagg = guitars.find { it == 'Stagg'};
      println "found: " + findStagg;


      // Item lookup with regex
      def findEpiphoneWithRegex = guitars.findAll { it =~ /pip/ };
      println "found with regex: " +findEpiphoneWithRegex;

      def findGuitarsWhichStartWithY = guitars.findAll { it =~ /^Y/ }
      println "found those that start with Y: " + findGuitarsWhichStartWithY;

      // iteration

      guitars.eachWithIndex { guitar, index ->
         print index  + ": ";
         println guitar;
      }

      // or iterate this way
      def result = guitars.indexed().collect { guitar, index ->
         "$index: $guitar";
      }

      println result

      // incrementing indexPlusOne by 1
      guitars.eachWithIndex { guitar, index, indexPlusOne = index + 1 ->
      println "Guitar $guitar has position $indexPlusOne"
      }
   }
   
   static void maps(){

      // adding pairs
      def guitarMap = [:];
      guitarMap.put('Fender', 'Gibson'); // java notation
      guitarMap['Used'] = 'Yes';
      guitarMap << [price: 179]; // This is something output redirection in unix commands. key-value pair put inside map object
      guitarMap.class = "Premium"; // Dot notation is also available
      guitarMap.'delivery' = "Europe"; // Same as previous
         
      println guitarMap;

      // removing
      guitarMap.remove('class'); // by key
      println guitarMap;

      guitarMap = guitarMap - [delivery: 'Europe']; // "arithmetic operation"
      println guitarMap;

      // union

      def guitarMap2 = [guitarrela: 'Flamenco'];
      def unionMap = guitarMap + guitarMap2;
      println "union: " + unionMap;

      // iterating
      guitarMap.each { key, val ->
         println "Key: $key has value $val"
      }

      guitarMap.eachWithIndex { val, index -> 
         println "Index: $index has map pair $val"
      }

      for (val in guitarMap) {
         println "Key: $val.key has entry: $val.value";
      }

   }

   static void nullSafe(){
      
      def list = ['aaaa', 'bbb', 'zzz'];
      def string1 = list.find { it.startsWith('a')};
      println string1?.length();

      def string2 = list.find { it.startsWith('f')}; // no element found, null returned

      println string2?.length(); // no null pointer exception throw because we use nullsafe

      //println string2.length(); // nullpointer exception
   }

   static void ternary(){
      // in this case we have set a name
      def name = "Fender";
      def displayedName = name ?: "Ibanez";
      println displayedName;

      // in this case its null, so it will default to the elvis operator (special type of ternary) value = Ibanez
      def nameNull = null;
      //def nameNull = '';
      def displayedName2 = nameNull ?: "Ibanez";
      println displayedName2;
      // this is equivalent to def displayedName2 = (nameNull == null) ? "Ibanez" : nameNull;

   }

   static void regexing() {
      def nameRegex = ~'pasadena';
      println nameRegex.matcher("pasadena").matches();

      def priceRegex = ~/([0-9]+\.[0-9]+)/;
      println priceRegex.matcher("179.99").matches();

      def pattern = ~'G....r';
      println pattern.matcher("Guitar").matches();

      def isCasePattern = ~/G\w+r/;
      println isCasePattern.isCase("Guitarerrrerr");

      def grepPattern = ~/El\w+/;
      def cities = ['Electrical', 'Classical', 'Electrical'];
      println cities.grep(grepPattern);

      // easier way to call matchers
      def matcher = ("179.99" =~ /([0-9]+\.[0-9]+)/);
      println matcher.class.name;
      println matcher[0];

   }

   static void main(String[] args) {
      print("------------\n");
      HelloWorld();

      print("------------\n");
      print(sum(5,10) + "\n");

      print("------------\n");
      Classy classy = new Classy();
      int myX = 10;
      classy.setX(myX);
      //print("got x from Classy class: " + classy.getX()+ "\n");
      if( classy.getX() == myX){
         print("got x from Classy class: " + classy.getX()+ "\n");
      }
      print("------------\n");

      stringFunc();
      print("------------\n");

      lists();
      print("------------\n");

      maps();
      print("------------\n");

      nullSafe();
      print("------------\n");

      ternary();
      print("------------\n");

      regexing();
      print("------------\n");




      









      print("\n")
   }
}