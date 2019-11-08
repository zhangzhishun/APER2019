package com.springboot.dao;

import com.springboot.domain.CSDN;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface copyCsdnDao {
    List<CSDN> getCsdnResult();


    void setCsdnResult(List<CSDN> csdnResult);


    List<CSDN> FindAllArticle(String pages);

    /* 开始爬虫 将所有数据放在List<csdn>中 */
    int reptile(String url);

    /* 获取标题和内容 */
    Map<String,String> getContentFromUrl(String url);



    ArrayList getCsdnUrl(String url, String type);


    //根据url获取数据
    Document getHtmlTextByUrl(String url);

    //根据元素属性获取某个元素内的elements列表
    Elements getElementByClass(Document document, String className);
    CSDN FindByTitle(String title);

    CSDN FindByNumber(String p, String number);

    String getAcw_sc__v2();

    void setAcw_sc__v2(String acw_sc__v2);
}
