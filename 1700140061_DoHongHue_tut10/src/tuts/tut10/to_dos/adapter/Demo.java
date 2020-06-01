package tuts.tut10.to_dos.adapter;

import tuts.tut10.to_dos.adapter.adapter.SquarePegAdapter;
import tuts.tut10.to_dos.adapter.round.RoundHole;
import tuts.tut10.to_dos.adapter.round.RoundPeg;
import tuts.tut10.to_dos.adapter.square.SquarePeg;

/**
 * Somewhere in client code...
 */
public class Demo {
	public static void main(String[] args) {
		RoundHole hole1 = new RoundHole(10);
		RoundPeg hole2 = new RoundPeg(10);
		//TO-DO: Create 2 instances of RoundHole and RoundPeg with same radius
	 
		//TO-DO: If RoundHole instance can "fits" with RoundPeg instance => show a message
	 if(hole1.fits(hole2)) {
		 System.out.println("hole and peg are fitting!");
	 }
		//TO-DO: Create 2 instances of SquarePeg with 2 different widths
 SquarePeg peg1 = new SquarePeg(10);
 SquarePeg peg2 = new SquarePeg(5);
		//Note: You can't make RoundHole instance "fit" with SquarePeg instance
		//Therefore, we need to use Adapter for solving the problem.
		
		//TO-DO: Create 2 corresponding instances of SquarePegAdapter  
		 SquarePegAdapter adapter1 = new SquarePegAdapter(peg1);
		 SquarePegAdapter adapter2 = new SquarePegAdapter(peg2);
		//TO-DO: If the RoundHole instance can "fits" with "small" RoundPegAdapter instance 
		//show a suitable message
		 if(hole1.fits(adapter1)) {
			 System.out.println("Round hole can fit with the small small Square peg");
		 } else {
			 System.out.println("Round hole can not fit with the small Square peg");
		 }
	 
		//TO-DO: If the RoundHole instance can not "fits" with "big" RoundPegAdapter instance 
		//show a suitable message
	}
}