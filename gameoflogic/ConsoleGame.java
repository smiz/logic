package gameoflogic;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleGame
{
	public static void main(String [] args)
		throws IOException
	{
		boolean game_over = false, got_response = false;
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Atomic> domain = new ArrayList<>();
		domain.add(new Atomic("You are an ass","You are not an ass"));
		domain.add(new Atomic("I am clever","I am foolish"));
		Disputation dispute = new Disputation(domain);
		do
		{
			if (dispute.questionsRemaining() == 0)
				break;
			System.out.println(dispute.questionsRemaining()+") "+ dispute.newProposition());
			do
			{
				got_response = true;
				System.out.print(">>> ");
				System.out.flush();
				String response = reader.readLine();
				if (response.equals("true"))
					game_over = !dispute.reply(true);
				else if (response.equals("false"))
					game_over = !dispute.reply(false);
				else
				{
					System.out.println("true or false?");
					got_response = false;	
				}
			}
			while(!got_response);
		}
		while (!game_over);
		reader.close();
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
