package org.eclipse.jakarta.backingbean;

import java.io.Serializable;

import org.eclipse.jakarta.dto.ReportDto;
import org.eclipse.jakarta.infrastracture.repository.ReportRepository;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;

@Named
@SessionScoped
public class ReportUpdateBean implements Serializable {

    @NotBlank(message = "You cannot leave the title blank.")
    private String newTitle;
    private String newDetail;

    private ReportDto report;

    @Inject
    private ReportRepository reportRepository;

    public String update(ReportDto report) {
        this.report = report;
        this.newTitle = report.getTitle();
        this.newDetail = report.getDetail();
        return "/reportUpdate.xhtml?faces-redirect=true";
    }

    public String save() {
        reportRepository.update(report, newTitle, newDetail);
        return "/reportList.xhtml?faces-redirect=true";
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewDetail() {
        return newDetail;
    }

    public void setNewDetail(String newDetail) {
        this.newDetail = newDetail;
    }
}
