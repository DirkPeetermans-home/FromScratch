package be.abis.exc1a.ut;

import be.abis.exb4.exception.PersonShouldBeAdultException;
import be.abis.exb4.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPerson {

	Person p;

	@Before
	public void setUp(){
		p = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
	}

	@Test
	public void testCalculateAge() throws PersonShouldBeAdultException {
		assertThat(p.calculateAge(), is (equalTo(53)));
	}

	@Test
	public void toStringSentenceStartsWithPerson(){
		String sentence = p.toString();
		assertThat(sentence, startsWith("Person"));
	}

	@Test(expected= PersonShouldBeAdultException.class)
	public void calculateAgeShouldThrowExceptionWhenPersonNotAdult() throws PersonShouldBeAdultException {
		Person p2 = new Person(2,"Jane","Smith",LocalDate.of(2007, 8, 10));
		p2.calculateAge();
	}

}
