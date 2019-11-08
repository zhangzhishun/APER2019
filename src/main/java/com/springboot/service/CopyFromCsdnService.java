package com.springboot.service;

import com.springboot.domain.CSDN;
import java.util.*;
/* 所有爬虫相关的 */
public interface CopyFromCsdnService {
    /* 获取所有结果 */
    List<CSDN> getCsdnResult();

    /* 获取某一页所有结果 */
    List<CSDN> FindAllArticle(String pages);

    /* 获取标题和内容 */
    Map<String,String> getContentFromUrl(String url);

    /* 根据标题获取一篇CSDN */
    CSDN FindByTitle(String title);

    /* 设置acw_sc__v2*/
    void setAcw_sc__v2(String acw_sc__v2);

    /* 获取acw_sc__v2*/
    String getAcw_sc__v2();
}
