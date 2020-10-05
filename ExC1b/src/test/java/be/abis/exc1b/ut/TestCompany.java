package be.abis.exc1b.ut;

import be.abis.exc1b.model.Address;
import be.abis.exc1b.model.Company;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCompany {

    @Test
    public void taxForBelgianCompanyShouldBe51() {

        Address addr1 = new Address("Broekstraat", "30", "1000", "Brussel", "België", "BE");
        Company comp1 = new Company("Fortis", addr1);

        double tax = comp1.calculateTaxToPay();

        //assertEquals(51.0, tax);
        assertThat(tax,equalTo(51.0));

    }
}


