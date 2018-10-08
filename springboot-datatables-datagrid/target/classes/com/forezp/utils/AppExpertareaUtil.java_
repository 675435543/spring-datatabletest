package com.forezp.utils;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONObject;
import com.huawei.rdsearch.biz.UserDepartNameService;
import com.huawei.rdsearch.biz.UserExpertareaService;
import com.huawei.rdsearch.controller.SynonymsController;
import com.huawei.rdsearch.entity.UserExpertarea;
import com.huawei.rdsearch.vo.ExpertTempVo;
import com.huawei.rdsearch.vo.ReportMsgVo;

/**
 * 
 *
 */
public final class AppExpertareaUtil
{
    // APP,专家定制导入线程池
    private static ExecutorService importThreadPool = Executors.newCachedThreadPool();
    // 定时清空APP,专家定制导入错误提示文件夹
    private static ScheduledExecutorService deleteFileThreadPool = Executors.newScheduledThreadPool(1);

    protected static final Logger LOG = Logger.getLogger(AppExpertareaUtil.class);

    /**
     * excel的第14列
     */
    private static final Integer NUM_13 = 3;

    /**
     * excel的第15列
     */
    private static final Integer NUM_14 = 4;

    /**
     * 构造方法
     */
    public AppExpertareaUtil()
    {

    }

