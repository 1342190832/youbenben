-- BUILD WITH MODEL TIME 700101T0800






drop table  if exists hospital_data;
create table hospital_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	address                       	varchar(24)                              comment '地址',
	telephone                     	varchar(44)                              comment '电话',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists expense_type_data;
create table expense_type_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(12)                              comment '名称',
	helper_chars                  	varchar(12)                              comment '辅助识字课',
	status                        	varchar(8)                               comment '状态',
	hospital                      	varchar(48)                              comment '医院',
	description                   	longtext                                 comment '描述',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists period_data;
create table period_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(8)                               comment '名称',
	code                          	varchar(36)                              comment '代码',
	hospital                      	varchar(48)                              comment '医院',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists expense_item_data;
create table expense_item_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(20)                              comment '名称',
	price                         	numeric(15,2)                            comment '价格',
	expense_type                  	varchar(48)                              comment '费用类型',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists doctor_data;
create table doctor_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(12)                              comment '名称',
	shot_image                    	varchar(512)                             comment '拍摄的图像',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists department_data;
create table department_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(12)                              comment '名称',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists doctor_assignment_data;
create table doctor_assignment_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(40)                              comment '名称',
	doctor                        	varchar(48)                              comment '医生',
	department                    	varchar(48)                              comment '部门',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists doctor_schedule_data;
create table doctor_schedule_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(116)                             comment '名称',
	doctor                        	varchar(48)                              comment '医生',
	schedule_date                 	date                                     comment '安排日期',
	period                        	varchar(48)                              comment '期',
	department                    	varchar(48)                              comment '部门',
	available                     	int                                      comment '可用',
	price                         	numeric(7,2)                             comment '价格',
	expense_type                  	varchar(48)                              comment '费用类型',
	create_time                   	datetime                                 comment '创建时间',
	update_time                   	datetime                                 comment '更新时间',
	hospital                      	varchar(48)                              comment '医院',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists mobile_app_data;
