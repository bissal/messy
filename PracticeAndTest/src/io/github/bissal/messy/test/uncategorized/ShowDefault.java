package io.github.bissal.messy.test.uncategorized;

public class ShowDefault {
	
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	
	void print(String s)
	{
		System.out.println(s);
	}
	
	void printInitialValues()
	{
		print("boolean : " + t);
		print("char : [" + c + "]");
		print("byte : " + b);
		print("short : " + s);
		print("int : " + i);
		print("long : " + l);
		print("float : " + f);
		print("double : " + d);
	}
}
