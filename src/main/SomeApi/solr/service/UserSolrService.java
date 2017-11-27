package solr.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.FieldStatsInfo;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.GroupParams;
import org.springframework.stereotype.Component;

import solr.SolrConfig;

import org.springframework.stereotype.Service;

public class UserSolrService{

	public static void main(String[] args) {
		System.out.println(yestodayStats("p2p_user_id", "p2p_user_id",1,null,"p2p_user_id", "2017-09-25"));
	}

	/**
	 * 按某一天统计
	 * @param queryStr	查询条件
	 * @param statsField  统计字段
	 * @param statsType  统计方式（1.count 2.sum）
	 * @param groupField  分组字段
	 * @param tableKey  统计表的主键 
	 * @param dateStr  日期
	 * @return
	 */
	public static String yestodayStats(String queryStr,String statsField,Integer statsType,String groupField,String tableKey,String dateStr){
		 try {
		 	 //验证权限
			 if(queryStr==null||tableKey==null||dateStr==null)
				 return "参数不能为空";
			 // 查询条件设置
			 SolrQuery query = new SolrQuery(); 
			 query.set("q", queryStr);
			 query.addFilterQuery("create_time:["+dateStr+"T00:00:00Z TO "+dateStr+"T23:59:59Z]");
			 query.set("stats", "true");	
			 //设置统计字段
			 query.set("stats.field", statsField);
			 //设置分组字段
			 if(groupField!=null&&!groupField.equals("")){
				 query.setParam("group", "true"); 
				 query.setParam(GroupParams.GROUP_FIELD,groupField); 
			 }
			 QueryResponse response = SolrConfig.client.query(query);
			 //按字段分组统计
			 if(statsType==1&&groupField!=null&&!groupField.equals("")){
				 return String.valueOf(response.getGroupResponse().getValues().get(0).getValues().size());
			 }
			 //不分组count统计
			 else if(statsType==1&&groupField!=null&&!groupField.equals("")){
				 FieldStatsInfo statsInfo = response.getFieldStatsInfo().get(statsField);
				 return String.valueOf(statsInfo.getCount());
			 }
			 //不分组sum统计
			 else{
				 FieldStatsInfo statsInfo = response.getFieldStatsInfo().get(statsField);
				 return String.valueOf(statsInfo.getSum());
			 }
		} catch (SolrServerException | IOException e){
			e.printStackTrace();
			return "统计出错";
		}
	}

}
