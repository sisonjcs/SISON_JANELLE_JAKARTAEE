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

    private static final long serialVersionUID = 1L;

    private int id;

    @NotBlank(message = "You cannot leave the title blank.")
    private String newTitle;
    private String newDetail;

    @Inject
    private ReportRepository reportRepository;

    public String update(int id) {
        this.id = id;
        ReportDto report = reportRepository.findById(id);
        this.newTitle = report.getTitle();
        this.newDetail = report.getDetail();
        return "/reportUpdate.xhtml?faces-redirect=true";
    }

    public String save() {
        reportRepository.update(id, newTitle, newDetail);
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
