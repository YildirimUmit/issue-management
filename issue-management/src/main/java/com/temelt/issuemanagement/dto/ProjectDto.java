package com.temelt.issuemanagement.dto;


import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by temelt on 4.02.2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
    @ApiModelProperty(required = false,value = "ID Of Project")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,value = "Name Of Project")
    private String projectName;
    @NotNull
    @ApiModelProperty(required = true,value = "Code Of Project")
    private String projectCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

}
