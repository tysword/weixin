//package cn.dt.weixin.handler.dao;
//
//import java.util.Date;
//import java.util.List;
//
//import cn.dt.basic.dao.IMyRepository;
//import cn.dt.weixin.po.NoticeTemplate;
//
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface INoticeTemplateDAO extends
//		IMyRepository<NoticeTemplate, String>,
//		JpaSpecificationExecutor<NoticeTemplate> {
//	
//	@Query("from NoticeTemplate m where (m.scheduledDate <= ? or m.scheduledDate is null) "
//			+ "and m.sendCount < 3 and m.sendStatus <> 'SUCCESS'")
//	List<NoticeTemplate> getScheduledNoticeTemplates(Date date);
//
//}
