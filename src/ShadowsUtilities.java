import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 * My utilities!
 * @author Tyler (Shadows)
 * @version 1.2.0
 */
public class ShadowsUtilities 
{
	/**
	 * Delay, in milliseconds. Because Robotics habits are strong.
	 */
	public static void delay(int MS)
	{
		try 
		{
			TimeUnit.MILLISECONDS.sleep(MS);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Finds the GCF given two inputs
	 */
	public static long findGCF(long num1, long num2)
	{
		long GCF = 1; //GCF of all numbers
		for(int c = 1; c <= num1 && c <= num2; c++)
		{
			if(num1 % c == 0 && num2 % c == 0)GCF = c;
		}
		return GCF;
	}
	
	/**
	 * Returns a random int within the given range
	 */
	public static int randomInRange(int lower, int upper)
	{
		int randNum;
		if(lower > upper)
		{
			int ph = lower;
			lower = upper;
			upper = ph;
		}
		Random RNG = new Random();
		
		int range = upper - lower + 1;
				
		randNum = RNG.nextInt(range)+lower;
		
		return randNum;
	}
	
	/**
	 * Converts the given string to all lowercase except the last letter which is capitalized
	 */
	public static String firstLetterUppercase(String str)
	{
		char[] hi = str.toLowerCase().toCharArray();
		
		hi[0] = Character.toUpperCase(hi[0]);
		
		String re = new String(hi);
		
		return re;
	}
	
	/**
	 * Changes all number in the input string into their subscript forms
	 */
	public static String num2subscript(String str) 
	{
	    str = str.replaceAll("0", "₀");
	    str = str.replaceAll("1", "₁");
	    str = str.replaceAll("2", "₂");
	    str = str.replaceAll("3", "₃");
	    str = str.replaceAll("4", "₄");
	    str = str.replaceAll("5", "₅");
	    str = str.replaceAll("6", "₆");
	    str = str.replaceAll("7", "₇");
	    str = str.replaceAll("8", "₈");
	    str = str.replaceAll("9", "₉");
	    return str;
	}
	
	public static Clip importSoundClip(String filePath)
	{
		File countdownSound = new File(filePath);
		Clip clip = null;
		try 
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(countdownSound);
			Clip clip2 = AudioSystem.getClip();
			clip = clip2;
			clip.open(audioIn);
		} 
		catch (UnsupportedAudioFileException e) 
		{
			JOptionPane.showMessageDialog(null,"There was an error with a sound file: Unsupported", "ERROR", 0);
			System.exit(202);
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null,"There was an error with a sound file. Please check your file configuration.", "ERROR", 0);
			System.exit(202);
		} 
		catch (LineUnavailableException e) 
		{
			JOptionPane.showMessageDialog(null,"There was an error with a sound file: Line Unavailable", "ERROR", 0);
			System.exit(202);
		}
		return clip;
	}
}
