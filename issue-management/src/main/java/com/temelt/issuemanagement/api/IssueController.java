package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.impl.IssueServiceImpl;
import com.temelt.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CRTL)
@Api( value=ApiPaths.IssueCtrl.CRTL,description ="Issue Api")
public class IssueController {
    private final IssueServiceImpl IssueServiceImpl;


    public IssueController(IssueServiceImpl IssueServiceImpl) {
        this.IssueServiceImpl = IssueServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "GetById Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value="id",required=true) Long id){//required  bos veri gelmesin
        IssueDto IssueDto= IssueServiceImpl.getById(id);
        return ResponseEntity.ok(IssueDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto>  cerateIssue(@Valid @RequestBody IssueDto Issue){ // @NotNull u kullana ilmeki icin  @Valid kullanmak gerek
        return ResponseEntity.ok(IssueServiceImpl.save(Issue));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto>  updateIssue(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody IssueDto Issue){   // required = true bos veri gelmesin demek
        return ResponseEntity.ok(IssueServiceImpl.update(id,Issue));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delet Operation",response = Boolean.class)
    public ResponseEntity<Boolean> deleteIssue(@PathVariable(value="id",required=true) Long id){
        return  ResponseEntity.ok(IssueServiceImpl.delete(id));
    }

}
