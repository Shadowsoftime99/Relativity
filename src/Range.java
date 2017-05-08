
public class Range 
{
	double lower, upper;
	
	public Range(double first, double second)
	{
		if(first < second)
		{
			lower = first; upper = second;
		}
		else
		{
			lower = second; upper = first;
		}
	}
	
	public static boolean doRangesCross(Range r1, Range r2)
	{
		return Math.max(r1.lower,r2.lower) <= Math.min(r1.upper,r2.upper);
	}

	public boolean contains(double value) 
	{
		return value >= lower && value <= upper;
	}
}
