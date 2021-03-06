public class Player
{
	public int playerID;
	public int victoryPoints = 0;
	int buy = 1;
	int actions = 1;
	int money = 0;	
	public Pile deck;
	public Pile hand;
	public Pile discard;

	public Player(int ID)
	{
		System.out.println("Player has been initialized.");
		playerID = ID;
		deck = new Pile();
		hand = new Pile();
		discard = new Pile();

		for(int i=0; i <= 10; i++)
		{
			if(i < 7)
			{
				deck.addCard(new Copper());
			}
			else if(i > 7)
			{
				deck.addCard(new Estate());
			}
		}
	}
	
	public Card drawCard()
	{
		return deck.drawCard();
	}

	public void discardCard(int index)
	{
		discard.addCard(hand.getCard(index));
		hand.removeCard(index);
	}

	public void takeTurn(Dominion game)
	{
		reset();
		for(int i=0; i < 5; i++)
		{
			if(deck.getSize() == 0)
			{
				rebuildDeck();
			}
			hand.addCard(drawCard());
		}
	}


	public void reset()
	{
		buy = 1;
		actions = 1;
		money = 0;
	}

	public void rebuildDeck()
	{
		while(!discard.isEmpty())
		{
			deck.addCard(discard.drawCard());
		}
		deck.shufflePile();
	}

	public void printDeck()
	{
		System.out.println(deck.cards.size());
		for(int i=0; i < deck.cards.size(); i++)
		{	
			deck.cards.get(i).print();
		}
		deck.print();
	}
}	
