package com.alyxferrari.gen95;
import javax.swing.*;
public class Gen95 {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("GUI coming soon. Use CLI for now. -help for usage.");
			JOptionPane.showMessageDialog(null, "GUI coming soon. Use CLI for now. -help for usage.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equals("-cd10")) {
				long start = System.currentTimeMillis();
				String key = gen10CDKey();
				long end = System.currentTimeMillis();
				System.out.println(key);
				System.out.println("Generated 1 10-digit CD key in " + ((double)(end-start)/1000) + " seconds! (" + (end-start) + " ms)");
				return;
			}
			if (args[0].equals("-cd11")) {
				long start = System.currentTimeMillis();
				String key = gen11CDKey();
				long end = System.currentTimeMillis();
				System.out.println(key);
				System.out.println("Generated 1 11-digit CD key in " + ((double)(end-start)/1000) + " seconds! (" + (end-start) + " ms)");
				return;
			}
			if (args[0].equals("-oem20")) {
				long start = System.currentTimeMillis();
				String key = genOEMKey();
				long end = System.currentTimeMillis();
				System.out.println(key);
				System.out.println("Generated 1 20-digit OEM key in " + ((double)(end-start)/1000) + " seconds! (" + (end-start) + " ms)");
				return;
			}
		} else if (args.length == 2) {
			if (args[0].equals("-cd10")) {
				int count;
				try {
					count = Integer.parseInt(args[1]);
					if (count < 1) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException ex) {
					Gen95.printUsage();
					return;
				}
				String[] result = new String[count];
				long start = System.currentTimeMillis();
				for (int i = 0; i < count; i++) {
					result[i] = gen10CDKey();
				}
				long end = System.currentTimeMillis();
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
				System.out.println("Generated " + count + " 10-digit CD keys in " + ((double)(end-start)/1000) + " seconds! (" + (end-start) + " ms)");
				return;
			}
			if (args[0].equals("-cd11")) {
				int count;
				try {
					count = Integer.parseInt(args[1]);
					if (count < 1) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException ex) {
					Gen95.printUsage();
					return;
				}
				String[] result = new String[count];
				long start = System.currentTimeMillis();
				for (int i = 0; i < count; i++) {
					result[i] = gen11CDKey();
				}
				long end = System.currentTimeMillis();
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
				System.out.println("Generated " + count + " 11-digit CD keys in " + ((double)(end-start)/1000) + " seconds! (" + (end-start) + " ms)");
				return;
			}
			if (args[0].equals("-oem20")) {
				int count;
				try {
					count = Integer.parseInt(args[1]);
					if (count < 1) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException ex) {
					Gen95.printUsage();
					return;
				}
				String[] result = new String[count];
				long start = System.currentTimeMillis();
				for (int i = 0; i < count; i++) {
					result[i] = genOEMKey();
				}
				long end = System.currentTimeMillis();
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
				System.out.println("Generated " + count + " 20-digit OEM keys in " + ((double)(end-start)/1000) + " seconds! (" + (end-start) + " ms)");
				return;
			}
		}
		Gen95.printUsage();
	}
	public static void printUsage() {
		System.out.println("gen95 usage:");
		System.out.println("-help: display this menu");
		System.out.println("-cd10 [n]: generates n amount of valid 10-digit CD keys (used on Windows 95, Office 95, Windows NT 4.0, etc.)");
		System.out.println("-cd11 [n]: generates n amount of valid 11-digit CD keys (used on Office 97, etc.)");
		System.out.println("-oem20 [n]: generates n amount of valid 20-digit OEM product IDs (used on Windows 95, etc.)");
	}
	public static String gen10CDKey() {
		int three = (int)(Math.random()*999.0);
		while (three == 333 || three == 444 || three == 555 || three == 666 || three == 777 || three == 88 || three == 999 || (""+three).split("").length != 3) {
			three = (int)(Math.random()*999.0);
		}
		return three + "-" + genSeven();
	}
	private static int genSeven() {
		int seven = 0;
		boolean wrong = true;
		while(wrong) {
			seven = (int)(Math.random()*9999999.0);
			String[] split = (""+seven).split("");
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				count += Integer.parseInt(split[i]);
			}
			if (count % 7 == 0) {
				wrong = false;
			}
			if (split[split.length-1].equals("0") || split[split.length-1].equals("8") || split[split.length-1].equals("9") || split.length != 7) {
				wrong = true;
			}
		}
		return seven;
	}
	private static int genOEMSeven() {
		int seven = 0;
		boolean wrong = true;
		while(wrong) {
			seven = (int)(Math.random()*999999.0);
			String[] split = (""+seven).split("");
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				count += Integer.parseInt(split[i]);
			}
			if (count % 7 == 0) {
				wrong = false;
			}
			if (split[split.length-1].equals("0") || split[split.length-1].equals("8") || split[split.length-1].equals("9") || split.length != 6) {
				wrong = true;
			}
		}
		return seven;
	}
	public static String gen11CDKey() {
		int four = 0;
		String temp = "";
		while (temp.split("").length != 3) {
			four = (int)(Math.random()*999.0);
			temp = ""+four;
		}
		temp += ""+((Integer.parseInt(temp.split("")[2])+(int)(Math.random()+1.0)) == 10 ? 0 : (Integer.parseInt(temp.split("")[2])+(int)(Math.random()+1.0)));
		return temp + "-" + genSeven();
	}
	public static String genOEMKey() {
		int dayInt = (int)(Math.random()*366.0);
		int yearInt = ((int)(Math.random()*8.0))+95;
		String day = ""+dayInt;
		String year = ""+yearInt;
		if (dayInt < 10) {
			day = "00" + dayInt;
		} else if (dayInt < 100) {
			day = "0" + dayInt;
		}
		if (yearInt > 99) {
			year = (""+yearInt).split("")[1] + (""+yearInt).split("")[2];
		}
		int seven = genOEMSeven();
		int fiveInt = (int)(Math.random()*99999.0);
		String five = ""+fiveInt;
		if (fiveInt < 10) {
			five = "0000" + fiveInt;
		} else if (fiveInt < 100) {
			five = "000" + fiveInt;
		} else if (fiveInt < 1000) {
			five = "00" + fiveInt;
		} else if (fiveInt < 10000) {
			five = "0" + fiveInt;
		}
		return day + year + "-OEM-0" + seven + "-" + five;
	}
}