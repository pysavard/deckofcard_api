package com.py.deckofcard.restapi.deck.entity.enums;

import com.py.deckofcard.restapi.TestBase;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SuitsTest extends TestBase {

    @Test
    public void getName_whenHearts_ShouldBeHearts()
    {
        Suits sut = Suits.Hearts;

        String result = sut.getName();

        assertThat(result).isEqualTo("Heart");
    }

    @Test
    public void getValue_whenHearts_ShouldBe_1(){
        Suits sut = Suits.Hearts;

        int  result = sut.getValue();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getName_whenSpades_ShouldBeSpades()
    {
        Suits sut = Suits.Spades;

        String result = sut.getName();

        assertThat(result).isEqualTo("Spade");
    }

    @Test
    public void getValue_whenSpades_ShouldBe_2(){
        Suits sut = Suits.Spades;

        int  result = sut.getValue();

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getName_whenClubs_ShouldBeClubs()
    {
        Suits sut = Suits.Clubs;

        String result = sut.getName();

        assertThat(result).isEqualTo("Club");
    }

    @Test
    public void getValue_whenClubs_ShouldBe_3(){
        Suits sut = Suits.Clubs;

        int  result = sut.getValue();

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getName_whenDiamonds_ShouldBeDiamonds()
    {
        Suits sut = Suits.Diamonds;

        String result = sut.getName();

        assertThat(result).isEqualTo("Diamond");
    }

    @Test
    public void getValue_whenDiamonds_ShouldBe_4(){
        Suits sut = Suits.Diamonds;

        int  result = sut.getValue();

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void valueOf_1_ShouldBeHearts(){
        Suits result = Suits.valueOf(1);

        assertThat(result).isEqualTo(Suits.Hearts);
    }

    @Test
    public void valueOf_2_ShouldBeSpades(){
        Suits result = Suits.valueOf(2);

        assertThat(result).isEqualTo(Suits.Spades);
    }

    @Test
    public void valueOf_3_ShouldBeClubs(){
        Suits result = Suits.valueOf(3);

        assertThat(result).isEqualTo(Suits.Clubs);
    }

    @Test
    public void valueOf_4_ShouldBeDiamonds(){
        Suits result = Suits.valueOf(4);

        assertThat(result).isEqualTo(Suits.Diamonds);
    }

}
