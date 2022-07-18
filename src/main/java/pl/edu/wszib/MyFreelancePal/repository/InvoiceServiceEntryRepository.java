package pl.edu.wszib.MyFreelancePal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface InvoiceServiceEntryRepository extends JpaRepository<InvoiceServiceEntry, Integer> {

    List<InvoiceServiceEntry> findAllByInvoice_Id(Integer id);

//    @Nullable
//    @Query(value = "SELECT invoice.id, sum(preTaxAmount) from InvoiceServiceEntry group by invoice.id")
//    Map<Integer, BigDecimal> totalPreTaxAmountByInvoiceId();


}
