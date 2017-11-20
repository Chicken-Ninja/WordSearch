
    import java.util.Random;
    import java.util.Scanner;
    import java.util.ArrayList;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.lang.Math;
import java.util.Arrays;
public class WordSearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private int area;
    
    
     
    public WordSearch(int rows,int cols,String fileName, int Seed , String answers){
    area = rows;
    randgen = new Random(Seed); 
    //randgen = new Random (Seed);
	try{File a  = new File(fileName);
	    Scanner b = new Scanner(a);
	    
	    while(b.hasNext()){
		String line = b.nextLine();
		wordsToAdd.add(line);
	       
		
	    }}catch(FileNotFoundException e){
		System.out.println("File not found" + fileName);
		System.exit(1);}
		

	char[][]temp = new char[rows][cols];
	for (int counter = 0; counter < cols; counter ++ ){
	    for (int coonter = 0; coonter < rows; coonter ++){
		temp[coonter][counter] = '_';}}
	data = temp;
	area = rows; 	
	for ( int counter = 0; counter < 1000; counter ++ ) {
	    addAllWords();}
	if(answers.equals("key") || answers.equals("Key")){
	    System.out.println(toString());}
	else{for(int counter = 0; counter < area; counter++ ) {
	    for(int coonter = 0; coonter < area; coonter++ ) {
		if(data[coonter][counter] == '_') {data[coonter][counter] = (char)(randgen.nextInt(Seed) % 26 + 'a');}}}
	    System.out.println(toString());}
    }

	
	
	
    
    public WordSearch (int rows , int cols , String fileName, int Seed) {
    area = rows;
    randgen = new Random(Seed);
    //wordsToAdd = new ArrayList<String>();
    //wordsAdded = new ArrayList<String>(); 
    //randgen = new Random(randSeed); 
	try{File a  = new File(fileName);
	    Scanner b = new Scanner(a);
	    
	    while(b.hasNext()){
		String line = b.nextLine();
		wordsToAdd.add(line);
	       
		
	    }}catch(FileNotFoundException e){
		System.out.println("File not found" + fileName);
		System.exit(1);}
		

	char[][]temp = new char[rows][cols];
	for (int counter = 0; counter < cols; counter ++ ){
	    for (int coonter = 0; coonter < rows; coonter ++){
		temp[coonter][counter] = '_';}}
	data = temp;
	area = rows; 
	for ( int counter = 0; counter < 1000; counter ++ ) {
	    addAllWords();}
	for(int counter = 0; counter < area; counter++ ) {
	   for(int coonter = 0; coonter < area; coonter++ ) {
		if(data[coonter][counter] == '_')  {data[coonter][counter] = (char)(randgen.nextInt(Seed) % 26 + 'a');}}}

	System.out.println( toString());}
	
    
    //public int rereturn () {
    //int seed =(int)(Math.random()*100000);
    //return seed;}
    
    private void clear(){
	for (int counter = 0; counter < data.length; counter ++ ){
	    for (int coonter = 0; coonter < data[0].length; coonter ++){
		data[coonter][counter] = '_';}

	}}

    
    public String toString(){
	String dump = "" ;
	int rowpos = 0; 
	for(int counter = 0; counter < data[0].length; counter ++){
	    for(int colcount = 0; colcount < data.length; colcount ++ ) {
		dump = dump + ' '  +  data[counter][colcount];}
	    dump = dump +'\n';}
	return dump;
	    
    }


     public boolean addWordHorizontal(String word,int row, int col){
	if(word.length() > data.length - col) {return false;} 
	if(row > data[0].length) {return false;}
	int digitcount = 0; 
	for (int counter = col; counter < col + word.length(); counter ++ ) {
	    if(data[row][counter] != '_' && data[row][counter] != word.charAt(digitcount)) {return false;}
	    digitcount ++; }
	digitcount = 0; 
	for(int counter = col; counter < col + word.length(); counter++ ) {
	    data[row][counter] = word.charAt(digitcount);
	    digitcount ++;}

	return true;
	}

  
    public boolean addWordVertical(String word,int row, int col){
	if(word.length() > data[0].length + row) {return false;}
	if(col > data.length) {return false;}
	int digitcount = 0;
	for(int counter = row; counter < row + word.length(); counter++){
	    if(word.charAt(digitcount) != data[counter][col] && data[counter][col] != '_'){return false;}
	    digitcount ++ ;}
	digitcount = 0; 
	for(int counter = row; counter < row + word.length() ; counter++ ) { 
	    data[counter][col] = word.charAt(digitcount);
	    digitcount ++ ;}
	return true;
	}


     public  boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
	if(word.length() > data.length + col) {return false;}
	if(word.length() > data[0].length + row) {return false;}
	if(col > data.length || row > data.length) {return false;}
	if(rowIncrement == 0 && colIncrement == 0) {return false;} 
	int digitcount = 0;
	int rowcount = row;
	int colcount = col;
	for (int counter = 0; counter < word.length() ; counter++ ) {
	    if (data[rowcount][colcount] != '_' && data[rowcount][colcount] != word.charAt(counter)) {return false;}
	   rowcount =  rowcount + rowIncrement;  
	   colcount =  colcount + colIncrement;
	}
	rowcount = row;
	colcount = col; 
	for (int counter = 0; counter < word.length() ; counter++ ) {
	    data[rowcount][colcount] = word.charAt(counter);
	    rowcount = rowcount + rowIncrement;
	    colcount = colcount + colIncrement;
	}
	wordsToAdd.remove(word);
	wordsAdded.add(word);
	return true;
	
    }

    private boolean addAllWords(){
	for(int i = 0; i < wordsToAdd.size(); i ++){
	    try {addWord(wordsToAdd.get(i), randgen.nextInt(area) , randgen.nextInt(area), randgen.nextInt() % 2 , randgen.nextInt() % 2);}
	    catch(ArrayIndexOutOfBoundsException  e) {};}
	return true;}

