package com.bankapplication.demo.repository;

import java.util.List;

import com.bankapplication.demo.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

	@Query(value = "SELECT * FROM notice_details n WHERE CURDATE() BETWEEN notic_beg_dt AND notic_end_dt", nativeQuery = true)
	List<Notice> findAllActiveNotices();

}
