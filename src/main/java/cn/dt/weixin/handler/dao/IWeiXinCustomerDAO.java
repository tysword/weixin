//package cn.dt.weixin.handler.dao;
//
//import java.util.Date;
//import java.util.List;
//
//import cn.dt.basic.dao.IMyRepository;
//import cn.dt.weixin.po.WeiXinCustomer;
//
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface IWeiXinCustomerDAO extends
//	IMyRepository<WeiXinCustomer, String>,
//	JpaSpecificationExecutor<WeiXinCustomer> {
//
//	WeiXinCustomer findByOpenid(String fromUserName);
//	@Query("from WeiXinCustomer t where t.createDate >?1 and t.customerID is null order by t.createDate desc")
//	List<WeiXinCustomer> inTimeQueryWeixin(Date date);
//}
