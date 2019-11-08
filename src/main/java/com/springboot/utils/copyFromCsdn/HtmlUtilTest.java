/*
package com.springboot.utils.copyFromCsdn;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.mime.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

*/
/**
 * Created by xuyh at 2017/11/6 14:03.
 *//*

public class HtmlUtilTest {
    @Test
    public void test() {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
        HtmlPage page = null;
        try {
            page = webClient.getPage("https://blog.csdn.net/han_ying_ying/article/details/80454176");//尝试加载上面图片例子给出的网页
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            webClient.close();
        }

        webClient.waitForBackgroundJavaScript(30000);//异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束

        System.out.println(page.toString());
        String pageXml = page.asXml();//直接将加载完成的页面转换成xml格式的字符串

        //TODO 下面的代码就是对字符串的操作了,常规的爬虫操作,用到了比较好用的Jsoup库

        Document document = Jsoup.parse(pageXml);//获取html文档
        List<Element> infoListEle = document.getElementById("feedCardContent").getElementsByAttributeValue("class", "feed-card-item");//获取元素节点等
        infoListEle.forEach(element -> {
            System.out.println(element.getElementsByTag("h2").first().getElementsByTag("a").text());
            System.out.println(element.getElementsByTag("h2").first().getElementsByTag("a").attr("href"));
        });
    }


    @Test
    public void test1(){
        try {
            URL link = new URL(
                    "http://www.66ip.cn/mo.php?sxb=&tqsl=1000&ports%5B%5D2=&ktip=&sxa=&radio=radio&submit=%CC%E1++%C8%A1");
            WebRequest request = new WebRequest(link);
            request.setCharset(Charset.forName("UTF-8"));
            request.setAdditionalHeader("Referer",
                    "http://www.66ip.cn/mo.php?sxb=&tqsl=1000&ports%5B%5D2=&ktip=&sxa=&radio=radio&submit=%CC%E1++%C8%A1");// 设置请求报文头里的refer字段
            request.setAdditionalHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
            WebClient wc = new WebClient();
            wc.getCookieManager().setCookiesEnabled(true);// 开启cookie管理
            wc.getOptions().setJavaScriptEnabled(true);// 开启js解析。对于变态网页，这个是必须的
            wc.getOptions().setCssEnabled(false);// 关闭css解析。
            wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
            wc.getOptions().setThrowExceptionOnScriptError(false);
            wc.getOptions().setRedirectEnabled(true);
            wc.getOptions().setTimeout(10000);
            wc.setJavaScriptTimeout(50000);
            Header[] cookie = null;
            for (int i = 0; i < cookie.length; i++) {//此处的cookie是我第一次正常访问获取到的cookie
                Header ck = cookie[i];
                com.gargoylesoftware.htmlunit.util.Cookie ucookies = new com.gargoylesoftware.htmlunit.util.Cookie(
                        "www.66ip.cn", ck.getName(), ck.getValue());
                wc.getCookieManager().addCookie(ucookies);
            }

            HtmlPage hp = wc.getPage(request);
            String body = hp.getBody().asXml();
            // 截取js函数
            String function = body.substring(body.indexOf("function"), body.lastIndexOf("}") + 1);
            // 把设置cookie的函数替换成返回
            function = function.replace("eval(\"qo=eval;qo(po);\")", "return po");
            // 提取js函数参数(正则表达式匹配)
            String regx = "setTimeout\\(\\\"\\D+\\((\\d+)\\)\"";
            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(body);
            String call = "";
            while (matcher.find()) {
                String group = matcher.group();
                call = group.substring(group.indexOf("\"") + 1, group.lastIndexOf("\""));
            }
            ScriptResult ckstr = hp.executeJavaScript(function + call);//拼接Js,运行
            String cookie1 = ckstr.getJavaScriptResult().toString();
            cookie1 = cookie1.substring(cookie1.indexOf("'") + 1, cookie1.indexOf(";") + 1);
            //此处已拿到需要的cookie：_ydclearance=efad3fbba88e7738d15cc25b-5203-428b-b273-5d6459ee5246-1506330645
            wc.close();
        } catch (ClientProtocolException e2) {
            System.out.println("66IP解密Js失败");
        } catch (IOException e3) {
            System.out.println("66IP解密Js失败");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
