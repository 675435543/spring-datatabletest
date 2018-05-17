package com.forezp.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.forezp.entity.P2pLoanTasklog;
import com.forezp.utils.ExportExcel;


@RestController
@RequestMapping("/loantask")
public class P2pLoanTaskController {
  
    @RequestMapping(value = "/helloworld",method = RequestMethod.GET)  
    public ModelAndView helloworld() {  
        // 跳转到 /WEB-INF/views/hello 下的 myTest.jsp 文件；
    	ModelAndView mv = new ModelAndView("singlejsp/helloworldExportExcel");
    	return mv;
    }

    @RequestMapping(value = "/p2ploadXls",method = RequestMethod.GET)  
    public void p2ploadXls(HttpServletResponse response) {  
		//表头
		String[] headers = {  "项目ID","贷款名称","借款人ID","用户名","借款人名称/企业名称","信用等级","客服id","客服名称","年利率","借款期限","借款期限类型","申请日期","成标日期","借款状态","最后修改时间","创建日期"};  
		//数据键名或者MODEL类字段名
		String[] Col = {"tasklogId","loanName","custId","userName","realName","creditGrade","serviceId","serviceName","profitInterest","loanDeadline","loanDeadlineType","createTime","finishTime","status","updateTime","createTime"};

		ExportExcel<P2pLoanTasklog> ex = new ExportExcel<P2pLoanTasklog>();
		//这是model类型的数据  写的例子  暂时不添加数据
		List<P2pLoanTasklog> excelList  = new ArrayList<P2pLoanTasklog>();
		//生成Excel
		HSSFWorkbook workbook = ex.exportExcelXls("sheet1", headers,Col, excelList,null);
		//下载
		response.setContentType("application/vnd.ms-excel");   
		response.setHeader("Content-disposition", "attachment;filename=" + "helloworld.xls"); 
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
    
    @RequestMapping(value = "/p2ploadXlsx",method = RequestMethod.GET)  
    public void p2ploadXlsx(HttpServletResponse response) {  
		//表头
		String[] headers = {  "项目ID","贷款名称","借款人ID","用户名","借款人名称/企业名称","信用等级","客服id","客服名称","年利率","借款期限","借款期限类型","申请日期","成标日期","借款状态","最后修改时间","创建日期"};  
		//数据键名或者MODEL类字段名
		String[] Col = {"tasklogId","loanName","custId","userName","realName","creditGrade","serviceId","serviceName","profitInterest","loanDeadline","loanDeadlineType","createTime","finishTime","status","updateTime","createTime"};

		ExportExcel<P2pLoanTasklog> ex = new ExportExcel<P2pLoanTasklog>();
		//这是model类型的数据  写的例子  暂时不添加数据
		List<P2pLoanTasklog> excelList  = new ArrayList<P2pLoanTasklog>();
		//生成Excel
		XSSFWorkbook workbook = ex.exportExcelXlsx("sheet1", headers,Col, excelList,null);
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
