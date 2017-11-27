package solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrConfig {
	
	public static  String SolrUrl = "http://127.0.0.1:8983/solr/new_core";
	public static  SolrClient client = new HttpSolrClient(SolrUrl);

}
