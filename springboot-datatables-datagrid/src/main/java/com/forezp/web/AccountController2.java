package com.forezp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.forezp.dao.UserInfoDao;
import com.forezp.entity.Account;
import com.forezp.entity.UserInfo;
import com.forezp.service.AccountService2;
import com.forezp.service.SendEmailService;

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
    
    @Autowired
    UserInfoDao userInfoDao;
    
    @Autowired
    SendEmailService sendEmailService;
    
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
    	//ModelAndView mv = new ModelAndView("helloworldSelectAll");
    	/*mv.addObject("mydiv", "liuxuandediv");*/
    	ModelAndView mv = new ModelAndView("singlejsp/helloworldjqueryui");
    	String toMailsProcess[] = {"675435543@qq.com","516412893@qq.com"};
    	String ccMailsProcess[] = {"675435543@qq.com","516412893@qq.com"};
    	String subject = "小宝你好，这是一封测试邮件！";
    	String emailContentDetail = "haha";
    	
    	boolean sendResult = true;
/*    	sendResult = sendEmailService.problemListSendEmail(toMailsProcess, ccMailsProcess, subject, emailContentDetail, problemListSelected,null,"toDoRemind");
    	if (true == sendResult)
    	{
    		System.out.println("邮件发送成功！");
    	}*/

    	return mv;
    }
    
    @RequestMapping(value = "/helloworld2",method = RequestMethod.GET)  
    public ModelAndView helloworld2() {  
        // 跳转到 /WEB-INF/views/hello 下的 myTest.jsp 文件；
    	ModelAndView mv = new ModelAndView("helloworldSelectAll");
/*    	mv.addObject("mydiv", "liuxuandediv");*/
    	return mv;
    }
    
    
    @RequestMapping(value = "/helloworldjqueryui",method = RequestMethod.GET)  
    public JSONObject helloworldjqueryui(@RequestParam("userId") String name) {  

    	List<UserInfo> userInfoList = userInfoDao.findUserInfoBynameLike("%"+name.trim()+"%");
    	JSONObject jsonObject = new JSONObject();
    	
    	jsonObject.put("userInfoList", userInfoList);
    	return jsonObject;
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
    
    
/*    
    @RequestMapping(value = "sendWeeklyTemplet", method = RequestMethod.POST)
    public ResultData<String> sendWeeklyTemplet(@Validated ProblemList problemList, BindingResult bindingResult,
    	@RequestParam("problemScreenshot") List<MultipartFile> problemScreenshot, @RequestParam("mailTo") String mailTo,
    	@RequestParam("mailCc") String mailCc, @RequestParam("subject") String subject,
    	@RequestParam("selectedEmailIds") String selectedEmailIds, HttpServletRequest request)
    {
    	
    	String[] toMails = null;
    	if(StringUtils.isNotEmpty(mailTo))
    	{
    		toMails = mailTo.split(",");
    	}
    	String mergeStr = "";
    	String[] toMailsProcess = null;
    	List<String> toMailslist = new ArrayList<String>(); 
    	List<UserSearchItem> UserSearchItemlist = null;
    	if(toMails != null && toMails.length >= 1)
    	{
    		for(int i = 0; i < toMails.length; i++)
    		{
    			mergeStr = RegexUtils.mergeBlank(toMails[i]);
    			if(mergeStr.lastIndexOf(" ") != -1 && mergeStr.indexOf(" ") != mergeStr.lastIndexOf(" "))
    			{
    				UserSearchItemlist  = UserSeacher.search(mergeStr.substring(0, mergeStr.lastIndexOf(" ")));
    				if(CollectionUtils.isNotEmpty(UserSearchItemlist))
    				{
    					if(!toMailslist.contains(UserSearchItemlist.get(0).getMail()))
    					{
    						toMailslist.add(UserSearchItemlist.get(0).getMail());
    					}
    				}
    			}
    		}
    	}
    	toMailsProcess = (String[])toMailslist.toArray(new String[toMailslist.size()]);
    	
    	String[] ccMails = null;
    	if(StringUtils.isNotEmpty(mailCc))
    	{
    		ccMails = mailCc.split(",");
    	}
    	String[] ccMailsProcess = null;
    	List<String> ccMailslist = new ArrayList<String>(); 
    	if(ccMails != null && ccMails.length >= 1)
    	{
    		for(int i = 0; i < ccMails.length; i++)
    		{
    			mergeStr = RegexUtils.mergeBlank(ccMails[i]);
    			if(mergeStr.lastIndexOf(" ") != -1 && mergeStr.indexOf(" ") != mergeStr.lastIndexOf(" "))
    			{
    				UserSearchItemlist  = UserSeacher.search(mergeStr.substring(0, mergeStr.lastIndexOf(" ")));
    				if(CollectionUtils.isNotEmpty(UserSearchItemlist))
    				{
    					if(!ccMailslist.contains(UserSearchItemlist.get(0).getMail()))
    					{
    						ccMailslist.add(UserSearchItemlist.get(0).getMail());
    					}
    				}
    			}
    		}
    	}
    	ccMailsProcess = (String[])ccMailslist.toArray(new String[ccMailslist.size()]);
    	
    	String[] selectedEmailIdArry = null;
    	if(StringUtils.isNotEmpty(selectedEmailIds))
    	{
    		selectedEmailIdArry = selectedEmailIds.trim().split(",");
    	}
    	List<String> selectedEmailIdList = new ArrayList<String>();
    	for (String selectedEmailId : selectedEmailIdArry)
    	{
    		if (!selectedEmailIdList.contains(selectedEmailId))
    		{
    			selectedEmailIdList.add(selectedEmailId);
    		}
    	}
    	//选中的数据列表
    	List<ProblemList> problemListSelected = problemListService.findProblemListSelected(selectedEmailIdList);

    	String emailContentDetail = "测试邮件的正文";
    	boolean sendResult = false;
    	ResultData<String> result = new ResultData<>();
    	
    	if(toMailsProcess==null || (toMailsProcess!=null && toMailsProcess.length==0))
    	{
    		result.setStatus(CommonsConstants.RESULT_ERROR);
    		result.setMassage("查询不到收件人信息 !");
    	}
    	else
    	{
    		sendResult = problemListService
    			.problemListSendEmail(toMailsProcess, ccMailsProcess, subject, emailContentDetail, problemListSelected,null,WEEKLY_TEMPLET);
    		if (true == sendResult)
    		{
    			result.setStatus(CommonsConstants.RESULT_SUCCESS);
    		}
    		else
    		{
    			result.setStatus(CommonsConstants.RESULT_ERROR);
    		}
    	}
    	return result;
    }*/
}