    /**
     * @param fileName
     *            String
     * @param inputStream
     *            InputStream
     * @param originUser
     *            String
     * @throws IOException
     *             IOException
     */
    public static void importExpertarea(String fileName, InputStream inputStream, String originUser) throws IOException
    {
        importThreadPool.execute(new Runnable()
        {
            @Override
            public void run()
            {
                UserExpertareaService userExpertareaServiceImpl = (UserExpertareaService) Util
                        .getBeanByName("userExpertareaServiceImpl");
                List<RowValueClassType> classTypeList = new ArrayList<>();
                // 模板共13列
                for (int i = 0; i < NumConstants.NUM_13; i++)
                {
                    classTypeList.add(RowValueClassType.String);
                }
                List<Object[]> parseExcel = null;
                try
                {
                    parseExcel = PoiUtil.parseExcel(fileName, inputStream, classTypeList, null, false,
                            NumConstants.NUM_3);
                }
                catch (Exception e1)
                {
                    sendWarningMail(originUser);
                    e1.printStackTrace();
                    return;
                }
                ReportMsgVo msg = new ReportMsgVo();
                StringBuilder importMsg = new StringBuilder();
                Object[] title = null, subject = null;
                msg.getRecord().add(title);
                msg.getRecord().add(subject);
                importExpertareas(userExpertareaServiceImpl, parseExcel, msg);
                SXSSFWorkbook sxssfWorkbook = new AppExpertareaUtil().getExpertModelExcel("领域专家邮件附件模板.xlsx");
                Workbook exportWorkBook = PoiUtil.exportWorkBook(msg.getRecord(), sxssfWorkbook, null);
                importMsg.append("<font>导入成功").append(parseExcel.size() - msg.getFailCount()).append("个专家,</font>")
                        .append("<font>导入失败").append(msg.getFailCount().toString()).append("个专家,</font>")
                        .append("<font>详情请在附件中查看</font><br>");
                Date date = new Date();
                SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                String fileName = "领域专家定制导入详情表_" + formate.format(date);
                String errorMsgExcelPath = "";
                try
                {
                    errorMsgExcelPath = SysConfig.getIndexConfig("synonyms.errorMsgExcelPath") + "/"
                            + new String(fileName.getBytes("UTF-8"), "utf-8") + ".xlsx";
                }
                catch (UnsupportedEncodingException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                File file = new File(SysConfig.getIndexConfig("synonyms.errorMsgExcelPath"));
                if (!file.exists())
                {
                    boolean check = file.mkdirs();
                    if (check)
                    {
                        System.out.println("创建了文件路径为：" + file.getAbsolutePath());
                    }
                }
                PoiUtil.writeToFile(errorMsgExcelPath, exportWorkBook);
                // 发送结果邮件
                UserDepartNameService userDepartNameServiceImpl = (UserDepartNameService) Util
                        .getBeanByName("userDepartNameServiceImpl");
                String mail = userDepartNameServiceImpl.queryEmployeeMail(originUser);
                String mailTitle = "";
                String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                mailTitle = "领域专家定制导入结果(" + dateFormat + ")：全部成功！";
                if (msg.getFailCount() > 0)
                {
                    mailTitle = "领域专家定制导入结果(" + dateFormat + ")：本次导入部分失败！";
                }
                MailUtil.sendMail("领域专家定制导入信息", mailTitle, importMsg.toString(), "true", mail, "", errorMsgExcelPath,
                        "xlsx");
                deleteTempFile();
                // 筛选专家工号
                Set<String> userNum = new HashSet<>();
                for (String expert : msg.getUserIds())
                {
                    List<JSONObject> jsons = splitExpert(expert);
                    for (JSONObject json : jsons)
                    {
                        userNum.add(json.getString("userId").toLowerCase());
                    }
                }
                // 给专家发邮件
                sendMail(userNum);
            }
        });
    }

    private static void importExpertareas(UserExpertareaService userExpertareaServiceImpl, List<Object[]> parseExcel,
            ReportMsgVo msg)
    {
        ExpertTempVo ex = new ExpertTempVo();
        ex.setExpert("");
        ex.setLastKeyword("");
        ex.setStatus(false);
        ex.setList(userExpertareaServiceImpl.findAllKeyWord());
        for (int i = 0; i < parseExcel.size(); i++)
        {

            Object[] temp = parseExcel.get(i);
            msg.getRecord().add(insertMsg(temp, "", ""));
            String readKeyword = (String) temp[0];
            // 搜索关键字不为空，代表是新的关键字
            if (StringUtils.isNotBlank(readKeyword))
            {
                afterKeyword(userExpertareaServiceImpl, parseExcel, msg, ex, i, temp, readKeyword);
            }
            else
            {
                // 搜索关键字为空，代表没读完
                // 读专家列
                String readExpertName = "";
                if (temp[1] != null)
                {
                    readExpertName = temp[1].toString();
                }
                // 搜索关键字和专家列都为空，跳下一行数据
                if (StringUtils.isBlank(readExpertName))
                {
                    importDB(userExpertareaServiceImpl, parseExcel, msg, ex, i);
                }
                else
                {
                    afterExpert(userExpertareaServiceImpl, parseExcel, msg, ex, i, temp, readExpertName);
                }

            }
        }
    }

    private static void afterExpert(UserExpertareaService userExpertareaServiceImpl, List<Object[]> parseExcel,
            ReportMsgVo msg, ExpertTempVo ex, int i, Object[] temp, String readExpertName)
    {
        // 进行工号和姓名检验
        JSONObject respInfo = checkNameAndNumber(readExpertName);
        String check = respInfo.getString("check").toLowerCase();
        // 工号和姓名检验不通过
        if (check.equals("false"))
        {
            msg.getRecord().get(msg.getRecord().size() - 1)[NUM_13] = "否";
            msg.getRecord().get(msg.getRecord().size() - 1)[NUM_14] = "姓名和工号检验不通过";
            msg.setFailCount(msg.getFailCount() + 1);
            // 数据异常，记录状态为false，不再读取
            ex.setStatus(false);
        }
        else
        {
            msg.getRecord().get(msg.getRecord().size() - 1)[NUM_13] = "是";
            String expert = ex.getExpert() + "," + respInfo.getString("userName").toString() + "@"
                    + respInfo.getString("userId").toString();
            String readRecommens = fillRecomment(temp);
            expert = expert + "#" + readRecommens.toString();
            ex.setExpert(expert);
            // 成功读入专家列和推荐指数列，记录状态为true
            ex.setStatus(true);
            // status = true;
            // 判断是不是最后一列
            if (i == parseExcel.size() - 1)
            {
                addToDatabase(userExpertareaServiceImpl, msg, ex);
            }
        }
    }

    private static void afterKeyword(UserExpertareaService userExpertareaServiceImpl, List<Object[]> parseExcel,
            ReportMsgVo msg, ExpertTempVo ex, int i, Object[] temp, String readKeyword)
    {
        // status为true,代表上条关键字无异常，进行入库操作
        if (ex.getStatus())
        {
            addToDatabase(userExpertareaServiceImpl, msg, ex);
        }
        else
        {
            // 清掉expert
            ex.setExpert("");
            // 清掉上一个关键词
            ex.setLastKeyword("");
        }
        // 读专家列
        String readExpertName = "";
        if (temp[1] != null)
        {
            readExpertName = temp[1].toString();
        }
        if (StringUtils.isBlank(readExpertName))
        {
            msg.getRecord().get(msg.getRecord().size() - 1)[NUM_13] = "否";
            msg.getRecord().get(msg.getRecord().size() - 1)[NUM_14] = "专家（姓名+工号）列不能为空";
            msg.setFailCount(msg.getFailCount() + 1);
            ex.setLastKeyword(readKeyword);
            // 数据异常，记录状态为false，不再读取
            ex.setStatus(false);
        }
        else
        {
            // 进行工号和姓名检验
            JSONObject respInfo = checkNameAndNumber(readExpertName);
            String check = respInfo.getString("check").toLowerCase();
            // 工号和姓名检验不通过
            if (check.equals("false"))
            {
                msg.getRecord().get(msg.getRecord().size() - 1)[NUM_14] = "姓名和工号检验不通过";
                msg.getRecord().get(msg.getRecord().size() - 1)[NUM_13] = "否";
                msg.setFailCount(msg.getFailCount() + 1);
                ex.setLastKeyword(readKeyword);
                // 数据异常，记录状态为false，不再读取
                ex.setStatus(false);
            }
            else
            {
                msg.getRecord().get(msg.getRecord().size() - 1)[NUM_13] = "是";
                String expert = "," + respInfo.getString("userName").toString() + "@"
                        + respInfo.getString("userId").toString();
                String readRecommens = fillRecomment(temp);
                expert = expert + "#" + readRecommens.toString();
                ex.setExpert(expert);
                // 记录关键字
                // 判读是不是最后一列
                if (i == parseExcel.size() - 1)
                {
                    ex.setLastKeyword(readKeyword);
                    addToDatabase(userExpertareaServiceImpl, msg, ex);
                }
                ex.setLastKeyword(readKeyword);
                ex.setStatus(true);
            }
        }
    }

    private static Object[] insertMsg(Object[] temp, String... value)
    {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < temp.length; i++)
        {
            if (null == temp[i])
            {
                list.add("");
            }
            else
            {
                list.add(temp[i].toString());
            }
        }
        for (int i = 0; i < value.length; i++)
        {
            list.add(value[i]);
        }
        return list.toArray();
    }

