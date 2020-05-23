
public class Ratl {

	private int valueNum;
	private int valueDenom;
	private int visibleNum;
	private int visibleDenom;

	public Ratl() {
		//no-arg constructor
		//creates a Ratl with value 0/1
		this.valueNum = 0;
		this.valueDenom = 1;

		this.visibleNum = 0;
		this.visibleDenom = 1;
	}

	public Ratl(int num, int denom){
		//two-int constructor
		//creates a Ratl with value num/denom
		this.valueNum = num;
		this.valueDenom = denom;

		this.visibleNum = num;
		this.visibleDenom = denom;
	}

	public Ratl(Ratl a){
		//Ratl constructor
		//builds a new Ratl with the same values as its input
		this.valueNum = a.valueNum;
		this.valueDenom = a.valueDenom;

		this.visibleNum = a.visibleNum;
		this.visibleDenom = a.visibleDenom;
	}

	/*********************************************
	Getters for Ratl
	**********************************************/
	public int getNum() { return valueNum; }
	public int getDenom(){ return valueDenom; }

	/*********************************************
	Setters for Ratl
	**********************************************/
	public void setNum(int num) {
		this.valueNum =  num;
		this.visibleNum = num;
	}

	public void setDenom(int denom) {
		this.valueDenom = denom;
		this.visibleDenom = denom;
	}

	//convert to string
	//print as a/b
	@Override
	public String toString() {
		return visibleNum + "/" + visibleDenom;
	}

	//reduce
	//reduces a Ratl to the canonical form described above
	//uses the gcd function
	public void reduce() {
		int greatestCommonDivisor = gcd(valueNum, valueDenom);
		
		setNum(valueNum / greatestCommonDivisor);
		setDenom(valueDenom / greatestCommonDivisor);
	}
	
	//static gcd
	public static int gcd(int a, int b) {
		if (b == 0){
			return a;
		}
		return gcd(b, a % b);
		}

	public static Ratl negate(Ratl a) {
		//given a/b
		//returns -a/b
		a.valueNum = a.valueNum * -1;

		return a;
	}

	public static Ratl invert(Ratl a) {
		//given a/b
		//returns b/a
		int temp;

		temp = a.valueNum;
		a.valueNum = a.valueDenom;
		a.visibleNum = a.valueNum;

		a.valueDenom = temp;
		a.visibleDenom = temp;

		return a;
	}

	public void add(Ratl b) {
		//adds b to the Ratl it is called with
		valueNum = (this.visibleDenom * b.valueNum) + (this.visibleNum * b.valueDenom);
		valueDenom = this.visibleDenom * b.valueDenom;

		reduce();
	}

	public void sub(Ratl b) {
		//implemented with add and negate
		negate(b);
		add(b);
	}

	public void mult(Ratl b) {
		//mult
		setNum(valueNum * b.valueNum);

		setDenom(valueDenom * b.valueDenom);

		reduce();
	}

	public void div(Ratl b) {
		//div
		invert(b);
		mult(b);
	}

	// static add
	public static Ratl add(Ratl a, Ratl b) {
		Ratl temp = new Ratl(a);

		temp.add(b);

		return temp;
	}

	// static sub
	public static Ratl sub(Ratl a, Ratl b) {
		a.sub(b);
		return a;
	}

	// static mult
	public static Ratl mult(Ratl a, Ratl b) {
		a.mult(b);
		return a;
	}
	
	// static div
	public static Ratl div(Ratl a, Ratl b) {
		a.div(b);
		return a;
	}

	// member ident
	public boolean ident(Ratl a) {
		{
			if(visibleNum * a.visibleDenom == visibleDenom * a.visibleNum)
				return true;
			else
				return false;
		}
	}
	
	// member equiv
	//check if its equivalent
	public boolean equiv(Ratl a) {
		{
			if(valueNum * a.valueDenom == valueDenom * a.valueNum)
				return true;
			else
			{
				int greatestCommonDivisor = gcd(valueNum, valueDenom);
				
				valueNum = valueNum / greatestCommonDivisor;
				valueDenom = valueDenom / greatestCommonDivisor;

				greatestCommonDivisor = gcd(a.valueNum, a.valueDenom);
				
				a.valueNum = a.valueNum / greatestCommonDivisor;
				a.valueDenom = a.valueDenom / greatestCommonDivisor;


				if(valueNum == a.valueNum && valueDenom == a.valueDenom)
				{
					//set the numbers back to normal
					valueNum = visibleNum;
					valueDenom = visibleDenom;
					a.valueNum = a.visibleNum;
					a.valueDenom = a.visibleDenom;

					return true;
				}
				else
				{
					return false;
				}
			}
		}
	}
	
	// static ident
	public static boolean ident(Ratl a, Ratl b) {
		boolean temp = a.ident(b);
		return temp;
	}
	
	// static equiv
	public static boolean equiv(Ratl a, Ratl b) {
		boolean temp = a.equiv(b);
		return temp;
	}
	
	// debugPrint
	// builds a string from the fields of a Ratl object as follows:
	// num value 3 denom value 5 num visible 6 denom visible 10
	// you might find Integer.toString() useful
	public String debugPrint() {
		String output = "num value " + valueNum + "  denom value " + valueDenom + "  num visible " + visibleNum + "  denom visible " + visibleDenom;
		return output;
	}
}
