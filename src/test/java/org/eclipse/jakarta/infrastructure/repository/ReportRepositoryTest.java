package org.eclipse.jakarta.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.eclipse.jakarta.dto.ReportDto;
import org.eclipse.jakarta.infrastracture.repository.ReportRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportRepositoryTest {

	private ReportRepository reportRepository;
	private ReportDto testReport1;
	private ReportDto testReport2;
	
	@BeforeEach
	void setup() {
		reportRepository = new ReportRepository();
		testReport1 = new ReportDto();
		testReport1.setTitle("Test1");
		testReport1.setDetail("Test1 Detail");
		
		testReport2 = new ReportDto();
		testReport2.setTitle("Test2");
		testReport2.setDetail("Test2 Detail");
	}
	
	@AfterEach
	void teardown() {
		reportRepository = null;
		testReport1 = null;
		testReport2 = null;
	}
	
	@Test
	void testCreate() {
		reportRepository.create(testReport1);
		reportRepository.create(testReport2);
		
		assertNotNull(reportRepository.findAll());
		assertEquals(2, reportRepository.findAll().size());
		assertEquals(1, testReport1.getId());
		assertEquals(2, testReport2.getId());
	}
	
	@Test
	void testDeleteOne() {
		reportRepository.create(testReport1);
		reportRepository.create(testReport2);
		
		reportRepository.delete(1);
		
		assertNotNull(reportRepository.findAll());
		assertEquals(1, reportRepository.findAll().size());
		assertEquals(2, testReport2.getId());
	}
	
	@Test
	void testDeleteAll() {
		reportRepository.create(testReport1);
		reportRepository.create(testReport2);
		
		reportRepository.delete(1);
		reportRepository.delete(2);
		
		assertNotNull(reportRepository.findAll());
		assertEquals(0, reportRepository.findAll().size());
	}
	
	@Test
	void testUpdate() {
		reportRepository.create(testReport1);
		
		reportRepository.update(1, "New Title", "New report detail");
		
		assertNotNull(reportRepository.findAll());
		assertEquals(1, reportRepository.findAll().size());
		assertEquals("New Title", testReport1.getTitle());
		assertEquals("New report detail", testReport1.getDetail());
	}
	
	@Test
	void testView() {
		reportRepository.create(testReport1);
		reportRepository.create(testReport2);
		
		ReportDto viewResult = reportRepository.findById(1);
		
		assertNotNull(viewResult);
		assertEquals(1, viewResult.getId());
		assertEquals("Test1", viewResult.getTitle());
		assertEquals("Test1 Detail", viewResult.getDetail());
		
		assertNull(reportRepository.findById(5));
	}
}