create table mobile_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists page_data;
create table page_data (
	id                            	varchar(48)          not null            comment 'ID',
	page_title                    	varchar(8)                               comment '页面标题',
	link_to_url                   	varchar(200)                             comment '链接网址',
	page_type                     	varchar(48)                              comment '页面类型',
	mobile_app                    	varchar(48)                              comment '手机应用程序',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists page_type_data;
create table page_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(48)                              comment '名称',
	code                          	varchar(56)                              comment '编码',
	mobile_app                    	varchar(48)                              comment '手机应用程序',
	footer_tab                    	tinyint                                  comment '页脚选项卡',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists slide_data;
create table slide_data (
	id                            	varchar(48)          not null            comment 'ID',
	display_order                 	int                                      comment '顺序',
	name                          	varchar(20)                              comment '名称',
	image_url                     	varchar(512)                             comment '图片链接',
	video_url                     	varchar(512)                             comment '视频网址',
	link_to_url                   	varchar(68)                              comment '链接网址',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists ui_action_data;
create table ui_action_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(24)                              comment '编码',
	icon                          	varchar(40)                              comment '图标',
	title                         	varchar(8)                               comment '标题',
	brief                         	varchar(36)                              comment '短暂的',
	image_url                     	varchar(512)                             comment '图片链接',
	link_to_url                   	varchar(68)                              comment '链接网址',
	extra_data                    	longtext                                 comment '额外的数据',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists section_data;
create table section_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(8)                               comment '标题',
	brief                         	varchar(28)                              comment '短暂的',
	icon                          	varchar(40)                              comment '图标',
	view_group                    	varchar(40)                              comment '视图组',
	link_to_url                   	varchar(68)                              comment '链接网址',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment '序号',
	user_identity                 	varchar(40)                              comment '用户身份',
	user_special_functions        	varchar(200)                             comment '用户特殊功能',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment '序号',
	login                         	varchar(256)                             comment '登录',
	mobile                        	varchar(11)                              comment '手机号码',
	email                         	varchar(256)                             comment '电子邮件',
	pwd                           	varchar(64)                              comment '密码',
	weixin_openid                 	varchar(128)                             comment '微信openid',
	weixin_appid                  	varchar(128)                             comment '微信Appid',
	access_token                  	varchar(128)                             comment '访问令牌',
	verification_code             	int                                      comment '验证码',
	verification_code_expire      	datetime                                 comment '验证码过期',
	last_login_time               	datetime                                 comment '最后登录时间',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment '序号',
	title                         	varchar(300)                             comment '标题',
	sec_user                      	varchar(48)                              comment '安全用户',
	app_icon                      	varchar(36)                              comment '应用程序图标',
	full_access                   	tinyint                                  comment '完全访问',
	permission                    	varchar(16)                              comment '许可',
	object_type                   	varchar(100)                             comment '访问对象类型',
	object_id                     	varchar(40)                              comment '对象ID',
	location                      	varchar(48)                              comment '位置',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	icon                          	varchar(200)                             comment '图标',
	image_path                    	varchar(512)                             comment '图片路径',
	link_target                   	varchar(200)                             comment '链接的目标',
	create_time                   	datetime                                 comment '创建时间',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	internal_name                 	varchar(200)                             comment '内部名称',
	read_permission               	tinyint                                  comment '读权限',
	create_permission             	tinyint                                  comment '创建权限',
	delete_permission             	tinyint                                  comment '删除权限',
	update_permission             	tinyint                                  comment '更新许可',
	execution_permission          	tinyint                                  comment '执行权限',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment '序号',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '安全用户',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512)                             comment '图片',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists wechat_workapp_identify_data;
create table wechat_workapp_identify_data (
	id                            	varchar(48)          not null            comment 'ID',
	corp_id                       	varchar(100)                             comment '公司标识',
	user_id                       	varchar(100)                             comment '用户Id',
	sec_user                      	varchar(48)                              comment '安全用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists wechat_miniapp_identify_data;
create table wechat_miniapp_identify_data (
	id                            	varchar(48)          not null            comment 'ID',
	open_id                       	varchar(128)                             comment '开放Id',
	app_id                        	varchar(128)                             comment '应用程序Id',
	sec_user                      	varchar(48)                              comment '安全用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists keypair_identify_data;
create table keypair_identify_data (
	id                            	varchar(48)          not null            comment 'ID',
	public_key                    	longtext                                 comment '公钥',
	key_type                      	varchar(48)                              comment '密钥类型',
	sec_user                      	varchar(48)                              comment '安全用户',
	create_time                   	datetime                                 comment '创建时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists public_key_type_data;
create table public_key_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	code                          	varchar(12)                              comment '编码',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists tree_node_data;
create table tree_node_data (
	id                            	varchar(48)          not null            comment 'ID',
	node_id                       	varchar(40)                              comment '节点Id',
	node_type                     	varchar(32)                              comment '节点类型',
	left_value                    	int                                      comment '左值',
	right_value                   	int                                      comment '正确的价值',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance




insert into hospital_data values
	('H000001','上和医院','毕升路22号','028-9123123','1');

insert into expense_type_data values
	('ET000001','诊疗费','zlf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-04-25 13:57:01','1'),
	('ET000002','治疗费','zlf','停用','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-04-24 04:18:16','1'),
	('ET000003','检查费','jcf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-04-20 21:36:55','1'),
	('ET000004','诊疗费','zlf','停用','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-04-17 15:10:09','1');

insert into period_data values
	('MORNING','上午','MORNING','H000001','1'),
	('AFTERNOON','下午','AFTERNOON','H000001','1'),
	('NIGHT','夜班','NIGHT','H000001','1');

insert into expense_item_data values
	('EI000001','专家诊疗费','72545386496.00','ET000001','H000001','2020-04-25 03:47:54','1'),
	('EI000002','血常规','97185382400.00','ET000001','H000001','2020-04-21 00:44:29','1'),
	('EI000003','煎药费','91592622080.00','ET000001','H000001','2020-04-16 14:01:54','1'),
	('EI000004','专家诊疗费','78508597248.00','ET000001','H000001','2020-04-23 18:54:44','1'),
	('EI000005','血常规','86046277632.00','ET000002','H000001','2020-04-06 20:45:55','1'),
	('EI000006','煎药费','89474891776.00','ET000002','H000001','2020-04-21 05:14:37','1'),
	('EI000007','专家诊疗费','86233260032.00','ET000002','H000001','2020-04-17 16:00:18','1'),
	('EI000008','血常规','76044738560.00','ET000002','H000001','2020-04-07 10:47:45','1'),
	('EI000009','煎药费','90896900096.00','ET000003','H000001','2020-04-12 16:19:03','1'),
	('EI000010','专家诊疗费','73722929152.00','ET000003','H000001','2020-04-09 12:11:00','1'),
	('EI000011','血常规','80554827776.00','ET000003','H000001','2020-04-19 11:30:52','1'),
	('EI000012','煎药费','87664820224.00','ET000003','H000001','2020-04-16 01:48:33','1'),
	('EI000013','专家诊疗费','92507652096.00','ET000004','H000001','2020-04-18 01:16:50','1'),
	('EI000014','血常规','78140342272.00','ET000004','H000001','2020-04-09 16:33:38','1'),
	('EI000015','煎药费','84026122240.00','ET000004','H000001','2020-04-22 15:35:19','1'),
	('EI000016','专家诊疗费','78805942272.00','ET000004','H000001','2020-04-03 20:56:12','1');

insert into doctor_data values
	('D000001','魏松全','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0001/400/300/red/','H000001','2020-04-17 21:10:27','1'),
	('D000002','魏松全0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0002/400/300/red/','H000001','2020-04-22 06:27:24','1'),
	('D000003','魏松全0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0003/400/300/red/','H000001','2020-04-19 03:26:40','1'),
	('D000004','魏松全0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0004/400/300/red/','H000001','2020-04-25 00:53:36','1');

insert into department_data values
	('D000001','放射科','H000001','2020-04-21 12:54:34','1'),
	('D000002','放射科0002','H000001','2020-04-03 22:07:09','1'),
	('D000003','放射科0003','H000001','2020-04-12 11:35:50','1'),
	('D000004','放射科0004','H000001','2020-04-12 14:01:30','1');

insert into doctor_assignment_data values
	('DA000001','魏松全在内分泌科室上','D000001','D000001','2020-04-06 15:00:20','1'),
	('DA000002','魏松全在内分泌科室上0002','D000001','D000001','2020-04-15 13:14:25','1'),
	('DA000003','魏松全在内分泌科室上0003','D000001','D000001','2020-04-22 10:03:48','1'),
	('DA000004','魏松全在内分泌科室上0004','D000001','D000001','2020-04-11 15:16:24','1'),
	('DA000005','魏松全在内分泌科室上0005','D000002','D000002','2020-04-13 06:30:58','1'),
	('DA000006','魏松全在内分泌科室上0006','D000002','D000002','2020-04-08 06:22:04','1'),
	('DA000007','魏松全在内分泌科室上0007','D000002','D000002','2020-04-23 17:05:31','1'),
	('DA000008','魏松全在内分泌科室上0008','D000002','D000002','2020-04-05 15:55:58','1'),
	('DA000009','魏松全在内分泌科室上0009','D000003','D000003','2020-04-08 17:26:18','1'),
	('DA000010','魏松全在内分泌科室上0010','D000003','D000003','2020-04-15 16:26:05','1'),
	('DA000011','魏松全在内分泌科室上0011','D000003','D000003','2020-04-12 22:41:13','1'),
	('DA000012','魏松全在内分泌科室上0012','D000003','D000003','2020-04-25 14:56:35','1'),
	('DA000013','魏松全在内分泌科室上0013','D000004','D000004','2020-04-08 14:03:13','1'),
	('DA000014','魏松全在内分泌科室上0014','D000004','D000004','2020-04-15 21:43:56','1'),
	('DA000015','魏松全在内分泌科室上0015','D000004','D000004','2020-04-15 20:57:19','1'),
	('DA000016','魏松全在内分泌科室上0016','D000004','D000004','2020-04-04 00:29:31','1');

insert into doctor_schedule_data values
	('DS000001','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10','D000001','2018-10-13','MORNING','D000001','15','123.66','ET000001','2020-04-12 15:13:18','2020-04-21 01:02:42','H000001','1'),
	('DS000002','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100002','D000001','2017-09-18','MORNING','D000001','16','102.62','ET000001','2020-04-08 14:18:26','2020-04-21 14:59:14','H000001','1'),
	('DS000003','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100003','D000001','2017-06-12','MORNING','D000001','20','90.69','ET000001','2020-04-14 01:43:30','2020-04-05 14:30:56','H000001','1'),
	('DS000004','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100004','D000001','2017-09-27','MORNING','D000001','20','107.84','ET000001','2020-04-22 08:09:10','2020-04-11 13:54:38','H000001','1'),
	('DS000005','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100005','D000002','2018-12-22','MORNING','D000002','18','92.28','ET000002','2020-04-17 21:41:46','2020-04-19 13:15:46','H000001','1'),
	('DS000006','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100006','D000002','2019-05-23','MORNING','D000002','15','98.94','ET000002','2020-04-16 18:31:02','2020-04-05 17:49:25','H000001','1'),
	('DS000007','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100007','D000002','2019-06-28','AFTERNOON','D000002','15','117.18','ET000002','2020-04-05 05:57:11','2020-04-06 20:23:20','H000001','1'),
	('DS000008','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100008','D000002','2019-08-20','AFTERNOON','D000002','17','119.92','ET000002','2020-04-16 00:36:16','2020-04-06 17:34:28','H000001','1'),
	('DS000009','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100009','D000003','2018-10-24','AFTERNOON','D000003','18','117.98','ET000003','2020-04-04 11:34:08','2020-04-22 02:53:19','H000001','1'),
	('DS000010','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100010','D000003','2017-11-18','AFTERNOON','D000003','19','94.25','ET000003','2020-04-10 05:12:26','2020-04-15 15:22:32','H000001','1'),
	('DS000011','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100011','D000003','2017-06-04','AFTERNOON','D000003','20','122.50','ET000003','2020-04-10 15:45:14','2020-04-21 21:25:06','H000001','1'),
	('DS000012','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100012','D000003','2018-09-15','NIGHT','D000003','15','101.40','ET000003','2020-04-23 09:40:22','2020-04-17 21:10:11','H000001','1'),
	('DS000013','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100013','D000004','2018-02-04','NIGHT','D000004','16','112.76','ET000004','2020-04-23 17:41:37','2020-04-14 23:14:38','H000001','1'),
	('DS000014','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100014','D000004','2020-04-24','NIGHT','D000004','18','121.19','ET000004','2020-04-05 08:24:02','2020-04-25 04:30:20','H000001','1'),
	('DS000015','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100015','D000004','2017-10-11','NIGHT','D000004','18','89.85','ET000004','2020-04-16 16:40:01','2020-04-20 09:39:58','H000001','1'),
	('DS000016','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100016','D000004','2019-04-13','NIGHT','D000004','16','108.61','ET000004','2020-04-18 14:57:32','2020-04-11 08:02:07','H000001','1');

insert into mobile_app_data values
	('MA000001','移动端配置','1');

insert into page_data values
	('P000001','首页','首页','home','MA000001','1'),
	('P000002','首页0002','首页0002','home','MA000001','1'),
	('P000003','首页0003','首页0003','home','MA000001','1'),
	('P000004','首页0004','首页0004','me','MA000001','1'),
	('P000005','首页0005','首页0005','me','MA000001','1'),
	('P000006','首页0006','首页0006','me','MA000001','1'),
	('P000007','首页0007','首页0007','generic-page','MA000001','1'),
	('P000008','首页0008','首页0008','generic-page','MA000001','1'),
	('P000009','首页0009','首页0009','listof-page','MA000001','1'),
	('P000010','首页0010','首页0010','listof-page','MA000001','1'),
	('P000011','首页0011','首页0011','listof-page','MA000001','1'),
	('P000012','首页0012','首页0012','service-center','MA000001','1'),
	('P000013','首页0013','首页0013','service-center','MA000001','1'),
	('P000014','首页0014','首页0014','service-center','MA000001','1'),
	('P000015','首页0015','首页0015','simple','MA000001','1'),
	('P000016','首页0016','首页0016','simple','MA000001','1');

insert into page_type_data values
	('home','首页','home','MA000001','1','1'),
	('me','我的','me','MA000001','1','1'),
	('generic-page','Generic Page','generic-page','MA000001','1','1'),
	('listof-page','Listof Page','listof-page','MA000001','1','1'),
	('service-center','功能大厅','service-center','MA000001','1','1'),
	('simple','普通','simple','MA000001','1','1');

insert into slide_data values
	('S000001','1','首页Focus的内容','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000001','1'),
	('S000002','2','首页Focus的内容0002','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000001','1'),
	('S000003','3','首页Focus的内容0003','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000001','1'),
	('S000004','1','首页Focus的内容0004','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000001','1'),
	('S000005','2','首页Focus的内容0005','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000002','1'),
	('S000006','3','首页Focus的内容0006','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000002','1'),
	('S000007','1','首页Focus的内容0007','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000002','1'),
	('S000008','2','首页Focus的内容0008','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000002','1'),
	('S000009','3','首页Focus的内容0009','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000003','1'),
	('S000010','1','首页Focus的内容0010','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000003','1'),
	('S000011','2','首页Focus的内容0011','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000003','1'),
	('S000012','3','首页Focus的内容0012','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000003','1'),
	('S000013','1','首页Focus的内容0013','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000004','1'),
	('S000014','2','首页Focus的内容0014','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000004','1'),
	('S000015','3','首页Focus的内容0015','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000004','1'),
	('S000016','1','首页Focus的内容0016','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000004','1'),
	('S000017','2','首页Focus的内容0017','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000005','1'),
	('S000018','3','首页Focus的内容0018','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000005','1'),
	('S000019','1','首页Focus的内容0019','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000005','1'),
	('S000020','2','首页Focus的内容0020','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000005','1'),
	('S000021','3','首页Focus的内容0021','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000006','1'),
	('S000022','1','首页Focus的内容0022','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000006','1'),
	('S000023','2','首页Focus的内容0023','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000006','1'),
	('S000024','3','首页Focus的内容0024','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000006','1'),
	('S000025','1','首页Focus的内容0025','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000007','1'),
	('S000026','2','首页Focus的内容0026','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000007','1'),
	('S000027','3','首页Focus的内容0027','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000007','1'),
	('S000028','1','首页Focus的内容0028','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000007','1'),
	('S000029','2','首页Focus的内容0029','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000008','1'),
	('S000030','3','首页Focus的内容0030','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000008','1'),
	('S000031','1','首页Focus的内容0031','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000008','1'),
	('S000032','2','首页Focus的内容0032','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000008','1'),
	('S000033','3','首页Focus的内容0033','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000009','1'),
	('S000034','1','首页Focus的内容0034','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000009','1'),
	('S000035','2','首页Focus的内容0035','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000009','1'),
	('S000036','3','首页Focus的内容0036','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000009','1'),
	('S000037','1','首页Focus的内容0037','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000010','1'),
	('S000038','2','首页Focus的内容0038','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000010','1'),
	('S000039','3','首页Focus的内容0039','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000010','1'),
	('S000040','1','首页Focus的内容0040','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000010','1'),
	('S000041','2','首页Focus的内容0041','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000011','1'),
	('S000042','3','首页Focus的内容0042','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000011','1'),
	('S000043','1','首页Focus的内容0043','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000011','1'),
	('S000044','2','首页Focus的内容0044','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000011','1'),
	('S000045','3','首页Focus的内容0045','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000012','1'),
	('S000046','1','首页Focus的内容0046','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000012','1'),
	('S000047','2','首页Focus的内容0047','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000012','1'),
	('S000048','3','首页Focus的内容0048','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000012','1'),
	('S000049','1','首页Focus的内容0049','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000013','1'),
	('S000050','2','首页Focus的内容0050','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000013','1'),
	('S000051','3','首页Focus的内容0051','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000013','1'),
	('S000052','1','首页Focus的内容0052','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000013','1'),
	('S000053','2','首页Focus的内容0053','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000014','1'),
	('S000054','3','首页Focus的内容0054','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000014','1'),
	('S000055','1','首页Focus的内容0055','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000014','1'),
	('S000056','2','首页Focus的内容0056','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000014','1'),
	('S000057','3','首页Focus的内容0057','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000015','1'),
	('S000058','1','首页Focus的内容0058','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000015','1'),
	('S000059','2','首页Focus的内容0059','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000015','1'),
	('S000060','3','首页Focus的内容0060','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000015','1'),
	('S000061','1','首页Focus的内容0061','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000016','1'),
	('S000062','2','首页Focus的内容0062','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000016','1'),
	('S000063','3','首页Focus的内容0063','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000016','1'),
	('S000064','1','首页Focus的内容0064','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000016','1');

insert into ui_action_data values
	('UA000001','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000002','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0002','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000003','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0003','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000004','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0004','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000005','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0005','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000006','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0006','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000007','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0007','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000008','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0008','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000009','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0009','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000010','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0010','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000011','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0011','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000012','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0012','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000013','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0013','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000014','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0014','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000015','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0015','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000016','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0016','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000017','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0017','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000018','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0018','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000019','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0019','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000020','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0020','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000021','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0021','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000022','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0022','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000023','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0023','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000024','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0024','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000025','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0025','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000026','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0026','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000027','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0027','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000028','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0028','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000029','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0029','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000030','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0030','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000031','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0031','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000032','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0032','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000033','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0033','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000034','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0034','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000035','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0035','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000036','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0036','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000037','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0037','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000038','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0038','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000039','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0039','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000040','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0040','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000041','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0041','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000042','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0042','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000043','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0043','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000044','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0044','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000045','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0045','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000046','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0046','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000047','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0047','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000048','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0048','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000049','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0049','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000050','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0050','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000051','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0051','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000052','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0052','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000053','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0053','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000054','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0054','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000055','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0055','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000056','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0056','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000057','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0057','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000058','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0058','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000059','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0059','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000060','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0060','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000061','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0061','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1'),
	('UA000062','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0062','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1'),
	('UA000063','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0063','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1'),
	('UA000064','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0064','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1');

insert into section_data values
	('S000001','文章','Article','icon_edit','icon_edit','/section/article/','P000001','1'),
	('S000002','作品','Artwork','icon_share','icon_share','/section/article/0002','P000001','1'),
	('S000003','文章','Article','icon_eye','icon_eye','/section/article/0003','P000001','1'),
	('S000004','作品','Artwork','icon_more','icon_more','/section/article/0004','P000001','1'),
	('S000005','文章','Article','icon_edit','icon_edit','/section/article/0005','P000002','1'),
	('S000006','作品','Artwork','icon_share','icon_share','/section/article/0006','P000002','1'),
	('S000007','文章','Article','icon_eye','icon_eye','/section/article/0007','P000002','1'),
	('S000008','作品','Artwork','icon_more','icon_more','/section/article/0008','P000002','1'),
	('S000009','文章','Article','icon_edit','icon_edit','/section/article/0009','P000003','1'),
	('S000010','作品','Artwork','icon_share','icon_share','/section/article/0010','P000003','1'),
	('S000011','文章','Article','icon_eye','icon_eye','/section/article/0011','P000003','1'),
	('S000012','作品','Artwork','icon_more','icon_more','/section/article/0012','P000003','1'),
	('S000013','文章','Article','icon_edit','icon_edit','/section/article/0013','P000004','1'),
	('S000014','作品','Artwork','icon_share','icon_share','/section/article/0014','P000004','1'),
	('S000015','文章','Article','icon_eye','icon_eye','/section/article/0015','P000004','1'),
	('S000016','作品','Artwork','icon_more','icon_more','/section/article/0016','P000004','1'),
	('S000017','文章','Article','icon_edit','icon_edit','/section/article/0017','P000005','1'),
	('S000018','作品','Artwork','icon_share','icon_share','/section/article/0018','P000005','1'),
	('S000019','文章','Article','icon_eye','icon_eye','/section/article/0019','P000005','1'),
	('S000020','作品','Artwork','icon_more','icon_more','/section/article/0020','P000005','1'),
	('S000021','文章','Article','icon_edit','icon_edit','/section/article/0021','P000006','1'),
	('S000022','作品','Artwork','icon_share','icon_share','/section/article/0022','P000006','1'),
	('S000023','文章','Article','icon_eye','icon_eye','/section/article/0023','P000006','1'),
	('S000024','作品','Artwork','icon_more','icon_more','/section/article/0024','P000006','1'),
	('S000025','文章','Article','icon_edit','icon_edit','/section/article/0025','P000007','1'),
	('S000026','作品','Artwork','icon_share','icon_share','/section/article/0026','P000007','1'),
	('S000027','文章','Article','icon_eye','icon_eye','/section/article/0027','P000007','1'),
	('S000028','作品','Artwork','icon_more','icon_more','/section/article/0028','P000007','1'),
	('S000029','文章','Article','icon_edit','icon_edit','/section/article/0029','P000008','1'),
	('S000030','作品','Artwork','icon_share','icon_share','/section/article/0030','P000008','1'),
	('S000031','文章','Article','icon_eye','icon_eye','/section/article/0031','P000008','1'),
	('S000032','作品','Artwork','icon_more','icon_more','/section/article/0032','P000008','1'),
	('S000033','文章','Article','icon_edit','icon_edit','/section/article/0033','P000009','1'),
	('S000034','作品','Artwork','icon_share','icon_share','/section/article/0034','P000009','1'),
	('S000035','文章','Article','icon_eye','icon_eye','/section/article/0035','P000009','1'),
	('S000036','作品','Artwork','icon_more','icon_more','/section/article/0036','P000009','1'),
	('S000037','文章','Article','icon_edit','icon_edit','/section/article/0037','P000010','1'),
	('S000038','作品','Artwork','icon_share','icon_share','/section/article/0038','P000010','1'),
	('S000039','文章','Article','icon_eye','icon_eye','/section/article/0039','P000010','1'),
	('S000040','作品','Artwork','icon_more','icon_more','/section/article/0040','P000010','1'),
	('S000041','文章','Article','icon_edit','icon_edit','/section/article/0041','P000011','1'),
	('S000042','作品','Artwork','icon_share','icon_share','/section/article/0042','P000011','1'),
	('S000043','文章','Article','icon_eye','icon_eye','/section/article/0043','P000011','1'),
	('S000044','作品','Artwork','icon_more','icon_more','/section/article/0044','P000011','1'),
	('S000045','文章','Article','icon_edit','icon_edit','/section/article/0045','P000012','1'),
	('S000046','作品','Artwork','icon_share','icon_share','/section/article/0046','P000012','1'),
	('S000047','文章','Article','icon_eye','icon_eye','/section/article/0047','P000012','1'),
	('S000048','作品','Artwork','icon_more','icon_more','/section/article/0048','P000012','1'),
	('S000049','文章','Article','icon_edit','icon_edit','/section/article/0049','P000013','1'),
	('S000050','作品','Artwork','icon_share','icon_share','/section/article/0050','P000013','1'),
	('S000051','文章','Article','icon_eye','icon_eye','/section/article/0051','P000013','1'),
	('S000052','作品','Artwork','icon_more','icon_more','/section/article/0052','P000013','1'),
	('S000053','文章','Article','icon_edit','icon_edit','/section/article/0053','P000014','1'),
	('S000054','作品','Artwork','icon_share','icon_share','/section/article/0054','P000014','1'),
	('S000055','文章','Article','icon_eye','icon_eye','/section/article/0055','P000014','1'),
	('S000056','作品','Artwork','icon_more','icon_more','/section/article/0056','P000014','1'),
	('S000057','文章','Article','icon_edit','icon_edit','/section/article/0057','P000015','1'),
	('S000058','作品','Artwork','icon_share','icon_share','/section/article/0058','P000015','1'),
	('S000059','文章','Article','icon_eye','icon_eye','/section/article/0059','P000015','1'),
	('S000060','作品','Artwork','icon_more','icon_more','/section/article/0060','P000015','1'),
	('S000061','文章','Article','icon_edit','icon_edit','/section/article/0061','P000016','1'),
	('S000062','作品','Artwork','icon_share','icon_share','/section/article/0062','P000016','1'),
	('S000063','文章','Article','icon_eye','icon_eye','/section/article/0063','P000016','1'),
	('S000064','作品','Artwork','icon_more','icon_more','/section/article/0064','P000016','1');

insert into user_domain_data values
	('UD000001','用户区域','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1'),
	('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1'),
	('UWL000004','13808188512','tester;ios-spokesperson0004','UD000001','1');

insert into sec_user_data values
	('SU000001','login','13900000001','suddy_chang@163.com','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2020-04-14 01:09:00','2020-04-24 09:59:10','UD000001','1'),
	('SU000002','login0002','13900000002','2@qq.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2020-04-14 18:44:24','2020-04-20 15:34:41','UD000001','1'),
	('SU000003','login0003','13900000003','3@qq.com','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','wx123456789abcdefghijklmn0003','wxapp120984102398400003','jwt_token_123456780003','0','2020-04-18 10:44:05','2020-04-14 06:14:40','UD000001','1'),
	('SU000004','login0004','13900000004','4@qq.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','wx123456789abcdefghijklmn0004','wxapp120984102398400004','jwt_token_123456780004','9999999','2020-04-21 17:42:55','2020-04-05 20:23:00','UD000001','1');

insert into user_app_data values
	('UA000001','审车平台','SU000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','账户管理','SU000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','接车公司','SU000001','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','审车公司','SU000001','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1'),
	('UA000005','维修公司','SU000002','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1'),
	('UA000006','顾客','SU000002','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0006','1'),
	('UA000007','审车平台','SU000002','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0007','1'),
	('UA000008','账户管理','SU000002','bank','1','MXWR','UserDomain','UD000001','/link/to/app0008','1'),
	('UA000009','接车公司','SU000003','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0009','1'),
	('UA000010','审车公司','SU000003','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0010','1'),
	('UA000011','维修公司','SU000003','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0011','1'),
	('UA000012','顾客','SU000003','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0012','1'),
	('UA000013','审车平台','SU000004','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0013','1'),
	('UA000014','账户管理','SU000004','bank','1','MXWR','UserDomain','UD000001','/link/to/app0014','1'),
	('UA000015','接车公司','SU000004','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0015','1'),
	('UA000016','审车公司','SU000004','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0016','1');

insert into quick_link_data values
	('QL000001','列表','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0001/200/200/red/','列表','2020-04-12 02:51:28','UA000001','1'),
	('QL000002','列表0002','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0002/200/200/red/','列表0002','2020-04-04 17:17:40','UA000001','1'),
	('QL000003','列表0003','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0003/200/200/red/','列表0003','2020-04-08 00:13:01','UA000001','1'),
	('QL000004','列表0004','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0004/200/200/red/','列表0004','2020-04-19 10:49:45','UA000001','1'),
	('QL000005','列表0005','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0005/200/200/red/','列表0005','2020-04-10 20:51:12','UA000002','1'),
	('QL000006','列表0006','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0006/200/200/red/','列表0006','2020-04-09 18:34:12','UA000002','1'),
	('QL000007','列表0007','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0007/200/200/red/','列表0007','2020-04-20 17:08:19','UA000002','1'),
	('QL000008','列表0008','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0008/200/200/red/','列表0008','2020-04-22 08:19:37','UA000002','1'),
	('QL000009','列表0009','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0009/200/200/red/','列表0009','2020-04-15 09:44:58','UA000003','1'),
	('QL000010','列表0010','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0010/200/200/red/','列表0010','2020-04-21 18:01:01','UA000003','1'),
	('QL000011','列表0011','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0011/200/200/red/','列表0011','2020-04-08 21:10:29','UA000003','1'),
	('QL000012','列表0012','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0012/200/200/red/','列表0012','2020-04-12 05:17:07','UA000003','1'),
	('QL000013','列表0013','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0013/200/200/red/','列表0013','2020-04-21 12:40:18','UA000004','1'),
	('QL000014','列表0014','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0014/200/200/red/','列表0014','2020-04-20 13:09:51','UA000004','1'),
	('QL000015','列表0015','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0015/200/200/red/','列表0015','2020-04-12 02:52:08','UA000004','1'),
	('QL000016','列表0016','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0016/200/200/red/','列表0016','2020-04-05 11:59:15','UA000004','1'),
	('QL000017','列表0017','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0017/200/200/red/','列表0017','2020-04-11 02:41:20','UA000005','1'),
	('QL000018','列表0018','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0018/200/200/red/','列表0018','2020-04-21 15:55:53','UA000005','1'),
	('QL000019','列表0019','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0019/200/200/red/','列表0019','2020-04-04 14:32:35','UA000005','1'),
	('QL000020','列表0020','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0020/200/200/red/','列表0020','2020-04-21 10:17:42','UA000005','1'),
	('QL000021','列表0021','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0021/200/200/red/','列表0021','2020-04-24 00:31:28','UA000006','1'),
	('QL000022','列表0022','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0022/200/200/red/','列表0022','2020-04-15 13:28:17','UA000006','1'),
	('QL000023','列表0023','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0023/200/200/red/','列表0023','2020-04-14 15:47:52','UA000006','1'),
	('QL000024','列表0024','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0024/200/200/red/','列表0024','2020-04-09 11:49:03','UA000006','1'),
	('QL000025','列表0025','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0025/200/200/red/','列表0025','2020-04-25 05:29:09','UA000007','1'),
	('QL000026','列表0026','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0026/200/200/red/','列表0026','2020-04-18 18:17:49','UA000007','1'),
	('QL000027','列表0027','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0027/200/200/red/','列表0027','2020-04-07 07:17:55','UA000007','1'),
	('QL000028','列表0028','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0028/200/200/red/','列表0028','2020-04-18 16:34:07','UA000007','1'),
	('QL000029','列表0029','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0029/200/200/red/','列表0029','2020-04-13 05:54:05','UA000008','1'),
	('QL000030','列表0030','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0030/200/200/red/','列表0030','2020-04-20 18:31:14','UA000008','1'),
	('QL000031','列表0031','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0031/200/200/red/','列表0031','2020-04-20 11:01:24','UA000008','1'),
	('QL000032','列表0032','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0032/200/200/red/','列表0032','2020-04-11 08:18:00','UA000008','1'),
	('QL000033','列表0033','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0033/200/200/red/','列表0033','2020-04-15 10:43:48','UA000009','1'),
	('QL000034','列表0034','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0034/200/200/red/','列表0034','2020-04-13 01:14:01','UA000009','1'),
	('QL000035','列表0035','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0035/200/200/red/','列表0035','2020-04-23 09:01:45','UA000009','1'),
	('QL000036','列表0036','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0036/200/200/red/','列表0036','2020-04-13 11:55:46','UA000009','1'),
	('QL000037','列表0037','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0037/200/200/red/','列表0037','2020-04-20 11:48:01','UA000010','1'),
	('QL000038','列表0038','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0038/200/200/red/','列表0038','2020-04-15 14:28:46','UA000010','1'),
	('QL000039','列表0039','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0039/200/200/red/','列表0039','2020-04-14 08:18:00','UA000010','1'),
	('QL000040','列表0040','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0040/200/200/red/','列表0040','2020-04-16 05:30:44','UA000010','1'),
	('QL000041','列表0041','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0041/200/200/red/','列表0041','2020-04-18 17:33:08','UA000011','1'),
	('QL000042','列表0042','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0042/200/200/red/','列表0042','2020-04-15 00:43:22','UA000011','1'),
	('QL000043','列表0043','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0043/200/200/red/','列表0043','2020-04-07 09:10:20','UA000011','1'),
	('QL000044','列表0044','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0044/200/200/red/','列表0044','2020-04-15 12:04:09','UA000011','1'),
	('QL000045','列表0045','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0045/200/200/red/','列表0045','2020-04-04 19:00:35','UA000012','1'),
	('QL000046','列表0046','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0046/200/200/red/','列表0046','2020-04-17 02:47:52','UA000012','1'),
	('QL000047','列表0047','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0047/200/200/red/','列表0047','2020-04-15 23:59:26','UA000012','1'),
	('QL000048','列表0048','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0048/200/200/red/','列表0048','2020-04-13 10:28:33','UA000012','1'),
	('QL000049','列表0049','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0049/200/200/red/','列表0049','2020-04-06 03:22:00','UA000013','1'),
	('QL000050','列表0050','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0050/200/200/red/','列表0050','2020-04-11 12:00:44','UA000013','1'),
	('QL000051','列表0051','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0051/200/200/red/','列表0051','2020-04-20 21:49:43','UA000013','1'),
	('QL000052','列表0052','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0052/200/200/red/','列表0052','2020-04-23 01:07:35','UA000013','1'),
	('QL000053','列表0053','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0053/200/200/red/','列表0053','2020-04-17 12:52:36','UA000014','1'),
	('QL000054','列表0054','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0054/200/200/red/','列表0054','2020-04-13 04:37:03','UA000014','1'),
	('QL000055','列表0055','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0055/200/200/red/','列表0055','2020-04-17 19:31:05','UA000014','1'),
	('QL000056','列表0056','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0056/200/200/red/','列表0056','2020-04-04 03:37:29','UA000014','1'),
	('QL000057','列表0057','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0057/200/200/red/','列表0057','2020-04-19 20:39:01','UA000015','1'),
	('QL000058','列表0058','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0058/200/200/red/','列表0058','2020-04-18 06:00:00','UA000015','1'),
	('QL000059','列表0059','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0059/200/200/red/','列表0059','2020-04-12 01:15:21','UA000015','1'),
	('QL000060','列表0060','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0060/200/200/red/','列表0060','2020-04-20 21:31:29','UA000015','1'),
	('QL000061','列表0061','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0061/200/200/red/','列表0061','2020-04-13 13:18:27','UA000016','1'),
	('QL000062','列表0062','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0062/200/200/red/','列表0062','2020-04-24 17:19:34','UA000016','1'),
	('QL000063','列表0063','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0063/200/200/red/','列表0063','2020-04-25 04:43:33','UA000016','1'),
	('QL000064','列表0064','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y0064/200/200/red/','列表0064','2020-04-21 00:43:06','UA000016','1');

insert into list_access_data values
	('LA000001','列表','levelOneCategoryList','1','1','1','1','1','UA000001','1'),
	('LA000002','列表0002','levelOneCategoryList0002','1','1','1','1','1','UA000001','1'),
	('LA000003','列表0003','levelOneCategoryList0003','1','1','1','1','1','UA000001','1'),
	('LA000004','列表0004','levelOneCategoryList0004','1','1','1','1','1','UA000001','1'),
	('LA000005','列表0005','levelOneCategoryList0005','1','1','1','1','1','UA000002','1'),
	('LA000006','列表0006','levelOneCategoryList0006','1','1','1','1','1','UA000002','1'),
	('LA000007','列表0007','levelOneCategoryList0007','1','1','1','1','1','UA000002','1'),
	('LA000008','列表0008','levelOneCategoryList0008','1','1','1','1','1','UA000002','1'),
	('LA000009','列表0009','levelOneCategoryList0009','1','1','1','1','1','UA000003','1'),
	('LA000010','列表0010','levelOneCategoryList0010','1','1','1','1','1','UA000003','1'),
	('LA000011','列表0011','levelOneCategoryList0011','1','1','1','1','1','UA000003','1'),
	('LA000012','列表0012','levelOneCategoryList0012','1','1','1','1','1','UA000003','1'),
	('LA000013','列表0013','levelOneCategoryList0013','1','1','1','1','1','UA000004','1'),
	('LA000014','列表0014','levelOneCategoryList0014','1','1','1','1','1','UA000004','1'),
	('LA000015','列表0015','levelOneCategoryList0015','1','1','1','1','1','UA000004','1'),
	('LA000016','列表0016','levelOneCategoryList0016','1','1','1','1','1','UA000004','1'),
	('LA000017','列表0017','levelOneCategoryList0017','1','1','1','1','1','UA000005','1'),
	('LA000018','列表0018','levelOneCategoryList0018','1','1','1','1','1','UA000005','1'),
	('LA000019','列表0019','levelOneCategoryList0019','1','1','1','1','1','UA000005','1'),
	('LA000020','列表0020','levelOneCategoryList0020','1','1','1','1','1','UA000005','1'),
	('LA000021','列表0021','levelOneCategoryList0021','1','1','1','1','1','UA000006','1'),
	('LA000022','列表0022','levelOneCategoryList0022','1','1','1','1','1','UA000006','1'),
	('LA000023','列表0023','levelOneCategoryList0023','1','1','1','1','1','UA000006','1'),
	('LA000024','列表0024','levelOneCategoryList0024','1','1','1','1','1','UA000006','1'),
	('LA000025','列表0025','levelOneCategoryList0025','1','1','1','1','1','UA000007','1'),
	('LA000026','列表0026','levelOneCategoryList0026','1','1','1','1','1','UA000007','1'),
	('LA000027','列表0027','levelOneCategoryList0027','1','1','1','1','1','UA000007','1'),
	('LA000028','列表0028','levelOneCategoryList0028','1','1','1','1','1','UA000007','1'),
	('LA000029','列表0029','levelOneCategoryList0029','1','1','1','1','1','UA000008','1'),
	('LA000030','列表0030','levelOneCategoryList0030','1','1','1','1','1','UA000008','1'),
	('LA000031','列表0031','levelOneCategoryList0031','1','1','1','1','1','UA000008','1'),
	('LA000032','列表0032','levelOneCategoryList0032','1','1','1','1','1','UA000008','1'),
	('LA000033','列表0033','levelOneCategoryList0033','1','1','1','1','1','UA000009','1'),
	('LA000034','列表0034','levelOneCategoryList0034','1','1','1','1','1','UA000009','1'),
	('LA000035','列表0035','levelOneCategoryList0035','1','1','1','1','1','UA000009','1'),
	('LA000036','列表0036','levelOneCategoryList0036','1','1','1','1','1','UA000009','1'),
	('LA000037','列表0037','levelOneCategoryList0037','1','1','1','1','1','UA000010','1'),
	('LA000038','列表0038','levelOneCategoryList0038','1','1','1','1','1','UA000010','1'),
	('LA000039','列表0039','levelOneCategoryList0039','1','1','1','1','1','UA000010','1'),
	('LA000040','列表0040','levelOneCategoryList0040','1','1','1','1','1','UA000010','1'),
	('LA000041','列表0041','levelOneCategoryList0041','1','1','1','1','1','UA000011','1'),
	('LA000042','列表0042','levelOneCategoryList0042','1','1','1','1','1','UA000011','1'),
	('LA000043','列表0043','levelOneCategoryList0043','1','1','1','1','1','UA000011','1'),
	('LA000044','列表0044','levelOneCategoryList0044','1','1','1','1','1','UA000011','1'),
	('LA000045','列表0045','levelOneCategoryList0045','1','1','1','1','1','UA000012','1'),
	('LA000046','列表0046','levelOneCategoryList0046','1','1','1','1','1','UA000012','1'),
	('LA000047','列表0047','levelOneCategoryList0047','1','1','1','1','1','UA000012','1'),
	('LA000048','列表0048','levelOneCategoryList0048','1','1','1','1','1','UA000012','1'),
	('LA000049','列表0049','levelOneCategoryList0049','1','1','1','1','1','UA000013','1'),
	('LA000050','列表0050','levelOneCategoryList0050','1','1','1','1','1','UA000013','1'),
	('LA000051','列表0051','levelOneCategoryList0051','1','1','1','1','1','UA000013','1'),
	('LA000052','列表0052','levelOneCategoryList0052','1','1','1','1','1','UA000013','1'),
	('LA000053','列表0053','levelOneCategoryList0053','1','1','1','1','1','UA000014','1'),
	('LA000054','列表0054','levelOneCategoryList0054','1','1','1','1','1','UA000014','1'),
	('LA000055','列表0055','levelOneCategoryList0055','1','1','1','1','1','UA000014','1'),
	('LA000056','列表0056','levelOneCategoryList0056','1','1','1','1','1','UA000014','1'),
	('LA000057','列表0057','levelOneCategoryList0057','1','1','1','1','1','UA000015','1'),
	('LA000058','列表0058','levelOneCategoryList0058','1','1','1','1','1','UA000015','1'),
	('LA000059','列表0059','levelOneCategoryList0059','1','1','1','1','1','UA000015','1'),
	('LA000060','列表0060','levelOneCategoryList0060','1','1','1','1','1','UA000015','1'),
	('LA000061','列表0061','levelOneCategoryList0061','1','1','1','1','1','UA000016','1'),
	('LA000062','列表0062','levelOneCategoryList0062','1','1','1','1','1','UA000016','1'),
	('LA000063','列表0063','levelOneCategoryList0063','1','1','1','1','1','UA000016','1'),
	('LA000064','列表0064','levelOneCategoryList0064','1','1','1','1','1','UA000016','1');

insert into login_history_data values
	('LH000001','2020-04-12 04:24:25','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2020-04-20 12:58:41','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2020-04-16 07:20:36','192.168.1.1','登陆成功0003','SU000001','1'),
	('LH000004','2020-04-19 11:05:44','192.168.1.2','登陆成功0004','SU000001','1'),
	('LH000005','2020-04-23 05:45:42','192.168.1.1','登陆成功0005','SU000002','1'),
	('LH000006','2020-04-12 20:56:04','192.168.1.2','登陆成功0006','SU000002','1'),
	('LH000007','2020-04-17 09:08:43','192.168.1.1','登陆成功0007','SU000002','1'),
	('LH000008','2020-04-21 06:43:47','192.168.1.2','登陆成功0008','SU000002','1'),
	('LH000009','2020-04-16 03:22:36','192.168.1.1','登陆成功0009','SU000003','1'),
	('LH000010','2020-04-23 21:54:45','192.168.1.2','登陆成功0010','SU000003','1'),
	('LH000011','2020-04-08 08:34:32','192.168.1.1','登陆成功0011','SU000003','1'),
	('LH000012','2020-04-19 21:42:39','192.168.1.2','登陆成功0012','SU000003','1'),
	('LH000013','2020-04-04 03:59:09','192.168.1.1','登陆成功0013','SU000004','1'),
	('LH000014','2020-04-09 23:21:11','192.168.1.2','登陆成功0014','SU000004','1'),
	('LH000015','2020-04-24 12:46:38','192.168.1.1','登陆成功0015','SU000004','1'),
	('LH000016','2020-04-22 04:49:59','192.168.1.2','登陆成功0016','SU000004','1');

insert into candidate_container_data values
	('CC000001','我只是一个容器','1');

insert into candidate_element_data values
	('CE000001','搜索到的匹配字段','类型描述','https://demo.doublechaintech.com/demodata/imageManager/genImage/10001/400/200/grey/','CC000001','1'),
	('CE000002','搜索到的匹配字段0002','类型描述0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/10002/400/200/grey/','CC000001','1'),
	('CE000003','搜索到的匹配字段0003','类型描述0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/10003/400/200/grey/','CC000001','1'),
	('CE000004','搜索到的匹配字段0004','类型描述0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/10004/400/200/grey/','CC000001','1');

insert into wechat_workapp_identify_data values
	('WWI000001','corporation123','user123','SU000001','2020-04-12 18:38:02','2020-04-05 06:50:17','1'),
	('WWI000002','corporation1230002','user1230002','SU000001','2020-04-19 10:10:50','2020-04-14 01:03:33','1'),
	('WWI000003','corporation1230003','user1230003','SU000001','2020-04-10 02:38:41','2020-04-03 22:39:04','1'),
	('WWI000004','corporation1230004','user1230004','SU000001','2020-04-18 18:35:10','2020-04-21 10:13:21','1'),
	('WWI000005','corporation1230005','user1230005','SU000002','2020-04-04 07:50:18','2020-04-19 16:56:49','1'),
	('WWI000006','corporation1230006','user1230006','SU000002','2020-04-23 08:58:20','2020-04-23 22:35:18','1'),
	('WWI000007','corporation1230007','user1230007','SU000002','2020-04-06 21:24:03','2020-04-09 13:22:05','1'),
	('WWI000008','corporation1230008','user1230008','SU000002','2020-04-22 23:30:54','2020-04-16 01:53:17','1'),
	('WWI000009','corporation1230009','user1230009','SU000003','2020-04-19 15:10:57','2020-04-22 19:08:48','1'),
	('WWI000010','corporation1230010','user1230010','SU000003','2020-04-20 02:59:18','2020-04-16 07:14:51','1'),
	('WWI000011','corporation1230011','user1230011','SU000003','2020-04-05 18:59:44','2020-04-20 16:57:48','1'),
	('WWI000012','corporation1230012','user1230012','SU000003','2020-04-14 11:25:18','2020-04-24 10:28:42','1'),
	('WWI000013','corporation1230013','user1230013','SU000004','2020-04-24 12:05:43','2020-04-25 14:04:11','1'),
	('WWI000014','corporation1230014','user1230014','SU000004','2020-04-05 17:01:26','2020-04-14 03:15:06','1'),
	('WWI000015','corporation1230015','user1230015','SU000004','2020-04-08 04:53:10','2020-04-25 03:04:45','1'),
	('WWI000016','corporation1230016','user1230016','SU000004','2020-04-16 13:56:15','2020-04-19 03:46:34','1');

insert into wechat_miniapp_identify_data values
	('WMI000001','wechat_open_id_1234567890','wechat_miniapp_id_1234567890','SU000001','2020-04-21 19:32:57','2020-04-21 07:30:30','1'),
	('WMI000002','wechat_open_id_12345678900002','wechat_miniapp_id_12345678900002','SU000001','2020-04-05 15:46:10','2020-04-10 20:42:04','1'),
	('WMI000003','wechat_open_id_12345678900003','wechat_miniapp_id_12345678900003','SU000001','2020-04-05 05:47:27','2020-04-05 16:29:39','1'),
	('WMI000004','wechat_open_id_12345678900004','wechat_miniapp_id_12345678900004','SU000001','2020-04-09 20:39:25','2020-04-15 02:43:02','1'),
	('WMI000005','wechat_open_id_12345678900005','wechat_miniapp_id_12345678900005','SU000002','2020-04-18 09:25:53','2020-04-05 06:39:23','1'),
	('WMI000006','wechat_open_id_12345678900006','wechat_miniapp_id_12345678900006','SU000002','2020-04-25 07:38:59','2020-04-20 06:04:52','1'),
	('WMI000007','wechat_open_id_12345678900007','wechat_miniapp_id_12345678900007','SU000002','2020-04-18 16:41:39','2020-04-11 03:14:46','1'),
	('WMI000008','wechat_open_id_12345678900008','wechat_miniapp_id_12345678900008','SU000002','2020-04-23 04:15:21','2020-04-12 20:16:48','1'),
	('WMI000009','wechat_open_id_12345678900009','wechat_miniapp_id_12345678900009','SU000003','2020-04-23 01:01:28','2020-04-20 01:08:02','1'),
	('WMI000010','wechat_open_id_12345678900010','wechat_miniapp_id_12345678900010','SU000003','2020-04-17 03:28:24','2020-04-09 17:52:21','1'),
	('WMI000011','wechat_open_id_12345678900011','wechat_miniapp_id_12345678900011','SU000003','2020-04-21 22:04:08','2020-04-12 09:36:10','1'),
	('WMI000012','wechat_open_id_12345678900012','wechat_miniapp_id_12345678900012','SU000003','2020-04-25 11:08:40','2020-04-07 19:46:15','1'),
	('WMI000013','wechat_open_id_12345678900013','wechat_miniapp_id_12345678900013','SU000004','2020-04-04 14:27:16','2020-04-10 12:58:27','1'),
	('WMI000014','wechat_open_id_12345678900014','wechat_miniapp_id_12345678900014','SU000004','2020-04-14 04:35:27','2020-04-17 15:53:52','1'),
	('WMI000015','wechat_open_id_12345678900015','wechat_miniapp_id_12345678900015','SU000004','2020-04-22 16:27:49','2020-04-10 13:21:38','1'),
	('WMI000016','wechat_open_id_12345678900016','wechat_miniapp_id_12345678900016','SU000004','2020-04-11 03:39:28','2020-04-18 09:14:27','1');

insert into keypair_identify_data values
	('KI000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000001','SU000001','2020-04-07 05:33:30','1'),
	('KI000002','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000001','SU000001','2020-04-23 13:33:01','1'),
	('KI000003','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000001','SU000001','2020-04-15 05:04:00','1'),
	('KI000004','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000001','SU000001','2020-04-15 18:02:06','1'),
	('KI000005','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000002','SU000002','2020-04-04 05:48:45','1'),
	('KI000006','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000002','SU000002','2020-04-13 23:56:36','1'),
	('KI000007','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000002','SU000002','2020-04-20 15:11:10','1'),
	('KI000008','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000002','SU000002','2020-04-24 23:21:07','1'),
	('KI000009','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000003','SU000003','2020-04-12 09:13:22','1'),
	('KI000010','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000003','SU000003','2020-04-21 16:01:11','1'),
	('KI000011','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000003','SU000003','2020-04-22 10:58:08','1'),
	('KI000012','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000003','SU000003','2020-04-25 14:07:24','1'),
	('KI000013','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000004','SU000004','2020-04-17 13:25:03','1'),
	('KI000014','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000004','SU000004','2020-04-11 11:59:12','1'),
	('KI000015','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000004','SU000004','2020-04-17 19:50:54','1'),
	('KI000016','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','PKT000004','SU000004','2020-04-25 09:49:50','1');

insert into public_key_type_data values
	('PKT000001','rsa','rsa','UD000001','1'),
	('PKT000002','ecc','ecc','UD000001','1'),
	('PKT000003','rsa','rsa','UD000001','1'),
	('PKT000004','ecc','ecc','UD000001','1');

insert into tree_node_data values
	('TN000001','node000001','nodetype','1','10','1');





alter table hospital_data add constraint pk4id_of_hospital_data primary key (id);

alter table expense_type_data add constraint pk4id_of_expense_type_data primary key (id);
alter table expense_type_data add constraint 
	fk4hospital_of_expense_type_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table period_data add constraint pk4id_of_period_data primary key (id);
alter table period_data add constraint 
	fk4hospital_of_period_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table expense_item_data add constraint pk4id_of_expense_item_data primary key (id);
alter table expense_item_data add constraint 
	fk4expense_type_of_expense_item_data foreign key (expense_type) references expense_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table expense_item_data add constraint 
	fk4hospital_of_expense_item_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table doctor_data add constraint pk4id_of_doctor_data primary key (id);
alter table doctor_data add constraint 
	fk4hospital_of_doctor_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table department_data add constraint pk4id_of_department_data primary key (id);
alter table department_data add constraint 
	fk4hospital_of_department_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table doctor_assignment_data add constraint pk4id_of_doctor_assignment_data primary key (id);
alter table doctor_assignment_data add constraint 
	fk4doctor_of_doctor_assignment_data foreign key (doctor) references doctor_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_assignment_data add constraint 
	fk4department_of_doctor_assignment_data foreign key (department) references department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table doctor_schedule_data add constraint pk4id_of_doctor_schedule_data primary key (id);
alter table doctor_schedule_data add constraint 
	fk4doctor_of_doctor_schedule_data foreign key (doctor) references doctor_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4period_of_doctor_schedule_data foreign key (period) references period_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4department_of_doctor_schedule_data foreign key (department) references department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4expense_type_of_doctor_schedule_data foreign key (expense_type) references expense_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4hospital_of_doctor_schedule_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table mobile_app_data add constraint pk4id_of_mobile_app_data primary key (id);

alter table page_data add constraint pk4id_of_page_data primary key (id);
alter table page_data add constraint 
	fk4page_type_of_page_data foreign key (page_type) references page_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table page_data add constraint 
	fk4mobile_app_of_page_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table page_type_data add constraint pk4id_of_page_type_data primary key (id);
alter table page_type_data add constraint 
	fk4mobile_app_of_page_type_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table slide_data add constraint pk4id_of_slide_data primary key (id);
alter table slide_data add constraint 
	fk4page_of_slide_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table ui_action_data add constraint pk4id_of_ui_action_data primary key (id);
alter table ui_action_data add constraint 
	fk4page_of_ui_action_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table section_data add constraint pk4id_of_section_data primary key (id);
alter table section_data add constraint 
	fk4page_of_section_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_domain_data add constraint pk4id_of_user_domain_data primary key (id);

alter table user_white_list_data add constraint pk4id_of_user_white_list_data primary key (id);
alter table user_white_list_data add constraint 
	fk4domain_of_user_white_list_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_data add constraint pk4id_of_sec_user_data primary key (id);
alter table sec_user_data add constraint 
	fk4domain_of_sec_user_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_app_data add constraint pk4id_of_user_app_data primary key (id);
alter table user_app_data add constraint 
	fk4sec_user_of_user_app_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table quick_link_data add constraint pk4id_of_quick_link_data primary key (id);
alter table quick_link_data add constraint 
	fk4app_of_quick_link_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table list_access_data add constraint pk4id_of_list_access_data primary key (id);
alter table list_access_data add constraint 
	fk4app_of_list_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table login_history_data add constraint pk4id_of_login_history_data primary key (id);
alter table login_history_data add constraint 
	fk4sec_user_of_login_history_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table candidate_container_data add constraint pk4id_of_candidate_container_data primary key (id);

alter table candidate_element_data add constraint pk4id_of_candidate_element_data primary key (id);
alter table candidate_element_data add constraint 
	fk4container_of_candidate_element_data foreign key (container) references candidate_container_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_workapp_identify_data add constraint pk4id_of_wechat_workapp_identify_data primary key (id);
alter table wechat_workapp_identify_data add constraint 
	fk4sec_user_of_wechat_workapp_identify_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_miniapp_identify_data add constraint pk4id_of_wechat_miniapp_identify_data primary key (id);
alter table wechat_miniapp_identify_data add constraint 
	fk4sec_user_of_wechat_miniapp_identify_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table keypair_identify_data add constraint pk4id_of_keypair_identify_data primary key (id);
alter table keypair_identify_data add constraint 
	fk4key_type_of_keypair_identify_data foreign key (key_type) references public_key_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table keypair_identify_data add constraint 
	fk4sec_user_of_keypair_identify_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table public_key_type_data add constraint pk4id_of_public_key_type_data primary key (id);
alter table public_key_type_data add constraint 
	fk4domain_of_public_key_type_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table tree_node_data add constraint pk4id_of_tree_node_data primary key (id);
-- create extra index for time, number and mobile phone
create unique index idx4id_ver_of_hospital on hospital_data (id, version);

create unique index idx4id_ver_of_expense_type on expense_type_data (id, version);
create  index idx4update_time_of_expense_type on expense_type_data (update_time);

create unique index idx4id_ver_of_period on period_data (id, version);
create unique index idx4code_of_period on period_data (code);

create unique index idx4id_ver_of_expense_item on expense_item_data (id, version);
create  index idx4price_of_expense_item on expense_item_data (price);
create  index idx4update_time_of_expense_item on expense_item_data (update_time);

create unique index idx4id_ver_of_doctor on doctor_data (id, version);
create  index idx4update_time_of_doctor on doctor_data (update_time);

create unique index idx4id_ver_of_department on department_data (id, version);
create  index idx4update_time_of_department on department_data (update_time);

create unique index idx4id_ver_of_doctor_assignment on doctor_assignment_data (id, version);
create  index idx4update_time_of_doctor_assignment on doctor_assignment_data (update_time);

create unique index idx4id_ver_of_doctor_schedule on doctor_schedule_data (id, version);
create  index idx4schedule_date_of_doctor_schedule on doctor_schedule_data (schedule_date);
create  index idx4available_of_doctor_schedule on doctor_schedule_data (available);
create  index idx4price_of_doctor_schedule on doctor_schedule_data (price);
create  index idx4create_time_of_doctor_schedule on doctor_schedule_data (create_time);
create  index idx4update_time_of_doctor_schedule on doctor_schedule_data (update_time);

create unique index idx4id_ver_of_mobile_app on mobile_app_data (id, version);

create unique index idx4id_ver_of_page on page_data (id, version);

create unique index idx4id_ver_of_page_type on page_type_data (id, version);
create unique index idx4code_of_page_type on page_type_data (code);

create unique index idx4id_ver_of_slide on slide_data (id, version);
create  index idx4display_order_of_slide on slide_data (display_order);

create unique index idx4id_ver_of_ui_action on ui_action_data (id, version);

create unique index idx4id_ver_of_section on section_data (id, version);

create unique index idx4id_ver_of_user_domain on user_domain_data (id, version);

create unique index idx4id_ver_of_user_white_list on user_white_list_data (id, version);

create unique index idx4id_ver_of_sec_user on sec_user_data (id, version);
create unique index idx4login_of_sec_user on sec_user_data (login);
create unique index idx4email_of_sec_user on sec_user_data (email);
create unique index idx4mobile_of_sec_user on sec_user_data (mobile);
create  index idx4verification_code_of_sec_user on sec_user_data (verification_code);
create  index idx4verification_code_expire_of_sec_user on sec_user_data (verification_code_expire);
create  index idx4last_login_time_of_sec_user on sec_user_data (last_login_time);

create unique index idx4id_ver_of_user_app on user_app_data (id, version);
create  index idx4object_id_of_user_app on user_app_data (object_id);

create unique index idx4id_ver_of_quick_link on quick_link_data (id, version);
create  index idx4create_time_of_quick_link on quick_link_data (create_time);

create unique index idx4id_ver_of_list_access on list_access_data (id, version);

create unique index idx4id_ver_of_login_history on login_history_data (id, version);
create  index idx4login_time_of_login_history on login_history_data (login_time);

create unique index idx4id_ver_of_candidate_container on candidate_container_data (id, version);

create unique index idx4id_ver_of_candidate_element on candidate_element_data (id, version);

create unique index idx4id_ver_of_wechat_workapp_identify on wechat_workapp_identify_data (id, version);
create  index idx4corp_id_of_wechat_workapp_identify on wechat_workapp_identify_data (corp_id);
create  index idx4user_id_of_wechat_workapp_identify on wechat_workapp_identify_data (user_id);
create  index idx4create_time_of_wechat_workapp_identify on wechat_workapp_identify_data (create_time);
create  index idx4last_login_time_of_wechat_workapp_identify on wechat_workapp_identify_data (last_login_time);

create unique index idx4id_ver_of_wechat_miniapp_identify on wechat_miniapp_identify_data (id, version);
create  index idx4open_id_of_wechat_miniapp_identify on wechat_miniapp_identify_data (open_id);
create  index idx4app_id_of_wechat_miniapp_identify on wechat_miniapp_identify_data (app_id);
create  index idx4create_time_of_wechat_miniapp_identify on wechat_miniapp_identify_data (create_time);
create  index idx4last_login_time_of_wechat_miniapp_identify on wechat_miniapp_identify_data (last_login_time);

create unique index idx4id_ver_of_keypair_identify on keypair_identify_data (id, version);
create  index idx4create_time_of_keypair_identify on keypair_identify_data (create_time);

create unique index idx4id_ver_of_public_key_type on public_key_type_data (id, version);

create unique index idx4id_ver_of_tree_node on tree_node_data (id, version);
create  index idx4node_id_of_tree_node on tree_node_data (node_id);
create  index idx4left_value_of_tree_node on tree_node_data (left_value);
create  index idx4right_value_of_tree_node on tree_node_data (right_value);






delete from list_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
delete from wechat_miniapp_identify_data;
delete from wechat_workapp_identify_data;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000001','上和医院','SU000001','university',1,'MXWR','Hospital','H000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000003','用户管理','SU000001','users',1,'MXWR','UserDomain','UD000001','/link/to/app','1');

/* ------------------------------ generate users for all target od marked as user4all ------------------------------------------ */


-- no change request type found

select mobile as `可用于登录的账号`, 'admin123' as `密码` from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|


*/



/* start with data patch */
/* The sql file is not found from: /home/philip/resin-3.1.12/webapps/sky/data-patch/his.sql */