    private static String fillRecomment(Object[] temp)
    {
        // 读推荐指数列
        String readRecommens = "";
        if (temp[2] != null)
        {
            readRecommens = temp[2].toString();
        }
        // 文本格式不同读出来的数字可能包含小数点
        if (readRecommens.indexOf(".") != -1)
        {
            readRecommens = readRecommens.substring(0, readRecommens.indexOf("."));
        }
        // 为空默认为500
        if (StringUtils.isBlank(readRecommens))
        {
            readRecommens = "500";
        }
        return readRecommens;
    }

    private static void importDB(UserExpertareaService userExpertareaServiceImpl, List<Object[]> parseExcel,
            ReportMsgVo msg, ExpertTempVo ex, int i)
    {
        // 判断是不是最后一列
        if (i == parseExcel.size() - 1)
        {
            String expert = sortExpertString(ex.getExpert().substring(1));
            ex.setExpert(expert);
            // 数据库关键字包含用户上传，做更新处理
            if (ex.getList().contains(ex.getLastKeyword()))
            {
                UserExpertarea userExpertarea = userExpertareaServiceImpl.findByKeyWord(ex.getLastKeyword()).get(0);
                userExpertarea.setExpert(expert);
                userExpertareaServiceImpl.update(userExpertarea);
                ex.getLists().add(userExpertarea);
                msg.setSucCount(msg.getSucCount() + 1);
                msg.getUserIds().add(expert);
            }
            else
            {
                UserExpertarea userExpertarea = new UserExpertarea();
                userExpertarea.setIsDelete(0);
                userExpertarea.setExpert(expert);
                userExpertarea.setKeyword(ex.getLastKeyword());
                userExpertareaServiceImpl.add(userExpertarea);
                // 将存数据库的关键词放入最新的关键词集合中
                ex.getLists().add(userExpertarea);
                ex.getList().add(ex.getLastKeyword());
                msg.getUserIds().add(expert);
            }
        }
    }

