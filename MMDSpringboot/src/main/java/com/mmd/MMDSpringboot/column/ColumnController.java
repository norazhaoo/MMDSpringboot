package com.mmd.MMDSpringboot.column;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("column")
public class ColumnController {

	private ColumnService columnService;

	public ColumnController(ColumnService columnService) {
		super();
		this.columnService = columnService;
	}

	//GET /column
	@GetMapping
	public List<ColumnModel> getAllColumns(){
		return columnService.getAllColumns();
	}
	
	@PostMapping("/addColumn")
	public Long addColumn(@RequestBody ColumnModel columnModel, HttpServletResponse httpResponse) {
		Long id = columnService.addColumn(columnModel);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return id;
	}
	
	@PutMapping("/updateColumn/{columnId}")
	public Long updateColumn(@PathVariable Long columnId, @Valid @RequestBody ColumnModel columnModel) {
		return columnService.updateColumn(columnId, columnModel);
	}	
	
}
