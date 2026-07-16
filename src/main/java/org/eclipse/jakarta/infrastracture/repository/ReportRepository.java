package org.eclipse.jakarta.infrastracture.repository;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jakarta.dto.ReportDto;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReportRepository {
    private List<ReportDto> reports = new ArrayList<>();
    private int nextId = 1;

    public List<ReportDto> findAll() {
        return reports;
    }

    public ReportDto findById(int id) {
    	for (ReportDto report : reports) {
    		if (report.getId() == id) {
    			return report;
    		}
    	}
    	return null;
    }
    
    public void create(ReportDto report) {
        report.setId(nextId++);
        reports.add(report);
    }

    public void update(int id, String newTitle, String newDetail) {
    	ReportDto report = findById(id);
    	if (report != null) {
    		report.setTitle(newTitle);
    		report.setDetail(newDetail);    		
    	}
    }

    public void delete(int id) {
    	ReportDto report = findById(id);
    	
    	if (report != null) {
    		reports.remove(findById(id));    		
    	}
    }
    
    
}