    private static void addToDatabase(UserExpertareaService userExpertareaServiceImpl, ReportMsgVo msg, ExpertTempVo ex)
    {
        // 专家及指数排序
        String expert = sortExpertString(ex.getExpert().substring(1));
        ex.setExpert(expert);
        // System.out.println("expert排序："+expert);
        // 数据库关键字包含用户上传，做更新处理
        if (ex.getList().contains(ex.getLastKeyword()))
        {
            UserExpertarea userExpertarea = userExpertareaServiceImpl.findByKeyWord(ex.getLastKeyword()).get(0);
            userExpertarea.setExpert(ex.getExpert());
            userExpertareaServiceImpl.update(userExpertarea);
            ex.getLists().add(userExpertarea);
            msg.setSucCount(msg.getSucCount() + 1);
            msg.getUserIds().add(ex.getExpert());
        }
        else
        {
            UserExpertarea userExpertarea = new UserExpertarea();
            userExpertarea.setKeyword(ex.getLastKeyword());
            userExpertarea.setExpert(expert);
            userExpertarea.setIsDelete(0);
            userExpertareaServiceImpl.add(userExpertarea);
            // 将存数据库的关键词放入最新的关键词集合中
            ex.getList().add(ex.getLastKeyword());
            ex.getLists().add(userExpertarea);
            msg.setSucCount(msg.getSucCount() + 1);
            msg.getUserIds().add(expert);
        }
    }

    /**
     * @param expertJsonStr
     *            String
     * @return String
     */
    public static String sortExpertString(String expertJsonStr)
    {
        String[] list = expertJsonStr.split(",");
        List<JSONObject> listJSON = new ArrayList<JSONObject>();
        for (int i = 0; i < list.length; i++)
        {
            JSONObject respInfo = new JSONObject();
            respInfo.put("name", list[i].split("#")[0]);
            respInfo.put("value", list[i].split("#")[1]);
            listJSON.add(respInfo);
        }
        Collections.sort(listJSON, new Comparator<JSONObject>()
        {

            @Override
            public int compare(JSONObject arg0, JSONObject arg1)
            {
                if (Integer.parseInt((String) arg0.get("value")) < Integer.parseInt((String) arg1.get("value")))
                {
                    return 1;
                }
                else if (Integer.parseInt((String) arg0.get("value")) == Integer.parseInt((String) arg1.get("value")))
                {
                    return 0;
                }
                return -1;
            }
        });
        StringBuffer expertString = new StringBuffer();
        for (int i = 0; i < listJSON.size(); i++)
        {
            expertString
                    .append("," + (String) listJSON.get(i).get("name") + "#" + (String) listJSON.get(i).get("value"));
        }
        return expertString.toString().substring(1);
    }

