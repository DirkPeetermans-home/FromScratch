package be.abis.exc1b.ut;

import be.abis.exc1b.exception.PersonShouldBeAdultException;
import be.abis.exc1b.model.Address;
import be.abis.exc1b.model.Company;
import be.abis.exc1b.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;



import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

	Person p;
	@Mock Company MockCompany;

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

	@Test
	public void calculateNetSalaryOfBelgianPersonUsingMockCompany() {

		//Address addr1 = new Address("Broekstraat", "30", "1000", "Brussel", "België", "BE");
		//Company comp1 = new Company("Fortis", addr1);
		Person p3 = new Person(3,"Jane","Smith",LocalDate.of(2007, 8, 10),MockCompany,1000);
		when(MockCompany.calculateTaxToPay()).thenReturn(51.0);
		assertThat(p3.calculateNetSalary(), is (equalTo(490.0)));

	}

}
