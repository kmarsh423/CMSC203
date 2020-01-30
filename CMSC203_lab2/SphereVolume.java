import java.util.Scanner;
public class SphereVolume 
{ 
	public static void main(String[] args) { 

		Scanner stdin = new Scanner(System.in);
		
		System.out.println("The purpose of this program is to calculate the volume of a sphere.\n");
		System.out.print("Enter the diameter of the sphere: ");
		double diam = stdin.nextDouble();
		double sphereR = diam / 2;
		double sphereV = (double)4/3 * Math.PI * Math.pow(sphereR, 3);
		System.out.print("The volume of the Sphere is " + sphereV);
	} 
} 