    private static JSONObject checkNameAndNumber(String expert)
    {
        int expertLength = expert.length();
        int leftParen = expert.indexOf("(");
        String userName = expert.substring(0, leftParen);
        String userId = expert.substring(leftParen + 1, expertLength - 1);
        UserDepartNameService userDepartNameServiceImpl = (UserDepartNameService) Util
                .getBeanByName("userDepartNameServiceImpl");
        String userCnName = userDepartNameServiceImpl.queryEmployeeName(userId.toLowerCase());
        JSONObject respInfo = new JSONObject();
        if (userName.equals(userCnName))
        {
            respInfo.put("check", "true");
            respInfo.put("userName", userName);
            respInfo.put("userId", userId);
            return respInfo;
        }
        else
        {
            respInfo.put("check", "false");
            return respInfo;
        }
    }

    private static void deleteTempFile()
    {
        deleteFileThreadPool.schedule(new Runnable()
        {

            @Override
            public void run()
            {
                File file = new File(SysConfig.getIndexConfig("synonyms.errorMsgExcelPath"));
                File[] listFiles = file.listFiles();
                if (null != listFiles && listFiles.length != 0)
                {
                    for (File fileTemp : listFiles)
                    {
                        if (fileTemp.isFile())
                        {
                            boolean delete = fileTemp.delete();
                            if (delete)
                            {
                                System.out.println("删除领域专家定制临时目录成功");
                            }
                        }
                    }
                }
            }
        }, NumConstants.NUM_10, TimeUnit.MINUTES);
    }

    /**
     * @param keyword
     *            String
     * @param expert
     *            String
     * @return Workbook
     */
    public Workbook exportExpertareaExcel(String keyword, String expert)
    {
        SXSSFWorkbook workbook = getExpertModelExcel("领域专家定制导出模板.xlsx");
        List<Object[]> lists = new ArrayList<>();
        UserExpertareaService userExpertareaServiceImpl = (UserExpertareaService) Util
                .getBeanByName("userExpertareaServiceImpl");
        List<UserExpertarea> userExpertareas = userExpertareaServiceImpl.queryAllExpertareaByPage(null, null, keyword,
                expert);
        Object[] title = null, subject = null;
        lists.add(title);
        lists.add(subject);
        for (UserExpertarea userExpert : userExpertareas)
        {
            String expertJsonStr = userExpert.getExpert();
            List<JSONObject> listJSON = splitExpert(expertJsonStr);
            for (int i = 0; i < listJSON.size(); i++)
            {
                JSONObject json = listJSON.get(i);
                if (i == 0)
                {
                    Object[] obj = {userExpert.getKeyword(),
                            json.getString("userName") + "(" + json.getString("userId") + ")",
                            json.getString("value")};
                    lists.add(obj);
                }
                else
                {
                    Object[] obj = {"", json.getString("userName") + "(" + json.getString("userId") + ")",
                            json.getString("value")};
                    lists.add(obj);
                }
            }
        }
        PoiUtil.exportWorkBook(lists, workbook, null);
        return workbook;
    }

    /**
     * @param expertJsonStr
     *            String
     * @return List<JSONObject>
     */
    public static List<JSONObject> splitExpert(String expertJsonStr)
    {
        String[] list = expertJsonStr.split(",");
        List<JSONObject> listJSON = new ArrayList<JSONObject>();
        for (int i = 0; i < list.length; i++)
        {
            JSONObject respInfo = new JSONObject();
            respInfo.put("userName", list[i].split("#")[0].split("@")[0]);
            respInfo.put("userId", list[i].split("#")[0].split("@")[1]);
            respInfo.put("value", list[i].split("#")[1]);
            listJSON.add(respInfo);
        }
        for (JSONObject o : listJSON)
        {
            System.out.println("userName:" + o.getString("userName") + "--userId:" + o.getString("userId") + "--value:"
                    + o.getString("value"));
        }
        return listJSON;
    }

