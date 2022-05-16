package vocabMeanings;


import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class vacabs {

		static Map<String,String> hashmap = new LinkedHashMap<String,String>();
		static String paragraph ="";
				static String [] array1 = new String[1000];
				static int control=0;

	    public static void main(String[] args) {
	    	String word="hi";
	    	Scanner input = new Scanner(System.in);
	    	int b=input.nextInt();
	    	for(int i=0;i<b;i++) {
	    		try {
	    			word = input.next();
	    			
	    			getWebsite(word);
	    		} catch(Exception e) {
	    			print();
	    		}
	    	}
	    	print();
	    	
	        
	    }
	    public static void getWebsite(String word){
	        StringBuffer prefab = new StringBuffer("http://dictionary.com/browse/");
	        prefab.append(word);
	        String str= prefab.toString();
	      
	        copyText(str, word);
	    }
	    public static void copyText(String link, String word) {
	    	
	    	Document doc = null;
	    			try {
						doc = Jsoup.connect(link).get();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						doc =null;
					}
	    			
	    			Elements className = doc.getElementsByClass("css-10n3ydx e1hk9ate0");
	    			String linkText = className.text();
	    			String [] textArray = linkText.split("\\.");
	    			hashmap.put(word,textArray[0]);
	    			findSentence(word);
					
	    }
	    
	    public static void print() {
	    	int x=0;
	    	for(String name: hashmap.keySet()) {
	    		System.out.println("");
	    		System.out.println(name);
	    		System.out.println("");
	    		System.out.println(hashmap.get(name));
	    		System.out.println("");
	    		System.out.println(array1[x]);
	    		System.out.println("");
	    		x++;
	    	}
	    }
	    
	    public static void findSentence(String word) {
	    	String [] array = paragraph.split("\\.");
	    	
	    	for(int i=0;i<array.length;i++) {
	    	
	    		if (array[i].indexOf(word)!= -1) {
	    			array1[control] = array[i];
	    			
	    			
	    			break;
	    		}
	    	}
	    	control++;
	    }
	    
	 

	
}
