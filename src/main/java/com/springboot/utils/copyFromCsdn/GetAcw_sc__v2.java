package com.springboot.utils.copyFromCsdn;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAcw_sc__v2 {
    String acw_sc__v2 = "";

    public String getAcw_sc__v2() {
        return acw_sc__v2;
    }

    public GetAcw_sc__v2(){
        String temp = GetCookie();
        acw_sc__v2 = PatternAcw_sc__v2((temp));
    }

    public String GetCookie(){
        /* chromedriver.exe地址 */
        System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");//这一步必不可少
        //System.setProperty("webdriver.chrome.driver","C:/Users/study/AppData/Local/Google/Chrome/Application/chromedriver.exe");//这一步必不可少
        ChromeOptions options = new ChromeOptions();
        /* chrome安装地址 */
        options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://blog.csdn.net/qq_36254699/article/details/102530260");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获得cookie
        Set<Cookie> coo = driver.manage().getCookies();
        //打印cookie
        //System.out.println(coo.contains("acw_sc__v2"));
        //System.out.println(GetAcw_sc__v2(coo.toString()));
        String re = coo.toString();
        driver.quit();
        return re;
    }

    public String PatternAcw_sc__v2(String coo){
        String acw_sc__v2 = "";
        Pattern p = Pattern.compile("acw_sc__v2=(.*?);");//正则表达式，取q#和#q之间的字符串，不包括q#和#q
        Matcher m = p.matcher(coo);
        while(m.find()) {
            acw_sc__v2 = m.group(1);//m.group(1)不包括这两个字符
        }
        return acw_sc__v2;
    }

    @Test
    public void aaa(){
        String temp= GetCookie();
        System.out.println(PatternAcw_sc__v2((temp)));
    }
}
