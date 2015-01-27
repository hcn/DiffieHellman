package com.mailtux.diffie;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class DiffieTests {
	
	private String testData[]= {
			"here is a family living in Britain, known only as the KE family, ",
			"with a few members that can’t quite say words like “hippopotamus.” ",
			"They know the words, but can’t get their mouth positions quite right, ",
			"so their speech comes out garbled. Some family members have a hard time s",
			"aying words in the right order, and others have trouble reciting words that begin",
			"with the same letter. Multiple generations of the family have similar language difficulties,",
			"suggesting a genetic basis for their disorder.",
			"In the early 2000s, Oxford University geneticists Anthony Monaco, ",
			"Simon Fisher, and their colleagues found the culprit: KE family ",
			"members had a rare mutation in a gene called FOXP2.1 The mutation was subtle—only",
			"one nucleotide removed from the typical FOXP2 sequence—but the resulting ",
			"language impairment was substantial. That meant there was probably something about",
			"the normal FOXP2 gene that helped enable fluent speech. In the wake of this finding,",
			"FOXP2 was trumpeted in the press as a “grammar gene” and a “language gene.” ",
			"The public’s “language gene” assumption seemed to fit well with certain ",
			"long-standing theories about the origins of language. In the mid-1960s, ",
			"linguist Noam Chomsky proposed that the human brain is equipped with a distinct ",
			"“language organ”—a module that appeared relatively suddenly in the history of human ",
			"development. “The language organ interacts with early experience and matures into ",
			"the grammar of the language that the child speaks,” Chomsky told Omni’s John Gliedman", 
			"in a 1983 interview. "
			
			
			
	};

	@Test
	public void big() {
		BigInteger b=BigInteger.valueOf(1063);
		b=b.pow(47*763);
		String val=b.toString();
		System.out.println(val.length());
		BigInteger sekunder=new BigInteger("400000000000000000");
//		System.out.println(val);
	}
	
	@Test
	public void test() {
		
		ShiftCoder coder=new ShiftCoder();
		
		
		for (int i = 0; i < this.testData.length; i++) {
			String tekst=this.testData[i];
			System.out.println(tekst);
			for (int j = 1; j < 200; j++) {
			
			  String kodet=coder.encode(tekst,j);
			  String dekodet=coder.decode(kodet,j);
			  
			  if (! tekst.equals(dekodet)) {
				  System.out.println(j);
				  System.out.println(tekst);
				  System.out.println(kodet);
				  System.out.println(dekodet);
				  
			  }
			  
			assertEquals(tekst,dekodet);
			}
		}
		
		
	}
}
