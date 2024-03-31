package gameoflogic;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;

public class RandomGame
{
	public static void main(String [] args)
		throws IOException
	{
		Random r = new Random();
		boolean game_over = false;
        // Enter data using BufferReader
		ArrayList<Atomic> domain = new ArrayList<>();
		domain.add(new Atomic("You are an ass","You are not an ass"));
		domain.add(new Atomic("I am clever","I am foolish"));
		Disputation dispute = new Disputation(domain);
		do
		{
			if (dispute.questionsRemaining() == 0)
				break;
			System.out.println(dispute.questionsRemaining()+") "+ dispute.newProposition());
			String response = (r.nextBoolean()) ? "true" : "false";
			System.out.println(response);
			if (response.equals("true"))
				game_over = !dispute.reply(true);
			else if (response.equals("false"))
				game_over = !dispute.reply(false);
		}
		while (!game_over);
		if (!game_over && dispute.questionsRemaining() == 0)
			System.out.println("No more questions! You win!");
		else
		{
			System.out.println("You lose!");
			String [] why = dispute.describeContradiction();
			for (String statement: why)
				System.out.println(statement);
		}
		System.out.println("Your score is "+dispute.getRounds());
	}
}
