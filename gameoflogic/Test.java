package gameoflogic;

public class Test
{
	
	public static void test1()
	{
		Atomic atomic = new Atomic("I am an ass","I am not an ass");
		assert atomic.status() == Proposition.UNDECIDED;
		assert atomic.setStatus(Proposition.TRUE);
		assert !atomic.setStatus(Proposition.FALSE);
		atomic = new Atomic("I am an ass","I am not an ass");
		assert atomic.status() == Proposition.UNDECIDED;
		assert atomic.setStatus(Proposition.TRUE);
		assert atomic.setStatus(Proposition.TRUE);
	}

	public static void test2()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am a king","I am not a king");
		Compound compound = new Compound(A,B,Compound.OR);
		assert compound.status() == Proposition.UNDECIDED;
		A.setStatus(Proposition.TRUE);
		assert A.status() == Proposition.TRUE;
		assert B.status() == Proposition.UNDECIDED;
		assert compound.status() == Proposition.TRUE;
		assert compound.isConsistent();
		assert compound.setStatus(Proposition.TRUE);
		assert A.status() == Proposition.TRUE;
		assert B.status() == Proposition.UNDECIDED;
		B.setStatus(Proposition.TRUE);
		assert B.status() == Proposition.TRUE;
		assert compound.isConsistent();
		assert compound.status() == Proposition.TRUE;
	}

	public static void test3()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am a king","I am not a king");
		Compound compound = new Compound(A,B,Compound.AND);
		assert compound.status() == Proposition.UNDECIDED;
		A.setStatus(Proposition.TRUE);
		assert A.status() == Proposition.TRUE;
		assert B.status() == Proposition.UNDECIDED;
		assert compound.status() == Proposition.UNDECIDED;
		assert compound.isConsistent();
		assert compound.setStatus(Proposition.TRUE);
		assert A.status() == Proposition.TRUE;
		assert B.status() == Proposition.TRUE;
		assert compound.isConsistent();
		assert compound.status() == Proposition.TRUE;
	}

	public static void test4()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.OR);
		assert compound.status() == Proposition.UNDECIDED;
		assert compound.setStatus(Proposition.TRUE);
		assert A.status() == Proposition.UNDECIDED;
		assert B.status() == Proposition.UNDECIDED;
		assert compound.isConsistent();
		assert B.setStatus(Proposition.TRUE);
		assert A.status() == Proposition.UNDECIDED;
		assert compound.isConsistent();
	}

	public static void test5()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.AND);
		assert compound.status() == Proposition.UNDECIDED;
		assert compound.setStatus(Proposition.FALSE);
		assert A.status() == Proposition.UNDECIDED;
		assert B.status() == Proposition.UNDECIDED;
		assert compound.isConsistent();
		assert B.setStatus(Proposition.TRUE);
		assert compound.isConsistent();
		assert A.status() == Proposition.FALSE;
	}

	public static void test6()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.OR);
		assert A.setStatus(Proposition.TRUE);
		assert !compound.setStatus(Proposition.FALSE);
		assert B.status() == Proposition.UNDECIDED;
	}

	public static void test7()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.IF_THEN);
		assert A.setStatus(Proposition.TRUE);
		assert compound.setStatus(Proposition.FALSE);
		assert B.status() == Proposition.FALSE;
	}

	public static void test8()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.IF_THEN);
		assert B.setStatus(Proposition.FALSE);
		assert compound.setStatus(Proposition.FALSE);
		assert A.status() == Proposition.TRUE;
	}

	public static void test9()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.IF_THEN);
		assert B.setStatus(Proposition.TRUE);
		assert !compound.setStatus(Proposition.FALSE);
	}

	public static void test10()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.AND);
		assert B.setStatus(Proposition.TRUE);
		assert compound.setStatus(Proposition.FALSE);
		assert A.status() == Proposition.FALSE;
	}

	public static void test11()
	{
		Atomic A = new Atomic("I am an ass","I am not an ass");
		Atomic B = new Atomic("I am clever","I am foolish");
		Compound compound = new Compound(A,B,Compound.IF_THEN);
		assert B.setStatus(Proposition.TRUE);
		assert A.setStatus(Proposition.FALSE);
		assert !compound.setStatus(Proposition.FALSE);
	}

	public static void main(String [] args)
	{
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
	}
}
