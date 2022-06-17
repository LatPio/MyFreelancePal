package pl.edu.wszib.MyFreelancePal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Address;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


    List<Address> findByEmployee_id(Integer id);
    List<Address> findByEmployer_id(Integer id);


}
