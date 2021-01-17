package com.temelt.issuemanagement.api;

        import com.temelt.issuemanagement.dto.ProjectDto;
        import com.temelt.issuemanagement.service.impl.ProjectServiceImpl;
        import com.temelt.issuemanagement.util.ApiPaths;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CRTL)
@Api( value=ApiPaths.ProjectCtrl.CRTL,description ="Project Api")
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;


    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "GetById Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value="id",required=true) Long id){//required  bos veri gelmesin
        ProjectDto projectDto= projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto>  cerateProject(@Valid @RequestBody ProjectDto project){ // @NotNull u kullana ilmeki icin  @Valid kullanmak gerek
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto>  updateProject(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody ProjectDto project){   // required = true bos veri gelmesin demek
        return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delet Operation",response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value="id",required=true) Long id){
        return  ResponseEntity.ok(projectServiceImpl.delete(id));
    }

}
