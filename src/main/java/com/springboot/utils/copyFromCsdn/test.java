package com.springboot.utils.copyFromCsdn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

public class test {
    public static String getLocation(String url) {
        try {
            URL serverUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(true);
            conn.connect();
            String location = conn.getHeaderField("Location");
            System.out.println(location);
            return location;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Test
    public void main(){
        /*System.out.println(getLocation("https://blog.csdn.net/han_ying_ying/article/details/80454176"));*/
        Document document = null;
        String url = "https://blog.csdn.net/han_ying_ying/article/details/80454176";
        try{
            int i=(int)(Math.random()*1000);////做一个随机延时，防止网站屏蔽
            while (i!=0) {
                i--;
            }
            document = Jsoup.connect(url).cookie("acw_sc__v2","5da0321641c989ee575d67049e5f643d2462ed53").get();
            Elements element = document.getElementsByTag("script");
            //Element element = elements.get(0).selectFirst("script");
            if (element != null) {
                String str = element.toString();
                //System.out.println(str);
            }
            System.out.println(document);
        }catch(Exception e){
            e.printStackTrace();
            try{
                document= (Document) Jsoup.connect(url).timeout(5000000).get();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
