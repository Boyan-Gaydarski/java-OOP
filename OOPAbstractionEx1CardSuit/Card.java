package OOPAbstractionEx1CardSuit;

public class Card {

    private CardRank number;
    private CardSuit color;
    private int power;

    public Card(CardRank number, CardSuit color) {
        this.number = number;
        this.color = color;
        this.power = number.getRankPower() + color.getSuitPower();
    }

    public int getPower() {
        return this.power;
    }
}
