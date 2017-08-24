package pri.fly.leaning.controller.teacher;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pri.fly.leaning.config.Manager;

@RestController
@RequestMapping("/teacher/students")
@Api(tags = {"1.0.3"},description = "老师-班级学生管理接口")
@Manager
public class StudentController {
	
	@PostMapping
	@ApiOperation("添加一个学生信息")
	public void addStudent(){
	}
}
