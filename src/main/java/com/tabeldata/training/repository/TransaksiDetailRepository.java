package com.tabeldata.training.repository;

import com.tabeldata.training.entity.TransaksiDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransaksiDetailRepository extends PagingAndSortingRepository<TransaksiDetails, String> {
}
