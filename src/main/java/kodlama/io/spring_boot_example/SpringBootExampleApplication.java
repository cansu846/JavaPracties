package kodlama.io.spring_boot_example;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor  //when not in use give error, because 'customerRepository' is null

public class SpringBootExampleApplication {

	private CustomerRepository customerRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootExampleApplication.class, args);
	}
	@GetMapping
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	@PostMapping
	public void addCustomer(@RequestBody Customer customer){
		customerRepository.save(customer);
	}
	@DeleteMapping("{id}")
	public void deleteCustomer(@PathVariable Integer id){
		customerRepository.deleteById(id);
	}
	@PutMapping()
	public void updateCustomer(Customer customer){
		customerRepository.save(customer);
	}
}
