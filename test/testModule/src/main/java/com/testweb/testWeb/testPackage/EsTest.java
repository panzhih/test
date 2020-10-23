package com.testweb.testWeb.testPackage;

import com.testweb.testWeb.utils.ServerModule;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EsTest {

    private TransportClient client = new ServerModule().getClient();

    //创建索引
    public boolean createIndex(String indexName){
        CreateIndexResponse response = client.admin().indices().create(new CreateIndexRequest(indexName)).actionGet();
        String str = response.index();
        return indexIExist(str);
    }

    //删除索引
    public boolean deleteIndex(String indexName){
        DeleteIndexResponse response = client.admin().indices().delete(new DeleteIndexRequest(indexName)).actionGet();
        return response.isAcknowledged();
    }

    //创建type
    public List<String> createType(String indexName,String typeName){
        IndexResponse response = null;
        List<String> ids = new ArrayList<>();
        try {
            List<Map<String,String>> lists = new ArrayList<>();
            Map<String,String> map = new HashMap<>();
            map.put("id","5");
            map.put("name","赛科世纪科技股份有限公司");
            map.put("content","内容今天星期1");
            lists.add(map);
            Map<String,String> map1 = new HashMap<>();
            map1.put("id","6");
            map1.put("name","java框架");
            map1.put("content","spring框架");
            lists.add(map1);
            Map<String,String> map2 = new HashMap<>();
            map.put("id","7");
            map.put("name","数据库操作");
            map.put("content","mysqldb2oracle");
            lists.add(map2);
            Map<String,String> map3 = new HashMap<>();
            map1.put("id","8");
            map1.put("name","赛科在线书籍");
            map1.put("content","hi二号IE");
            lists.add(map3);
            for(Map<String,String> ma : lists){
                String id = ma.get("id");
                client.prepareIndex(indexName,typeName,id).setSource(ma).execute().actionGet();
                ids.add(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }

    //验证索引是否存在
    public boolean indexIExist(String name){
        //IndicesExistsRequest request = new IndicesExistsRequest(name);
        IndicesExistsResponse response = client.admin().indices().prepareExists(name).execute().actionGet();
        return response.isExists();
    }
    //验证索引下type是否存在
    public boolean typeExist(String index ,String type){
        return this.client.admin().indices().prepareTypesExists(index).setTypes(type).execute().actionGet().isExists();
    }

    //查询表记录
    public Map<String, Object> selectData(String index ,String type ,String id ,String field){
        GetRequestBuilder getRequestBuilde = this.client.prepareGet(index ,type ,id);
        if(StringUtils.isNotEmpty(field)){
            getRequestBuilde.setFetchSource(field.split(","),null);
        }
        GetResponse response = getRequestBuilde.execute().actionGet();
        return response.getSource();
    }

    //查询全部记录
    public List<Map<String,Object>> selectAll(String index,String type){
        List<Map<String,Object>> list = new ArrayList<>();
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //从第三条数据后查询一条
        /*builder.from(3);
        builder.size(1);*/
        //全量数据查询
        //builder.query(QueryBuilders.matchAllQuery());
        //精准匹配
        //builder.query(QueryBuilders.termsQuery("_id","1","2"));
        //占比匹配
        //builder.query(QueryBuilders.matchQuery("name","赛科世纪科技股份有限").minimumShouldMatch("70"));
        //多字段联合匹配
        //builder.query(QueryBuilders.multiMatchQuery("赛科","name","content").field("content",10));
        //多条件查询+过滤器
        /*
          must：文档必须匹配must所包括的查询条件，相当于 “AND”
          should：文档应该匹配should所包括的查询条件其中的一个或多个，相当于 “OR”
          must_not：文档不能匹配must_not所包括的该查询条件，相当于“NOT”
        */
        MultiMatchQueryBuilder matchQueryBuilder = QueryBuilders.multiMatchQuery("赛科","name","centent").field("name",10);
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("_id","8");
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(matchQueryBuilder);
        boolQueryBuilder.should(termQueryBuilder);

        //添加过滤
        boolQueryBuilder.filter(QueryBuilders.multiMatchQuery("hi二号IE","content"));

        builder.query(boolQueryBuilder);

        //进行排序
        builder.sort("id", SortOrder.DESC);

        builder.fetchSource(new String[]{},new String[]{});
        searchRequest.source(builder);

        SearchResponse response = client.search(searchRequest).actionGet();

        SearchHits searchHits = response.getHits();

        System.out.println("获取数据数=="+searchHits.totalHits);

        for(SearchHit searchHit : searchHits){
            list.add(searchHit.getSource());
        }
        return list;

    }



    //更新数据
    public Map<String, Object> updateData(String index,String type,String id,String name,String content){
        Map<String,String> jsonObject = new HashMap<>();
        jsonObject.put("id","4");
        jsonObject.put("name",name);
        jsonObject.put("content",content);

        UpdateRequestBuilder requestBuilder = client.prepareUpdate(index,type,id);
        requestBuilder.setDoc(jsonObject).execute().actionGet();


        /*UpdateRequest request = new UpdateRequest();
        request.index(index).type(type).id(id).doc(jsonObject);
        client.update(request).actionGet();*/

        return selectData(index,type,id,null);
    }

    @Test
    public void createDate(){
        System.out.println(new EsTest().createType("test","book"));
    }

    public static void main(String[] args){
        EsTest esTest = new EsTest();
        String indexName = "test";
        String typeName = "book";

        boolean existFlog = esTest.indexIExist(indexName);
        System.out.println("是否存在index=="+esTest.indexIExist(indexName));
        if(!existFlog){
            //System.out.println("删除索引=="+esTest.deleteIndex(indexName));

            System.out.println("创建index=="+esTest.createIndex("test"));

            List<String> ids = esTest.createType(indexName,typeName);
            System.out.println("创建type==="+ids);
        }
        System.out.println("是否存在type=="+esTest.typeExist(indexName,typeName));

        //获取全部数据
        List<Map<String,Object>> result = esTest.selectAll(indexName,typeName);

        System.out.println("查询结果如下==");
        /*for(String id : ids){
            System.out.println(esTest.selectData(indexName,typeName,id,"name"));
        }*/
        System.out.println(result);

        //System.out.println("更新数据2=="+esTest.updateData(indexName,typeName,"2","王五","内容3"));

    }
}
