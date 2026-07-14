package org.eclipse.jakarta.backingbean;

import java.io.Serializable;

import org.eclipse.jakarta.dto.ReportDto;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ReportViewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ReportDto report;
	
	public String view(ReportDto report) {
		this.report = report;
		return "/reportView.xhtml?faces-redirect=true";
	}
	
	public String getTitle() {
		return report.getTitle();
	}
	
	public String getDetail() {
		return report.getDetail();
	}
}