    /**
     * @param userNum
     *            Set<String>
     */
    public static void sendMail(Set<String> userNum)
    {
        UserDepartNameService userDepartNameServiceImpl = (UserDepartNameService) Util
                .getBeanByName("userDepartNameServiceImpl");
        UserExpertareaService userExpertareaServiceImpl = (UserExpertareaService) Util
                .getBeanByName("userExpertareaServiceImpl");
        SynonymsController synonymsController = (SynonymsController) Util.getBeanByName("synonymsController");
        for (String strId : userNum)
        {
            List<String> keywords = new ArrayList<String>();
            String userName = synonymsController.getUserDetail(strId.toLowerCase());
            String mail = userDepartNameServiceImpl.queryEmployeeMail(strId.toLowerCase());
            List<UserExpertarea> userExpertareas = userExpertareaServiceImpl.queryAllExpertareaByPage(null, null, null,
                    strId);
            for (UserExpertarea userExpertarea : userExpertareas)
            {
                String keyword = userExpertarea.getKeyword();
                if (StringUtils.isNotBlank(keyword))
                {
                    keywords.add(keyword);
                }
            }
            String content = content(userName, keywords);
            MailUtil.sendMail("亲爱的" + userName + ",您已被女神选中！", content, true, mail, "", "");
            System.out.println("邮件内容：" + content);
        }
    }
    
    /**
     * @param userNum
     *          String
     */
    public static void sendWarningMail(String userNum)
    {
        UserDepartNameService userDepartNameServiceImpl = (UserDepartNameService) Util
                .getBeanByName("userDepartNameServiceImpl");
        
        // 查询用户名
        String userCnName = userDepartNameServiceImpl.queryEmployeeName(userNum.toLowerCase());
        // 查询用户邮箱
        String mail = userDepartNameServiceImpl.queryEmployeeMail(userNum.toLowerCase());
        StringBuilder importMsg = new StringBuilder();
        importMsg.append("亲爱的").append(userCnName)
                .append("同学，<br><br>您的导入数据中存在无效超链接，请您手动去除无效超链接！！");
        String content = importMsg.toString();
        MailUtil.sendMail("亲爱的" + userCnName + ",您的导入数据有误！", content, true, mail, "", "");
        System.out.println("邮件内容：" + content);
        
    }

    private static String content(String userCnName, List<String> keywords)
    {
        StringBuilder keyword = new StringBuilder();
        for (String kw : keywords)
        {
            // keyword.append("、").append(kw);
            keyword.append("、").append("<a href='http://athena.huawei.com/rd-search/search/000?key=")
            .append(kw + "&sortMode=sortByScore&filterByTime=0&divided=true&qtype=ST'>")
            .append(kw + "</a>");
        }
        StringBuilder importMsg = new StringBuilder();
        importMsg.append("<div style='font-family:微软雅黑'>亲爱的").append("<u><strong>" + userCnName + "</strong></u>")
                .append("同学，<br><br><br><br>鉴于您在研发知识领域的影响力，您已被"
                        + "雅典娜女神（<a href='http://athena.huawei.com'>http://athena.huawei.com</a>）"
                        + "选中，设置成该领域的专家。请不吝赐教！<br><br><br><br>"
                        + "当以下关键词出现时，您的名字会被置顶。<br><br>")
                .append("关键词：")
                .append(keyword.toString().substring(1) + "</div>");
        return importMsg.toString();
    }

    private SXSSFWorkbook getExpertModelExcel(String model)
    {
        XSSFWorkbook excel = null;
        try
        {
            String webInf = new File(this.getClass().getClassLoader().getResource("").getPath()).getParentFile()
                    .getAbsolutePath();
            String realPath = webInf + File.separator + "classes" + File.separator + model;
            File file = new File(realPath);
            excel = (XSSFWorkbook) WorkbookFactory.create(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        SXSSFWorkbook workbook = new SXSSFWorkbook(excel, NumConstants.NUM_1000);
        return workbook;
    }

}
