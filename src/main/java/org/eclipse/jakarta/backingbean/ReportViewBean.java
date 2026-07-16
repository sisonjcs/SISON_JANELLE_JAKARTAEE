package org.eclipse.jakarta.backingbean;

import java.io.Serializable;

import org.eclipse.jakarta.dto.ReportDto;
import org.eclipse.jakarta.infrastracture.repository.ReportRepository;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ReportViewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ReportDto report;
	
	@Inject
	private ReportRepository reportRepository;
	
	public String view(int id) {
		this.report = reportRepository.findById(id);
		return "/reportView.xhtml?faces-redirect=true";
	}
	
	public String getTitle() {
		return report.getTitle();
	}
	
	public String getDetail() {
		return report.getDetail();
	}
}
