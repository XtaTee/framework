package jac.dev.trigger;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import jac.dev.trigger.dao.Customer;
import jac.dev.trigger.query.CustomerRepository;

/**
 * @author jacryd
 **/
@SpringBootApplication
public class XtaTeeExecutor implements CommandLineRunner {
		
    @Autowired
    DataSource dataSource;

    @Autowired
    CustomerRepository customerRepository;
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(XtaTeeExecutor.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String... args) throws Exception {
    	 final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    

    	        System.out.println("DATASOURCE = " + dataSource);

    	        System.out.println("\n1.findAll()...");
    	        for (Customer customer : customerRepository.findAll()) {
    	            System.out.println(customer);
    	        }

    	        System.out.println("\n2.findByEmail(String email)...");
    	        for (Customer customer : customerRepository.findByEmail("222@yahoo.com")) {
    	            System.out.println(customer);
    	        }

    	        System.out.println("\n3.findByDate(Date date)...");
    	        for (Customer customer : customerRepository.findByDate(sdf.parse("2017-02-12"))) {
    	            System.out.println(customer);
    	        }

    	        // For Stream, need @Transactional
    	        System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
    	        try (Stream<Customer> stream = customerRepository.findByEmailReturnStream("333@yahoo.com")) {
    	            stream.forEach(x -> System.out.println(x));
    	        }

    	        System.out.println("Done!");

    }

}
