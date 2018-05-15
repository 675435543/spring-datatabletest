package com.forezp.service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.forezp.utils.ExportExcel;

@Service
public class ExportExcelService {
	public static void main(String[] args) {
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
		response.setHeader("Content-disposition", "attachment;filename=" + exportExcelFileName);   
		OutputStream ouputStream = response.getOutputStream();   
		workbook.write(ouputStream);   
		ouputStream.flush();   
		ouputStream.close();
	}
}
