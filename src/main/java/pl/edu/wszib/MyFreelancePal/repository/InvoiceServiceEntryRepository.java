package pl.edu.wszib.MyFreelancePal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;

@Repository
public interface InvoiceServiceEntryRepository extends JpaRepository<InvoiceServiceEntry, Integer> {
}
