package com.forezp.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.forezp.entity.Account;
import com.forezp.entity.P2pLoanTasklog;
import com.forezp.service.AccountService2;
import com.forezp.utils.ExportExcel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@RestController
@RequestMapping("/loantask")
public class P2pLoanTaskController {
    @Autowired
    AccountService2 accountService;

    
    @RequestMapping(value = "/findAccountInfoDatatable",method=RequestMethod.GET)
    public JSONObject findAccountInfoDatatable() {
    	JSONObject jsonObject = new JSONObject();
    	List<Account> accountList = new ArrayList<Account>();
    	accountList = accountService.findAccountInfo();
    	jsonObject.put("aaData",JSONArray.fromObject(accountList));
    	return jsonObject;
    }
    
    @RequestMapping(value = "/p2pload",method = RequestMethod.GET)  
    public void p2pload(HttpServletResponse response) {  
/*        // 跳转到 /WEB-INF/views/hello 下的 myTest.jsp 文件；
    	ModelAndView mv = new ModelAndView("helloworldOptions");
    	mv.addObject("mydiv", "liuxuandediv");
    	//ModelAndView mv = new ModelAndView("singlejsp/helloworldjspingjie");
    	return mv;*/
		//表头
		String[] headers = {  "项目ID","贷款名称","借款人ID","用户名","借款人名称/企业名称","信用等级","客服id","客服名称","年利率","借款期限","借款期限类型","申请日期","成标日期","借款状态","最后修改时间","创建日期"};  
		//数据键名或者MODEL类字段名
		String[] Col = {"tasklogId","loanName","custId","userName","realName","creditGrade","serviceId","serviceName","profitInterest","loanDeadline","loanDeadlineType","createTime","finishTime","status","updateTime","createTime"};

		ExportExcel<P2pLoanTasklog> ex = new ExportExcel<P2pLoanTasklog>();
		//这是model类型的数据  写的例子  暂时不添加数据
		List<P2pLoanTasklog> excelList  = new ArrayList<P2pLoanTasklog>();
		//生成Excel
		HSSFWorkbook workbook = ex.exportExcel("sheet1", headers,Col, excelList,null);
		//下载
		response.setContentType("application/vnd.ms-excel");   
		response.setHeader("Content-disposition", "attachment;filename=" + "helloworld.xlsx");   
		OutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			workbook.write(ouputStream);   
			ouputStream.flush();   
			ouputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

    }
    

    
}
