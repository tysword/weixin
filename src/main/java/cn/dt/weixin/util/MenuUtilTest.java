//package cn.dt.weixin.util;
//
//import org.junit.Test;
//
//import cn.dt.weixin.message.menu.ClickButton;
//import cn.dt.weixin.message.menu.Menu;
//
//public class MenuUtilTest {
//	@Test
//	public void testConvert2MenuJson() {
//		Menu m = new Menu();
//
//		// ClickButton b = new ClickButton("点击按钮", "KEY_001");
//		// ViewButton v = new ViewButton("查看QQ",
//		// "http://mp.weixin.qq.com/s?__biz=MzA4ODE5MDYyOQ==&mid=200244679&idx=1&sn=3c9d91805467db020b45add08a14c00a#rd");
//		// ScanCodeWaitMsgButton s = new ScanCodeWaitMsgButton("扫码", "KEY_002");
//
//		// ParentButton p = new ParentButton();
//		// p.setName("健康管理");
//		ClickButton b1 = new ClickButton("制作主播卡", "KEY_001");
//		ClickButton b2 = new ClickButton("查看主播卡", "KEY_002");
//		// List<Button> l = new ArrayList<Button>();
//		// l.add(b1);
//		// l.add(b2);
//		// l.add(b3);
//		// l.add(b4);
//		// p.setSubButton(l);
//		//
//		// ParentButton p2 = new ParentButton();
//		// p2.setName("公益行动");
//		// ViewButton v1 = new ViewButton("国民体质检测",
//		// "http://mp.weixin.qq.com/s?__biz=MzA4ODE5MDYyOQ==&mid=200244679&idx=1&sn=3c9d91805467db020b45add08a14c00a#rd");
//		// ViewButton v2 = new ViewButton("痛经沙龙",
//		// "http://mp.weixin.qq.com/s?__biz=MzA4ODE5MDYyOQ==&mid=200230385&idx=1&sn=602168cc09ab099f440530786fccd5ca#rd");
//		// l = new ArrayList<Button>();
//		// l.add(v1);
//		// l.add(v2);
//		// p2.setSubButton(l);
//		//
//		// ParentButton p3 = new ParentButton();
//		// ViewButton v31 = new ViewButton("入职体检预约",
//		// "http://wap.howareyou.co/form/");
//		// ViewButton v32 = new ViewButton("体检报告查询",
//		// "http://www.chinamedical.net/baogao/");
//		// ViewButton v33 = new ViewButton("女性私密论坛",
//		// "http://wx.wsq.qq.com/247072462");
//		// l = new ArrayList<Button>();
//		// p3.setName("互动专区");
//		// l.add(v31);
//		// l.add(v32);
//		// l.add(v33);
//		// p3.setSubButton(l);
//
//		// ViewButton v1 = new ViewButton("抢票",
//		// "http://tangyu.tunnel.qydev.com/card");
//		//
//		//
//		// ParentButton p3 = new ParentButton();
//		// ViewButton v31 = new ViewButton("68元深度体检",
//		// "http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=201002461&idx=2&sn=e22461f90bd008a8ba1bc0712c2205f1");
//		// ViewButton v32 = new ViewButton("180元颈肩腰舒缓",
//		// "http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=201083969&idx=1&sn=3073cedc204a3ce87c04fd2a092ef288");
//		// l = new ArrayList<Button>();
//		// p3.setName("团购");
//		// l.add(v31);
//		// l.add(v32);
//		// p3.setSubButton(l);
//		//
//		//
//		//
//		m.getButtons().add(b1);
//		m.getButtons().add(b2);
//		// m.getButtons().add(v1);
//		// m.getButtons().add(p3);
//
//		System.out.println(MenuUtil.convert2MenuJson(m));
//		try {
//			MenuUtil.setMenu(m);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void getMenu() {
//		try {
//			MenuUtil.getMenu();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
