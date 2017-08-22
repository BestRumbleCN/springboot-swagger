package pri.fly.leaning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import pri.fly.leaning.pojo.UserInfo;

@RestController
@RequestMapping("/users")
@ApiModel("用户相关接口")
public class UserController {
	
	@GetMapping("/{id}")
	@ApiOperation("根据id获取用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户id", dataType = "String", paramType = "query"),
			})
	public UserInfo getUser(@PathVariable("id") Long id){
		return new UserInfo(id,"小明",15);
	}
	
	@GetMapping()
	@ApiOperation("条件查询用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "用户名称", dataType = "String", paramType = "query"),
		})
	public List<UserInfo> getUsers(@RequestParam("name") String name){
		List<UserInfo> result = new ArrayList<UserInfo>();
		result.add(new UserInfo(1l,name+"1",15));
		result.add(new UserInfo(2l,name+"2",17));
		return result;
	}
	
	@PostMapping()
	@ApiOperation("新增一条用户信息")
	public UserInfo addUser(@RequestBody UserInfo user){
		return user;
	}
	
	@PutMapping("/{id}")
	@ApiOperation("修改一条用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户id", dataType = "long", paramType = "path"),
		})
	public UserInfo addUser(@RequestBody UserInfo user,@PathVariable("id") Long id){
		user.setId(id);
		return user;
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("删除一条用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "当前管理员token", dataType = "String",required=true, paramType = "header"),
		@ApiImplicitParam(name = "id", value = "用户id", dataType = "long",required=true, paramType = "path"),
		})
	public void addUser(@RequestHeader("token") String token, @PathVariable("id") Long id){
		System.out.println("删除人token:"+token);
	}
}
