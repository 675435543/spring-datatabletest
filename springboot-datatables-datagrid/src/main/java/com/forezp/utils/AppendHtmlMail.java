package com.forezp.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.forezp.entity.ProblemList;

public class AppendHtmlMail
{
    public static String getHtmlMail(String emailContentDetail, List<ProblemList> problemList, String url, String filePath, String emailType)
    {
        /*String explanation = "这是一封测试邮件<br/>";*/
        StringBuffer theMessage = new StringBuffer();
        String emailContent = null;
        theMessage.append(
            "<!DOCTYPE html><html lang='zh-CN'><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        theMessage.append("<title></title><style>table tr td{text-align: center;line-height: 25px;vertical-align: middle;}table thead tr{background: #224B7F;background: #224B7F;color: white;height:40px;font-size: 15px;}table tbody tr{height: 80px;font-size: 15px;}</style>");
        theMessage.append("</head><body>");
        /*theMessage.append("<span><strong>说明：</strong><span>" + explanation + "</span></span>");*/
        /*theMessage.append("<div><div><span><h3>" + emailContentDetail + "</h3></span>");*/
        theMessage.append("</div><div>");
        theMessage.append("<table border='1' bordercolor='#9C9C9C' cellspacing='0' width='1100'><thead><tr><th style='width:10%'>提出时间</th><th style='width:8%'>区域/国家</th><th style='width:8%'>提出人</th><th style='width:20%'>问题</th><th style='width:10%'>诉求关闭时间</th><th style='background: #0170BF; width:8%'>责任部门</th><th style='background: #0170BF; width:8%'>责任人</th><th style='background: #0170BF; width:8%'>状态</th><th style='background: #0170BF; width:20%'>当前进展</th></tr></thead><tbody>");
        for (ProblemList problem : problemList)
        {
            if(problem.getStatus().toLowerCase().equals("close")) {
                if(StringUtils.isNotEmpty(url) && emailType.equals("toDoRemind"))
                {
/*                    theMessage.append("<tr><td>" + problem.getDiscoverTime()+ "</td>"
                        + "<td>" + problem.getTarget() + "</td>"
                        + "<td>" + problem.getIntroducer() + "</td>"
                        + "<td style='text-align:left;'><a href='"+url+"' target='_blank'>" + problem.getProblemSketch() + "</a></td>"
                        + "<td>" + problem.getFinishTime() + "</td>"
                        + "<td>" + problem.getResponsibleField() + "</td>"
                        + "<td>" + problem.getResponsiblePerson() + "</td>"
                        + "<td style='color: white;background: gray'>" + problem.getStatus() + "</td>"
                        + "<td style='text-align:left;'>" + (problem.getAttachList()!=null?"【"+problem.getAttachList().get(0).getCreateTime().split(" ")[0]+"进展】"+"<br/>"+problem.getAttachList().get(0).getAttachDesc():"") + "</td></tr>");*/
                }
                else
                {
                    theMessage.append("<tr><td>" + problem.getDiscoverTime()+ "</td>"
                        + "<td>" + problem.getTarget() + "</td>"
                        + "<td>" + problem.getIntroducer() + "</td>"
                        + "<td style='text-align:left;'>" + problem.getProblemSketch() + "</td>"
                        + "<td>" + problem.getFinishTime() + "</td>"
                        + "<td>" + problem.getResponsibleField() + "</td>"
                        + "<td>" + problem.getResponsiblePerson() + "</td>"
                        + "<td style='color: white;background: gray'>" + problem.getStatus() + "</td></tr>");
                        /*+ "<td style='text-align:left;'>" + (problem.getAttachList()!=null?"【"+problem.getAttachList().get(0).getCreateTime().split(" ")[0]+"进展】"+"<br/>"+problem.getAttachList().get(0).getAttachDesc():"") + "</td></tr>");*/
                }
            }
            else
            {
                if(StringUtils.isNotEmpty(url) && emailType.equals("toDoRemind"))
                {
                    theMessage.append("<tr><td>" + problem.getDiscoverTime()+ "</td>"
                        + "<td>" + problem.getTarget() + "</td>"
                        + "<td>" + problem.getIntroducer() + "</td>"
                        + "<td style='text-align:left;'><a href='"+url+"' target='_blank'>" + problem.getProblemSketch() + "</a></td>"
                        + "<td>" + problem.getFinishTime() + "</td>"
                        + "<td>" + problem.getResponsibleField() + "</td>"
                        + "<td>" + problem.getResponsiblePerson() + "</td>"
                        + "<td style='background: yellow'>" + problem.getStatus() + "</td></tr>");
                        /*+ "<td style='text-align:left;'>" + (problem.getAttachList()!=null?"【"+problem.getAttachList().get(0).getCreateTime().split(" ")[0]+"进展】"+"<br/>"+problem.getAttachList().get(0).getAttachDesc():"") + "</td></tr>");*/
                }
                else
                {
                    theMessage.append("<tr><td>" + problem.getDiscoverTime()+ "</td>"
                        + "<td>" + problem.getTarget() + "</td>"
                        + "<td>" + problem.getIntroducer() + "</td>"
                        + "<td style='text-align:left;'>" + problem.getProblemSketch() + "</td>"
                        + "<td>" + problem.getFinishTime() + "</td>"
                        + "<td>" + problem.getResponsibleField() + "</td>"
                        + "<td>" + problem.getResponsiblePerson() + "</td>"
                        + "<td style='background: yellow'>" + problem.getStatus() + "</td></tr>");
                        /*+ "<td style='text-align:left;'>" + (problem.getAttachList()!=null?"【"+problem.getAttachList().get(0).getCreateTime().split(" ")[0]+"进展】"+"<br/>"+problem.getAttachList().get(0).getAttachDesc():"") + "</td></tr>");*/
                }

            }

        }
        theMessage.append("</tbody></table></div><br/>");
        /*theMessage.append("<strong>附件信息</strong>:" + filePath);*/
        /*theMessage.append("<br/><br/><span><strong>一线舆情页面地址：</strong></span><a href='" + url + "' target='blank'>" + url + " </a></div>");*/
        theMessage.append("</body>");
        theMessage.append("</html>");
        emailContent = theMessage.toString();
        return emailContent;
    }
}
