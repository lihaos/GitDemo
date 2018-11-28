package cn.ch.netem.service;

import java.util.List;


import cn.ch.netem.pojo.TestPaper;

public interface TestService {
	 /***
     * <h1 style="color:red">获取试卷列表</h1>
     * @param testPaperTtile
     * @param pageNo
     * @return
     */
	List<TestPaper> getTestPaperList(String testPaperTtile,int pageNo);
	/***
     * <h1 style="color:red">获取试卷数</h1>
     * @param testPaperTtile
     * @return
     */
	 int getTestPaperCount(String testPaperTtile);
}
