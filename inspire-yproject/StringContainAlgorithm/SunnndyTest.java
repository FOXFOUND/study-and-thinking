package com.sunddytest;

import java.util.ArrayList;
import java.util.List;

public class SunnndyTest {
	public static void main(String[] args) {
		String sourceString = "CODNEMOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOONKMONEMOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOONY";
		String testString = "MON";
		System.out.println("is contains string =" + IsContainS(sourceString, testString));
	}

	public static boolean IsContainS(String sourceString, String testString) {
		boolean res = false;

		// if(sourceString.length)

		// int first = sourceString.indexOf(priv);
		// int second = sourceString.indexOf(priv,first+1);
		// System.out.println(first);
		// System.out.println(second);

		List<Integer> lastchararr = new ArrayList<Integer>();
		int lastcharpos = 0;
		char priv = testString.charAt(testString.length() - 1);
		while (true) {
			try {

				lastcharpos = sourceString.indexOf(priv, lastcharpos + 1);
				if (Integer.compare(lastcharpos, -1) == 0) {
					break;
				}
				lastchararr.add(lastcharpos);
			} catch (Exception e) {
				// TODO: handle exception
				break;
			}

		}
		System.out.println(lastchararr);
		for (int j = 0; j < lastchararr.size(); j++) {

			int pos = lastchararr.get(j) - 1;
			int testpos = testString.length() - 2;
			while (true) {
				if (pos >= 0 && testpos >= 0) {
					char poschar = sourceString.charAt(pos);
					char testchar = testString.charAt(testpos);

					if (poschar == testchar) {
						if (testpos == 0) {
							System.out.println(pos+"-----------"+testchar);
							return true;
						}
						pos--;
						testpos--;
					} else {
						break;
					}
				}

			}
		}
		return res;
	}
}
