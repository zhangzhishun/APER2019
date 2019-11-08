package com.springboot.dao.impl;

import com.springboot.dao.copyCsdnDao;
import com.springboot.domain.CSDN;
import com.springboot.utils.copyFromCsdn.GetAcw_sc__v2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class copyCsdnDaoImpl implements copyCsdnDao{
    public List<CSDN> getCsdnResult() {
        return FindAllArticle(pages);
    }

    public void setCsdnResult(List<CSDN> csdnResult) {
        this.csdnResult = csdnResult;
    }

    private List<CSDN> csdnResult = new ArrayList<>(); /* 每步的操作都是将结果保存到csdn中 */
    private Document document=null;

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    private String pages = "1";

    public String getAcw_sc__v2() {
        return acw_sc__v2;
    }

    public void setAcw_sc__v2(String acw_sc__v2) {
        this.acw_sc__v2 = acw_sc__v2;
    }

    private String acw_sc__v2;
    public List<CSDN> FindAllArticle(String pages){
        csdnResult.clear();
        /* 修改该处为自己的CSDN博客地址 */
        String url ="https://blog.csdn.net/qq_36254699/article/list/"+ pages;
        //System.out.println(getHtmlTextByUrl(url).text());
        //System.out.println("打开第"+ pages +"个页面："+url);
        reptile(url);
        //System.out.println("访问完毕！");
        //System.out.println("本页是否有博客：" + flag);
        return csdnResult;
    }

    /* 开始爬虫 将所有数据放在List<csdn>中 */
    public int reptile(String url){
        /* 添加时间变量 */
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        //System.out.println("当前时间为: " + ft.format(dNow));

        String type="content";
        //System.out.println(getCsdnUrl(url, type));
        List list = getCsdnUrl(url, type);
        if(!list.isEmpty()){
            //System.out.println("找到这个界面的所有链接"+ list );
            for(int i = 0;i < list.size(); i ++){
                //System.out.println(list.get(i));
                String tempRrl = (String) list.get(i);
                Map<String,String> str = getContentFromUrl(tempRrl);
                Iterator<String> iter = str.keySet().iterator();
                while(iter.hasNext()){
                    CSDN temp = new CSDN();
                    String key=iter.next();
                    String value = str.get(key);
                    temp.setArticle_id(i);
                    temp.setArticle_user_id(1);
                    temp.setArticle_title(key);
                    temp.setArticle_content(value);
                    temp.setArticle_view_count(0);
                    temp.setArticle_comment_count(0);
                    temp.setArticle_like_count(0);
                    temp.setArticle_is_comment(1);
                    temp.setArticle_status(1);
                    temp.setArticle_order(1);
                    temp.setArticle_summary(key);
                    temp.setArticle_create_time(ft.format(dNow));
                    temp.setArticle_update_time(ft.format(dNow));
                    csdnResult.add(temp);
                }
            }
        }else{
            return 0;
        }
        return 1;
    }

    /* 获取标题和内容 */
    public Map<String,String> getContentFromUrl(String url){
        Map<String,String> result = new HashMap();
        String title = "";
        String content = "";

        String classtypeTitle=".title-article";
        //String classtypeTitle=".title-article";
        String classtypeContent=".article_content";

        //从网络上获取网页
        Document document=getHtmlTextByUrl(url);
        //System.out.println(document.text());
        if (document!=null) {

            Elements elementsTitle=getElementByClass(document,classtypeTitle);// tr的集合
            title = elementsTitle.text();

            Elements elementsContent=getElementByClass(document,classtypeContent);// tr的集合
            content = elementsContent.toString();

            content = content.replaceAll("https","http");
            result.put(title,content);


            //System.out.println("博客标题："+ title );
            //System.out.println("博客标题："+ title + "博客内容："+ content );
        }
        else{ /*该页面不含博客*/
            return null;
        }
        return result;
    }



    public ArrayList getCsdnUrl(String url, String type){
        ArrayList result=new ArrayList();
        String classtype="."+type;
        //从网络上获取网页
        Document document=getHtmlTextByUrl(url);
        //System.out.println(document);
        if (document!=null) {
            Elements elements=getElementByClass(document,classtype);// tr的集合
            //Elements elements=getElementByClass(document,"[href]");// tr的集合
            //System.out.println(elements.attr("href"));
            for(Element e:elements){// 依次循环每个元素，也就是一个tr
                if(e!=null){
                    //System.out.println(e.children());
                    //System.out.println("------   --------   ---------   ------");
                    String str = e.select("a").attr("href");
                    /* 如果是我的博客那么输出url */
                    boolean status = str.contains("qq_36254699");
                    if(status){
                        //System.out.println(str);
                        result.add(str);
                    }
                }
            }
        }
        else{
            return null;
        }
        return result;
    }

    //根据url获取数据
    public Document getHtmlTextByUrl(String url){
        try{
            int i=(int)(Math.random()*1000);////做一个随机延时，防止网站屏蔽
            while (i!=0) {
                i--;
            }
            document = Jsoup.connect(url).cookie("acw_sc__v2",getAcw_sc__v2()).get();
            //System.out.println(acw_sc__v2);
            //System.out.println(document);
        }catch(Exception e){
            e.printStackTrace();
            try{
                document= (Document) Jsoup.connect(url).timeout(5000000).get();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        return document;
    }

    //根据元素属性获取某个元素内的elements列表
    public Elements getElementByClass(Document document, String className){
        Elements elements = document.select(className);
        return elements;
    }

    public CSDN FindByTitle(String title){
        for(int i = 0;i < csdnResult.size(); i ++){
            //System.out.println(list.get(i));
            CSDN tempRrl = csdnResult.get(i);
            if(tempRrl.getArticle_title().equals(title))
                return tempRrl;
        }
        return null;
    }

    public CSDN FindByNumber(String p, String number) {
        int IntNumber = Integer.valueOf(number) - 1 ;
        if(csdnResult.size() < IntNumber )
            return null;
        else
            return csdnResult.get(IntNumber);
    }
}
