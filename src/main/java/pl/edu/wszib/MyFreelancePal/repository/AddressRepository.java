package pl.edu.wszib.MyFreelancePal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


}
