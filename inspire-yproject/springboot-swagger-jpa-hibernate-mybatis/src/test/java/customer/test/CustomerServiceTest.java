package customer.test;

import com.javainuse.swaggertest.Application;
import com.javainuse.swaggertest.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;


    @Test
    public void testGetCustomer() {
        System.out.println(customerService.getCustomer(1));
    }
}