//The codes after these are not necessary, but simply test codes that I used and edited out later


    /* public String  Wordsremaining () {
	
	String dump = "";
	for (int counter = 0; counter < wordsToAdd.size();counter ++){
		dump = dump + wordsToAdd.get(counter);}
		return dump;}*/

    //The codes after these are not necessary, but simply test codes that I used and edited out later

    /* public String Wordsdone() {
	String dump = "";
	for(int counter = 0; counter < wordsAdded.size(); counter++){
	    dump = dump + wordsAdded.get(counter);}
	    return dump;}*/ 


    /* private boolean addAllWords(){
	int max = wordsToAdd.size();
	for (int counter = 0; counter < max; counter++)
	    {

    */

    public static void main (String[] args){
	try{int row = Integer.parseInt(args[0]);
	    int col = Integer.parseInt(args[1]);
	    if( row == 0 || col == 0 || !(args[2].substring(args[2].length() - 4).equals(".txt"))) {throw new ArrayIndexOutOfBoundsException();}
	    else if( args.length == 3) {
		int randSeed = (int)(Math.random()*100000); 
		System.out.println("Your seed is " + randSeed);
		WordSearch a = new WordSearch (row , col , args[2] , randSeed);}
	    else if( args.length == 4) {
		int seed = Integer.parseInt(args[3]);
		WordSearch a = new WordSearch (row , col , args[2] , seed);}
	    else if( args.length == 5) {
		int seed = Integer.parseInt(args[3]);
		WordSearch a = new WordSearch(row , col , args[2] , seed , args[4]);}
}catch(ArrayIndexOutOfBoundsException e){
     	System.out.println("To use this WordSearch, first input the number of rows, followed by the number of collumns of the puzzle.");
	    System.out.println("Then you must put in the filename of which you need to read in the words to put into the puzzle (You must use the file extension)");
	    System.out.println(" Finally, you can optionally put in a seed of which to generate the puzzle, and optionally, afterwards, you can put in the String Key or key to print out the answers to the puzzle.");
	    System.out.println("If you do not put in the seed, you will be given one randomly");}}
}

	 
	