package com.forezp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.forezp.entity.Account;
import com.forezp.service.AccountService2;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
 * Created by fangzhipeng on 2017/4/20.
 */
@RestController
@RequestMapping("/account")
public class AccountController2 {
    @Autowired
    AccountService2 accountService;

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public void transfer(){
        accountService.transfer();
    }
    
    @GetMapping(value = "/getInfo")
    public String getInfo() {
    	return "hello world";
    }
    
    @GetMapping(value = "/findAccountInfo")
    public List<Account> findAccountInfo() {
    	return accountService.findAccountInfo();
    }
    
    @RequestMapping(value = "/findAccountInfoDatatable",method=RequestMethod.GET)
    public JSONObject findAccountInfoDatatable() {
    	JSONObject jsonObject = new JSONObject();
    	List<Account> accountList = new ArrayList<Account>();
    	accountList = accountService.findAccountInfo();
    	jsonObject.put("aaData",JSONArray.fromObject(accountList));
    	return jsonObject;
    }
    
    @RequestMapping(value = "/helloworld",method = RequestMethod.GET)  
    public ModelAndView helloworld() {  
        // 跳转到 /WEB-INF/views/hello 下的 myTest.jsp 文件；
    	ModelAndView mv = new ModelAndView("helloworldSelectAll");
    	/*mv.addObject("mydiv", "liuxuandediv");*/
    	//ModelAndView mv = new ModelAndView("singlejsp/helloworldCheckBoxSelect");
    	return mv;
    }
    
    @RequestMapping(value = "/test1")  
    public JSONObject test1() {  
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("name", "liuxuan1");
    	return jsonObject;
    }
    
    @RequestMapping(value = "/test2")  
    public JSONObject test2() {  
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("name", "liuxuan2");
    	return jsonObject;
    }
    
}
